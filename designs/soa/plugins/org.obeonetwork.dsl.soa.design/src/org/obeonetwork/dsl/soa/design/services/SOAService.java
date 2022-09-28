/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design.services;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.*;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.MediaType;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.Scope;
import org.obeonetwork.dsl.soa.Securable;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.Wire;
import org.obeonetwork.dsl.soa.design.dialogs.NewSecuritySchemeDialog;
import org.obeonetwork.dsl.soa.services.HttpStatusService;
import org.obeonetwork.utils.common.EObjectUtils;

public class SOAService {


	private static final String COMMON_MEDIA_TYPES_EXTENSION_ID = "org.obeonetwork.dsl.soa.design.mediaTypes";
	private static final String COMMON_MEDIA_TYPES_NAME_ATTRIBUTE = "name";
	private static Collection<String> commonMediaTypes;
	private static final Pattern PATH_PARAM_PATTERN = Pattern.compile("\\{[^\\{\\}]*\\}");

	public EObject trace(EObject receiver) {
		java.lang.System.out.println("receiver.eClass() = \"" + receiver.eClass().getName() + "\"");
		java.lang.System.out.println("receiver.toString() = \"" + receiver.toString() + "\"");
		java.lang.System.out
				.println("receiver.name = \"" + Optional.ofNullable(receiver.eClass().getEStructuralFeature("name"))
						.map(f -> (String) receiver.eGet(f)).orElse(null) + "\"");

		return receiver;
	}

	public EObject traceVars(EObject o) {
		trace(o);
		Session session = new EObjectQuery(o).getSession();
		Map<String, ?> vars = session.getInterpreter().getVariables();
		java.lang.System.out.println(vars.keySet().size() + " variable(s)");
		for (String var : vars.keySet()) {
			java.lang.System.out.println(var + " = " + vars.get(var));
		}
		return o;
	}

	public Operation setExpositionKind(Operation operation, ExpositionKind expositionKind) {

		operation.setExposition(expositionKind);
		if (expositionKind == ExpositionKind.NONE) {
			operation.setURI(null);
			operation.setVerb(Verb.GET);
			// operation.setPaged(true);
		}
		
		if(expositionKind != ExpositionKind.NONE &&
				EObjectUtils.getContainer(operation, Service.class).getKind() == InterfaceKind.PROVIDED_LITERAL) {
			operation.setPublic(true);
		}

		return operation;
	}

	public Securable updateSecurityApplications(Securable securable, List<SecurityScheme> securitySchemes) {
		List<SecurityApplication> oldSecurityApplications = new ArrayList<>(securable.getSecurityApplications());
		securable.getSecurityApplications().removeAll(oldSecurityApplications);
		
		for(SecurityScheme securityScheme : securitySchemes) {
			SecurityApplication securityApplication = oldSecurityApplications.stream().filter(sa -> sa.getSecurityScheme() == securityScheme).findAny().orElse(null);
			if(securityApplication == null) {
				securityApplication = SoaFactory.eINSTANCE.createSecurityApplication();
				securityApplication.setSecurityScheme(securityScheme);
				securityApplication.getScopes().addAll(securityScheme.getFlows().stream().flatMap(f -> f.getScopes().stream()).collect(toList()));
			}
			securable.getSecurityApplications().add(securityApplication);
		}
		return securable;
	}
	
	public SecurityApplication updateScopes(SecurityApplication securityApplication, List<Scope> scopes) {
		List<Scope> oldScopes = new ArrayList<Scope>(securityApplication.getScopes());
		securityApplication.getScopes().removeAll(oldScopes);
		securityApplication.getScopes().addAll(scopes);
		return securityApplication;
	}
	
	public Parameter setStatusCode(Parameter parameter, String statusCode) {
		if (!Objects.equals(parameter.getStatusCode(), statusCode)) {
			if (isNullOrWhite(parameter.getStatusMessage()) || parameter.getStatusMessage().trim()
					.equals(HttpStatusService.getHttpMessage(parameter.getStatusCode()))) {
				parameter.setStatusMessage(HttpStatusService.getHttpMessage(statusCode));
			}
			parameter.setStatusCode(statusCode);
		}
		return parameter;
	}

	public List<Component> allNonReferencedExternalComponents(System context) {
		List<Component> allNonReferencedExternalComponents = allExternalComponents(context);
		// Remove all referenced external components
		allNonReferencedExternalComponents.removeAll(allReferencedExternalComponents(context));
		return allNonReferencedExternalComponents;
	}

	public List<Component> allExternalComponents(System context) {
		List<Component> allExternalComponents = allComponents(context);
		// Remove The component contained in the System.
		allExternalComponents.removeAll(context.getOwnedComponents());
		return allExternalComponents;
	}

	public List<Component> allReferencedExternalComponents(System context) {
		List<Component> allReferencedExternelComponents = allReferencedComponents(context);
		// Remove The component contained in the System.
		allReferencedExternelComponents.removeAll(context.getOwnedComponents());
		return allReferencedExternelComponents;
	}

