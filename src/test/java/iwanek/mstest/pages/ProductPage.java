package iwanek.mstest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by barba_000 on 2015-10-22.
 */
public class ProductPage {

    private static final WebDriver driver = new FirefoxDriver();

    @FindBy(id = "8DUMMY")
    private WebElement sizeButton8;

    @FindBy(id = "basket_P22411984")
    private WebElement addToBag;

    @FindBy(css = "li[class^=\"basket\"] > a")
    private WebElement bag;

    public static ProductPage open(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, ProductPage.class);
    }

    public void addToBag() {
        sizeButton8.click();
        addToBag.click();
    }


    public BagPage goToBag() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        bag.click();
        return PageFactory.initElements(driver, BagPage.class);
    }
}
