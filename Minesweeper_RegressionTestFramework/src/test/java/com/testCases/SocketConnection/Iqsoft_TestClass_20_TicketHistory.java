package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft307_SocketMessage_CashOut_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft308_SocketMessage_TicketsHistory_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Iqsoft_TestClass_20_TicketHistory extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_20_TicketHistory() {
    }

    @BeforeClass
    public void setUp() throws InterruptedException {

        client.sendMessage(sendSocketMessageTicketHistory("playerhub", "MinesweeperTicketsHistory", I));
        iqsoft308_socketMessage_ticketsHistory_response = (Iqsoft308_SocketMessage_TicketsHistory_Response)
                mapReceivedMessage(Iqsoft308_SocketMessage_TicketsHistory_Response.class, String.valueOf(I));
        I++;
    }


    @Test(description = "TicketHistory", priority = 60)
    @Feature("TicketHistory")
    @Story("TicketHistory_Message")
    @Description("Verify Socket TicketHistory Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCTicketHistory_ValidatePositiveResponse()  {

            Assert.assertEquals( iqsoft308_socketMessage_ticketsHistory_response.getR().getResponseCode(),0,
                    "ResponseCode: " + iqsoft308_socketMessage_ticketsHistory_response.getR().getResponseCode());

    }


}
