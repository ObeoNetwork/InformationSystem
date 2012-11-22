package org.obeonetwork.sample.demo.weblogng.search;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;	

public interface ISearchService {
	public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException;	
	public Collection<Comment> searchComments(String searchContent) throws ServiceException;	
}
