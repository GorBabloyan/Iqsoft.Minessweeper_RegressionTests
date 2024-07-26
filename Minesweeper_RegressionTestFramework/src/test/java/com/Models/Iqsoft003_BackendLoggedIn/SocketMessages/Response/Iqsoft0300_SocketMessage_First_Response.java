package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft0300_SocketMessage_First_Response {


    public Iqsoft0300_SocketMessage_First_Response() {

    }

    @JsonProperty("C")
    private String C;

    @JsonProperty("S")
    private int S;
    @JsonProperty("R")
    private List<Object> R  = new ArrayList<>();


    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public List<Object> getR() {
        return R;
    }

    public void setR(List<Object> r) {
        R = r;
    }
}
