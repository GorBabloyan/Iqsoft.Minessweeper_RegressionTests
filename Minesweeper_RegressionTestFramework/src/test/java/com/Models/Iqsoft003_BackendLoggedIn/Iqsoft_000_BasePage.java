package com.Models.Iqsoft003_BackendLoggedIn;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request.*;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pageObjects.Iqsoft_001_BasePage;
import com.pageObjects.Iqsoft_Page_01_Header;
import com.pageObjects.Iqsoft_Page_02_Lobby;
import com.pageObjects.Iqsoft_Page_03_PlayGame;
import com.utilities.DriverFactory;
import com.utilities.ReadConfig;
import io.qameta.allure.Allure;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Iqsoft_000_BasePage  extends DriverFactory {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getBaseURL();
    public String webSitWebApiURL = readConfig.getWebSitWebApi();
    public String isHeadless = readConfig.isHeadless();
    public String browser = readConfig.getBrowser();
    public String loginData = readConfig.getData();
    public int productId = readConfig.getProductId();
    public int DimensionHeight = readConfig.getDimensionHeight();
    public int DimensionWidth = readConfig.getDimensionWidth();

    public static String loginPath = "LoginClient";
    public static String getProductUrlPath = "GetProductUrl";
    public static String token;
    public static int clientId;
    public static int partnerId;
    public static String languageId;

    public static String gameUrl;

    //region <Page Class Instances  >

    public static Iqsoft_Page_01_Header iqsoftPage01;
    public static Iqsoft_Page_02_Lobby iqsoftPage02;
    public static Iqsoft_Page_03_PlayGame iqsoftPage03;


    public static Iqsoft102_SportWebSocketClient client;

    public static Iqsoft200_SocketMessage_WithoutArguments_Request iqsoft200_socketMessageWithoutArguments_request;
    public static Iqsoft201_SocketMessage_State_Request iqsoft201_socketMessage_state_request;
    public static Iqsoft202_SocketMessage_CreateBoard_Request iqsoft202_socketMessage_createBoard_request;
    public static Iqsoft203_SocketMessage_Bet_Request iqsoft203_socketMessage_bet_request;
    public static Iqsoft204_SocketMessage_Cashout_Request iqsoft204_socketMessage_cashout_request;
    public static Iqsoft205_SocketMessage_TicketsHistory_Request iqsoft205_socketMessage_ticketsHistory_request;

    public static Iqsoft300_SocketMessage_Authorized_Response iqsoft300_socketMessage_authorized_response;
    public static Iqsoft301_SocketMessage_Units_Response iqsoft301_socketMessage_units_response;
    public static Iqsoft302_SocketMessage_Balance_Response iqsoft302_socketMessage_balance_response;

    public static Iqsoft303_SocketMessage_State_Response iqsoft303_socketMessage_state_response;
    public static Iqsoft304_SocketMessage_GetDefaultBoards_Response iqsoft304_socketMessage_getDefaultBoards_response;
    public static Iqsoft305_SocketMessage_CreateBoard_Response iqsoft305_socketMessage_createBoard_response;
    public static Iqsoft306_SocketMessage_Bet_Response iqsoft306_socketMessage_bet_response;
    public static Iqsoft307_SocketMessage_CashOut_Response iqsoft307_socketMessage_cashOut_response;

    public static Iqsoft308_SocketMessage_TicketsHistory_Response iqsoft308_socketMessage_ticketsHistory_response;
    //endregion



    public void loginRequest() {
        HttpResponse<String> response;
        int statusCode;
        String urlLoginApi = webSitWebApiURL + loginPath;
        String RequestBody = "{\"Data\":\"" + loginData + "\"}";

        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlLoginApi)
                .header("content-type", "application/json")
                .header("Origin", baseURL)
                .body(RequestBody)
                .asString();
        Unirest.shutDown();

        statusCode = response.getStatus();

        if (statusCode == 200) {

            String responseString = response.getBody();
            Unirest.shutDown();
            JSONObject responseJson = new JSONObject(responseString);
            int responseCode = Integer.parseInt(String.valueOf(responseJson.get("ResponseCode")));

            if (responseCode == 0) {
                clientId = Integer.parseInt(String.valueOf(responseJson.get("Id")));
                partnerId = Integer.parseInt(String.valueOf(responseJson.get("PartnerId")));
                languageId = String.valueOf(responseJson.get("LanguageId"));
                token = String.valueOf(responseJson.get("Token"));

                Allure.addAttachment("LoginAPIRequest:  Url  " + urlLoginApi + "        RequestBody", RequestBody);
                Allure.addAttachment("LoginAPIResponse:   ", responseString);


                Iqsoft_001_BasePage.logger.info("ClientId: " + clientId +
                        "   token: " + token + "  partnerId: " + partnerId + "  languageId: " + languageId);

            } else {
                throw new SkipException("loginRequest Response failed");
            }
        } else {
            throw new SkipException("loginRequest Request failed");
        }
    }

    public static String sessionToken = null;

    public void getProductUrl() {
        HttpResponse<String> response;
        int statusCode;
        String urlGetProductUrlApi = webSitWebApiURL + getProductUrlPath;
        String RequestBody = "{\"IsForMobile\": false, \"LanguageId\": \"" + languageId + "\", \"PartnerId\":" + partnerId + ",\"ProductId\": " + productId +
                ",\"TimeZone\": 4, " + "\"Token\": \"" + token + "\",\"ClientId\":" + clientId + ", \"IsForDemo\": false, \"IsAgent\": false}";

        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlGetProductUrlApi)
                .header("Content-Type", "application/json")
                .header("Origin", baseURL)
                .body(RequestBody)
                .asString();

        statusCode = response.getStatus();
        if (statusCode == 200) {

            String responseString = response.getBody();
            Unirest.shutDown();
            JSONObject responseJson = new JSONObject(responseString);
            int responseCode = Integer.parseInt(String.valueOf(responseJson.get("ResponseCode")));
            if (responseCode == 0) {
                gameUrl = String.valueOf(responseJson.get("ResponseObject"));
                Iqsoft_001_BasePage.logger.info("GameUrl: " + gameUrl);
                sessionToken = getParameterFromURL(gameUrl, "token");
                Iqsoft_001_BasePage.logger.info("GameToken: " + sessionToken);

                Allure.addAttachment("GetProductUrlAPIRequest:  Url  " + urlGetProductUrlApi + "        RequestBody", RequestBody);
                Allure.addAttachment("GetProductUrlAPIResponse:   ", responseString);
                Allure.addAttachment("SessionToken:   ", sessionToken);

            } else {
                throw new SkipException("GetProductUrl Response failed");
            }

        } else {
            throw new SkipException("GetProductUrl Request failed");

        }
    }

    public static String getParameterFromURL(String url, String parameterName) {
        try {
            URL urlObject = new URL(url);
            String query = urlObject.getQuery();
            Map<String, String> params = new HashMap<>();
            for (String param : query.split("&")) {
                String[] keyValue = param.split("=");
                params.put(URLDecoder.decode(keyValue[0], "UTF-8"), URLDecoder.decode(keyValue[1], "UTF-8"));
//                params.put((keyValue[0]), keyValue[1]);
            }
            return params.get(parameterName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initElements() {
        try {
            iqsoftPage01 = PageFactory.initElements(driver, Iqsoft_Page_01_Header.class);
            iqsoftPage02 = PageFactory.initElements(driver, Iqsoft_Page_02_Lobby.class);
            iqsoftPage03 = PageFactory.initElements(driver, Iqsoft_Page_03_PlayGame.class);

            iqsoft200_socketMessageWithoutArguments_request = new Iqsoft200_SocketMessage_WithoutArguments_Request();
            iqsoft201_socketMessage_state_request = new Iqsoft201_SocketMessage_State_Request();
            iqsoft202_socketMessage_createBoard_request = new Iqsoft202_SocketMessage_CreateBoard_Request();
            iqsoft203_socketMessage_bet_request = new Iqsoft203_SocketMessage_Bet_Request();
            iqsoft204_socketMessage_cashout_request = new Iqsoft204_SocketMessage_Cashout_Request();


        } catch (Exception e) {

            Iqsoft_001_BasePage.logger.error("initElements() has an Exception: " + e);
        }
    }

    public static URI serverUri;
    public static boolean isSocketConnectionSuccess = false;
    public static long responseTime;
    public static long start;
    public static long end;

    public void socketConnectionLoggedInVirtual() {

        try {

//            serverUri = new URI( "wss://virtualgameswebsitewebapi.craftbet.com/api/VirtualGamesWebSiteWebApi/signalr/hubs" +
//                    "/connect?transport=webSockets&clientProtocol=1.5&IntegrationToken=" +
//                    sessionToken +
//                    "&PartnerId=1&LanguageId=en&TimeZone=4&EnvironmentId=1&GameId=110&connectionToken=" +
//                    negotiateHttpApiLoggedInVirtual()+encodeData + "&tid=0");
            serverUri = new URI(webSocketUrl);
            client = new Iqsoft102_SportWebSocketClient(serverUri);
            long start = System.currentTimeMillis();

//            client.connect();
            client.connectBlocking();

            long end = System.currentTimeMillis();
            responseTime = end - start;

            // Wait for a moment (optional) before sending messages
            Thread.sleep(1000);

//             Send messages to the WebSocket server

            // Keep the application running to listen for messages
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    client.closeBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));


        } catch (Exception e) {
            Iqsoft_001_BasePage.logger.error("socketConnectionSportsBook() call has an exception: " + e);
        }
    }

    public static String receivedMessage;
    public static int I = 0;

    public static String sendSocketMessageWithoutArgument(String H, String M, int I) {
        String message;
        iqsoft200_socketMessageWithoutArguments_request = new Iqsoft200_SocketMessage_WithoutArguments_Request();
        iqsoft200_socketMessageWithoutArguments_request.setH(H);
        iqsoft200_socketMessageWithoutArguments_request.setM(M);
        iqsoft200_socketMessageWithoutArguments_request.setI(I);


        Gson gson = new Gson();

        message = gson.toJson(iqsoft200_socketMessageWithoutArguments_request);

        return message;
    }

    public static String sendSocketMessageState(String H, String M, int I, List<Integer> A) {
        String message;
        iqsoft201_socketMessage_state_request = new Iqsoft201_SocketMessage_State_Request();
        iqsoft201_socketMessage_state_request.setH(H);
        iqsoft201_socketMessage_state_request.setM(M);
        iqsoft201_socketMessage_state_request.setI(I);
        iqsoft201_socketMessage_state_request.setA(A);

        Gson gson = new Gson();

        message = gson.toJson(iqsoft201_socketMessage_state_request);

        return message;
    }

    public static String sendSocketMessageCreateBoard(String H, String M, int I, int width, int height, int minesCount,
                                                      int betType, int gameId, double Amount) {
        String message;
        iqsoft202_socketMessage_createBoard_request = new Iqsoft202_SocketMessage_CreateBoard_Request();
        iqsoft202_socketMessage_createBoard_request.setH(H);
        iqsoft202_socketMessage_createBoard_request.setM(M);
        iqsoft202_socketMessage_createBoard_request.setI(I);

        Iqsoft202_SocketMessage_CreateBoard_Request.A.BoardInput boardInput = new Iqsoft202_SocketMessage_CreateBoard_Request.A.BoardInput();
        boardInput.setWidth(width);
        boardInput.setHeight(height);
        boardInput.setMinesCount(minesCount);

        Iqsoft202_SocketMessage_CreateBoard_Request.A.BetInput betInput = new Iqsoft202_SocketMessage_CreateBoard_Request.A.BetInput();
        betInput.setBetType(betType);
        betInput.setClientId(iqsoft300_socketMessage_authorized_response.getR().getClientId());
        betInput.setGameId(gameId);
        betInput.setAmount(Amount);
        betInput.setEvents(null);

        Iqsoft202_SocketMessage_CreateBoard_Request.A a = new Iqsoft202_SocketMessage_CreateBoard_Request.A();
        a.setBoardInput(boardInput);
        a.setBetInput(betInput);

        List<Iqsoft202_SocketMessage_CreateBoard_Request.A> aList = new ArrayList<>();
        aList.add(a);

        iqsoft202_socketMessage_createBoard_request.setA(aList);

        Gson gson = new Gson();

        message = gson.toJson(iqsoft202_socketMessage_createBoard_request);

        return message;
    }
    public static String sendSocketMessageBet(String H, String M, int I, int row, int column) {
        String message;
        iqsoft203_socketMessage_bet_request = new Iqsoft203_SocketMessage_Bet_Request();
        iqsoft203_socketMessage_bet_request.setH(H);
        iqsoft203_socketMessage_bet_request.setM(M);
        iqsoft203_socketMessage_bet_request.setI(I);


        Iqsoft203_SocketMessage_Bet_Request.A a = new Iqsoft203_SocketMessage_Bet_Request.A();
        a.setColumn(column);
        a.setRow(row);
        List<Iqsoft203_SocketMessage_Bet_Request.A> aList = new ArrayList<>();
        aList.add(a);

        iqsoft203_socketMessage_bet_request.setA(aList);

        Gson gson = new Gson();

        message = gson.toJson(iqsoft203_socketMessage_bet_request);

        return message;
    }

    public static String sendSocketMessageCashout(String H, String M, int I) {
        String message = null;
        iqsoft204_socketMessage_cashout_request = new Iqsoft204_SocketMessage_Cashout_Request();
        iqsoft204_socketMessage_cashout_request.setH(H);
        iqsoft204_socketMessage_cashout_request.setM(M);
        iqsoft204_socketMessage_cashout_request.setI(I);


        Iqsoft204_SocketMessage_Cashout_Request.A aInstance = new Iqsoft204_SocketMessage_Cashout_Request.A();

        // Create a list of A and add the instance to the list
        List<Iqsoft204_SocketMessage_Cashout_Request.A> aList = new ArrayList<>();
        aList.add(aInstance);
        iqsoft204_socketMessage_cashout_request.setA(aList);
        Gson gson = new Gson();

        message = gson.toJson(iqsoft204_socketMessage_cashout_request);
//        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

//        try {
//            message = objectMapper.writeValueAsString(iqsoft204_socketMessage_cashout_request);
////            System.out.println(message); // Output will be {"A":[{}]}
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return message;
    }

    public static String sendSocketMessageTicketHistory(String H, String M, int I) {
        //  {"H":"playerhub","M":"MinesweeperTicketsHistory","A":[{"FromDate":"2024-07-30T14:46:49.157Z","ToDate":"2024-07-31T19:46:49.157Z","PageNumber":1,"ItemsPerPage":13}],"I":9}


        String message = null;
        iqsoft205_socketMessage_ticketsHistory_request = new Iqsoft205_SocketMessage_TicketsHistory_Request();
        iqsoft205_socketMessage_ticketsHistory_request.setH(H);
        iqsoft205_socketMessage_ticketsHistory_request.setM(M);
        iqsoft205_socketMessage_ticketsHistory_request.setI(I);


        Iqsoft205_SocketMessage_TicketsHistory_Request.A a = new Iqsoft205_SocketMessage_TicketsHistory_Request.A();

        a.setItemsPerPage(2);
        a.setPageNumber(1);
        a.setFromDate(dateTimeNowMinusOneDay());
        a.setToDate(dateTimeNow());


        List<Iqsoft205_SocketMessage_TicketsHistory_Request.A> aList = new ArrayList<>();
        aList.add(a);

        iqsoft205_socketMessage_ticketsHistory_request.setA(aList);


        Gson gson = new Gson();

        message = gson.toJson(iqsoft205_socketMessage_ticketsHistory_request);

        return message;
    }

    public static Object mapReceivedMessage(Class myClass, String I) throws InterruptedException {
        Object mapObj;
        try {
            receivedMessage = client.waitForMessageWithInvocationId(I);
//            System.out.println("receivedMessage:  "+receivedMessage);
            Allure.addAttachment("Received message: ResponseTime = " + responseTime + " ms ", receivedMessage);
            Iqsoft_001_BasePage.logger.info("Received message: " + receivedMessage);

            ObjectMapper objectMapper = new ObjectMapper();

            mapObj = objectMapper.readValue(receivedMessage, myClass);
        } catch (JsonProcessingException e) {
            Iqsoft_001_BasePage.logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     " + e);
            throw new RuntimeException(e);
        }
        return mapObj;
    }

    public static String dateTimeNow() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");  //2024-05-29T15:30:45.123
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //2024-06-09 12:39

        // Format the current date and time
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }

    public static String dateTimeNowMinusOneDay() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Subtract one day from the current date and time
        LocalDateTime dateTimeMinusOneDay = currentDateTime.minusDays(1);

        // Define the desired date-time format
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");  //2024-05-29T15:30:45.123
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //2024-06-09 12:39


        // Format the date and time minus one day
        String formattedDateTime = dateTimeMinusOneDay.format(formatter);

        return formattedDateTime;
    }

}
