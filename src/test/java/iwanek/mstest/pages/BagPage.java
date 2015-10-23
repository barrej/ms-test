package iwanek.mstest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by barba_000 on 2015-10-22.
 */
public class BagPage {
    @FindBy(className = "product-code")
    private List<WebElement> products;

    public List<String> getProductCodes() {
        return products.stream().map(p -> p.getText()).map(String::trim).collect(toList());
    }
}
