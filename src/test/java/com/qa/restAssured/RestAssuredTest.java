package com.qa.restAssured;

import com.qa.config.ConfigManager;
import io.restassured.RestAssured;
import models.Post;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class RestAssuredTest {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = ConfigManager.getApiBaseUrl();
    }


    @Test
    void testPostNewPost(){
        Map<String, Object> body = new HashMap<>();
        body.put("userId", 2);
        body.put("title", "new post request i made");
        body.put("body", "new post request i made yoohoo");
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("new post request i made"))
                .body("id", notNullValue());
    }

    @Test
    void testUpdateSinglePost(){
        Map<String, Object> body = new HashMap<>();
        body.put("userId", 1);
        body.put("title", "update title");
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("update title"));
    }

    @Test
    void testPatchSinglePostWithMap(){
        Map<String, Object> body = new HashMap<>();
        body.put("userId", 4);
        body.put("title", "new update title");
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(4))
                .body("title", equalTo("new update title"))
                .body("body", notNullValue());
    }

    @Test
    void testPatchSinglePost(){
        given()
                .contentType("application/json")
                .body("{\"userId\":4,\"title\":\"new update title\"}")
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(4))
                .body("title", equalTo("new update title"))
                .body("body", notNullValue());
    }

    @Test
    void testDeleteSinglePost(){
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);

    }

    @Test
    void negativeTest(){
        given()
                .when()
                .get("/posts/99292")
                .then()
                .statusCode(404);
    }

    @Test
    void getAllThePosts(){
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", equalTo(1));
    }

    @Test
    void testGetSinglePost() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }

    @Test
    void testGetPostAsObject(){
        Post post = given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        assertEquals(1, post.getId());
        assertEquals(1, post.getUserId());
        assertNotNull(post.getTitle(), "Заголовок не должен быть null");
    }

    @Test
    void testCreatePostFromObject(){
        Post newPost = new Post(1, "My title", "My body");

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
        assertEquals("My body", creater.getBody());
        assertNotNull(creater.getId());
    }

    @Test
    void testGetPostsByUserId(){
        given()
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("userId", everyItem(equalTo(1)));
    }

    @Test
    void testGetPostsList(){
        Post[] posts = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .as(Post[].class);

        assertTrue(posts.length > 0);
        assertEquals(1, posts[0].getId());
    }
}
