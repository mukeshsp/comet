package com.comet.app.serviceimpimpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comet.app.models.Blogs;

@Service
public class ScrapingService {

	@Autowired
	private BlogService blogService;

	public String webScraping(String tag) throws Exception {

		String url = "https://medium.com/tag/" + tag.toLowerCase() + "/latest";
		System.out.println(tag);
		try {
			Document doc = null;
			doc = Jsoup.connect(url).get();
			String response = parseData(tag, doc);
			
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	private String parseData(String tag, Document doc) {

		Elements allData = doc.getElementsByClass("postArticle");
		String eachArtical = "";
		for (Element data : allData) {

			Blogs blog = new Blogs();

			blog.setBlogLink(data.getElementsByClass("link link--darken").attr("href"));
			blog.setCreator(data.getElementsByClass("ds-link--styleSubtle").text());
			blog.setDetails(data.getElementsByTag("time").text() + " , "
					+ data.getElementsByClass("readingTime").attr("title"));
			blog.setResponse(data.getElementsByClass("graf--trailing").text());
			blog.setTag(tag);
			blog.setTitle(data.getElementsByClass("graf--title").text());

			if(!blogService.existsByBlogLink(blog.getBlogLink())) {
				blogService.save(blog);
			}
			
		}
		return eachArtical;
	}

}
