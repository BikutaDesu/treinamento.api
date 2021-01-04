package br.com.etech.strategy;

import br.com.etech.commons.ApiRobot;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequestStrategy implements RequestStrategy {

    @Override
    public void request(String url) {
        ApiRobot apiRobot = ApiRobot.getInstance();
        Response response =
            given()
                .pathParams(apiRobot.getRequestParams())
                .body(apiRobot.getRequestBody())
            .when()
                .get(url)
            .then()
                .log().all()
                .extract().response();

        apiRobot.setStatusCode(response.statusCode());
        apiRobot.setResponseBody(response.getBody());
        apiRobot.setCookies(response.getCookies());
    }
}
