package hcmute.nhom2.foody.Model;

import java.io.Serializable;

public class Order implements Serializable {

    private int ID;
    private int UserID;
    private int ResID;
    private  int status;
    private  Double priceTotal;

    public Order(int ID, int userID, int resID, int status, Double priceTotal) {
        this.ID = ID;
        UserID = userID;
        ResID = resID;
        this.status = status;
        this.priceTotal = priceTotal;
    }

    public Order(int ID, int userID, int status) {
        ID=ID;
        UserID = userID;
        this.status = status;
    }

    public int getResID() {
        return ResID;
    }

    public void setResID(int resID) {
        ResID = resID;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
