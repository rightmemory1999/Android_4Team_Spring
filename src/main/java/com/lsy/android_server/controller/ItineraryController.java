package com.lsy.android_server.controller;

import com.lsy.android_server.model.Itinerary;
import com.lsy.android_server.model.Place;
import com.lsy.android_server.repository.ItineraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("itinerary")
@RequiredArgsConstructor
public class ItineraryController {
    private final ItineraryRepository itineraryRepository;

    @GetMapping("list")
    public Map<String, List<Itinerary>> getItineraryList() {
        Map<String, List<Itinerary>> map = new HashMap<String, List<Itinerary>>();
        map.put("itinerary", itineraryRepository.findAll());
        return map;
    }

    @GetMapping("getItinerary/{id}")
    public Itinerary getItinerary(@PathVariable("id") Long id) {
        return itineraryRepository.findById(id).get();
    }

    @PostMapping("insert")
    public String insertItinerary(@RequestBody Itinerary itinerary){
        itineraryRepository.save(itinerary);
        return "successfully saved your itinerary..";
    }

    //sql DB에 입력된 데이터가 수정되도록 설정
    @PostMapping("update")
    public String updateItinerary(@RequestBody Itinerary itinerary) {
        return "successfully updated place data..";
    }

}
