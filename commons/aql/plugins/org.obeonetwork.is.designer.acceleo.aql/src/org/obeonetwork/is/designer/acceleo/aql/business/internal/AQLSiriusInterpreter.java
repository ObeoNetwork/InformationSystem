/*******************************************************************************
 * Copyright (c) 2015, 2017 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.designer.acceleo.aql.business.internal;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.eclipse.acceleo.query.parser.AstResult;
import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.acceleo.query.runtime.AcceleoQueryValidationException;
import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.IQueryValidationEngine;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.QueryEvaluation;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.acceleo.query.runtime.QueryValidation;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.ICollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.is.designer.acceleo.aql.business.AQLSiriusPlugin;
import org.obeonetwork.is.designer.acceleo.aql.business.Messages;
import org.obeonetwork.is.designer.acceleo.aql.business.api.AQLConstants;
import org.obeonetwork.is.designer.acceleo.aql.business.api.ExpressionTrimmer;
import org.obeonetwork.is.designer.acceleo.aql.business.api.TypesUtil;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EPackageLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterContext;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterStatus;
import org.eclipse.sirius.common.tools.api.interpreter.IJavaAwareInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.InterpreterStatusFactory;
import org.eclipse.sirius.common.tools.api.interpreter.ValidationResult;
import org.eclipse.sirius.common.tools.api.interpreter.VariableType;
import org.eclipse.sirius.ecore.extender.business.api.accessor.EcoreMetamodelDescriptor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.MetamodelDescriptor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * A Sirius interpreter using the Acceleo Query Language. It only supports expressions which are not using implicit
 * variables.
 *
 * @author cedric
 */
public class AQLSiriusInterpreter extends AcceleoAbstractInterpreter implements IJavaAwareInterpreter {

    private LoadingCache<String, AstResult> parsedExpressions;

    private IQueryEnvironment queryEnvironment;

    private ECrossReferenceAdapter siriusXref;

    private CrossReferenceProvider xRef = new CrossReferenceProvider() {

        @Override
        public Collection<Setting> getInverseReferences(EObject self) {
            if (siriusXref != null) {
                return siriusXref.getInverseReferences(self);

            } else {
                return Collections.emptySet();
            }
        }
    };

    private final ClassLoadingCallback callback = new ClassLoadingCallback() {

        @Override
        public void loaded(String qualifiedName, Class<?> clazz) {
            ServiceUtils.registerServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
        }

        @Override
        public void notFound(String qualifiedName) {
            AQLSiriusPlugin.INSTANCE.log(new Status(IStatus.WARNING, AQLSiriusPlugin.INSTANCE.getSymbolicName(), MessageFormat.format(Messages.AQLInterpreter_javaClassNotFound, qualifiedName)));
        }

        @Override
        public void unloaded(String qualifiedName, Class<?> clazz) {
            ServiceUtils.removeServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
        }
    };

    private final EPackageLoadingCallback ePackageCallBack;

