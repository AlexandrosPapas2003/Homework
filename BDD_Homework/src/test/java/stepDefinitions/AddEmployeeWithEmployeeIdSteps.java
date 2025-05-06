package stepDefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import loginAsAdmin.OrangeHRM;

import java.util.List;
import java.util.Map;

public class AddEmployeeWithEmployeeIdSteps {

    private final Page currentPage = OrangeHRM.getPage();


    @And("user is redirected to {} page")
    public void redirectedToPage(String pageName) {
        if (pageName.equals("Dashboard")) {
            currentPage.locator(".orangehrm-login-button").click();
            currentPage.waitForLoadState(LoadState.NETWORKIDLE);
        } else {
            currentPage.waitForLoadState(LoadState.NETWORKIDLE);
        }
    }

    @And("{} is clicked")
    public void clickElement(String elementName) {
        switch (elementName) {
            case "Add employee" -> currentPage.getByText("Add Employee").click();
            case "Create Login Details toggle" -> currentPage.locator(".oxd-switch-wrapper").click();
            case "Save button" -> currentPage.locator("button.oxd-button--secondary").click();
            case "PIM" ->
                    currentPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(elementName)).click();
            default -> throw new IllegalArgumentException("No click action defined for: " + elementName);
        }
    }

    @And("user fills in the form with")
    public void fillForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        Locator inputs = currentPage.locator("input.oxd-input.oxd-input--active");

        inputs.nth(1).fill(data.get("firstName"));
        inputs.nth(2).fill(data.get("lastName"));
        inputs.nth(4).fill(data.get("username"));
        inputs.nth(5).fill(data.get("password"));
        inputs.nth(6).fill(data.get("password"));
    }

    @And("{} field is empty")
    public void clearField(String fieldName) {
        if (fieldName.equals("Employee Id")) {
            currentPage.locator("input[data-v-1f99f73c]").nth(4).clear();
        }
    }

    @Then("{} is displayed")
    public void verifyMessage(String expectedMessageName) {
        Locator toast = currentPage.locator(".oxd-toast-content");
        toast.waitFor();
        String actualText = toast.textContent();

        if (expectedMessageName.equals("error message")) {
            Assert.assertEquals("The system can't create a new employee", actualText);
        }
    }

    @After
    public void tearDown() {
        OrangeHRM.close();
    }
}
