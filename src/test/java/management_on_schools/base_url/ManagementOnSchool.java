package management_on_schools.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static management_on_schools.utilities.Authentication.generateToken;
import static management_on_schools.utilities.Authentication.generateToken_vice_dean;


public class ManagementOnSchool {
    public static RequestSpecification spec;
    public static RequestSpecification spec_vice_dean;

    public static void setUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken())
                .setContentType(ContentType.JSON).build();

        spec_vice_dean = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization", generateToken_vice_dean())
                .setContentType(ContentType.JSON).build();
    }
}
