package mypackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class data {

WebDriver driver;
String baseurl="http://localhost:8081/exam/page1.jsp";
@BeforeMethod
public void beforeMethod()
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akash\\Downloads\\chromedriver.exe");


}


@Test(priority = 0)
public void welcomePageTS1() throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/page1.jsp");
 System.out.println("TEST CASE 1\n");
driver.get(baseurl);
String currentTitle = driver.getTitle();

Assert.assertEquals(currentTitle,"insert title here");
//System.out.println("To home page \n TEST CASE 1 -- Pass");
Thread.sleep(10000);
driver.close();
}

@Test(priority = 1)
void adminLoginTS2()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/page1.jsp");
System.out.println("TEST CASE 2\nLogin as Admin");
driver.findElement(By.name("studentlogin")).click();
//System.out.println("CLicked button login as Admin");

String curUrl = driver.getCurrentUrl();
System.out.println("currentUrl::"+curUrl);
if(curUrl.equalsIgnoreCase("http://localhost:8081/exam/adminlogin.jsp"))
System.out.println("Adminlogin.jsp displayed");


WebElement userNameEle = driver.findElement(By.name("username"));
userNameEle.sendKeys("anil");
driver.findElement(By.name("userpass")).sendKeys("yadav");


driver.findElement(By.name("lbut")).click();
System.out.println("Login button Click");

curUrl = driver.getCurrentUrl();
System.out.println("curUrl::"+curUrl);
Assert.assertTrue( curUrl.equalsIgnoreCase("http://localhost:8081/exam/adminupdate.jsp"));
System.out.println("TEST CASE 02 PASSED");
driver.close();
}
@Test(priority = 2)
void createAccountantUrlTS3()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/adminupdate.jsp");
System.out.println("TEST CASE 3\n");
driver.findElement(By.name("exit")).click();
String curUrl = driver.getCurrentUrl() ;
Assert.assertTrue(curUrl.equalsIgnoreCase("http://localhost:8081/exam/page1.jsp"));
System.out.println("TEST CASE 03 PASSED");
driver.close();
}

@Test(priority = 3)
void studentlogin()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/page1.jsp");
System.out.println("TEST CASE 2\nLogin as Admin");
driver.findElement(By.name("admin")).click();
String curUrl = driver.getCurrentUrl() ;
Assert.assertTrue(curUrl.equalsIgnoreCase("http://localhost:8081/exam/studlog.jsp"));
System.out.println("studentlogin.jsp displayed");

WebElement userNameEle = driver.findElement(By.name("username"));
userNameEle.sendKeys("1");
driver.findElement(By.name("userpass")).sendKeys("4");

driver.findElement(By.name("lbut")).click();
System.out.println("Login button Click");

curUrl = driver.getCurrentUrl();
System.out.println("curUrl::"+curUrl);
Assert.assertTrue( curUrl.equalsIgnoreCase("http://localhost:8081/exam/studlog.jsp"));
System.out.println("TEST CASE 04 PASSED");
driver.close();
}

@Test(priority = 4)
void question()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/adminupdate.jsp");
System.out.println("TEST CASE 5\nLogin as Admin");
driver.findElement(By.name("ques")).click();
String curUrl = driver.getCurrentUrl() ;
Assert.assertTrue(curUrl.equalsIgnoreCase("http://localhost:8081/exam/question.jsp"));
System.out.println("question.jsp displayed");


System.out.println("TEST CASE 05 PASSED");
driver.close();
}


@Test(priority = 5)
void reg()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8081/exam/adminupdate.jsp");
System.out.println("TEST CASE 6\nLogin as Admin");
driver.findElement(By.name("reg")).click();
String curUrl = driver.getCurrentUrl() ;
Assert.assertTrue(curUrl.equalsIgnoreCase("http://localhost:8081/exam/studentregistration.jsp"));
System.out.println("question.jsp displayed");

WebElement userNameEle = driver.findElement(By.name("name"));
userNameEle.sendKeys("5");
driver.findElement(By.name("student")).sendKeys("6");

WebElement userNameEle1 = driver.findElement(By.name("contact"));
userNameEle1.sendKeys("7");
driver.findElement(By.name("password")).sendKeys("8");

driver.findElement(By.name("lbut")).click();
System.out.println("Login button Click");

curUrl = driver.getCurrentUrl();
System.out.println("curUrl::"+curUrl);
Assert.assertTrue( curUrl.equalsIgnoreCase("http://localhost:8081/exam/studentregistration.jsp"));
System.out.println("TEST CASE 06 PASSED");
driver.close();



}
}
