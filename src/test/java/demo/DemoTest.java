package demo;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.BookService;

import static org.hamcrest.Matchers.equalTo;

@MicronautTest
class DemoTest {

    @Inject @Client("/")
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    BookService bookService;

    @Test
    void testApplicationRunning() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testCreationWithRestAssured(RequestSpecification spec) {
        spec.given().contentType(ContentType.JSON).body("{\"title\":\"Title\"}")
            .when().post("/book")
            .then().statusCode(200).and().body("title", equalTo("Title"));
    }
}
