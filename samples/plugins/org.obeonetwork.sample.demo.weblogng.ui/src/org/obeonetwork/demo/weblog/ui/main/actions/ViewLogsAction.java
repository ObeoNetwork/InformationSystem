package org.obeonetwork.demo.weblog.ui.main.actions;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import org.obeonetwork.demo.weblog.ui.UiConstants;
import org.obeonetwork.demo.weblog.ui.main.forms.ViewLogsForm;
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;
import org.obeonetwork.demo.weblogng.business.users.User;
import org.obeonetwork.demo.weblogng.business.weblog.IWebLogService;
import org.obeonetwork.weblog.dto.BlogEntryDto;


// End of user code for import


/**
 * Implementation of <strong>ViewLogs Action</strong>
 * Scenario : ViewLogs
 *
 */
public class ViewLogsAction extends org.apache.struts.actions.DispatchAction {
    /**
     * Commons Logging instance.
     */
     private final static Log LOG = LogFactory.getLog(ViewLogsAction.class);

    /**
     * Forward codes.
     */
	public final static String PAGE_SELF = "self"; //$NON-NLS-1$
	public final static String PAGE_LOGIN = "login"; //$NON-NLS-1$
	public final static String PAGE_CREATELOG = "createLog"; //$NON-NLS-1$
	public final static String PAGE_VIEWCOMMENTS = "viewComments"; //$NON-NLS-1$
	public final static String PAGE_EDITACCOUNT = "editAccount"; //$NON-NLS-1$
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
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;

		//Start of user code method init
		this.getLogs(viewLogsForm);
		
		User user= (User)request.getSession().getAttribute(UiConstants.CURRENT_USER);
		if (user != null) 
			viewLogsForm.setUser(user.getFirstName() +" " + user.getLastName());

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
     * Process the specified HTTP request for <strong>viewComments</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward viewComments(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting viewComments");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method viewComments
		// TODO Write here the action code for viewComments		
		//End of user code

		LOG.debug("End viewComments");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>editAccount</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward editAccount(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting editAccount");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method editAccount
		User user= (User)request.getSession().getAttribute(UiConstants.CURRENT_USER);
		if (user != null) 
			returnCode = PAGE_EDITACCOUNT;
		else
			this.getLogs(viewLogsForm);
		//End of user code

		LOG.debug("End editAccount");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>login</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting login");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method login
		returnCode = PAGE_LOGIN;
		//End of user code

		LOG.debug("End login");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>reload</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward reload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting reload");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method reload
		this.init(mapping, form, request,response);
		//End of user code

		LOG.debug("End reload");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>addComment</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward addComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting addComment");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method addComment
		// TODO Write here the action code for addComment		
		//End of user code

		LOG.debug("End addComment");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>logout</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting logout");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method logout
		request.getSession().setAttribute(UiConstants.CURRENT_USER, null);
		viewLogsForm.setUser(null);
		this.getLogs(viewLogsForm);
		//End of user code

		LOG.debug("End logout");
		return mapping.findForward(returnCode);
	}
    /**
     * Process the specified HTTP request for <strong>createLog</strong> event.
     * 
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public ActionForward createLog(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Starting createLog");
		String returnCode = PAGE_SELF;
		ViewLogsForm viewLogsForm = (ViewLogsForm)form;
		
		//Start of user code method createLog
		User user= (User)request.getSession().getAttribute(UiConstants.CURRENT_USER);
		if (user != null) 
			returnCode = PAGE_CREATELOG;
		else
			this.getLogs(viewLogsForm);		
		//End of user code

		LOG.debug("End createLog");
		return mapping.findForward(returnCode);
	}

private IWebLogService webLogService;
public void setWebLogService(IWebLogService webLogService){
	this.webLogService = webLogService;
}


//Start of user code user methods
	private void getLogs(ViewLogsForm viewLogsForm) throws ServiceException{
		// Recuperation DAO sur table Users
		Collection<BlogEntry> listBlogs = webLogService.getAllBlogEntries();
		if(listBlogs!=null){
			Collection<BlogEntryDto> listBlogDtos = new ArrayList<BlogEntryDto>(listBlogs.size());
			Iterator<?> blogsIterator=listBlogs.iterator();
			while(blogsIterator.hasNext()){
				BlogEntry blog = (BlogEntry)blogsIterator.next();
				BlogEntryDto blogDto = new BlogEntryDto(blog);
				listBlogDtos.add(blogDto);
			}
			viewLogsForm.setLogs(listBlogDtos);
		}
	}
//End of user code

}