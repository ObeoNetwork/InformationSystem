package org.obeonetwork.sample.demo.weblogng.manage;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.users.User;	
import org.obeonetwork.sample.demo.weblogng.informations.Tag;	
import org.obeonetwork.sample.demo.weblogng.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.informations.Category;	
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;	

public interface IManageService {
	public void deleteComment(Comment comment) throws ServiceException;	
	public void deleteUser(User user) throws ServiceException;	
	public void updateComment(Comment comment) throws ServiceException;	
	public void createCategory(Category category) throws ServiceException;	
	public void deleteCategory(Category category) throws ServiceException;	
	public void removeCategory(Category category, BlogEntry blogEntry) throws ServiceException;	
	public void updateCategory(Category category) throws ServiceException;	
	public void addCategory(Category category, BlogEntry blogEntry) throws ServiceException;	
	public void deleteTag(Tag tag) throws ServiceException;	
	public void removeTag(Tag tag, BlogEntry blogEntry) throws ServiceException;	
	public void updateTag(Tag tag) throws ServiceException;	
	public void addTag(Tag tag, BlogEntry blogEntry) throws ServiceException;	
	public void createTag(Tag tag) throws ServiceException;	
	public Comment getComment(String id) throws ServiceException;	
	public Category getCategory(String id) throws ServiceException;	
	public Tag getTag(String id) throws ServiceException;	
}
