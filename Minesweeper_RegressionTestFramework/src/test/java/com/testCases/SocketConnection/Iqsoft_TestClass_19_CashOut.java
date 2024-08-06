package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft302_SocketMessage_Balance_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft307_SocketMessage_CashOut_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Iqsoft_TestClass_19_CashOut extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_19_CashOut() {
    }

    @Test(description = "Cashout", priority = 60)
    @Feature("Cashout")
    @Story("Cashout_Message")
    @Description("Verify Socket Cashout Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCashout_ValidatePositiveResponse() throws InterruptedException {
        if (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount() != 0) {

            client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
            iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                    mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
            I++;

            Assert.assertEquals( iqsoft307_socketMessage_cashOut_response.getR().getResponseCode(),0,
                    "ResponseCode: " + iqsoft307_socketMessage_cashOut_response.getR().getResponseCode());

            client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
            iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                    mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
            I++;

            Assert.assertEquals( iqsoft307_socketMessage_cashOut_response.getR().getResponseCode(),0,
                    "ResponseCode: " + iqsoft307_socketMessage_cashOut_response.getR().getResponseCode());
        }
    }


}
