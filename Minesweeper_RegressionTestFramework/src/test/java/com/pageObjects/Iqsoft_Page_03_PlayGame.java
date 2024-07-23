package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class Iqsoft_Page_03_PlayGame extends Iqsoft_001_BasePage{

    private final Iqsoft_001_BasePage iqsoft001BasePage;

    public Iqsoft_Page_03_PlayGame(WebDriver driver) throws AWTException {
        super(driver);
        iqsoft001BasePage = new Iqsoft_001_BasePage(driver);
    }





    @FindBy(xpath = "//button[@class='btn_cash_out']")
    @CacheLookup
    WebElement buttonCashout;

    public void clickOnButtonCashout() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(buttonCashout);
            iqsoft001BasePage.clickOnElementIfClickable(buttonCashout);

        } catch (Exception e) {
            logger.error("clickOnButtonCashout() method has an Exception: " + e);
        }
    }

    public boolean isVisibleButtonCashout() {
        try {
            return  iqsoft001BasePage.waitElementToBeVisibleBoolean(buttonCashout);
        } catch (Exception e) {
            logger.error("isDisplayedButtonCashout() method has an Exception: " + e);
        }
        return false;
    }
















    // Getters

    public WebElement getWebElementButtonCashOut() {
        return buttonCashout;
    }


}
