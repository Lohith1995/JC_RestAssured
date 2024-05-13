//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class ApiUtils {
//
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static void startExtentReport() {
//        extent = new ExtentReports();
//    }
//
//    public static void createTest(String testName) {
//        test = extent.createTest(testName);
//    }
//
//    public static void endTest() {
//        extent.flush();
//    }
//
//    public static void sendGetRequest(String baseURI, String endpoint, String testName) {
//        createTest(testName); // Ensure test object is initialized
//        Response response = RestAssured.get(baseURI + endpoint);
//        logRequestDetails(baseURI, endpoint);
//        logRequestHeaders();
//        logResponseDetails(response);
//    }
//
//    public static void logRequestDetails(String baseURI, String endpoint) {
//        // Log request details
//        test.log(Status.INFO, "Request URL: " + baseURI + endpoint);
//        test.log(Status.INFO, "Request Method: GET");
//    }
//
//    public static void logRequestHeaders() {
//        // Log request headers
//        test.log(Status.INFO, "Request Headers:");
//   //     RestAssured.requestSpecification.log().headers();
//    }
//
//    public static void logResponseDetails(Response response) {
//        // Log response details
//        test.log(Status.INFO, "Response Status Code: " + response.getStatusCode());
//        test.log(Status.INFO, "Response Body:");
//        test.log(Status.INFO, response.getBody().asString());
//    }
//}