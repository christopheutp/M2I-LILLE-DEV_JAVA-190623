package com.example.demo_springmvc_resttemplate.controllers;

import com.example.demo_springmvc_resttemplate.models.PostDTO;
import com.example.demo_springmvc_resttemplate.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {
    private final PostService postService;

    @GetMapping("in-string")
    public List<String> getPostsTitles() {
//        postService.getPostsString();
//        postService.getPostsMap();
//        postService.getPostsJsonNode();
        postService.getPosts();
        return postService.getPostsTitles();
    }
}
