package com.stream.app.services.Impl;

import com.stream.app.entites.Video;
import com.stream.app.repositiories.VideoRepository;
import com.stream.app.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServicesImpl implements VideoService {


    @Value("${files.video}")
    String DIR;


    private VideoRepository videoRepository;

    public VideoServicesImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void init(){

        File file=new File(DIR);
        if (!file.exists()){
            file.mkdir();
            System.out.println("Folder Created:");
        }else{
            System.out.println("Folder already created");
        }

    }
    @Override
    public Video save(Video video, MultipartFile file) {
          //original file name

        try {
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();


            //file path
            String cleanFileName=StringUtils.cleanPath(filename);

             //folder path:create
            String cleanFolder=StringUtils.cleanPath(DIR);

            //folder path with filename
            Path path= Paths.get(cleanFolder,cleanFileName);

            System.out.println(contentType);
            System.out.println(path);


            //COPY FILE TO THE FOLDER
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            //VIDEO META DATA

            video.setContentType(contentType);
            video.setFilePath(path.toString());

            //META DATA SAVE

             return videoRepository.save(video);

        }catch(IOException e){
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public Video get(String videoId) {
        return null;
    }

    @Override
    public Video getByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAll() {
        return null;
    }
}
