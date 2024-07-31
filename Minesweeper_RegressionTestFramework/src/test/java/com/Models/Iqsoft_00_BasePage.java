//package com.Models;
//
//import com.Models.Iqsoft001_Frontend.Iqsoft001_Response_ConfigJsonAPI;
//import com.Models.Iqsoft001_Frontend.Iqsoft002_Response_MenuJsonAPI;
//import com.Models.Iqsoft001_Frontend.Iqsoft003_Response_TranslationEnJsonAPI;
//import com.Models.Iqsoft001_Frontend.Iqsoft004_Response_FontsJsonAPI;
//import com.Models.Iqsoft002_BackendLoggedOut.*;
//import com.Models.Iqsoft003_BackendLoggedIn.Iqsoft101_Response_NegotiateAPI;
//import com.Models.Iqsoft003_BackendLoggedIn.Iqsoft102_SportWebSocketClient;
//import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request.*;
//import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.*;
//import com.Utilities.ReadConfig;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import io.qameta.allure.Allure;
//import kong.unirest.HttpResponse;
//import kong.unirest.Unirest;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.Logger;
//
//import java.io.File;
//import java.net.URI;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//public class Iqsoft_00_BasePage {
//    public Iqsoft_00_BasePage() {
//    }
//
//
//    public static Logger logger ;
//    public static int jsVersion;
//    public static long responseTime;
//    public static long start;
//    public static long end;
//    public static String connectionId;
//    public static String connectionToken;
//    public static URI serverUri;
//    public static boolean isSocketConnectionSuccess = false;
//
//    public static List<Long> unblockedMatchIds = new ArrayList<>();
//
//    public static int betTypeSingle;
//    public static int betTypeMultiple;
//    public static int betTypeSystem;
//    public static int betTypeChain;
//    public static int betTypeTeaser;
//
//    public static int betAcceptanceModeNone;
//    public static int betAcceptanceModeHigherOdds;
//    public static int betAcceptanceModeAnyOdds;
//    public static List<Long> favoriteMatchIds =new ArrayList<>();
//
//    //region <Request and Response Variables Integration>
//
//
//
//
//    public static Iqsoft101_Response_NegotiateAPI iqsoft101_responseNegotiateAPI = new Iqsoft101_Response_NegotiateAPI();
//    public static Iqsoft102_SportWebSocketClient client;
//
//
//    public static Iqsoft200_SocketMessage_WithoutArguments_Request iqsoft200_socketMessageWithoutArguments_request;
//    public static Iqsoft203_SocketMessage_Bet_Request iqsoft203_socketMessage_bet_request = new Iqsoft203_SocketMessage_Bet_Request();
//    public static Iqsoft204_SocketMessage_OpenBetsCount_Request iqsoft204_socketMessage_openBetsCount_request = new Iqsoft204_SocketMessage_OpenBetsCount_Request();
//    public static Iqsoft205_SocketMessage_OpenBets_Request iqsoft205_socketMessage_openBets_request = new Iqsoft205_SocketMessage_OpenBets_Request();
//    public static Iqsoft206_SocketMessage_CashoutInfo_Request iqsoft206_socketMessage_cashoutInfo_request = new Iqsoft206_SocketMessage_CashoutInfo_Request();
//    public static Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request iqsoft222_socketMessage_getFavoriteMatcheIds_request= new Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request();
//
//    public static Iqsoft207_SocketMessage_Cashout_Request iqsoft207_socketMessage_cashout_request = new Iqsoft207_SocketMessage_Cashout_Request();
//    public static Iqsoft210_SocketMessage_GetFavoriteCompetitions_Request iqsoft210_socketMessage_getFavoriteCompetitions_request = new Iqsoft210_SocketMessage_GetFavoriteCompetitions_Request();
//    public static Iqsoft211_SocketMessage_AddRemoveFavoriteCompetitions_Request iqsoft211_socketMessage_addRemoveFavoriteCompetitions_request = new Iqsoft211_SocketMessage_AddRemoveFavoriteCompetitions_Request();
//    public static Iqsoft220_SocketMessage_GetFavoriteMatches_Request iqsoft220_socketMessage_getFavoriteMatches_request = new Iqsoft220_SocketMessage_GetFavoriteMatches_Request();
//    public static Iqsoft221_SocketMessage_AddRemoveFavoriteMatches_Request iqsoft221_socketMessage_addRemoveFavoriteMatches_request = new Iqsoft221_SocketMessage_AddRemoveFavoriteMatches_Request();
//    public static Iqsoft230_SocketMessage_GetFavoriteTeams_Request iqsoft230_socketMessage_getFavoriteTeams_request = new Iqsoft230_SocketMessage_GetFavoriteTeams_Request();
//    public static Iqsoft231_SocketMessage_AddRemoveFavoriteTeam_Request iqsoft231_socketMessage_addRemoveFavoriteTeam_request = new Iqsoft231_SocketMessage_AddRemoveFavoriteTeam_Request();
//
//
//
//    public static Iqsoft300_SocketMessage_Authorized_Response iqsoft300_socketMessageAuthorized_response;
//    public static Iqsoft302_SocketMessage_Balance_Response iqsoft301_socketMessage_Balance_response;
//    public static Iqsoft302_SocketMessage_Bet_Response iqsoft302_socketMessage_bet_response;
//    public static Iqsoft303_SocketMessage_GetOpenBetsCount_Response iqsoft303_socketMessage_getOpenBetsCount_response;
//    public static Iqsoft304_SocketMessage_GetOpenBets_Response iqsoft304_socketMessage_getOpenBets_response;
//    public static Iqsoft305_SocketMessage_GetCashoutInfo_Response iqsoft305_socketMessage_getCashoutInfo_response;
//    public static Iqsoft307_SocketMessage_UnsubscribeFromOpenBets_Response iqsoft307_socketMessage_unsubscribeFromOpenBets_response;
//    public static Iqsoft308_SocketMessage_GetPendingCashout_Response iqsoft308_socketMessage_getPendingCashout_response;
//    public static Iqsoft306_SocketMessage_Cashout_Response iqsoft306_socketMessage_cashout_response;
//
//    public static Iqsoft310_SocketMessage_GetFavoriteCompetitions_Response iqsoft310_socketMessage_getFavoriteCompetitions_response;
//    public static Iqsoft311_SocketMessage_GetFavoriteCompetitionsIds_Response iqsoft311_socketMessage_getFavoriteCompetitionsIds_response;
//    public static Iqsoft312_SocketMessage_AddFavoriteCompetitions_Response iqsoft312_socketMessage_addFavoriteCompetitions_response;
//    public static Iqsoft313_SocketMessage_RemoveFavoriteCompetitions_Response iqsoft313_socketMessage_removeFavoriteCompetitions_response;
//    public static Iqsoft320_SocketMessage_GetFavoriteMatches_Response iqsoft320_socketMessage_getFavoriteMatches_response;
//    public static Iqsoft321_SocketMessage_GetFavoriteMatchesIds_Response iqsoft321_socketMessage_getFavoriteMatchesIds_response;
//    public static Iqsoft322_SocketMessage_AddFavoriteMatches_Response iqsoft322_socketMessage_addFavoriteMatches_response;
//    public static Iqsoft323_SocketMessage_RemoveFavoriteMatches_Response iqsoft323_socketMessage_removeFavoriteMatches_response;
//    public static Iqsoft330_SocketMessage_GetFavoriteTeams_Response iqsoft330_socketMessage_getFavoriteTeams_response;
//    public static Iqsoft331_SocketMessage_GetFavoriteTeamsIds_Response iqsoft331_socketMessage_getFavoriteTeamsIds_response;
//    public static Iqsoft332_SocketMessage_AddFavoriteTeam_Response iqsoft332_socketMessage_addFavoriteTeam_response;
//    public static Iqsoft333_SocketMessage_RemoveFavoriteTeam_Response iqsoft333_socketMessage_removeFavoriteTeam_response;
//
//
//
//    //endregion
//
//    //region < ConfigVars>
//
//
//
//    //endregion
//
//
//
//
//    //region < negotiateApiSportsBook >
//
//    public HttpResponse<String> negotiateApiSportsBook() {
//        long responseTime;
//        HttpResponse<String> response = null;
//        try {
//            String url = iqsoft001_response_configJsonAPI.getWebSocketApi() + negotiateApiPathLoggedOut + iqsoft001_response_configJsonAPI.getPartnerId();
//
//            long start = System.currentTimeMillis();
//
//            Unirest.config().reset();
//            Unirest.config().connectTimeout(60000);
//            Unirest.config().socketTimeout(60000);
//            response = Unirest.post(url)
//                    .asString();
//            Unirest.shutDown();
//
//
//            long end = System.currentTimeMillis();
//            responseTime = end - start;
//            Allure.addAttachment("negotiateApiSportsBook:  Url  " + url, "");
//            Allure.addAttachment("negotiateApiSportsBook:  ResponseTime  " + responseTime + "ms        ResponseBody", "application/json", response.getBody());
//
//            int statusCode = response.getStatus();
//            if (statusCode == 200) {
//
//                String responseString = response.getBody();
//                Unirest.shutDown();
//
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                    iqsoft101_responseNegotiateAPI = objectMapper.readValue(responseString, Iqsoft101_Response_NegotiateAPI.class);
//                    connectionId = iqsoft101_responseNegotiateAPI.getConnectionId();
//                    connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
////                    System.out.println("Negotiate Version: " + iqsoft101_responseNegotiateAPI.getNegotiateVersion());
////                    System.out.println("Connection ID: " + iqsoft101_responseNegotiateAPI.getConnectionId());
////                    System.out.println("Connection Token: " + iqsoft101_responseNegotiateAPI.getConnectionToken());
////                    for (Iqsoft101_Response_NegotiateAPI.Transport transport : iqsoft101_responseNegotiateAPI.getAvailableTransports()) {
////                        System.out.println("Transport: " + transport.getTransport());
////                        System.out.println("Transfer Formats: " + transport.getTransferFormats());
////                    }
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                logger.fatal("negotiateApiSportsBook() has status code = " + statusCode);
//            }
//
//        } catch (Exception e1) {
//            try {
//                String url = iqsoft001_response_configJsonAPI.getWebSocketApi() + negotiateApiPathLoggedOut + iqsoft001_response_configJsonAPI.getPartnerId();
//
//                long start = System.currentTimeMillis();
//                Unirest.config().reset();
//                Unirest.config().connectTimeout(60000);
//                Unirest.config().socketTimeout(60000);
//                response = Unirest.post(url)
//                        .header("content-type", "application/json")
//                        .asString();
//                Unirest.shutDown();
//                long end = System.currentTimeMillis();
//                responseTime = end - start;
//                Allure.addAttachment("negotiateApiSportsBook:  Url  " + url, "");
//                Allure.addAttachment("negotiateApiSportsBook:  ResponseTime  " + responseTime + "ms        ResponseBody", "application/json", response.getBody());
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
//                        connectionId = iqsoft101_responseNegotiateAPI.getConnectionId();
//                        connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
////                    System.out.println("Negotiate Version: " + iqsoft101_responseNegotiateAPI.getNegotiateVersion());
////                    System.out.println("Connection ID: " + iqsoft101_responseNegotiateAPI.getConnectionId());
////                    System.out.println("Connection Token: " + iqsoft101_responseNegotiateAPI.getConnectionToken());
////                    for (Iqsoft101_Response_NegotiateAPI.Transport transport : iqsoft101_responseNegotiateAPI.getAvailableTransports()) {
////                        System.out.println("Transport: " + transport.getTransport());
////                        System.out.println("Transfer Formats: " + transport.getTransferFormats());
////                    }
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    logger.fatal("negotiateApiSportsBook() has status code = " + statusCode);
//                }
//            } catch (Exception e) {
//                logger.error("negotiateApiSportsBook() call has exception: " + e);
//            }
//        }
//        return response;
//    }
//
//    public HttpResponse<String> negotiateApiLoggedInSportsBook() {
//        long responseTime;
//        HttpResponse<String> response = null;
//        try {
//            String url = iqsoft001_response_configJsonAPI.getWebSocketApi()
//                    + negotiateApiPathLoggedIn + iqsoft001_response_configJsonAPI.getPartnerId();
//
//            long start = System.currentTimeMillis();
//
//            Unirest.config().reset();
//            Unirest.config().connectTimeout(60000);
//            Unirest.config().socketTimeout(60000);
//            response = Unirest.post(url)
//                    .asString();
//            Unirest.shutDown();
//
//
//            long end = System.currentTimeMillis();
//            responseTime = end - start;
//            Allure.addAttachment("negotiateApiSportsBook:  Url  " + url, "");
//            Allure.addAttachment("negotiateApiSportsBook:  ResponseTime  " + responseTime + "ms        ResponseBody", "application/json", response.getBody());
//
//            int statusCode = response.getStatus();
//            if (statusCode == 200) {
//
//                String responseString = response.getBody();
//                Unirest.shutDown();
//
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                    iqsoft101_responseNegotiateAPI = objectMapper.readValue(responseString, Iqsoft101_Response_NegotiateAPI.class);
//                    connectionId = iqsoft101_responseNegotiateAPI.getConnectionId();
//                    connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
////                    System.out.println("Negotiate Version: " + iqsoft101_responseNegotiateAPI.getNegotiateVersion());
////                    System.out.println("Connection ID: " + iqsoft101_responseNegotiateAPI.getConnectionId());
////                    System.out.println("Connection Token: " + iqsoft101_responseNegotiateAPI.getConnectionToken());
////                    for (Iqsoft101_Response_NegotiateAPI.Transport transport : iqsoft101_responseNegotiateAPI.getAvailableTransports()) {
////                        System.out.println("Transport: " + transport.getTransport());
////                        System.out.println("Transfer Formats: " + transport.getTransferFormats());
////                    }
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                logger.fatal("negotiateApiSportsBook() has status code = " + statusCode);
//            }
//
//        } catch (Exception e1) {
//            try {
//                String url = iqsoft001_response_configJsonAPI.getWebSocketApi() + negotiateApiPathLoggedIn + iqsoft001_response_configJsonAPI.getPartnerId();
//
//                long start = System.currentTimeMillis();
//                Unirest.config().reset();
//                Unirest.config().connectTimeout(60000);
//                Unirest.config().socketTimeout(60000);
//                response = Unirest.post(url)
//                        .header("content-type", "application/json")
//                        .asString();
//                Unirest.shutDown();
//                long end = System.currentTimeMillis();
//                responseTime = end - start;
//                Allure.addAttachment("negotiateApiSportsBook:  Url  " + url, "");
//                Allure.addAttachment("negotiateApiSportsBook:  ResponseTime  " + responseTime + "ms        ResponseBody", "application/json", response.getBody());
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
//                        connectionId = iqsoft101_responseNegotiateAPI.getConnectionId();
//                        connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
////                    System.out.println("Negotiate Version: " + iqsoft101_responseNegotiateAPI.getNegotiateVersion());
////                    System.out.println("Connection ID: " + iqsoft101_responseNegotiateAPI.getConnectionId());
////                    System.out.println("Connection Token: " + iqsoft101_responseNegotiateAPI.getConnectionToken());
////                    for (Iqsoft101_Response_NegotiateAPI.Transport transport : iqsoft101_responseNegotiateAPI.getAvailableTransports()) {
////                        System.out.println("Transport: " + transport.getTransport());
////                        System.out.println("Transfer Formats: " + transport.getTransferFormats());
////                    }
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    logger.fatal("negotiateApiSportsBook() has status code = " + statusCode);
//                }
//            } catch (Exception e) {
//                logger.error("negotiateApiSportsBook() call has exception: " + e);
//            }
//        }
//        return response;
//    }
//
//
//    //endregion
//
//
//
//    //region < negotiateApiSportsBook & SocketConnection LoggedIn>
//    public String negotiateHttpApiLoggedInSportsBook() {
//        String connectionToken = null;
//        long responseTime;
//        HttpResponse<String> response = null;
//        try {
//            String url = iqsoft001_response_configJsonAPI.getWebSocketApi() + negotiateApiPathLoggedIn + iqsoft001_response_configJsonAPI.getPartnerId();
//
//            long start = System.currentTimeMillis();
//
//            Unirest.config().reset();
//            Unirest.config().connectTimeout(60000);
//            Unirest.config().socketTimeout(60000);
//            response = Unirest.post(url)
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
//                Unirest.shutDown();
//
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                    iqsoft101_responseNegotiateAPI = objectMapper.readValue(responseString, Iqsoft101_Response_NegotiateAPI.class);
//                    connectionToken = iqsoft101_responseNegotiateAPI.getConnectionToken();
//
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                logger.fatal("negotiateHttpApiLoggedInSportsBook() has status code = " + statusCode);
//            }
//
//        } catch (Exception e1) {
//            try {
//                String url = iqsoft001_response_configJsonAPI.getWebSocketApi() + negotiateApiPathLoggedIn + iqsoft001_response_configJsonAPI.getPartnerId();
//
//                long start = System.currentTimeMillis();
//
//                Unirest.config().reset();
//                Unirest.config().connectTimeout(60000);
//                Unirest.config().socketTimeout(60000);
//                response = Unirest.post(url)
//                        .asString();
//                Unirest.shutDown();
//
//
//                long end = System.currentTimeMillis();
//                responseTime = end - start;
//                Allure.addAttachment("negotiateHttpApiLoggedInSportsBook:  Url: " + url + "    ResponseTime  " + responseTime + "ms        ResponseBody", "application/json", response.getBody());
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
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    logger.fatal("negotiateHttpApiLoggedInSportsBook() has status code = " + statusCode);
//                }
//            } catch (Exception e) {
//                logger.error("negotiateHttpApiLoggedInSportsBook() call has exception: " + e);
//            }
//        }
//        return connectionToken;
//    }
//
//    public void socketConnectionLoggedInSportsBook() {
//
//        try {
//
//            serverUri = new URI(iqsoft001_response_configJsonAPI.getWebSocketApi().replace("https://", "wss://")
//                    + socketConnectionPathLoggedIn + negotiateHttpApiLoggedInSportsBook() + "&PartnerId=" + iqsoft001_response_configJsonAPI.getPartnerId());
//            client = new Iqsoft102_SportWebSocketClient(serverUri);
//            long start = System.currentTimeMillis();
//
////            client.connect();
//            client.connectBlocking();
//
//            long end = System.currentTimeMillis();
//            responseTime = end - start;
//
//            // Wait for a moment (optional) before sending messages
//            Thread.sleep(1000);
//
////             Send messages to the WebSocket server
//
//            // Keep the application running to listen for messages
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                try {
//                    client.closeBlocking();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }));
//
//
//        } catch (Exception e) {
//            logger.error("socketConnectionSportsBook() call has an exception: " + e);
//
//        }
//
//    }
//
//    //endregion
//
//
//    public static int invocationId = 0;
//    public static String receivedMessage;
//
//    public String sendSocketMessageWithoutArgument(String invocationId, String target) {
//        String message;
//
//        iqsoft200_socketMessageWithoutArguments_request = new Iqsoft200_SocketMessage_WithoutArguments_Request();
//
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft200_socketMessageWithoutArguments_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageGetFavoriteMatchIds(String invocationId, String target) {
//        String message;
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setInvocationId(invocationId);
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setTarget(target);
//        List<Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments ag1 = new Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments();
//
//        ag1.setViewType(1);
//
//        arguments.add(ag1);
//
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft222_socketMessage_getFavoriteMatcheIds_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//    public String sendSocketMessageAddRemoveFavoriteCompetition(String invocationId, String target, long id) {
//        String message;
//        iqsoft211_socketMessage_addRemoveFavoriteCompetitions_request.setInvocationId(invocationId);
//        iqsoft211_socketMessage_addRemoveFavoriteCompetitions_request.setTarget(target);
//        List<Long> arguments = new ArrayList<>();
//        arguments.add(id);
//
//        iqsoft211_socketMessage_addRemoveFavoriteCompetitions_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft211_socketMessage_addRemoveFavoriteCompetitions_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageAddRemoveFavoriteMatch(String invocationId, String target, long id) {
//        String message;
//        iqsoft221_socketMessage_addRemoveFavoriteMatches_request.setInvocationId(invocationId);
//        iqsoft221_socketMessage_addRemoveFavoriteMatches_request.setTarget(target);
//        List<Long> arguments = new ArrayList<>();
//        arguments.add(id);
//
//        iqsoft221_socketMessage_addRemoveFavoriteMatches_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft221_socketMessage_addRemoveFavoriteMatches_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageAddRemoveFavoriteCTeam(String invocationId, String target, long id) {
//        String message;
//        iqsoft231_socketMessage_addRemoveFavoriteTeam_request.setInvocationId(invocationId);
//        iqsoft231_socketMessage_addRemoveFavoriteTeam_request.setTarget(target);
//        List<Long> arguments = new ArrayList<>();
//        arguments.add(id);
//
//        iqsoft231_socketMessage_addRemoveFavoriteTeam_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft231_socketMessage_addRemoveFavoriteTeam_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//
//    public String sendSocketMessageGetPlayerFavoriteCompetitions(String invocationId, String target) {
//        String message;
//        iqsoft210_socketMessage_getFavoriteCompetitions_request.setInvocationId(invocationId);
//        iqsoft210_socketMessage_getFavoriteCompetitions_request.setTarget(target);
//        List<Iqsoft210_SocketMessage_GetFavoriteCompetitions_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft210_SocketMessage_GetFavoriteCompetitions_Request.arguments ag1 = new Iqsoft210_SocketMessage_GetFavoriteCompetitions_Request.arguments();
//
//        ag1.setOddsType(0);
//
//        arguments.add(ag1);
//
//        iqsoft210_socketMessage_getFavoriteCompetitions_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft210_socketMessage_getFavoriteCompetitions_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageGetPlayerFavoriteTeams (String invocationId, String target) {
//        String message;
//        iqsoft230_socketMessage_getFavoriteTeams_request.setInvocationId(invocationId);
//        iqsoft230_socketMessage_getFavoriteTeams_request.setTarget(target);
//        List<Iqsoft230_SocketMessage_GetFavoriteTeams_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft230_SocketMessage_GetFavoriteTeams_Request.arguments ag1 = new Iqsoft230_SocketMessage_GetFavoriteTeams_Request.arguments();
//
//        ag1.setOddsType(0);
//
//        arguments.add(ag1);
//
//        iqsoft230_socketMessage_getFavoriteTeams_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft230_socketMessage_getFavoriteTeams_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageGetFavoriteMatches(String invocationId, String target) {
//        String message;
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setInvocationId(invocationId);
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setTarget(target);
//        List<Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments ag1 = new Iqsoft222_SocketMessage_GetFavoriteMatcheIds_Request.arguments();
//
//        ag1.setViewType(1);
//
//        arguments.add(ag1);
//
//        iqsoft222_socketMessage_getFavoriteMatcheIds_request.setArguments(arguments);
//        Gson gson = new Gson();
//        message = gson.toJson(iqsoft222_socketMessage_getFavoriteMatcheIds_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//
//
//    public String sendSocketMessageCashoutInfo(String invocationId, String target,
//                                               Iqsoft304_SocketMessage_GetOpenBets_Response.result.ResponseObject arguments) {
//
//        String message;
//        Gson gson = new GsonBuilder()
//                .serializeNulls()
//                .create();
//        iqsoft206_socketMessage_cashoutInfo_request.setInvocationId(invocationId);
//        iqsoft206_socketMessage_cashoutInfo_request.setTarget(target);
//        List<Iqsoft304_SocketMessage_GetOpenBets_Response.result.ResponseObject> Arguments = new ArrayList<>();
//        Arguments.add(arguments) ;
//
//        iqsoft206_socketMessage_cashoutInfo_request.setArguments(Arguments);
//
//        message = gson.toJson(iqsoft206_socketMessage_cashoutInfo_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//    public String sendSocketMessageCashout(String invocationId, String target, long betId, boolean isFullAmount, double amount) {
//
//        String message;
//        Gson gson = new Gson();
//        iqsoft207_socketMessage_cashout_request.setInvocationId(invocationId);
//        iqsoft207_socketMessage_cashout_request.setTarget(target);
//        List<Iqsoft207_SocketMessage_Cashout_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft207_SocketMessage_Cashout_Request.arguments ag1 = new Iqsoft207_SocketMessage_Cashout_Request.arguments();
//
//        ag1.setBetId(betId);
//        ag1.setFullAmount(isFullAmount);
//        ag1.setAmount(amount);
//
//        arguments.add(ag1);
//
//        iqsoft207_socketMessage_cashout_request.setArguments(arguments);
//
//        message = gson.toJson(iqsoft207_socketMessage_cashout_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//    public String sendSocketMessage_GetOpenBetsCount(String invocationId, String target, boolean IsForCashout) {
//
//        String message;
//        Gson gson = new Gson();
//
//        iqsoft204_socketMessage_openBetsCount_request.setInvocationId(invocationId);
//        iqsoft204_socketMessage_openBetsCount_request.setTarget(target);
//        List<Iqsoft204_SocketMessage_OpenBetsCount_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft204_SocketMessage_OpenBetsCount_Request.arguments ag1 = new Iqsoft204_SocketMessage_OpenBetsCount_Request.arguments();
//
//        ag1.setForCashout(IsForCashout);
//
//        arguments.add(ag1);
//
//        iqsoft204_socketMessage_openBetsCount_request.setArguments(arguments);
//
//        message = gson.toJson(iqsoft204_socketMessage_openBetsCount_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//    public String sendSocketMessage_GetOpenBets(String invocationId, String target, boolean IsForCashout) {
//
//        String message;
//        Gson gson = new Gson();
//        iqsoft205_socketMessage_openBets_request.setInvocationId(invocationId);
//        iqsoft205_socketMessage_openBets_request.setTarget(target);
//        List<Iqsoft205_SocketMessage_OpenBets_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft205_SocketMessage_OpenBets_Request.arguments ag1 = new Iqsoft205_SocketMessage_OpenBets_Request.arguments();
//
//        ag1.setForCashout(IsForCashout);
//
//        arguments.add(ag1);
//
//        iqsoft205_socketMessage_openBets_request.setArguments(arguments);
//
//        message = gson.toJson(iqsoft205_socketMessage_openBets_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//    public String sendSocketMessageBet(String invocationId, String target, int betType, int betAcceptanceMode, double betAmount,
//                                       List<Long> selectionId, List<Long> marketId, List<Long> matchId, List<Double> coefficient, boolean isSystem) {
//
//        String message;
//        Gson gson = new Gson();
//        iqsoft203_socketMessage_bet_request.setInvocationId(invocationId);
//        iqsoft203_socketMessage_bet_request.setTarget(target);
//        List<Iqsoft203_SocketMessage_Bet_Request.arguments> arguments = new ArrayList<>();
//        Iqsoft203_SocketMessage_Bet_Request.arguments ag1 = new Iqsoft203_SocketMessage_Bet_Request.arguments();
//
//        ag1.setBetAcceptanceMode(betAcceptanceMode);
//        ag1.setAmount(betAmount);
//        ag1.setBetType(betType);
//
//        if (isSystem){
//            List<Object> a = new ArrayList<>();
//            a.add(2);
//            ag1.setSystemOutCounts(a);
//        }
//        List<Iqsoft203_SocketMessage_Bet_Request.arguments.Selections> selections = new ArrayList<>();
//
//        int size = matchId.size();
//        if (marketId.size() != size || coefficient.size() != size || selectionId.size() != size) {
//            throw new IllegalArgumentException("All lists must have the same size");
//        }
//        Iqsoft203_SocketMessage_Bet_Request.arguments.Selections selection;
//        for (int i = 0; i < size; i++) {
//            selection = new Iqsoft203_SocketMessage_Bet_Request.arguments.Selections();
//            selection.setSelectionId(selectionId.get(i));
//            selection.setMarketId(marketId.get(i));
//            selection.setMatchId(matchId.get(i));
//            selection.setCoefficient(coefficient.get(i));
//            selections.add(selection);
//        }
//
//        arguments.add(ag1);
//        ag1.setSelections(selections);
//        iqsoft203_socketMessage_bet_request.setArguments(arguments);
//
//        message = gson.toJson(iqsoft203_socketMessage_bet_request);
//        message = message + "\u001E\t";
//        return message;
//    }
//
//
//
//
//    public Object mapReceivedMessage(Class myClass, String invocationId) throws InterruptedException {
//        Object mapObj;
//        try {
//        receivedMessage = client.waitForMessageWithInvocationId(invocationId);
//        Allure.addAttachment("Received message: ResponseTime = " + responseTime + " ms ", receivedMessage);
//            logger.info("Received message: " + receivedMessage);
//            String cleanedJson = receivedMessage.replace("\u001e", "");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//            mapObj = objectMapper.readValue(cleanedJson, myClass);
//        } catch (JsonProcessingException e) {
//            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     " + e);
//            throw new RuntimeException(e);
//        }
//        return mapObj;
//    }
//
//
//
//
//
//
//
//
//}
