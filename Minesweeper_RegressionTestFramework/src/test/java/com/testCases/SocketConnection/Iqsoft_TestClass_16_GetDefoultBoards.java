package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft302_SocketMessage_Balance_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft304_SocketMessage_GetDefaultBoards_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class Iqsoft_TestClass_16_GetDefoultBoards extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_16_GetDefoultBoards() {
    }



    @BeforeClass
    public void setUp() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        list.add(73);
        list.add(73);
        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "GetDefaultBoards", I));
        iqsoft304_socketMessage_getDefaultBoards_response = (Iqsoft304_SocketMessage_GetDefaultBoards_Response)
                mapReceivedMessage(Iqsoft304_SocketMessage_GetDefaultBoards_Response.class, String.valueOf(I));
        I++;
    }

    @Test(description = "GetDefaultBoard", priority = 15)
    @Feature("GetDefaultBoard")
    @Story("DefaultBoard_Message")
    @Description("Verify Socket GetDefaultBoard Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageDefaultBoard_ValidatePositiveResponse(){

        Assert.assertEquals(iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseCode());
        Assert.assertNotEquals(iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseObject().size(),0,
                "DefaultBoardsSize: " + iqsoft304_socketMessage_getDefaultBoards_response.getR().getResponseObject().size());

    }





}
