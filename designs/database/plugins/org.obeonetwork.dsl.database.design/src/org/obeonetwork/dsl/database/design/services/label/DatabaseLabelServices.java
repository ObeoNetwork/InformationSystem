/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services.label;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.Layer;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

public class DatabaseLabelServices extends DatabaseSwitch<String>{

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());
	private DDiagram diagram = null;

	public String getDatabaseElementLabel(DatabaseElement element, DDiagram diagram) {
		this.diagram = diagram;
		return doSwitch(element);
	}
	public String getDatabaseElementLabel(DatabaseElement element) {
		return doSwitch(element);
	}

	@Override
	public String caseColumn(Column column) {
		String label = caseNamedElement(column);
		label += " : ";
		String typeLabel = "undefined";
		if (column.getType() != null) {
			typeLabel = adapterFactoryLabelProvider.getText(column.getType());
		}

		label += typeLabel;
		if (!column.getIndexes().isEmpty() && diagram !=null 
				&& isIndexLayerActive(diagram.getOwnedDiagramElements().get(0))){
			String indexesLabel = "    <";
			boolean isFirst = true;
			for (Index index : column.getIndexes()){
				EList<Index> indexes = index.getOwner().getIndexes();
				int i = indexes.indexOf(index)+1;
				if (isFirst == true){
					indexesLabel += "i"+ i;
					isFirst = false;
				}else{
					indexesLabel +=", i"+i;
				}
			}
			indexesLabel += ">";
			label += indexesLabel;
		}
		return label;
	}

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}

	public String caseIndex(Index index) {
		String label = index.getName();
		EList<Index> indexes = index.getOwner().getIndexes();
		int i = indexes.indexOf(index)+1;
		label += "    <i"+ i+">";
		return label;
	}

	private boolean isIndexLayerActive(DDiagramElement diagramElement) {
		final DDiagram diagram = diagramElement.getParentDiagram();
		for (final Layer activeLayer : diagram.getActivatedLayers()) {
			if ("Index".equals(activeLayer.getName())) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	public String getViewElementLabel(ViewElement viewElement){
		String label = viewElement.getName();
		if (viewElement.getAlias()!= null && !viewElement.getAlias().isEmpty()){
			label+= " \u2190 "+viewElement.getAlias();
		}
		return label;
	} 
}
