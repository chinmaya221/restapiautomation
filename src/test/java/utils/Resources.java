package utils;

public class Resources {
	public static String addPostResourceJsonData() {
		String postData = "/maps/api/place/add/json";
		return postData;
	}

	public static String addPostResourceXmlData() {
		String postData = "/maps/api/place/add/xml";
		return postData;
	}

	public static String deletePostResourceData() {
		String deletePostData = "/maps/api/place/delete/json";
		return deletePostData;
	}

	public static String getNearBySearch() {
		String nearByGetData = "/maps/api/place/nearbysearch/json";
		return nearByGetData;
	}
	
	public static String createJiraIssue()
	{
		String createIssue="/rest/api/2/issue";
		return createIssue;
	}
	
	public static String deleteIssueById(String issueId)
	{
		String deleteIssue ="/rest/api/2/issue/"+issueId;
		return deleteIssue;
	}
	
	public static String createJiraSession()
	{
		String jiraLogin ="/rest/auth/1/session";
		return jiraLogin;
	}

}
