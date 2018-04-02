package com.rest.responsepojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo 
{
	@SerializedName("loginCount")
	@Expose
	private Integer loginCount;
	@SerializedName("previousLoginTime")
	@Expose
	private String previousLoginTime;

	public Integer getLoginCount() {
	return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
	this.loginCount = loginCount;
	}

	public String getPreviousLoginTime() {
	return previousLoginTime;
	}

	public void setPreviousLoginTime(String previousLoginTime) {
	this.previousLoginTime = previousLoginTime;
	}

}
