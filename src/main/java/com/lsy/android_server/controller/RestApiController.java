package com.lsy.android_server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsy.android_server.constant.Purpose;
import com.lsy.android_server.model.Place;
import com.lsy.android_server.repository.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import com.lsy.android_server.model.User;
import com.lsy.android_server.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("base/")
@RequiredArgsConstructor
public class RestApiController {

	private final UserRepository userRepository;
	private final PlaceRepository placeRepository;

//	@GetMapping("home")
//	public String home() {
//		return "<h1>home</h1>";
//	}

//	@PostMapping("insert")
//	public String insertUser(@RequestBody User user) {
//		userRepository.save(user);
//		return "데이터 저장 성공";
//	}

//	@GetMapping("getUser/{id}")
//	public User getUser(@PathVariable("id") Long id) {
//		return userRepository.findById(id).get();
//	}
//
//	@GetMapping("getUsername/{username}")
//	public User getUser(@PathVariable("username") String username) {
//		return userRepository.findByUsername(username);
//	}

//	@GetMapping("list")
//	public Map<String,List<User>> getList(){
//		Map<String, List<User>> map=new HashMap<String,List<User>>();
//		map.put("users", userRepository.findAll());
//		return map;
//	}

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


	@PostMapping("delete")
	public String deletePlace(@RequestBody Place place){
		placeRepository.delete(place);
		return "successfully deleted place data..";
	}

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

//	@GetMapping("listBy/{purpose}")
//	public Place listByPurpose(@PathVariable("purpose")String purpose){
//		return placeRepository.findByPurpose(purpose);
//	}

	@GetMapping("getPlace/{id}")
	public Place getPlace(@PathVariable("id") Long id) {
		return placeRepository.findById(id).get();
	}

}