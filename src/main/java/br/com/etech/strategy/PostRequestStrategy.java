package br.com.etech.strategy;

import br.com.etech.commons.ApiRobot;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRequestStrategy implements RequestStrategy {

    @Override
    public void request(String url) {
        ApiRobot apiRobot = ApiRobot.getInstance();
        Response response =
            given()
//                .contentType("application/json; charset=utf-8")
                .contentType(ContentType.JSON)
                .pathParams(apiRobot.getRequestParams())
                .body(apiRobot.getRequestBody())
            .when()
                .post(url)
            .then()
                .log().all()
                .extract().response();

        apiRobot.setStatusCode(response.statusCode());
        apiRobot.setResponseBody(response.getBody());
        apiRobot.setCookies(response.getCookies());
    }
}
