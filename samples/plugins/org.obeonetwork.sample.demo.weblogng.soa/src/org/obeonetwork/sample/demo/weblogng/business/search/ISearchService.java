package org.obeonetwork.sample.demo.weblogng.business.search;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.business.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.business.blog.BlogEntry;	

public interface ISearchService {
	public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException;	
	public Collection<Comment> searchComments(String searchContent) throws ServiceException;	
}
