package com.socialmediaanalytics.userprofiling.controller;

import com.socialmediaanalytics.userprofiling.model.UserProfile;
import com.socialmediaanalytics.userprofiling.service.UserProfilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfilingController {

    @Autowired
    private UserProfilingService userProfilingService;

    @GetMapping("/generate")
    public List<UserProfile> generateProfiles() {
        return userProfilingService.generateProfiles();
    }
}

