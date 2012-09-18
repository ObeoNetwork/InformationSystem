package org.obeonetwork.demo.weblogng.business.manage;

//Start of user code for import

import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.informations.Comment;
import org.obeonetwork.demo.weblogng.business.users.User;
import org.obeonetwork.demo.weblogng.business.informations.Category;
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;
import org.obeonetwork.demo.weblogng.business.informations.Tag;

import org.obeonetwork.demo.weblogng.business.grant.IGrantService;	
import org.obeonetwork.demo.weblogng.business.user.IUserService;	
import org.obeonetwork.demo.weblogng.business.search.ISearchService;	
import org.obeonetwork.demo.weblogng.business.blog.IBlogEntryDao;	
import org.obeonetwork.demo.weblogng.business.informations.ICategoryDao;	
import org.obeonetwork.demo.weblogng.business.informations.ICommentDao;	
import org.obeonetwork.demo.weblogng.business.informations.ITagDao;	
import org.obeonetwork.demo.weblogng.business.users.IUserDao;	


public class ManageServiceImpl implements IManageService {
    public void deleteComment(Comment comment) throws ServiceException{
    	// Start of user code of deleteComment        
    	
    	// End of user code        
    }
    
    public void deleteUser(User user) throws ServiceException{
    	// Start of user code of deleteUser        
    	
    	// End of user code        
    }
    
    public void updateComment(Comment comment) throws ServiceException{
    	// Start of user code of updateComment        
    	
    	// End of user code        
    }
    
    public void createCategory(Category category) throws ServiceException{
    	// Start of user code of createCategory        
    	
    	// End of user code        
    }
    
    public void deleteCategory(Category category) throws ServiceException{
    	// Start of user code of deleteCategory        
    	
    	// End of user code        
    }
    
    public void removeCategory(Category category, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of removeCategory        
    	
    	// End of user code        
    }
    
    public void updateCategory(Category category) throws ServiceException{
    	// Start of user code of updateCategory        
    	
    	// End of user code        
    }
    
    public void addCategory(Category category, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addCategory        
    	
    	// End of user code        
    }
    
    public void deleteTag(Tag tag) throws ServiceException{
    	// Start of user code of deleteTag        
    	
    	// End of user code        
    }
    
    public void removeTag(Tag tag, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of removeTag        
    	
    	// End of user code        
    }
    
    public void updateTag(Tag tag) throws ServiceException{
    	// Start of user code of updateTag        
    	
    	// End of user code        
    }
    
    public void addTag(Tag tag, BlogEntry blogEntry) throws ServiceException{
    	// Start of user code of addTag        
    	
    	// End of user code        
    }
    
    public void createTag(Tag tag) throws ServiceException{
    	// Start of user code of createTag        
    	
    	// End of user code        
    }
    
    public Comment getComment(String id) throws ServiceException{
    	// Start of user code of getComment        
    	return null;
    	// End of user code        
    }
    
    public Category getCategory(String id) throws ServiceException{
    	// Start of user code of getCategory        
    	return null;
    	// End of user code        
    }
    
    public Tag getTag(String id) throws ServiceException{
    	// Start of user code of getTag        
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

