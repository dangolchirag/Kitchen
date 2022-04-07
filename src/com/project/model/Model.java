package com.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.project.utils.Contants;

public class Model {
	
	
	private static Map<String,String> mMap = new LinkedHashMap<>();
	static {				
		mMap.put("गृहपृष्ठ", Contants.SOURCE);
		mMap.put("१ नं. प्रदेश प्रहरी", Contants.SOURCE_PROVINCE_ONE);
		mMap.put("२ नं. प्रदेश प्रहरी", Contants.SOURCE_PROVINCE_TWO);
		mMap.put("बागमती प्रदेश", Contants.SOURCE_PROVINCE_THREE);
		mMap.put("गण्डकी प्रदेश", Contants.SOURCE_PROVINCE_FOUR);
		mMap.put("लुम्बिनी प्रदेश", Contants.SOURCE_PROVINCE_FIVE);
		mMap.put("कर्णाली प्रदेश", Contants.SOURCE_PROVINCE_SIX);
		mMap.put("सुदूरपश्चिम प्रदेश", Contants.SOURCE_PROVINCE_SEVEN);
		mMap.put("Settings", null);
	}
	
	
	public List<String> getStates() {
		return new ArrayList<String>(mMap.keySet());
	}
}
