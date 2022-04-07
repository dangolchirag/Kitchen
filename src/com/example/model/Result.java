package com.example.model;

import java.util.List;


public class Result {
	int count;
	String next;
	String previous;
	public List<Results> results;
	public class Results{
		public String id;
		public String url;
		public String web_url;
		public String title;
		public String title_np;
		public String language;
		public String cover_image;
		public String published_date;
		public String news_type;
		public List<NewsTag> news_tags;
		public String is_published;
		public String is_flash_news;
		public String is_highlights;
	}
	class NewsTag{
		String id;
		String title;	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return next;
	}

}
