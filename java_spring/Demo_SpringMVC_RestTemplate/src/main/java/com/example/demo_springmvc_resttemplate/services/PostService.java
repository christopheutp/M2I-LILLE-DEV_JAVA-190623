package com.example.demo_springmvc_resttemplate.services;

import com.example.demo_springmvc_resttemplate.models.PostDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class PostService {
    private final RestTemplateBuilder builder;

    public ResponseEntity<String> getPostsString() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<String> entityString = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);

        return entityString;
    }

    public ResponseEntity<Map> getPostsMap() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<Map> entityString = restTemplate
                .getForEntity("/posts/1", Map.class);

        Integer userId = (Integer) entityString.getBody().get("userId");

        return entityString;
    }

    public ResponseEntity<JsonNode> getPostsJsonNode() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<JsonNode> entityString = restTemplate
                .getForEntity("https://swapi.dev/api/films", JsonNode.class);

        List<String> titles = new ArrayList<>();

        entityString.getBody().findPath("results").elements().forEachRemaining(e -> {
            String title = e.findPath("title").asText();
            titles.add(title);
        });

        return entityString;
    }

    public ResponseEntity<PostDTO[]> getPosts() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<PostDTO[]> entityString = restTemplate
                .getForEntity("/posts", PostDTO[].class);

        return entityString;
    }

    public List<String> getPostsTitles() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<PostDTO[]> entityString = restTemplate
                .getForEntity("/posts", PostDTO[].class);

        List<String> titles = Arrays.stream(entityString.getBody())
                .map(p -> p.getTitle())
                .collect(Collectors.toList());

        return titles;
    }
}
