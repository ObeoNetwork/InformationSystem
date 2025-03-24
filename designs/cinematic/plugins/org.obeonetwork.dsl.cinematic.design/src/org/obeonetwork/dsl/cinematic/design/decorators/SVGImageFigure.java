/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.decorators;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.common.tools.api.resource.FileProvider;
import org.eclipse.sirius.diagram.ui.tools.api.figure.SVGFigure;
import org.eclipse.sirius.diagram.ui.tools.api.figure.SVGWorkspaceImageFigure;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.swt.graphics.Image;

public class SVGImageFigure extends SVGWorkspaceImageFigure {

	public Image getImage(int w, int h) {
		return getImage(new PrecisionRectangle(0, 0, w, h), null);
	}

	private static Option<String> getImageUri(String workspacePath, boolean force) {
		final File imageFile = FileProvider.getDefault().getFile(new Path(workspacePath));
		if (imageFile != null && (force || imageFile.exists() && imageFile.canRead())) {
			return Options.newSome(imageFile.toURI().toString());
		}
		Option<String> nonExistingFile = Options.newNone();
		if (force) {
			// Deleted file : retrieve the key.
			nonExistingFile = Options.newSome(ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString() + workspacePath);
		}

		return nonExistingFile;
	}

	public boolean updateImageURI(String workspacePath) {
		if (workspacePath != null) {
			Option<String> existingImageUri = getImageUri(workspacePath, false);
			if (existingImageUri.some()) {
				setURI(existingImageUri.get());
			} else {
				setURI(SVGFigure.IMAGE_NOT_FOUND_URI);
			}
			return true;
		}
		return false;
	}

	private static final Map<Session, Map<String, Image>> IMAGE_CACHE_PER_SESSION = new HashMap<>();

    public static Image flyWeightImage(Session session, String path) {
    	Map<String, Image> imageCache = getImageCache(session);
    	Image image = imageCache.get(path);
    	if(image == null) {
    		image = flyWeightImage(path);
    		imageCache.put(path, image);
    	}
    	return image;
    }
	
	public static Image flyWeightImage(Session session, String path, int width, int height) {
		
		Map<String, Image> imageCache = getImageCache(session);
		
		String imageKey = computeKey(path, width, height);
		Image image = imageCache.get(imageKey);
		
		if(image == null) {
			SVGImageFigure fig = new SVGImageFigure();
			fig.updateImageURI(path);
			fig.setSize(width, height);
			fig.contentChanged();
			image = fig.getImage(new PrecisionRectangle(0, 0, width, height), null);
			imageCache.put(imageKey, image);
		}
		
		return image;
	}

	private static Map<String, Image> getImageCache(Session session) {
		Map<String, Image> imageCache = IMAGE_CACHE_PER_SESSION.get(session);
		
		if(imageCache == null) {
			imageCache = new HashMap<>();
			IMAGE_CACHE_PER_SESSION.put(session, imageCache);
			
			session.addListener(new SessionListener() {
				@Override
				public void notify(int changeKind) {
					if(changeKind == SessionListener.CLOSED) {
						IMAGE_CACHE_PER_SESSION.get(session).values().forEach(image -> image.dispose());
						IMAGE_CACHE_PER_SESSION.remove(session);
					}
				}
			});
		}
		return imageCache;
	}

	private static String computeKey(String path, int width, int height) {
		return String.format("%s(%dx%d)", path, width, height);
	}

}