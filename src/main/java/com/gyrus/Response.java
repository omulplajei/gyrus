package com.gyrus;

public class Response {

    private String status;

    public static Response OK = new Response("OK");

    public Response(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
