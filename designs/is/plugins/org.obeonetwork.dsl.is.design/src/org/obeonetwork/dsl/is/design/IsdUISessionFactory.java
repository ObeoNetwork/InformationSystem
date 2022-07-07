package org.obeonetwork.dsl.is.design;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.factory.UISessionFactory;
import org.eclipse.sirius.ui.business.internal.session.EditingSession;
import org.eclipse.ui.progress.IJobRunnable;

/**
 * Workaround to https://github.com/eclipse-platform/eclipse.platform.ui/issues/173
 * causing a closing confirmation dialog to show when saving.
 * 
 * This fix forces the save to run synchronously. See bug description for details.
 *
 */
@SuppressWarnings("restriction")
public class IsdUISessionFactory implements UISessionFactory {

	@Override
	public IEditingSession createUISession(Session session) {
		return new IsdEditingSession(session);
	}

	class IsdEditingSession extends fr.obeo.dsl.viewpoint.collab.ui.internal.session.UICollaborativeSessionImpl {

		public IsdEditingSession(Session session) {
			super(session);
			this.saveable = new IsdSessionSaveable(this);
		}
	}

	class IsdSessionSaveable extends fr.obeo.dsl.viewpoint.collab.ui.internal.session.UICollaborativeSessionSaveable { 

		public IsdSessionSaveable(EditingSession uiSession) {
			super(uiSession);
		}

		@Override
		public IJobRunnable doSave(IProgressMonitor monitor, IShellProvider shellProvider) throws CoreException {
			doSave(monitor);
			return null;
		}
	}
	
}
