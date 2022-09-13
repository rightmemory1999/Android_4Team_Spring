package com.lsy.android_server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsy.android_server.model.Place;
import com.lsy.android_server.repository.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import com.lsy.android_server.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("base/")
@RequiredArgsConstructor
public class RestApiController {

	private final UserRepository userRepository;
	private final PlaceRepository placeRepository;

	@GetMapping("list")
	public Map<String, List<Place>> getPlaceList(){
		Map<String, List<Place>> map = new HashMap<String, List<Place>>();
		map.put("places", placeRepository.findAll());
		return map;
	}

	@PostMapping("insert")
	public String insertPlace(@RequestBody Place place){
		placeRepository.save(place);
		return "successfully saved place data..";
	}

	//(안드로이드부터 넘어온) sql DB에 입력된 데이터가 삭제되도록 설정
	//DB 입력방식 : 안드로이드 -> 스프링 -> sql DB
	@PostMapping("delete")
	public String deletePlace(@RequestBody Place place){
		placeRepository.delete(place);
		return "successfully deleted place data..";
	}

	//(안드로이드부터 넘어온) sql DB에 입력된 데이터가 수정되도록 설정
	@PostMapping("update")
	public String updatePlace(@RequestBody Place place){
		Place place1 = placeRepository.findById(place.getId()).get();
		place1.setPlaceName(place.getPlaceName());
		place1.setPurpose(place.getPurpose());
		place1.setCity(place.getCity());
		place1.setAddress(place.getAddress());
		place1.setDescription(place.getDescription());
		placeRepository.save(place1);
		/*placeRepository.save(place);*/
		return "successfully updated place data..";
	}

	@GetMapping("listBy/{purpose}")
	public Map<String, List<Place>> listByPurpose(@PathVariable("purpose")String purpose){
		Map<String, List<Place>> map = new HashMap<String, List<Place>>();
		map.put("places", placeRepository.findByPurpose(purpose));
		return map;
	}

	@GetMapping("getPlace/{id}")
	public Place getPlace(@PathVariable("id") Long id) {
		return placeRepository.findById(id).get();
	}

}