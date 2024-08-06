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


    @BeforeClass
    public void setUp() {
//        socketConnectionLoggedInVirtual();
    }

    @Test(description = "Socket", priority = 50)
    @Feature("SocketConnection")
    @Story("Bet")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_ValidateNegativeTest_1() throws InterruptedException {
        client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
        iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
        I++;

        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2, 10, 1, 1, 110, 6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;

        Thread.sleep(15000);
        client.sendMessage(sendSocketMessageTicketHistory("playerhub", "MinesweeperTicketsHistory", I));
        iqsoft308_socketMessage_ticketsHistory_response = (Iqsoft308_SocketMessage_TicketsHistory_Response)
                mapReceivedMessage(Iqsoft308_SocketMessage_TicketsHistory_Response.class, String.valueOf(I));
        I++;


        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < iqsoft308_socketMessage_ticketsHistory_response.getR().getResponseObject().getTickets().get(0).getOutcome().getBoard().size();i++){
            for (int j = 0; j < iqsoft308_socketMessage_ticketsHistory_response.getR().getResponseObject().getTickets().get(0).getOutcome().getBoard().get(i).size();j++) {
                if (iqsoft308_socketMessage_ticketsHistory_response.getR().getResponseObject().getTickets().get(0).getOutcome().getBoard().get(i).get(j) ==2){
                    right.add(j);
                    break;
                }
            }
        }
        System.out.println(">>>>>>>  " + right);



        for (int i = 0 ; i<right.size();i++){
            if (right.get(i) == 0){
                client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I, i, 0));
                iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                        mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
                I++;
            } else if (right.get(i) == 1) {
                client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I, i, 1));
                iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                        mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
                I++;
            }
            if (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount()==0){
                break;
            }

        }


        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

        Assert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(), 0,
                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
    }


    @Test(description = "Socket", priority = 50)
    @Feature("SocketConnection")
    @Story("Bet_Message")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_Negative_001() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,5,0));
        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
        I++;

        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft306_socketMessage_bet_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
    }

//    @Test(description = "Socket", priority = 50)
//    @Feature("SocketConnection")
//    @Story("Bet")
//    @Description("Verify Socket Bet Message")
//    @Severity(SeverityLevel.BLOCKER)
//    public void MessageBet_Negative_002() throws InterruptedException {
//        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
//        client.sendMessage("{\"H\":\"playerhub\",\"M\":\"RevealCell\",\"A\":[],\"I\":30}");
//        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
//                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
//        I++;
//
//        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
//        Assert.assertNotEquals( iqsoft306_socketMessage_bet_response.getR().getResponseCode(),0,
//                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
//    }



    @Test(description = "Socket", priority = 51)
    @Feature("SocketConnection")
    @Story("Bet_Message")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_Negative_003() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,0,0));
        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
        I++;
        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,0,0));
        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
        I++;
        client.sendMessage(sendSocketMessageBet("playerhub", "RevealCell", I,0,0));
        iqsoft306_socketMessage_bet_response = (Iqsoft306_SocketMessage_Bet_Response)
                mapReceivedMessage(Iqsoft306_SocketMessage_Bet_Response.class, String.valueOf(I));
        I++;
//        if (iqsoft306_socketMessage_bet_response.getR().getResponseObject().getWinAmount() != 0) {
            client.sendMessage(sendSocketMessageCashout("playerhub", "CashOut", I));
            iqsoft307_socketMessage_cashOut_response = (Iqsoft307_SocketMessage_CashOut_Response)
                    mapReceivedMessage(Iqsoft307_SocketMessage_CashOut_Response.class, String.valueOf(I));
            I++;
//            Assert.assertEquals( iqsoft307_socketMessage_cashOut_response.getR().getResponseCode(),0,
//                    "ResponseCode: " + iqsoft307_socketMessage_cashOut_response.getR().getResponseCode());
//        }
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        Assert.assertNotEquals( iqsoft306_socketMessage_bet_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
    }







    @Test(description = "Socket", priority = 59)
    @Feature("SocketConnection")
    @Story("Bet_Message")
    @Description("Verify Socket Bet Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBet_ValidatePositiveResponse() throws InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());


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
            System.out.println(">>>>>>>>>>>>>>>>>>" + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());

            Assert.assertEquals(iqsoft306_socketMessage_bet_response.getR().getResponseCode(), 0,
                    "ResponseCode: " + iqsoft306_socketMessage_bet_response.getR().getResponseCode());
        }
    }





}
