package com.testCases.SocketConnection;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft300_SocketMessage_Authorized_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft301_SocketMessage_Units_Response;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft302_SocketMessage_Balance_Response;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.*;
import kong.unirest.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Iqsoft_TestClass_12_Authorization extends Iqsoft_001_BaseTest {

    public Iqsoft_TestClass_12_Authorization() {
    }

    public static HttpResponse<String> negotiateApiSportsBookResponse;
    int statusCode;
    String jsonObjectBody;

    @BeforeClass
    public void setUp() {
        driver.quit();
        socketConnectionLoggedInVirtual();
    }


    @Test(description = "SocketConnection")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void SocketConnectionSportsBook_ValidatePositiveResponse()  {
        Assert.assertEquals(true, isSocketConnectionSuccess, "SocketConnectionSuccess: " + isSocketConnectionSuccess);
    }



    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageAuthorized_ValidatePositiveResponse() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        client.sendMessage(sendSocketMessageWithoutArgument("basehub", "Authorized", I));
        iqsoft300_socketMessage_authorized_response = (Iqsoft300_SocketMessage_Authorized_Response)
                mapReceivedMessage(Iqsoft300_SocketMessage_Authorized_Response.class, String.valueOf(I));

        I++;

        softAssert.assertEquals(true, iqsoft300_socketMessage_authorized_response.getR().isAuthorized(),
                "Authorized: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        softAssert.assertEquals(null, iqsoft300_socketMessage_authorized_response.getR().getCurrencyId(),
                "CurrencyId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        softAssert.assertEquals(0, iqsoft300_socketMessage_authorized_response.getR().getCurrencyRate(),
                "CurrencyRate: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        softAssert.assertEquals(0, iqsoft300_socketMessage_authorized_response.getR().getClientId(),
                "ClientId: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
    }

    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
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


    @Test(description = "SocketConnection", dependsOnMethods = "SocketConnectionSportsBook_ValidatePositiveResponse")
    @Feature("SocketConnection")
    @Story("002_RequestSucceeded_SocketConnectionLoggedIn")
    @Description("Verify Socket Success connection")
    @Severity(SeverityLevel.BLOCKER)
    public void MessageBalance_ValidatePositiveResponse() throws InterruptedException {

        client.sendMessage(sendSocketMessageWithoutArgument("playerhub", "Balance", I));
        iqsoft302_socketMessage_balance_response = (Iqsoft302_SocketMessage_Balance_Response)
                mapReceivedMessage(Iqsoft302_SocketMessage_Balance_Response.class, String.valueOf(I));
        I++;

        Assert.assertEquals(0, iqsoft302_socketMessage_balance_response.getR().getResponseCode(),
                "ResponseCode: " + iqsoft300_socketMessage_authorized_response.getR().isAuthorized());
        if (iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance()>=0){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Balance: " + iqsoft302_socketMessage_balance_response.getR().getResponseObject().getBalance());
        }
    }









}
