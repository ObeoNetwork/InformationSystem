package org.obeonetwork.dsl.cinematic.design.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;


/**
 * Extension of {@link NewModelCreationPage} that adds a checkbox to display an additional page.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class NewCinematicModelPage extends NewModelCreationPage {
	private boolean canFlipToNextPage = false;
	
	public NewCinematicModelPage(String pageId, IStructuredSelection selection, String fileExtension) {
		super(pageId, selection, fileExtension);
	}

	@Override
	public void createControl(Composite parent) {		
		super.createControl(parent);
		
		Composite compositeMockup = new Composite((Composite) getControl(), SWT.NONE);
		compositeMockup.setLayout(new RowLayout(SWT.HORIZONTAL));
		compositeMockup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 4));
		
		Button initializeWithMockup = new Button(compositeMockup, SWT.CHECK);
		initializeWithMockup.setText("Initialize cinematic model with mockup");
		initializeWithMockup.setSelection(false);
		initializeWithMockup.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent event) {
	            Button btn = (Button) event.getSource();
	            canFlipToNextPage = btn.getSelection();
	            getContainer().updateButtons();
			}
		});
	}
	
	
	@Override
	public boolean canFlipToNextPage() {
		return canFlipToNextPage;
	}
}
