package com.socialmediaanalytics.userprofiling.service;
import com.socialmediaanalytics.userprofiling.model.SocialMediaPost;
import com.socialmediaanalytics.userprofiling.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class UserProfilingService {

    @Autowired
    private DataIngestionClient dataIngestionClient;

    private static final List<String> POSITIVE_WORDS = Arrays.asList("love", "great", "good", "happy", "excellent", "fantastic", "amazing");
    private static final List<String> NEGATIVE_WORDS = Arrays.asList("worst", "bad", "sad", "terrible", "awful", "horrible");

    public List<UserProfile> generateProfiles() {
        List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
        Map<String, List<SocialMediaPost>> postsByUser = new HashMap<>();

        for (SocialMediaPost post : posts) {
            postsByUser.computeIfAbsent(post.getUser(), k -> new ArrayList<>()).add(post);
        }

        List<UserProfile> profiles = new ArrayList<>();
        for (Map.Entry<String, List<SocialMediaPost>> entry : postsByUser.entrySet()) {
            String user = entry.getKey();
            List<SocialMediaPost> userPosts = entry.getValue();

            Map<String, Long> wordFrequency = new HashMap<>();
            Map<String, Long> activeTimes = new HashMap<>();
            Map<String, Integer> sentimentCounts = new HashMap<>();
            sentimentCounts.put("Positive", 0);
            sentimentCounts.put("Negative", 0);
            sentimentCounts.put("Neutral", 0);

            for (SocialMediaPost post : userPosts) {
                String[] words = post.getContent().toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0L) + 1);
                    }
                }

                LocalTime postTime = post.getTimestamp().toLocalTime();
                String timeSlot = postTime.getHour() + ":00-" + (postTime.getHour() + 1) + ":00";
                activeTimes.put(timeSlot, activeTimes.getOrDefault(timeSlot, 0L) + 1);

                String sentiment = analyzeSentiment(post.getContent());
                sentimentCounts.put(sentiment, sentimentCounts.get(sentiment) + 1);
            }

            String predominantSentiment = sentimentCounts.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("Neutral");

            profiles.add(new UserProfile(user, wordFrequency, predominantSentiment, activeTimes));
        }

        return profiles;
    }

    private String analyzeSentiment(String content) {
        int positiveCount = 0;
        int negativeCount = 0;

        String[] words = content.toLowerCase().split("\\W+");
        for (String word : words) {
            if (POSITIVE_WORDS.contains(word)) {
                positiveCount++;
            } else if (NEGATIVE_WORDS.contains(word)) {
                negativeCount++;
            }
        }

        if (positiveCount > negativeCount) {
            return "Positive";
        } else if (negativeCount > positiveCount) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}
