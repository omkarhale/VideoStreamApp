package com.stream.app.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stream_video")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    private String videoId;
    private String title;
    private String description;
    private String contentType;
    private String filePath;
//    @ManyToOne
//    private Course course;
}
