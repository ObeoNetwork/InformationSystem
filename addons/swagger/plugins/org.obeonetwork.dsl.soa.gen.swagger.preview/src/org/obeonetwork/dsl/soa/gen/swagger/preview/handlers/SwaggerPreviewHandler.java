/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview.handlers;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.browser.WebBrowserEditor;
import org.eclipse.ui.internal.browser.WebBrowserEditorInput;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;
import org.obeonetwork.dsl.soa.gen.swagger.preview.webserver.SwaggerPreviewJettyServer;

import com.google.common.io.Files;

@SuppressWarnings("restriction")
public class SwaggerPreviewHandler extends AbstractHandler implements IHandler {

	private static final String SWAGGER_BROWSER_ID = "org.obeonetwork.dsl.soa.gen.swagger.preview.SwaggerPreviewBrowser";
	private static final MapperType MAPPER_TYPE = MapperType.YAML;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Component component = null;
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> selectionIteratror = structuredSelection.iterator();
			component = (Component) selectionIteratror.next();
		}
		
		try {
			// Start the SwaggerPreviewJettyServer (does nothing if already started)
			SwaggerPreviewJettyServer.instance().start();
			
			// Generate the swagger in a temporary file
			String swaggerFileName = SwaggerExporter.getFileNameForComponent(component, MAPPER_TYPE);
			File swaggerFile = File.createTempFile(Files.getNameWithoutExtension(swaggerFileName), Files.getFileExtension(swaggerFileName));
			swaggerFile.deleteOnExit();
			
			SwaggerExporter.exportInFile(component, MAPPER_TYPE, swaggerFile);
			
			// Register the generated file in the SwaggerPreviewJettyServer
			SwaggerPreviewJettyServer.instance().putSwaggerFile(swaggerFileName, swaggerFile);
			
			// Open the Eclipse internal web browser on the Swagger UI local web server
			URL url = SwaggerPreviewJettyServer.instance().getUrlForFile(swaggerFileName);
			
			WebBrowserEditorInput webBrowserEditor = new WebBrowserEditorInput(url, SWT.NONE, SWAGGER_BROWSER_ID);
			webBrowserEditor.setName(swaggerFileName);

			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.openEditor((IEditorInput) webBrowserEditor, WebBrowserEditor.WEB_BROWSER_EDITOR_ID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
