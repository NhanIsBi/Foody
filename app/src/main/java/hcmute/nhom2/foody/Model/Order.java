package hcmute.nhom2.foody.Model;

import java.io.Serializable;

public class Order implements Serializable {

    private int ID;
    private int UserID;
    private Cart[] listCart;
    private  int status;

    public Order(int ID,int userID, Cart[] listCart, int status) {
        ID=ID;
        UserID = userID;
        this.listCart = listCart;
        this.status = status;
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

    public Cart[] getListCart() {
        return listCart;
    }

    public void setListCart(Cart[] listCart) {
        this.listCart = listCart;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
