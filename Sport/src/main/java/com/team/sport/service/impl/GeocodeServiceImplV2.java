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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.sport.config.NaverSecret;
import com.team.sport.dao.MapDao;
import com.team.sport.model.DetailVO;
import com.team.sport.service.NaverCloudMapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("geocodeV2")
public class GeocodeServiceImplV2 extends NaverCloudMapService<DetailVO> {

	protected final MapDao mapDao;

	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String queryURL = NaverSecret.URL.GEOCODING + "?query=%s&filter=HCODE";
		queryURL = String.format(queryURL, URLEncoder.encode(search, "UTF-8"));
		log.debug("queryURL : {}", queryURL);
		return queryURL;
	}

	@Override
	public List<DetailVO> getJson(String jsonString) throws IOException, ParseException {
		// TODO Auto-generated method stub
		// JsonString을 이용할 수 있게 변환시키는 것
		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray addresses = (JSONArray) jObject.get("addresses");

		List<DetailVO> dList = new ArrayList<DetailVO>();

		int nSize = addresses.size();
		for (int i = 0; i < nSize; i++) {
			JSONObject addr = (JSONObject) addresses.get(i);

			String dt_road = addr.get("roadAddress").toString();
			String dt_lat = addr.get("x").toString();
			String dt_lgt = addr.get("y").toString();
			
			DetailVO vo = new DetailVO();
			vo.setDt_lat(dt_lat);
			vo.setDt_lgt(dt_lat);
			vo.setDt_road(dt_road);

			dList.add(vo);

		}

		return dList;
	}

	@Override
	public List<DetailVO> getList(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub

//		// JsonString을 이용할 수 있게 변환시키는 것
//		JSONParser jParser = new JSONParser();
//
//		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
//		JSONArray addresses = (JSONArray) jObject.get("addresses");
//
//		List<Map<String, String>> geoList = new ArrayList<>();
//
//		Map<String, String> map = new HashMap<>();
//		map.put("dt_code", dt_code);
//
//		int nSize = addresses.size();
//		for (int i = 0; i < nSize; i++) {
//
//			JSONObject addr = (JSONObject) addresses.get(i);
//
//			String dt_road = addr.get("roadAddress").toString();
//			String dt_lat = addr.get("x").toString();
//			String dt_lgt = addr.get("y").toString();
//
//			map.put("dt_road", dt_road);
//			map.put("dt_lat", dt_lat);
//			map.put("dt_lgt", dt_lgt);
//
//			log.debug("road : {}, lat : {}, lgt : {} , dt_code : {}", dt_road, dt_lat, dt_lgt, dt_code);
//
//			geoList.add(map);
//		}

//		List<Map<String, String>> geoList = this.getJson(jsonString);
//		log.debug("결과임{}", geoList.toString());

		return null;
//		return geoList;
	}

	@Override
	public DetailVO getData(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub

		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray addresses = (JSONArray) jObject.get("addresses");

		List<Map<String, String>> geoList = new ArrayList<>();

//		mapDao.findByCode(dt_code).getDt_code();
		Map<String, String> map = new HashMap<>();
		map.put("dt_code", dt_code);

		int nSize = addresses.size();
		for (int i = 0; i < nSize; i++) {

			JSONObject addr = (JSONObject) addresses.get(i);

			String dt_road = addr.get("roadAddress").toString();
			String dt_lat = addr.get("x").toString();
			String dt_lgt = addr.get("y").toString();

			map.put("dt_road", dt_road);
			map.put("dt_lat", dt_lat);
			map.put("dt_lgt", dt_lgt);

			log.debug("road : {}, lat : {}, lgt : {} , code : {}", dt_road, dt_lat, dt_lgt, dt_code);

			geoList.add(map);
		}
		return null;
	}

	@Override
	public void getUpdate(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub

		// JsonString을 이용할 수 있게 변환시키는 것
		JSONParser jParser = new JSONParser();

		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray addresses = (JSONArray) jObject.get("addresses");

		List<Map<String, String>> geoList = new ArrayList<>();
		Map<String, String> map = new HashMap<>();

		map.put("dt_code", dt_code);

		int nSize = addresses.size();
		for (int i = 0; i < nSize; i++) {

			JSONObject addr = (JSONObject) addresses.get(i);

			String road = addr.get("roadAddress").toString();
			String lat = addr.get("x").toString();
			String lgt = addr.get("y").toString();

			map.put("dt_road", road);
			map.put("dt_lat", lat);
			map.put("dt_lgt", lgt);

			log.debug("road : {}, lat : {}, lgt : {} , code : {} ", road, lat, lgt, dt_code);

		}

		mapDao.update(map);

//		return geoList;
	}

}
