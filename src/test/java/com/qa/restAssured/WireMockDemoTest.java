package com.qa.restAssured;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class WireMockDemoTest {
    WireMockServer wireMock = new WireMockServer(8080);

    @BeforeEach
    void start(){
        wireMock.start();
    }

    @AfterEach
    void stop(){
        wireMock.stop();
    }

    @Test
    void testWithStubResponse(){
        wireMock.stubFor(get("/api/profile")
                .willReturn(okJson("{\"name\": \"Иван\", \"isResident\": false}")));

        given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/profile")
                .then()
                .statusCode(200)
                .body("name", equalTo("Иван"))
                .body("isResident", equalTo(false));
    }

    @Test
    void testVerifyRequestWasMade() {
        // Настраиваем заглушку
        wireMock.stubFor(get("/api/profile")
                .willReturn(okJson("{\"name\": \"Иван\"}")));

        // Делаем запрос
        given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/profile");

        // Проверяем, что WireMock получил запрос на /api/profile
        wireMock.verify(getRequestedFor(urlEqualTo("/api/profile")));
    }
}
