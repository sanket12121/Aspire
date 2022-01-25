package LoginScenario;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScenario {

 @SuppressWarnings("deprecation")
public static void main(String[] args) {
 
  WebDriverManager.chromedriver().setup();
  WebDriver driver=new ChromeDriver();
  String URL="https://aspireapp.odoo.com/web/login";
  driver.get(URL);
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  driver.manage().window().maximize();
  
  //Enter email address
  driver.findElement(By.xpath("//input[@id='login']")).sendKeys("user@aspireapp.com");
  
//Enter Password
  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@sp1r3app");
  
  //Click on "Login"
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  
  //Navigate to Inventory Feature
  driver.findElement(By.xpath("//a[@id='result_app_1']//div[@class='o_app_icon']")).click();
  
  driver.close();
  
 }
}