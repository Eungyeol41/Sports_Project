package com.team.sport.service.impl;

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

import com.team.sport.config.NaverSecret;
import com.team.sport.dao.MapDao;
import com.team.sport.service.NaverCloudMapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("geocodeV1")
public class GeocodeServiceImplV1 extends NaverCloudMapService<Map<String, String>>{
	
	protected final MapDao mapDao;

	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String queryURL = NaverSecret.URL.GEOCODING + "?query=%s&filter=HCODE";
		queryURL = String.format(queryURL, URLEncoder.encode(search,"UTF-8"));
		log.debug("queryURL : {}", queryURL);
		return queryURL;
	}

	@Override
	public List<Map<String, String>> getList(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		//JsonString을 이용할 수 있게 변환시키는 것
		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray addresses = (JSONArray) jObject.get("addresses");

		List<Map<String,String>> geoList = new ArrayList<>();
		
		int nSize = addresses.size();
		for(int i = 0 ; i < nSize ; i++) {
			
			JSONObject addr = (JSONObject) addresses.get(i);
			
			String road = addr.get("roadAddress").toString();
			String lat = addr.get("x").toString();
			String lgt = addr.get("y").toString();
			
			Map<String,String> map = new HashMap<>();
			
			map.put("m_road", road);
			map.put("m_lat",lat);
			map.put("m_lgt",lgt);
			
		
			log.debug("road : {}, lat : {}, lgt : {}", road, lat,lgt);

			geoList.add(map);
			
			int gSize = geoList.size();
			for(int index = 0 ; index < gSize ; index++) {
				mapDao.insert(geoList.get(index)); 
			}
			
			log.debug("결과임{}", geoList.toString());
		}
		return geoList;
	}

	@Override
	public Map<String, String> getData(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUpdate(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
	}


	
}