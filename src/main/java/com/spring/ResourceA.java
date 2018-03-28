package com.spring;

public class ResourceA {
    private String url = "http://localhost:8080/a";

    public ResourceA() {
        System.out.println("Resource A instance creation");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
