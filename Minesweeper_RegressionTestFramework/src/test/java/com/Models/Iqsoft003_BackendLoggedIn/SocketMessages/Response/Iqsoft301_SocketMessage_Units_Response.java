package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft301_SocketMessage_Units_Response {

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class R {

        @JsonProperty("ResponseCode")
        private  int ResponseCode;

        @JsonProperty("ResponseObject")
        private List<ResponseObject> ResponseObject ;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ResponseObject {

            @JsonProperty("Id")
            private  int Id;

            @JsonProperty("GameId")
            private  int GameId;

            @JsonProperty("CurrentRound")
            private  int CurrentRound;

            @JsonProperty("NickName")
            private  String NickName;

            @JsonProperty("Name")
            private  String Name;

            @JsonProperty("TranslationId")
            private  int TranslationId;

            @JsonProperty("Blocked")
            private  boolean Blocked;

            @JsonProperty("NextDrawDate")
            private  String NextDrawDate;

            @JsonProperty("Outcome")
            private  Object Outcome;

            @JsonProperty("Jackpot")
            private  Object Jackpot;

            @JsonProperty("PlayersCount")
            private  int PlayersCount;

            @JsonProperty("BetMinLimit")
            private  Object BetMinLimit;

            @JsonProperty("BetMaxLimit")
            private  Object BetMaxLimit;

            public int getId() {
                return Id;
            }

            public void setId(int id) {
                Id = id;
            }

            public int getGameId() {
                return GameId;
            }

            public void setGameId(int gameId) {
                GameId = gameId;
            }

            public int getCurrentRound() {
                return CurrentRound;
            }

            public void setCurrentRound(int currentRound) {
                CurrentRound = currentRound;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String nickName) {
                NickName = nickName;
            }

            public String getName() {
                return Name;
            }

            public void setName(String name) {
                Name = name;
            }

            public int getTranslationId() {
                return TranslationId;
            }

            public void setTranslationId(int translationId) {
                TranslationId = translationId;
            }

            public boolean isBlocked() {
                return Blocked;
            }

            public void setBlocked(boolean blocked) {
                Blocked = blocked;
            }

            public String getNextDrawDate() {
                return NextDrawDate;
            }

            public void setNextDrawDate(String nextDrawDate) {
                NextDrawDate = nextDrawDate;
            }

            public Object getOutcome() {
                return Outcome;
            }

            public void setOutcome(Object outcome) {
                Outcome = outcome;
            }

            public Object getJackpot() {
                return Jackpot;
            }

            public void setJackpot(Object jackpot) {
                Jackpot = jackpot;
            }

            public int getPlayersCount() {
                return PlayersCount;
            }

            public void setPlayersCount(int playersCount) {
                PlayersCount = playersCount;
            }

            public Object getBetMinLimit() {
                return BetMinLimit;
            }

            public void setBetMinLimit(Object betMinLimit) {
                BetMinLimit = betMinLimit;
            }

            public Object getBetMaxLimit() {
                return BetMaxLimit;
            }

            public void setBetMaxLimit(Object betMaxLimit) {
                BetMaxLimit = betMaxLimit;
            }
        }


        public int getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(int responseCode) {
            ResponseCode = responseCode;
        }

        public List<Iqsoft301_SocketMessage_Units_Response.R.ResponseObject> getResponseObject() {
            return ResponseObject;
        }

        public void setResponseObject(List<Iqsoft301_SocketMessage_Units_Response.R.ResponseObject> responseObject) {
            ResponseObject = responseObject;
        }
    }


    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public R getR() {
        return R;
    }

    public void setR(R r) {
        R = r;
    }
}
