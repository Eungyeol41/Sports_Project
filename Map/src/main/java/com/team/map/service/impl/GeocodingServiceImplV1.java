package com.team.map.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.team.map.config.NaverSecret;
import com.team.map.service.NaverCloudMapService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("geocodeV1")
public class GeocodingServiceImplV1 extends NaverCloudMapService<Map<String, String>>{

	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String queryURL = NaverSecret.URL.GEOCODING + "?query=%s&filter=HCODE";
		queryURL = String.format(queryURL, URLEncoder.encode(search,"UTF-8"));
		log.debug("queryURL : {}", queryURL);
		return queryURL;
	}

	@Override
	public List<Map<String, String>> getList(String jsonString) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray addresses = (JSONArray) jObject.get("addresses");

		List<Map<String,String>> geoList = new ArrayList<>();
		
		int nSize = addresses.size();
		for(int i = 0 ; i < nSize ; i++) {
			JSONObject addr = (JSONObject) addresses.get(i); 
			String lat = addr.get("x").toString();
			String lgt = addr.get("y").toString();
			Map<String,String> map = new HashMap<>();
			map.put("lat",lat);
			map.put("lgt",lgt);
			log.debug("lat {}, lgt {}",lat,lgt);
			geoList.add(map);
		}
		return geoList;
	}

	@Override
	public Map<String, String> getData(String jsonString) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
