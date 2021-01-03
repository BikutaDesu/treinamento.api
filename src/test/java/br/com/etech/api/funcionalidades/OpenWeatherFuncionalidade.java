package br.com.etech.api.funcionalidades;

import br.com.etech.commons.ApiRobot;
import org.junit.Assert;

public class OpenWeatherFuncionalidade {

    private ApiRobot apiRobot;

    public OpenWeatherFuncionalidade() {
        apiRobot = ApiRobot.getInstance();
    }

    public void addRequestParam(String key, String value) {
        this.apiRobot.addRequestParam(key, value);
    }

    public void checkKeyAndValue(String key, String value) {
        Assert.assertEquals(value, apiRobot.getResponseBody().path(key));
    }
}
