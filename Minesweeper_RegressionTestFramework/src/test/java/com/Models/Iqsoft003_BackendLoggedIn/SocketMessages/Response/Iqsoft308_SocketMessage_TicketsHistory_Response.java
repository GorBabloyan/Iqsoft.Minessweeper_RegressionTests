package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import cucumber.api.java.eo.Do;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft308_SocketMessage_TicketsHistory_Response {

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class R {


        @JsonProperty("ResponseCode")
        private int ResponseCode;

        @JsonProperty("ResponseObject")
        private ResponseObject ResponseObject;


        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ResponseObject {
            @JsonProperty("GameId")
            private int GameId;

            @JsonProperty("ClientId")
            private int ClientId;

            @JsonProperty("BetsCount")
            private int BetsCount;

            @JsonProperty("Tickets")
            private List<Tickets> Tickets;


            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Tickets {

                @JsonProperty("RoundId")
                private long RoundId;

                @JsonProperty("TicketPrice")
                private double TicketPrice;

                @JsonProperty("WinAmount")
                private double WinAmount;

                @JsonProperty("TicketDate")
                private String TicketDate;

                @JsonProperty("Outcome")
                private Outcome Outcome;

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class Outcome {

                    @JsonProperty("Board")
                    private List<List<Double>> Board;

                    @JsonProperty("Salt")
                    private String Salt;

                    @JsonProperty("Hash")
                    private String Hash;

                    @JsonProperty("PositionRow")
                    private int PositionRow;

                    @JsonProperty("PositionColumn")
                    private int PositionColumn;

                    @JsonProperty("Key")
                    private String Key;

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


                    public List<List<Double>> getBoard() {
                        return Board;
                    }

                    public void setBoard(List<List<Double>> board) {
                        Board = board;
                    }

                    public String getSalt() {
                        return Salt;
                    }

                    public void setSalt(String salt) {
                        Salt = salt;
                    }

                    public String getHash() {
                        return Hash;
                    }

                    public void setHash(String hash) {
                        Hash = hash;
                    }

                    public int getPositionRow() {
                        return PositionRow;
                    }

                    public void setPositionRow(int positionRow) {
                        PositionRow = positionRow;
                    }

                    public int getPositionColumn() {
                        return PositionColumn;
                    }

                    public void setPositionColumn(int positionColumn) {
                        PositionColumn = positionColumn;
                    }

                    public String getKey() {
                        return Key;
                    }

                    public void setKey(String key) {
                        Key = key;
                    }

                    public Dimension getDimension() {
                        return Dimension;
                    }

                    public void setDimension(Dimension dimension) {
                        Dimension = dimension;
                    }
                }


                public long getRoundId() {
                    return RoundId;
                }

                public void setRoundId(long roundId) {
                    RoundId = roundId;
                }

                public double getTicketPrice() {
                    return TicketPrice;
                }

                public void setTicketPrice(double ticketPrice) {
                    TicketPrice = ticketPrice;
                }

                public double getWinAmount() {
                    return WinAmount;
                }

                public void setWinAmount(double winAmount) {
                    WinAmount = winAmount;
                }

                public String getTicketDate() {
                    return TicketDate;
                }

                public void setTicketDate(String ticketDate) {
                    TicketDate = ticketDate;
                }

                public Outcome getOutcome() {
                    return Outcome;
                }

                public void setOutcome(Outcome outcome) {
                    Outcome = outcome;
                }
            }

            public int getGameId() {
                return GameId;
            }

            public void setGameId(int gameId) {
                GameId = gameId;
            }

            public int getClientId() {
                return ClientId;
            }

            public void setClientId(int clientId) {
                ClientId = clientId;
            }

            public int getBetsCount() {
                return BetsCount;
            }

            public void setBetsCount(int betsCount) {
                BetsCount = betsCount;
            }

            public List<Tickets> getTickets() {
                return Tickets;
            }

            public void setTickets(List<Tickets> tickets) {
                Tickets = tickets;
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
