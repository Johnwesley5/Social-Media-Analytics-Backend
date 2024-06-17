package com.socialmediaanalytics.sentimentanalysis.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.socialmediaanalytics.sentimentanalysis.model.SocialMediaPost;

@FeignClient(name = "data-ingestion-service", url = "http://localhost:8001")
public interface DataIngestionClient {
    @GetMapping("/ingestion/getPosts")
    List<SocialMediaPost> getAllPosts();
}
