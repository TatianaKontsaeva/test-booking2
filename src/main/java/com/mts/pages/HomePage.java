package com.mts.pages;

import com.codeborne.selenide.Condition; 
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement searchField = $("input[name='ss']");
    private SelenideElement searchButton = $x("//button[.//span[text()='Найти']]");
    private SelenideElement dateFieldButton = $("button[data-testid='date-display-field-start']");
    private SelenideElement flexiblePlansButton = $("#flexible-searchboxdatepicker-tab-trigger");
    private SelenideElement weekendOption = $x("//label//div[contains(text(), 'На выходные')]");
    private SelenideElement monthOption = $x("//label[@data-testid='flexible-dates-month']//span[contains(text(), 'Янв') and following-sibling::span[text()='2025']]");
    private SelenideElement selectDatesButton = $("button:has(span.e4adce92df)");

    public HomePage openHomePage() {
        open("https://booking.com/");
        return this;
    }

    public HomePage enterCity(String city) {
        searchField.setValue(city);
        return this;
    }

    public HomePage selectFlexibleDates() {
        dateFieldButton.click();

        flexiblePlansButton.shouldBe(Condition.visible).click();

        weekendOption.shouldBe(Condition.visible).click();

        monthOption.shouldBe(Condition.visible).click();

        selectDatesButton.shouldBe(Condition.enabled).click();

        return this;
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).scrollIntoView("{block: 'center'}").click();
        return new SearchResultsPage();
    }
}
