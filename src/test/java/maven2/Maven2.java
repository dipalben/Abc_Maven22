package maven2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Maven2 extends Utils {
    protected static WebDriver driver;

    //  public void Fourth(){
    static String getCurrentDateTime() {
        //create object of simple date format class and decide format
        DateFormat dateformat = new SimpleDateFormat("MMddyyyyHHmmss");
        // get current date time with date()
        Date date = new Date();
        // new format for date
        String date1 = dateformat.format(date);
        // print the date
        System.out.println(" Current date and time is " + date1);
        return date1;
    }

    @Before
    public void Third() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        driver = new ChromeDriver();
        //implicit wait applied to driver instance - which will be applied to driver until driver instance
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //asking driver to get url
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void Register(){
        //register for new user
        ClickElementBy(By.xpath("//a[@class= \'ico-register\']"));
        //registerdriver.findElement(By.xpath("//a[@class= \'ico-\']")).click();
        // Enter gender detail
        ClickElementBy(By.xpath("//input[@id='gender-female']"));
        //  driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        //Enter first name
        enterText(By.xpath("//*[@name='FirstName']"), "Martin");
    //  driver.findElement(By.xpath("//*[@name='FirstName']")).sendKeys("Martin");
        // Enter last name

        enterText(By.xpath("//*[@id=\"LastName\"]"),"Patel");
        //driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Patel");
        // Enter email id
        enterText(By.xpath("//*[@id=\"Email\"]"),"kd" + getCurrentDateTime() + "@yahoo.com");
        // driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("kd" + getCurrentDateTime() + "@yahoo.com");
        // Enter password
        enterText(By.xpath("//input[@id='Password']"),"pruthvi");
        // driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("pruthvi");
        // Enter confirm password
        enterText(By.xpath("//*[@name='ConfirmPassword']"),"pruthvi");
        //driver.findElement(By.xpath("//*[@name='ConfirmPassword']")).sendKeys("pruthvi");
        // click on register button
        ClickElementBy(By.xpath("//input[@id='register-button']"));
        // driver.findElement(By.xpath("//input[@id='register-button']")).click();
        String expectedMessage = "Your registeration completed";
        String actualMessage =  getTextFromElemet("//div[@class='result']");
        String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Your registration completed", actualRegistrationSuccessMessage);

    }


    @Test
    public void Login() {


        // click on login
        ClickElementBy(By.xpath("//a[@class='ico-login']"));
        //driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        // Enter email-id
        enterText(By.xpath("//input[@id='Email']"),"krunal@yahoo.com");
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("krunal@yahoo.com");

        // Enter Password
        enterText(By.xpath("//input[@name='Password']"),"pruthvi");
        //driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("pruthvi");
        //Click on login button
        ClickElementBy(By.xpath("//input[@value='Log in']"));
        //driver.findElement(By.xpath("//input[@value='Log in']")).click();
        // Click on log out button


        String message = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        String expectedMessage = "welcome to our store";
         Assert.assertEquals("Log out", expectedMessage);
        System.out.print("User logged in successfully ");
    }
    @Test
    public void Notebooks() {

        // User should be on homepage.
       // driver.findElement(By.xpath("//a[contains(text(),'Computers')]")).click();
        ClickElementBy(By.xpath("//a[contains(text(),'Computers')]"));
        // click on notebooks
       // driver.findElement(By.partialLinkText("Notebooks")).click();
       ClickElementBy(By.partialLinkText("Notebooks"));
        String actualUserShouldBeNevigateToNotebooks = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals("Notebooks", actualUserShouldBeNevigateToNotebooks);
        System.out.print(" User should be able to nevigate to notebooks category ");
    }
    @Test
    public void Electronics() {


        //Click on electronics category
       // driver.findElement(By.linkText("Electronics")).click();
        ClickElementBy(By.linkText("Electronics"));
        //click on cell phone
        ClickElementBy(By.partialLinkText("Cell phone"));
       // driver.findElement(By.partialLinkText("Cell phone")).click();

        String message = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals("Cell phones", message);

        System.out.print(" User should be able to nevigate to electronics category");
    }
    @Test
    public void Shopping_Cart() {

        ClickElementBy(By.linkText("Jewelry"));
        //driver.findElement()By.linkText("Jewelry").click();
        ClickElementBy(By.linkText("Flower Girl Bracelet"));
        //driver.findElement(By.linkText("Flower Girl Bracelet")).click();
        ClickElementBy(By.xpath("//input[@value='Add to cart']"));
       // driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        String actualresult = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("The product has been added to your shopping cart", actualresult);
        System.out.print(" User should be able to add products ");
    }

    @After
    public void tearDown(){
        driver.quit();

    }

}
