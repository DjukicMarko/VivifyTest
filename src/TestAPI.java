import org.testng.annotations.Test;
import io.restassured.RestAssured;

import javax.xml.ws.Response;

import static org.hamcrest.Matchers.equalTo;

public class TestAPI {

    @Test
    public void getGallery() {
        RestAssured.get("https://gallery-api.vivifyideas.com/api/galleries?page=1&term=")
                .then()
                .body("galleries[0].id", equalTo(277));
    }
    @Test
    public void getSC() {
        RestAssured.get("https://gallery-api.vivifyideas.com/api/galleries?page=1&term=")
                .then()
                .statusCode(200);
    }
    @Test
    public void getOneGallery() {
        RestAssured.get("https://gallery-api.vivifyideas.com/api/galleries?page=3&term=")
                .then()
                .body("galleries[3].title", equalTo("Test 3"));
    }
    @Test
    public void getTitle() {
        RestAssured.get("https://gallery-api.vivifyideas.com/api/galleries?page=2&term=")
                .then()
                .body("galleries[5].images.image_url", equalTo("https://cdn.fakercloud.com/avatars/itolmach_128.jpg"));
    }
}
