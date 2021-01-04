package br.com.etech.strategy;

import br.com.etech.commons.ApiRobot;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutRequestStrategy implements RequestStrategy {

    @Override
    public void request(String url) {
        ApiRobot apiRobot = ApiRobot.getInstance();
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .pathParams(apiRobot.getRequestParams())
                .body(apiRobot.getRequestBody())
            .when()
                .put(url)
            .then()
                .log().all()
                .extract().response();

        apiRobot.setStatusCode(response.statusCode());
        apiRobot.setResponseBody(response.getBody());
        apiRobot.setCookies(response.getCookies());
    }
}
