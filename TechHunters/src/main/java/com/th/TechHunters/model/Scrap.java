package com.th.TechHunters.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "scrap_db")

@Data
public class Scrap {
	
	@Id
	private ObjectId _id;
	
	@Indexed
	private String title;
	
	private String link;
	
	private String preview;
	
	private String email;
	

	}