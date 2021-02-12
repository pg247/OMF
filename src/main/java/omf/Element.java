package omf;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {
    private static final String disabledClass = "disabled";


    public static WebElement loadAndClick(WebElement element) {
        waitForEnabled(element);
    }

    public static WebElement waitForEnabled(final WebElement wel) {
        WebDriverWait wait = DriverManager.getWebDriverWait(Driver.TIMEOUT_20_SEC);
        return wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return isElementEnabled(wel) ? wel : null;
            }
        });
    }
    public static boolean isElementEnabled(WebElement element) {
        if (element != null && element.isDisplayed() && element.isEnabled()) {
            String classes = element.getAttribute("class");
            if (classes != null) {
                return !classes.contains(disabledClass);
            }
            return true;
        }
        return false;
    }

}
