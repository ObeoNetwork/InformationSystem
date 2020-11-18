/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.actions;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.TreeItemWrapper;
import org.eclipse.sirius.common.ui.tools.api.selection.EObjectPaneBasedSelectionWizard;
import org.eclipse.sirius.common.ui.tools.api.selection.page.EObjectPaneBasedSelectionWizardPage;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class PaneBasedReferenceEditionWizardAction implements IExternalJavaAction {
	
	// Input variables
    private static final String PARAMETER_WINDOW_TITLE = "windowTitle";
    private static final String PARAMETER_ICON_PATH = "iconPath";
    private static final String PARAMETER_MESSAGE = "message";
    private static final String PARAMETER_CANDIDATES = "candidates";
    private static final String PARAMETER_REFERENCE_NAME = "referenceName";
    private static final String PARAMETER_CHOICE_OF_VALUES_MESSAGE = "choiceOfValuesMessage";
    private static final String PARAMETER_SELECTED_VALUES_MESSAGE = "selectedValuesMessage";
	
    // Output variables
    private static final String OUTPUT_RETURN_CODE = "returnCode";
    private static final String OUTPUT_SELECTED_ELEMENTS = "selectedElements";

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		
		EObject context = selections.iterator().next();
        
    	String windowTitle = Optional.ofNullable((String) parameters.get(PARAMETER_WINDOW_TITLE)).orElse("");
        
        ImageDescriptor image = Optional.ofNullable((String) parameters.get(PARAMETER_ICON_PATH))
        		.map(path -> DiagramUIPlugin.Implementation.findImageDescriptor(path)).orElse(null);
        
        String message = Optional.ofNullable((String) parameters.get(PARAMETER_MESSAGE)).orElse("");
        
		List<EObject> allCandidates = ((EList<?>)parameters.get(PARAMETER_CANDIDATES)).stream().filter(EObject.class::isInstance).map(EObject.class::cast).collect(toList());
        
        String referenceName = Optional.ofNullable((String) parameters.get(PARAMETER_REFERENCE_NAME)).orElse("");
        
        String choiceOfValuesMessageLocalized = Optional.ofNullable((String) parameters.get(PARAMETER_CHOICE_OF_VALUES_MESSAGE)).orElse("");
        
        String selectedValuesMessageLocalized = Optional.ofNullable((String) parameters.get(PARAMETER_SELECTED_VALUES_MESSAGE)).orElse("");
        
        
        Collection<EObject> preSelection = computePreSelection(context, referenceName);
        
        final EObjectPaneBasedSelectionWizard wizard = new EObjectPaneBasedSelectionWizard(
        		windowTitle, 
        		message, 
        		image, 
        		choiceOfValuesMessageLocalized,
                selectedValuesMessageLocalized, 
                DiagramUIPlugin.getPlugin().getItemProvidersAdapterFactory());
        
        
        wizard.init(allCandidates, preSelection);
        
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        final WizardDialog dlg = new WizardDialog(shell, wizard);
        dlg.setMinimumPageSize(200, 360);
        
        // Working around bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=526223
        dlg.addPageChangedListener(new IPageChangedListener() {
			
			@Override
			public void pageChanged(PageChangedEvent event) {
				EObjectPaneBasedSelectionWizardPage page = (EObjectPaneBasedSelectionWizardPage) event.getSelectedPage();
		        TreeViewer treeViewer = getFieldValue(page, "treeViewer", TreeViewer.class);
				treeViewer.addFilter(new ViewerFilter() {
					
					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if(element instanceof TreeItemWrapper && ((TreeItemWrapper) element).getWrappedObject() instanceof EObject) {
							EObject eObject = (EObject) ((TreeItemWrapper) element).getWrappedObject();
							return !page.getSelectedEObjects().contains(eObject);
						}
						return true;
					}
				});
				
				Button addButton = getFieldValue(page, "addButton", Button.class);
				addButton.addSelectionListener(new SelectionAdapter() {
	                @Override
	                public void widgetSelected(final SelectionEvent event) {
                        treeViewer.refresh();
	                }
	            });
				
				Button removeButton = getFieldValue(page, "removeButton", Button.class);
				removeButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent event) {
						Text elementsToSelectText = getFieldValue(page, "elementsToSelectText", Text.class);
						elementsToSelectText.setText(""); //$NON-NLS-1$
						invokeMethod(page, "initRootPrefix");
					}
				});
			}
		});
        
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(context);
		
        final int result = dlg.open();
        if (result == Window.OK) {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "OK");
    		interpreter.setVariable(OUTPUT_SELECTED_ELEMENTS, wizard.getSelectedEObjects());
        } else {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "CANCEL");
        }
	}
	
	private Collection<EObject> computePreSelection(EObject context, String referenceName) {
		
        Collection<EObject> preSelection = Collections.emptyList();
    	
		EStructuralFeature feature = context.eClass().getEStructuralFeature(referenceName);
		Object value = context.eGet(feature);
		
		if(value instanceof EList) {
			preSelection = ((EList<?>)value).stream().map(EObject.class::cast).collect(toList());
		}
        
    	return preSelection;
    }

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

	private <T> T getFieldValue(Object object, String fieldName, Class<T> clazz) {
		T fieldValue = null;
		Field field = getField(object.getClass(), fieldName);
		field.setAccessible(true);
		try {
			Object value = field.get(object);
			if (clazz.isAssignableFrom(value.getClass())) {
				fieldValue = clazz.cast(value);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// Silent catch
		} finally {
			field.setAccessible(false);
		}
		return fieldValue;
	}

	private Field getField(Class<? extends Object> clazz, String fieldName) {
		Field field = getDeclaredFieldSafe(clazz,fieldName);
		while(field == null && clazz != null) {
			clazz = clazz.getSuperclass();
			field = getDeclaredFieldSafe(clazz, fieldName);
		}
		return field;
	}

	private Field getDeclaredFieldSafe(Class<? extends Object> clazz, String fieldName) {
		Field field = null;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			// Silent catch
		}
		return field;
	}

	private void invokeMethod(Object object, String methodName) {
		Method method = getMethod(object.getClass(), methodName);
		method.setAccessible(true);
		try {
			method.invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// Silent catch
		} finally {
			method.setAccessible(false);
		}
	}
	
	private Method getMethod(Class<? extends Object> clazz, String methodName) {
		Method method = getDeclaredMethodSafe(clazz, methodName);
		while(method == null && clazz != null) {
			clazz = clazz.getSuperclass();
			method = getDeclaredMethodSafe(clazz, methodName);
		}
		return method;
	}
	
	private Method getDeclaredMethodSafe(Class<? extends Object> clazz, String methodName) {
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException | SecurityException e) {
			// Silent catch
		}
		return method;
	}
	
}
