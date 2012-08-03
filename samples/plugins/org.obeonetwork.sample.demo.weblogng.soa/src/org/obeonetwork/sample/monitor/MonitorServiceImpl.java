package org.obeonetwork.sample.monitor;

// Start of user code for import

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ITagDao;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.users.User;

import java.util.Collection;

// End of user code for import

import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Comment;


import org.obeonetwork.sample.search.ISearchService;
import org.obeonetwork.sample.user.IUserService;
import org.obeonetwork.sample.grant.IGrantService;

import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ITagDao;
import org.obeonetwork.sample.informations.ICommentDao;


public class MonitorServiceImpl implements IMonitorService{
	public Collection<User> getAllUsers() throws ServiceException{
	// Start of user code of getAllUsers
	return null;
	// End of user code of getAllUsers
	}
	
	public Collection<Tag> getAllTags() throws ServiceException{
	// Start of user code of getAllTags
	return null;
	// End of user code of getAllTags
	}
	
	public Collection<Category> getAllCategories() throws ServiceException{
	// Start of user code of getAllCategories
	return null;
	// End of user code of getAllCategories
	}
	
	public Collection<Comment> getAllComments() throws ServiceException{
	// Start of user code of getAllComments
	return null;
	// End of user code of getAllComments
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

	private IUserDao userDao;
	public void setUserDao(IUserDao userDao){
		this.userDao=userDao;
	}
	private ICategoryDao categoryDao;
	public void setCategoryDao(ICategoryDao categoryDao){
		this.categoryDao=categoryDao;
	}
	private ITagDao tagDao;
	public void setTagDao(ITagDao tagDao){
		this.tagDao=tagDao;
	}
	private ICommentDao commentDao;
	public void setCommentDao(ICommentDao commentDao){
		this.commentDao=commentDao;
	}

	
}