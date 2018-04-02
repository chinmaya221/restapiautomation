package utils;

public class PayLoad {
	public static String postJsonData() {

		String jsonPostBody = "{"
				+ "\"location\": {"
				+ "\"lat\": -33.8669710,"
				+ "\"lng\": 151.1958750"
				+ "},"
				+ "\"accuracy\": 50,"
				+ "\"name\": \"Google Shoes!\","
				+ "\"phone_number\": \"(02) 9374 4001\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\"" + "}";

		return jsonPostBody;

	}

	public static String jsonDeleteData(String placeId) {
		String jsonDeleteData = "{" + "\"place_id\":\"" + placeId + "\"" + "}";
		return jsonDeleteData;
	}

	public static String jsonJiraCreateIssuePostData(String key) {
		String createJiraIssuePostData = "{" + "\"fields\": {"
				+ "\"project\":{" + "\"key\": \"" + key + "\"},"
				+ "\"summary\": \"creating my credit card details\","
				+ "\"description\": \"Create my 3rd bug using the REST API\","
				+ "\"issuetype\": {" + "\"name\": \"Bug\"}" + "}" + "}";
		return createJiraIssuePostData;
	}

	public static String loginToJiraPostData() {
		String jiraLoginPostData = "{" + "\"username\":\"chinmaya\","
				+ "\"password\":\"ck2016d\"" + "}";
		return jiraLoginPostData;
	}

}
