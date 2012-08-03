package org.obeonetwork.sample.grant;

// Start of user code for import

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.users.Admin;
import org.obeonetwork.sample.users.IAdminDao;
import org.obeonetwork.sample.users.IModeratorDao;
import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.users.Moderator;
import org.obeonetwork.sample.users.User;

// End of user code for import

import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.users.Admin;
import org.obeonetwork.sample.users.Moderator;



import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.users.IAdminDao;
import org.obeonetwork.sample.users.IModeratorDao;


public class GrantServiceImpl implements IGrantService{
	public void grantModerate(User user) throws ServiceException{
	// Start of user code of grantModerate
	
	// End of user code of grantModerate
	}
	
	public void grantAdministrate(User user) throws ServiceException{
	// Start of user code of grantAdministrate
	
	// End of user code of grantAdministrate
	}
	
	public void removeAdminRight(Admin admin) throws ServiceException{
	// Start of user code of removeAdminRight
	
	// End of user code of removeAdminRight
	}
	
	public void removeModerateRight(Moderator moderator) throws ServiceException{
	// Start of user code of removeModerateRight
	
	// End of user code of removeModerateRight
	}
	
	

	private IUserDao userDao;
	public void setUserDao(IUserDao userDao){
		this.userDao=userDao;
	}
	private IAdminDao adminDao;
	public void setAdminDao(IAdminDao adminDao){
		this.adminDao=adminDao;
	}
	private IModeratorDao moderatorDao;
	public void setModeratorDao(IModeratorDao moderatorDao){
		this.moderatorDao=moderatorDao;
	}

	
}