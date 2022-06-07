package integration.steps;

import io.restassured.response.Response;

public class getAllTestStep extends abstractStep{

    private static final String ENDPOINT = "/agendas";

    private Response response;
    private String responseBody;
    private String statuscode;


    public getAllTestStep() {
        super(ENDPOINT);
    }
}
