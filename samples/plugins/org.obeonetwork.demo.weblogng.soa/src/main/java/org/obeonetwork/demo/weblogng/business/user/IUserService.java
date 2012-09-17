package org.obeonetwork.demo.weblogng.business.user;

//Start of user code for import

import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.users.Admin;	
import org.obeonetwork.demo.weblogng.business.users.User;	
import org.obeonetwork.demo.weblogng.business.users.Moderator;	

public interface IUserService {
	public void createUser(User user) throws ServiceException;	
	public void saveUser(User user) throws ServiceException;	
	public User login(String login, String password) throws ServiceException;	
	public User getUser(String id) throws ServiceException;	
	public Admin getAdmin(String id) throws ServiceException;	
	public Moderator getModerator(String id) throws ServiceException;	
}
