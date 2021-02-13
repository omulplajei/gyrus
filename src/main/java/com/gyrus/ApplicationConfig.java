package com.gyrus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class ApplicationConfig {

    @Bean
    public S3Client createS3Client() {
        return S3Client.builder()
            .region(Region.EU_WEST_1)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();
    }
}
