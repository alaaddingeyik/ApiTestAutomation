package apiTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilities.ApiUtils;

public class BookingAPI {

    private static int bookingId;
    private static String authToken;

    @BeforeAll
    public static void setUp() {
        authToken = ApiUtils.generateAuthToken(); // Token al
    }

    @Test
    public void testCreateBooking() {
        String requestBody = "{ \"firstname\": \"Ali\", \"lastname\": \"Veli\", \"totalprice\": 150, \"depositpaid\": true, \"bookingdates\": {\"checkin\": \"2024-01-01\", \"checkout\": \"2024-01-05\"}, \"additionalneeds\": \"Breakfast\" }";
        Response response = ApiUtils.sendPostRequest("/booking", authToken, requestBody);
        Assertions.assertEquals(200, response.getStatusCode());

        // Oluşturulan rezervasyonun ID'sini kaydet
        bookingId = response.jsonPath().getInt("bookingid");
        Assertions.assertNotEquals(0, bookingId, "Booking ID alınamadı!");
    }

    @Test
    public void testGetBooking() {
        Response response = ApiUtils.sendGetRequest("/booking/" + bookingId);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testUpdateBooking() {
        if (bookingId == 0) {
            testCreateBooking();
        }
        String requestBody = "{ \"firstname\": \"Mehmet\", \"lastname\": \"Can\", \"totalprice\": 200, \"depositpaid\": false, \"bookingdates\": {\"checkin\": \"2024-02-01\", \"checkout\": \"2024-02-10\"}, \"additionalneeds\": \"Lunch\" }";
        Response response = ApiUtils.sendPutRequest("/booking/" + bookingId, authToken, requestBody);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testPartialUpdateBooking() {
        if (bookingId == 0) {
            testCreateBooking();
        }
        String requestBody = "{ \"lastname\": \"Yılmaz\" }";
        Response response = ApiUtils.sendPatchRequest("/booking/" + bookingId, authToken, requestBody);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testDeleteBooking() {
        if (bookingId == 0) {
            testCreateBooking();
        }
        Response response = ApiUtils.sendDeleteRequest("/booking/" + bookingId, authToken);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
