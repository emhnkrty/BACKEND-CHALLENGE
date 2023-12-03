package com.example.questapp1.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.questapp1.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByUserId(Long userId);

	List<Long> findTopByUserId(@Param("userId") Long userId);
}
