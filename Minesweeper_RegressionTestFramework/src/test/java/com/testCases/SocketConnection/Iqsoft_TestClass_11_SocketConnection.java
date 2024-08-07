package com.testCases.SocketConnection;

import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = { "SocketConnection" },dependsOnGroups = {"GetProductUrl"})

public class Iqsoft_TestClass_11_SocketConnection extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_11_SocketConnection() {
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver.quit();
        socketConnectionLoggedInVirtual();
    }

    @Test(description = "SocketConnection",priority = 10)
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void SocketConnectionSportsBook_ValidatePositiveResponse()  {
        Assert.assertEquals( isSocketConnectionSuccess,true,
                "SocketConnectionSuccess: " + isSocketConnectionSuccess);
    }


//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 11)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageAuthorized_ValidatePositiveResponse() throws InterruptedException {
//
//        SoftAssert softAssert = new SoftAssert();
//        client.sendMessage(sendSocketMessageWithoutArgument("basehub", "Authorized", I));
//        iqsoft300_socketMessage_authorized_response = (Iqsoft300_SocketMessage_Authorized_Response)
//                mapReceivedMessage(Iqsoft300_SocketMessage_Authorized_Response.class, String.valueOf(I));
//
//        I++;
//
//        softAssert.assertEquals(true, iqsoft300_socketMessage_authorized_response.getR().isAuthorized(),
//                "Authorized: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
//        softAssert.assertEquals(null, iqsoft300_socketMessage_authorized_response.getR().getCurrencyId(),
//                "CurrencyId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
//        softAssert.assertEquals(0, iqsoft300_socketMessage_authorized_response.getR().getCurrencyRate(),
//                "CurrencyRate: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
//        softAssert.assertEquals(0, iqsoft300_socketMessage_authorized_response.getR().getClientId(),
//                "ClientId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
//    }
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 12)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageUnits_ValidatePositiveResponse() throws InterruptedException {
//
//        client.sendMessage(sendSocketMessageWithoutArgument("websitehub", "Units", I));
//        iqsoft301_socketMessage_units_response = (Iqsoft301_SocketMessage_Units_Response)
//                mapReceivedMessage(Iqsoft301_SocketMessage_Units_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft301_socketMessage_units_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft301_socketMessage_units_response.getR().getResponseCode());
//        Assert.assertNotEquals(null, iqsoft301_socketMessage_units_response.getR(),
//                "Units R: " + iqsoft301_socketMessage_units_response.getR());
//    }
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 13)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageBalance_ValidatePositiveResponse() throws InterruptedException {
//
//        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "Balance", I));
//        iqsoft302_socketMessage_balance_response = (Iqsoft302_SocketMessage_Balance_Response)
//                mapReceivedMessage(Iqsoft302_SocketMessage_Balance_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft302_socketMessage_balance_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
//        if (iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance()>=0){
//            Assert.assertTrue(true);
//        }else{
//            Assert.fail("Balance: " + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
//        }
//    }
//
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 14)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageState_ValidatePositiveResponse() throws InterruptedException {
//        List<Integer> list = new ArrayList<>();
//        list.add(73);
//        list.add(73);
//        client.sendMessage(sendSocketMessageState("websitehub", "State", I, list));
//        iqsoft303_socketMessage_state_response = (Iqsoft303_SocketMessage_State_Response)
//                mapReceivedMessage(Iqsoft303_SocketMessage_State_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft303_socketMessage_state_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft303_socketMessage_state_response.getR().getResponseCode());
//
//    }
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 15)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageDefaultBoard_ValidatePositiveResponse() throws InterruptedException {
//        List<Integer> list = new ArrayList<>();
//        list.add(73);
//        list.add(73);
//        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "GetDefaultBoards", I));
//        iqsoft304_socketMessage_getDefaultBoards_response = (Iqsoft304_SocketMessage_GetDefaultBoards_Response)
//                mapReceivedMessage(Iqsoft304_SocketMessage_GetDefaultBoards_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseCode());
//
//    }
//
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 16)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageCreateBoard_ValidatePositiveResponse() throws InterruptedException {
//        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
//                2,10,1,1,110,6));
//        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
//                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
//
//    }
//
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 17)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageBet_ValidatePositiveResponse() throws InterruptedException {
//
//        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,0,0
//                ));
//        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
//                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
//        I++;
//
//        Assert.assertEquals(0, iqsoft306_socketMessage_bet_response.getR().getResponseCode(),
//                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
//    }
//
//
//
//    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse",priority = 18)
//    @Feature("SocketConnection")
//    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
//    @Description("Verify Socket Success connection")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageCashout_ValidatePositiveResponse() throws InterruptedException {
//
//        if (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount() !=0 ){
//            client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
//            iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
//                    mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
//            I++;
//
//            Assert.assertEquals(0, iqsoft307_socketMessage_cashOut_response.getR().getResponseCode(),
//                    "ResponseCode: " + iqsoft307_socketMessage_cashOut_response.getR().getResponseCode());
//        }
//
//    }



}
