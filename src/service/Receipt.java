package service;

import entity.Customer;
import entity.Mobile;

import java.util.Arrays;

public class Receipt {
    private Customer customer;
    private Mobile[] mobiles;
    private int mobileTotal;
    private int sum;
    private float calculator;

    public Receipt() {
    }

    public Receipt(Customer customer, Mobile[] mobiles, int mobileTotal) {
        this.customer = customer;
        this.mobiles = mobiles;
        this.mobileTotal = mobileTotal;
    }

    public float getCalculator() {
        return calculator;
    }

    public void setCalculator(float calculator) {
        this.calculator = calculator;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Mobile[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(Mobile[] mobiles) {
        this.mobiles = mobiles;
    }

    public int getMobileTotal() {
        return mobileTotal;
    }

    public void setMobileTotal(int mobileTotal) {
        this.mobileTotal = mobileTotal;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "customer=" + customer +
                ", mobiles=" + Arrays.toString(mobiles) +
                ", mobileTotal=" + mobileTotal +
                '}';
    }
}
