package com.th.TechHunters.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Document("conference_db")
@Getter
@Setter
public class Conference {
	
	@Id
	private ObjectId _id;
	private String title;
	private String link;
	private String date;
	private String place;
	private String img;
}