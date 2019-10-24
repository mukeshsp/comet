package com.comet.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comet.app.models.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Long>{

	List<Blogs> findByTag(String tag);

	boolean existsByBlogLink(String blogLink);
	

}
