package com.spbstu.lab4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.lab4.utilities.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    SelenideElement profileIcon;

    @FindBy(css = "#Login")
    SelenideElement loginIn;

    @FindBy(css = "#Password")
    SelenideElement passwordIn;

    @FindBy(css = "form .btn-login")
    SelenideElement enterIn;

    @FindBy(css = ".logout")
    SelenideElement logOutIn;

    @FindBy(css = ".icons-benefit")
    ElementsCollection iconsIn;

    @FindBy(css = ".benefit-txt")
    ElementsCollection textsIn;

    @FindBy(css = ".main-title")
    SelenideElement mainTitleIn;

    @FindBy(css = ".main-txt")
    SelenideElement mainTextIn;

    @FindBy(css = "li.sub-menu")
    SelenideElement serviceLeftSection;

    @FindBy(css = "li.dropdown")
    SelenideElement serviceHeader;

    public HomePageSelenide() {
        Selenide.page(this);
    }

    @Step(" Open url")
    public static void open() {
        Selenide.open(ConfigFactory.create(TestConfig.class).homepage());
        Selenide.zoom(0.5);

    }

    @Step("Get title")
    public String getTitle() {
        return Selenide.title();
    }

    @Step("check Logged User")
    public void checkLoggedIn(String Login, String Password) {
        profileIcon.click();
        loginIn.sendKeys(Login);
        passwordIn.sendKeys(Password);
        enterIn.click();
        logOutIn.shouldBe(Condition.visible);
    }

    @Step("check UserName")
    public void checkUserName(String Username) {
        profileIcon.shouldBe(Condition.visible);
        profileIcon.shouldHave(Condition.text(Username));
    }

    @Step("check Icons And Texts Exists")
    public void checkIconsAndTextsExists() {
        for (int i = 0; i < 4; i++) {
            iconsIn.get(i).shouldBe(Condition.visible);
            textsIn.get(i).shouldBe(Condition.visible);
        }
    }

    @Step("check MainTitle")
    public void checkMainTitle(String mainTitle) {
        mainTitleIn.shouldBe(Condition.visible);
        mainTitleIn.shouldHave(Condition.text(mainTitle));
    }

    @Step("check MainText")
    public void checkMainText(String mainText) {
        mainTextIn.shouldBe(Condition.visible);
        mainTextIn.shouldHave(Condition.text(mainText));
    }

    @Step("check MainText")
    public void checkServiceButtons(String[] str) {
        serviceLeftSection.click();
        serviceHeader.click();
        for (int i = 0; i < 6; i++) {
            serviceLeftSection.shouldHave(Condition.text(str[i]));
            serviceHeader.shouldHave(Condition.text(str[i]));
        }
    }
}
