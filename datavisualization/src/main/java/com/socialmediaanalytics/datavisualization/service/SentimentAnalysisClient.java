package com.socialmediaanalytics.datavisualization.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sentiment-analysis-service", url = "http://localhost:8002")
public interface SentimentAnalysisClient {

    @GetMapping("/sentiment/analyze")
    String analyzeSentiment(@RequestParam("postContent") String postContent);
}


