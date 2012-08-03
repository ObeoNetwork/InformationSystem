package org.obeonetwork.sample.ui.users.actions;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.blog.IUserDao;
import org.obeonetwork.sample.blog.User;
import org.obeonetwork.sample.ui.UiConstants;
import org.obeonetwork.sample.ui.users.forms.EditAccountForm;




// End of user code for import


/**
 * Implementation of <strong>EditAccount Action</strong>
 * Scenario : EditAccount
 *
 */
public class EditAccountAction extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(EditAccountAction.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
	public final static String PAGE_VIEWLOGS = "viewLogs"; //$NON-NLS-1$
//Start of user code user attributes
	private IUserDao userDao;
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
		EditAccountForm editAccountForm = (EditAccountForm)form;

		//Start of user code method init
		User user = (User)request.getSession().getAttribute(UiConstants.CURRENT_USER);
		// Recuperation DAO sur table Users

		User findByLoginAndPassword = userDao.findByLoginAndPassword(user.getLogin(), user.getPassword());
		
		editAccountForm.setFirstName(findByLoginAndPassword.getFirstName());
		editAccountForm.setLastName(findByLoginAndPassword.getLastName());
		editAccountForm.setEmail(findByLoginAndPassword.getEmail());
		editAccountForm.setLogin(findByLoginAndPassword.getLogin());
		editAccountForm.setPassword(findByLoginAndPassword.getPassword());
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
		EditAccountForm editAccountForm = (EditAccountForm)form;
		
		//Start of user code method validate
		User user = (User)request.getSession().getAttribute(UiConstants.CURRENT_USER);
		
		// Recuperation DAO sur table Users

		user = userDao.findByLoginAndPassword(user.getLogin(), user.getPassword());
			
		user.setFirstName(editAccountForm.getFirstName());
		user.setLastName(editAccountForm.getLastName());
		user.setEmail(editAccountForm.getEmail());
		user.setPassword(editAccountForm.getPassword());

		userDao.updateUser(user);

		request.getSession().setAttribute(UiConstants.CURRENT_USER, user);

		returnCode = PAGE_VIEWLOGS;
		//End of user code

		LOG.debug("End validate");
		return mapping.findForward(returnCode);
	}



//Start of user code user methods
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

//End of user code

}