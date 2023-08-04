package qa.guru.ht11;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class GitHubIssueNameStepsTest {

    static final String repository = "eroshenkoam/allure-example";
    private static final int issue = 81;

    @Test
    public void testLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий" + repository, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(repository);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория " + repository, () -> $(linkText(repository)).click());

        step("Открываем таб issues", () -> $("#issues-tab").click());

        step("Проверяем название Issue с номером " + issue, () -> {
            $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
        });

    }

    @Test
    public void testAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.clickOnRepositaryLink(repository);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber();
    }

}
