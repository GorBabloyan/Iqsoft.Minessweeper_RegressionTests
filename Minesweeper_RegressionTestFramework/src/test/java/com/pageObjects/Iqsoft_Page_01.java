package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class Iqsoft_Page_01 extends Iqsoft_001_BasePage{

    private final Iqsoft_001_BasePage iqsoft001BasePage;

    public Iqsoft_Page_01(WebDriver driver) throws AWTException {
        super(driver);
        iqsoft001BasePage = new Iqsoft_001_BasePage(driver);
    }


    @FindBy(xpath = "//button[@class='btn_play']")
    @CacheLookup
    WebElement buttonPlay;

    public void clickOnButtonPlay() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(buttonPlay);
            iqsoft001BasePage.clickOnElementIfClickable(buttonPlay);

        } catch (Exception e) {
            logger.error("clickOnButtonPlay() method has an Exception: " + e);
        }
    }



}
