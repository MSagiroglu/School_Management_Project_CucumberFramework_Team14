package management_on_schools.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
  /*
       Driver class'indan obje olusturmanin onunce gecebilmek icin
       default constructor'i private yaparak bunu engellemis oluruz. Bu kaliba da Singleton patter denir */
    }

    /*
    POM(Page Object Model)
           Test seneryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
       olanak sağlayan yazılım test yöntemidir. TestNG ve Cucumber frameworklerinde POM kalıbı kullanılır.
     */
    public static WebDriver driver;

    public static WebDriver getDriver() {

        /*
            Driver'i her çağırdığımızda yeni bir pencere açılmasının önüne geçmek için
         if bloğu içinde Eğer driver'a değer ATANMAMIŞSA değer ata, eğer değer atanmışsa
         driver'i aynı sayfada return et
             */
        if (driver == null) {//-->Driver'a değer atanmamışsa
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//-->Driver'a değer atanmışsa, boş değilse
            driver.close();
            driver = null; //--> Driver'ı kapattıktan sonra boşalt
        }

    }

    public static void quitDriver() {
        if (driver != null) {//-->Driver'a değer atanmışsa, boş değilse
            driver.quit();
            driver = null; //--> Driver'ı kapattıktan sonra boşalt
        }


    }
}

/*
package techproed.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import java.time.Duration;
public class  Driver {
    private static int timeout = 5;
    //    creating private constructor
    private Driver(){}
    //    creating a thread safe variable. type of the variable is WebDriver.So every thread will have its own copy of the variable
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //    getDriver method is used to access the class instance that is WebDriver.
    //    This method will return a copy of the driverThreadLocal for each thread during parallel testing
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }
    //    Creating and instantiating the WebDriver instance
    private static void initializeDriver() {
        switch (ConfigReader.getProperty(“browser”)) {
            case “chrome”:
                WebDriverManager.chromedriver().setup();
                driver.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case “firefox”:
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case “chrome-headless”:
                WebDriverManager.chromedriver().setup();
                driver.set(ThreadGuard.protect(new ChromeDriver(new ChromeOptions().setHeadless(true))));
                break;
            case “edge”:
                WebDriverManager.edgedriver().setup();
                driver.set(ThreadGuard.protect(new EdgeDriver()));
                break;
            case “safari”:
                WebDriverManager.safaridriver().setup();
                driver.set(ThreadGuard.protect(new SafariDriver()));
                break;
        }
        //driver -> getDriver()
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
    }
    //    if driver is pointing any object such as chrome or edge, then quit
    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
 */
