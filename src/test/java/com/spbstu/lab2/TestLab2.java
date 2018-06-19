package com.spbstu.lab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import static org.junit.Assert.assertEquals;

public class TestLab2 {

    private WebDriver driver;

    @Before
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        PageObject.initHP(this.driver);
    }

    @AfterSuite
    public void after() {
        PageObject.homePage.driver.close();
    }

    @Test
    public void Lab2() {

        PageObject.homePage.openSite();
        PageObject.homePage.getUrl();

        assertEquals(PageObject.homePage.getUrl(), PAGE_DATA.SITE.str);
        assertEquals(PageObject.homePage.getTitle(), PAGE_DATA.TITLE.str);
        Assert.assertTrue(PageObject.homePage.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str));

        assertEquals(PageObject.homePage.getUsername(), PAGE_DATA.USER_NAME.str);
        assertEquals(PageObject.homePage.getTitle(), PAGE_DATA.TITLE.str);

        assertEquals(PageObject.homePage.getIconsNumber(), PAGE_DATA.ICONS_NUMBERS.i);

        for (int i = 0; i < PAGE_DATA.ICONS_NUMBERS.i; i++) {
            assertEquals(PageObject.homePage.getPictureText(i), PAGE_DATA.TEXT.strArVal[i]);
        }

        assertEquals(PageObject.homePage.getMainTitle(), PAGE_DATA.MAIN_HEADER.str);
        assertEquals(PageObject.homePage.getMainText(), PAGE_DATA.HOME_PAGE.str);
    }
}
