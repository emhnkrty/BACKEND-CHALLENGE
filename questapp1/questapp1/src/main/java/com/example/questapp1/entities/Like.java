package com.example.questapp1.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
public class Like {
	@Id
	Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Post post;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;
	
}
