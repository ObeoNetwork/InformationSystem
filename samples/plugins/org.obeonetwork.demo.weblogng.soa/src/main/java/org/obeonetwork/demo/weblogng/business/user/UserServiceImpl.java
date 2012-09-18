package org.obeonetwork.demo.weblogng.business.user;

//Start of user code for import

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.users.User;
import org.obeonetwork.demo.weblogng.business.users.Admin;
import org.obeonetwork.demo.weblogng.business.users.Moderator;

import org.obeonetwork.demo.weblogng.business.users.IUserDao;	
import org.obeonetwork.demo.weblogng.business.users.IAdminDao;	
import org.obeonetwork.demo.weblogng.business.users.IModeratorDao;	


public class UserServiceImpl implements IUserService {
    public void createUser(User user) throws ServiceException{
    	// Start of user code of createUser        
	try {
		userDao.createUser(user);
	} catch (DaoException e) {
		throw new ServiceException(e);
	}
	// End of user code of createUser
    }
    
    public void saveUser(User user) throws ServiceException{
    	// Start of user code of saveUser        
		try {
			userDao.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of saveUser
    }
    
    public User login(String login, String password) throws ServiceException{
    	// Start of user code of login        
	try {
		return userDao.findByLoginAndPassword(login, password);
	} catch (DaoException e) {
		throw new ServiceException(e);
	}
	// End of user code of login
    }
    
    public User getUser(String id) throws ServiceException{
    	// Start of user code of getUser        
	try {
		return userDao.findUserById(id);
	} catch (DaoException e) {
		throw new ServiceException(e);
	}
	// End of user code of getUser
    }
    
    public Admin getAdmin(String id) throws ServiceException{
    	// Start of user code of getAdmin        
		try {
			return adminDao.findAdminById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of getAdmin
    }
    
    public Moderator getModerator(String id) throws ServiceException{
    	// Start of user code of getModerator        
		try {
			return moderatorDao.findModeratorById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	// End of user code of getModerator
    }
    
	
    private IUserDao userDao;
    public void setUserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
    	
    private IAdminDao adminDao;
    public void setAdminDao(IAdminDao adminDao){
    	this.adminDao = adminDao;
    }
    	
    private IModeratorDao moderatorDao;
    public void setModeratorDao(IModeratorDao moderatorDao){
    	this.moderatorDao = moderatorDao;
    }
    	
    

}

