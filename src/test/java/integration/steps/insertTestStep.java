package integration.steps;

import io.restassured.response.Response;

public class insertTestStep extends abstractStep{

    private static final String ENDPOINT = "/agendas";

    private Response response;
    private String responseBody;
    private String statuscode;


    public insertTestStep() {
        super(ENDPOINT);
    }
}
