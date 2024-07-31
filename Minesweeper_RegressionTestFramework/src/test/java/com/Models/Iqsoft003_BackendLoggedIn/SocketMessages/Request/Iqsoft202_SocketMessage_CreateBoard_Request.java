package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response.Iqsoft303_SocketMessage_State_Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft202_SocketMessage_CreateBoard_Request {


    public Iqsoft202_SocketMessage_CreateBoard_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<A>  A ;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class A {

        @JsonProperty("BetInput")
        private  BetInput BetInput;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BetInput {
            @JsonProperty("BetType")
            private int BetType;

            @JsonProperty("ClientId")
            private int ClientId;

            @JsonProperty("GameId")
            private int GameId;

            @JsonProperty("Amount")
            private double Amount;

            @JsonProperty("Events")
            private Object Events = null;

            public int getBetType() {
                return BetType;
            }

            public void setBetType(int betType) {
                BetType = betType;
            }

            public int getClientId() {
                return ClientId;
            }

            public void setClientId(int clientId) {
                ClientId = clientId;
            }

            public int getGameId() {
                return GameId;
            }

            public void setGameId(int gameId) {
                GameId = gameId;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
            }

            public Object getEvents() {
                return Events;
            }

            public void setEvents(Object events) {
                Events = events;
            }
        }





        @JsonProperty("BoardInput")
        private  BoardInput BoardInput;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BoardInput {
            @JsonProperty("Width")
            private int Width;
            @JsonProperty("Height")
            private int Height;
            @JsonProperty("MinesCount")
            private int MinesCount;

            public int getWidth() {
                return Width;
            }

            public void setWidth(int width) {
                Width = width;
            }

            public int getHeight() {
                return Height;
            }

            public void setHeight(int height) {
                Height = height;
            }

            public int getMinesCount() {
                return MinesCount;
            }

            public void setMinesCount(int minesCount) {
                MinesCount = minesCount;
            }
        }


        public BetInput getBetInput() {
            return BetInput;
        }

        public void setBetInput(BetInput betInput) {
            BetInput = betInput;
        }

        public BoardInput getBoardInput() {
            return BoardInput;
        }

        public void setBoardInput(BoardInput boardInput) {
            BoardInput = boardInput;
        }
    }



    @JsonProperty("I")
    private int I;



    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public List<A> getA() {
        return A;
    }

    public void setA(List<A> a) {
        A = a;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }
}
