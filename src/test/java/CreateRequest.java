import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateRequest {


    @Test
    public void Createobject() {
        JSONObject data = new JSONObject();
        data.put("name", "Dinith Airpod");
        String dup = "{year:2023,price:1000.0,CPU model:pro,Hard disk size:1TB}";
        // String dup []={"2023","1000","pro","1TB"};
        data.put("data", dup);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("https://api.restful-api.dev/objects");

        String Update_id = response.jsonPath().getString("id");
        System.out.println(response.asString());


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Dinith Airpod");
        Assert.assertEquals(response.jsonPath().getString("id"), Update_id);
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        Assert.assertEquals(response.header("Transfer-Encoding"), "chunked");
    }



    // below test case also doing the same assertion but here data send through object (POJO)
    @Test
    public void Creatdata() {


        CreatePojo createPojo = new CreatePojo();
        createPojo.setName("Dinith Airpod");
        CreatePojo.Data data = new CreatePojo.Data(2023, 1000, "pro", "1TB");

        createPojo.setData(data);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(createPojo)
                .when()
                .post("https://api.restful-api.dev/objects");


        String Update_id = response.jsonPath().getString("id");
        System.out.println(response.asString());


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Dinith Airpod");
        Assert.assertEquals(response.jsonPath().getString("id"), Update_id);
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        Assert.assertEquals(response.header("Transfer-Encoding"), "chunked");





    }
}

