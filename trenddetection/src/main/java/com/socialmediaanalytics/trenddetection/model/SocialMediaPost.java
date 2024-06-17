package com.socialmediaanalytics.trenddetection.model;
import java.time.LocalDateTime;

public class SocialMediaPost {

    private Long id;
    private String user;
    private String content;
    private LocalDateTime timestamp;
    public SocialMediaPost() {
    }
    public SocialMediaPost(Long id, String user, String content, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
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

    
    
}
