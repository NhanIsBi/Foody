package hcmute.nhom2.foody;

import java.io.Serializable;

public class Food implements Serializable {

    public static final int TYPE_FOOD=1;
    public static final int TYPE_DRINK=2;

    private int image;
    private String name;
    private String price;
    private  int type;

    public Food(int image, String name,String price, int type) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
