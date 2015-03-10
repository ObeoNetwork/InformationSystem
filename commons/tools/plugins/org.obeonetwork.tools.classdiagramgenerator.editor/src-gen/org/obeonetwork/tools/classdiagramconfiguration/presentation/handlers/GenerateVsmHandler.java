package org.obeonetwork.tools.classdiagramconfiguration.presentation.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.tools.classdiagramconfiguration.Configuration;


/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class GenerateVsmHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public GenerateVsmHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		Configuration configuration = getConfiguration(activeEditor);
		EditingDomain editingDomain = getEditingDomainFromEditor(activeEditor);
		
		ClassDiagramGenerator generator = new ClassDiagramGenerator(configuration, editingDomain);
		Collection<RepresentationDescription> newDescriptions = generator.generate();
		
		if (!newDescriptions.isEmpty() && activeEditor instanceof ISelectionProvider) {
			((ISelectionProvider)activeEditor).setSelection(new StructuredSelection(newDescriptions));			
		}
		return null;
	}
	
	private EditingDomain getEditingDomainFromEditor(IEditorPart editor) {
		if (editor instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) editor).getEditingDomain();
		}
		return null;
	}
	
	private Configuration getConfiguration(IEditorPart editor) {
		if (editor instanceof IEditingDomainProvider) {
			EditingDomain editingDomain = ((IEditingDomainProvider) editor).getEditingDomain();
			if (editingDomain != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				if (resourceSet != null) {
					for (Resource resource : resourceSet.getResources()) {
						for (EObject object : resource.getContents()) {
							if (object instanceof Configuration) {
								return (Configuration)object;
							}
						}
					}
				}
			}
		}
		return null;
	}
}
