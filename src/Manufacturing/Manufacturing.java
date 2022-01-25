package Manufacturing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Manufacturing 
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
  
  //Navigate to Application Icon
  driver.findElement(By.xpath("//a[@title='Applications']")).click();
  
  //Navigate to Manufacturing Feature
  driver.findElement(By.xpath("//a[@id='result_app_2']//div[@class='o_app_icon']")).click();
  
  //Click on Create Button
  driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
  
  //Select value from dropdown
  Select se = new Select(driver.findElement(By.xpath("//input[@id='o_field_input_828']")));
  se.selectByVisibleText("Aspiring0006");
  
  //Add a Line
  driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")).click();
  Select s = new Select(driver.findElement(By.xpath("//td[@class='o_data_cell o_field_cell o_list_many2one o_required_modifier']//div[@name='product_id']//input[@type='text']")));
  s.selectByVisibleText("Aspiring0006");
  driver.findElement(By.xpath("//input[@name='product_uom_qty']")).sendKeys("10.00");
  
  //Save the Manufacturing Order Item
  driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
  
  //Confirm the Manufacturing Order Item
  driver.findElement(By.xpath("//span[normalize-space()='Confirm']")).click();
  
  //Mark as Done for the Manufacturing Order Item
  driver.findElement(By.xpath("//span[normalize-space()='Mark as Done']")).click();
  
  //Click on Apply Button
  driver.findElement(By.cssSelector("@sp1r3app")).click();
  
  //Verify the new Manufacturing Order is created with correct information 
  String ManufacturingReference=driver.findElement(By.xpath("//span[@placeholder='Manufacturing Reference']")).getText();
  if(ManufacturingReference.contains("Aspiring0006")) 
  {
	   System.out.println("Order Completed:Test Case Passed");
	  }
	  else 
	  {
	   System.out.println("Order Not Successfull:Test Case Failed");
	  }
  driver.close();
  }
}