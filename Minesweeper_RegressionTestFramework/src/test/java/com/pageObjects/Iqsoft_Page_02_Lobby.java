package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class Iqsoft_Page_02_Lobby extends Iqsoft_001_BasePage{

    private final Iqsoft_001_BasePage iqsoft001BasePage;

    public Iqsoft_Page_02_Lobby(WebDriver driver) throws AWTException {
        super(driver);
        iqsoft001BasePage = new Iqsoft_001_BasePage(driver);
    }





//    @FindBy(xpath = "//button[@class='btn_play']")
    @FindBy(xpath = "//button[@class='btn_play']")

    @CacheLookup
    WebElement buttonPlayNow;

    public void clickOnButtonPlayNow() {
        try {
//            iqsoft001BasePage.waitElementToBeVisible(buttonPlayNow);
//            iqsoft001BasePage.clickOnElementIfClickable(buttonPlayNow);

        } catch (Exception e) {
            logger.error("clickOnButtonPlay() method has an Exception: " + e);
        }
    }

    public boolean isDisplayedButtonPlayNow() {
        try {
            return  buttonPlayNow.isDisplayed();

        } catch (Exception e) {
            logger.error("isDisplayedButtonPlayNow() method has an Exception: " + e);
        }
        return false;
    }

    @FindBy(xpath = "//div[@class='options_buttons top_buttons']//button[1]")
    @CacheLookup
    WebElement buttonDefaultOption;

    public void clickOnButtonDefaultOption() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(buttonDefaultOption);
            iqsoft001BasePage.clickOnElementIfClickable(buttonDefaultOption);

        } catch (Exception e) {
            logger.error("clickOnButtonDefaultOption() method has an Exception: " + e);
        }
    }

    public boolean isDisplayedButtonDefaultOption() {
        try {
            return  buttonDefaultOption.isDisplayed();

        } catch (Exception e) {
            logger.error("isDisplayedButtonDefaultOption() method has an Exception: " + e);
        }
        return false;
    }


    @FindBy(xpath = "//div[@class='options_buttons top_buttons']//button[2]")
    @CacheLookup
    WebElement buttonCustomOption;

    public void clickOnButtonCustomOption() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(buttonCustomOption);
            iqsoft001BasePage.clickOnElementIfClickable(buttonCustomOption);

        } catch (Exception e) {
            logger.error("clickOnButtonCustomOption() method has an Exception: " + e);
        }
    }

    public boolean isDisplayedButtonCustomOption() {
        try {
            return  buttonCustomOption.isDisplayed();

        } catch (Exception e) {
            logger.error("isDisplayedButtonCustomOption() method has an Exception: " + e);
        }
        return false;
    }















    // Getters

    public WebElement getWebElementButtonPlay() {
        return buttonPlayNow;
    }


}
