package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SearchWithStep extends TestBase {

    @Step("Открываем главную страницу GitHub")
    void openGitHub() {
        open(baseUrl);
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    void openMainGitHub(String REPOSITORY) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория")
    void clickIssueLink() {
        $(linkText("selenide/selenide")).click();
    }

    @Step("Открываем таб Issues")
    void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {ISSUE}")
    void searchIssue(int ISSUE) {
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Test
    void webStepTest() {
        openGitHub();
        openMainGitHub(REPOSITORY);
        clickIssueLink();
        openIssueTab();
        searchIssue(ISSUE);
    }
}
