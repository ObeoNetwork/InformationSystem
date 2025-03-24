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
package org.obeonetwork.dsl.cinematic.design.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.utils.common.StringUtils;

public class CinematicVCDLabelServices {

	public static String getVCDLabel(ViewElement viewElement) {
		
		if(!StringUtils.isNullOrWhite(viewElement.getLabel())) {
			return viewElement.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewElement.getName())) {
			return viewElement.getName();
		}
		
		return StringUtils.EMPTY_STRING;
		
	}
	
	public static String getVCDLabel(ViewContainer viewContainer) {
		
		if(!StringUtils.isNullOrWhite(viewContainer.getLabel())) {
			return viewContainer.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewContainer.getName())) {
			return viewContainer.getName();
		}
		
		return StringUtils.EMPTY_STRING;
	}
	
	public static String getVCDLabel(ViewContainerReference viewContainerReference) {
		
		if(!StringUtils.isNullOrWhite(viewContainerReference.getLabel())) {
			return viewContainerReference.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewContainerReference.getName())) {
			return viewContainerReference.getName();
		}
		
		return getVCDLabel(viewContainerReference.getViewContainer());
	}
			
	/**
	 * Evaluate the expression defined by the exampleExpression attribute defined in the toolkit model used by the {@link AbstractViewElement}. 
	 * @param abstractViewElement an {@link AbstractViewElement}.
	 * @return a {@link String} produced by the evaluation of the exampleExpression, or the name of the {@link AbstractViewElement} it the query cannot be evaluated.
	 */
	public static String evaluateExampleExpression(AbstractViewElement abstractViewElement) {
		Style s = abstractViewElement.getWidget().getStyle();
		if (s != null) {
			
			String exampleExpression = s.getExampleExpression();
			if (!StringUtils.isNullOrWhite(exampleExpression)) {
				
				try {
					Object output = new EObjectQuery(abstractViewElement).getSession().getInterpreter().evaluate(abstractViewElement, exampleExpression);
					if (output != null)
						return output.toString();
				} catch (EvaluationException e) {					 
					e.printStackTrace();
				}				
			}
		}
		
		return abstractViewElement.getName();
	}
	
	public static AbstractViewElement getNextTabElement(AbstractViewElement element) {
		AbstractViewElement nextTabElement = null;
		if(element.eContainingFeature() == ViewPackage.eINSTANCE.getViewContainer_OwnedElements()) {
			ViewContainer parentViewContainer = (ViewContainer) element.eContainer();
			EList<AbstractViewElement> ownedElements = parentViewContainer.getOwnedElements();
			int nextIndex = ownedElements.indexOf(element) + 1;
			if(nextIndex < ownedElements.size()) {
				nextTabElement = ownedElements.get(nextIndex);
			}
		}
		return nextTabElement;
	}
	
}
