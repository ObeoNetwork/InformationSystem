package org.obeonetwork.tools.snapshot.viewer.wizards;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SelectXmlFilePage2 extends WizardPage {
	private DataBindingContext m_bindingContext;
	private Text text;
	
	private String xmlFilePath;

	/**
	 * Create the wizard.
	 */
	public SelectXmlFilePage2() {
		super("wizardPage");
		setTitle("File selection");
		setDescription("Select an XML file (exported by CDO)");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblXmlFile = new Label(container, SWT.NONE);
		lblXmlFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblXmlFile.setText("XML File :");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell());
				dlg.setFileName(xmlFilePath);
				
				String [] filterNames = new String [] {"XML Files", "All Files (*)"};
				String [] filterExtensions = new String [] {"*.xml", "*"};

				dlg.setFilterNames(filterNames);
				dlg.setFilterExtensions(filterExtensions);
				xmlFilePath = dlg.open();
			}
		});
		btnBrowse.setText("Browse...");
		m_bindingContext = initDataBindings();
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue bytesXmlFilePathObserveValue = PojoProperties.value("bytes").observe(xmlFilePath);
		bindingContext.bindValue(observeTextTextObserveWidget, bytesXmlFilePathObserveValue, null, null);
		//
		return bindingContext;
	}
}
