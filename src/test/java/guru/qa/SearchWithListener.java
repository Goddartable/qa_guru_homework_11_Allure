package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SearchWithListener extends TestBase {

    @Test
    @DisplayName("Поиск Issue в Github. Listener")
    void searchGithubIssueListener() {
        open(baseUrl);
        $(".search-input").click();
        $("#query-builder-test").sendKeys("Selenide");
        $("#query-builder-test").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);


    }
}
