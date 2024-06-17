package com.socialmediaanalytics.dataingestionservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialmediaanalytics.dataingestionservice.model.SocialMediaPost;
import com.socialmediaanalytics.dataingestionservice.service.SocialMediaPostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingestion")
public class DataIngestionController {

    @Autowired
    private SocialMediaPostService service;

    @PostMapping("/addPost")
    public SocialMediaPost ingestData(@RequestBody SocialMediaPost post) {
        return service.savePost(post);
    }

    @GetMapping("/getPosts")
    public List<SocialMediaPost> getData() {
        return service.getAllPosts();
    }
    @GetMapping("/getPost/{id}")
    public Optional<SocialMediaPost> getDataById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PutMapping("/updatePost/{id}")
    public SocialMediaPost updateData(@PathVariable Long id, @RequestBody SocialMediaPost updatedPost) {
        return service.updatePost(id, updatedPost);
    }

    @DeleteMapping("/deletePost/{id}")
    public String deleteData(@PathVariable Long id) {
        service.deletePost(id);
        return "Post with ID " + id + " has been deleted.";
    }
}

