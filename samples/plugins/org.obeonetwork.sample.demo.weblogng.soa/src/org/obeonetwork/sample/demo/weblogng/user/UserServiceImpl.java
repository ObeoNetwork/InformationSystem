package org.obeonetwork.sample.demo.weblogng.user;

//Start of user code for import

import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;

//End of user code

import org.obeonetwork.sample.demo.weblogng.users.User;
import org.obeonetwork.sample.demo.weblogng.users.Admin;
import org.obeonetwork.sample.demo.weblogng.users.Moderator;

import org.obeonetwork.sample.demo.weblogng.users.IAdminDao;	
import org.obeonetwork.sample.demo.weblogng.users.IUserDao;	
import org.obeonetwork.sample.demo.weblogng.users.IModeratorDao;	


public class UserServiceImpl implements IUserService {
    public void createUser(User user) throws ServiceException{
    	// Start of user code of createUser        
    	try {
			userDao.createUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
    	// End of user code        
    }
    
    public void saveUser(User user) throws ServiceException{
    	// Start of user code of saveUser        
    	
    	// End of user code        
    }
    
    public User login(String login, String password) throws ServiceException{
    	// Start of user code of login 
    	try {
			Collection<User> findAllUsers = userDao.findAllUsers();
			for (User user : findAllUsers) {
				if (login.equals(user.getLogin())) {
					if (password.equals(user.getPassword())) {
						return user;
					} else {
						return null;
					}
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
    	return null;
    	// End of user code        
    }
    
    public User getUser(String id) throws ServiceException{
    	// Start of user code of getUser        
    	return null;
    	// End of user code        
    }
    
    public Admin getAdmin(String id) throws ServiceException{
    	// Start of user code of getAdmin        
    	return null;
    	// End of user code        
    }
    
    public Moderator getModerator(String id) throws ServiceException{
    	// Start of user code of getModerator        
    	return null;
    	// End of user code        
    }
    
	
    private IAdminDao adminDao;
    public void setAdminDao(IAdminDao adminDao){
    	this.adminDao = adminDao;
    }
    	
    private IUserDao userDao;
    public void setUserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
    	
    private IModeratorDao moderatorDao;
    public void setModeratorDao(IModeratorDao moderatorDao){
    	this.moderatorDao = moderatorDao;
    }
    	
    

}

