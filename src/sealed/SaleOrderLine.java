package sealed;

import java.math.BigDecimal;

//The normal sale order. Few fields for brevity
public record SaleOrderLine(String productName, int quantity, BigDecimal amount) implements OrderLine {
}
