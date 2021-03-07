import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Set;

public class MainTest extends Methods{

    @Test

    public void TrendyolTest() {

        Delay(3);
        List<WebElement> webElements = driver.findElements(By.cssSelector(".homepage-popup-gender"));
        webElements.get(1).click();
        Delay(3);
        SendKeys(By.cssSelector(".search-box"), "Kamera");
        Delay(3);
        Click(By.cssSelector(".search-icon"));
        Delay(3);
        SendKeys(By.cssSelector(".fltr-srch-inpt"), "logitech");
        Click(By.cssSelector(".chckbox"));
        Delay(3);

        SelectByValue(By.cssSelector("div[class='sort-fltr-cntnr']>select"),"PRICE_BY_ASC");
        Delay(3);

        String parent = driver.getWindowHandle();
        List<WebElement> logitech = driver.findElements(By.cssSelector(".p-card-img-wr"));
        logitech.get(0).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String child : allWindows) {
            if (!parent.equalsIgnoreCase(child)) {

                driver.switchTo().window(child);
                Delay(3);
                driver.close();
            }
        }

        driver.switchTo().window(parent);

        Delay(3);
        Click(By.cssSelector(".remove"));
        Delay(3);
        SendKeys(By.cssSelector(".fltr-srch-inpt"), "A4");
        Delay(1);
        Click(By.cssSelector(".chckbox"));

        Delay(3);
        List<WebElement> a4 = driver.findElements(By.cssSelector(".p-card-img-wr"));
        a4.get(0).click();

        Set<String> allWindows1 = driver.getWindowHandles();
        for (String child2 : allWindows1){

            if (!parent.equalsIgnoreCase(child2)) {

                driver.switchTo().window(child2);

            }
        }
        Delay(3);
        WebElement comment = findElement(By.xpath("//div//h3[text()='Ürün Değerlendirmeleri']"));
        ScrollToElement("arguments[0].scrollIntoView();",comment);
        Delay(3);

        List<WebElement> comments = driver.findElements(By.cssSelector(".rnr-com-tx"));
        System.out.println("First comment of the product : " + comments.get(0).getText());
        Delay(2);
    }

}
