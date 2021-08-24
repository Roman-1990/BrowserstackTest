package cloud.autotests.tests;

import cloud.autotests.helpers.AllureAttachments;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cloud.autotests.drivers.BrowserstackMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static cloud.autotests.helpers.AllureAttachments.getSessionId;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;



public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {

        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
//        Attach.browserConsoleLogs();

        closeWebDriver();

        AllureAttachments.attachVideo(sessionId);

    }
}
