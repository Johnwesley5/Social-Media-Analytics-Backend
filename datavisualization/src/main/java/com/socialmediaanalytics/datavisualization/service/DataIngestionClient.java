package com.socialmediaanalytics.datavisualization.service;

import com.socialmediaanalytics.datavisualization.model.SocialMediaPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "data-ingestion-service", url = "http://localhost:8001")
public interface DataIngestionClient {

    @GetMapping("/ingestion/getPosts")
    List<SocialMediaPost> getAllPosts();
}


