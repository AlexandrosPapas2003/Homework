package loginAsAdmin;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OrangeHRM {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static void init() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void close() {
        page.close();
        browser.close();
        playwright.close();
    }
}
