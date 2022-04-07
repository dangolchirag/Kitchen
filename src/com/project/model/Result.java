package com.project.model;

import java.util.List;


public class Result {
	public int count;
	public String next;
	public String previous;
	public List<Results> results;
	public static class Results{
		public String id;
		public String url;
		public String web_url;
		public String title;
		public String title_np;
		public String language;
		public String cover_image;
		public String content_np;
		public String published_date;
		public String news_type;
		public List<NewsTag> news_tags;
		public String is_published;
		public String is_flash_news;
		public String is_highlights;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return title_np;
		}
	}
	class NewsTag{
		public String id;
		public String title;	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return next;
	}

}
