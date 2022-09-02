package com.lsy.android_server.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Itinerary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String tripName;
    private String party;
    // 추후 enum type 으로.. family, friend 등 구성원 분류 나눔?
    private String departurePoint;
    private String wayPoint1;
    private String wayPoint2;
    private String wayPoint3;
    private String wayPoint4;
    private String returnPoint;
    private String departureDate;
    private String returnDate;
    private String period;
    private String others;
}
