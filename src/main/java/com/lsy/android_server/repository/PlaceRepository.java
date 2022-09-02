package com.lsy.android_server.repository;

import com.lsy.android_server.constant.Purpose;
import com.lsy.android_server.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByPurpose(String purpose);
}
