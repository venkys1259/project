package com.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class WebhookResponse{
    private String eventType;
    private String email;
    private String timeStamp;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "WebhookResponse{" +
                "eventType='" + eventType + '\'' +
                ", email='" + email + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
class Tuple{
    private String eventType;
    private String email;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class GroupByJava8 {
    public static void main(String[] args) {
        List<WebhookResponse> responseList = new ArrayList();

        WebhookResponse webhookResponse = new WebhookResponse();
        webhookResponse.setEventType("delivered");
        webhookResponse.setEmail("a@b.com");
        webhookResponse.setTimeStamp("1234");

        WebhookResponse webhookResponse2 = new WebhookResponse();
        webhookResponse2.setEventType("opened");
        webhookResponse2.setEmail("a@b.com");
        webhookResponse2.setTimeStamp("1234");

        WebhookResponse webhookResponse7 = new WebhookResponse();
        webhookResponse7.setEventType("opened");
        webhookResponse7.setEmail("a@b.com");
        webhookResponse7.setTimeStamp("1234");

        WebhookResponse webhookResponse3 = new WebhookResponse();
        webhookResponse3.setEventType("clicked");
        webhookResponse3.setEmail("a@b.com");
        webhookResponse3.setTimeStamp("1234");

        WebhookResponse webhookResponse4 = new WebhookResponse();
        webhookResponse4.setEventType("delivered");
        webhookResponse4.setEmail("b@b.com");
        webhookResponse4.setTimeStamp("123445");

        responseList.add(webhookResponse);
        responseList.add(webhookResponse2);
        responseList.add(webhookResponse3);
        responseList.add(webhookResponse4);
        responseList.add(webhookResponse7);

        Map<String, List<WebhookResponse>> details = responseList.stream().collect(groupingBy(WebhookResponse::getEmail));
        System.out.println(details);
        for(Map.Entry<String,List<WebhookResponse>> detail : details.entrySet()){
            System.out.println(detail.getKey());
            List<WebhookResponse> value = detail.getValue();
            for(WebhookResponse response : value){
                System.out.println(response.getEventType());
                System.out.println(response.getTimeStamp());
            }
        }
    }
}
