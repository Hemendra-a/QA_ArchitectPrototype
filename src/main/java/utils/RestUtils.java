package utils;

import Reader.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestUtils {
	private PropertiesReader prop;
	private static Logger logger;

	public RestUtils(PropertiesReader prop, Logger logger) {
		this.prop = prop;
		this.logger = logger;
	}


    public String restUtil(String id, String screenshotByte, String errorByte, String remarks,String pdfByte,String Status) {
        // Construct the JSON request body using JSONObject
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("Id", id);
        requestBodyJson.put("Screenshot_Byte", screenshotByte);
        requestBodyJson.put("Error_Byte", errorByte);
        requestBodyJson.put("Remarks", remarks);
        requestBodyJson.put("PDF_byte", pdfByte);
        requestBodyJson.put("Status", Status);

		// Convert JSONObject to String
		String requestBody = requestBodyJson.toString();
//        logger.info("Request Body: " + requestBody);
		RequestSpecification requestSpec = RestAssured.given().log().all()
				.header("accept-language", prop.getProperty("acceptLanguage"))
				.header("content-type", prop.getProperty("contentType")).header("origin", prop.getProperty("origin"))
				.header("priority", prop.getProperty("priority")).header("referer", prop.getProperty("referer"))
				.header("sec-ch-ua", prop.getProperty("secChUa"))
				.header("sec-ch-ua-mobile", prop.getProperty("secChUaMobile"))
				.header("sec-ch-ua-platform", prop.getProperty("secChUaPlatform"))
				.header("sec-fetch-des", prop.getProperty("secFetchDes"))
				.header("sec-fetch-mode", prop.getProperty("secFetchMode"))
				.header("sec-fetch-site", prop.getProperty("secFetchSite"))
				.header("user-agent", prop.getProperty("userAgent"))
				.header("x-access-token", prop.getProperty("xAccessToken"))
				.header("Content-Disposition", prop.getProperty("contentDisposition"))
				.header("Cookie", prop.getProperty("cookie")).body(requestBody);

		// Send the first request
		Response response = requestSpec.post(prop.getProperty("API_BASEURL"));
		int statusCode = response.getStatusCode();

		// Print response details
		logger.info("Response Status Code: " + statusCode);
        logger.info("Response Headers: " + response.getHeaders());
		logger.info("Response Body: " + response.getBody().asString());

		if (statusCode == 200) {
			return "Request Successful :" + statusCode;
		}
		// Retry request
		logger.info("Retrying request...");
		response = requestSpec.post(prop.getProperty("API_BASEURL"));
		statusCode = response.getStatusCode();

		// Print response details for retry
		logger.info("Retry Response Status Code: " + statusCode);
        logger.info("Retry Response Headers: " + response.getHeaders());
        logger.info("Retry Response Body: " + response.getBody().asString());

		if (statusCode == 200) {
			return "Request Successful on 1 retry :" + statusCode;
		} else {
			return "Request failed with status code: " + statusCode;
		}
	}

}