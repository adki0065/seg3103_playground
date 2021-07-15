package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  
  @BeforeAll
  public static void setUpBeforeClass() throws Exception {

    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    pb.inheritIO();
    server = pb.start();
    
  }
  

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 300);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }


  @Test
  public void myFirstTest() {
    driver.get("http://localhost:8080/");
    WebElement search = driver.findElement(By.id("searchBtn"));
    search.click();
    String title = "Core Servlets and JavaServer Pages 2nd Edition (Volume 1)";
    String authors = "Marty Hall and Larry Brown";
    String cost = "$39.95";
    String desc = "The definitive reference on servlets and JSP from Prentice Hall and Sun Microsystems Press.Nominated for the Nobel Prize in Literature.";
    WebElement t = driver.findElement(By.id("title-hall001"));
    WebElement a = driver.findElement(By.id("authors-hall001"));
    WebElement c = driver.findElement(By.id("cost-hall001"));
    WebElement d = driver.findElement(By.id("descr-hall001"));


    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));


    assertEquals(title, t.getText());
    assertEquals(authors, a.getText());
    assertEquals(cost, c.getText());
    assertEquals(desc, d.getText());

    

    

  }

@Test
public void mySecondTest() {
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");

  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("password");

  WebElement login = driver.findElement(By.id("loginBtn"));
  login.click();

  WebDriverWait wait = new WebDriverWait(driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  

  String expectedUrl = "http://localhost:8080/admin";
  String actualUrl = driver.getCurrentUrl();

  assertEquals(expectedUrl, actualUrl);

}
}