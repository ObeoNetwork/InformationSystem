/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class TextWithButton extends Composite {
	private Text textWidget;
	private Button button;

	public TextWithButton(Composite parent, int style, FormToolkit toolkit) {
		super(parent, style);

		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		
		textWidget = toolkit.createText(this, "", SWT.BORDER);
		textWidget.setEnabled(false);
		textWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		button = toolkit.createButton(this, "", SWT.NONE);
	}
	
	public void addButtonSelectionListener(SelectionListener listener) {
		button.addSelectionListener(listener);
	}
	
	public void setButtonText(String buttonText) {
		button.setText(buttonText);
	}
	
	public String getText () {
		return getTextWidget().getText();
	}
	
	public void setText(String text) {
		getTextWidget().setText(text);
	}

	public Text getTextWidget() {
		return textWidget;
	}

	public Button getButton() {
		return button;
	}

}
