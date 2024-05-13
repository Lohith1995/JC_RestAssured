package utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.json.simple.JSONObject;
//
//public class ExtentReportUtils {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static void initializeExtentReport(String reportFilePath) {
//        extent = new ExtentReports();
//        extent.attachReporter(ExtentManager.createExtentHtmlReporter(reportFilePath));
//    }
//
//    public static ExtentTest createTest(String testName) {
//        test = extent.createTest(testName);
//        return test;
//    }
//
//    public static void logInfo(String message) {
//        test.log(Status.INFO, message);
//    }
//
//    public static void logScenarioInfo(JSONObject apiConfig) {
//        logInfo("Scenario: " + apiConfig.get("Scenario"));
//    }
//
//    public static void logAPIDetails(JSONObject apiConfig) {
//        // Print baseURL and endpoint
//        String baseURL = (String) apiConfig.get("baseURL");
//        String endpoint = (String) apiConfig.get("endpoint");
//        logInfo("Base URL: " + baseURL);
//        logInfo("Endpoint: " + endpoint);
//
//        // Print headers
//        JSONObject headers = (JSONObject) apiConfig.get("headers");
//        logInfo("Headers: " + headers.toJSONString());
//
//        // Print queryParams
//        JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
//        logInfo("Query Params: " + queryParams.toJSONString());
//    }
//
//    public static void flushExtentReport() {
//        extent.flush();
//    }
//}


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class ExtentReportUtils {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void getInstance(String reportPath) {
        if (extent == null)
            createInstance(reportPath);
    }

    private static void createInstance(String reportPath) {
        extent = new ExtentReports();
        extent.attachReporter(ExtentManager.createExtentHtmlReporter(reportPath));
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void logInfo(String message) {
        test.log(Status.INFO, message);
    }

    public static void flushReport() {
        extent.flush();
    }

    public static void TestLogInfo(JSONObject apiConfig) {
        // Initialize Extent report and create a test
        createTest("Test API");

        // Print scenario
        logInfo("<b>Scenario:</b> " + apiConfig.get("Scenario"));

        // Print baseURL and endpoint
        String baseURL = (String) apiConfig.get("baseURL");
        String endpoint = (String) apiConfig.get("endpoint");
        JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
        String queryParamsFormatted = formatQueryParams(queryParams);
     //   logInfo("<b>Query Params:</b> " + queryParamsFormatted);
        logInfo("<b>URL:</b> " + baseURL + endpoint + queryParamsFormatted);

        // Print headers
        JSONObject headers = (JSONObject) apiConfig.get("headers");
        Gson gson = new Gson();
        String headersJson = gson.toJson(headers);
        logInfo("<b>Headers:</b> " + headersJson);


        // Print queryParams

    }
    public static void logResponse(String responseBody) {
        logInfo("<b>Response:</b><br>" + responseBody);
    }
    private static String formatQueryParams(JSONObject queryParams) {
        StringBuilder formattedParams = new StringBuilder();
        boolean isFirstParam = true;
        for (Object keyObj : queryParams.keySet()) {
            String key = (String) keyObj;
            String value = (String) queryParams.get(key);
            if (isFirstParam) {
                formattedParams.append("?");
                isFirstParam = false;
            } else {
                formattedParams.append("&");
            }
            formattedParams.append(key).append("=").append(value);
        }
        return formattedParams.toString();
    }
}