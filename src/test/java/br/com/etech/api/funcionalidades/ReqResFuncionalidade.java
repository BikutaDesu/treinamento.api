package br.com.etech.api.funcionalidades;

import br.com.etech.commons.ApiRobot;
import br.com.etech.strategy.*;
import org.junit.Assert;

public class ReqResFuncionalidade {

    private ApiRobot apiRobot;

    public ReqResFuncionalidade() {
        apiRobot = ApiRobot.getInstance();
    }

    public void addRequestParam(String key, String value) {
        apiRobot.addRequestParam(key, value);
    }

    public void addToRequestBody(String key, String value) {
        apiRobot.addToRequestBody(key, value);
    }

    public void request(String method, String url) {
        RequestStrategy requestStrategy = new GetRequestStrategy();
        switch (method) {
            case "POST":
                requestStrategy = new PostRequestStrategy();
                break;
            case "PUT":
                requestStrategy = new PutRequestStrategy();
                break;
            case "DELETE":
                requestStrategy = new DeleteRequestStrategy();
                break;

        }
        this.apiRobot.request(url, requestStrategy);
    }

    public void checkStatus(String status) {
        Assert.assertTrue(Integer.parseInt(status) == apiRobot.getStatusCode());
    }

    public void checkKey(String key) {
        Assert.assertNotNull(apiRobot.getResponseBody().path(key));
    }


}
