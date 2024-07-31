package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft201_SocketMessage_State_Request {

    //       {"H":"basehub","M":"Authorized","A":[],"I":0}

    public Iqsoft201_SocketMessage_State_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<Integer>  A = new ArrayList<>();

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

    public List<Integer> getA() {
        return A;
    }

    public void setA(List<Integer> a) {
        A = a;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }
}
