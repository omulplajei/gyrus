package com.gyrus.s3;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public class S3DelegateTest {

    @InjectMocks
    private S3Delegate s3Delegate;
    @Mock
    private S3Client s3ClientMock;

    @BeforeEach
    void setUp() {
        s3Delegate = new S3Delegate();
        initMocks(this);
    }

    @Test
    void shouldUploadFile() {
        //given
        when(s3ClientMock.putObject(any(PutObjectRequest.class), any(RequestBody.class)))
            .thenReturn(PutObjectResponse.builder().build());

        //when
        var multipartFile = new MockMultipartFile("testFile", "testFile".getBytes());
        s3Delegate.upload(multipartFile);

        //then
    }
}
