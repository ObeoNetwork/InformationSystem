/*******************************************************************************
 * Copyright (c) 2016, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.designer.contribution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class StatusBarBrandingControlContribution extends WorkbenchWindowControlContribution {
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.action.ControlContribution#createControl(org.eclipse
     * .swt.widgets.Composite)
     */
    protected Control createControl(Composite parent) {
        // Create a composite to place the label in
        Composite comp = new Composite(parent, SWT.NONE);

        // Give some room around the control
        FillLayout layout = new FillLayout();
        layout.marginHeight = 2;
        layout.marginWidth = 2;
        comp.setLayout(layout);

        // Create a label for the trim.
        Label ccCtrl = new Label(comp,/* SWT.BORDER | */ SWT.CENTER);
        ccCtrl.setText(Messages.StatusBarBranding_Text);
        ccCtrl.setToolTipText(Messages.StatusBarBranding_Text);

        return comp;
    }


}
