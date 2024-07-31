package com.testCases;

import com.Models.Iqsoft003_BackendLoggedIn.Iqsoft102_SportWebSocketClient;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request.*;
import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pageObjects.Iqsoft_Page_01_Header;
import com.pageObjects.Iqsoft_001_BasePage;
import com.pageObjects.Iqsoft_Page_02_Lobby;
import com.pageObjects.Iqsoft_Page_03_PlayGame;
import io.qameta.allure.Allure;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.utilities.DriverFactory;
import com.utilities.ReadConfig;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Iqsoft_001_BaseTest extends DriverFactory {

    Iqsoft_001_BasePage iqsoft001BasePage = new Iqsoft_001_BasePage();
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


    public static Iqsoft300_SocketMessage_Authorized_Response iqsoft300_socketMessage_authorized_response;
    public static Iqsoft301_SocketMessage_Units_Response iqsoft301_socketMessage_units_response;
    public static Iqsoft302_SocketMessage_Balance_Response iqsoft302_socketMessage_balance_response;

    public static Iqsoft303_SocketMessage_State_Response iqsoft303_socketMessage_state_response;
    public static Iqsoft304_SocketMessage_GetDefaultBoards_Response iqsoft304_socketMessage_getDefaultBoards_response;
    public static Iqsoft305_SocketMessage_CreateBoard_Response iqsoft305_socketMessage_createBoard_response;
    public static Iqsoft306_SocketMessage_Bet_Response iqsoft306_socketMessage_bet_response;
    public static Iqsoft307_SocketMessage_CashOut_Response iqsoft307_socketMessage_cashOut_response;
    //endregion


    public Iqsoft_001_BaseTest() {
    }


    @BeforeSuite
    public void setupBeforeAll() throws InterruptedException {
        Iqsoft_001_BasePage.logger = Logger.getLogger("craftBet");
        PropertyConfigurator.configure("Log4j.properties");
        Iqsoft_001_BasePage.logger.info("<<<<<<<<<<<<<<<<<<<<<<<<< Test Suite Started  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
        Iqsoft_001_BasePage.logger.info("");

        String folderPathAllure = "./allure-results";
        String folderPathLogs = "./log/testlogs.log";
        File folderAllure = new File(folderPathAllure);
        if (folderAllure.exists()) {
            Iqsoft_001_BasePage.deleteFolder(folderAllure);
        }
        File folderLogs = new File(folderPathLogs);
        if (folderLogs.exists()) {
            Iqsoft_001_BasePage.deleteFolder(folderLogs);
        }

        loginRequest();
        getProductUrl();


        try {
            super.initDriver(gameUrl, browser, isHeadless);
//            DevTools devTools = ((HasDevTools) driver).getDevTools();
//            devTools.createSession();

            // Clear browser cache
//            Iqsoft_001_BasePage.clearBrowserCache(devTools);

            initElements();


            Dimension d = new Dimension(DimensionWidth, DimensionHeight);  //
            if (DimensionWidth > 1250 && DimensionHeight > 750) {

                driver.manage().window().setSize(d);
                Iqsoft_001_BasePage.logger.info("Window size is: " + DimensionWidth + " x " + DimensionHeight);
            }

        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(gameUrl, browser, isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        iqsoftPage01 = PageFactory.initElements(driver, Iqsoft_Page_01_Header.class);

    }


    @AfterSuite
    public void Finish() {
        if (driver != null) {
            driver.quit();
        }
        try {
            client.closeBlocking();
            client.close();
        } catch (InterruptedException e) {

        }
        Iqsoft_001_BasePage.logger.info("Browser closed");


        Iqsoft_001_BasePage.logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Test Suite finished  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
    }


    public void loginRequest() {
        HttpResponse<String> response;
        int statusCode;
        String urlLoginApi = webSitWebApiURL + loginPath;


        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlLoginApi)
                .header("content-type", "application/json")
                .header("Origin", baseURL)
                .body("{\"Data\":\"" + loginData + "\"}")
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
        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlGetProductUrlApi)
                .header("Content-Type", "application/json")
                .header("Origin", baseURL)
                .body("{\"IsForMobile\": false, \"LanguageId\": \"" + languageId + "\", \"PartnerId\":" + partnerId + ",\"ProductId\": " + productId +
                        ",\"TimeZone\": 4, " + "\"Token\": \"" + token + "\",\"ClientId\":" + clientId + ", \"IsForDemo\": false, \"IsAgent\": false}")
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

        iqsoft200_socketMessageWithoutArguments_request.setH(H);
        iqsoft200_socketMessageWithoutArguments_request.setM(M);
        iqsoft200_socketMessageWithoutArguments_request.setI(I);

        Gson gson = new Gson();

        message = gson.toJson(iqsoft200_socketMessageWithoutArguments_request);

        return message;
    }

    public static String sendSocketMessageState(String H, String M, int I, List<Integer> A) {
        String message;

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

        iqsoft204_socketMessage_cashout_request.setH(H);
        iqsoft204_socketMessage_cashout_request.setM(M);
        iqsoft204_socketMessage_cashout_request.setI(I);


        Iqsoft204_SocketMessage_Cashout_Request.A aInstance = new Iqsoft204_SocketMessage_Cashout_Request.A();

        // Create a list of A and add the instance to the list
        List<Iqsoft204_SocketMessage_Cashout_Request.A> aList = new ArrayList<>();
        aList.add(aInstance);
        iqsoft204_socketMessage_cashout_request.setA(aList);

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        try {
            message = objectMapper.writeValueAsString(iqsoft204_socketMessage_cashout_request);
//            System.out.println(message); // Output will be {"A":[{}]}
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Gson gson = new Gson();
//
//        message = gson.toJson(iqsoft204_socketMessage_cashout_request);

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


    static String encodeData = "";
    //region < negotiateApiSportsBook & SocketConnection LoggedIn>
//    public String negotiateHttpApiLoggedInVirtual() {
//        String connectionToken = null;
//        long responseTime;
//        HttpResponse<String> response;
//        encodeData =  URLEncoder.encode("[{\"name\":\"basehub\"},{\"name\":\"websitehub\"}]", StandardCharsets.UTF_8);
//        encodeData = "&connectionData=" + encodeData;
//        try {
//            String url = "https://virtualgameswebsitewebapi.craftbet.com/api/VirtualGamesWebSiteWebApi/signalr/hubs/negotiate?clientProtocol=1.5" +
//                    "&IntegrationToken=" + sessionToken + "&PartnerId=" + partnerId +
//                    "&LanguageId=" + languageId + "&TimeZone=4&EnvironmentId=1&GameId=" + "110"+encodeData + "&_=1721965060330";
//
//            System.out.println("Negotiation URL: " + url);
//
//            long start = System.currentTimeMillis();
//
//            Unirest.config().reset();
//            Unirest.config().connectTimeout(60000);
//            Unirest.config().socketTimeout(60000);
//            response = Unirest.get(url)
//                    .header("Origin","https://virtualgameswebsite.craftbet.com")
//                    .asString();
//            Unirest.shutDown();
//
//
//            long end = System.currentTimeMillis();
//            responseTime = end - start;
//            Allure.addAttachment("negotiateHttpApiLoggedInSportsBook:  Url: " + url + "    ResponseTime  " + responseTime + "ms", "");
//            Allure.addAttachment("negotiateHttpApiLoggedInSportsBook:  ResponseBody: ", "application/json", response.getBody());
//
//            int statusCode = response.getStatus();
//            if (statusCode == 200) {
//
//                String responseString = response.getBody();
//                System.out.println("Negotiation ResponseBody: " + url);
//                Unirest.shutDown();
//
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                    iqsoft101_responseNegotiateAPI = objectMapper.readValue(responseString, Iqsoft101_Response_NegotiateAPI.class);
//                    connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
//
////                    JSONObject obh = new JSONObject(responseString);
////                    connectionToken = obh.getString("ConnectionToken");
//                    System.out.println("connectionToken 1 :" + connectionToken);
////                    connectionToken = connectionToken.replace("+", "%2B");
//                    connectionToken = URLEncoder.encode(connectionToken, StandardCharsets.UTF_8);
//                    System.out.println("connectionToken 2 :" + connectionToken);
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                Iqsoft_001_BasePage.logger.fatal("negotiateHttpApiLoggedInSportsBook() has status code = " + statusCode);
//            }
//
//        } catch (Exception e1) {
//            try {
//                String url = "https://virtualgameswebsitewebapi.craftbet.com/api/VirtualGamesWebSiteWebApi/signalr/hubs/negotiate?clientProtocol=1.5" +
//                        "&IntegrationToken=" + sessionToken + "&PartnerId=" + partnerId +
//                        "&LanguageId=" + languageId + "&TimeZone=4&EnvironmentId=1&GameId=" + "110";
//
//
//                long start = System.currentTimeMillis();
//
//                Unirest.config().reset();
//                Unirest.config().connectTimeout(60000);
//                Unirest.config().socketTimeout(60000);
//                response = Unirest.get(url)
//                        .asString();
//                Unirest.shutDown();
//
//
//                long end = System.currentTimeMillis();
//                responseTime = end - start;
//                Allure.addAttachment("negotiateHttpApiLoggedInSportsBook:  Url: " + url + "    ResponseTime  " + responseTime + "ms", "");
//                Allure.addAttachment("negotiateHttpApiLoggedInSportsBook:  ResponseBody: ", "application/json", response.getBody());
//
//                int statusCode = response.getStatus();
//                if (statusCode == 200) {
//
//                    String responseString = response.getBody();
//                    Unirest.shutDown();
//
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    try {
//                        iqsoft101_responseNegotiateAPI = objectMapper.readValue(responseString, Iqsoft101_Response_NegotiateAPI.class);
//                        connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
//
////                    JSONObject obh = new JSONObject(responseString);
////                    connectionToken = obh.getString("ConnectionToken");
//                        System.out.println("connectionToken 1 :" + connectionToken);
////                    connectionToken = connectionToken.replace("+", "%2B");
//                        connectionToken = URLEncoder.encode(connectionToken, StandardCharsets.UTF_8);
//                        System.out.println("connectionToken 2 :" + connectionToken);
//
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    Iqsoft_001_BasePage.logger.fatal("negotiateHttpApiLoggedInSportsBook() has status code = " + statusCode);
//                }
//
//            } catch (Exception e) {
//                Iqsoft_001_BasePage.logger.error("negotiateHttpApiLoggedInSportsBook() call has exception: " + e);
//            }
//        }
//        return connectionToken;
//    }


}
