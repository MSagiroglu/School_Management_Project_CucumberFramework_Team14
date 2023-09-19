package management_on_schools.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {


    public static String generateToken(String password, String userName){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
        Map<String,String> token=new HashMap<>();
        token.put("password",password);
        token.put("username",userName);
        Response response = given().body(token).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();//--> Response'u yazdır
        return response.jsonPath().getString("token");
    }
 // public static String generateToken_vice_dean(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
 //     String body = "{\n" +
 //             "  \"password\": "+ConfigReader.getProperty("ViceDeanUsername")+",\n" +
 //             "  \"username\": "+ConfigReader.getProperty("ViceDeanPassword")+"\n" +
 //             "}";
 //     Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
 //     //response.prettyPrint();//--> Response'u yazdır
 //     return response.jsonPath().getString("token");
 // }
 // public static String generateToken_dean(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
 //     String body = "{\n" +
 //             "  \"password\": "+ConfigReader.getProperty("DeanUsername")+",\n" +
 //             "  \"username\": "+ConfigReader.getProperty("DeanPassword")+"\n" +
 //             "}";
 //     Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
 //     //response.prettyPrint();//--> Response'u yazdır
 //     return response.jsonPath().getString("token");
 // }
 // public static String generateToken_advice_teacher(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
 //     String body = "{\n" +
 //             "  \"password\": "+ConfigReader.getProperty("AdviceTeacherUsername")+",\n" +
 //             "  \"username\": "+ConfigReader.getProperty("AdviceTeacherPassword")+"\n" +
 //             "}";
 //     Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
 //     //response.prettyPrint();//--> Response'u yazdır
 //     return response.jsonPath().getString("token");
 // }
 // public static String generateToken_student(){//--> Bu metod token oluşturur ve baseUrl sayfasında kullanılır.
 //     String body = "{\n" +
 //             "  \"password\": "+ConfigReader.getProperty("StudentUserName")+",\n" +
 //             "  \"username\": "+ConfigReader.getProperty("StudentUserPassword")+"\n" +
 //             "}";
 //     Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
 //     //response.prettyPrint();//--> Response'u yazdır
 //     return response.jsonPath().getString("token");
 // }
}
