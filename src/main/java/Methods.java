import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class Methods extends BaseTest{

    public Select select;
    /*public WebElement findElement(By by){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }*/
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public void SendKeys(By by, String text){
        WebElement element = driver.findElement(by);
        element.clear();
        //driverWait.until(ExpectedConditions.elementToBeClickable(by));
        element.sendKeys(text);
    }

    public void Click(By by){
        WebElement element  = driver.findElement(by);
        if (element != null && !element.isDisplayed()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        }
        //driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void HoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String GetText(By by){
        return findElement(by).getText();
    }

    public void Navigate(String url){
        driver.navigate().to(url);
    }

    public void Delay(int second){
        try{
            TimeUnit.SECONDS.sleep(second);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public void ScrollToElement(String key ,WebElement input) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(key, input);
    }
    public void SelectByValue(By by, String value){
        select = new Select(findElement(by));
        select.selectByValue(value);
    }

}
