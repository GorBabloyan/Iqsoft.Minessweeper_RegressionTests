package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft200_SocketMessage_WithoutArguments_Request {

    //       {"H":"basehub","M":"Authorized","A":[],"I":0}

    public Iqsoft200_SocketMessage_WithoutArguments_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<Object>  A = new ArrayList<>();

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

    public List<Object> getA() {
        return A;
    }

    public void setA(List<Object> a) {
        A = a;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }
}
