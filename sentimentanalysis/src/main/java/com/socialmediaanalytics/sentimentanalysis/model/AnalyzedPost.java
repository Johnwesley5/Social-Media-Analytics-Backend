package com.socialmediaanalytics.sentimentanalysis.model;

import java.time.LocalDateTime;

public class AnalyzedPost {

    private Long id;
    private String user;
    private String content;
    private LocalDateTime timestamp;
    private String sentiment;
    public AnalyzedPost() {
    }
    public AnalyzedPost(Long id, String user, String content, LocalDateTime timestamp, String sentiment) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
        this.sentiment = sentiment;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getSentiment() {
        return sentiment;
    }
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
    @Override
    public String toString() {
        return "AnalyzedPost [id=" + id + ", user=" + user + ", content=" + content + ", timestamp=" + timestamp
                + ", sentiment=" + sentiment + "]";
    }

  
}
