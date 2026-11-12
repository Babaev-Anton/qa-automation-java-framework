package com.qa.restAssured;

import com.qa.config.ConfigManager;
import io.restassured.RestAssured;
import models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class ApiRecoveryTest {

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = ConfigManager.getApiBaseUrl();
    }

    @Test
    void testGetRequest() {
        Post post = given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);
        assertEquals(1, post.getUserId());
        assertEquals(1, post.getId());
        assertNotNull(post.getTitle());
    }

    @Test
    void testPostRequest() {
        Post newPost = new Post(1, "Hello", "World");
        Post creater = given()
                .contentType("application/json")
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .as(Post.class);
        assertEquals(1, creater.getUserId());
        assertEquals("World", creater.getBody());
    }
}