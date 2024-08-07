package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft305_SocketMessage_CreateBoard_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = { "SocketMessages" },dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_17_CreateBoard extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_17_CreateBoard() {
    }

    @BeforeClass
    public void MessageCreateBoard() throws InterruptedException {
        client.sendMessage(sendSocketMessageCreateBoard("playerhub", "CreateBoard", I,
                2,10,1,1,110,6));
        iqsoft305_socketMessage_createBoard_response = (Iqsoft305_SocketMessage_CreateBoard_Response)
                mapReceivedMessage(Iqsoft305_SocketMessage_CreateBoard_Response.class, String.valueOf(I));
        I++;
    }





    @Test(description = "CreateBoard", priority = 49)
    @Feature("CreateBoard")
    @Story("CreateBoard_Message")
    @Description("Verify Socket CreateBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageCreateBoard_ValidatePositiveResponse() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseCode());
        softAssert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getHeight(),
                iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getHeight(),
                "BoardHeight: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getHeight());

        softAssert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getWidth(),
                iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getWidth(),
                "BoardWidth: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getWidth());

        softAssert.assertEquals( iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getMines(),
                iqsoft202_socketMessage_createBoard_request.getA().get(0).getBoardInput().getMinesCount(),
                "MinesCount: " + iqsoft305_socketMessage_createBoard_response.getR().getResponseObject().getBoardInfo().getDimension().getMines());



        softAssert.assertAll();

    }



}
