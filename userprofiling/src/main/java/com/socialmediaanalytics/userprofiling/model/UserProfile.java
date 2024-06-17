package com.socialmediaanalytics.userprofiling.model;

import java.util.Map;

public class UserProfile {
    private String user;
    private Map<String, Long> wordFrequency;
    private String predominantSentiment;
    private Map<String, Long> activeTimes;
    public UserProfile() {
    }
    public UserProfile(String user, Map<String, Long> wordFrequency, String predominantSentiment,
            Map<String, Long> activeTimes) {
        this.user = user;
        this.wordFrequency = wordFrequency;
        this.predominantSentiment = predominantSentiment;
        this.activeTimes = activeTimes;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Map<String, Long> getWordFrequency() {
        return wordFrequency;
    }
    public void setWordFrequency(Map<String, Long> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }
    public String getPredominantSentiment() {
        return predominantSentiment;
    }
    public void setPredominantSentiment(String predominantSentiment) {
        this.predominantSentiment = predominantSentiment;
    }
    public Map<String, Long> getActiveTimes() {
        return activeTimes;
    }
    public void setActiveTimes(Map<String, Long> activeTimes) {
        this.activeTimes = activeTimes;
    }

    
}
