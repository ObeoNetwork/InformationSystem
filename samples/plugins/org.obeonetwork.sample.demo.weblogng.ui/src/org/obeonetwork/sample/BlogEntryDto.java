package org.obeonetwork.sample;

import java.text.DateFormat;
import java.util.Date;

import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;
import org.obeonetwork.sample.demo.weblogng.users.User;

public class BlogEntryDto {
	
	private BlogEntry blog;
	private String author;
	
	public BlogEntryDto() {	
	}
		
	public String getAuthor() {
		return author;
	}
	
	public String getCreationDateAsText() {
		Date date = blog.getCreationDate();
		DateFormat df = DateFormat.getDateInstance();
		return df.format(date);
	}
	
	public String getCreationTimeAsText() {
		Date date = blog.getCreationDate();
		DateFormat df = DateFormat.getTimeInstance();
		return df.format(date);
	}
	
	// delegateurs
	
	public BlogEntryDto(BlogEntry blog) {
		this.blog = blog;
		User user = blog.getAuthorUser();
		this.author = user.getFirstName() + " " + user.getLastName();
	}

	public User getAuthorUser() {
		return blog.getAuthorUser();
	}

	public String getContent() {
		return blog.getContent();
	}

	public Date getCreationDate() {
		return blog.getCreationDate();
	}

	public String getId() {
		return blog.getId();
	}

	public String getTitle() {
		return blog.getTitle();
	}

	public void setAuthorUser(User authorUser) {
		blog.setAuthorUser(authorUser);
	}

	public void setContent(String content) {
		blog.setContent(content);
	}

	public void setCreationDate(Date creationDate) {
		blog.setCreationDate(creationDate);
	}

	public void setTitle(String title) {
		blog.setTitle(title);
	}
}
