package com.team.map.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.map.model.GeocodeDTO;
import com.team.map.service.NaverCloudMapService;
//import com.team.sport.model.QnAVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/maps")
public class MapController {
	
	@Qualifier("geocodeV1")
	protected final NaverCloudMapService<?> nGeoService;

	@Qualifier("reverseV1")
	protected final NaverCloudMapService<?> nReGeoService;

	@RequestMapping(value = "/geocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String geoCoding(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {
		
		

		if (address != null && !address.equals("")) {

			String queryURL = nGeoService.queryURL(address);
			System.out.println("queryURL : " + queryURL);
			String jsonString = nGeoService.jsonString(queryURL);
			System.out.println("jsonString : " + jsonString);
			
			//JsonString을 이용할 수 있게 변환시키는 것
			JSONParser jsonParse = new JSONParser();
			
			JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonString);
			
			System.out.println("jsonObj : "+jsonObj);
			
			JSONArray Array = (JSONArray) jsonObj.get("addresses");
			
			// Array SIZE : 1 로 나오는 이유는 array가 배열이라서 하나로 갖고 있기때문
			System.out.println("Array SIZE : " + Array.size());
			
			// Array에서 분류하기 위해 오브젝트에 array를 담아서 get으로 가져오기
			JSONObject addrObj = (JSONObject) Array.get(0);

			System.out.println("roadAddress : " + addrObj.get("roadAddress"));
			
			JSONArray Array2 = (JSONArray) jsonObj.get(addrObj);
			

//			Map<Object, Object> map = new HashMap<Object, Object>();
//			
//			map.put("roadAddr",addrObj.get("roadAddress"));
//			
//			servie.insert(map);
			
;//			JSONObject addressElements = (JSONObject) Array2.get(0); 
//			
//			System.out.println("addressElements" + addressElements.get("types"));
//			JSONArray ElArray = (JSONArray) jsonObj.get("addressElements");
			
//			String roadAddr = addrObj.get("roadAddress").toString();
//			
//			System.out.println("roadAddress(STRING) : " + roadAddr);
			
			model.addAttribute("GEOS", nGeoService.getList(jsonString));
		}
		return "home";
		//		return jsonString;
	}

	@ResponseBody
	@RequestMapping(value = "/regeocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public List<GeocodeDTO> reverseGeoCoding(
			@RequestParam(name = "coords", required = false, defaultValue = "") String coords)
			throws IOException, ParseException {

		if (coords == null || coords.equals("")) {
			return null;//"좌표를 입력해주세요";
		}

		String queryURL = nReGeoService.queryURL(coords);
		String jsonString = nReGeoService.jsonString(queryURL);
		//		return jsonString
		return (List<GeocodeDTO>) nReGeoService.getList(jsonString);
	}

}
