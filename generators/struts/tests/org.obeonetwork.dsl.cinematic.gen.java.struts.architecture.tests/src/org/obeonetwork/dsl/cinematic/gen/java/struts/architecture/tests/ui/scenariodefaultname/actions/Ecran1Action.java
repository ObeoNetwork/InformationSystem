package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.actions;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.forms.Ecran1Form;




// End of user code for import


/**
 * Implementation of <strong>Ecran1 Action</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class Ecran1Action extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(Ecran1Action.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
	public final static String PAGE_ECRAN2 = "ecran2"; //$NON-NLS-1$
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
		Ecran1Form ecran1Form = (Ecran1Form)form;

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
		Ecran1Form ecran1Form = (Ecran1Form)form;
		
		//Start of user code method Action1
		// TODO Write here the action code for action1
		//End of user code

		LOG.debug("End action1");
		return mapping.findForward(returnCode);
	}



//Start of user code user methods
//End of user code

}