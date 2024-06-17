package com.socialmediaanalytics.trenddetection.controller;

import com.socialmediaanalytics.trenddetection.service.TrendDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trends")
public class TrendDetectionController {

    @Autowired
    private TrendDetectionService trendDetectionService;

    @GetMapping("/detect")
    public String detectTrend() {
        return trendDetectionService.detectTrend();
    }
}

