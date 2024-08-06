package com.Models.Iqsoft003_BackendLoggedIn.SocketMessages.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Iqsoft205_SocketMessage_TicketsHistory_Request {

    public Iqsoft205_SocketMessage_TicketsHistory_Request() {

    }

    @JsonProperty("H")
    private String H;

    @JsonProperty("M")
    private String M;

    @JsonProperty("A")
    private List<A> A ;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class A {

        @JsonProperty("FromDate")
        private String FromDate;

        @JsonProperty("ToDate")
        private String ToDate;

        @JsonProperty("PageNumber")
        private int PageNumber;

        @JsonProperty("ItemsPerPage")
        private int ItemsPerPage;

        public String getFromDate() {
            return FromDate;
        }

        public void setFromDate(String fromDate) {
            FromDate = fromDate;
        }

        public String getToDate() {
            return ToDate;
        }

        public void setToDate(String toDate) {
            ToDate = toDate;
        }

        public int getPageNumber() {
            return PageNumber;
        }

        public void setPageNumber(int pageNumber) {
            PageNumber = pageNumber;
        }

        public int getItemsPerPage() {
            return ItemsPerPage;
        }

        public void setItemsPerPage(int itemsPerPage) {
            ItemsPerPage = itemsPerPage;
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
