package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Iqsoft_TestClass_15_Units extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_15_Units() {
    }

    @BeforeClass
    public void setUp() {
//        socketConnectionLoggedInVirtual();
    }


    @Test(description = "SocketConnection",priority = 12)
    @Feature("SocketConnection")
    @Story("Units_Message")
    @Description("Verify Socket Units Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageUnits_ValidatePositiveResponse() throws InterruptedException {

        client.sendMessage(sendSocketMessageWithoutArgument("websitehub", "Units", I));
        iqsoft301_socketMessage_units_response = (Iqsoft301_SocketMessage_Units_Response)
                mapReceivedMessage(Iqsoft301_SocketMessage_Units_Response.class, String.valueOf(I));
        I++;

        Assert.assertEquals(0, iqsoft301_socketMessage_units_response.getR().getResponseCode(),
                "ResponseCode: " + iqsoft301_socketMessage_units_response.getR().getResponseCode());
        Assert.assertNotEquals(null, iqsoft301_socketMessage_units_response.getR(),
                "Units R: " + iqsoft301_socketMessage_units_response.getR());
    }







}
