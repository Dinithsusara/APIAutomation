import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateRequest {


    String id;

    @BeforeMethod
    public void CreateRequst() {

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
    public void Updateobject() {


        JSONObject dat = new JSONObject();
        dat.put("name", "Susara Airpod");
        String dup = "{year:2023,price:1000.0,CPU model:pro,Hard disk size:1TB}";
        // String du []={"2023","1000k","pro","1TB"};
        dat.put("data", dup);

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("Objects", "objects")
                .body(dat.toString())
                .when()
                .put("https://api.restful-api.dev/{Objects}/" + id);

        String Update_id = response.jsonPath().getString("id");

        System.out.println(response.asString());


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Susara Airpod");
        Assert.assertEquals(response.jsonPath().getString("id"), Update_id);
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        Assert.assertEquals(response.header("Transfer-Encoding"), "chunked");

    }
}
