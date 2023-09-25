import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {


    String id;

    @BeforeMethod
    public void CreateObject() {

        JSONObject data = new JSONObject();
        data.put("name", "Dinith Airpod");
        String dupl = "{year:2023,price:1000.0,CPU model:pro,Hard disk size:1TB}";
        // String dup []={"2023","1000","pro","1TB"};
        data.put("data", dupl);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("https://api.restful-api.dev/objects");


        id = response.jsonPath().getString("id");


    }

    @Test
    public void DeleteObject() {


        Response response = given()
                .pathParam("Objects","objects")
                .when()
                .log().all()
                .delete("https://api.restful-api.dev/{Objects}/" + id);


        System.out.println(response.asString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        Assert.assertEquals(response.header("Transfer-Encoding"), "chunked");


    }
}
