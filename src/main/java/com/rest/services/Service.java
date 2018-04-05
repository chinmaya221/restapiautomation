package com.rest.services;

import utils.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.rest.requestpojo.CreateJiraIssue;
import com.rest.requestpojo.Fields;
import com.rest.requestpojo.Issuetype;
import com.rest.requestpojo.LoginApi;
import com.rest.requestpojo.Project;
import com.rest.responsepojo.LoginResponse;

/**
 * @author TEChinnmaya41
 * 
 *
 */

public class Service {

	public static String key = "JIR";
	public static String summary = "creating my credit card details";
	public static String description = "Create my 2nd bug using the REST API";
	public static String name = "Bug";

	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws JsonProcessingException
	 */
	public Response jiraLoginAuth(String username, String password)
			throws JsonProcessingException {
		LoginApi login = new LoginApi();
		login.setUsername(username);
		login.setPassword(password);

		String jsonString = ReusableMethods.jsonToString(login);

		Response response = RestAssured.given()
				.header("Content-Type", "application/json").body(jsonString)
				.post(ServiceURL.jiraLoginUrl).then().extract().response();

		return response;

	}

	
	/**
	 * @param key
	 * @param summary
	 * @param description
	 * @param name
	 * @return
	 * @throws Exception
	 */
	
	public Response createIssueInJira(String key, String summary,
			String description, String name) throws Exception {
		CreateJiraIssue createJiraIssue = new CreateJiraIssue();
		Fields fields = new Fields();
		createJiraIssue.setFields(fields);
		fields.setDescription(description);
		fields.setSummary(summary);
		Project project = new Project();
		fields.setProject(project);
		Issuetype issue = new Issuetype();
		fields.setIssuetype(issue);
		issue.setName(name);
		project.setKey(key);

		String jsonString = ReusableMethods.jsonToString(createJiraIssue);

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.header("Cookie", "JSESSIONID="
				+ getJiraSessionId());
		requestSpecification.body(jsonString);
		Response response = requestSpecification
				.post(ServiceURL.jiraIssueCreation);

		return response;

	}

	/**
	 * getting Jira sessionId
	 * @return
	 * @throws Exception
	 */
	public static String getJiraSessionId() throws Exception {
		Service service = new Service();
		Response response = service.jiraLoginAuth(
				ReusableMethods.getPropData("username"),
				ReusableMethods.getPropData("password"));
		Gson gson = new Gson();
		LoginResponse loginRes = gson.fromJson(response.asString(),
				LoginResponse.class);

		String sessionId = loginRes.getSession().getValue();
		return sessionId;
	}

	/*
	 * public static void main(String[] args) throws Exception { Service service
	 * = new Service();
	 * 
	 * // System.out.println(getJiraSessionId()); Response data =
	 * service.createIssueInJira(key, summary, description, name);
	 * System.out.println(data.asString()); Gson gson = new Gson();
	 * CreateJiraIssueResponse createJiraIssueResponse = gson.fromJson(
	 * data.asString(), CreateJiraIssueResponse.class);
	 * 
	 * System.out.println(createJiraIssueResponse.getId());
	 * 
	 * }
	 */

}
