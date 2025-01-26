package com.example.blog.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")  
@CrossOrigin("http://192.168.1.37:5173")
public class PostController {
    @Autowired
    private PostService postService ;
	private Post updatedPost;

    @GetMapping("/post")
    public List<Post> getAllPosts() {
    	System.err.println("1");
        return postService.getAllPosts();
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
    	System.err.println("2");
        return postService.createPost(post);
    }
    
    @PostMapping("/author/{id}")
    public  Post getAuthorById(@PathVariable Long id){
    	System.err.println("get author by  id ");
    	return postService.getAuthorBYId(id);
    }
	@PutMapping("/update/{id}")
	public Post updatePost(@PathVariable Long id,@RequestBody Post updatedPost) {
		System.out.println("this is for the update"+ id );
		return postService.updatePost(id,updatedPost);
		
}
}
