package org.obeonetwork.sample.monitor;

// Start of user code for import

import java.util.Collection;

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.users.User;

// End of user code for import

import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.informations.Tag;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.Comment;


public interface IMonitorService {
	public Collection<User> getAllUsers() throws ServiceException;
	public Collection<Tag> getAllTags() throws ServiceException;
	public Collection<Category> getAllCategories() throws ServiceException;
	public Collection<Comment> getAllComments() throws ServiceException;
}