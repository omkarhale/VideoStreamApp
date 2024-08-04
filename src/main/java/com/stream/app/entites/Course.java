package com.stream.app.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stream_video_courses")
public class Course {
    @Id
    private String id;

    private String titile;
//    @OneToMany(mappedBy = "course")
//    List<Video>list=new ArrayList<>();
}
