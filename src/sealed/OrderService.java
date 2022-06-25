package sealed;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class OrderService {
    public static BigDecimal calculateTotalAmount(Order order) {
        var total = ZERO;
        //Pattern matching is a preview feature in 17, will do an enhanced for instead
        for (OrderLine line : order.lines()) {
            if (line instanceof SaleOrderLine sale) {
                total = total.add(sale.amount());
            } else if (line instanceof DiscountOrderLine discount) {
                total = total.subtract(discount.amount());
            }
        }
        return total;
    }
}
