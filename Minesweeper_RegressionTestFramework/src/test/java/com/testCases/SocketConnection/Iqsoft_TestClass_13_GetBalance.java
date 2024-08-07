package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft302_SocketMessage_Balance_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = { "SocketMessages" },dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_13_GetBalance extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_13_GetBalance() {
    }


    @BeforeClass
    public void MessageBalance() throws InterruptedException {
        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "Balance", I));
        iqsoft302_socketMessage_balance_response = (Iqsoft302_SocketMessage_Balance_Response)
                mapReceivedMessage(Iqsoft302_SocketMessage_Balance_Response.class, String.valueOf(I));
        I++;
    }


    @Test(description = "GetBalance",priority = 13)
    @Feature("GetBalance")
    @Story("Balance_Message")
    @Description("Verify Socket Balance Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBalance_ValidatePositiveResponse()  {

        Assert.assertEquals(iqsoft302_socketMessage_balance_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        if (iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance()>=0){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Balance: " + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        }
    }








}
