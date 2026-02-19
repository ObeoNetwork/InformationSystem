/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.common.ui;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.eclipse.eef.common.api.utils.Util;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage;
import org.eclipse.eef.properties.ui.api.IEEFTabbedPropertySheetPageContributor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;
import org.eclipse.sirius.properties.core.api.SiriusInputDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.part.IPageSite;
import org.osgi.framework.Bundle;

@SuppressWarnings("deprecation") // IWorkbenchPartSite has deprecated API.
public class EEFPropertiesPageDialog extends TrayDialog {


	private static final Point INITIAL_WIZARD_SIZE = new Point(800, 400);

    private static final String PROPERTIES_VIEW_TITLE = "Views.PropertySheet";

	private static final String PROPERTIES_VIEW_PLUGIN = "org.eclipse.ui.views";

	/**
     * The pattern used to separate a piece of text into an array containing all
     * the lines of the text.
     */
    private static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile("\r\n|\r|\n|\u2028"); //$NON-NLS-1$
    
	private EEFTabbedPropertySheetPage page;
	
	private final IWorkbenchPart parentView;
	
	private final PartStub innerPart;
	private final SiteStub innerSite;
	
	private final EObject target;
	private final ISelection selection;

	
	private final boolean canCancel;
	
	private final EditingDomainServices edtServices = new EditingDomainServices();
    
    public EEFPropertiesPageDialog(IWorkbenchPart parent, EObject element, boolean cancellable) {
    	super(parent.getSite().getShell());
		setShellStyle(getShellStyle() | SWT.RESIZE);

    	parentView = parent;
    	target = element;
    	selection = new StructuredSelection(target);
    	
    	innerPart = new PartStub();
    	innerSite = new SiteStub();
    	canCancel = cancellable;
    	
    	page = new EEFTabbedPropertySheetPage(new IEEFTabbedPropertySheetPageContributor() {
			
			@Override
			public void updateFormTitle(Form form, ISelection selection) {
				updateHeader(form, selection);
			}		    
		    
		    @Override
			public List<String> getContributorIds() {
				return List.of(getContributorId());
			}
			
			@Override
			public String getContributorId() {
				return EEFPropertiesPageDialog.class.getName();
			}
		});
    	page.init(innerSite);
    }
    
	private void updateHeader(Form form, ISelection selection) {
        boolean semanticElementFound = false;
        if (selection instanceof IStructuredSelection structuredSelection
        		&& structuredSelection.getFirstElement() instanceof Object first) {
            SiriusInputDescriptor inputDescriptor = new SiriusInputDescriptor(first);
            EObject semanticElement = inputDescriptor.getSemanticElement();
            if (semanticElement != null) {
                semanticElementFound = true;
                updateFormText(form, semanticElement);
                form.setImage(ExtendedImageRegistry.INSTANCE.getImage(edtServices.getLabelProviderImage(semanticElement)));
            }
        }
        if (!semanticElementFound) {
            form.setText(""); //$NON-NLS-1$
            form.setImage(null);
        }
	}
	
    /**
     * Update the text of the title of the form.
     * 
     * @param form
     *            The form
     * @param semanticElement
     *            The current semantic element
     */
	private void updateFormText(Form form, EObject semanticElement) {
        String text = edtServices.getLabelProviderText(semanticElement);
        if (!Util.isBlank(text)) {
            // Keep only the first line in case of multiline labels
            String[] result = LINE_SEPARATOR_PATTERN.split(text, 2);
            if (result.length >= 1) {
                form.setText(result[0].replace("&", "&&")); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else {
            form.setText(""); //$NON-NLS-1$
        }    
    }
    
	public void create() {
		super.create();
		
    	Bundle bundle = Platform.getBundle(PROPERTIES_VIEW_PLUGIN);
    	String title = Platform.getResourceBundle(bundle).getString(PROPERTIES_VIEW_TITLE);
    	getShell().setText(title);
		getShell().setMinimumSize(INITIAL_WIZARD_SIZE.x, INITIAL_WIZARD_SIZE.y);
	}
    
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
    	if (!canCancel) {
	    	// Cancel only close.
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.CLOSE_LABEL, true);
    	} else {
    		super.createButtonsForButtonBar(parent);
    	}
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
    	Composite mainArea = (Composite) super.createDialogArea(parent);
    	mainArea.setLayout(new FormLayout());    	

		page.createControl(mainArea);
		
		return mainArea;
	}
    
    @Override
    protected Control createContents(Composite parent) {
    	Control result = super.createContents(parent);

    	// dialogArea must be set
		page.selectionChanged(innerPart, selection);
    	
    	return result;
    }
    
    private class PartStub implements IWorkbenchPart, IEEFTabbedPropertySheetPageContributor {
		@Override
		public void updateFormTitle(Form form, ISelection selection) {
			// nothing to do
		}
		
		@Override
		public List<String> getContributorIds() {
			return List.of(getContributorId());
		}
		
		@Override
		public String getContributorId() {
			return EEFPropertiesPageDialog.class.getName();
		}

		@Override
		public <T> T getAdapter(Class<T> adapter) {
			return null;
		}

		@Override
		public void addPropertyListener(IPropertyListener listener) {
		}

		@Override
		public void createPartControl(Composite parent) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void dispose() {
		}

		@Override
		public IWorkbenchPartSite getSite() {
			return innerSite;
		}

		@Override
		public String getTitle() {
			return "EEFPropertiesPageDialog";
		}

		@Override
		public Image getTitleImage() {
			return null;
		}

		@Override
		public String getTitleToolTip() {
			return null;
		}

		@Override
		public void removePropertyListener(IPropertyListener listener) {
		}

		@Override
		public void setFocus() {
		}
    }
    
    private class SiteStub implements IPageSite, IWorkbenchPartSite, ISelectionProvider {

    	final IWorkbenchPartSite delegate = parentView.getSite();
    	
		@Override
		public IWorkbenchPage getPage() {
			return delegate.getWorkbenchWindow().getActivePage(); // TO confirm
		}

		@Override
		public ISelectionProvider getSelectionProvider() {
			return this;
		}

		@Override
		public Shell getShell() {
			return delegate.getShell();
		}

		@Override
		public IWorkbenchWindow getWorkbenchWindow() {
			return delegate.getWorkbenchWindow();
		}

		@Override
		public void setSelectionProvider(ISelectionProvider provider) {
		}

		@Override
		public <T> T getAdapter(Class<T> adapter) {
			return null;
		}

		@Override
		public <T> T getService(Class<T> api) {
			return delegate.getService(api);
		}

		@Override
		public boolean hasService(Class<?> api) {
			return delegate.hasService(api);
		}

		@Override
		public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider) {
		}

		@Override
		public IActionBars getActionBars() {
			return null;
		}

		@Override
		public ISelection getSelection() {
			return selection;
		}

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		}

		@Override
		public void setSelection(ISelection selection) {
		}

		@Override
		public String getId() {
			return EEFPropertiesPageDialog.class.getSimpleName();
		}

		@Override
		public String getPluginId() {
			return Activator.PLUGIN_ID;
		}

		@Override
		public String getRegisteredName() {
			return EEFPropertiesPageDialog.class.getSimpleName();
		}

		@Override
		public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
		}


		@Override
		public IKeyBindingService getKeyBindingService() {
			return getService(IKeyBindingService.class);
		}

		@Override
		public IWorkbenchPart getPart() {
			return innerPart;
		}
    	
    }
    
}
