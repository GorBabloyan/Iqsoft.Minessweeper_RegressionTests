package com.testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iqsoft_TestClass_02_Lobby  extends Iqsoft_001_BaseTest{

    public Iqsoft_TestClass_02_Lobby() {
    }



    @BeforeClass
    public void setUp() {

    }


    @Test(description = "Check Play now buttons functionality",priority = -100)
    @Feature("Minesweeper Lobby")
    @Story("Check Play now buttons functionality")
    @Description("Check Play now buttons functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void checkPlayNowFunctionality()  {
        iqsoftPage02.clickOnButtonPlayNow();
        Assert.assertTrue(iqsoftPage03.isVisibleButtonCashout(),
                "After clicking Play Now button game page didn't opened");
    }











}
