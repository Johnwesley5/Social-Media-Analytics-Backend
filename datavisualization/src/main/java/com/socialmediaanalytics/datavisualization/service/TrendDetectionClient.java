package com.socialmediaanalytics.datavisualization.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "trend-detection-service", url = "http://localhost:8003")
public interface TrendDetectionClient {

    @GetMapping("/trends/detect")
    String detectTrend();
}