	public List<Component> allReferencedComponents(System context) {
		List<Component> allReferencedComponents = new ArrayList<Component>();
		List<Wire> ownedWires = context.getOwnedWires();
		// Add Components parent of source and dest of westWire
		for (Wire wire : ownedWires) {
			Component componentSource = (Component) wire.getSource().eContainer();
			allReferencedComponents.add(componentSource);
			Component componentDest = (Component) wire.getDest().eContainer();
			allReferencedComponents.add(componentDest);
		}
		Set<Component> componentsSet = new HashSet<Component>();
		// Remove duplicates
		componentsSet.addAll(allReferencedComponents);
		return new ArrayList<Component>(componentsSet);
	}

	public List<Component> allComponents(System context) {
		EcoreService ecoreService = new EcoreService();
		// Retrieve allRoots
		Collection<EObject> allRoots = ecoreService.allRoots(context);
		List<Component> components = new ArrayList<Component>();
		// For all roots retrieve all elements of type Component
		for (EObject object : allRoots) {
			List<Component> allContainedEntities = new ArrayList<Component>();
			for (EObject obj : EcoreService.eAllContents(object, Component.class)) {
				allContainedEntities.add((Component) obj);
			}
			components.addAll(allContainedEntities);
		}
		return components;
	}

	/**
	 * Return all selectable externable components and their ancestors
	 * 
	 * @param semanticDiagram
	 * @return
	 */
	public List<EObject> allSelectableExternalComponentsAndAncestors(DSemanticDiagram semanticDiagram) {
		Set<EObject> result = new HashSet<EObject>();

		EObject rootObject = semanticDiagram.getTarget();
		if (rootObject instanceof System) {
			System system = (System) rootObject;

			// retrieve all selectable external components
			List<Component> components = allSelectableExternalComponents(system, semanticDiagram);
			for (Component component : components) {
				// retrieve ancestors of each component
				result.addAll(getAncestorsAndSelf(component));
			}
		}

		return new ArrayList<EObject>(result);
	}

	/**
	 * Returns the object and all its ancestors in a list
	 * 
	 * @param object
	 * @return
	 */
	private List<EObject> getAncestorsAndSelf(EObject object) {
		List<EObject> result = new ArrayList<EObject>();
		// Add current object
		result.add(object);

		EObject container = object.eContainer();
		if (container != null) {
			result.addAll(getAncestorsAndSelf(container));
		}

		return result;
	}

	public List<Component> allSelectableExternalComponents(System context, DSemanticDiagram semanticDiagram) {
		List<Component> allNonReferencedExternalComponents = allNonReferencedExternalComponents(context);
		List<Component> allComponentToRemove = new ArrayList<Component>();
		// For all semanticDiagram retrieve all contents elements of type
		// "DNodeContainer"
		for (EObject obj : EcoreService.eContents(semanticDiagram, DNodeContainer.class)) {
			// Retrieve and add the target of DNodeContainer type of Component
			if (((DNodeContainer) obj).getTarget() instanceof Component) {
				allComponentToRemove.add((Component) ((DNodeContainer) obj).getTarget());
			}
		}
		allNonReferencedExternalComponents.removeAll(allComponentToRemove);
		return allNonReferencedExternalComponents;
	}

	public boolean isRequiredService(Service context) {
		return context.getKind().equals(getRequiredLiteral(context));
	}

	public InterfaceKind getProvidedLiteral(EObject object) {
		return InterfaceKind.PROVIDED_LITERAL;
	}

	public InterfaceKind getRequiredLiteral(EObject object) {
		return InterfaceKind.REQUIRED_LITERAL;
	}

