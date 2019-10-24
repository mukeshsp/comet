package com.comet.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comet.app.dto.Response;
import com.comet.app.models.History;
import com.comet.app.serviceimpimpl.BlogService;
import com.comet.app.serviceimpimpl.HistoryService;
import com.comet.app.serviceimpimpl.ScrapingService;

@RestController
@RequestMapping("/api/blogs")
public class BlogsController {

	@Autowired
	private ScrapingService scrapingService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private HistoryService histopryService;

	@GetMapping("")
	public ResponseEntity<Response> getAll() {
		return ResponseEntity.ok(new Response("200", "Blogs Fetched", blogService.findAll()));
	}

	
	@GetMapping("/delete")
	public ResponseEntity<Response> delete() {
		blogService.deleteAll();
		return ResponseEntity.ok(new Response("200", "Delete Blogs", "Deleted"));
	}

	@GetMapping("/scrap/{tag}")
	public ResponseEntity<Response> scrapTag(@PathVariable("tag") String tag) {
		try {
			// scrapping web content by tag..
			scrapingService.webScraping(tag);
			// updating history..
			if (!histopryService.existsByTag(tag)) {
				histopryService.save(new History(tag));
			}
			// return response dto
			return ResponseEntity.ok(new Response("200", "Blogs Scrapped", blogService.findByTag(tag)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response("500", e.getMessage(), "Internal Server Error"));
		}
	}
}
