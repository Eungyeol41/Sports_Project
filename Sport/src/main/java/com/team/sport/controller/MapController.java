package com.team.sport.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.sport.model.DetailVO;
import com.team.sport.model.GeocodeDTO;
import com.team.sport.service.MapService;
import com.team.sport.service.NaverCloudMapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/map")
public class MapController {
	
	protected final MapService mapService;
	
	@Qualifier("geocodeV1")
	protected final NaverCloudMapService<?> nGeoService;

	@Qualifier("reverseV1")
	protected final NaverCloudMapService<?> nReGeoService;

	@RequestMapping(value = "/geocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String geoCoding(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {
		
		if (address != null && !address.equals("")) {

			List<DetailVO> detailList = mapService.selectAddr(address);
			log.debug("mapList {}", detailList.toString());
			int mapSize = detailList.size();
			
			for(int i = 0; i < mapSize; i++) {
				String queryURL = nGeoService.queryURL(detailList.get(i).getAl_addr());
				log.debug("queryURL : {}", queryURL);
				String jsonString = nGeoService.jsonString(queryURL);
				model.addAttribute("GEOS", nGeoService.getList(jsonString));
			}
			
		}
		
		return "map_basic";
		// return jsonString;
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

	@RequestMapping(value = "/naver", method = RequestMethod.GET)
	public String naver(Model model) {
		
		List<DetailVO> mapList = mapService.select();
		model.addAttribute("MAP", mapList);
		
		return "map/naver";
	}
}
