package Project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class consumerTest {
    Map<String, String> headers = new HashMap<String, String>();
    String createUser = "/api/users";
    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {
        headers.put("Content-Type", "application/json");
        DslPart RequestResponseBody = new PactDslJsonBody()
                .numberType("id", 345)
                .stringType("firstName", "Ruchi")
                .stringType("lastName", "Singh")
                .stringType("email", "ruchi.r1@mail.com");
        return builder.given("A request to create a user")
                .uponReceiving("A request to create a user")
                .path(createUser)
                .method("POST")
                .headers(headers)
                .body(RequestResponseBody)
                .willRespondWith()
                .status(201)
                .body(RequestResponseBody)
                .toPact();
    }
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void postRequestTest() {
        RestAssured.baseURI = "http://localhost:8080";
        RequestSpecification rq = RestAssured.given().headers(headers).when();
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 345);
        reqBody.put("firstName", "Ruchi");
        reqBody.put("lastName", "Singh");
        reqBody.put("email", "ruchi.r1@mail.com");
        Response response = rq.body(reqBody).post(createUser);
        assert (response.getStatusCode() == 201);

    }
}