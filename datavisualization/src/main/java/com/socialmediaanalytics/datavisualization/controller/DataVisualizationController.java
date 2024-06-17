package com.socialmediaanalytics.datavisualization.controller;

import com.socialmediaanalytics.datavisualization.service.DataVisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/visualization")
public class DataVisualizationController {

    @Autowired
    private DataVisualizationService dataVisualizationService;

    @GetMapping("/sentiment")
    public void getSentimentPieChart(HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        byte[] chart = dataVisualizationService.generateSentimentPieChart();
        response.getOutputStream().write(chart);
    }
}
