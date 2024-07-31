package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft303_SocketMessage_State_Response {

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

            @JsonProperty("GameId")
            private  int GameId;

            @JsonProperty("UnitId")
            private  int UnitId;

            @JsonProperty("RoundId")
            private  int RoundId;

            @JsonProperty("Status")
            private  int Status;

            @JsonProperty("State")
            private  Object State;

            @JsonProperty("Outcome")
            private  Object Outcome;

            @JsonProperty("BettingTime")
            private  Object BettingTime;

            @JsonProperty("CalculationTime")
            private  int CalculationTime;

            @JsonProperty("RemSeconds")
            private  int RemSeconds;

            @JsonProperty("CreationTime")
            private  String CreationTime;

            @JsonProperty("CalculationDate")
            private  Object CalculationDate;

            @JsonProperty("JackpotAmount")
            private  Object JackpotAmount;

            @JsonProperty("LeftAmount")
            private  Object LeftAmount;

            @JsonProperty("StartTime")
            private  Object StartTime;



            @JsonProperty("History")
            private  List<History> History;
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class History {

                @JsonProperty("RoundId")
                private  int RoundId;

                @JsonProperty("UnitOutcome")
                private  Object UnitOutcome;

                @JsonProperty("DateValue")
                private  String DateValue;
                @JsonProperty("Info")
                private  String Info;


                public String getInfo() {
                    return Info;
                }

                public void setInfo(String info) {
                    Info = info;
                }

                public int getRoundId() {
                    return RoundId;
                }

                public void setRoundId(int roundId) {
                    RoundId = roundId;
                }

                public Object getUnitOutcome() {
                    return UnitOutcome;
                }

                public void setUnitOutcome(Object unitOutcome) {
                    UnitOutcome = unitOutcome;
                }

                public String getDateValue() {
                    return DateValue;
                }

                public void setDateValue(String dateValue) {
                    DateValue = dateValue;
                }


            }

            public int getGameId() {
                return GameId;
            }

            public void setGameId(int gameId) {
                GameId = gameId;
            }

            public int getUnitId() {
                return UnitId;
            }

            public void setUnitId(int unitId) {
                UnitId = unitId;
            }

            public int getRoundId() {
                return RoundId;
            }

            public void setRoundId(int roundId) {
                RoundId = roundId;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int status) {
                Status = status;
            }

            public Object getState() {
                return State;
            }

            public void setState(Object state) {
                State = state;
            }

            public Object getOutcome() {
                return Outcome;
            }

            public void setOutcome(Object outcome) {
                Outcome = outcome;
            }

            public Object getBettingTime() {
                return BettingTime;
            }

            public void setBettingTime(Object bettingTime) {
                BettingTime = bettingTime;
            }

            public int getCalculationTime() {
                return CalculationTime;
            }

            public void setCalculationTime(int calculationTime) {
                CalculationTime = calculationTime;
            }

            public int getRemSeconds() {
                return RemSeconds;
            }

            public void setRemSeconds(int remSeconds) {
                RemSeconds = remSeconds;
            }

            public String getCreationTime() {
                return CreationTime;
            }

            public void setCreationTime(String creationTime) {
                CreationTime = creationTime;
            }

            public Object getCalculationDate() {
                return CalculationDate;
            }

            public void setCalculationDate(Object calculationDate) {
                CalculationDate = calculationDate;
            }

            public Object getJackpotAmount() {
                return JackpotAmount;
            }

            public void setJackpotAmount(Object jackpotAmount) {
                JackpotAmount = jackpotAmount;
            }

            public Object getLeftAmount() {
                return LeftAmount;
            }

            public void setLeftAmount(Object leftAmount) {
                LeftAmount = leftAmount;
            }

            public Object getStartTime() {
                return StartTime;
            }

            public void setStartTime(Object startTime) {
                StartTime = startTime;
            }

            public List<History> getHistory() {
                return History;
            }

            public void setHistory(List<History> history) {
                History = history;
            }
        }


        public int getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(int responseCode) {
            ResponseCode = responseCode;
        }

        public List<ResponseObject> getResponseObject() {
            return ResponseObject;
        }

        public void setResponseObject(List<ResponseObject> responseObject) {
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
