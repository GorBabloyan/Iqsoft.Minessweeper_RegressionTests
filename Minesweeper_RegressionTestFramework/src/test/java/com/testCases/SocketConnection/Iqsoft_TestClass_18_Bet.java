package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = {"SocketMessages"}, dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_18_Bet extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_18_Bet() {
    }

    @BeforeMethod
    public void MessageBet() throws InterruptedException {

    }

    @Test(description = "Bet", priority = 59)
    @Feature("Bet")
    @Story("Bet_Message")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_ValidatePositiveResponse() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        do {
            client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
            iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                    mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
            I++;

            Thread.sleep(1000);
            client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                    2, 10, 1, 1, 110, 6));
            iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                    mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
            I++;

            client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I, 0, 0));
            iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                    mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
            I++;

            softAssert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(), 0,
                    "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
            softAssert.assertNotEquals(iqsoft306_socketMessage_bet_response.getR().getResponseObject().getCurrencyId(), null,
                    "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
            if (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getBetAmount() <= 0) {
                softAssert.fail("Invalid BetAmount: " + iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getBetAmount());
            } else {
                softAssert.assertTrue(true);
            }

            softAssert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getBoard().size(),
                    iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getHeight(),
                    "Board Columns size: " + iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getBoard().size()
                            + " Bet Response VS Create Board Request  " + iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getHeight());

            softAssert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getDimension().getHeight(),
                    iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getHeight(),
                    "Board Height " + iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getBoard().size()
                            + " Bet Response VS Create Board Request  " + iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getHeight());
            softAssert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getDimension().getWidth(),
                    iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getWidth(),
                    " Bet Response VS Create Board Request  " + iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getDimension().getWidth()
                            + "  VS  " + iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getWidth());
            softAssert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getDimension().getMines(),
                    iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getMinesCount(),
                    "Mines Count " + iqsoft306_socketMessage_bet_response.getR().getResponseObject().getBoardInfo().getDimension().getMines()
                            + " Bet Response VS Create Board Request  " + iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getMinesCount());

        }
        while (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount() == 0);

        softAssert.assertAll();
    }

}
