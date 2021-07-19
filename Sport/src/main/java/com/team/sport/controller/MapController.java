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

import com.team.sport.dao.MapDao;
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
	protected final MapDao mapDao;

	@Qualifier("geocodeV1")
	protected final NaverCloudMapService<?> nGeoService;

	@Qualifier("reverseV1")
	protected final NaverCloudMapService<?> nReGeoService;


	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String map() {

		return "map/map_basic";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String geoCoding(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {
		// TODO 1개의 주소값을 입력해서 좌표값 입력받기

		if (address != null && !address.equals("")) {
			DetailVO vo = new DetailVO();
			List<DetailVO> detailList = mapService.selectAddr(address); 
			String queryURL = nGeoService.queryURL(address);
			String jsonString = nGeoService.jsonString(queryURL);
			String dt_code = vo.getAl_code();
			model.addAttribute("GEOS", nGeoService.getData(jsonString,dt_code));
		}
		return "map/list";
	}

	@RequestMapping(value = "/allList", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String allList(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {
		// TODO 전체 리스트 띄우기

		if (address != null && !address.equals("")) {

			// 주소 가져오기
			List<DetailVO> detailList = mapService.selectAddr(address);
			log.debug("mapList {}", detailList.toString());
			int mapSize = detailList.size();

			for (int i = 0; i < mapSize; i++) {
				String queryURL = nGeoService.queryURL(detailList.get(i).getAl_addr());
				log.debug("queryURL : {}", queryURL);
				String jsonString = nGeoService.jsonString(queryURL);
				String dt_code = detailList.get(i).getAl_code();
				model.addAttribute("GEOS", nGeoService.getList(jsonString,dt_code));

			}

		}

		return "map/list";
	}

	@RequestMapping(value = "/list/update", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String update(DetailVO vo ,Model model) throws IOException, ParseException {
		// TODO 

		
//		if (address != null && !address.equals("")) {
		if (vo.getAl_code() == vo.getDt_code()) {
			return null;
			
//			List<DetailVO> detailList = mapService.selectAddr(address);
//			log.debug("mapList {}", detailList.toString());
//			int mapSize = detailList.size();
//
//			for (int i = 0; i < mapSize; i++) {
//				String queryURL = nGeoService.queryURL(detailList.get(i).getAl_addr());
//				log.debug("queryURL : {}", queryURL);
//				String jsonString = nGeoService.jsonString(queryURL);
//				String al_code = detailList.get(i).getAl_code();
//				model.addAttribute("GEOS", nGeoService.getUpdate(jsonString,al_code));

//			}

		}else {
			mapDao.update(vo);
		}
		return "map/list";
	}

//	@ResponseBody
//	@RequestMapping(value = "/regeocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
//	public List<GeocodeDTO> reverseGeoCoding(
//			// TODO 좌표를 입력해서 json으로 결과 받기
//			@RequestParam(name = "coords", required = false, defaultValue = "") String coords)
//			throws IOException, ParseException {
//
//		if (coords == null || coords.equals("")) {
//			return null;// "좌표를 입력해주세요";
//		}
//
//		String queryURL = nReGeoService.queryURL(coords);
//		String jsonString = nReGeoService.jsonString(queryURL);
//		// return jsonString
//		return (List<GeocodeDTO>) nReGeoService.getList(jsonString,al_code);
//	}

	@RequestMapping(value = "/naver", method = RequestMethod.GET)
	public String naver(Model model) {

		List<DetailVO> mapList = mapService.select();
		model.addAttribute("MAP", mapList);

		return "map/naver";
	}
}

