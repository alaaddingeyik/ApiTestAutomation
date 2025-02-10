package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import utilities.ApiUtils;

import java.util.List;
import java.util.Map;

public class BookingSteps {
    private static String authToken;
    Response response;
    private static int bookingId;


    @Given("Kullanıcı API için yetkilendirme alır")
    public void kullanıcıYetkilendirmeAlır() {
        authToken = ApiUtils.generateAuthToken();
        Assertions.assertNotNull(authToken, "Token alınamadı!");
    }

    @Then("Yetkilendirme başarılı olmalıdır")
    public void yetkilendirmeBaşarılıOlmalıdır() {
        Assert.assertNotNull("Token alınamadı!", authToken);
    }

    @When("Kullanıcı {string} endpointine GET isteği gönderir")
    public void getIstegiGonderir(String endpoint) {
        response = ApiUtils.sendGetRequest(endpoint);
    }

    @When("Kullanıcı {string} endpointine şu verilerle POST isteği gönderir:")
    public void postIstegiGonderir(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : dataList) {
            JSONObject bookingDates = new JSONObject();
            bookingDates.put("checkin", data.get("checkin"));
            bookingDates.put("checkout", data.get("checkout"));

            JSONObject requestBody = new JSONObject();
            requestBody.put("firstname", data.get("firstname"));
            requestBody.put("lastname", data.get("lastname"));
            requestBody.put("totalprice", Integer.parseInt(data.get("totalprice")));
            requestBody.put("depositpaid", Boolean.parseBoolean(data.get("depositpaid")));
            requestBody.put("bookingdates", bookingDates);
            requestBody.put("additionalneeds", data.get("additionalneeds"));

            response = ApiUtils.sendPostRequest(endpoint, authToken, requestBody.toString());

            // 📌 **Booking ID'yi güvenli şekilde al**
            if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                bookingId = response.jsonPath().getInt("bookingid");
                System.out.println("✅ Oluşturulan Booking ID: " + bookingId);
            } else {
                throw new RuntimeException("❌ Rezervasyon oluşturulamadı! Hata kodu: " + response.getStatusCode());
            }
        }
    }

    @Given("Kullanıcı geçerli bir {string} alır")
    public void kullaniciTokenAlir(String tokenType) {
        authToken = ApiUtils.generateAuthToken();
        Assertions.assertNotNull(authToken, "Token alınamadı!");
        System.out.println("✅ Alınan Token: " + authToken);
    }

    @When("Kullanıcı {string} endpointine şu verilerle PUT isteği gönderir:")
    public void putIstegiGonderir(String endpoint, DataTable dataTable) {
        Assertions.assertNotNull(authToken, "Token bulunamadı! Önce 'Given Kullanıcı geçerli bir \"token\" alır' adımını çalıştırın.");
        Assertions.assertTrue(bookingId > 0, "Booking ID geçersiz! Önce rezervasyon oluşturulmalı.");

        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : dataList) {
            JSONObject bookingDates = new JSONObject();
            bookingDates.put("checkin", data.get("checkin"));
            bookingDates.put("checkout", data.get("checkout"));

            JSONObject requestBody = new JSONObject();
            requestBody.put("firstname", data.get("firstname"));
            requestBody.put("lastname", data.get("lastname"));
            requestBody.put("totalprice", Integer.parseInt(data.get("totalprice")));
            requestBody.put("depositpaid", Boolean.parseBoolean(data.get("depositpaid")));
            requestBody.put("bookingdates", bookingDates);
            requestBody.put("additionalneeds", data.get("additionalneeds"));

            // ✅ **Doğru bookingId'yi endpoint'e ekle**
            if (endpoint.contains("{bookingId}")) {
                endpoint = endpoint.replace("{bookingId}", String.valueOf(bookingId));
            } else {
                throw new RuntimeException("❌ Endpoint içinde {bookingId} bulunamadı!");
            }

            response = ApiUtils.sendPutRequest(endpoint, authToken, requestBody.toString());
            System.out.println("✅ Yanıt: " + response.asString());
        }
    }

    @When("Kullanıcı {string} endpointine şu verilerle PATCH isteği gönderir:")
    public void patchIstegiGonderir(String endpoint, DataTable dataTable) {
        Assertions.assertNotNull(authToken, "Token bulunamadı! Önce 'Given Kullanıcı geçerli bir \"token\" alır' adımını çalıştırın.");
        Assertions.assertTrue(bookingId > 0, "Booking ID geçersiz! Önce rezervasyon oluşturulmalı.");

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        JSONObject requestBody = new JSONObject();
        requestBody.put("lastname", data.get("lastname"));

        // ✅ **Doğru bookingId'yi endpoint'e ekle**
        if (endpoint.contains("{bookingId}")) {
            endpoint = endpoint.replace("{bookingId}", String.valueOf(bookingId));
        } else {
            throw new RuntimeException("❌ Endpoint içinde {bookingId} bulunamadı!");
        }

        response = ApiUtils.sendPatchRequest(endpoint, authToken, requestBody.toString());
        System.out.println("✅ Yanıt: " + response.asString());
    }


    @When("Kullanıcı {string} endpointine DELETE isteği gönderir")
    public void deleteIstegiGonderir(String endpoint) {
        Assertions.assertNotNull(authToken, "Token bulunamadı! Önce 'Given Kullanıcı geçerli bir \"token\" alır' adımını çalıştırın.");
        Assertions.assertTrue(bookingId > 0, "Booking ID geçersiz! Önce rezervasyon oluşturulmalı.");

        // ✅ **Doğru bookingId'yi endpoint'e ekle**
        if (endpoint.contains("{bookingId}")) {
            endpoint = endpoint.replace("{bookingId}", String.valueOf(bookingId));
        } else {
            throw new RuntimeException("❌ Endpoint içinde {bookingId} bulunamadı!");
        }

        response = ApiUtils.sendDeleteRequest(endpoint, authToken);
        System.out.println("✅ Yanıt: " + response.asString());
    }


    @Then("Yanıt kodu {int} olmalıdır")
    public void yanitKoduOlmalidir(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
}
