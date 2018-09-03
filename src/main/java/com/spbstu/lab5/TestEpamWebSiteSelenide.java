package com.spbstu.lab5;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.spbstu.lab5.entities.User;
import com.spbstu.lab5.entities.Users;
import com.spbstu.lab5.enums.PAGE_DATA;
import com.spbstu.lab5.pages.HomePageJDI;
import com.spbstu.lab5.pages.MetalsAndColorsPage;
import org.openqa.selenium.support.FindBy;

import static com.spbstu.lab5.entities.Users.PETER;

@JSite("https://jdi-framework.github.io/tests/")
public class TestEpamWebSiteSelenide extends WebSite {

    public static HomePageJDI homePageJDI;
    public static MetalsAndColorsPage metalsAndColorsPageJDI;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @FindBy(css = ".logout")
    public static Button logout;

    @FindBy(css = ".uui-navigation | [href=\"page2.htm\"]")
    public static Button metalsAndColorsPageButton;

    public static void login(User user1) {
        profilePhoto.click();
        loginForm.loginAs(user1);
    }
    //public static void login(){
    //    login(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
    //}

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPageButton.click();
    }


}
