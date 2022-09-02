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
    public Map<String, List<Place>> getPlaceList(){
        Map<String, List<Place>> map = new HashMap<String, List<Place>>();
        map.put("places", placeRepository.findAll());
        return map;
    }

    @GetMapping("getPlace/{id}")
    public Place getPlace(@PathVariable("id") Long id) {
        return placeRepository.findById(id).get();
    }



    @PostMapping("insert")
    public String insertPlace(@RequestBody Place place){
        placeRepository.save(place);
        return "successfully saved place data..";
    }
}
