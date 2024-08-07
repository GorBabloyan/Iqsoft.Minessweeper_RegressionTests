package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = { "SocketMessages" },dependsOnGroups = {"SocketConnection"})

public class Iqsoft_TestClass_12_Authorization extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_12_Authorization() {
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        client.sendMessage(sendSocketMessageWithoutArgument("basehub", "Authorized", I));
        iqsoft300_socketMessage_authorized_response = (Iqsoft300_SocketMessage_Authorized_Response)
                mapReceivedMessage(Iqsoft300_SocketMessage_Authorized_Response.class, String.valueOf(I));

        I++;
    }


    @Test(description = "Authorization", priority = 11)
    @Feature("Authorization")
    @Story("Authorized_Message")
    @Description("Verify Socket Authorized Message")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageAuthorized_ValidatePositiveResponse() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals( iqsoft300_socketMessage_authorized_response.getR().isAuthorized(),true,
                "Authorized: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());

        softAssert.assertNotEquals( iqsoft300_socketMessage_authorized_response.getR().getCurrencyId(),null,
                "CurrencyId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        softAssert.assertNotEquals(iqsoft300_socketMessage_authorized_response.getR().getCurrencyRate(),0,
                "CurrencyRate: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        softAssert.assertNotEquals(iqsoft300_socketMessage_authorized_response.getR().getClientId(),0,
                "ClientId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());

        softAssert.assertAll();
    }


}
