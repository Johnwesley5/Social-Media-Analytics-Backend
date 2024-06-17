package com.socialmediaanalytics.dataingestionservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmediaanalytics.dataingestionservice.model.SocialMediaPost;
import com.socialmediaanalytics.dataingestionservice.repository.SocialMediaPostRepository;

@Service
public class SocialMediaPostService {

    @Autowired
    private SocialMediaPostRepository repository;

    public SocialMediaPost savePost(SocialMediaPost post) {
        return repository.save(post);
    }

    public List<SocialMediaPost> getAllPosts() {
        return repository.findAll();
    }
    public Optional<SocialMediaPost> getPostById(Long id) {
        return repository.findById(id);
    }

    public SocialMediaPost updatePost(Long id, SocialMediaPost updatedPost) {
        return repository.findById(id).map(post -> {
            post.setUser(updatedPost.getUser());
            post.setContent(updatedPost.getContent());
            post.setTimestamp(updatedPost.getTimestamp());
            return repository.save(post);
        }).orElseGet(() -> {
            updatedPost.setId(id);
            return repository.save(updatedPost);
        });
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }
}
