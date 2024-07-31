package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft305_SocketMessage_CreateBoard_Response {

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class R {

        @JsonProperty("ResponseCode")
        private  int ResponseCode;

        @JsonProperty("ResponseObject")
        private ResponseObject ResponseObject ;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ResponseObject {

            @JsonProperty("Status")
            private  int Status;

            @JsonProperty("Balance")
            private  double Balance;

            @JsonProperty("BoardInfo")
            private  BoardInfo BoardInfo;

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BoardInfo {

                @JsonProperty("PlayerId")
                private  int PlayerId;

                @JsonProperty("Board")
                private  List<List<Double>> Board;

                @JsonProperty("PositionRow") ////////////////////////////////////// Select Position on top
                private  int PositionRow;

                @JsonProperty("BetAmount")
                private  double BetAmount;

                @JsonProperty("WinAmount")
                private  double WinAmount;

                @JsonProperty("PositionColumn")
                private  Object PositionColumn;

                @JsonProperty("Dimension")
                private  Dimension Dimension;

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class Dimension {

                    @JsonProperty("Height")
                    private  int Height;

                    @JsonProperty("Width")
                    private  int Width;

                    @JsonProperty("Mines")
                    private  int Mines;

                    public int getHeight() {
                        return Height;
                    }

                    public void setHeight(int height) {
                        Height = height;
                    }

                    public int getWidth() {
                        return Width;
                    }

                    public void setWidth(int width) {
                        Width = width;
                    }

                    public int getMines() {
                        return Mines;
                    }

                    public void setMines(int mines) {
                        Mines = mines;
                    }
                }

            }


            public int getStatus() {
                return Status;
            }

            public void setStatus(int status) {
                Status = status;
            }

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double balance) {
                Balance = balance;
            }

            public BoardInfo getBoardInfo() {
                return BoardInfo;
            }

            public void setBoardInfo(BoardInfo boardInfo) {
                BoardInfo = boardInfo;
            }
        }


        public int getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(int responseCode) {
            ResponseCode = responseCode;
        }

        public ResponseObject getResponseObject() {
            return ResponseObject;
        }

        public void setResponseObject(ResponseObject responseObject) {
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
