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
package org.obeonetwork.graal.design.services.configuration;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.obeonetwork.graal.design.extension.GraalFeatureExtension;
import org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsFactory;
import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;

import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DAnalysisSessionEObject;
import org.eclipse.sirius.viewpoint.DFeatureExtension;
import org.eclipse.sirius.business.api.featureextensions.FeatureExtensionsManager;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;

/**
 * Services to handle user preferences about Graal UI 
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 */
public class UIConfigurationServices {

	/**
	 * Get an existing UI configuration on the specified analysis
	 * or null if none already exists
	 * @param analysis Viewpoint analysis used to store the configuration
	 * @return existing UIConfiguration or null 
	 */
	public static UIConfiguration getUIConfigurationOnlyIfExisting(DAnalysis analysis) {
		if (analysis != null) {
			// Get all Graal Feature Extensions
			Session session = getSessionFromAnalysis(analysis);
			Collection<UIConfiguration> uiConfigurations = getAllGraalUIConfigurations(session);
			if (uiConfigurations != null) {
				for (UIConfiguration configuration : uiConfigurations) {
					// Filter on the analysis
					if (analysis.equals(configuration.getViewpointAnalysis())) {
						return configuration;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Get an existing UI configuration on the specified analysis
	 * or create a new one if none already exists
	 * @param analysis Viewpoint analysis used to store the configuration
	 * @return existing or new UIConfiguration
	 */
	public static UIConfiguration getUIConfiguration(DAnalysis analysis) {
		UIConfiguration configuration = getUIConfigurationOnlyIfExisting(analysis);
		if (configuration == null) {
			// No existing configuration found, we have to create a new one
			configuration = GraalfeatureextensionsFactory.eINSTANCE.createUIConfiguration();
			configuration.setViewpointAnalysis(analysis);
		}
		return configuration;			
	}
	
	
	/**
	 * Save the configuration on the specified viewpoint analysis
	 * @param configuration Configuration to be saved
	 * @param analysis Viewpoint analysis concerned by the configuration
	 */
	public static void saveUIConfiguration(final UIConfiguration configuration, final DAnalysis analysis) {
		if (!analysis.equals(configuration.getViewpointAnalysis())) {
			configuration.setViewpointAnalysis(analysis);
		}
		
		final Session session = getSessionFromAnalysis(analysis);
		if (session != null) {
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(analysis); 
			final Command cmd = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					FeatureExtensionsManager.INSTANCE.saveFeatureExtensionData(
							GraalFeatureExtension.FEATURE_EXTENSION_NAME,
							session,
							analysis,
							configuration);
				}
			};
			domain.getCommandStack().execute(cmd);
		}
		
	}
	
	/**
	 * Get all UI configurations stored in session
	 * @param session Viewpoint session
	 * @return Collection of UIConfiguration instances
	 */
	@SuppressWarnings("unchecked")
	private static Collection<UIConfiguration> getAllGraalUIConfigurations(Session session) {
		if (session != null) {
			Collection<? extends DFeatureExtension> data = FeatureExtensionsManager.INSTANCE.retrieveFeatureExtensionData(GraalFeatureExtension.FEATURE_EXTENSION_NAME, session);
			if (data != null) {
				return (Collection<UIConfiguration>)data;
			}
		}
		return null;
	}
	
	/**
	 * Retrieves the session corresponding to the specified viewpoint analysis
	 * @param analysis Viewpoint analysis
	 * @return Viewpoint session or null if no corresponding session has been found 
	 */
	private static Session getSessionFromAnalysis(DAnalysis analysis) {
		// Retrieve the session using EObjectQuery
		EObjectQuery query = new EObjectQuery(analysis);
		Session existingSession = query.getSession();
		if (existingSession != null) {
			return existingSession;
		}
		// If it did not work, let's inspect the existing sessions
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			if (session instanceof DAnalysisSessionEObject) {
				DAnalysisSessionEObject analysisSession = (DAnalysisSessionEObject)session;
				for (DAnalysis sessionAnalysis : analysisSession.getAnalyses()) {
					if (EcoreUtil.equals(analysis, sessionAnalysis)) {
						return session;
					}
				}
			}
		}
		return null;
	}
}
