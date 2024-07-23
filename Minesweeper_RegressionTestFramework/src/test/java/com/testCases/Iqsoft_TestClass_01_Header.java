package com.testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Iqsoft_TestClass_01_Header extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_01_Header() {
    }



    @BeforeClass
    public void setUp() {

    }


    @Test(description = "Check logo image")
    @Feature("Minesweeper header")
    @Story("check logo")
    @Description("Check logo image")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLogoVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementLogoImg());
        Assert.assertTrue(iqsoftPage01.checkLogoImgLink(), "Invalid Logo");
    }

    @Test(description = "Check game title")
    @Feature("Minesweeper header")
    @Story("check Title")
    @Description("Check Title visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTitleVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementGameTitle());
        Assert.assertEquals(iqsoftPage01.getTextGameTitle(), "Minesweeper","Invalid Title");
    }

    @Test(description = "Check game userId text")
    @Feature("Minesweeper header")
    @Story("check userId text")
    @Description("Check userId text visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTextUserIdVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementTextUserId());
        Assert.assertEquals(iqsoftPage01.getTextUserID(), "User ID","Invalid UserId text: " + iqsoftPage01.getTextUserID());
    }

    @Test(description = "Check game userId")
    @Feature("Minesweeper header")
    @Story("check userId")
    @Description("Check userId visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkUserIdVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementUserId());
        Assert.assertNotEquals(iqsoftPage01.getUserID(), 0,"Invalid UserId: " + iqsoftPage01.getUserID());
    }

    @Test(description = "Check game balance text")
    @Feature("Minesweeper header")
    @Story("check Balance text")
    @Description("Check Balance text visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTextBalanceVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementTextBalance());
        Assert.assertEquals(iqsoftPage01.getTextBalance(), "Balance","Invalid Balance text: " + iqsoftPage01.getTextBalance());
    }

    @Test(description = "Check Client Balance")
    @Feature("Minesweeper header")
    @Story("Check Balance")
    @Description("Check Balance visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkBalanceVisibility() {
        basePage.setElement(iqsoftPage01.getWebElementBalance());
        Assert.assertNotEquals(iqsoftPage01.getBalance(), -1,"Invalid ClientBalance");
    }



}