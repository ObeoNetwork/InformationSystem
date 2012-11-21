package org.obeonetwork.sample.demo.weblogng.business.monitor;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.business.users.User;
import org.obeonetwork.sample.demo.weblogng.business.informations.Tag;
import org.obeonetwork.sample.demo.weblogng.business.informations.Category;
import org.obeonetwork.sample.demo.weblogng.business.informations.Comment;

import org.obeonetwork.sample.demo.weblogng.business.grant.IGrantService;	
import org.obeonetwork.sample.demo.weblogng.business.user.IUserService;	
import org.obeonetwork.sample.demo.weblogng.business.search.ISearchService;	
import org.obeonetwork.sample.demo.weblogng.business.users.IUserDao;	
import org.obeonetwork.sample.demo.weblogng.business.informations.ICommentDao;	
import org.obeonetwork.sample.demo.weblogng.business.informations.ITagDao;	
import org.obeonetwork.sample.demo.weblogng.business.informations.ICategoryDao;	


public class MonitorServiceImpl implements IMonitorService {
    public Collection<User> getAllUsers() throws ServiceException{
    	// Start of user code of getAllUsers        
    	return null;
    	// End of user code        
    }
    
    public Collection<Tag> getAllTags() throws ServiceException{
    	// Start of user code of getAllTags        
    	return null;
    	// End of user code        
    }
    
    public Collection<Category> getAllCategories() throws ServiceException{
    	// Start of user code of getAllCategories        
    	return null;
    	// End of user code        
    }
    
    public Collection<Comment> getAllComments() throws ServiceException{
    	// Start of user code of getAllComments        
    	return null;
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
	
    private IUserDao userDao;
    public void setUserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
    	
    private ICommentDao commentDao;
    public void setCommentDao(ICommentDao commentDao){
    	this.commentDao = commentDao;
    }
    	
    private ITagDao tagDao;
    public void setTagDao(ITagDao tagDao){
    	this.tagDao = tagDao;
    }
    	
    private ICategoryDao categoryDao;
    public void setCategoryDao(ICategoryDao categoryDao){
    	this.categoryDao = categoryDao;
    }
    	
    

}

