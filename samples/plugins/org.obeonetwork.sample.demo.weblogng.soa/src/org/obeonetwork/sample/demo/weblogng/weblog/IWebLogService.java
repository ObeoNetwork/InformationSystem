package org.obeonetwork.sample.demo.weblogng.weblog;

//Start of user code for import

import org.obeonetwork.sample.demo.fwk.service.exception.ServiceException;
import java.util.Collection;

//End of user code

import org.obeonetwork.sample.demo.weblogng.informations.Comment;	
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;	

public interface IWebLogService {
	public Collection<BlogEntry> getAllBlogEntries() throws ServiceException;	
	public void addBlogEntry(BlogEntry blogEntry) throws ServiceException;	
	public void removeBlogEntry(BlogEntry blogEntry) throws ServiceException;	
	public BlogEntry getBlogEntry(String id) throws ServiceException;	
	public void addComment(Comment comment, BlogEntry blogEntry) throws ServiceException;	
}
