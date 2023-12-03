package com.example.questapp1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp1.entities.Post;
import com.example.questapp1.services.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam java.util.Optional<Long> userId) {
		return postService.getAllPosts(userId);
	}


	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody Post newPost) {
		return postService.createOnePost(newPost);
	}
	

}
