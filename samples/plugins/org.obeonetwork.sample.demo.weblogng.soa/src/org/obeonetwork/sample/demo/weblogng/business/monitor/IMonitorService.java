package org.obeonetwork.sample.demo.weblogng.business.monitor;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.business.users.User;	
import org.obeonetwork.sample.demo.weblogng.business.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.business.informations.Tag;	
import org.obeonetwork.sample.demo.weblogng.business.informations.Category;	

public interface IMonitorService {
	public Collection<User> getAllUsers() throws ServiceException;	
	public Collection<Tag> getAllTags() throws ServiceException;	
	public Collection<Category> getAllCategories() throws ServiceException;	
	public Collection<Comment> getAllComments() throws ServiceException;	
}
