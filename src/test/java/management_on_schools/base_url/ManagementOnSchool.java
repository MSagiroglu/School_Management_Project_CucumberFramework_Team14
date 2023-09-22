package management_on_schools.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import management_on_schools.utilities.ConfigReader;

import static management_on_schools.utilities.Authentication.*;


public class ManagementOnSchool {
    public static RequestSpecification spec;
    public static RequestSpecification spec_vice_dean;


    public static void adminSetUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken(ConfigReader.getProperty("AdminUsername"), ConfigReader.getProperty("AdminPassword")))
                .setContentType(ContentType.JSON).build();


    }
    public static void viceDeanSetUp() {

        spec_vice_dean = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken(ConfigReader.getProperty("ViceDeanUsername"), ConfigReader.getProperty("ViceDeanPassword")))
                .setContentType(ContentType.JSON).build();
    }
    public static void deanSetUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken(ConfigReader.getProperty("DeanUsername"), ConfigReader.getProperty("DeanPassword")))
                .setContentType(ContentType.JSON).build();
    }
    public static void adviceTeacherSetUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken(ConfigReader.getProperty("AdviceTeacherUsername"), ConfigReader.getProperty("AdviceTeacherPassword")))
                .setContentType(ContentType.JSON).build();
    }
    public static void studentSetUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken(ConfigReader.getProperty("StudentUserName"), ConfigReader.getProperty("StudentUserPassword")))
                .setContentType(ContentType.JSON).build();
    }
}
