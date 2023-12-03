package com.example.questapp1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user")
@Data

public class User {
	@Id
	Long id;
	String userName;
	String password;
	
	public String getUserName() {
	   return userName;
	}

	public void setUserName(String userName) {
	   this.userName = userName;
	}

	public String getPassword() {
	   return password;
	}

	public void setPassword(String password) {
	   this.password = password;
	}
}
