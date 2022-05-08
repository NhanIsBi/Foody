package hcmute.nhom2.foody.Static;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Model.Cart;
import hcmute.nhom2.foody.Model.Database;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Order;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.Model.User;

public class StaticArg {
    public static Database database;
    public static User user;
    public static Food food;
    public static Order order;
    public static List<Cart> listCart = new ArrayList<>();
    public static Restaurant currentRes;
    public static boolean isNew = false;
}
