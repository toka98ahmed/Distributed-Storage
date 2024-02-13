package Balancer;

import java.io.Serializable;

public class Item implements Serializable {

    int id;
    String type;
    double size;

    public Item(int id, String type, double size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", type=" + type + ", size=" + size + '}';
    }

}
