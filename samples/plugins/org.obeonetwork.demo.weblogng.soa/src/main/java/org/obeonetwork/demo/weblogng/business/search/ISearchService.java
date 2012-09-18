package org.obeonetwork.demo.weblogng.business.search;

//Start of user code for import

import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.informations.Comment;	
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;	

public interface ISearchService {
	public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException;	
	public Collection<Comment> searchComments(String searchContent) throws ServiceException;	
}
