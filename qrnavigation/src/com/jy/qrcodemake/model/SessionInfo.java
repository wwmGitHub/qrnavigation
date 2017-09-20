package com.jy.qrcodemake.model;

import java.io.Serializable;

public class SessionInfo  implements Serializable {
	private String userId;
	private String userLoginName;
	private String userLoginPass;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserLoginPass() {
		return userLoginPass;
	}
	public void setUserLoginPass(String userLoginPass) {
		this.userLoginPass = userLoginPass;
	}
	
	
}
