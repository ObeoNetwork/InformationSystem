package org.obeonetwork.dsl.cinematic.edit.ui;

import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.provider.extension.IReferenceWidgetImageProvider;
import org.osgi.framework.Bundle;
public class ReferenceWidgetImageProvider implements IReferenceWidgetImageProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.provider.extension.IReferenceWidgetImageProvider#getReferencedWidgetImage(java.lang.Object)
	 */
	public Object getReferencedWidgetImage(Object object) {
		AbstractViewElement abstractViewElement = (AbstractViewElement) object;
		Widget widget = abstractViewElement.getWidget();
		if (widget != null) {
			String iconStringPath = widget.getIcon();
			if (iconStringPath != null && !iconStringPath.trim().equals("")) {
				IResource iconResource = ResourcesPlugin.getWorkspace().getRoot().findMember(iconStringPath);
				if (iconResource == null) {
					// Search in plugins
					IPath iconPath = new Path(iconStringPath);
					String bundleId = iconPath.segment(0);
					Bundle bundle = Platform.getBundle(bundleId);
					if (bundle != null) {
						IPath iconRelativePath = iconPath.removeFirstSegments(1);
						Map<String, String> emptyMap = Collections.emptyMap();
						URL imageURL = FileLocator.find(bundle, iconRelativePath, emptyMap);
						if (imageURL != null) {
							ImageDescriptor imgDesc = ImageDescriptor.createFromURL(imageURL);
							if (imgDesc != null) {
								return imgDesc.createImage();
							}
						}
					}
				} else {
					ImageDescriptor imgDesc = ImageDescriptor
							.createFromImageData(new ImageData(iconResource.getLocation().toString()));
					if (imgDesc != null) {
						return imgDesc.createImage();
					}
				}
			}
		}
		return null;
	}
}