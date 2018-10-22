package com.self.test;

public class Post {
	private String userId;
	private String id;
	private String title;
	private String body;
	
	public Post() {
		userId = "1004";
		id = "1";
		title = "First Response";
		body = "Building rest service";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
