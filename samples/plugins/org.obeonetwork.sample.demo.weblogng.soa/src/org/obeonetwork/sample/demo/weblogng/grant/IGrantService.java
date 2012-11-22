package org.obeonetwork.sample.demo.weblogng.grant;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.users.Admin;	
import org.obeonetwork.sample.demo.weblogng.users.User;	
import org.obeonetwork.sample.demo.weblogng.users.Moderator;	

public interface IGrantService {
	public void grantModerate(User user) throws ServiceException;	
	public void grantAdministrate(User user) throws ServiceException;	
	public void removeAdminRight(Admin admin) throws ServiceException;	
	public void removeModerateRight(Moderator moderator) throws ServiceException;	
}
