package com.lsy.android_server.repository;

import com.lsy.android_server.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    Itinerary findByDepartureDate(String departureDate);
}
