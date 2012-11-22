package org.obeonetwork.sample.demo.weblogng.ui.users.actions;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.obeonetwork.sample.demo.weblogng.ui.users.forms.LoginForm;


import org.obeonetwork.sample.demo.weblogng.user.IUserService;
import org.obeonetwork.sample.demo.weblogng.users.User;


// End of user code for import


/**
 * Implementation of <strong>Login Action</strong>
 * Scenario : Login
 *
 */
public class LoginAction extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(LoginAction.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
	public final static String PAGE_CREATEACCOUNT = "createAccount"; //$NON-NLS-1$
	public final static String PAGE_VIEWLOGS = "viewLogs"; //$NON-NLS-1$
	public final static String PAGE_ERRORS = "errors"; //$NON-NLS-1$
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
		LoginForm loginForm = (LoginForm)form;

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
     * Process the specified HTTP request for <strong>createAccount</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward createAccount(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting createAccount");
		String returnCode = PAGE_SELF;
		LoginForm loginForm = (LoginForm)form;
		
		//Start of user code method createAccount
		returnCode = PAGE_CREATEACCOUNT;
		//End of user code

		LOG.debug("End createAccount");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>validate</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward validate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting validate");
		String returnCode = PAGE_SELF;
		LoginForm loginForm = (LoginForm)form;
		
		//Start of user code method validate
		User user = userService.login(loginForm.getLogin(), loginForm.getPassword());
		if (user != null) {
			request.setAttribute("user", user);
			returnCode = PAGE_VIEWLOGS;
		} else {
			returnCode = PAGE_ERRORS;
		}
		//End of user code

		LOG.debug("End validate");
		return mapping.findForward(returnCode);
	}

private IUserService userService;
public void setUserService(IUserService userService){
	this.userService = userService;
}


//Start of user code user methods
//End of user code

}