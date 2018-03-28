package com.spring;

public class ResourceB {
    private String url = "http://localhost:8080/b";
    public ResourceB() {
        System.out.println("Resource B instance creation");
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
