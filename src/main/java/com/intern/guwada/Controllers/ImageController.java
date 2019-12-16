package com.intern.guwada.Controllers;


import com.intern.guwada.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;


    @PostMapping(value="/upload/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@PathVariable String id,@RequestParam("photo") MultipartFile file){

        String fileName=file.getOriginalFilename();



        if(file==null)return "empty";

        try {
            imageService.uploadImage(id,file);
            return "done";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }

    @GetMapping(value="/download/{id}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Object> getImage(@PathVariable String id, HttpServletResponse response){

        return imageService.downloadFile(id,response);
    }
}
