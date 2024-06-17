package com.socialmediaanalytics.sentimentanalysis.controller;

import com.socialmediaanalytics.sentimentanalysis.model.AnalyzedPost;
import com.socialmediaanalytics.sentimentanalysis.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sentiment")
public class SentimentAnalysisController {

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @GetMapping("/analyze")
    public List<AnalyzedPost> analyzePosts() {
        return sentimentAnalysisService.analyzePosts();
    }
}

// package com.socialmediaanalytics.sentimentanalysis.controller;

// import com.socialmediaanalytics.sentimentanalysis.service.SentimentAnalysisService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.logging.Logger;

// @RestController
// @RequestMapping("/sentiment")
// public class SentimentAnalysisController {

//     @Autowired
//     private SentimentAnalysisService sentimentAnalysisService;

//     private static final Logger LOGGER = Logger.getLogger(SentimentAnalysisController.class.getName());

//     @GetMapping("/analyze")
//     public String analyzeSentiment(@RequestParam("postContent") String postContent) {
//         String sentiment = sentimentAnalysisService.analyze(postContent);
//         LOGGER.info("Post: " + postContent + " | Sentiment: " + sentiment);
//         return sentiment;
//     }
// }

