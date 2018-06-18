package com.spbstu.lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class HomePage {

    public WebDriver driver;
    @FindBy(css = ".profile-photo")
    WebElement ProfilePhoto;
    @FindBy(css = "#Login")
    WebElement UserLogin;
    @FindBy(css = "#Password")
    WebElement UserPass;
    @FindBy(css = "form .btn-login")
    WebElement UserEnter;
    @FindBy(css = ".logout")
    WebElement LogOutIn;
    @FindBy(css = ".icons-benefit")
    List<WebElement> IconsPage;
    @FindBy(css = ".benefit-txt")
    List<WebElement> TextsIn;
    @FindBy(css = ".main-title")
    WebElement MainTitleIn;
    @FindBy(css = ".main-txt")
    WebElement MainTextIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }


    public void openSite(String Site) {
        driver.navigate().to(Site);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLoggedIn(String Login, String Password) {
        ProfilePhoto.click();
        UserLogin.sendKeys(Login);
        UserPass.sendKeys(Password);
        UserEnter.click();
        return LogOutIn.isDisplayed();
    }

    public String getUsername() {
        return ProfilePhoto.getText();
    }

    public Integer getIconsNumber() { return IconsPage.size(); }

    public String getPictureText(int i) {
        return TextsIn.get(i).getText();
    }

    public String getMainTitle() {
        return MainTitleIn.getText();
    }

    public String getMainText() {
        return MainTextIn.getText();
    }
}
