package org.obeonetwork.dsl.soa.design.services;

import fr.obeo.dsl.viewpoint.DDiagram;
import fr.obeo.dsl.viewpoint.description.Layer;

public class DiagramService {

	
	public static boolean isLayerActivated(DDiagram diagram, String layerName) {
		for (Layer activatedLayer : diagram.getActivatedLayers()) {
			if (layerName.equals(activatedLayer.getName())) {
				return true;
			}
		}
		return false;
	}
}
