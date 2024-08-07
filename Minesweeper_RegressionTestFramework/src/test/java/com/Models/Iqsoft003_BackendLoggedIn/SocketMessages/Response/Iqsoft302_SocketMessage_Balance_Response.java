package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft302_SocketMessage_Balance_Response {

    @JsonProperty("I")
    private String I;

    @JsonProperty("R")
    private R R ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class R {

        @JsonProperty("ResponseCode")
        private  int ResponseCode;

        @JsonProperty("ResponseObject")
        private ResponseObject ResponseObject ;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ResponseObject {

            @JsonProperty("Balance")
            private  double Balance;

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double balance) {
                Balance = balance;
            }
        }


        public int getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(int responseCode) {
            ResponseCode = responseCode;
        }

        public Iqsoft302_SocketMessage_Balance_Response.R.ResponseObject getResponseObject() {
            return ResponseObject;
        }

        public void setResponseObject(Iqsoft302_SocketMessage_Balance_Response.R.ResponseObject responseObject) {
            ResponseObject = responseObject;
        }
    }


    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public Iqsoft302_SocketMessage_Balance_Response.R getR() {
        return R;
    }

    public void setR(Iqsoft302_SocketMessage_Balance_Response.R r) {
        R = r;
    }
}
