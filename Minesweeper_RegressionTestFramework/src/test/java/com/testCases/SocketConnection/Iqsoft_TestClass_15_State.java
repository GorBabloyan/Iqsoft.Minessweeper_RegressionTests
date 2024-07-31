package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft302_SocketMessage_Balance_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft303_SocketMessage_State_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class Iqsoft_TestClass_15_State extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_15_State() {
    }

    public static HttpResponse<String> negotiateApiSportsBookResponse;
    int statusCode;
    String jsonObjectBody;

    @BeforeClass
    public void setUp() {
//        socketConnectionLoggedInVirtual();
    }


    @Test(description = "SocketConnection", priority = 14)
    @Feature("State")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket State Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageState_ValidatePositiveResponse() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        list.add(73);
        list.add(73);
        client.sendMessage(sendSocketMessageState("websitehub", "State", I, list));
        iqsoft303_socketMessage_state_response = (Iqsoft303_SocketMessage_State_Response)
                mapReceivedMessage(Iqsoft303_SocketMessage_State_Response.class, String.valueOf(I));
        I++;

        Assert.assertEquals(0, iqsoft303_socketMessage_state_response.getR().getResponseCode(),
                "ResponseCode: " + iqsoft303_socketMessage_state_response.getR().getResponseCode());

    }







}
