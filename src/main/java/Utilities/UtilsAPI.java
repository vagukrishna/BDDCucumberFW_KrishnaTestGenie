package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class UtilsAPI {

    public static RequestSpecification req;
    private ConfigReader configReader = new ConfigReader();
    private Properties prop = configReader.init_prop();
    JsonPath js;

    public RequestSpecification requestSpecification() throws IOException, FileNotFoundException {

        if(req==null)
        {
            PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
            req=new RequestSpecBuilder().setBaseUri(prop.getProperty("baseUrl")).addQueryParam("key",prop.getProperty("queryparam"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public String getJsonPath(Response response, String KeyValue)
    {
        String resp=response.asString();
        System.out.println("resp--"+resp);
        js=new JsonPath(resp);
        String value=js.get(KeyValue);
        return value;


    }





}
