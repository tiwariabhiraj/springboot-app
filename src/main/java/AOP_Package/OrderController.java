package AOP_Package;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String placeOrder() {
        orderService.placeOrder();
        return "Done";
    }

    @GetMapping("/get-order")
    public String placeGetOrder() {
        orderService.orderList();
        return "Done";
    }
}