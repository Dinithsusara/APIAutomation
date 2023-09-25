import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {


    String value1 = "Apple iPhone 12 Mini, 256GB, Blue";
    String value2 = "Apple iPhone 11, 64GB";

    @Test
    public void Getobject_by_id() {

        given()
                .pathParam("Objects", "objects")
                .queryParam("id", 3)
                .queryParam("id", 5)
                .queryParam("id", 10)
                .when()
                .get("https://api.restful-api.dev/{Objects}")
                .then()
                .statusCode(200)
                .body("data[0].color", equalTo("Cloudy White"))
                .body("name[1]", equalTo("Samsung Galaxy Z Fold2"))
                .body("name[0]", equalTo("Apple iPhone 12 Pro Max"))
                .header("Content-Type", equalTo("application/json"))
                .header("Transfer-Encoding", equalTo("chunked"))
                .log().all();


    }


    @Test
    public void Getallobjects() throws IOException {


        given()
                .pathParam("Objects", "objects")
                .when()
                .get("https://api.restful-api.dev/{Objects}")
                .then()
                .statusCode(200)
                .body("name[1]", equalTo(value1))
                .body("data[1]", equalTo(null))
                .body("name[3]", equalTo(value2))
                .body("data[3].price", equalTo(389.99F))
                .header("Content-Type", equalTo("application/json"))
                .log().all();


        //  below code  also i'm trying to do same assertions above did, but going to get data through object. but given request body data not in same format

        // ex -data: {
        //         "color": "Cloudy White",
        //         "capacity": "128 GB"
        //      }

        //        data: {
        //        "Capacity": "64 GB",
        //        "Screen size": 7.9
        //    }
//______________________________________________________________________

//        ObjectMapper objectMapper = new ObjectMapper();
//        Response responseLogin = given()
//                .pathParam("Objects", "objects")
//                .queryParam("id", 3)
//                .queryParam("id", 5)
//                .queryParam("id", 10)
//                .when()
//                .get("https://api.restful-api.dev/{Objects}")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response();
//
//
//        GetPojo[] createdUser = objectMapper.readValue(responseLogin.getBody().asString(), GetPojo[].class);
//
//
//        GetPojo objectPojo = createdUser[3];
//        System.out.println(objectPojo);
//
//        Assert.assertEquals(objectPojo.id, "3");
//        Assert.assertEquals(objectPojo.name,"value1");
//
//    }

    }


}
