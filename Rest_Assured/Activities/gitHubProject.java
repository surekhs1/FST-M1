package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class gitHubProject {
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKOu5tjWVZuTASseLNaSeaXBfl7JqUMUQPDqrUEa2jmC";
    int sshKeyId;
    RequestSpecification requestSpec=new RequestSpecBuilder()
            .setBaseUri("https://api.github.com/user/keys")
            .addHeader("Authorization","token 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")
            .addHeader("Content-Type", "application/json")
            .build();
    ResponseSpecification responseSpec=new ResponseSpecBuilder()
            .expectResponseTime(lessThan(5000L))
            .expectBody("key",equalTo(sshKey))
            .expectBody("title",equalTo("TestAPIKey"))
            .build();

    @Test(priority = 1)
    public void postRequestTest() {

        Map<String,String> regBody=new HashMap<>();
        regBody.put("title","TestAPIKey");
        regBody.put("Key",sshKey);
        Response response=given().spec(requestSpec).body(regBody).when().post();
        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);
    }
    @Test(priority = 2)
    public void getTest() {
        given().spec(requestSpec).pathParam("keyId",sshKeyId)
                .when().get("/{keyId}")
                .then().statusCode(200).spec(responseSpec);
    }
    @Test(priority = 3)
    public void deleteTest() {
        given().spec(requestSpec).pathParam("keyId",sshKeyId)
                .when().delete("/{keyId}")
                .then().statusCode(anyOf(is(200),is(204))).time(lessThan(3000L));
    }
}
