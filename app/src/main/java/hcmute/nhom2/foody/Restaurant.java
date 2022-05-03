package hcmute.nhom2.foody;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private int Id;
    private byte[] image;
    private String name;

    public Restaurant(int id, String name, byte[] image) {
        Id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
