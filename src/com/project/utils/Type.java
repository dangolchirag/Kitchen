package com.project.utils;

public enum Type {

	NEWS("news","NEWS"),
	NOTICE("notices","NOTICE"),
	PRESS("news/press-releases","PRESS");
	private final String type;
	private final String title;
	Type(String type,String title){
		this.type = type;
		this.title = title;
	}
	
	
	public String buildUrl(String url) {
		return url.replace("news", type);
	}
	
	@Override
	public String toString() {
		return title;
	}
	
	
	
	
}
