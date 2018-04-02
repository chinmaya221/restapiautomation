package com.rest.requestpojo;

import com.rest.requestpojo.Fields;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateJiraIssue 
{
	@SerializedName("fields")
	@Expose
	private Fields fields;

	public Fields getFields() {
	return fields;
	}

	public void setFields(Fields fields) {
	this.fields = fields;
	}


}
