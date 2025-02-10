package utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import base.BaseAPI;

public class ApiUtils extends BaseAPI {

    private static String authToken;

    public static String generateAuthToken() {
        String requestBody = "{ \"username\": \"admin\", \"password\": \"password123\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/auth");

        authToken = response.jsonPath().getString("token");
        return authToken;
    }

    public static String getAuthToken() {
        return authToken;
    }

    public static Response sendPostRequest(String endpoint, String authToken, String body) {
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + authToken)
                .body(body)
                .when()
                .post(BASE_URL + endpoint);
    }

    public static Response sendGetRequest(String endpoint) {
        return given()
                .header("Accept", "application/json")
                .when()
                .get(BASE_URL + endpoint);
    }

    public static Response sendPutRequest(String endpoint, String authToken, String body) {
        String finalUrl = BASE_URL + (endpoint.startsWith("/") ? endpoint : "/" + endpoint);
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + authToken)
                .body(body)
                .when()
                .put(finalUrl);
    }


    public static Response sendPatchRequest(String endpoint, String authToken, String body) {
        String finalUrl = BASE_URL + (endpoint.startsWith("/") ? endpoint : "/" + endpoint);
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + authToken)
                .body(body)
                .when()
                .patch(finalUrl);
    }

    public static Response sendDeleteRequest(String endpoint, String authToken) {
        String finalUrl = BASE_URL + (endpoint.startsWith("/") ? endpoint : "/" + endpoint);
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + authToken)
                .when()
                .delete(finalUrl);
    }

}
