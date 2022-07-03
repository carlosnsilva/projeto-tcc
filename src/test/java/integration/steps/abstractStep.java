package integration.steps;


import com.projeto.tcc.TccApplication;
import io.cucumber.java.en_old.Ac;
//import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//@RunWith(SpringRunner.class)
//@CucumberContextConfiguration
//@SpringBootTest(classes = {TccApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ActiveProfiles("test")
//@TestPropertySource(properties = {"server.port=8081"})
//@ContextConfiguration(classes = {TccApplication.class})
public class abstractStep {

    private String host  = "http://localhost:";
    private String port = "8081/";
    private String endpoint;
    private Response response;
    private RequestSpecification request;
    private String url;

    public abstractStep(String endpoint){
        this.url = host+port+endpoint;
    }

    public RequestSpecification configRequest(){
        request = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        return request;
    }

    public Response sendRequestGet(){
        response = configRequest().when().get(url);
        return response;
    }

    public Response sendRequestGetById(String id){
        response = configRequest().when().get(url+"/"+id);
        return response;

    }

    public Response sendRequestPost(String body){
        request = configRequest();
        request.header("Content-Type","application/json");
        request.body(body);
        response = request.post(url);

        return response;
    }

    public Response sendRequestPut(String id, String body){
        request = configRequest();
        request.header("Content-Type","application/json");
        request.body(body);
        response = request.put(url+"/"+id);

        return response;
    }

    public Response sendRequestDelete(String id){
        request = configRequest();
        response = request.delete(url+"/"+id);

        return response;
    }

    public String extract(Response response, String field){
        String extracted;

        if(field==null){
            extracted = extractBody(response);
            return extracted;
        }else{
            extracted = extractField(response, field);
            return extracted;
        }
    }

    private String extractBody(Response response){
        return response.asString();
    }

    private String extractField(Response response, String field){
        String body = extractBody(response);
        String value = JsonPath.from(body).get(field);

        return value;
    }

    public String searchJson(String json, String type) throws IOException {
        if(type.equals("request")){
            return searchJsonRequest(json);
        }else{
            return searchJsonResponse(json);
        }
    }

    private String searchJsonRequest(String json) throws IOException {
        String jsonRequest = String.join("", Files.readAllLines(Paths.get("src/test/resources/payloads/request/"+json+".json")));

        return jsonRequest;
    }

    private String searchJsonResponse(String json) throws IOException {
        String jsonResponse = String.join("", Files.readAllLines(Paths.get("src/test/resources/payloads/response/"+json+".json")));

        return jsonResponse;
    }

}
