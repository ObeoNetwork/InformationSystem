package org.obeonetwork.sample.demo.weblogng.monitor;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.users.User;	
import org.obeonetwork.sample.demo.weblogng.informations.Tag;	
import org.obeonetwork.sample.demo.weblogng.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.informations.Category;	

public interface IMonitorService {
	public Collection<User> getAllUsers() throws ServiceException;	
	public Collection<Tag> getAllTags() throws ServiceException;	
	public Collection<Category> getAllCategories() throws ServiceException;	
	public Collection<Comment> getAllComments() throws ServiceException;	
}
