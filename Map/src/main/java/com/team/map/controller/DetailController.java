package com.team.sport.controller;

import java.io.IOException;
import java.util.List;

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

import com.team.map.model.DetailVO;
import com.team.map.model.GeocodeDTO;
import com.team.map.service.DetailService;
import com.team.map.service.NaverCloudMapService;
//import com.team.sport.model.QnAVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/maps")
public class DetailController {
	
	protected final DetailService mapService;
	
	@Qualifier("geocodeV1")
	protected final NaverCloudMapService<?> nGeoService;

	@Qualifier("reverseV1")
	protected final NaverCloudMapService<?> nReGeoService;

	@RequestMapping(value = "/geocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String geoCoding(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {
		
		List<DetailVO> mapList = mapService.selectAddr(address);
//		log.debug("Controller-mapList :{}", mapList.toString());

		Integer mapSize = mapList.size();
		for(int i = 0; i < mapSize; i++) {
//			if (address != null && !address.equals("")) {
			
				String queryURL = nGeoService.queryURL(mapList.get(i).getAl_addr());
				String jsonString = nGeoService.jsonString(queryURL);
				model.addAttribute("GEOS", nGeoService.getList(jsonString));
				log.debug("controller에 있는 jsonString {}", jsonString);
				
				//JsonString을 이용할 수 있게 변환시키는 것
//				JSONParser jsonParse = new JSONParser();
//				
//				JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonString);
//				System.out.println("jsonObj : "+jsonObj);
//				JSONArray Array = (JSONArray) jsonObj.get("addresses"); // addresses
//				// Array SIZE : 1 로 나오는 이유는 array가 배열이라서 하나로 갖고 있기때문
//				System.out.println("Array SIZE : " + Array.size());
//				// Array에서 분류하기 위해 오브젝트에 array를 담아서 get으로 가져오기
//				JSONObject addrObj = (JSONObject) Array.get(0); // roadAddress
//				log.debug("roadAddress : {}" , addrObj.get("roadAddress"));
//				JSONArray Arrayaddr = (JSONArray) jsonObj.get("roadAddress");
//				log.debug("roadAddress" , Arrayaddr.size());
//				JSONObject jsonObj2 = (JSONObject) jsonParse.parse(jsonString);
//				JSONArray ArrayX = (JSONArray) jsonObj.get("X");
//				JSONArray ArrayY = (JSONArray) jsonObj.get("Y");
//				log.debug("ArrayX" , ArrayX.size());
//				log.debug("ArrayY" , ArrayY.size());
				
//				JSONObject addrObjX = (JSONObject) Array.get(4); //
//				JSONObject jsonObj3 = (JSONObject) jsonParse.parse(jsonString);
//				JSONObject addrObjY = (JSONObject) Array.get(5); //
//				log.debug("addrObjX : {}" , addrObjX.get("x"));
//				log.debug("addrObjY : {}" , addrObjY.get("Y"));
//				JSONArray Array2 = (JSONArray) jsonObj.get(addrObj);
//				Map<Object, Object> map = new HashMap<Object, Object>();
//				map.put("roadAddr",addrObj.get("roadAddress"));
//				servie.insert(map);
//				JSONObject addressElements = (JSONObject) Array2.get(0); 
//				System.out.println("addressElements" + addressElements.get("types"));
//				JSONArray ElArray = (JSONArray) jsonObj.get("addressElements");
//				String roadAddr = addrObj.get("roadAddress").toString();
//				System.out.println("roadAddress(STRING) : " + roadAddr);
//			}
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
//	@RequestMapping(value = "")
//	public String map() {
//		
//	}

}
