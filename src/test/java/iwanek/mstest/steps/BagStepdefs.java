package iwanek.mstest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iwanek.mstest.pages.BagPage;
import iwanek.mstest.pages.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by barba_000 on 2015-10-22.
 */
public class BagStepdefs {

    public static final String SHIRT_PRODUCT_CODE = "03788707";
    public static final String SHIRT_URL = "http://www.marksandspencer.com/heatgen-checked-shirt-with-no-peep/p/p22411984";

    private ProductPage productPage;
    private BagPage bagPage;

    @Given("^I have added a shirt to my bag$")
    public void I_have_added_a_shirt_to_my_bag() throws Throwable {
        productPage = ProductPage.open(SHIRT_URL);
        productPage.addToBag();
    }

    @When("^I view the contents of my bag$")
    public void I_view_the_contents_of_my_bag() throws Throwable {
        bagPage = productPage.goToBag();
    }


    @Then("^I can see the contents of the bag include a shirt$")
    public void I_can_see_the_contents_of_the_bag_include_a_shirt() throws Throwable {
        assertThat(bagPage.getProductCodes(), hasItem(SHIRT_PRODUCT_CODE));
    }

}