	private static class StatusLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			String statusCode = (String) element;
			return statusCode + " : " + HttpStatusService.getHttpMessage(statusCode); //$NON-NLS-1$
		}

	}

	public void openStatusCodeSelectionDialog(Parameter parameter) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ListDialog dialog = new ListDialog(shell);
		dialog.setTitle(Messages.SOAService_StatusSelectionDiaglogTitle);
		dialog.setMessage(Messages.SOAService_StatusSelectionDiaglogMessage + parameter.getName());
		dialog.setContentProvider(ArrayContentProvider.getInstance());
		dialog.setLabelProvider(new StatusLabelProvider());
		if (parameter.eContainingFeature() == SoaPackage.eINSTANCE.getOperation_Output()) {
			dialog.setInput(HttpStatusService.getStandardSuccessCodes());
		} else if (parameter.eContainingFeature() == SoaPackage.eINSTANCE.getOperation_Fault()) {
			dialog.setInput(HttpStatusService.getStandardErrorCodes());
		}
		if (dialog.open() == Dialog.OK && dialog.getResult().length == 1) {
			String selectedStatusCode = (String) dialog.getResult()[0];
			parameter.setStatusCode(selectedStatusCode);
			parameter.setStatusMessage(HttpStatusService.getHttpMessage(selectedStatusCode));
		}

	}

	public void openCommonMediaTypesSelectionDialog(MediaType mediaType) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ListDialog dialog = new ListDialog(shell);
		dialog.setTitle(Messages.SOAService_StatusSelectionDiaglogTitle);
		dialog.setMessage("Pick an identifier amongst the most common ones:");
		dialog.setContentProvider(ArrayContentProvider.getInstance());
		dialog.setInput(getCommonMediaTypes());
		dialog.setLabelProvider(new LabelProvider());
		if (dialog.open() == Dialog.OK && dialog.getResult().length == 1) {
			String selectedIdentifier = (String) dialog.getResult()[0];
			setNewMediaTypeIdentifier(mediaType, selectedIdentifier);
		}
	}
	
	public synchronized void setNewMediaTypeIdentifier(MediaType mediaType, String newValue) {		
		mediaType.setIdentifier(newValue);	
	}

	public static Collection<String> getCommonMediaTypes() {
		if (commonMediaTypes == null) {
			IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(COMMON_MEDIA_TYPES_EXTENSION_ID)
					.getExtensions();

			commonMediaTypes = Arrays.stream(extensions).map(IExtension::getConfigurationElements)
					.flatMap(Arrays::stream)
					.map(configurationElement -> configurationElement.getAttribute(COMMON_MEDIA_TYPES_NAME_ATTRIBUTE))
					.sorted()
					.collect(toList());
			
			if (!commonMediaTypes.contains("")) {
				commonMediaTypes.add("");
			}

		}

		return commonMediaTypes;
	}
	public List<String> getParamIdsFromURI(Operation operation) {
		List<String> paramIds = new ArrayList<>();
		if (operation.getURI() != null) {
			Matcher matcher = PATH_PARAM_PATTERN.matcher(operation.getURI());
			while (matcher.find()) {
				String match = matcher.group();
				paramIds.add(match.substring(1, match.length() - 1));
			}
		}

		return paramIds;
	}
	
	public void newSecurityScheme(SecurityScheme scheme) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		new NewSecuritySchemeDialog(shell, scheme).open();
	}
	
	public void editSecurityScheme(SecurityScheme scheme) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		new NewSecuritySchemeDialog(shell, scheme).edit();
	}
	
	public boolean isSecuritySchemeDialog(SecurityScheme scheme) {
		Display display = Display.getCurrent();
		Shell shell = display.getActiveShell();
		return shell != null && shell.getText().equals("Security scheme edition");
	}
	
	public void closeSecuritySchemeDialog(SecurityScheme scheme) {
		Display display = Display.getCurrent();
		Shell shell = display.getActiveShell();
		shell.close();
	}
	
	public void setSecuritySchemeType(SecurityScheme scheme, SecuritySchemeType type) {
		scheme.setType(type);
		Display display = Display.getCurrent();
		Shell shell = display.getActiveShell(); 
		shell.dispose();
	}

	public String getName(SecuritySchemeType schemeType) {
		return schemeType.getName();
	}
	
	public void setPaginationExtensionName(Operation operation, String name) {
		if (operation.getPaginationExtension() == null) {
			PropertiesExtension extension = SoaFactory.eINSTANCE.createPropertiesExtension();
			extension.setContext("Operation");			
			if (operation.getMetadatas() == null)
				operation.setMetadatas(EnvironmentFactory.eINSTANCE.createMetaDataContainer());

			operation.getMetadatas().getMetadatas().add(extension);
			operation.setPaginationExtension(extension);
		}

		if (name.startsWith("x-"))
			name = name.replaceFirst("x-", "");
		
		operation.getPaginationExtension().setTitle(name);
	}

	public void setPaginationExtensionValue(Operation operation, String value) {
		if (operation.getPaginationExtension() == null) {
			PropertiesExtension extension = SoaFactory.eINSTANCE.createPropertiesExtension();
			extension.setContext("Operation");			
			if (operation.getMetadatas() == null)
				operation.setMetadatas(EnvironmentFactory.eINSTANCE.createMetaDataContainer());

			operation.getMetadatas().getMetadatas().add(extension);
			operation.setPaginationExtension(extension);
		}

		operation.getPaginationExtension().setBody(value);
	}
	
	public boolean isValidPropertyExtension(Annotation theObject) {
		boolean isValidPropertyExtension = false;
		if (theObject instanceof PropertiesExtension) {		
			if (!isPaginationPropertyExtension(theObject)) {
				isValidPropertyExtension = true;	
			}
		}
		return isValidPropertyExtension;
	}
	
	public boolean isPaginationPropertyExtension(Annotation theObject) {
		return (theObject.eContainer() != null 
				&& theObject.eContainer().eContainer() != null 
				&& theObject.eContainer().eContainer() instanceof Operation 
				&& theObject.equals(((Operation) theObject.eContainer().eContainer()).getPaginationExtension()));
	}	
}
