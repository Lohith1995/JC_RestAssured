import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostAPI {
    @Test
    public void statuscodecheck() {
        String baseurl = "https://stage-auth-jiovoot.voot.com";
        String endpoint = "/tokenservice/apis/v4/guest";
        baseURI = baseurl + endpoint;

        String requestBody = "{\n" +
                "    \"deviceType\": \"phone\",\n" +
                "    \"os\": \"ios\",\n" +
                "    \"appName\": \"RJIL_JioCinema\",\n" +
                "    \"deviceId\": \"E31BFY78UFC756G4E8E9C23AA96A80\",\n" +
                "    \"adId\": \"673547543844\",\n" +
                "    \"freshLaunch\": false\n" +
                "}";
        Response response1 = given()
                .header("device-id", "399af483-023f-46e8-av47-f81c084bf833")
                .header("device-category", "phone")
                .header("model", "iphone")
                .header("manufacturer", "apple")
                .header("manufacturer", "apple")
                .header("device-range", "123456")
                .body(requestBody)
                .when()
                .post(baseURI);
        response1.prettyPrint();

        int statuscode = response1.getStatusCode();
        assertEquals(statuscode, 200);
    }
}
