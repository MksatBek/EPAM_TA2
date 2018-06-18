package com.spbstu.lab4;

import ru.yandex.qatools.allure.annotations.Step;

public class TestWebsiteSelenide {

    static public HomePageSelenide homePageSelenide;
    static public DifferentElementsPages differentElementsPages;

    @Step("Init DifferentElementsPages")
    public static void init() {
        homePageSelenide = new HomePageSelenide();
        differentElementsPages = new DifferentElementsPages();
    }
}
