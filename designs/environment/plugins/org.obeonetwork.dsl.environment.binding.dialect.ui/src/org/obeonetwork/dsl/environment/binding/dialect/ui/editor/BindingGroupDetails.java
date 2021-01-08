/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands.UpdateMappingExpressionCommand;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class BindingGroupDetails {
	private static final String LBL_EMPTY_SELECTION = "Empty selection";
	private static final String LBL_NOT_YET_BOUND_ELEMENT = "Element is not bound";
	
	private BindingTreeEditorManager editorManager;
	private Group group;
	private Set<DBoundElement> boundElements = new HashSet<DBoundElement>();
	private Collection<BoundElementComposite> composites = new ArrayList<BoundElementComposite>();

	public BindingGroupDetails(Composite parent, Composite topAttachement, BindingTreeEditorManager editorManager) {
		this.editorManager = editorManager;
		group = new Group(parent, SWT.NONE);
		init(topAttachement);
	}

	private void init(Composite topAttachement) {
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft = 10;
		group.setLayout(gridLayout);
		
		FormData formData = new FormData();
		if (topAttachement == null) {
			formData.top = new FormAttachment(0);
		} else {
			formData.top = new FormAttachment(topAttachement);
		}
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(100);
		group.setLayoutData(formData);
		composites.add(new NoBoundElementComposite(group, LBL_EMPTY_SELECTION));
	}
	
	public void setBoundElements(Set<DBoundElement> boundElements) {
		this.boundElements = boundElements;

		for (BoundElementComposite composite : composites) {
			composite.remove();
		}
		composites.clear();

		if (this.boundElements.isEmpty()) {
			composites.add(new NoBoundElementComposite(group, LBL_EMPTY_SELECTION));
		} else {
			for (DBoundElement boundElement : boundElements) {
				composites.add(new BoundElementComposite(group, boundElement));
			}
		}
		group.layout(true);
	}
	
	private class BoundElementComposite {
		private DBoundElement element;
		protected Label label;
		protected Text text;
		final private BindingElement bindingElement;
		final private boolean alreadyBound;
		
		public BoundElementComposite(Composite parent, DBoundElement element) {
			this.element = element;
			bindingElement = getRelatedBindingElement();
			alreadyBound = (bindingElement != null);
			init(parent);
		}
		
		protected void init(Composite parent) {
			label = new Label(parent, SWT.NONE);
			label.setText(getLabel());
			
			String expression = null;
			if (bindingElement != null) {
				expression = bindingElement.getBindingExpression();
			}
			
			text = new Text(parent, SWT.BORDER);
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			if (alreadyBound == true) {
				if (expression != null) {
					text.setText(expression);
				}
				text.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent e) {
						
						UpdateMappingExpressionCommand updMappingCmd = new UpdateMappingExpressionCommand(editorManager.getEditingDomain(),
								editorManager.getAccessor(),
								bindingElement,
								((Text)e.widget).getText());
						editorManager.execute(updMappingCmd);
					}
					
					public void focusGained(FocusEvent e) {
					}
				});
			} else {
				text.setText(LBL_NOT_YET_BOUND_ELEMENT);
				text.setEnabled(false);
				text.setEditable(false);
			}
		}
		
		private BindingElement getRelatedBindingElement() {
			if (element == null) {
				return null;
			}
			BindingElement bindingElement = null;
			List<DBindingEdge> edges = element.getEdges();
			if (edges != null && edges.isEmpty() == false) {
				DBindingEdge firstEdge = edges.get(0);
				BindingReference reference = (BindingReference)firstEdge.getTarget();
				if (element.equals(firstEdge.getLeft())) {
					bindingElement = reference.getLeft();
				} else if (element.equals(firstEdge.getRight())) {
					bindingElement = reference.getRight();
				}
			}
			return bindingElement;
		}
		
		private String getLabel() {
			String label = null;
			EObject target = element.getTarget();
			if (target instanceof Property) {
				label = ((Property)target).getName();
			} else if (target instanceof Type) {
				label = ((Type)target).getName();
			}
			return label + " =";
		}
		
		private void remove() {
			if (label != null && !label.isDisposed()) {
				label.dispose();
			}
			if (text != null && !text.isDisposed()) {
				text.dispose();
			}
		}
	}
	
	private class NoBoundElementComposite extends BoundElementComposite {

		public NoBoundElementComposite(Composite parent, String labelValue) {
			super(parent, null);
			label.setText(labelValue);
		}

		@Override
		protected void init(Composite parent) {
			label = new Label(parent, SWT.NONE);
			text = null;
		}
		
	}

	
	public void setText(String text) {
		group.setText(text);
	}

	public Group getGroup() {
		return group;
	}
}
