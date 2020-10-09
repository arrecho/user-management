package com.bci.users.domain.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class UserStatus {

	private UUID id;
	
	private Date created;
	
	//TODO JAVA 8
	private LocalDateTime modified;
	
	private Date last_login;
	
	private String isactive;

	public UUID getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public String isIsactive() {
		return isactive;
	}

	public UserStatus(UUID id, Date created, LocalDateTime modified, Date last_login, String isactive) {
		
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isactive = isactive;
	}
	
	
	
}
