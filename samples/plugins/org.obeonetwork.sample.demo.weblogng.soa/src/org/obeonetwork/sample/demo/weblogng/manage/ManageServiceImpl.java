package org.obeonetwork.sample.demo.weblogng.manage;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.informations.Comment;
import org.obeonetwork.sample.demo.weblogng.users.User;
import org.obeonetwork.sample.demo.weblogng.informations.Category;
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;
import org.obeonetwork.sample.demo.weblogng.informations.Tag;

import org.obeonetwork.sample.demo.weblogng.grant.IGrantService;	
import org.obeonetwork.sample.demo.weblogng.user.IUserService;	
import org.obeonetwork.sample.demo.weblogng.search.ISearchService;	
import org.obeonetwork.sample.demo.weblogng.informations.ITagDao;	
import org.obeonetwork.sample.demo.weblogng.informations.ICommentDao;	
import org.obeonetwork.sample.demo.weblogng.users.IUserDao;	
import org.obeonetwork.sample.demo.weblogng.informations.ICategoryDao;	
import org.obeonetwork.sample.demo.weblogng.blog.IBlogEntryDao;	


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

