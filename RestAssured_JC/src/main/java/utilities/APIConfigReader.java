//package utilities;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileReader;
//import java.io.IOException;
//
//public class APIConfigReader {
//    public static JSONObject getAPIConfig(String apiName, String filePath) throws IOException, ParseException {
//        JSONParser parser = new JSONParser();
//        try (FileReader reader = new FileReader(filePath)) {
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            return (JSONObject) jsonObject.get(apiName);
//        }
//    }
//}

package utilities;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class APIConfigReader {
    public static JSONObject getAPIConfig(String apiName, String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject apiConfig = (JSONObject) jsonObject.get(apiName);
//
            // Print scenario
            String scenario = (String) apiConfig.get("Scenario");
            System.out.println("Scenario: " + scenario);

            // Print baseURL and endpoint
            String baseURL = (String) apiConfig.get("baseURL");
            String endpoint = (String) apiConfig.get("endpoint");
            System.out.println("URL: " + baseURL + endpoint);

            // Print headers
            JSONObject headers = (JSONObject) apiConfig.get("headers");
            System.out.println("Headers: " + headers.toJSONString());

            // Print queryParams
            JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
            System.out.println("Query Params: " + queryParams.toJSONString());

            return apiConfig;
        }
    }

    public void printAPIDetails(JSONObject apiConfig)
    {
        String baseURL = (String) apiConfig.get("baseURL");
        String endpoint = (String) apiConfig.get("endpoint");
        JSONObject queryParams = (JSONObject) apiConfig.get("queryParams");
        JSONObject headers = (JSONObject) apiConfig.get("headers");

        // Format headers
        StringBuilder formattedHeaders = new StringBuilder();
        headers.forEach((key, value) -> formattedHeaders.append(key).append(" : ").append(value).append(", "));

        // Print details
        System.out.println("Scenario: " + apiConfig.get("Scenario"));
        System.out.println("URL: " + baseURL + endpoint);
        System.out.println("Headers: " + formattedHeaders.substring(0, formattedHeaders.length() - 2)); // Removing the last comma
        System.out.println("Query Params: " + queryParams.toJSONString());
    }
}
