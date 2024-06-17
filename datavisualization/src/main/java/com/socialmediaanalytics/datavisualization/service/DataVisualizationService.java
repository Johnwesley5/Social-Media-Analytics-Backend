// package com.socialmediaanalytics.datavisualization.service;

// import com.socialmediaanalytics.datavisualization.model.SocialMediaPost;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.knowm.xchart.PieChart;
// import org.knowm.xchart.PieChartBuilder;
// import org.knowm.xchart.BitmapEncoder;

// import java.awt.*;
// import java.io.ByteArrayOutputStream;
// import java.io.IOException;
// import java.util.List;

// @Service
// public class DataVisualizationService {

//     @Autowired
//     private DataIngestionClient dataIngestionClient;

//     @Autowired
//     private SentimentAnalysisClient sentimentAnalysisClient;

//     @Autowired
//     private TrendDetectionClient trendDetectionClient;

//     public byte[] generateSentimentPieChart() throws IOException {
//         List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
//         int positive = 0, negative = 0, neutral = 0;

//         for (SocialMediaPost post : posts) {
//             String sentiment = sentimentAnalysisClient.analyzeSentiment(post.getContent());
//             switch (sentiment) {
//                 case "Positive":
//                     positive++;
//                     break;
//                 case "Negative":
//                     negative++;
//                     break;
//                 case "Neutral":
//                     neutral++;
//                     break;
//             }
//         }

//         PieChart chart = new PieChartBuilder().width(800).height(600).title("Sentiment Analysis").build();
//         chart.addSeries("Positive", positive);
//         chart.addSeries("Negative", negative);
//         chart.addSeries("Neutral", neutral);
//         chart.getStyler().setSeriesColors(new Color[]{new Color(0, 204, 0), new Color(255, 0, 0), new Color(255, 204, 0)});

//         ByteArrayOutputStream baos = new ByteArrayOutputStream();
//         BitmapEncoder.saveBitmap(chart, baos, BitmapEncoder.BitmapFormat.PNG);
//         return baos.toByteArray();
//     }
// }
package com.socialmediaanalytics.datavisualization.service;

import com.socialmediaanalytics.datavisualization.model.SocialMediaPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.BitmapEncoder;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DataVisualizationService {

    @Autowired
    private DataIngestionClient dataIngestionClient;

    @Autowired
    private SentimentAnalysisClient sentimentAnalysisClient;

    private static final Logger LOGGER = Logger.getLogger(DataVisualizationService.class.getName());

    public byte[] generateSentimentPieChart() throws IOException {
        List<SocialMediaPost> posts = dataIngestionClient.getAllPosts();
        LOGGER.info("Fetched posts: " + posts);

        int positive = 0, negative = 0, neutral = 0;

        for (SocialMediaPost post : posts) {
            String sentiment = sentimentAnalysisClient.analyzeSentiment(post.getContent());
            LOGGER.info("Post: " + post.getContent() + " | Sentiment: " + sentiment);
            switch (sentiment) {
                case "Positive":
                    positive++;
                    break;
                case "Negative":
                    negative++;
                    break;
                case "Neutral":
                    neutral++;
                    break;
            }
        }

        LOGGER.info("Sentiment counts - Positive: " + positive + ", Negative: " + negative + ", Neutral: " + neutral);

        // If all counts are zero, add a dummy value to ensure the chart is rendered
        if (positive == 0 && negative == 0 && neutral == 0) {
            positive = 1;
        }

        PieChart chart = new PieChartBuilder().width(800).height(600).title("Sentiment Analysis").build();
        chart.addSeries("Positive", positive);
        chart.addSeries("Negative", negative);
        chart.addSeries("Neutral", neutral);
        chart.getStyler().setSeriesColors(new Color[]{new Color(0, 204, 0), new Color(255, 0, 0), new Color(255, 204, 0)});

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BitmapEncoder.saveBitmap(chart, baos, BitmapEncoder.BitmapFormat.PNG);
        return baos.toByteArray();
    }
}
