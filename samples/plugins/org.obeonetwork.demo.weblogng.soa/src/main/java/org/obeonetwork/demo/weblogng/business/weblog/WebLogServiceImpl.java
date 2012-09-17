package org.obeonetwork.demo.weblogng.business.weblog;

//Start of user code for import

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;
import org.obeonetwork.demo.weblogng.business.informations.Comment;

import org.obeonetwork.demo.weblogng.business.grant.IGrantService;	
import org.obeonetwork.demo.weblogng.business.user.IUserService;	
import org.obeonetwork.demo.weblogng.business.search.ISearchService;	
import org.obeonetwork.demo.weblogng.business.blog.IBlogEntryDao;	
import org.obeonetwork.demo.weblogng.business.informations.ICategoryDao;	
import org.obeonetwork.demo.weblogng.business.informations.ICommentDao;	
import org.obeonetwork.demo.weblogng.business.informations.ITagDao;	
import org.obeonetwork.demo.weblogng.business.users.IUserDao;	


public class WebLogServiceImpl implements IWebLogService {
    public Collection<BlogEntry> getAllBlogEntries() throws ServiceException{
    	// Start of user code of getAllBlogEntries        
	try {
		return blogEntryDao.findAllBlogEntrys();
	} catch (DaoException e) {
		throw new ServiceException(e);
	}
	// End of user code of getAllBlogEntries
    }
    
    public void addBlogEntry(BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addBlogEntry        
		try {
			blogEntryDao.createBlogEntry(blogEntry);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of addBlogEntry
    }
    
    public void removeBlogEntry(BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of removeBlogEntry        
    	try {
			blogEntryDao.deleteBlogEntry(blogEntry);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of removeBlogEntry
    }
    
    public BlogEntry getBlogEntry(String id) throws ServiceException{
    	// Start of user code of getBlogEntry        
    	try {
			return blogEntryDao.findBlogEntryById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of getBlogEntry        
    }
    
    public void addComment(Comment comment, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addComment        
    	try {
			BlogEntry entry = blogEntryDao.findBlogEntryById(blogEntry.getId());
			entry.addComments(comment);
			blogEntryDao.updateBlogEntry(entry);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of addComment       
    }
    
    private IGrantService grantService;
    public void setGrantService(IGrantService grantService){
	    this.grantService = grantService;
    }			
    private IUserService userService;
    public void setUserService(IUserService userService){
	    this.userService = userService;
    }			
    private ISearchService searchService;
    public void setSearchService(ISearchService searchService){
	    this.searchService = searchService;
    }			
	
    private IBlogEntryDao blogEntryDao;
    public void setBlogEntryDao(IBlogEntryDao blogEntryDao){
    	this.blogEntryDao = blogEntryDao;
    }
    	
    private ICategoryDao categoryDao;
    public void setCategoryDao(ICategoryDao categoryDao){
    	this.categoryDao = categoryDao;
    }
    	
    private ICommentDao commentDao;
    public void setCommentDao(ICommentDao commentDao){
    	this.commentDao = commentDao;
    }
    	
    private ITagDao tagDao;
    public void setTagDao(ITagDao tagDao){
    	this.tagDao = tagDao;
    }
    	
    private IUserDao userDao;
    public void setUserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
    	
    

}

