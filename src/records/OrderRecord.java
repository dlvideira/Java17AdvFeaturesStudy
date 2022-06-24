package records;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record OrderRecord(long id, String costumerName, LocalDateTime createdDate,
                          List<OrderLineRecord> orderlines) { //CANNOT extend, but can implement
    //In this case, orderLines is a modifiable list (List methods)
    //To prevent this and REALLY make an unmodifiable list of orderLines, we have to create our own Canonical Constructor
    public OrderRecord(long id, String costumerName, LocalDateTime createdDate, List<OrderLineRecord> orderlines) {
        //As always, we can validate data on initialization like
        //throw exception (not checked exceptions!!!) when receive a required field, createdDate after localDate.now() .....
        this.id = id;
        this.costumerName = costumerName;
        this.createdDate = createdDate;
        this.orderlines = List.copyOf(orderlines); //This create an unmodifiable list (all methods that modify it will throw a runtime exception [UnsuporttedOperationException])
    }

    /*
    //COMPACT CONSTRUCTOR (best practice)
    public OrderRecord { //we dont define the arguments, because its already on the record definition
        //do our validations here normally
        //in this case, we want to defend immutability of orderLines list, so we can assign the new immutable list of it
        orderlines = List.copyOf(orderlines); //now orderLines in this record is immuttable, like tthe other constructor
    }
    */

    //CREATING A BUILDER (nott 17 feature)

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String costumerName;
        private LocalDateTime createdDate;
        private List<OrderLineRecord> orderLineRecords = new ArrayList<>();

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder forCostumer(String costumerName) {
            this.costumerName = costumerName;
            return this;
        }

        public Builder atDateTime(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder addOrderLine(OrderLineRecord orderLine) {
            this.orderLineRecords.add(orderLine);
            return this;
        }

        public OrderRecord build() {
            return new OrderRecord(id, costumerName, createdDate, orderLineRecords);
        }
    }
}
