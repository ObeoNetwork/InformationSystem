package org.obeonetwork.dsl.environment.design.ui.providers;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.environment.Reference;
import org.osgi.framework.Bundle;

public class ReferenceLabelProvider extends LabelProvider {

	private static final String UNKNOWN = "?";
	private Image image = null;
	
	public ReferenceLabelProvider() {
		String path = "icons/full/obj16/Reference.gif";		
		Bundle bundle = Platform.getBundle("org.obeonetwork.dsl.environment.edit");
		URL url = FileLocator.find(bundle, new Path(path), null);
		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
		image = imageDesc.createImage();
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Reference) {
			StringBuilder sb = new StringBuilder();
			Reference ref = (Reference)element;
			if (ref.getName() != null) {
				sb.append(ref.getName());
			}
			sb.append("[");
			if (ref.getMultiplicity() != null) {
				sb.append(ref.getMultiplicity());
			} else {
				sb.append(UNKNOWN);
			}
			sb.append("] (");
			if (ref.getContainingType() != null) {
				sb.append(ref.getContainingType().getName());
			} else {
				sb.append(UNKNOWN);
			}
			sb.append(" -> ");
			if (ref.getReferencedType() != null) {
				sb.append(ref.getReferencedType().getName());
			} else {
				sb.append(UNKNOWN);
			}
			sb.append(")");
			return sb.toString();
		}
		return super.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof Reference) {
			return image;
		}
		return super.getImage(element);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (image != null) {
			image.dispose();			
		}
	}
}
