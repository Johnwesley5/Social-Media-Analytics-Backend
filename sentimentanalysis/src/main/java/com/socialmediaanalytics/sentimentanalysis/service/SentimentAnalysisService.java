package com.socialmediaanalytics.sentimentanalysis.service;
import com.socialmediaanalytics.sentimentanalysis.model.AnalyzedPost;
import com.socialmediaanalytics.sentimentanalysis.model.SocialMediaPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentimentAnalysisService {

    @Autowired
    private DataIngestionClient dataIngestionClient;

    private static final List<String> POSITIVE_WORDS = Arrays.asList("great", "good", "happy", "excellent", "fantastic", "amazing","love");
    private static final List<String> NEGATIVE_WORDS = Arrays.asList("worst", "bad", "sad", "terrible", "awful", "horrible","hate");

    public List<AnalyzedPost> analyzePosts() {
        List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
        return posts.stream().map(this::analyzeSentiment).collect(Collectors.toList());
    }

    private AnalyzedPost analyzeSentiment(SocialMediaPost post) {
        String content = post.getContent().toLowerCase();
        long positiveCount = POSITIVE_WORDS.stream().filter(content::contains).count();
        long negativeCount = NEGATIVE_WORDS.stream().filter(content::contains).count();

        String sentiment;
        if (positiveCount > negativeCount) {
            sentiment = "Positive";
        } else if (negativeCount > positiveCount) {
            sentiment = "Negative";
        } else {
            sentiment = "Neutral";
        }

        return new AnalyzedPost(post.getId(), post.getUser(), post.getContent(), post.getTimestamp(), sentiment);
    }
}

// package com.socialmediaanalytics.sentimentanalysis.service;

// import com.socialmediaanalytics.sentimentanalysis.model.AnalyzedPost;
// import com.socialmediaanalytics.sentimentanalysis.model.SocialMediaPost;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class SentimentAnalysisService {

//     @Autowired
//     private DataIngestionClient dataIngestionClient;

//     private static final List<String> POSITIVE_WORDS = Arrays.asList("great", "good", "happy", "excellent", "fantastic", "amazing","Love");
//     private static final List<String> NEGATIVE_WORDS = Arrays.asList("worst", "bad", "sad", "terrible", "awful", "horrible","hate");

//     public List<AnalyzedPost> analyzePosts() {
//         List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
//         return posts.stream().map(this::analyzeSentiment).collect(Collectors.toList());
//     }

//     public String analyze(String content) {
//         content = content.toLowerCase();
//         long positiveCount = POSITIVE_WORDS.stream().filter(content::contains).count();
//         long negativeCount = NEGATIVE_WORDS.stream().filter(content::contains).count();

//         if (positiveCount > negativeCount) {
//             return "Positive";
//         } else if (negativeCount > positiveCount) {
//             return "Negative";
//         } else {
//             return "Neutral";
//         }
//     }

//     private AnalyzedPost analyzeSentiment(SocialMediaPost post) {
//         String sentiment = analyze(post.getContent());
//         return new AnalyzedPost(post.getId(), post.getUser(), post.getContent(), post.getTimestamp(), sentiment);
//     }
// }
