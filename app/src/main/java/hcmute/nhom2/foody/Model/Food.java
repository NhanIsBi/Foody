package hcmute.nhom2.foody.Model;

import java.io.Serializable;

public class Food implements Serializable {

    private int Id;
    private  int ResId;
    private String name;
    private Double price;
    private byte[] image;


    public Food(int id, int resId, String name, Double price, byte[] image) {
        Id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        ResId = resId;
    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getResId() {
        return ResId;
    }

    public void setResId(int resId) {
        ResId = resId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

}
