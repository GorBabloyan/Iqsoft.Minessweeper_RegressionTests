package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft307_SocketMessage_CashOut_Response {

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class R {


        @JsonProperty("ClientId")
        private int ClientId;

        @JsonProperty("Coefficient")
        private double Coefficient;

        @JsonProperty("GameId")
        private double GameId;

        @JsonProperty("WinAmount")
        private double WinAmount;


        @JsonProperty("Balance")
        private double Balance;

        @JsonProperty("CurrencyId")
        private String CurrencyId;

        @JsonProperty("Status")
        private int Status;

        @JsonProperty("ResponseCode")
        private int ResponseCode;

        @JsonProperty("Info")
        private Info Info;


        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Info {
            @JsonProperty("PlayerId")
            private int PlayerId;

            @JsonProperty("PositionRow")
            private int PositionRow;

            @JsonProperty("BetAmount")
            private double BetAmount;

            @JsonProperty("WinAmount")
            private double WinAmount;

            @JsonProperty("PositionColumn")
            private int PositionColumn;

            @JsonProperty("Board")
            private List<List<Double>> Board;

            @JsonProperty("Dimension")
            private Dimension Dimension;

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Dimension {

                @JsonProperty("Height")
                private int Height;

                @JsonProperty("Width")
                private int Width;

                @JsonProperty("Mines")
                private int Mines;

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

            public int getPlayerId() {
                return PlayerId;
            }

            public void setPlayerId(int playerId) {
                PlayerId = playerId;
            }

            public int getPositionRow() {
                return PositionRow;
            }

            public void setPositionRow(int positionRow) {
                PositionRow = positionRow;
            }

            public double getBetAmount() {
                return BetAmount;
            }

            public void setBetAmount(double betAmount) {
                BetAmount = betAmount;
            }

            public double getWinAmount() {
                return WinAmount;
            }

            public void setWinAmount(double winAmount) {
                WinAmount = winAmount;
            }

            public int getPositionColumn() {
                return PositionColumn;
            }

            public void setPositionColumn(int positionColumn) {
                PositionColumn = positionColumn;
            }

            public List<List<Double>> getBoard() {
                return Board;
            }

            public void setBoard(List<List<Double>> board) {
                Board = board;
            }

            public Iqsoft307_SocketMessage_CashOut_Response.R.Info.Dimension getDimension() {
                return Dimension;
            }

            public void setDimension(Iqsoft307_SocketMessage_CashOut_Response.R.Info.Dimension dimension) {
                Dimension = dimension;
            }
        }


        public int getClientId() {
            return ClientId;
        }

        public void setClientId(int clientId) {
            ClientId = clientId;
        }

        public double getCoefficient() {
            return Coefficient;
        }

        public void setCoefficient(double coefficient) {
            Coefficient = coefficient;
        }

        public double getGameId() {
            return GameId;
        }

        public void setGameId(double gameId) {
            GameId = gameId;
        }

        public double getWinAmount() {
            return WinAmount;
        }

        public void setWinAmount(double winAmount) {
            WinAmount = winAmount;
        }

        public double getBalance() {
            return Balance;
        }

        public void setBalance(double balance) {
            Balance = balance;
        }

        public String getCurrencyId() {
            return CurrencyId;
        }

        public void setCurrencyId(String currencyId) {
            CurrencyId = currencyId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int status) {
            Status = status;
        }

        public int getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(int responseCode) {
            ResponseCode = responseCode;
        }

        public Info getInfo() {
            return Info;
        }

        public void setInfo(Info info) {
            Info = info;
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
