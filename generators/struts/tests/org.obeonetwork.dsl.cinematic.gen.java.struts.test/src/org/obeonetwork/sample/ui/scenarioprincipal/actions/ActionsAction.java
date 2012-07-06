package org.obeonetwork.sample.ui.scenarioprincipal.actions;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.obeonetwork.sample.ui.scenarioprincipal.forms.ActionsForm;


 

// End of user code for import


/**
 * Implementation of <strong>Actions Action</strong>
 * Scenario : Scenario Principal
 *
 */
public class ActionsAction extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(ActionsAction.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
	public final static String PAGE_ALL_IN_ONE = "allInOne"; //$NON-NLS-1$
//Start of user code user attributes
//End of user code
    /**
     * Process the specified HTTP request for <strong>init</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return Forward setting with indirection forward name (see struts-config for real JSP name)
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting init");
		String returnCode = PAGE_SELF;
		ActionsForm actionsForm = (ActionsForm)form;

		//Start of user code method init
		// TODO Write here the action code for init
		//End of user code

		LOG.debug("End init");	
		return mapping.findForward(returnCode);
	} 

    /**
     * Process if no event specified. Redirect to init.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return Forward setting with indirection forward name (see struts-config for real JSP name)
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("No event specified. Redirect to init.");
		return init(mapping, form, request, response);
	} 

    /**
     * Process the specified HTTP request for <strong>action1</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward action1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting action1");
		String returnCode = PAGE_SELF;
		ActionsForm actionsForm = (ActionsForm)form;
		
		//Start of user code method action1
		// TODO Write here the action code for action1
		//End of user code

		LOG.debug("End action1");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>mon Action</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward monAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting mon Action");
		String returnCode = PAGE_SELF;
		ActionsForm actionsForm = (ActionsForm)form;
		
		//Start of user code method mon Action
		// TODO Write here the action code for mon Action
		//End of user code

		LOG.debug("End mon Action");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>monAutreAction</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward monAutreAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting monAutreAction");
		String returnCode = PAGE_SELF;
		ActionsForm actionsForm = (ActionsForm)form;
		
		//Start of user code method MonAutreAction
		// TODO Write here the action code for monAutreAction
		//End of user code

		LOG.debug("End monAutreAction");
		return mapping.findForward(returnCode);
	}



//Start of user code user methods
//End of user code

}