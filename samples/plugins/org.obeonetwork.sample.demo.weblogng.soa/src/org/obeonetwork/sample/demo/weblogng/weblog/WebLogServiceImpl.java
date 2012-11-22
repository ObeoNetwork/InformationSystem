package org.obeonetwork.sample.demo.weblogng.weblog;

//Start of user code for import

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;
import org.obeonetwork.sample.demo.weblogng.informations.Comment;

import org.obeonetwork.sample.demo.weblogng.grant.IGrantService;	
import org.obeonetwork.sample.demo.weblogng.user.IUserService;	
import org.obeonetwork.sample.demo.weblogng.search.ISearchService;	
import org.obeonetwork.sample.demo.weblogng.informations.ITagDao;	
import org.obeonetwork.sample.demo.weblogng.informations.ICommentDao;	
import org.obeonetwork.sample.demo.weblogng.users.IUserDao;	
import org.obeonetwork.sample.demo.weblogng.informations.ICategoryDao;	
import org.obeonetwork.sample.demo.weblogng.blog.IBlogEntryDao;	


public class WebLogServiceImpl implements IWebLogService {
    public Collection<BlogEntry> getAllBlogEntries() throws ServiceException{
    	// Start of user code of getAllBlogEntries        
    	try {
			return blogEntryDao.findAllBlogEntrys();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
    	// End of user code        
    }
    
    public void addBlogEntry(BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addBlogEntry        
    	try {
			blogEntryDao.createBlogEntry(blogEntry);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
    	// End of user code        
    }
    
    public void removeBlogEntry(BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of removeBlogEntry        
    	
    	// End of user code        
    }
    
    public BlogEntry getBlogEntry(String id) throws ServiceException{
    	// Start of user code of getBlogEntry        
    	return null;
    	// End of user code        
    }
    
    public void addComment(Comment comment, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addComment        
    	
    	// End of user code        
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
	
    private ITagDao tagDao;
    public void setTagDao(ITagDao tagDao){
    	this.tagDao = tagDao;
    }
    	
    private ICommentDao commentDao;
    public void setCommentDao(ICommentDao commentDao){
    	this.commentDao = commentDao;
    }
    	
    private IUserDao userDao;
    public void setUserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
    	
    private ICategoryDao categoryDao;
    public void setCategoryDao(ICategoryDao categoryDao){
    	this.categoryDao = categoryDao;
    }
    	
    private IBlogEntryDao blogEntryDao;
    public void setBlogEntryDao(IBlogEntryDao blogEntryDao){
    	this.blogEntryDao = blogEntryDao;
    }
    	
    

}

