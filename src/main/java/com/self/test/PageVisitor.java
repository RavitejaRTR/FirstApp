package com.self.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagevisitor")
public class PageVisitor {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String contact;
	private String profession;
	private String comment;
	
	public PageVisitor() {}		//no-arg constructor
	
	public PageVisitor(String name, String email, String contact, String profession, String comment) {
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.profession = profession;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PageVisitor [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact
				+ ", profession=" + profession + ", comment=" + comment + "]";
	}
	
}
