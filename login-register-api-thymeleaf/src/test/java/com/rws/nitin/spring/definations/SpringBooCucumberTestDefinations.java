package com.rws.nitin.spring.definations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBooCucumberTestDefinations {
    private final static String BASE_URI = "http://localhost";

    @LocalServerPort
    private int port;

    private ValidatableResponse validatableResponse;

    private void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }

    protected RequestSpecification requestSpecification() {
        configureRestAssured();
        return requestSpecification().given();
    }

    @Given("I send a request to the URL {string} to register user details")
    public void iSendARequest(String endpoint) {
        validatableResponse = requestSpecification().contentType(ContentType.JSON)
                .when().get(endpoint).then();
        System.out.println("RESPONSE :"+validatableResponse.extract().asString());
    }

//    @Then("the response will return status {int} and id {int} and names {string} and name {String} and email {string}")
//    public void extractResponse(int status, int id, String first_name, String last_name, String email) {
//        validatableResponse.assertThat().statusCode(equalTo(status))
//                .body("id",hasItem(id)).body(containsString(first_name)).body(containsString(last_name)).body(containsString(email));
//
//    }

//    @Then("the response will return status{int} and id {int} and firstname {string} and lastname {string} and email {string} and password {string}")
//    public void theResponseWillReturnIdAndNamesAndAndEmailAndPassword(int status,int id, String firstname, String lastname, String email, String password)  {
//        validatableResponse.assertThat().statusCode(equalTo(status))
//                .body("id",hasItem(id)).body(containsString(firstname)).body(containsString(lastname)).body(containsString(email)).body(containsString(password));
//
//    }

    @Then("the response will return status {int} and id {string} and firstname {string} and lastname {string} and email {string} and password {string}")
    public void theResponseWillReturnIdAndNamesAndAndEmailAndPassword(int status,int id, String firstname, String lastname, String email, String password)  {
        validatableResponse.assertThat().statusCode(equalTo(status))
                .body("id",hasItem(id)).body(containsString(firstname)).body(containsString(lastname)).body(containsString(email)).body(containsString(password));

    }
}
