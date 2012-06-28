package org.obeonetwork.dsl.is.design.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class DisplayMessageService {

	/**
	 * Display the provided message as an information to the user
	 * @param context Parameter needed so the method can be called by Acceleo
	 * @param title Title of the dialog
	 * @param message Message displayed inside the dialog
	 * @return the unmodified "context" parameter
	 */
	public EObject displayInfoMessage(EObject context, String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, message);
		return context;
	}
	
	/**
	 * Display the provided message as an error to the user
	 * @param context Parameter needed so the method can be called by Acceleo
	 * @param title Title of the dialog
	 * @param message Message displayed inside the dialog
	 * @return the unmodified "context" parameter
	 */
	public EObject displayErrorMessage(EObject context, String title, String message) {
		MessageDialog.openError(Display.getCurrent().getActiveShell(), title, message);
		return context;
	}
	
	/**
	 * Display the provided message as a warning to the user
	 * @param context Parameter needed so the method can be called by Acceleo
	 * @param title Title of the dialog
	 * @param message Message displayed inside the dialog
	 * @return the unmodified "context" parameter
	 */
	public EObject displayWarningMessage(EObject context, String title, String message) {
		MessageDialog.openWarning(Display.getCurrent().getActiveShell(), title, message);
		return context;
	}
}