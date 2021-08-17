package cloud.autotests.tests;

import cloud.autotests.config.App;
import com.codeborne.selenide.Configuration;
import io.appium.java_client.MobileBy;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



public class BrowserStackIosSampleTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = App.config.apiUrl();
        Configuration.baseUrl = App.config.webUrl();
    }


    @Test
    @DisplayName("Check Login option at menu")
    void loginOptionCheck() {
        step("Wait while Wikipedia is opened", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).shouldBe(visible));
        step("Open menu", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click());
        step("Check Log in to Wikipedia option", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia")));
    }

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));

    }
}