package stepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import loginAsAdmin.Admin;
import loginAsAdmin.OrangeHRM;

public class LoginSteps {
    private Page page;
    private static final String ORANGE_HRM_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        OrangeHRM.init();
        page = OrangeHRM.getPage();
    }

    @Given("user logs in OrangeHRM page")
    public void UserLogsIn() {
        page.navigate(ORANGE_HRM_URL);
        Locator username = page.getByPlaceholder("Username");
        username.fill(Admin.getUSERNAME());
        Locator password = page.getByPlaceholder("Password");
        password.fill(Admin.getPASSWORD());
    }
}
