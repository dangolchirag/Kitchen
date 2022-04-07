package com.project.utils;

import java.util.ArrayList;
import java.util.List;

public class Contants {
	public static final String URL = "jdbc:mysql://localhost:3306/reports?characterEncoding=utf8&useConfigs=maxPerformance";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Ktmnepal@1";
	//public static String SOURCE = "https://www.nepalpolice.gov.np/api/v1/news&limit=1098&offset=0";
	public static String SOURCE = "https://www.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_ONE = "https://province1.nepalpolice.gov.np/api/v1/news";	
	public static String SOURCE_PROVINCE_TWO = "https://province2.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_THREE = "https://bagmati.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_FOUR = "https://gandaki.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_FIVE = "https://lumbini.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_SIX = "https://karnali.nepalpolice.gov.np/api/v1/news";
	public static String SOURCE_PROVINCE_SEVEN = "https://sudurpashchim.nepalpolice.gov.np/api/v1/news";
	
	
	
	
	public static List<String> URLs = new ArrayList<>();
	
	static {
		URLs.add(SOURCE);
		URLs.add(SOURCE_PROVINCE_ONE);
		URLs.add(SOURCE_PROVINCE_TWO);
		URLs.add(SOURCE_PROVINCE_THREE);
		URLs.add(SOURCE_PROVINCE_FOUR);
		URLs.add(SOURCE_PROVINCE_FIVE);
		URLs.add(SOURCE_PROVINCE_SIX);
		URLs.add(SOURCE_PROVINCE_SEVEN);
	}
	

	
	
	
}
