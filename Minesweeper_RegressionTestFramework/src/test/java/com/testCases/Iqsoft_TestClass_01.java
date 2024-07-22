package com.testCases;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


public class Iqsoft_TestClass_01 extends Iqsoft_001_BaseTest {


    public Iqsoft_TestClass_01() throws AWTException {
    }



    @BeforeClass
    public void setUp() {

    }


    @Test(description = "test")
    @Feature("testFeature")
    @Story("testStory")
    @Description("testDescription")
    @Severity(SeverityLevel.BLOCKER)
    public void test() {
        iqsoftPage01.clickOnButtonPlay();
        Assert.assertTrue(true);
    }




    @Test(description = "", dependsOnMethods = "test")
    @Feature("")
    @Story("")
    @Description("")
    @Severity(SeverityLevel.BLOCKER)
    public void test2() {

    }


}