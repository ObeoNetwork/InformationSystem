package org.obeonetwork.sample.search;

// Start of user code for import

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ITagDao;
import java.util.Collection;

// End of user code for import

import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;



import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ITagDao;


public class SearchServiceImpl implements ISearchService{
	public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException{
	// Start of user code of searchBlogEntries
	return null;
	// End of user code of searchBlogEntries
	}
	
	public Collection<Comment> searchComments(String searchContent) throws ServiceException{
	// Start of user code of searchComments
	return null;
	// End of user code of searchComments
	}
	
	

	private IBlogEntryDao blogEntryDao;
	public void setBlogEntryDao(IBlogEntryDao blogEntryDao){
		this.blogEntryDao=blogEntryDao;
	}
	private ICommentDao commentDao;
	public void setCommentDao(ICommentDao commentDao){
		this.commentDao=commentDao;
	}
	private ICategoryDao categoryDao;
	public void setCategoryDao(ICategoryDao categoryDao){
		this.categoryDao=categoryDao;
	}
	private ITagDao tagDao;
	public void setTagDao(ITagDao tagDao){
		this.tagDao=tagDao;
	}

	
}