package com.gyrus.content;

import software.amazon.awssdk.services.s3.model.S3Object;

public class Document {

    private String key;
    private Long sizeInKB;

    private Document() {
    }

    public static Document fromS3Object(S3Object s3Object) {
        Document document = new Document();
        document.setKey(s3Object.key());
        document.setSizeInKB(toKB(s3Object.size()));


        return document;
    }

    private static Long toKB(Long sizeInBytes) {
       return sizeInBytes/1024;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getSizeInKB() {
        return sizeInKB;
    }

    public void setSizeInKB(Long sizeInKB) {
        this.sizeInKB = sizeInKB;
    }
}
