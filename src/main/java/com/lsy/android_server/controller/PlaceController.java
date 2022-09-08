package com.lsy.android_server.controller;

import com.lsy.android_server.model.Place;
import com.lsy.android_server.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceRepository placeRepository;

    @GetMapping("list")
    public Map<String, List<Place>> getPlaceList() {
        Map<String, List<Place>> map = new HashMap<String, List<Place>>();
        map.put("places", placeRepository.findAll());
        return map;
    }

    @GetMapping("getPlace/{id}")
    public Place getPlace(@PathVariable("id") Long id) {
        return placeRepository.findById(id).get();
    }


    @PostMapping("insert")
    public String insertPlace(@RequestBody Place place) {
        placeRepository.save(place);
        return "successfully saved place data..";
    }

    @PostMapping("update")
    public String updatePlace(@RequestBody Place place) {
        Place place1 = placeRepository.findById(place.getId()).get();
        place1.setPlaceName(place.getPlaceName());
        place1.setPurpose(place.getPurpose());
        place1.setCity(place.getCity());
        place1.setAddress(place.getAddress());
        place1.setDescription(place.getDescription());
        /*placeRepository.save(place);*/
        return "successfully updated place data..";

    }
}

