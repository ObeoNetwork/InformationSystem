package org.obeonetwork.demo.weblogng.business.monitor;

//Start of user code for import

import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.informations.Comment;	
import org.obeonetwork.demo.weblogng.business.informations.Tag;	
import org.obeonetwork.demo.weblogng.business.informations.Category;	
import org.obeonetwork.demo.weblogng.business.users.User;	

public interface IMonitorService {
	public Collection<User> getAllUsers() throws ServiceException;	
	public Collection<Tag> getAllTags() throws ServiceException;	
	public Collection<Category> getAllCategories() throws ServiceException;	
	public Collection<Comment> getAllComments() throws ServiceException;	
}
