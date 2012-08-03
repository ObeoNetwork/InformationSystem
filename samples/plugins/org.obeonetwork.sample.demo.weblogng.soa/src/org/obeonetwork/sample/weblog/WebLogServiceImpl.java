package org.obeonetwork.sample.weblog;

// Start of user code for import

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ITagDao;
import org.obeonetwork.sample.users.IUserDao;

import java.util.Collection;

// End of user code for import

import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;


import org.obeonetwork.sample.search.ISearchService;
import org.obeonetwork.sample.user.IUserService;
import org.obeonetwork.sample.grant.IGrantService;

import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ITagDao;
import org.obeonetwork.sample.users.IUserDao;


public class WebLogServiceImpl implements IWebLogService{
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
	
	public void addComment(Comment comment,BlogEntry blogEntry) throws ServiceException{
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
	
	public BlogEntry getBlogEntry(String id) throws ServiceException{
	// Start of user code of getBlogEntry
		try {
			return blogEntryDao.findBlogEntryById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of getBlogEntry
	}
	
	
	private ISearchService searchService;
	public void setSearchService(ISearchService searchService){
		this.searchService=searchService;
	}
	private IUserService userService;
	public void setUserService(IUserService userService){
		this.userService=userService;
	}
	private IGrantService grantService;
	public void setGrantService(IGrantService grantService){
		this.grantService=grantService;
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
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao){
		this.userDao=userDao;
	}

	
}