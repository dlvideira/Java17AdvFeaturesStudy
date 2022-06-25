package sealed;

import java.math.BigDecimal;

//Only 2 fields in our business model (code and value to discount)
public record DiscountOrderLine(String discountCode, BigDecimal amount) implements OrderLine {
}
