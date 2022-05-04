package hcmute.nhom2.foody.Model;

import java.io.Serializable;

public class Cart implements Serializable {
    private int Id;
    private int UserId;
    private int FoodId;
    private int Amount;

    public Cart(int id, int userId, int foodId, int amount) {
        Id = id;
        UserId = userId;
        FoodId = foodId;
        Amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getFoodId() {
        return FoodId;
    }

    public void setFoodId(int foodId) {
        FoodId = foodId;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
