package base;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    protected static final Logger logger = LogManager.getLogger(BaseAPI.class);
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    public static String authToken;

    /***
     * 🔹 **Token Oluşturma Metodu**
     * Bu metod **token oluşturur ve döndürür**.
     ***/
    public static String generateAuthToken() {
        logger.info("Auth token alınıyor...");

        // JSON body oluşturuluyor
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "admin");
        requestBody.put("password", "password123");

        // POST isteği ile token alınıyor
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post(BASE_URL + "/auth");

        // **Token alınamıyorsa hata fırlat**
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Token alınamadı! HTTP Status: " + response.getStatusCode());
        }

        // Token değeri değişkene atanıyor
        authToken = response.jsonPath().getString("token");
        logger.info("Alınan Token: " + authToken);

        // **Token değeri return ediliyor**
        return authToken;
    }
}
