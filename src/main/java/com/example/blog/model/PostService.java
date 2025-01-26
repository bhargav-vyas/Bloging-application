package com.example.blog.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
    	System.out.println("im in  get all post");
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
    	System.out.println("im in create post");
        return postRepository.save(post);
    }

	public Post getAuthorBYId(Long id) {
		System.out.println(" im in get authr by id");
		return postRepository.findById(id).orElse(null);
	}

	public Post updatePost(Long id, Post updatedPost) {
		System.err.println("updated  with id");
		Post existingPost = postRepository.findById(id)
				.orElseThrow(()->new RuntimeException("post not found with id "+ id));
		System.err.println("updated  with 1");
		System.err.println("updated  with 1.1");
		 	 existingPost.setTitle(updatedPost.getTitle());
		 System.err.println("updated  with 1.3");
	        existingPost.setContent(updatedPost.getContent());
	        System.err.println("updated  with 1.4");
	        existingPost.setAuthor(updatedPost.getAuthor());
	        System.err.println("updated  with 1.5");
	        
		
		//update is not fatchin
	        
		 return postRepository.save(existingPost);
			
}
}