package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft0300_SocketMessage_First_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Balance_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Iqsoft_TestClass_11_Negotiate extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_11_Negotiate() {
    }

    public static HttpResponse<String> negotiateApiSportsBookResponse;
    int statusCode;
    String jsonObjectBody;

    @BeforeClass
    public void setUp() {
        socketConnectionLoggedInVirtual();

    }


    @Test(description = "SocketConnection")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void SocketConnectionSportsBook_ValidatePositiveResponse() throws InterruptedException {

//        iqsoft0300_socketMessage_first_response = (Iqsoft0300_SocketMessage_First_Response)
//                mapFirstReceivedMessage(Iqsoft0300_SocketMessage_First_Response.class);
        Assert.assertEquals(true, isSocketConnectionSuccess, "SocketConnectionSuccess: " + isSocketConnectionSuccess);
//        Assert.assertEquals(iqsoft0300_socketMessage_first_response.getS(), 1, "FirstMessage: " );

    }

    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageAuthorized_ValidatePositiveResponse() throws InterruptedException {

            client.sendMessage(sendSocketMessageWithoutArgument("basehub", "Authorized", I));
            iqsoft300_socketMessage_authorized_response = (Iqsoft300_SocketMessage_Authorized_Response)
                    mapReceivedMessage(Iqsoft300_SocketMessage_Authorized_Response.class, String.valueOf(I));

        I++;

//        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "Balance", I));
//        iqsoft301_socketMessage_balance_response = (Iqsoft301_SocketMessage_Balance_Response)
//                mapReceivedMessage(Iqsoft301_SocketMessage_Balance_Response.class, String.valueOf(I));
//
//        I++;

        Assert.assertEquals(true, iqsoft300_socketMessage_authorized_response.getR().isAuthorized(),
                "Autorized: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());

    }


}
