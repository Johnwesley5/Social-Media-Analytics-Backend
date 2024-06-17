package com.socialmediaanalytics.dataingestionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmediaanalytics.dataingestionservice.model.SocialMediaPost;

public interface SocialMediaPostRepository extends JpaRepository<SocialMediaPost, Long>{
    
}
