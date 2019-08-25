package com.stackroute.socketone.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Tweets {
    WebClient client = WebClient.builder()
            .baseUrl("https://api.twitter.com/1.1/")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @GetMapping("/me/tweets")
    public Flux<?> getTweets() {
        List<Object> myArray = new ArrayList<>();
        Flux<?> response = Flux.fromIterable(myArray);

        return client.get()
                .uri("statuses/home_timeline.json")
                .header("Authorization", "OAuth oauth_consumer_key=\"s8Z6UCli9JpRzamPg5bLLMb1i\",oauth_token=\"1164104302207438848-cVcvP7KPSNjx9YrSxm4xyVLvjpyzxF\",oauth_version=\"1.0\",oauth_signature_method=\"HMAC-SHA1\"")
                .retrieve()
                .bodyToFlux(Object.class);

//        ,oauth_signature="tnnArxj06cWHq44gCs1OSKk/jLY=  ",oauth_nonce="kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg\,oauth_timestamp="1566389000",

    }

}



