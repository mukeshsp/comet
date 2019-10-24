package com.comet.app.serviceimpimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comet.app.models.Blogs;
import com.comet.app.repositories.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public List<Blogs> findAll() {
		return blogRepository.findAll();
	}

	public Blogs save(Blogs blog) {
		return blogRepository.save(blog);
	}

	public void deleteAll() {
		blogRepository.deleteAll();
	}

	public List<Blogs> findByTag(String tag) {
		return blogRepository.findByTag(tag);
	}

	public boolean existsByBlogLink(String blogLink) {
		// TODO Auto-generated method stub
		return blogRepository.existsByBlogLink(blogLink);
	}

}
