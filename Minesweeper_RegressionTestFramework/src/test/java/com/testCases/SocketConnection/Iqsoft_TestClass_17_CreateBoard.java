package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Iqsoft_TestClass_17_CreateBoard extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_17_CreateBoard() {
    }

    public static HttpResponse<String> negotiateApiSportsBookResponse;
    int statusCode;
    String jsonObjectBody;

    @BeforeClass
    public void setUp() {
//        socketConnectionLoggedInVirtual();
    }


    @Test(description = "SocketConnection", priority = 43)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBetBeforeCreateBoard_NegativeBet_001() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,-1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,0,0));
        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
        I++;

        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
    }

    @Test(description = "SocketConnection", priority = 43)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCashoutBeforeCreateBoard_NegativeBet_001() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,-1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
        iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
        I++;

        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
    }



    @Test(description = "SocketConnection", priority = 44)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeMinesCount_002() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,0,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }
    @Test(description = "SocketConnection", priority = 44)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeMinesCount_003() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,-1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }
    @Test(description = "SocketConnection", priority = 44)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeMinesCount_004() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,2,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }





    @Test(description = "SocketConnection", priority = 45)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeBalance_005() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,1,110,-10));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }

    @Test(description = "SocketConnection", priority = 45)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeBalance_006() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,1,110,iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance() + 10));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }







    @Test(description = "SocketConnection", priority = 46)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeWidth_007() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                6,10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }
    @Test(description = "SocketConnection", priority = 46)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeWidth_008() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                1,10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }
    @Test(description = "SocketConnection", priority = 46)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeWidth_009() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                -3,10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }





    @Test(description = "SocketConnection", priority = 47)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeHeight_010() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,-10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }
    @Test(description = "SocketConnection", priority = 47)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeBetType_011() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,2,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
    }


    @Test(description = "SocketConnection", priority = 48)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_NegativeSecondBoard_012() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                5,10,1,1,110,6));

        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        softAssert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,1,110,6));

        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        softAssert.assertNotEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());

        client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
        iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

        softAssert.assertAll();

    }






    @Test(description = "SocketConnection", priority = 49)
    @Feature("SocketConnection")
    @Story("CreateBoard")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_ValidatePositiveResponse() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());

    }






}
