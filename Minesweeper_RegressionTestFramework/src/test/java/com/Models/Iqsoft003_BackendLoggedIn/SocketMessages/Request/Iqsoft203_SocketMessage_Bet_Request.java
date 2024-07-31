package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft203_SocketMessage_Bet_Request {

    //       {"H":"basehub","M":"Authorized","A":[],"I":0}

    public Iqsoft203_SocketMessage_Bet_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<A>  A ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class A {

        @JsonProperty("Row")
        private int Row;
        @JsonProperty("Column")
        private int Column;

        public int getRow() {
            return Row;
        }

        public void setRow(int row) {
            Row = row;
        }

        public int getColumn() {
            return Column;
        }

        public void setColumn(int column) {
            Column = column;
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
