package management_on_schools.api_tests.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;



public class GmiBankBaseUrl {
    protected RequestSpecification spec;

    //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1#/user-jwt-controller/authorizeUsingPOST
    //https://www.gmibank.com/
    // user = mark_twain
    // password = Mark.123

  // @Before
  // public void Setup(){
  //     spec = new RequestSpecBuilder()
  //             .setContentType(ContentType.JSON)
  //             .addHeader("Authorization","Bearer "+generateToken())
  //             .setBaseUri("https://gmibank.com")
  //             .build();
  // }
}
  // Her sorguda tekrar eden dataları buraya gireceğiz