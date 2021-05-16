package es.upm.dit.isst.resumen.test;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestVisitanteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty( "webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testVisitante() {
    driver.get("http://localhost:8080/Resumen-WEBAPP/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("@visitante.es");
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.cssSelector(".resumen:nth-child(4) a")).click();
    driver.findElement(By.cssSelector("form:nth-child(2) > button")).click();
  }
}
