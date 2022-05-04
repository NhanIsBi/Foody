package hcmute.nhom2.foody.Model;

import java.io.Serializable;

public class Order implements Serializable {
    private int UserID;
    private Cart[] listCart;
    private  int status;

    public Order(int userID, Cart[] listCart, int status) {
        UserID = userID;
        this.listCart = listCart;
        this.status = status;
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
