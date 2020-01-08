package com.th.TechHunters.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Document("user_db")
@Getter
@Setter
public class User {
@Id
	private ObjectId _id;
	private String email;
	private String pwd;
	private String name;
	
}



