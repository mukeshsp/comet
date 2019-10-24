package com.comet.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Length;

@Entity
@NamedQuery(name = "find_all_blogs", query = "select blog from Blogs blog")
public class Blogs {

	@Id
	@GeneratedValue
	private Long id;
	
	@Length(min = 0, max = 15000000)
	@Column(unique = true)
	private String blogLink;
	@Length(min = 0, max = 15000000)
	private String creator;
	@Length(min = 0, max = 15000000)
	private String title;
	@Length(min = 0, max = 15000000)
	private String tag;
	@Length(min = 0, max = 15000000)
	private String details;
	@Length(min = 0, max = 15000000)
	private String response;

	@Override
	public String toString() {
		return "Blogs [id=" + id + ", blogLink=" + blogLink + ", creator=" + creator + ", title=" + title + ", tag="
				+ tag + ", details=" + details + ", response=" + response + "]";
	}

	public Blogs() {
	}

	public Blogs(String blogLink, String creator, String title, String tag, String details, String response) {
		this.blogLink = blogLink;
		this.creator = creator;
		this.title = title;
		this.tag = tag;
		this.details = details;
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public String getBlogLink() {
		return blogLink;
	}

	public void setBlogLink(String blogLink) {
		this.blogLink = blogLink;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
