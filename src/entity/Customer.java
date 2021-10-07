package entity;

import java.util.Scanner;

public class Customer extends Person{
    private int id;
    private String customerType;

    private final static String RETAIL = "Mua lẻ";
    private final static String BUY_WHOLESALE = "Mua buôn";
    private final static String BUY_ONLINE ="Mua online";

    private static int AUTO_ID = 10000;

    public Customer() {
    }

    public Customer(int id, String customerType) {
        this.id = id;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public static String getRETAIL() {
        return RETAIL;
    }

    public static String getBuyWholesale() {
        return BUY_WHOLESALE;
    }

    public static String getBuyOnline() {
        return BUY_ONLINE;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputInfo(){
        this.setId(Customer.AUTO_ID);
        super.inputInfo();
        System.out.println("Nhập loại khách hàng: ");
        System.out.println("1.Mua lẻ");
        System.out.println("2.Mua buôn");
        System.out.println("3.Mua online");
        boolean check = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            if (choice <= 0 || choice > 3) {
                System.out.print("Nhập số từ 1 đến 3! Nhập lại: ");
                check = false;
                continue;
            }
            switch (choice) {
                case 1:
                    this.setCustomerType(Customer.RETAIL);
                    System.out.println("Mua lẻ");
                    check = true;
                    break;
                case 2:
                    this.setCustomerType(Customer.BUY_WHOLESALE);
                    System.out.println("Mua buôn");
                    check = true;
                    break;
                case 3:
                    this.setCustomerType(Customer.BUY_ONLINE);
                    System.out.println("Mua online");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 3!");
                    check = false;
                    break;
            }
        } while (!check);
        Customer.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
