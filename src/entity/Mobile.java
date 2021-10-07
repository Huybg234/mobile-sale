package entity;

import java.util.Scanner;

public class Mobile {
    private int id;
    private String manufacturer;
    private String model;
    private float unitPrice;

    private static int AUTO_ID = 10000;

    public Mobile() {
    }

    public Mobile(int id, String manufacturer, String model, float unitPrice) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputMobileInfo(){
        this.setId(Mobile.AUTO_ID);
        System.out.println("Nhập hãng sản xuất: ");
        this.manufacturer = new Scanner(System.in).nextLine();
        System.out.println("Nhập model: ");
        this.model = new Scanner(System.in).nextLine();
        System.out.println("Nhập đơn giá: ");
        this.unitPrice = new Scanner(System.in).nextInt();
        Mobile.AUTO_ID++;
    }
    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
