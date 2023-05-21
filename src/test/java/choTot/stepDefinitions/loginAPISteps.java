package choTot.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;

public class loginAPISteps {
    RequestSpecification request;
    Response response;

    @Given("^I URL operation for \"([^\"]*)\"$")
    public void iURLOperationFor(String url)  {
        request = given();
        request.baseUri(url);
        request.header(new Header("Content-Type", "application/json; charset=UTF-8"));
    }

    @Given("^I send POST request with path \"([^\"]*)\"$")
    public void iPerformPOSTThePostPath(String path)  {
        response = request.post(path);
        response.prettyPrint();
    }

    @Then("^I should be see the status code response is \"([^\"]*)\"$")
    public void iShouldBeSeeTheStatusCodeIs(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        response.then().assertThat().statusLine(containsStringIgnoringCase("400 Bad Request"));
        response.then().assertThat().contentType("application/json; charset=UTF-8");
        response.then().assertThat().body("code", equalTo("login"));
        response.then().assertThat().body("err_code", equalTo("login"));
    }

    @Then("^I should be see the message response is \"([^\"]*)\"$")
    public void iShouldBeSeeTheMessageIs(String message) {
        response.then().assertThat().body("message", equalTo(message));
    }

    @When("^I send POST request with path \"([^\"]*)\" and set the body request have Password with value \"([^\"]*)\"$")
    public void iSendPOSTRequestWithPathAndSetTheBodyRequestHavePasswordWithValue(String path, String password) {
        HashMap postBody = new HashMap();
        postBody.put("password", password);
        response = request.body(postBody).post(path);
        response.prettyPrint();
    }

    @When("^I send POST request with path \"([^\"]*)\" and set the body request have Phone with value \"([^\"]*)\"$")
    public void iSendPOSTRequestWithPathAndSetTheBodyRequestHavePhoneWithValue(String path, String phone) {
        HashMap postBody = new HashMap();
        postBody.put("phone", phone);
        response = request.body(postBody).post(path);
        response.prettyPrint();
    }

    @When("^I send POST request with path \"([^\"]*)\" and set the body request have Phone and Password with value \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendPOSTRequestWithPathAndSetTheBodyRequestHavePhoneAndPasswordWithValueAnd(String path, String phone, String password){
        HashMap postBody = new HashMap();
        postBody.put("phone", phone);
        postBody.put("password", password);
        response = request.body(postBody).post(path);
        response.prettyPrint();
    }
}
