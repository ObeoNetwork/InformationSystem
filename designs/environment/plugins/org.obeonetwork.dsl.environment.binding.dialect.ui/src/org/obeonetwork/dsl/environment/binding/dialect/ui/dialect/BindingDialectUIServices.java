/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.dialect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.tree.provider.TreeItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.environment.binding.dialect.ui.editor.BindingTreeEditor;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription;
import org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionFactory;
import org.obeonetwork.dsl.environment.bindingdialect.description.provider.DescriptionItemProviderAdapterFactory;
import org.obeonetwork.dsl.environment.bindingdialect.provider.BindingdialectItemProviderAdapterFactory;

import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.DRepresentationElement;
import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.dialect.command.RefreshRepresentationCommand;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.description.DescriptionPackage;
import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectEditor;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.ExportFormat;
import fr.obeo.dsl.viewpoint.ui.business.api.session.SessionEditorInput;

/**
 * @author sthibaudeau
 *
 */
public class BindingDialectUIServices implements DialectUIServices {
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#canHandle(fr.obeo.dsl.viewpoint.DRepresentation)
	 */
	public boolean canHandle(DRepresentation representation) {
		return representation instanceof DBindingEditor;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#canHandleEditor(org.eclipse.ui.IEditorPart)
	 */
	public boolean canHandleEditor(IEditorPart editor) {
		return editor instanceof BindingTreeEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#getEditorName(fr.obeo.dsl.viewpoint.DRepresentation)
	 */
	public String getEditorName(DRepresentation representation) {
		return representation.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#closeEditor(org.eclipse.ui.IEditorPart, boolean)
	 */
	public boolean closeEditor(IEditorPart editorPart, boolean save) {
        boolean result = false;
        if (canHandleEditor(editorPart)) {
            try {
                ((BindingTreeEditor) editorPart).close(save);
            } catch (NullPointerException e) {
                // we might have an exception closing an editor which is
                // already in trouble
            }
            // We suppose it is closed.
            result = true;
        }
        return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#createAdapterFactory()
	 */
	public AdapterFactory createAdapterFactory() {
        final ComposedAdapterFactory factory = new ComposedAdapterFactory();
        factory.addAdapterFactory(new BindingdialectItemProviderAdapterFactory());
        factory.addAdapterFactory(new DescriptionItemProviderAdapterFactory());
        factory.addAdapterFactory(new TreeItemProviderAdapterFactory());
        return factory;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#isRepresentationManagedByEditor(fr.obeo.dsl.viewpoint.DRepresentation, org.eclipse.ui.IEditorPart)
	 */
	public boolean isRepresentationManagedByEditor(DRepresentation representation, IEditorPart editor) {
		if (canHandleEditor(editor)) {
			return ((DialectEditor)editor).getRepresentation().equals(representation);
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#isRepresentationDescriptionManagedByEditor(fr.obeo.dsl.viewpoint.description.RepresentationDescription, org.eclipse.ui.IEditorPart)
	 */
	public boolean isRepresentationDescriptionManagedByEditor(RepresentationDescription description, IEditorPart editor) {
        if (canHandleEditor(editor)) {
        	BindingTreeEditor bindingEditor = (BindingTreeEditor) editor;
            return EcoreUtil.equals(bindingEditor.getBindingEditorRepresentation().getDescription(), description);
        } else {
            return false;
        }
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#openEditor(fr.obeo.dsl.viewpoint.business.api.session.Session, fr.obeo.dsl.viewpoint.DRepresentation)
	 */
	public IEditorPart openEditor(Session session, DRepresentation representation) {
        return openEditor(session, representation, new NullProgressMonitor());
	}
	

	@Override
	public IEditorPart openEditor(Session session, DRepresentation representation, IProgressMonitor monitor) {
		if (representation instanceof DBindingEditor) {
			monitor.beginTask("Opening binding editor", 1);
            URI uri = EcoreUtil.getURI(representation);
            final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
            final IEditorInput editorInput = new SessionEditorInput(uri, getEditorName(representation), session);
            RunnableWithResult<IEditorPart> runnable = new RunnableWithResult.Impl<IEditorPart>() {
                public void run() {
                    final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    try {
                        setResult(page.openEditor(editorInput, BindingTreeEditor.ID));
                    } catch (final PartInitException e) {
                        // silent catch
                    }
                }
            };
            PlatformUI.getWorkbench().getDisplay().syncExec(runnable);
            Object result = runnable.getResult();
            if (result instanceof IEditorPart && canHandleEditor((IEditorPart) result)) {
                // Activation of the refresh of the DBindingEditor property page
                if (result instanceof BindingTreeEditor) {
                	// TODO vérifier s'il faut enlever des choses
                    doRefresh((DBindingEditor) representation, domain);
                }
                return (IEditorPart) result;
            }
            monitor.worked(1);
            monitor.done();
        }
        return null;
	}
	
    private void doRefresh(final DBindingEditor editor, final TransactionalEditingDomain domain) {
        if (DialectManager.INSTANCE.isRefreshActivatedOnRepresentationOpening()) {
            Runnable runnable = new Runnable() {
                public void run() {
                    domain.getCommandStack().execute(new RefreshRepresentationCommand(domain, editor));
                };
            };
            PlatformUI.getWorkbench().getDisplay().syncExec(runnable);
        }
    }



	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#provideNewChildDescriptors()
	 */
	public Collection<CommandParameter> provideNewChildDescriptors() {
		final Collection<CommandParameter> newChilds = new ArrayList<CommandParameter>();
		final DBindingEditorDescription description = DescriptionFactory.eINSTANCE.createDBindingEditorDescription();
		newChilds.add(new CommandParameter(null, DescriptionPackage.Literals.VIEWPOINT__OWNED_REPRESENTATIONS, description));
		return newChilds;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#provideRepresentationCreationToolDescriptors(java.lang.Object)
	 */
	public Collection<CommandParameter> provideRepresentationCreationToolDescriptors(Object feature) {
		final Collection<CommandParameter> newChilds = new ArrayList<CommandParameter>();
		final DBindingEditorCreationDescription creationTool = DescriptionFactory.eINSTANCE.createDBindingEditorCreationDescription();
		newChilds.add(new CommandParameter(null, feature, creationTool));
		return newChilds;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#provideRepresentationNavigationToolDescriptors(java.lang.Object)
	 */
	public Collection<CommandParameter> provideRepresentationNavigationToolDescriptors(Object feature) {
		// TODO Auto-generated method stub
		 return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#provideTools(org.eclipse.emf.ecore.EObject)
	 */
	public Collection<CommandParameter> provideTools(EObject object) {
		return Collections.emptyList();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#provideAdditionalMappings(org.eclipse.emf.ecore.EObject)
	 */
	public Collection<CommandParameter> provideAdditionalMappings(EObject object) {
		return Collections.emptyList();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#canExport(fr.obeo.dsl.viewpoint.ui.business.api.dialect.ExportFormat)
	 */
	public boolean canExport(ExportFormat format) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIServices#export(fr.obeo.dsl.viewpoint.DRepresentation, fr.obeo.dsl.viewpoint.business.api.session.Session, org.eclipse.core.runtime.IPath, fr.obeo.dsl.viewpoint.ui.business.api.dialect.ExportFormat, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void export(DRepresentation representation, Session session, IPath path, ExportFormat format, IProgressMonitor monitor) {
		// Nothing to do for binding trees
	}

	public ILabelProvider getHierarchyLabelProvider(ILabelProvider labelProvider) {
		return labelProvider;
	}

	public Collection<DSemanticDecorator> getSelection(DialectEditor dialectEditor) {
		return Collections.emptyList();
	}

	public void setSelection(DialectEditor dialectEditor, List<DRepresentationElement> representationElements) {
		
	}
}
