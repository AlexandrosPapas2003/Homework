package stepDefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginAsAdmin.OrangeHRM;
import org.junit.jupiter.api.Assertions;

public class ReviewFunctionalitySteps {
    private final Page currentPage = OrangeHRM.getPage();

    @When("{} section in the main menu was clicked")
    public void clickPerformanceSection(String performanceSection) {
        currentPage.locator(".orangehrm-login-button").click();
        currentPage.waitForLoadState(LoadState.NETWORKIDLE);
        Locator performance = currentPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(performanceSection));
        performance.click();
    }

    @And("user was redirected to {} page")
    public void redirectToPerformancePage(String performancePage) {
        if(performancePage.equals("Performance")){
            currentPage.waitForLoadState(LoadState.NETWORKIDLE);
        }
    }

    @Then("the {} section is present")
    public void sectionIsPresent(String reviewSection) {
        Locator review = currentPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(reviewSection));
        Assertions.assertEquals(1, review.count(), "The " + reviewSection + " section presents in the 'Performance' page");
    }

    @After
    public void tearDown() {
        OrangeHRM.close();
    }
}
