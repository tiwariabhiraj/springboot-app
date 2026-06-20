package AOP_Package;


import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void placeOrder() {
        System.out.println("Order placed successfully");
    }

    public void orderList() {
        System.out.println("<<<<<<<<<<<<<<Enter in order Service>>>>>>>>>>>>>>>>>>");
        System.out.println("Order get List find successfully");
    }

    public void cancelOrder() {
        System.out.println("Order cancelled");
    }
}