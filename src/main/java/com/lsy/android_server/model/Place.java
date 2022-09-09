package com.lsy.android_server.model;

import com.lsy.android_server.constant.Purpose;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "place_id")
    private long id;

    private String placeName;

//    @Enumerated(EnumType.STRING)
    private String purpose;

    private String city;

    private String address;

    private String description;

    private String hello;

//    private long id;
//    private String placeName;
//    private String season;
//    private String city;
//    private String address;
//    private String detail;
}