    /**
     * Create a new interpreter supporting the AQL evaluation engine.
     */
    public AQLSiriusInterpreter() {
        super();
        this.queryEnvironment = Query.newEnvironmentWithDefaultServices(xRef);
        this.ePackageCallBack = new EPackageLoadingCallback() {

            @Override
            public void loaded(String nsURI, EPackage pak) {
                queryEnvironment.registerEPackage(pak);
            }

            @Override
            public void unloaded(String nsURI, EPackage pak) {
                queryEnvironment.removeEPackage(pak);
            }
        };
        this.javaExtensions.addClassLoadingCallBack(callback);
        this.javaExtensions.addEPackageCallBack(ePackageCallBack);
        this.queryEnvironment.registerEPackage(EcorePackage.eINSTANCE);
        this.queryEnvironment.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class);
        initExpressionsCache();
    }

    private void initExpressionsCache() {
        final IQueryBuilderEngine builder = QueryParsing.newBuilder(queryEnvironment);
        this.parsedExpressions = CacheBuilder.newBuilder().maximumSize(500).build(new CacheLoader<String, AstResult>() {

            @Override
            public AstResult load(String key) throws Exception {
                return builder.build(key);
            }

        });
    }

    @Override
    public void activateMetamodels(Collection<MetamodelDescriptor> metamodels) {
        Set<EPackage> additionalEPackages = new LinkedHashSet<>();
        for (MetamodelDescriptor descriptor : metamodels) {
            if (descriptor instanceof EcoreMetamodelDescriptor) {
                EPackage pkg = ((EcoreMetamodelDescriptor) descriptor).resolve();
                if (pkg != null) {
                    additionalEPackages.add(pkg);
                }
            }
        }
        for (EPackage ePackage : additionalEPackages) {
            this.queryEnvironment.registerEPackage(ePackage);
        }
        if (additionalEPackages.size() > 0) {
            this.initExpressionsCache();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        this.javaExtensions.removeClassLoadingCallBack(callback);
        this.javaExtensions.removeEPackageCallBack(ePackageCallBack);
    }

    @Override
    public Object evaluate(EObject target, String fullExpression) throws EvaluationException {
        IEvaluationResult evaluationResult = this.evaluateExpression(target, fullExpression);
        // We fire the exception to keep the old behavior
        Diagnostic diagnostic = evaluationResult.getDiagnostic();
        if (diagnostic.getSeverity() == Diagnostic.ERROR) {
            String uri = EcoreUtil.getURI(target).toString();
            String message = MessageFormat.format(Messages.AQLInterpreter_errorWithExpression, fullExpression, diagnostic.toString(), uri, target);
            throw new EvaluationException(message, diagnostic.getException());
        }
        return evaluationResult.getValue();
    }

    @Override
    public IEvaluationResult evaluateExpression(final EObject target, final String fullExpression) throws EvaluationException {
        this.javaExtensions.reloadIfNeeded();
        String expression = new ExpressionTrimmer(fullExpression).getExpression();
        Map<String, Object> variables = getVariables();
        variables.put("self", target); //$NON-NLS-1$

        try {
            AstResult build = parsedExpressions.get(expression);
            IQueryEvaluationEngine evaluationEngine = QueryEvaluation.newEngine(queryEnvironment);
            EvaluationResult evalResult = evaluationEngine.eval(build, variables);

            final BasicDiagnostic diagnostic = new BasicDiagnostic();
            if (Diagnostic.OK != build.getDiagnostic().getSeverity()) {
                diagnostic.merge(build.getDiagnostic());
            }
            if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
                diagnostic.merge(evalResult.getDiagnostic());
            }

            Diagnostic diag = minimize(diagnostic);
            if (diag.getSeverity() >= Diagnostic.ERROR) {
                return org.eclipse.sirius.common.tools.api.interpreter.EvaluationResult.ofError(diag);
            } else {
                return org.eclipse.sirius.common.tools.api.interpreter.EvaluationResult.ofValue(evalResult.getResult(), getConverter(), diag);
            }
        } catch (ExecutionException e) {
            throw new EvaluationException(e.getCause());
        }
    }
    
    private Diagnostic minimize(Diagnostic diag) {
        List<Diagnostic> children = diag.getChildren();
        if (children.size() == 1) {
            return children.get(0);
        } else {
            return diag;
        }
    }

    @Override
    public String getVariablePrefix() {
        /*
         * no variable prefix for this interpreter.
         */
        return null;
    }

    @Override
    public void setCrossReferencer(ECrossReferenceAdapter crossReferencer) {
        this.siriusXref = crossReferencer;
    }

    @Override
    public void setModelAccessor(ModelAccessor modelAccessor) {
        /*
         * AQL does not support the ModelAccessor yet.
         */
    }

    @Override
    public boolean supportsValidation() {
        return true;
    }

    @Override
    public ValidationResult analyzeExpression(IInterpreterContext context, String fullExpression) {
        this.javaExtensions.reloadIfNeeded();

        String trimmedExpression = new ExpressionTrimmer(fullExpression).getExpression();

        Map<String, Set<IType>> variableTypes = TypesUtil.createAQLVariableTypesFromInterpreterContext(context, queryEnvironment);
        ValidationResult result = new ValidationResult();
        IQueryValidationEngine validator = QueryValidation.newEngine(this.queryEnvironment);
        try {
            final IValidationResult aqlValidationResult = validator.validate(trimmedExpression, variableTypes);
            result = new ValidationResult() {

                @Override
                public Map<String, VariableType> getInferredVariableTypes(Boolean value) {
                    Map<String, VariableType> mapResult = new LinkedHashMap<>();
                    Map<String, Set<IType>> types = aqlValidationResult.getInferredVariableTypes(aqlValidationResult.getAstResult().getAst(), value);
                    Iterator<Map.Entry<String, Set<IType>>> it = types.entrySet().iterator();
                    while (it.hasNext()) {
                        Set<EClassifier> eClassifiers = new LinkedHashSet<>();
                        Map.Entry<String, Set<IType>> entry = it.next();
                        for (IType type : entry.getValue()) {
                            if (type.getType() instanceof EClassifier) {
                                eClassifiers.add((EClassifier) type.getType());
                            }
                        }
                        if (eClassifiers.size() > 0) {
                            mapResult.put(entry.getKey(), VariableType.fromEClassifiers(eClassifiers));
                        }

                    }
                    return mapResult;
                }
            };
            for (IValidationMessage message : aqlValidationResult.getMessages()) {
                String severity = IInterpreterStatus.WARNING;
                if (message.getLevel() == ValidationMessageLevel.ERROR) {
                    severity = IInterpreterStatus.ERROR;
                } else if (message.getLevel() == ValidationMessageLevel.INFO) {
                    severity = IInterpreterStatus.INFO;
                }
                result.addStatus(InterpreterStatusFactory.createInterpreterStatus(context, severity, message.getMessage()));
            }
            List<EClassifier> classifierNames = new ArrayList<>();
            List<Class<?>> javaClasses = new ArrayList<>();
            for (IType type : aqlValidationResult.getPossibleTypes(aqlValidationResult.getAstResult().getAst())) {
                IType actualType = type;
                /*
                 * Sirius has no notion of "multiple" or "collection" type in its typesystem and will unwrap the
                 * collection when using its result as the root of a new expression. It seems better to return the type
                 * information than hide which leads to a fall-back to EObject.
                 */
                if (type instanceof ICollectionType) {
                    actualType = ((ICollectionType) type).getCollectionType();
                }
                if (actualType instanceof EClassifierType) {
                    EClassifierType eClassifierType = (EClassifierType) actualType;
                    if (eClassifierType.getType() != null) {
                        classifierNames.add(eClassifierType.getType());
                    }
                } else if (actualType instanceof ClassType && actualType.getClass() != null) {
                    Class<?> clazz = ((ClassType) actualType).getType();
                    Set<EClassifier> eClassifiersFromJavaClassName = queryEnvironment.getEPackageProvider().getEClassifiers(clazz);
                    if (eClassifiersFromJavaClassName != null && eClassifiersFromJavaClassName.size() > 0) {
                        classifierNames.addAll(eClassifiersFromJavaClassName);
                    } else {
                        javaClasses.add(clazz);
                    }
                }
            }
            result.setReturnType(VariableType.fromEClassifiersAndClasses(classifierNames, javaClasses));

        } catch (

        AcceleoQueryValidationException e) {
            result.addStatus(InterpreterStatusFactory.createInterpreterStatus(context, IInterpreterStatus.ERROR, e.getMessage()));
            AQLSiriusPlugin.INSTANCE.log(new Status(IStatus.ERROR, AQLSiriusPlugin.INSTANCE.getSymbolicName(), e.getMessage(), e));
        } catch (

        AcceleoQueryEvaluationException e) {
            result.addStatus(InterpreterStatusFactory.createInterpreterStatus(context, IInterpreterStatus.ERROR, e.getMessage()));
        }

        return result;
    }

    @Override
    public Collection<Method> getImplementation(String serviceCall) {
        javaExtensions.reloadIfNeeded();
        Set<IService<?>> registeredServices = queryEnvironment.getLookupEngine().getRegisteredServices();
        List<Method> results = new ArrayList<Method>();
        registeredServices.iterator().forEachRemaining(s -> {
            if (s instanceof JavaMethodService) {
                results.add(((JavaMethodService) s).getOrigin());
            }
        });

        return results;
    }

    /**
     * return the cross reference provider used by this interpreter instance.
     * 
     * @return the cross reference provider used by this interpreter instance.
     */
    public CrossReferenceProvider getCrossReferenceProvider() {
        return xRef;
    }

    @Override
    public String getPrefix() {
        return AQLConstants.AQL_PREFIX;
    }

    @Override
    public boolean provides(String expression) {
        return expression != null && expression.startsWith(AQLConstants.AQL_PREFIX);
    }

    /**
     * The query environment currently used by this interpreter.
     * 
     * @return The query environment currently used by this interpreter.
     */
    public IQueryEnvironment getQueryEnvironment() {
        /*
         * The JavaExtensionManager might impact the query environment when loading classes. We trigger the reload
         * before returning the IQueryEnvironment so that it is properly configured with EPackages and imports.
         */
        this.javaExtensions.reloadIfNeeded();

        return this.queryEnvironment;
    }
}
