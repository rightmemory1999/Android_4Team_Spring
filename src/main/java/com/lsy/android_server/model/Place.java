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

//게시물 글쓴이와 username가 같을 경우 수정,삭제 가능하도록
    private String username;

    private String placeName;

//    @Enumerated(EnumType.STRING)
    private String purpose;

    private String city;

    private String address;

    private String description;

}
