package qa.guru.ht11;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubIssueNameTest {

        @Test
        public void testIssueSearch() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("/");

            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();

            $(linkText("eroshenkoam/allure-example")).click();
            $("#issues-tab").click();
            $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
        }

    }
