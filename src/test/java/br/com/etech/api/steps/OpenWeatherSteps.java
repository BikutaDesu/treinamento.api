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

    @E("^que eu informe a latitude \"([^\"]*)\" e a longitude \"([^\"]*)\" da cidade para pesquisa de clima$")
    public void queEuInformeALatitudeEALongitudeDaCidadeParaPesquisaDeClima(String lat, String lon) {
        this.openWeatherFuncionalidade.addRequestParam("lat", lat);
        this.openWeatherFuncionalidade.addRequestParam("lon", lon);
    }

    @E("^que eu informe o zipcode \"([^\"]*)\" da cidade para pesquisa de clima$")
    public void queEuInformeOZipcodeDaCidadeParaPesquisaDeClima(String zipcode) {
        this.openWeatherFuncionalidade.addRequestParam("zip", zipcode);
    }

    @E("^que eu informe a longitude esquerda \"([^\"]*)\", a latitude inferior \"([^\"]*)\", a longitude direita \"([^\"]*)\", a latitude superior \"([^\"]*)\" e o zoom \"([^\"]*)\" do retangulo para pesquisa de clima$")
    public void queEuInformeALongitudeEsquerdaALatitudeInferiorALongitudeDireitaALatitudeSuperiorEOZoomDoRetanguloParaPesquisaDeClima(String lonLeft, String latBottom, String lonRight, String latTop, String zoom) throws Throwable {
        this.openWeatherFuncionalidade.addRequestParam("lon-left", lonLeft);
        this.openWeatherFuncionalidade.addRequestParam("lon-right", lonRight);
        this.openWeatherFuncionalidade.addRequestParam("lat-bottom", latBottom);
        this.openWeatherFuncionalidade.addRequestParam("lat-top", latTop);
        this.openWeatherFuncionalidade.addRequestParam("zoom", zoom);
    }
}
