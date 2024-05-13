import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.APIConfigReader;
import utilities.ExtentReportUtils;
//import utilities.ExtentReportUtils;

import java.io.IOException;
import java.text.ParseException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.println;
import static org.testng.Assert.assertEquals;

//public class GetAPI {
//    @Test
//    public void testStatusCode() {
//        baseURI = "https://stage-content-jiovoot.voot.com";
//        Response response = given()
//                .param("sort", "season")
//                .param("ids", "3744709")
//                .param("responseType", "common")
//                .when()
//                .get("/psapi/voot/v1/voot-web/content/query/asset-details");
//        response.prettyPrint();
//        //    test.log(Status.INFO, "Request URL: " + baseURI );
//        int statuscode = response.getStatusCode();
//        assertEquals(statuscode, 200);
//    }
//}

//public class GetAPI {
//    @Test
//    public void testStatusCode() throws IOException, org.json.simple.parser.ParseException {
//        JSONObject apiConfig = APIConfigReader.getAPIConfig("getAPI", "src/main/resources/GetAPI_Scenarios/AssetDetails.json");
//        String baseURL = (String) apiConfig.get("baseURL");
//        String endpoint = (String) apiConfig.get("endpoint");
//        JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
//
//        baseURI = baseURL;
//        Response response = given()
//                .queryParams(queryParams)
//                .when()
//                .get(endpoint);
//
//        response.prettyPrint();
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }
//}

//public class GetAPI {
//    @Test
//    public void testStatusCode() throws IOException, org.json.simple.parser.ParseException {
//
//        JSONObject apiConfig = APIConfigReader.getAPIConfig("AssetDetails-API", "src/main/resources/testCases/AssetDetails.json");
//
//        // Print scenario
//        String scenario = (String) apiConfig.get("Scenario");
//        System.out.println("Scenario: " + scenario);
//
//        // Print baseURL and endpoint
//        String baseURL = (String) apiConfig.get("baseURL");
//        String endpoint = (String) apiConfig.get("endpoint");
//        System.out.println("URL: " + baseURL+endpoint);
//
//        JSONObject headers = (JSONObject) apiConfig.get("headers");
//        Gson gson = new Gson();
//        System.out.println("Headers: " + gson.toJson(headers));
//        //  System.out.println("Headers: " + headers.toString());
//
//        JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
//        System.out.println("Query Params: " + queryParams);

//
//        baseURI = baseURL;
//        Response response = given()
//                .queryParams(queryParams)
//                .when()
//                .get(endpoint);
//
//        response.prettyPrint();
//
//        // Verify status code
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//
//    }
//    }




import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.json.simple.JSONObject;
import java.io.IOException;
//import org.json.simple.parser.ParseException;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetAPI {

    @Test
    public void testStatusCode() throws IOException, ParseException, org.json.simple.parser.ParseException {

        // Get API configuration
        JSONObject apiConfig = APIConfigReader.getAPIConfig("AssetDetails-API", "src/main/resources/testCases/AssetDetails.json");

        // Initialize Extent report
        ExtentReportUtils.getInstance("src/main/ExtentReport/extentReport.html");

        // Create a test in the report
 //       ExtentReportUtils.createTest("Test API");

        // Set base URI and make the API call
        baseURI = (String) apiConfig.get("baseURL");
        String endpoint = (String) apiConfig.get("endpoint");
        Response response = given()
                .queryParams((JSONObject) apiConfig.get("queryParams"))
                .when()
                .get(endpoint);
        response.prettyPrint();
        ExtentReportUtils.TestLogInfo(apiConfig);
    //    println(apiConfig);
        APIConfigReader apiConfigReader = new APIConfigReader();
        apiConfigReader.printAPIDetails(apiConfig);

        // Verify status code
        int statusCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(200, statusCode);
        softAssert.assertAll();
        ExtentReportUtils.logInfo("<b>Status Code:</b> " + statusCode);
        String responseBody = response.getBody().asString();
        ExtentReportUtils.logResponse(responseBody);

        // Flush the Extent report
        ExtentReportUtils.flushReport();
    }
}







