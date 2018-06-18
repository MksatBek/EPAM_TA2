package com.spbstu.lab4;

import com.spbstu.lab4.enums.PAGE_DATA;
import com.spbstu.lab4.utilities.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.sleep;
import static com.spbstu.lab4.TestWebsiteSelenide.differentElementsPages;
import static com.spbstu.lab4.TestWebsiteSelenide.homePageSelenide;
import static com.spbstu.lab4.enums.DIFF_ELEMENTS_DATA.*;
import static org.aeonbits.owner.ConfigFactory.create;

@Listeners(com.spbstu.lab4.allure.Allure.class)
@Features({"Testing"})
@Stories({"the test"})

public class TestLab4 {
    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestWebsiteSelenide.init();
    }

    @Test
    @Step("Test case 1")
    public void Lab4_1() {
        homePageSelenide.open();
        com.codeborne.selenide.Selenide.zoom(0.5);
        homePageSelenide.checkLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_DATA.USER_NAME.str);
        homePageSelenide.checkIconsAndTextsExists();
        homePageSelenide.checkMainTitle(PAGE_DATA.MAIN_HEADER.str);
        homePageSelenide.checkMainText(PAGE_DATA.HOME_PAGE.str);
        homePageSelenide.checkServiceButtons(PAGE_DATA.SERVICE.strAr);

        differentElementsPages.differentElementsPageButton.click();
        differentElementsPages.checkDiffBoxexExists();
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectRadioElements(RADIOS.strAr[3]);
        differentElementsPages.selectColorElement(DROP_COLORS.strAr[3]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.checkSelectedElements(SELECT_ELEMENTS.strAr);
    }

    @Test
    @Step("Test case 2")
    public void Lab4_2() {

        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();
        differentElementsPages.sliders.get(0).scrollTo();

        System.out.println(differentElementsPages.sliderLength.getSize().width);

        differentElementsPages.checkSlidePositions(0, 100);
        differentElementsPages.checkSlidePositions(0, 0);
        differentElementsPages.checkSlidePositions(100, 100);
        differentElementsPages.checkSlidePositions(30, 70);
        sleep(3000);
    }
}
