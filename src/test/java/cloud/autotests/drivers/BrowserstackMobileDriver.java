package cloud.autotests.drivers;

import cloud.autotests.config.BrowserApp;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserApp config = ConfigFactory.create(BrowserApp.class, System.getProperties());

        public static URL getBrowserstackUrl() {
            try {
                return new URL(config.webUrl());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

            // Set your access credentials
            desiredCapabilities.setCapability("browserstack.user", config.userLogin());
            desiredCapabilities.setCapability("browserstack.key", config.userKey());

            // Set URL of the application under test
            desiredCapabilities.setCapability("app", config.androidAppUrl());

            // Specify device and os_version for testing
            desiredCapabilities.setCapability("device", config.device());
            desiredCapabilities.setCapability("os_version", config.os_version());

            // Set other BrowserStack capabilities
            desiredCapabilities.setCapability("project", "First Java Project");
            desiredCapabilities.setCapability("build", "Java Android");
            desiredCapabilities.setCapability("name", "first_test");

            return new AndroidDriver<>(getBrowserstackUrl(), desiredCapabilities);
        }
}
