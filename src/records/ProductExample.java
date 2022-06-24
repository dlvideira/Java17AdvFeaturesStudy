package records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.lang.String.format;

public class ProductExample {
    public static void main(String[] args) {
        var recProduct = new ProductRecord(0001l, "Product01", "First product");
        //Record 'getters'
        var productId = recProduct.id();
        var productName = recProduct.name();
        var productDesc = recProduct.description();
        System.out.println(format("Product: %s has the id: %s and description: %s", productName, productId, productDesc));

        //Record toString
        System.out.println(format("calling toString: %s", recProduct));
        System.out.println(format("calling record method: %s", recProduct.hasDescription()));

        System.out.println("=======================================================");

        var redProductWithoutName = new ProductRecord(1L, null, "First product");
        System.out.println(redProductWithoutName.name());

        //If we do a copy of the same object
        var redProductWithoutNameCp = new ProductRecord(redProductWithoutName.id(), redProductWithoutName.name(), redProductWithoutName.description());

        //toString dont call name(), it uses the field itself
        System.out.println(format("calling toString: %s", redProductWithoutName));
        System.out.println(format("calling toString: %s", redProductWithoutNameCp));

        //The copy of the instance is different, because itt read the field itself. REMEMBER THIS!
        System.out.println(redProductWithoutNameCp.equals(redProductWithoutName));

        System.out.println("=======================================================");

        //Lombok builder, it creates build 'steps' (methods) with the same name as record definition
        var orderLineWithBuilder = OrderLineRecord.builder()
                .product(recProduct)
                .price(new BigDecimal("19.80"))
                .quantity(6)
                .build();
        System.out.println(format("orderLine before wither method: %s", orderLineWithBuilder));

        //Using 'wither' method to change quantity
        var newOrderLine = orderLineWithBuilder.withQuantity(2);
        System.out.println(format("orderLine after wither method: %s", newOrderLine));

        //Using 'manual' builder (cleaner solution to know exactly wich fields we are filling)
        var orderWithBuilder = OrderRecord.builder()
                .withId(0001L)
                .forCostumer("Joao")
                .atDateTime(LocalDateTime.now())
                .addOrderLine(new OrderLineRecord(recProduct, 6, new BigDecimal("9.90")))
                .addOrderLine(orderLineWithBuilder)
                .build();

        System.out.println(orderWithBuilder);


        System.out.println("=======================================================");

    }
}
