/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.common.ui.services;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;

public class WizardHelper {
	
	/**
	 * Add {@link fileExtension} to the end of {@link inputField} if it doesn't end with an extension.
	 * The added extension is set to ITALIC style and GREY color.
	 * The selection in {@link fileExtension} is moved to the index of the added extension.
	 * 
	 * If {@link fileExtension} or {@link inputField} is null, does nothing.
	 * 
	 * @param inputField the modified field
	 * @param fileExtension the added default extension
	 */
	public static void addExtensionIfMissing(StyledText inputField, String fileExtension) {
		
		if(inputField == null || fileExtension == null) {
			return;
		}
		
		if(!fileExtension.startsWith(".")) {
			fileExtension = "." + fileExtension;
		}
		
		if(!inputField.getText().contains(".") && !inputField.getText().isEmpty()) {
			inputField.setText(inputField.getText() + fileExtension);
			int dotIndex = inputField.getText().lastIndexOf(".");
			inputField.setSelection(dotIndex);
		}
		
		if(inputField.getText().endsWith(fileExtension)) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = inputField.getText().lastIndexOf(fileExtension);
			styleRange.length = fileExtension.length();
			styleRange.fontStyle = SWT.ITALIC;
			styleRange.foreground = new Color(125, 125, 125);
			inputField.setStyleRange(styleRange);
		}
		else {
			StyleRange styleRange = new StyleRange();
			styleRange.start = 0;
			styleRange.length = inputField.getText().length();
			styleRange.fontStyle = SWT.NORMAL;
			styleRange.foreground = new Color(0, 0, 0);
			inputField.setStyleRange(styleRange);
		}
		
	}
	
	/**
	 * Set {@link inputField} as an empty String if it contains only the given {@link fileExtension}.
	 * 
	 * If {@link fileExtension} or {@link inputField} is null, does nothing.
	 * 
	 * @param inputField the modified field
	 * @param fileExtension the added default extension
	 */
	public static void setEmptyIfExtension(StyledText inputField, String fileExtension) {
		if(inputField == null || fileExtension == null) {
			return;
		}
		
		if(!fileExtension.startsWith(".")) {
			fileExtension = "." + fileExtension;
		}
		
		if(inputField.getText().equals(fileExtension)) {
			inputField.setText("");
		}
	}

}
