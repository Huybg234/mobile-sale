import entity.Customer;
import entity.Mobile;
import service.Receipt;

import java.util.Scanner;

public class MainRun {
    private static int countCustomer;
    private static Customer[] customers;
    private static Mobile[] mobiles;
    public static Receipt[] receipts;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewCustomer();
                    displayCustomer();
                    break;
                case 2:
                    createNewMobile();
                    displayMobile();
                    break;
                case 3:
                    receiptList();
                    break;
                case 4:
                    sortreceiptList();
                    break;
                case 5:
                    calculatorReceipt();
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);
    }

    private static void calculatorReceipt() {
        for (int i=0; i< receipts.length;i++){
            System.out.println("Tính hóa đơn cho khách hàng "+receipts[i].getCustomer().getName());
            System.out.println(receipts[i].getCalculator());
        }
    }

    private static void sortreceiptList() {
        if (receipts == null || receipts.length ==0){
            System.out.println("Bạn cần nhập danh sách mua hàng trước khi sắp xếp: ");
            return;
        }
        do {
            int sortChoice;
            System.out.println("---------- SẮP XẾP DANH SÁCH MUA BÁN ---------");
            System.out.println("1. Theo tên khách hàng.");
            System.out.println("2. Theo số lượng điện thoại đặt mua.");
            System.out.println("3. Thoát chức năng sắp xếp.");
            System.out.print("Xin mời chọn chức năng: ");
            do {
                sortChoice = new Scanner(System.in).nextInt();
                if (sortChoice >= 1 && sortChoice <= 3) {
                    break;
                }
                System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
            } while (true);
            switch (sortChoice) {
                case 1:
                    sortByCustomerName();
                    break;
                case 2:
                    sortByCountMobile();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void sortByCountMobile() {
        for (int i=0; i< receipts.length; i++){
            for (int j = i+1; j< receipts.length; j++){
                if (receipts[i].getSum()<receipts[j].getSum()){
                    Receipt tmp = receipts[i];
                    receipts[i] = receipts[j];
                    receipts[j] = tmp;
                }
            }
        }
        for (Receipt receipt : receipts) {
            System.out.println(receipt);
        }
    }

    private static void sortByCustomerName() {
        for (int i=0; i < receipts.length; i++){
            for (int j=i+1; j<receipts.length; j++){
                if (receipts[i].getCustomer().getName().compareTo(receipts[j].getCustomer().getName()) > 0){
                    Receipt temp = receipts[i];
                    receipts[i] = receipts[j];
                    receipts[j] = temp;
                }
            }
        }
        for (Receipt receipt : receipts) {
            System.out.println(receipt);
        }
    }

    private static boolean isValidCustomerAndMobile() {
        return customers != null && mobiles != null && customers.length > 0 && mobiles.length > 0;
    }

    private static void receiptList() {
        if (!isValidCustomerAndMobile()) {
            System.out.println("Bạn cần nhập danh sách khách hàng và điện thoại trước khi thống kê!");
            return;
        }
        boolean checked = true;
        receipts = new Receipt[countCustomer];
        int sum;
        float price, sumPrice;
        for (int i=0; i<customers.length;i++){
            sum = 0;
            price = 0;
            sumPrice =0;
            System.out.println("Nhập số loại điện thoại mà khách hàng "+customers[i].getName()+" muốn mua: ");
            int k;
            do {
                k = new Scanner(System.in).nextInt();
                if (k < 0 || k > mobiles.length) {
                    System.out.println("nhập lại! số lượng loại điện thoại lớn hơn 0 và nhỏ hơn tổng số loại điện thoại");
                    checked = false;
                }
            } while (!checked);
            Mobile[] mobileList = new Mobile[k];
            int mobileTotal = 0;
            for (int j=0; j < k; j++){
                System.out.println("Nhập id loại điện thoại thứ "+(j+1)+" mà khách hàng "+customers[i].getName()+" muốn mượn");
                int tempId;
                do {
                    tempId = new Scanner(System.in).nextInt();
                    Mobile mobile =  searchBook(tempId);
                    if (mobile != null){
                        System.out.println("Nhập số lượng điện thoại của loại "+mobile.getManufacturer()+" :");
                        do {
                            mobileTotal = new Scanner(System.in).nextInt();
                            if (mobileTotal <= 0) {
                                System.out.println("Số lượng điện thoại muốn mua phải lớn hơn 0! Nhập lại:");
                                checked = false;
                            }
                        } while (!checked);
                        price = mobileTotal * mobiles[j].getUnitPrice();
                        sum += mobileTotal;
                        mobileList[j] = mobile;
                        break;
                    }
                    System.out.print("Không có điện thoại nào có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);
            }
            sumPrice += price;
            Receipt receipt = new Receipt(customers[i],mobileList,mobileTotal);
            receipts[i] = receipt;
            receipts[i].setSum(sum);
            receipts[i].setCalculator(sumPrice);
        }
        System.out.println("Danh sách thống kê mua hàng của khách hàng hiện tại là:");
        for (Receipt receipt: receipts) {
            System.out.println(receipt);
        }
    }

    private static Mobile searchBook(int tempId) {
        for (Mobile mobile: mobiles) {
            if (mobile.getId() == tempId) {
                return mobile;
            }
        }
        return null;
    }

    private static void displayMobile() {
        for (Mobile mobile : mobiles) {
            System.out.println(mobile);
        }
    }

    private static void createNewMobile() {
        System.out.println("Nhập số lượng điện thoại muốn thêm: ");
        int countMobile = new Scanner(System.in).nextInt();
        mobiles = new Mobile[countMobile];
        for (int i = 0; i < mobiles.length; i++) {
            Mobile mobile = new Mobile();
            mobile.inputMobileInfo();
            mobiles[i] = mobile;
        }
    }

    private static void displayCustomer() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void createNewCustomer() {
        System.out.println("Nhập số lượng khách hàng muốn thêm: ");
        countCustomer = new Scanner(System.in).nextInt();
        customers = new Customer[countCustomer];
        for (int i = 0; i < customers.length; i++) {
            Customer customer = new Customer();
            customer.inputInfo();
            customers[i] = customer;
        }
    }

    private static int functionChoice() {
        System.out.println("--------Quản lý danh sách mua điện thoại cho mỗi khách hàng--------");
        System.out.println("1.Nhập danh sách khách hàng");
        System.out.println("2.Nhập danh sách sản phẩm di động");
        System.out.println("3.Quản lý danh sách mua hàng");
        System.out.println("4.Sắp xếp danh sách quản lý mua hàng");
        System.out.println("5.Thống kê tổng số tiền phải trả cho mỗi khách hàng");
        System.out.println("6.Thoát");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }
}
