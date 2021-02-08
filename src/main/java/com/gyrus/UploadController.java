package com.gyrus;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@RestController
@RequestMapping("/api")
public class UploadController {

    private static final String S3_BUCKET = "gyrus-bucket";


    @PostMapping("/upload")
    public RedirectView upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        S3Client s3Client = S3Client.builder()
            .region(Region.EU_WEST_1)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();

        System.out.println(s3Client.listBuckets().buckets().get(0).name());

        PutObjectRequest objectRequest = PutObjectRequest.builder()
            .bucket(S3_BUCKET)
            .key(file.getName())
            .build();
        try {
            s3Client.putObject(objectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());

        return new RedirectView("/success", true);
    }
}
