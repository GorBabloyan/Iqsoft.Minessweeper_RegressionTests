package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class Iqsoft_TestClass_18_Bet extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_18_Bet() {
    }


    @Test(description = "Bet", priority = 59)
    @Feature("Bet")
    @Story("Bet_Message")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_ValidatePositiveResponse() throws InterruptedException {

        while (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount() != 0) {

            client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                    2, 10, 1, 1, 110, 6));
            iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                    mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
            I++;


            client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I, 0, 0));
            iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                    mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
            I++;

            Assert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(), 0,
                    "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
        }
    }





}
