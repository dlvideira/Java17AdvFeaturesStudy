package records;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderLineRecord(ProductRecord product, int quantity, BigDecimal price) {

    //The problem with wither methods is that we are creating various objects in heap
    //and for some cases, like lists, we have to create a copy of the list we already have, then add the new item and finally
    //the constructor itself creates a immutable list (see orderRecord constructor).
    //3 copies of lists in the heap, just for a simple addition in a List
    public OrderLineRecord withQuantity(int quantity) {
        return new OrderLineRecord(this.product, quantity, this.price);
    }
}