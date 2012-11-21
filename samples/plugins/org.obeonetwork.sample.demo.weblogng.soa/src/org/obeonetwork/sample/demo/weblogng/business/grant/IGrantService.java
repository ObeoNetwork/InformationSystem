package org.obeonetwork.sample.demo.weblogng.business.grant;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.business.users.Admin;	
import org.obeonetwork.sample.demo.weblogng.business.users.User;	
import org.obeonetwork.sample.demo.weblogng.business.users.Moderator;	

public interface IGrantService {
	public void grantModerate(User user) throws ServiceException;	
	public void grantAdministrate(User user) throws ServiceException;	
	public void removeAdminRight(Admin admin) throws ServiceException;	
	public void removeModerateRight(Moderator moderator) throws ServiceException;	
}
