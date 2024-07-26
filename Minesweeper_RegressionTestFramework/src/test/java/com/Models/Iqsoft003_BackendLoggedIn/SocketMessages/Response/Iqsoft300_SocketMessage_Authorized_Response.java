package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import cucumber.api.java.eo.Do;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft300_SocketMessage_Authorized_Response {


    public Iqsoft300_SocketMessage_Authorized_Response() {

    }

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class R {

        @JsonProperty("Authorized")
        private  boolean Authorized;

        @JsonProperty("CurrencyId")
        private  String CurrencyId;

        @JsonProperty("CurrencyRate")
        private  double CurrencyRate;

        @JsonProperty("CurrencySymbol")
        private  String CurrencySymbol;

        @JsonProperty("ClientId")
        private  int ClientId;

        @JsonProperty("Nickname")
        private String Nickname;

        @JsonProperty("NicknameChanged")
        private  boolean NicknameChanged;

        @JsonProperty("ClientExternalId")
        private  int ClientExternalId;

        @JsonProperty("Coins")
        private List<Double> Coins;


        public boolean isAuthorized() {
            return Authorized;
        }

        public void setAuthorized(boolean authorized) {
            Authorized = authorized;
        }

        public String getCurrencyId() {
            return CurrencyId;
        }

        public void setCurrencyId(String currencyId) {
            CurrencyId = currencyId;
        }

        public double getCurrencyRate() {
            return CurrencyRate;
        }

        public void setCurrencyRate(double currencyRate) {
            CurrencyRate = currencyRate;
        }

        public String getCurrencySymbol() {
            return CurrencySymbol;
        }

        public void setCurrencySymbol(String currencySymbol) {
            CurrencySymbol = currencySymbol;
        }

        public int getClientId() {
            return ClientId;
        }

        public void setClientId(int clientId) {
            ClientId = clientId;
        }

        public String getNickname() {
            return Nickname;
        }

        public void setNickname(String nickname) {
            Nickname = nickname;
        }

        public boolean isNicknameChanged() {
            return NicknameChanged;
        }

        public void setNicknameChanged(boolean nicknameChanged) {
            NicknameChanged = nicknameChanged;
        }

        public int getClientExternalId() {
            return ClientExternalId;
        }

        public void setClientExternalId(int clientExternalId) {
            ClientExternalId = clientExternalId;
        }

        public List<Double> getCoins() {
            return Coins;
        }

        public void setCoins(List<Double> coins) {
            Coins = coins;
        }
    }


    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public Iqsoft300_SocketMessage_Authorized_Response.R getR() {
        return R;
    }

    public void setR(Iqsoft300_SocketMessage_Authorized_Response.R r) {
        R = r;
    }










}
