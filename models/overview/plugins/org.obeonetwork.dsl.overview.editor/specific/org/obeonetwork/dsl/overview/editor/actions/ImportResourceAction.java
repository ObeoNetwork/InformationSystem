/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.overview.editor.actions;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import org.obeonetwork.dsl.overview.Root;

/**
 * An action to import/copy a resource into an editing domain's resource set.
 */
public class ImportResourceAction extends Action {
	protected EditingDomain domain;

	public ImportResourceAction(EditingDomain domain) {
		this();
		this.domain = domain;
		update();
	}

	public ImportResourceAction() {
		super("Import Resource...");
	}

	/**
	 * This returns the action's domain.
	 */
	public EditingDomain getEditingDomain() {
		return domain;
	}

	/**
	 * This sets the action's domain.
	 */
	public void setEditingDomain(EditingDomain domain) {
		this.domain = domain;
	}

	@Override
	public void run() {
		ImportResourceDialog importResourceDialog = new ImportResourceDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				domain);

		importResourceDialog.open();
	}

	public void update() {
		setEnabled(domain != null);
	}

	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		setEditingDomain(workbenchPart instanceof IEditingDomainProvider ? ((IEditingDomainProvider) workbenchPart)
				.getEditingDomain()
				: null);
		update();
	}

	public static class ImportResourceDialog extends ResourceDialog {
		protected EditingDomain domain;

		public ImportResourceDialog(Shell parent, EditingDomain domain) {
			super(parent, "Import Resource", SWT.OPEN | SWT.MULTI);
			this.domain = domain;
		}

		@Override
		protected boolean processResources() {
			if (domain != null) {
				for (URI uri : getURIs()) {
					ResourceSet tempResourceSet = new ResourceSetImpl();
					// return
					// processResource(domain.getResourceSet().getResource(uri,
					// true));
					return processResource(tempResourceSet.getResource(uri,
							true));
				}
			}
			return true;
		}

		protected boolean processResource(final Resource resource) {
			Root rootOverview = getRootOverviewObject();
			if (rootOverview != null) {
				Command importCommand = createImportCommand(rootOverview,
						resource.getContents());
				domain.getCommandStack().execute(importCommand);
			}
			return true;
		}

		private Root getRootOverviewObject() {
			ResourceSet resourceSet = domain.getResourceSet();
			TreeIterator<Notifier> it = resourceSet.getAllContents();
			while (it.hasNext()) {
				Notifier notifier = it.next();
				if (notifier instanceof Root) {
					return (Root) notifier;
				}
			}
			return null;
		}

		private Command createImportCommand(final Root rootOverview,
				final EList<EObject> elements) {
			return new AbstractCommand("Import Resource") {
				protected boolean prepare() {
					return true;
				}

				public void execute() {
					rootOverview.getOwnedElements().addAll(elements);
				}

				public void redo() {
				}
			};
		}
	}

}
