package qa.guru.ht11;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;
@Tag("remote")
public class GitHubIssueNameStepsTest extends TestBase{

    static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 81;

    @Test
    public void testLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("/"));
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());

        step("Открываем таб issues", () -> $("#issues-tab").click());

        step("Проверяем название Issue с номером " + ISSUE, () -> {
            $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
        });

    }

    @Test
    public void testAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber();
    }

}
