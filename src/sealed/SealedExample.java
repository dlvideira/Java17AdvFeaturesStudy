package sealed;

import java.math.BigDecimal;
import java.util.List;

import static sealed.OrderService.*;

public class SealedExample {
    public static void main(String[] args) {
        var order = new Order(2L, List.of(
                new SaleOrderLine("Product from Sale", 1, new BigDecimal("5.99")),
                new DiscountOrderLine("Discount code", new BigDecimal("2.00"))
        ));
        System.out.printf("Total amount after calculation: %s", calculateTotalAmount(order));
    }
}
