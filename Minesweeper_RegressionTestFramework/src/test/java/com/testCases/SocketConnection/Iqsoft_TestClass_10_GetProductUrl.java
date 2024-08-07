package com.testCases.SocketConnection;

import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = { "GetProductUrl" })

public class Iqsoft_TestClass_10_GetProductUrl extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_10_GetProductUrl() {
    }


    @Test(description = "GetProductUrl",priority = 10)
    @Feature("GetProductUrl")
    @Story("RequestSucceeded_GetProductUrlLoggedIn")
    @Description("Verify GetProductUrl Success Response")
    @Severity(SeverityLevel.BLOCKER)
    public void GetProductUrl_Success()  {
        Assert.assertNotNull(sessionToken, "SessionToken: " + sessionToken);
    }






}
