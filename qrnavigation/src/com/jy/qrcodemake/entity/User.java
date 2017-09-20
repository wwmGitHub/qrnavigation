package com.jy.qrcodemake.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "qrcodemake")
public class User implements java.io.Serializable {
	// Fields
	private String userId;
	private String userLoginName;
	private String userLoginPass;
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public User(String userId, String userLoginName, String userLoginPass
			) {
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userLoginPass = userLoginPass;
		
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_login_name")
	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	@Column(name = "user_login_pass")
	public String getUserLoginPass() {
		return this.userLoginPass;
	}

	public void setUserLoginPass(String userLoginPass) {
		this.userLoginPass = userLoginPass;
	}
}
