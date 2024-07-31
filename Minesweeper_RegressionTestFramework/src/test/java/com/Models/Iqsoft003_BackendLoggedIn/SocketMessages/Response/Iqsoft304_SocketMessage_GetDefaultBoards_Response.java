package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft304_SocketMessage_GetDefaultBoards_Response {

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
