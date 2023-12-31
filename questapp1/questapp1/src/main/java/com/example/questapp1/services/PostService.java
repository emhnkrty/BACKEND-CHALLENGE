package com.example.questapp1.services;
import com.example.questapp1.requests.PostUpdateRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.questapp1.entities.Post;
import com.example.questapp1.repos.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService (PostRepository postRepository) {
	this.postRepository = postRepository;
	}
	
	public List<Post> getAllPosts (Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId (userId.get());
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(Post newPost) {
		return postRepository.save(newPost);
	}
	
	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
	public void deleteOnePost(Long postId) {
	   postRepository.deleteById(postId);
	}
	

}
