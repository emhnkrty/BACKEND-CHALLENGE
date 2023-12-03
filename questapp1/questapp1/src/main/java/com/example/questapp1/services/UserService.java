package com.example.questapp1.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.questapp1.entities.User;
import com.example.questapp1.repos.CommentRepository;
import com.example.questapp1.repos.LikeRepository;
import com.example.questapp1.repos.PostRepository;
import com.example.questapp1.repos.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;
	LikeRepository likeRepository;
	CommentRepository commentRepository;
	PostRepository postRepository;

	public UserService(UserRepository userRepository, LikeRepository likeRepository, 
			CommentRepository commentRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.likeRepository = likeRepository;
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		java.util.Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userId) {
		try {
		userRepository.deleteById(userId);
		}catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
			System.out.println("User "+userId+" doesn't exist"); //istersek loglayabiliriz
		}
	}
}
