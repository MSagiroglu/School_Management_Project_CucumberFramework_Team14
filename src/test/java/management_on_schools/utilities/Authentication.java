package management_on_schools.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {
    public static void main(String[] args) {
        System.out.println(generateToken());
    }
    public static String generateToken(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
        String body = "{\n" +
                "  \"password\": \"Team14Admin\",\n" +
                "  \"username\": \"Team14Admin\"\n" +
                "}";
        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();//--> Response'u yazdır
        return response.jsonPath().getString("token");
    }
    public static String generateToken_vice_dean(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
        String body = "{\n" +
                "  \"password\": \"Team_14 V-Dean\",\n" +
                "  \"username\": \"Team_14 V-Dean\"\n" +
                "}";
        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();//--> Response'u yazdır
        return response.jsonPath().getString("token");
    }
}
