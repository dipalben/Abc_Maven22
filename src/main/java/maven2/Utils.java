package maven2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// extends BasePage
public class Utils extends BasePage {
    static String actualResult;

    // 1) //Clicking element
    public static void ClickElementBy(By by) {

        BasePage.driver.findElement(by).click();
    }

    // 2)Clear text form input box/area
    public static void ClearField(By by)
    {
        BasePage.driver.findElement(by).clear();
    }

    //3) Enter text in input field
    public static void enterText(By by, String text) {
        BasePage.driver.findElement(by).sendKeys(text);
    }

    // 4)Clear and enter text in input field
    public void clearAndEnter(By by, String text) {
        BasePage.driver.findElement(by).clear();
        BasePage.driver.findElement(by).sendKeys(text);

    }

    // 5) checking webElement present in DOM
    public boolean isElementPresent(By by) {
        try {
            BasePage.driver.findElement(by).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }
    }

    // 6) checking webElement  displayed or not
    public boolean isElementDisplayed(By by) {
        try {
            BasePage.driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException  e) {
            return false;
        }
    }

    // 7) wait for fixed time given in seconds
    public static void waitForWebElementToBeClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // 8) try to click element three times if not available in first go
    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3) {
            try {
                Thread.sleep(10);
                BasePage.driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempt++;
        } return result;
    }

    // 10) wait for locator to be clickable for given time in seconds
    public static void waitForLoctorToBeClicable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    // 11) wait for visibility of element with given time
    public static void explicitWaitForVisibility(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    // 12) select text from value
    public static String getActualText(By by) {
      return actualResult = BasePage.driver.findElement(by).getText();
    }

    // 13) get selected value from dropdown
    public static void selectByValue(By by,String data){
        Select dob = new Select(BasePage.driver.findElement(by));
        dob.selectByValue(data);
    }

    // 14) scroll to view element
   // public void scrollToElement(By by, WebElement element,int seconds){
     //   try {
     //   ((JavascriptException) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", element);BasePage.driver.findElement(by);
        //    Thread.sleep(seconds);
        //    } catch (InterruptedException e) {
         //   e.printStackTrace();
      //  }

   // }
      // 15) scroll to element and click
   // public void  scrollTillElementFoundAndClick(By by, WebElement element){
     //  ((JavascriptException) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", element);
     //   BasePage.driver.findElement(by).click();


  //  }
    // 16) wait for alert to display
    public  boolean isAlartPresent(){
     boolean present = false;
     try {

         Alert alert = BasePage.driver.switchTo().alert();

        // Alert present; set the flag
         present = true;

          //if present consume the alert
         alert.accept();
     } catch (NoAlertPresentException ex){
         // Alert not present
         ex.printStackTrace();
     }
     return present;

    }
    // 17) get attribute of element
    public static  String getAttributeOfElement(WebElement element, String attr){
        String value = element.getAttribute(attr);
        return value;
    }
    // 18) get css property of element
    public String getCssPropOfElement(WebElement element,String css){
        String value = element.getCssValue(css);
        return value;
    }
}