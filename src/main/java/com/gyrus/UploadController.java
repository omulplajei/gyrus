package com.gyrus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UploadController {


    @PostMapping("/upload")
    public ResponseEntity<Response> upload() {

        return ResponseEntity.ok().build();
    }


}
