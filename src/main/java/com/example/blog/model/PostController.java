package com.example.blog.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService ;

    @GetMapping
    public List<Post> getAllPosts() {
    	System.err.println("1");
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
    	System.err.println("2");
        return postService.createPost(post);

    }
}
