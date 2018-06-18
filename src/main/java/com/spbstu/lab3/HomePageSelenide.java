package com.spbstu.lab3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.lab3.utilities.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;

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

    public static void open() {
        Selenide.open(ConfigFactory.create(TestConfig.class).homepage());
    }

    public String getTitle() {
        return Selenide.title();
    }

    public void checkLoggedIn(String Login, String Password) {
        profileIcon.click();
        loginIn.sendKeys(Login);
        passwordIn.sendKeys(Password);
        enterIn.click();
        logOutIn.shouldBe(Condition.visible);
    }

    public void checkUserName(String Username) {
        profileIcon.shouldBe(Condition.visible);
        profileIcon.shouldHave(Condition.text(Username));
    }

    public void checkIconsAndTextsExists() {
        for (int i = 0; i < 4; i++) {
            iconsIn.get(i).shouldBe(Condition.visible);
            textsIn.get(i).shouldBe(Condition.visible);
        }
    }

    public void checkMainTitle(String mainTitle) {
        mainTitleIn.shouldBe(Condition.visible);
        mainTitleIn.shouldHave(Condition.text(mainTitle));
    }

    public void checkMainText(String mainText) {
        mainTextIn.shouldBe(Condition.visible);
        mainTextIn.shouldHave(Condition.text(mainText));
    }

    public void checkServiceButtons(String[] str) {
        serviceLeftSection.click();
        serviceHeader.click();
        for (int i = 0; i < 6; i++) {
            serviceLeftSection.shouldHave(Condition.text(str[i]));
            serviceHeader.shouldHave(Condition.text(str[i]));
        }
    }
}
