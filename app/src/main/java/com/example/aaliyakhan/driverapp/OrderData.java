package com.example.aaliyakhan.driverapp;

/**
 * Created by AaliyaKhan on 27-05-2019.
 */

public class OrderData {
   private String customername,to;

    public String getCustomername() {
        return customername;
    }


    public String getTo() {
        return to;
    }

    public OrderData(String customername, String to) {
        this.customername = customername;
        this.to = to;
    }

}
