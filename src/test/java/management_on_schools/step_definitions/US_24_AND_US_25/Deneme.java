package management_on_schools.step_definitions.US_24_AND_US_25;

import com.github.javafaker.Faker;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class Deneme {
    static Faker faker = new Faker();
    static String name = "Yekta" + faker.number().numberBetween(1,100);
    static String surname= name + "123";
    static String nameYS=faker.name().firstName();
    static String surnameYS=faker.name().lastName();
    static String emailYS=nameYS.toUpperCase()+surnameYS.toLowerCase()+"@gmail.com";
    public static void main(String[] args) {

        System.out.println(emailYS);


    }








}
