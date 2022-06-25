package sealed;

//We define the classes or record that can implement this interface,
// after that, it is mandatory that those classes implements the interface
public sealed interface OrderLine permits SaleOrderLine, DiscountOrderLine {
}
