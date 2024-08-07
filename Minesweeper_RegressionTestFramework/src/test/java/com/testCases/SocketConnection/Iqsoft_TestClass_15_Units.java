package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = { "SocketMessages" },dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_15_Units extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_15_Units() {
    }

    @BeforeClass
    public void MessageUnits() throws InterruptedException {

        client.sendMessage(sendSocketMessageWithoutArgument("websitehub", "Units", I));
        iqsoft301_socketMessage_units_response = (Iqsoft301_SocketMessage_Units_Response)
                mapReceivedMessage(Iqsoft301_SocketMessage_Units_Response.class, String.valueOf(I));
        I++;
    }


    @Test(description = "Units",priority = 12)
    @Feature("Units")
    @Story("Units_Message")
    @Description("Verify Socket Units Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageUnits_ValidatePositiveResponse() {

        Assert.assertEquals(iqsoft301_socketMessage_units_response.getR().getResponseCode(),0,
                "ResponseCode: " + iqsoft301_socketMessage_units_response.getR().getResponseCode());
        Assert.assertNotEquals( iqsoft301_socketMessage_units_response.getR().getResponseObject().size(),0,
                "ResponseObject size: " + iqsoft301_socketMessage_units_response.getR().getResponseObject().size());
    }







}
