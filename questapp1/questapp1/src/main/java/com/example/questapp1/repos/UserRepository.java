package com.example.questapp1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp1.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUserName(String userName);
}
