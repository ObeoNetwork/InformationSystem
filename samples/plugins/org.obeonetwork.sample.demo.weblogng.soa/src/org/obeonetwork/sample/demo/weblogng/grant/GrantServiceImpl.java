package org.obeonetwork.sample.demo.weblogng.grant;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.users.User;
import org.obeonetwork.sample.demo.weblogng.users.Admin;
import org.obeonetwork.sample.demo.weblogng.users.Moderator;

import org.obeonetwork.sample.demo.weblogng.users.IAdminDao;	
import org.obeonetwork.sample.demo.weblogng.users.IUserDao;	
import org.obeonetwork.sample.demo.weblogng.users.IModeratorDao;	


public class GrantServiceImpl implements IGrantService {
    public void grantModerate(User user) throws ServiceException{
    	// Start of user code of grantModerate        
    	
    	// End of user code        
    }
    
    public void grantAdministrate(User user) throws ServiceException{
    	// Start of user code of grantAdministrate        
    	
    	// End of user code        
    }
    
    public void removeAdminRight(Admin admin) throws ServiceException{
    	// Start of user code of removeAdminRight        
    	
    	// End of user code        
    }
    
    public void removeModerateRight(Moderator moderator) throws ServiceException{
    	// Start of user code of removeModerateRight        
    	
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

