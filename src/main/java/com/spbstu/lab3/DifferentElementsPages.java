package com.spbstu.lab3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DifferentElementsPages {

    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
    SelenideElement differentElementsPageButton;

    @FindBy(css = ".label-checkbox")
    ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    ElementsCollection radios;

    @FindBy(css = "div.colors")
    ElementsCollection dropDownColors;

    @FindBy(css = "[value=\"Default Button\"]")
    SelenideElement defaultButton;

    @FindBy(css = "[value=\"Button\"]")
    SelenideElement button;

    @FindBy(css = ".logs li")
    ElementsCollection Logs;

    @FindBy(css = "#mCSB_1")
    SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    SelenideElement rightSection;

    @FindBy(css = ".dropdown-menu | [href=\"page4.htm\"]")
    SelenideElement datesPageButton;

    @FindBy(css = ".ui-slider-handle")
    ElementsCollection sliders;

    @FindBy(css = ".ui-slider-horizontal")
    SelenideElement sliderLength;


    public DifferentElementsPages() {
        Selenide.page(this);
    }


    public void checkDiffBoxexExists() {
        for (SelenideElement checkBox : checkBoxes) {
            checkBox.shouldBe(Condition.visible);
        }
        for (SelenideElement radio: radios){
            radio.shouldBe(Condition.visible);
        }

        dropDownColors.get(0).shouldBe(Condition.visible);
        leftSection.shouldBe(Condition.visible);
        rightSection.shouldBe(Condition.visible);
        defaultButton.shouldBe(Condition.visible);
        button.shouldBe(Condition.visible);
    }

    public void selectBoxElements(String str) {
        for (SelenideElement checkBox : checkBoxes) {
            if (checkBox.getText().contains(str)) {
                checkBox.click();
            }
        }
    }

    public void selectRadioElements(String str) {
        for (SelenideElement radio : radios) {
            if (radio.getText().contains(str)) {
                radio.click();
            }
        }
    }

    public void selectColorElement(String str) {
        $(".colors .uui-form-element").selectOption(str);
    }

    public void checkSelectedElements(String[] strAr) {
        for (int i = 0; i < strAr.length; i++) {
            Logs.get(i).shouldHave(Condition.text(strAr[i]));
        }
    }

    public void checkUnselectedElements(String[] strAr) {
        for (int i = 0; i < Logs.size(); i++)
            System.out.println(Logs.get(i).getText());

        for (int i = 4; i < strAr.length; i++) {
            Logs.get(i).shouldHave(Condition.text(strAr[i]));
        }
    }

    public void checkSlidePositions(int left, int right) {
        int length = sliderLength.getSize().width;
        int leftBegin = Integer.parseInt(sliders.get(0).getText());
        int rightBegin = Integer.parseInt(sliders.get(1).getText());

        if (left <= leftBegin) {
            actions().dragAndDropBy(sliders.get(0), -((length * ((leftBegin - left) + 1) / 100)), 0).perform();
            System.out.println("Left: " + Integer.parseInt(sliders.get(0).getText()));
        } else {
            actions().dragAndDropBy(sliders.get(0), (length * ((leftBegin + left) - 1) / 100), 0).perform();
            System.out.println("Left: " + Integer.parseInt(sliders.get(0).getText()));
        }
        if ((Integer.parseInt(sliders.get(0).getText()) == leftBegin) && (Integer.parseInt(sliders.get(1).getText()) == right)) {
            if (left <= leftBegin) {
                actions().dragAndDropBy(sliders.get(0), -((length * ((leftBegin - left) + 1) / 100)), 0).perform();
                System.out.println("Left: " + Integer.parseInt(sliders.get(0).getText()));
            } else {
                actions().dragAndDropBy(sliders.get(0), (length * ((leftBegin + left) - 1) / 100), 0).perform();
                System.out.println("Left: " + Integer.parseInt(sliders.get(0).getText()));
            }
        } else {
            if (right < rightBegin) {
                actions().dragAndDropBy(sliders.get(1), -(length * ((rightBegin - right) + 1) / 100), 0).perform();
                System.out.println("Right: " + Integer.parseInt(sliders.get(1).getText()));
            } else {
                actions().dragAndDropBy(sliders.get(1), (length * ((-rightBegin + right) + 1) / 100), 0).perform();
                System.out.println("Right: " + Integer.parseInt(sliders.get(1).getText()));
            }
        }

        System.out.println("");
        System.out.println("Left: " + Integer.parseInt(sliders.get(0).getText()));
        System.out.println("Right: " + Integer.parseInt(sliders.get(1).getText()));

        sliders.get(0).shouldHave(Condition.text(String.valueOf(left)));
        sliders.get(1).shouldHave(Condition.text(String.valueOf(right)));
    }
}
