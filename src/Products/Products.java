package Products;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Products 
{
 @SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException 
{
 
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
  
 //Select Products link
  Actions actions=new Actions(driver);
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  WebElement ProductsTab=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
  WebElement productsTab=driver.findElement(By.xpath("//a[@role='menuitem']//span[contains(text(),'Products')]"));
  actions.moveToElement(ProductsTab).moveToElement(productsTab).click().perform();
  Thread.sleep(2000);
  
  //Click on Create Option
  driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
  
  //Enter and Save the Product Name
  driver.findElement(By.xpath("//input[@id='o_field_input_736']")).sendKeys("Aspiring0006");
  driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
  
  //Update and Save the Product Cost Price
  driver.findElement(By.xpath("//button[normalize-space()='Edit']")).click();
  driver.findElement(By.xpath("//input[@id='o_field_input_1651']")).clear();
  driver.findElement(By.xpath("//input[@id='o_field_input_1651']")).sendKeys("15.00");
  driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
  
  driver.close();
  
}
}