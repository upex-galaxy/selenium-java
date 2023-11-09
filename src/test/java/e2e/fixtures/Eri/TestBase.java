package e2e.fixtures.Eri;

import java.time.Duration;

import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;

import e2e.fixtures.DriverManager;
import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

public class TestBase {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    private static final DriverManager MANAGER = new DriverManager();
    public WebDriver web;
    public Locator get;
    public Assertion then;
    public Action Do;

    @BeforeEach
    public void setup() {
        web = MANAGER.setChromeDriver();
        get = new Locator(web);
        then = new Assertion();
        Do = new Action(web);
        web.manage().window().maximize();
        web.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        try {
            web.quit();
        } catch (Exception log) {
            System.out.println("Error while closing browser: " + log.getMessage());
        }
    }
}
