package org.obeonetwork.sample.ui.grant.actions;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.obeonetwork.sample.ui.grant.forms.GrantModerateForm;


import org.obeonetwork.sample.user.IUserService;
import org.obeonetwork.sample.grant.IGrantService;
import org.obeonetwork.sample.monitor.IMonitorService;


// End of user code for import


/**
 * Implementation of <strong>GrantModerate Action</strong>
 * Scenario : Grant
 *
 */
public class GrantModerateAction extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(GrantModerateAction.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
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
		GrantModerateForm grantModerateForm = (GrantModerateForm)form;

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
     * Process the specified HTTP request for <strong>showUsers</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward showUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting showUsers");
		String returnCode = PAGE_SELF;
		GrantModerateForm grantModerateForm = (GrantModerateForm)form;
		
		//Start of user code method showUsers
		// TODO Write here the action code for showUsers		
		//End of user code

		LOG.debug("End showUsers");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>removeRight</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward removeRight(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting removeRight");
		String returnCode = PAGE_SELF;
		GrantModerateForm grantModerateForm = (GrantModerateForm)form;
		
		//Start of user code method removeRight
		// TODO Write here the action code for removeRight		
		//End of user code

		LOG.debug("End removeRight");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>showModerators</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward showModerators(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting showModerators");
		String returnCode = PAGE_SELF;
		GrantModerateForm grantModerateForm = (GrantModerateForm)form;
		
		//Start of user code method showModerators
		// TODO Write here the action code for showModerators		
		//End of user code

		LOG.debug("End showModerators");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>addRight</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward addRight(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting addRight");
		String returnCode = PAGE_SELF;
		GrantModerateForm grantModerateForm = (GrantModerateForm)form;
		
		//Start of user code method addRight
		// TODO Write here the action code for addRight		
		//End of user code

		LOG.debug("End addRight");
		return mapping.findForward(returnCode);
	}

private IUserService userService;
public void setUserService(IUserService userService){
	this.userService = userService;
}
private IMonitorService monitorService;
public void setMonitorService(IMonitorService monitorService){
	this.monitorService = monitorService;
}
private IGrantService grantService;
public void setGrantService(IGrantService grantService){
	this.grantService = grantService;
}


//Start of user code user methods
//End of user code

}