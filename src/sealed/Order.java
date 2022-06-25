package sealed;

import java.util.List;

//Define the interface (anyone who implements OrderLine as a parameter)
public record Order(long id, List<OrderLine> lines) {
}
