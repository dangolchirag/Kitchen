package com.project.model;

import java.util.List;

import com.project.model.Result.NewsTag;

public class Detail {
	
	
	public String web_url;
	public String title;
	public String title_np;
	public String language;
	public String cover_image;
	public String content_np;
	public String published_date;
	public String news_type;
	public List<NewsTag> news_tags;
	public Boolean is_published;
	public Boolean is_flash_news;
	public Boolean is_highlights;
}
