/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.decorators;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
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
    
    public static Image flyWeightImage(String path, int width, int height) {
    	SVGImageFigure fig = new SVGImageFigure();
        fig.updateImageURI(path);
        fig.setSize(width, height);
        fig.contentChanged();
        Image image = fig.getImage(new PrecisionRectangle(0, 0, width, height), null);
        return image;
    }
    
}