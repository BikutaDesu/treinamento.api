package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.OpenWeatherFuncionalidade;
import br.com.etech.commons.ApiRobot;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;

public class OpenWeatherSteps {

    private OpenWeatherFuncionalidade openWeatherFuncionalidade;


    public OpenWeatherSteps() {
        this.openWeatherFuncionalidade = new OpenWeatherFuncionalidade();
    }

    @Dado("^que eu informe a chave de api \"([^\"]*)\"$")
    public void queEuInformeAChaveDeApi(String apiKey) {
        this.openWeatherFuncionalidade.addRequestParam("appid", apiKey);
    }

    @E("^que eu informe a cidade \"([^\"]*)\" para pesquisa de clima$")
    public void queEuInformeACidadeParaPesquisaDeClima(String city) {
        this.openWeatherFuncionalidade.addRequestParam("q", city);
    }

    @E("^devo receber a chave \"([^\"]*)\" com o valor \"([^\"]*)\" no retorno do serviço$")
    public void devoReceberAChaveComOValorNoRetornoDoServico(String key, String value) {
        this.openWeatherFuncionalidade.checkKeyAndValue(key, value);
    }

    @E("^que eu informe a id da cidade \"([^\"]*)\" para pesquisa de clima$")
    public void queEuInformeAIdDaCidadeParaPesquisaDeClima(String cityID) {
        this.openWeatherFuncionalidade.addRequestParam("id", cityID);
    }
}
