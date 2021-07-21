package selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.lu.a;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
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
  public void adminLoginTest() { // test cases: 1.1
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

@Test
public void adminLoginFailTest() { // test cases: 1.2
driver.get("http://localhost:8080/admin");
WebElement username = driver.findElement(By.id("loginId"));
username.sendKeys("amorgd");

WebElement password = driver.findElement(By.id("loginPasswd"));
password.sendKeys("passworp");

WebElement login = driver.findElement(By.id("loginBtn"));
login.click();

WebDriverWait wait = new WebDriverWait(driver, 60);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));



String expected = "Invalid username and/or password";
String actual = driver.findElement(By.cssSelector(".content > div")).getText();

assertEquals(expected, actual);
username = driver.findElement(By.id("loginId"));
username.sendKeys("admin");

password = driver.findElement(By.id("loginPasswd"));
password.sendKeys("password");

login = driver.findElement(By.id("loginBtn"));
login.click();


wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));


String expectedUrl = "http://localhost:8080/admin";
String actualUrl = driver.getCurrentUrl();

assertEquals(expectedUrl, actualUrl);

}

@Test
  public void adminLogoutTest() { // test cases: 2.1
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");

  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("password");

  WebElement login = driver.findElement(By.id("loginBtn"));
  login.click();

  WebDriverWait wait = new WebDriverWait(driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

  driver.findElement(By.cssSelector("form > input")).click();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  String expected = "You have been logged out";
String actual = driver.findElement(By.cssSelector(".content > div")).getText();

assertEquals(expected, actual);



  }

  @Test
  public void addBookTest() { // test cases: 3.1
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");

  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("password");

  WebElement login = driver.findElement(By.id("loginBtn"));
  login.click();

  WebDriverWait wait = new WebDriverWait(driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  
  driver.findElement(By.id("addBook-category")).click();
  driver.findElement(By.id("addBook-category")).sendKeys("fiction");
  driver.findElement(By.id("addBook-id")).click();
  driver.findElement(By.id("addBook-id")).sendKeys("newbook");
  driver.findElement(By.id("addBook-title")).click();
  driver.findElement(By.id("addBook-title")).sendKeys("slenium tests");
  driver.findElement(By.id("addBook-authors")).click();
  driver.findElement(By.id("addBook-authors")).sendKeys("dave");
  driver.findElement(By.id("longDescription")).click();
  driver.findElement(By.id("longDescription")).sendKeys("test book");
  driver.findElement(By.id("cost")).click();
  driver.findElement(By.id("cost")).sendKeys("15");
  driver.findElement(By.name("addBook")).click();
  

  String expected = "Successfully added book";
  String actual = driver.findElement(By.cssSelector(".content > div > h2")).getText();
  assertEquals(expected, actual);
}

@Test
public void addBookMissingTest() { // test cases: 3.2
driver.get("http://localhost:8080/admin");
WebElement username = driver.findElement(By.id("loginId"));
username.sendKeys("admin");

WebElement password = driver.findElement(By.id("loginPasswd"));
password.sendKeys("password");

WebElement login = driver.findElement(By.id("loginBtn"));
login.click();

WebDriverWait wait = new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

driver.findElement(By.id("addBook-category")).click();
driver.findElement(By.id("addBook-category")).sendKeys("fiction");
driver.findElement(By.id("addBook-id")).click();
driver.findElement(By.id("addBook-id")).sendKeys("newbook1");
driver.findElement(By.id("addBook-authors")).click();
driver.findElement(By.id("addBook-authors")).sendKeys("dave");
driver.findElement(By.id("longDescription")).click();
driver.findElement(By.id("longDescription")).sendKeys("test book");
driver.findElement(By.id("cost")).click();
driver.findElement(By.id("cost")).sendKeys("15");
driver.findElement(By.name("addBook")).click();


String expected = "Validation errors";
String actual = driver.findElement(By.cssSelector(".content > div > h2")).getText();
assertEquals(expected, actual);
}

@Test
public void addBookDuplicateTest() { // test cases: 3.3
driver.get("http://localhost:8080/admin");
WebElement username = driver.findElement(By.id("loginId"));
username.sendKeys("admin");

WebElement password = driver.findElement(By.id("loginPasswd"));
password.sendKeys("password");

WebElement login = driver.findElement(By.id("loginBtn"));
login.click();

WebDriverWait wait = new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

driver.findElement(By.id("addBook-category")).click();
driver.findElement(By.id("addBook-category")).sendKeys("fiction");
driver.findElement(By.id("addBook-id")).click();
driver.findElement(By.id("addBook-id")).sendKeys("hall001");
driver.findElement(By.id("addBook-title")).click();
driver.findElement(By.id("addBook-title")).sendKeys("hall001dup");
driver.findElement(By.id("addBook-authors")).click();
driver.findElement(By.id("addBook-authors")).sendKeys("dave");
driver.findElement(By.id("longDescription")).click();
driver.findElement(By.id("longDescription")).sendKeys("test book");
driver.findElement(By.id("cost")).click();
driver.findElement(By.id("cost")).sendKeys("15");
driver.findElement(By.name("addBook")).click();


String expected = "Book with same id already exist";
String actual = driver.findElement(By.cssSelector(".content > div > h2")).getText();
assertEquals(expected, actual);
}

@Test
public void searchCategory() { // test cases: 4.1
  driver.get("http://localhost:8080/");
  driver.findElement(By.id("search")).click();
  driver.findElement(By.id("search")).sendKeys("fiction");
  driver.findElement(By.id("searchBtn")).click();
  WebElement h2 = driver.findElement(By.id("title-newbook"));
  assertNotNull(h2);
  
} 

@Test
public void searchAllCategories() { // test cases: 4.2
  driver.get("http://localhost:8080/");
  driver.findElement(By.id("searchBtn")).click();
  WebElement h1 = driver.findElement(By.id("title-hall001"));
  WebElement h2 = driver.findElement(By.id("title-hall002"));
  WebElement l = driver.findElement(By.id("title-lewis001"));
  WebElement a = driver.findElement(By.id("title-alexander001"));
  WebElement r = driver.findElement(By.id("title-rowling001"));
  assertNotNull(h1);
  assertNotNull(h2);
  assertNotNull(l);
  assertNotNull(a);
  assertNotNull(r);
} 

@Test
public void searchEmptyCategoryTest() { // test cases: 4.3
  driver.get("http://localhost:8080/");
  driver.findElement(By.id("search")).click();
  driver.findElement(By.id("search")).sendKeys("whales");
  driver.findElement(By.id("searchBtn")).click();
  

  String expected = "Sorry we do not have any item matching category 'whales' at this moment";
  String actual = driver.findElement(By.cssSelector(".content > div > h1")).getText();
  assertEquals(expected, actual);
  
  
} 

@Test
public void removeBookTest() { // test cases: 5.1
driver.get("http://localhost:8080/admin");
WebElement username = driver.findElement(By.id("loginId"));
username.sendKeys("admin");

WebElement password = driver.findElement(By.id("loginPasswd"));
password.sendKeys("password");

WebElement login = driver.findElement(By.id("loginBtn"));
login.click();

WebDriverWait wait = new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
driver.findElement(By.id("searchBtn")).click();
driver.findElement(By.id("del-hall001")).click();

try {
  driver.findElement(By.id("title-hall001")).isDisplayed();

} catch (NoSuchElementException e) {
assertTrue(true);
}

}

@Test
  public void orderBookTest() { // test cases: 6.1, 7.1
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();

    WebElement book = driver.findElement(By.id("tothall002"));
    assertNotNull(book);
  }

  @Test
  public void orderBookInCartTest() { // test cases: 6.2
    driver.get("http://localhost:8080/");
    
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();
    String book = driver.findElement(By.id("tothall002")).getAttribute("value");
    assertEquals(book, "1");
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.id("hall002")).click();
    book = driver.findElement(By.id("tothall002")).getAttribute("value");
    assertEquals(book, "2");
  }

  @Test
  public void UpdateBookOrderTest() { // test cases: 8.1
    driver.get("http://localhost:8080/");
    
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.id("hall002")).click();
    driver.findElement(By.id("hall002")).sendKeys("3");
    driver.findElement(By.name("updateOrder")).click();
    String book = driver.findElement(By.id("tothall002")).getAttribute("value");
    assertEquals(book, "3");
  }

  @Test
  public void deleteteBookOrderTest() { // test cases:8.2
    driver.get("http://localhost:8080/");
    
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.id("hall002")).click();
    driver.findElement(By.id("hall002")).sendKeys("0");
    driver.findElement(By.name("updateOrder")).click();
    
    try {
      driver.findElement(By.id("title-hall001")).isDisplayed();

  } catch (NoSuchElementException e) {
    assertTrue(true);
  }

  }

  @Test
  public void checkoutTest() { // test cases:9.1
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.name("checkout")).click();
    String total = driver.findElement(By.name("order_total")).getText();
    assertEquals(total, "$68.99");
  }
  
  @Test
  public void languageTest() { // test cases: 10.1
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("locales")).click();
    {
      WebElement dropdown = driver.findElement(By.id("locales"));
      dropdown.findElement(By.xpath("//option[. = 'French']")).click();
    }
    
    String title = driver.findElement(By.id("title")).getText();
    assertEquals(title, "Librairie Y'AMAZONE");
  }



  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
