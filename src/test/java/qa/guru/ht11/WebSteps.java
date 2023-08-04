package qa.guru.ht11;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step ("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step(value = "Ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step()
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step()
    public void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step()
    public void shouldSeeIssueWithNumber(){
        $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));

    }
}
