package com.gyrus.s3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
public class S3Delegate {

    private static final String S3_BUCKET = "gyrus-bucket";

    private Logger LOG = LoggerFactory.getLogger(S3Delegate.class);

    private S3Client s3Client;

    public S3Delegate() {
        s3Client = S3Client.builder()
            .region(Region.EU_WEST_1)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();
    }

    public void upload(MultipartFile file) {
        LOG.info("Uploading file " + file.getOriginalFilename());

        PutObjectRequest objectRequest = PutObjectRequest.builder()
            .bucket(S3_BUCKET)
            .key(file.getOriginalFilename())
            .contentType(file.getContentType())
            .build();
        try {
            s3Client.putObject(objectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (IOException e) {
            LOG.error("Exception while uploading file ", e);
        }
    }
}
