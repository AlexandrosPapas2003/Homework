package stepDefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginAsAdmin.OrangeHRM;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobSectionSteps {
    private final Page currentPage = OrangeHRM.getPage();

    @When("user clicks on 'Login' button")
    public void userRedirectedOnTheDashboardPage() {
        currentPage.locator(".orangehrm-login-button").click();
    }

    @Then("the user can see {} section in the main menu")
    public void JobSectionIsNotExist(String jobSection) {
        currentPage.waitForLoadState(LoadState.NETWORKIDLE);
        Locator job = currentPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(jobSection));
        assertEquals(1, job.count(), "The job section is exist");
    }

    @After
    public void tearDown() {
        OrangeHRM.close();
    }
}
