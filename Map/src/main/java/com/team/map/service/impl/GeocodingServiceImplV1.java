package com.team.map.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.sun.tools.example.debug.expr.ParseException;
import com.team.map.config.NaverSecret;
import com.team.map.dao.DetailDao;
import com.team.map.service.NaverCloudMapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("geocodeV1")
public class GeocodingServiceImplV1 extends NaverCloudMapService<Map<String, String>>{
	
	protected final DetailDao detailDao;

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
			
			map.put("dt_road", road);
			map.put("dt_lat",lat);
			map.put("dt_lgt",lgt);
			
		
			log.debug("road {}, lat {}, lgt {}", road, lat,lgt);

			geoList.add(map);
			
			int gSize = geoList.size();
			for(int index = 0 ; index < gSize ; index++) {
//				detailDao.insert(geoList.get(index));
				detailDao.update(geoList.get(index));
			}
			
			log.debug("결과임{}", geoList.toString());
		}
		return geoList;
	}

	@Override
	public Map<String, String> getData(String jsonString) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

