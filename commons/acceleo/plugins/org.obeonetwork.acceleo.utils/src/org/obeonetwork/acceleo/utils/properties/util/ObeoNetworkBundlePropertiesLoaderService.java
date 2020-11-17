/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.acceleo.utils.properties.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.acceleo.engine.service.AcceleoService;
import org.eclipse.acceleo.engine.service.properties.BundleAcceleoPropertiesLoaderService;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.obeonetwork.acceleo.utils.NetworkAcceleoUtilsPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

public class ObeoNetworkBundlePropertiesLoaderService extends BundleAcceleoPropertiesLoaderService {
	
	protected Bundle bundle;
	
	public ObeoNetworkBundlePropertiesLoaderService(AcceleoService acceleoService, Bundle bundle) {
		super(acceleoService, bundle);
		this.bundle = bundle;
	}
	
	@Override
	protected Properties alternatePropertiesLoading(String filepath) {
		/*
		 * Properties loading protocol by SBE
		 * Step 1: delegate to super.alternatePropertiesLoading(java.lang.String)
		 * 
		 * if it fails and if the path does not starts with platform:/plugin/
		 * 
		 * Step 2: load the properties from the path directly as if it was the
		 * absolute path of a file on the file system.
		 * 
		 * if the "Step 1" has failed and if the path does starts with platform:/plugin/
		 * 
		 * Step 3: compute the name of the bundle containing the properties file.
		 * Step 4: compute the path of the properties file.
		 * Step 5: load the properties file from that bundle.
		 **/
		
		Properties properties = super.alternatePropertiesLoading(filepath);
		if (EMFPlugin.IS_ECLIPSE_RUNNING && properties != null && properties.isEmpty()) {
			if (!filepath.startsWith(AcceleoPropertiesUtils.PLATFORM_PLUGIN)) {
				properties.putAll(this.loadProperties(filepath));
			} else if (filepath.indexOf("/", AcceleoPropertiesUtils.PLATFORM_PLUGIN.length() + 1) != -1) {
				// We will try to load a property file from another bundle.
				
				// Remove "platform:/plugin/"
				String bundleName = filepath.substring(AcceleoPropertiesUtils.PLATFORM_PLUGIN.length());
				bundleName = bundleName.substring(0, bundleName.indexOf("/"));
				
				String resourcePath = filepath.substring(AcceleoPropertiesUtils.PLATFORM_PLUGIN.length());
				resourcePath = resourcePath.substring(resourcePath.indexOf("/"));
				
				Bundle[] bundles = null;
				
				BundleContext context = NetworkAcceleoUtilsPlugin.getDefault().getBundle().getBundleContext();
				ServiceReference packageAdminReference = context.getServiceReference(PackageAdmin.class.getName());
				PackageAdmin packageAdmin = null;
				if (packageAdminReference != null) {
					packageAdmin = (PackageAdmin)context.getService(packageAdminReference);
				}

				if (packageAdmin != null) {
					bundles = packageAdmin.getBundles(bundleName, null);
				}
				if (packageAdminReference != null) {
					context.ungetService(packageAdminReference);
				}
				
				// We now have all the bundle with the matching bundle name.
				for (Bundle resourceBundle : bundles) {
					URL resource = resourceBundle.getResource(resourcePath);
					if (resource != null) {
						try {
							properties.load(resource.openStream());
						} catch (IOException e) {
							NetworkAcceleoUtilsPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, NetworkAcceleoUtilsPlugin.PLUGIN_ID, e.getMessage()));
						}
					}
					if (!properties.isEmpty()) {
						break;
					}
				}
			}
		}
		return properties;
	}
}
