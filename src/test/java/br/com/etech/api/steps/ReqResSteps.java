package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.ReqResFuncionalidade;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ReqResSteps {

    private ReqResFuncionalidade reqResFuncionalidade;

    public ReqResSteps() {
        reqResFuncionalidade = new ReqResFuncionalidade();
    }

    @Dado("^que eu escolha a página \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAPaginaParaPesquisa(String pageNumber) {
        this.reqResFuncionalidade.addRequestParam("page", pageNumber);
    }

    @Dado("^que eu escolha a id de usuário \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAIdDeUsuarioParaPesquisa(String id) {
        this.reqResFuncionalidade.addRequestParam("id", id);
    }

    @Dado("^que eu passe o nome \"([^\"]*)\" e o cargo \"([^\"]*)\" no body da requisição$")
    public void queEuPasseONomeEOCargoNoBodyDaRequisicao(String name, String job) {
        this.reqResFuncionalidade.addToRequestBody("name", name);
        this.reqResFuncionalidade.addToRequestBody("job", job);
    }

    @Dado("^que eu escolha o valor \"([^\"]*)\" para o delay da pesquisa$")
    public void queEuEscolhaOValorParaODelayDaPesquisa(String delay) {
        this.reqResFuncionalidade.addRequestParam("delay", delay);
    }

    @Dado("^que eu passe o email \"([^\"]*)\" e a senha \"([^\"]*)\" no body da requisição$")
    public void queEuPasseOEmailEASenhaNoBodyDaRequisicao(String email, String password) {
        this.reqResFuncionalidade.addToRequestBody("email", email);
        this.reqResFuncionalidade.addToRequestBody("password", password);
    }

    @Dado("^que eu passe o email \"([^\"]*)\" no body da requisição$")
    public void queEuPasseOEmailNoBodyDaRequisição(String email) {
        this.reqResFuncionalidade.addToRequestBody("email", email);
    }

    @Quando("^realizar uma requisição \"([^\"]*)\" na url \"([^\"]*)\"$")
    public void realizarUmaRequisicaoNaUrl(String method, String url) {
        this.reqResFuncionalidade.request(method, url);
    }

    @Então("^devo receber o status \"([^\"]*)\"$")
    public void devoReceberOStatus(String status) {
        this.reqResFuncionalidade.checkStatus(status);
    }

    @E("^devo receber a chave \"([^\"]*)\" no retorno do serviço$")
    public void devoReceberAChaveNoRetornoDoServico(String key) {
        this.reqResFuncionalidade.checkKey(key);
    }



}
