package demo;

import dao.BookRepository;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class DemoTest {

    @Inject @Client("/")
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Replaces(BookRepository.class)
    @JdbcRepository(dialect = Dialect.H2)
    public interface TestBookRepository extends BookRepository{}

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testHelloWorld(RequestSpecification spec) {
        spec.given().accept(ContentType.JSON).contentType(ContentType.JSON).body("{\"title\":\"Title\"}")
            .when().post("/book")
            .then().statusCode(200);
    }
}
