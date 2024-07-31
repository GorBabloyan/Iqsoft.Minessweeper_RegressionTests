package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft204_SocketMessage_Cashout_Request {

    public Iqsoft204_SocketMessage_Cashout_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<A> A ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class A {

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
