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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
			vo.setDt_lgt(dt_lgt);
			vo.setDt_road(dt_road);

			dList.add(vo);

		}

		return dList;
	}

	@Override
	public List<DetailVO> getList(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<DetailVO> dList = this.getJson(jsonString);

		log.debug("impl!!!!!!!!!!!!dt_code : {}", dt_code);

		int dSize = dList.size();
		for (int i = 0; i < dSize; i++) {
			dList.get(i).setDt_code(dt_code);
			String lat = dList.get(i).getDt_lat();
			String lgt = dList.get(i).getDt_lgt();
			String road = dList.get(i).getDt_road();
			String code = dList.get(i).getDt_code();
			log.debug("road : {}, lat : {}, lgt : {} , dt_code 제발 좀 보자 : {}", road, lat, lgt, code);
		}
		dList.addAll(dList);

		return dList;
	}

	@Override
	public DetailVO getData(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub

//		JSONParser jParser = new JSONParser();
//
//		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
//		JSONArray addresses = (JSONArray) jObject.get("addresses");
//
//		List<Map<String, String>> geoList = new ArrayList<>();
//
////		mapDao.findByCode(dt_code).getDt_code();
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
//			log.debug("road : {}, lat : {}, lgt : {} , code : {}", dt_road, dt_lat, dt_lgt, dt_code);
//
//			geoList.add(map);
//		}
		this.getJson(jsonString);
		Gson gson = new Gson();
		JsonElement jSonElement = JsonParser.parseString(jsonString);
		JsonElement oItems = jSonElement.getAsJsonObject().get("roadAddress");

//		jsonString.toString()
//		jsonString.getBytes(vo.getDt_lat());
//		jsonString.getBytes(vo.getDt_lgt());
//		jsonString.getBytes(vo.getDt_road());

		return null;
	}

	@Override
	public void getUpdate(String jsonString, DetailVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub

		// JsonString을 이용할 수 있게 변환시키는 것
//		JSONParser jParser = new JSONParser();
//
//		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
//		JSONArray addresses = (JSONArray) jObject.get("addresses");
//
//		List<Map<String, String>> geoList = new ArrayList<>();
//		Map<String, String> map = new HashMap<>();
//
//		map.put("dt_code", dt_code);
//
//		int nSize = addresses.size();
//		for (int i = 0; i < nSize; i++) {
//
//			JSONObject addr = (JSONObject) addresses.get(i);
//
//			String road = addr.get("roadAddress").toString();
//			String lat = addr.get("x").toString();
//			String lgt = addr.get("y").toString();
//
//			map.put("dt_road", road);
//			map.put("dt_lat", lat);
//			map.put("dt_lgt", lgt);
//
//			log.debug("road : {}, lat : {}, lgt : {} , code : {} ", road, lat, lgt, dt_code);

//		}

		List<DetailVO> dList = this.getJson(jsonString);
		int dSize = dList.size();
		for (int i = 0; i < dSize; i++) {

			dList.get(i).getDt_lat();
			dList.get(i).getDt_lgt();
			dList.get(i).getDt_road();
			dList.get(i).getDt_code();

			dList.addAll(dList);
			vo = dList.get(i);
		}

		mapDao.update(vo);

//		return geoList;
	}

	@Override
	public void getUpdate(String jsonString, String dt_code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
	}
}