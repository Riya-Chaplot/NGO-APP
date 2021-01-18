package com.example.ngomanagementapp.Models;

public class OrdersModel {
    int orderImage;
    String soldItemName,orderprice1,orderNumber;

    public OrdersModel(int orderImage, String soldItemName, String orderprice1, String orderNumber) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.orderprice1 = orderprice1;
        this.orderNumber = orderNumber;
    }

    public OrdersModel() {

    }


    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getOrderprice1() {
        return orderprice1;
    }

    public void setOrderprice1(String orderprice1) {
        this.orderprice1 = orderprice1;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}


