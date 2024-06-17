package com.socialmediaanalytics.trenddetection.service;

import com.socialmediaanalytics.trenddetection.model.SocialMediaPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrendDetectionService {

    @Autowired
    private DataIngestionClient dataIngestionClient;

    private static final List<String> TREND_KEYWORDS = Arrays.asList(
        "love", "great", "good", "happy", "excellent", "fantastic", "amazing",
        "worst", "bad", "sad", "terrible", "awful", "horrible"
    );

    public String detectTrend() {
        List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
        Map<String, Long> keywordCounts = new HashMap<>();

        for (SocialMediaPost post : posts) {
            String content = post.getContent().toLowerCase();
            for (String keyword : TREND_KEYWORDS) {
                if (content.contains(keyword)) {
                    keywordCounts.put(keyword, keywordCounts.getOrDefault(keyword, 0L) + 1);
                }
            }
        }

        return keywordCounts.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No trends detected");
    }
}

