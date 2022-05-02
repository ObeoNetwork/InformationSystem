package org.obeonetwork.utils.sirius.services;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.diagram.DiagramPlugin;
import org.eclipse.sirius.diagram.ui.part.ValidateAction;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

public class SiriusUtils {

    public static void validateDDiagramEditor(DDiagramEditor dDiagramEditor) {
    	
        if (dDiagramEditor instanceof IDiagramWorkbenchPart) {
            final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) dDiagramEditor;
            if(part.getDiagramEditPart() != null) {
                try {
                    new WorkspaceModifyDelegatingOperation(new IRunnableWithProgress() {

                        @Override
                        public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
                            ValidateAction.runValidation(part.getDiagramEditPart(), part.getDiagram());
                        }
                    }).run(new NullProgressMonitor());
                } catch (Exception e) {
                    DiagramPlugin.getDefault().logError(org.eclipse.sirius.diagram.ui.provider.Messages.ValidateAction_failureMessage, e);
                }
            }
        }
    }
	
}
