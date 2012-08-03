package org.obeonetwork.sample.search;

// Start of user code for import

import java.util.Collection;

import org.obeonetwork.fwk.service.exception.ServiceException;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;

// End of user code for import

import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.informations.Comment;


public interface ISearchService {
	public Collection<BlogEntry> searchBlogEntries(String searchContent) throws ServiceException;
	public Collection<Comment> searchComments(String searchContent) throws ServiceException;
}