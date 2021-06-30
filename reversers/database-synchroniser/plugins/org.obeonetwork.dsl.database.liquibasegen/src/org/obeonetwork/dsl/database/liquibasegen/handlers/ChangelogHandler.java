package org.obeonetwork.dsl.database.liquibasegen.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.Activator;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.osgi.OSGiResourceAccessor;

@SuppressWarnings("restriction")
public class ChangelogHandler extends AbstractHandler {
	private Shell shell = null;
	private String URL = "jdbc:postgresql://localhost:5432/";
	private String username = "postgres";
	private String password = "password";
	private Liquibase liquibase;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		shell = HandlerUtil.getActiveShell(event);
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof File) {
				File changelogFile = (File) structuredSelection.getFirstElement();
				try {										
						
					Database database = DatabaseFactory.getInstance().openDatabase(URL, username, password, null, new OSGiResourceAccessor(Activator.getContext().getBundle()));
					liquibase = new Liquibase(changelogFile.getFullPath().toOSString(), new liquibase.osgi.OSGiResourceAccessor(Activator.getContext().getBundle()), database);
					liquibase.dropAll();
					liquibase.update("");
				} catch ( Exception e) {
					e.printStackTrace();
				}
			} 
		}
		
		MessageDialog.openInformation(
				shell,
				"Liquibasegen",
				"Hello");
		
		return null;
	}
}
