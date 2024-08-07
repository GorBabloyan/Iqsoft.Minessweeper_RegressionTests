package com.testCases;

import io.qameta.allure.*;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Iqsoft_TestClass_01_Header extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_01_Header() {
    }



    @BeforeClass
    public void setUp() {

    }


    @Test(description = "Check logo image",priority = -100)
    @Feature("Minesweeper header")
    @Story("check logo")
    @Description("Check logo image")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLogoVisibility() {
        Assert.assertTrue(iqsoftPage01.checkLogoImgLink(), "Invalid Logo");
    }

    @Test(description = "Check game title",priority = -100)
    @Feature("Minesweeper header")
    @Story("check Title")
    @Description("Check Title visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTitleVisibility() {
        Assert.assertEquals(iqsoftPage01.getTextGameTitle(), "Minesweeper","Invalid Title");
    }

    @Test(description = "Check game userId text",priority = -100)
    @Feature("Minesweeper header")
    @Story("check userId text")
    @Description("Check userId text visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTextUserIdVisibility() {
        Assert.assertEquals(iqsoftPage01.getTextUserID(), "User ID","Invalid UserId text: " + iqsoftPage01.getTextUserID());
    }

    @Test(description = "Check game userId",priority = -100)
    @Feature("Minesweeper header")
    @Story("check userId")
    @Description("Check userId visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkUserIdVisibility() {
        Assert.assertNotEquals(iqsoftPage01.getUserID(), 0,"Invalid UserId: " + iqsoftPage01.getUserID());
    }

    @Test(description = "Check game balance text",priority = -100)
    @Feature("Minesweeper header")
    @Story("check Balance text")
    @Description("Check Balance text visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkTextBalanceVisibility() {
        Assert.assertEquals(iqsoftPage01.getTextBalance(), "Balance","Invalid Balance text: " + iqsoftPage01.getTextBalance());
    }

    @Test(description = "Check Client Balance",priority = -100)
    @Feature("Minesweeper header")
    @Story("Check Balance")
    @Description("Check Balance visibility")
    @Severity(SeverityLevel.BLOCKER)
    public void checkBalanceVisibility() {
        if (iqsoftPage01.getBalance()>0){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Balance is negative: " + iqsoftPage01.getBalance());
        }
    }



}