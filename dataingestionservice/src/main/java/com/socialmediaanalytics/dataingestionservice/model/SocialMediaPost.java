package com.socialmediaanalytics.dataingestionservice.model;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class SocialMediaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String content;
    private LocalDateTime timestamp;

    // Constructors, getters, and setters

    public SocialMediaPost() {}

    public SocialMediaPost(String user, String content, LocalDateTime timestamp) {
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
