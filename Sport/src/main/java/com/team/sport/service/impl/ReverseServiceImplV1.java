package com.team.sport.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.team.sport.config.NaverSecret;
import com.team.sport.model.DetailVO;
import com.team.sport.model.GeocodeDTO;
import com.team.sport.service.NaverCloudMapService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("reverseV1")
public class ReverseServiceImplV1 extends NaverCloudMapService<GeocodeDTO>{
	
	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		String queryURL = NaverSecret.URL.REVERSE_GEOCODING + "?coords=%s&output=json";
		queryURL += "&sourcecrs=epsg:4326";
		queryURL = String.format(queryURL, URLEncoder.encode(search, "UTF-8"));
		log.debug("queryURL : {}", queryURL);
		return queryURL;
	}

	@Override
	public List<GeocodeDTO> getList(String jsonString,String dt_code) throws IOException, ParseException {

		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray results = (JSONArray) jObject.get("results");

		JSONObject results_0 = (JSONObject) results.get(0);
		JSONObject resion = (JSONObject) results_0.get("region");

		List<GeocodeDTO> reGeoList = new ArrayList<>();

		int index = 0;
		while (true) {

				String areaNum = String.format("area%d", index++);
				log.debug("area Num {}", areaNum);
				JSONObject area = (JSONObject) resion.get(areaNum);
				log.debug("area {}", area.toString());

				String name = area.get("name").toString();
				if(name == null || name.equals("")) {
					break;
				}
				JSONObject coords = (JSONObject) area.get("coords");
				JSONObject center = (JSONObject) coords.get("center");
				
				String crs = center.get("crs").toString();
				String x = center.get("x").toString();
				String y = center.get("y").toString();
				
					
//				String x = area.get("x").toString();
//				String y = area.get("y").toString();
				String alias = "";
				try {
					crs = center.get("crs").toString();
					x = center.get("x").toString();
					y = center.get("y").toString();
					alias = area.get("alias").toString();
				} catch (Exception e) {
					log.debug("exception");
				}
				GeocodeDTO rgDTO = GeocodeDTO.builder().name(name).lat(x).lgt(y).crs(crs).alias(alias).build();
				reGeoList.add(rgDTO);
				log.debug(name);

		
		}
		return reGeoList;
	}

	
	@Override
	public void getUpdate(String jsonString, String al_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
	}


	@Override
	public GeocodeDTO getData(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeocodeDTO> getJson(String jsonString) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUpdate(String jsonString, DetailVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
