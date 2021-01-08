/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.ui.selector;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionService;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSessionService;

/**
 * A {@link SessionListener} used to change the DAnalysisSelector of any opened
 * Session.
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 * 
 */
public class UpdateDAnalysisSelectorSessionListener extends SessionManagerListener.Stub {

    @Override
    public void notifyAddSession(Session newSession) {
    	if (newSession instanceof DAnalysisSession) {
            // If a new session is opened, modify its DAnalysisSelector
            DAnalysisSelector originalSelector = getOriginalAnalysisSelector(newSession);
            if (originalSelector != null) {
            	((DAnalysisSession) newSession).setAnalysisSelector(new CreateTablesAndTreesLocallyDAnalysisSelector(originalSelector));
            }
        }
    }

    /**
     * Retrieve the current analysis selector for the provide session
     * Use reflection to access the analysis selector
     * @param session
     * @return
     */
    private DAnalysisSelector getOriginalAnalysisSelector(Session session) {
    	SessionService services = session.getServices();
    	if (services instanceof DAnalysisSessionService) {
    		try {
    			java.lang.reflect.Field f = services.getClass().getDeclaredField("analysisSelector");
    			f.setAccessible(true);
				Object analysisSelector = f.get(services);
				if (analysisSelector instanceof DAnalysisSelector) {
					return (DAnalysisSelector)analysisSelector;
				}
			} catch (Exception e) {
				// Do nothing
			}
    	}
    	return null;
    }


}
