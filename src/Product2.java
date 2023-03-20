import java.util.ArrayList;
import java.util.List;

public class Product2 {
    private int ID;
    private String name;
    private double price;
    private double offer;
    private String dateOfAvailability;

    public Product2(int ID, String name, double price, double offer, String dateOfAvailability) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.offer = offer;
        this.dateOfAvailability = dateOfAvailability;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public String getDateOfAvailability() {
        return dateOfAvailability;
    }

    public void setDateOfAvailability(String dateOfAvailability) {
        this.dateOfAvailability = dateOfAvailability;
    }

    @Override
    public String toString() {
        return String.format("%-3d|%-20s|%-10.2f|%-10.2f|%-10s", ID, name, price, offer, dateOfAvailability);
    }

}

