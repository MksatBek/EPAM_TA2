package com.spbstu.lab3;

import com.spbstu.lab3.enums.CHECK_BOX;
import com.spbstu.lab3.enums.DROP_COLOR;
import com.spbstu.lab3.enums.PAGE_DATA;
import com.spbstu.lab3.enums.RADIO;
import com.spbstu.lab3.utilities.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.spbstu.lab3.TestEpamWebsiteSelenide.differentElementsPages;
import static com.spbstu.lab3.TestEpamWebsiteSelenide.homePageSelenide;
import static com.spbstu.lab3.enums.DIFF_ELEMENTS_DATA.SELECT_ELEMENTS;
import static org.aeonbits.owner.ConfigFactory.create;

public class TestLab3 {


    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestEpamWebsiteSelenide.init();
    }

    @Test
    public void Lab3_1() {
        homePageSelenide.open();
        homePageSelenide.checkLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_DATA.USER_NAME.str);
        homePageSelenide.checkIconsAndTextsExists();
        homePageSelenide.checkMainTitle(PAGE_DATA.MAIN_HEADER.str);
        homePageSelenide.checkMainText(PAGE_DATA.HOME_PAGE.str);
        homePageSelenide.checkServiceButtons(PAGE_DATA.SERVICE.strArVal);

        differentElementsPages.differentElementsPageButton.click();
        differentElementsPages.checkDiffBoxesExists();

        differentElementsPages.selectBoxElements(CHECK_BOX.WIND.getName());
        differentElementsPages.selectBoxElements(CHECK_BOX.WATER.getName());
        differentElementsPages.selectRadioElements(RADIO.SELEN.getName());
        differentElementsPages.selectColorElement(DROP_COLOR.YELLOW.getName());
        differentElementsPages.selectBoxElements(CHECK_BOX.WATER.getName());
        differentElementsPages.selectBoxElements(CHECK_BOX.WIND.getName());
        differentElementsPages.checkSelectedElements(SELECT_ELEMENTS.strArVal);
    }

    @Test
    public void Lab3_2() {

        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();

        differentElementsPages.checkSlidePositions(0, 100);
        differentElementsPages.checkSlidePositions(0, 0);
        differentElementsPages.checkSlidePositions(100, 100);
        differentElementsPages.checkSlidePositions(30, 70);
    }
}
