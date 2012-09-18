package org.obeonetwork.demo.weblogng.business.weblog;

//Start of user code for import

import org.obeonetwork.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.demo.weblogng.business.informations.Comment;	
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;	

public interface IWebLogService {
	public Collection<BlogEntry> getAllBlogEntries() throws ServiceException;	
	public void addBlogEntry(BlogEntry blogEntry) throws ServiceException;	
	public void removeBlogEntry(BlogEntry blogEntry) throws ServiceException;	
	public BlogEntry getBlogEntry(String id) throws ServiceException;	
	public void addComment(Comment comment, BlogEntry blogEntry) throws ServiceException;	
}
