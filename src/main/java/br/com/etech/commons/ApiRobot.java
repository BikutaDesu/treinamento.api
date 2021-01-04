package br.com.etech.commons;

import br.com.etech.strategy.RequestStrategy;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiRobot {

    private static ApiRobot apiRobotInstance;
    private final Map<String, String> requestParams;
    private final Map<String, String> requestBody;
    private final Map<String, String> requestHeaders;
    private ResponseBody responseBody;
    private Map<String, String> cookies;
    private Integer statusCode;

    private ApiRobot() {
        requestParams = new HashMap<String, String>();
        requestBody = new HashMap<String, String>();
        requestHeaders = new HashMap<String, String>();
    }

    public static ApiRobot getInstance() {
        if (apiRobotInstance == null) {
            apiRobotInstance = new ApiRobot();
        }
        return apiRobotInstance;
    }

    public void clearRequestData() {
        requestParams.clear();
        requestHeaders.clear();
        requestBody.clear();
    }

    public void request(String url, RequestStrategy requestStrategy) {
        requestStrategy.request(url);
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public void addRequestParam(String key, String value) {
        this.requestParams.put(key, value);
    }

    public Map<String, String> getRequestBody() {
        return requestBody;
    }

    public void addToRequestBody(String key, String value) {
        this.requestBody.put(key, value);
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void addToRequestHeader(String key, String value) {
        this.requestHeaders.put(key, value);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
