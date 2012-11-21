package org.obeonetwork.sample.demo.weblogng.business.search;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.business.blog.BlogEntry;
import org.obeonetwork.sample.demo.weblogng.business.informations.Comment;

import org.obeonetwork.sample.demo.weblogng.business.informations.ICommentDao;	
import org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao;	
import org.obeonetwork.sample.demo.weblogng.business.informations.ITagDao;	
import org.obeonetwork.sample.demo.weblogng.business.informations.ICategoryDao;	


public class SearchServiceImpl implements ISearchService {
    public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException{
    	// Start of user code of searchBlogEntries        
    	return null;
    	// End of user code        
    }
    
    public Collection<Comment> searchComments(String searchContent) throws ServiceException{
    	// Start of user code of searchComments        
    	return null;
    	// End of user code        
    }
    
	
    private ICommentDao commentDao;
    public void setCommentDao(ICommentDao commentDao){
    	this.commentDao = commentDao;
    }
    	
    private IBlogEntryDao blogEntryDao;
    public void setBlogEntryDao(IBlogEntryDao blogEntryDao){
    	this.blogEntryDao = blogEntryDao;
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

