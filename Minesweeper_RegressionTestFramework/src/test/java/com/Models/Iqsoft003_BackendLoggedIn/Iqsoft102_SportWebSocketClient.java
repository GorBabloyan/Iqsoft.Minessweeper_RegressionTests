package com.Models.Iqsoft003_BackendLoggedIn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pageObjects.Iqsoft_001_BasePage;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.Allure;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.concurrent.*;

import static com.testCases.Iqsoft_001_BaseTest.*;


public class Iqsoft102_SportWebSocketClient extends WebSocketClient {

    public Iqsoft102_SportWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    private boolean intentionalClose = false;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    @Override
    public void onOpen(ServerHandshake handshakedata) {


//        Allure.addAttachment("SocketConnection Url:  " + serverUri.toString(), "WebSocket connection opened");

        if (handshakedata.getHttpStatus() < 300) {
            Iqsoft_001_BaseTest.isSocketConnectionSuccess = true;
            Allure.addAttachment("SocketConnection Url:  " + serverUri.toString(), "WebSocket connection opened: Status code = " + handshakedata.getHttpStatus());
//            Allure.addAttachment("WebSocket connection opened  ", "ServerHandshake: " + handshakedata);

        } else {
            Allure.addAttachment("Failed to establish WebSocket connection. Status code: " + handshakedata.getHttpStatus(), "");
        }

    }

    @Override
    public void onMessage(String message) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + message);
        end = System.currentTimeMillis();
        responseTime = end - start;
//        Allure.addAttachment("Received message:::  " + responseTime + " ms", "text/plain", message);
        messageQueue.offer(message);
   }

    public String waitForMessageWithInvocationId(String I) throws InterruptedException {
        while (true) {
            String message = messageQueue.take(); // This will block until a message is available
            if (message.contains("\"I\":\"" + I + "\"")) {
                return message;
            }
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
//        System.out.println("Socket successfully closed. " + " Code = " + code);
        Allure.addAttachment("Socket successfully closed. ", "Code = " + code);
    }
    @Override
    public void onError(Exception ex) {
        if (!intentionalClose) {
            Allure.addAttachment("Socket closed, Attempting to reconnect: ", String.valueOf(ex));
            System.out.println("Socket closed, Attempting to reconnect: " + ex);
            attemptReconnect();
        }
    }

    public void sendMessage(String message) {
        if (isOpen()) {
            Allure.addAttachment("Message sent: " , "text/plain", message);
//            System.out.println("Message sent: "+ message);
            Iqsoft_001_BasePage.logger.info("Message sent: "+ message);
            start = System.currentTimeMillis();
            send(message);

//            System.out.println("Message sent: " + message);
        } else {
            Allure.addAttachment("WebSocket connection is closed. Cannot send message. ", "");
//            System.err.println("WebSocket connection is not open. Cannot send message.");
            try {
                reconnect();
            } catch (Exception e) {
                try {
                    client.closeBlocking();
                    client.close();
                } catch (InterruptedException e1) {
                    throw new RuntimeException(e1);
                }

            }
        }
    }

    public void close() {

//        System.out.println("Socket close");
        if (! Iqsoft_001_BaseTest.client.isClosed()) {
            intentionalClose = true;
            closeConnection(1000, "Socket closed Successfully");
        }
    }

    private void attemptReconnect() {
        scheduler.schedule(this::connect, 0, TimeUnit.SECONDS);
    }




    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private int type;
        private String invocationId;
        private Result result;

        // Getters and setters
        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getInvocationId() {
            return invocationId;
        }

        public void setInvocationId(String invocationId) {
            this.invocationId = invocationId;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
    }

}
