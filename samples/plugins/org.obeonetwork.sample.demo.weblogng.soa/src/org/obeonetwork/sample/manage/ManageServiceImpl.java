package org.obeonetwork.sample.manage;

// Start of user code for import

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ITagDao;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.users.User;


// End of user code for import

import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Tag;


import org.obeonetwork.sample.search.ISearchService;
import org.obeonetwork.sample.user.IUserService;
import org.obeonetwork.sample.grant.IGrantService;

import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.blog.IBlogEntryDao;
import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.ICategoryDao;
import org.obeonetwork.sample.informations.ITagDao;


public class ManageServiceImpl implements IManageService{
	public void deleteComment(Comment comment) throws ServiceException{
	// Start of user code of deleteComment
	
	// End of user code of deleteComment
	}
	
	public void deleteUser(User user) throws ServiceException{
	// Start of user code of deleteUser
	
	// End of user code of deleteUser
	}
	
	public void updateComment(Comment comment) throws ServiceException{
	// Start of user code of updateComment
	
	// End of user code of updateComment
	}
	
	public void deleteCategory(Category category) throws ServiceException{
	// Start of user code of deleteCategory
	
	// End of user code of deleteCategory
	}
	
	public void removeCategory(Category category,BlogEntry blogEntry) throws ServiceException{
	// Start of user code of removeCategory
	
	// End of user code of removeCategory
	}
	
	public void updateCategory(Category category) throws ServiceException{
	// Start of user code of updateCategory
	
	// End of user code of updateCategory
	}
	
	public void addCategory(Category category,BlogEntry blogEntry) throws ServiceException{
	// Start of user code of addCategory
	
	// End of user code of addCategory
	}
	
	public void createCategory(Category category) throws ServiceException{
	// Start of user code of createCategory
	
	// End of user code of createCategory
	}
	
	public void deleteTag(Tag tag) throws ServiceException{
	// Start of user code of deleteTag
	
	// End of user code of deleteTag
	}
	
	public void removeTag(Tag tag,BlogEntry blogEntry) throws ServiceException{
	// Start of user code of removeTag
	
	// End of user code of removeTag
	}
	
	public void updateTag(Tag tag) throws ServiceException{
	// Start of user code of updateTag
	
	// End of user code of updateTag
	}
	
	public void addTag(Tag tag,BlogEntry blogEntry) throws ServiceException{
	// Start of user code of addTag
	
	// End of user code of addTag
	}
	
	public void createTag(Tag tag) throws ServiceException{
	// Start of user code of createTag
	
	// End of user code of createTag
	}
	
	public Comment getComment(String id) throws ServiceException{
	// Start of user code of getComment
	return null;
	// End of user code of getComment
	}
	
	public Category getCategory(String id) throws ServiceException{
	// Start of user code of getCategory
	return null;
	// End of user code of getCategory
	}
	
	public Tag getTag(String id) throws ServiceException{
	// Start of user code of getTag
	return null;
	// End of user code of getTag
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