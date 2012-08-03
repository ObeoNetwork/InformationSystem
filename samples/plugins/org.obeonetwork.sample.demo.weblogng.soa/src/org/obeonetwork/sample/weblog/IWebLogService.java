package org.obeonetwork.sample.weblog;

// Start of user code for import

import java.util.Collection;

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;

// End of user code for import

import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;


public interface IWebLogService {
	public Collection<BlogEntry> getAllBlogEntries() throws ServiceException;
	public void addBlogEntry(BlogEntry blogEntry) throws ServiceException;
	public void removeBlogEntry(BlogEntry blogEntry) throws ServiceException;
	public void addComment(Comment comment,BlogEntry blogEntry) throws ServiceException;
	public BlogEntry getBlogEntry(String id) throws ServiceException;
}