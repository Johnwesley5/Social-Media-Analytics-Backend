package com.socialmediaanalytics.trenddetection.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.socialmediaanalytics.trenddetection.model.SocialMediaPost;

import java.util.List;

@FeignClient(name = "data-ingestion-service", url = "http://localhost:8001")
public interface DataIngestionClient {

    @GetMapping("/ingestion/getPosts")
    List<SocialMediaPost> getAllPosts();
}

