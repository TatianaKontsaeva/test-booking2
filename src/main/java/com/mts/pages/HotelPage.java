package com.mts.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HotelPage {

    private SelenideElement hotelName = $("h2[data-testid='header-title']");
    String newHotelName = hotelName.getText();
   SelenideElement ratingElement = $(".ac4a7896c7");

    String newRating = ratingElement.getText();
    SelenideElement reviewsElement = $("div.c3deae0c07 .a3b8729ab1.d86cee9b25 .ac4a7896c7");

    String newReviewsText = reviewsElement.getText();


    public void verifyHotelInfo() {
        System.out.println("Hotel Info on page: " +
                newHotelName + " " +
                newRating + " " +
                newReviewsText);
    }
}
