package org.obeonetwork.sample.grant;

// Start of user code for import

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.users.Admin;
import org.obeonetwork.sample.users.Moderator;
import org.obeonetwork.sample.users.User;

// End of user code for import

import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.users.Admin;
import org.obeonetwork.sample.users.Moderator;


public interface IGrantService {
	public void grantModerate(User user) throws ServiceException;
	public void grantAdministrate(User user) throws ServiceException;
	public void removeAdminRight(Admin admin) throws ServiceException;
	public void removeModerateRight(Moderator moderator) throws ServiceException;
}