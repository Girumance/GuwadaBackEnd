package com.intern.guwada.Services;



import com.intern.guwada.Domain.ImageStorage;
import com.intern.guwada.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(String ownerId, MultipartFile file) throws IOException {

        File fileName= new File("/home/rootuser/Pictures/Uploads/"+file.getOriginalFilename());

       ImageStorage image=imageRepository.findImageStorageByOwnerId(ownerId);

        if(image!=null){
            imageRepository.delete(image);
        }

        FileOutputStream out=new FileOutputStream(fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();

        saveImageOnDatabase(ownerId,file.getOriginalFilename());

        return "";

    }



    public ResponseEntity<Object> downloadFile( String id, HttpServletResponse response) {

        String fileName=imageRepository.findImageStorageByOwnerId(id).getFileName();

        String filePath = "/home/rootuser/Pictures/Uploads/" + fileName;
        Path path = Paths.get(filePath);
        UrlResource resource = null;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

            // return new ResponseEntity<Object>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
        }
    }

    public void saveImageOnDatabase(String id,String fileName){

        ImageStorage imageStorage=new ImageStorage();
        imageStorage.setFileName(fileName);
        imageStorage.setOwnerId(id);

        imageRepository.save(imageStorage);
    }
}
