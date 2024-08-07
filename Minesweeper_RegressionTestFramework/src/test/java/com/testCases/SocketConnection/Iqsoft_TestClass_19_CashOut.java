package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft307_SocketMessage_CashOut_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"SocketMessages"}, dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_19_CashOut extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_19_CashOut() {
    }

    @Test(description = "Cashout", priority = 60)
    @Feature("Cashout")
    @Story("Cashout_Message")
    @Description("Verify Socket Cashout Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCashout_ValidatePositiveResponse() throws InterruptedException {

        client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
        iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
        I++;

        Assert.assertEquals(iqsoft307_socketMessage_cashOut_response.getR().getResponseCode(), 0,
                "ResponseCode: " + iqsoft307_socketMessage_cashOut_response.getR().getResponseCode());
    }


}
