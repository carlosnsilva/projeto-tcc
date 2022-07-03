package integration.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

public class insertTestStep extends abstractStep{

    private static final String ENDPOINT = "/agendas";

    private Response response;
    private String responseBody;
    private String statuscode;


    public insertTestStep() {
        super(ENDPOINT);
    }

    @Dado("o endpoint POST \\/agenda {string}")
    public void o_endpoint_post_agenda(String descricao) {
        System.out.println("Executando teste: "+descricao);
    }

    @Quando("a requisicao contendo todas as informacoes corretas {string}")
    public void a_requisicao_contendo_todas_as_informacoes_corretas(String payloadRequest) throws IOException {
        response = sendRequestPost(searchJson(payloadRequest,"request"));

        responseBody = extract(response,null);
        System.out.println("Response: "+responseBody);

    }
    @Então("receberei statusCode {string}")
    public void receberei_status_code(String statuscode) {
        Assert.assertEquals(response.statusCode(),Integer.parseInt(statuscode));

    }
    @Então("o payload de response será exibido com sucesso {string}")
    public void o_payload_de_response_será_exibido_com_sucesso(String payloadResponse) throws IOException {
        Assert.assertEquals(responseBody,searchJson(payloadResponse,"response"));
    }
}
