package cloud.autotests.helpers;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.remote.MobileBrowserType.BROWSER;

public class AllureAttachments {
    @Attachment(value = "{attachName}", type = "text/plain")
    public static void attachAsText(String attachName, String message) {
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static void pageSource() {
        getWebDriver().getPageSource();
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static void screenshotAs(String attachName) {
        ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static void attachVideo(String sessionId) {
        Browserstack.videoUrl(sessionId);
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }
}
