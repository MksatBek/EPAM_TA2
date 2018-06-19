package com.spbstu.lab4;

import com.spbstu.lab4.enums.CHECK_BOX;
import com.spbstu.lab4.enums.DROP_COLOR;
import com.spbstu.lab4.enums.PAGE_DATA;
import com.spbstu.lab4.enums.RADIO;
import com.spbstu.lab4.utilities.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.sleep;
import static com.spbstu.lab4.TestEpamWebsiteSelenide.differentElementsPages;
import static com.spbstu.lab4.TestEpamWebsiteSelenide.homePageSelenide;
import static com.spbstu.lab4.enums.DIFF_ELEMENTS_DATA.SELECT_ELEMENTS;
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
        TestEpamWebsiteSelenide.init();
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
