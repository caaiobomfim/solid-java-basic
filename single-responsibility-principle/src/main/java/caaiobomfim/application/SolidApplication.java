package caaiobomfim.application;

public class SolidApplication {
    public static void main(String[] args) {
        Order order = new Order("ba1aef0d-4ccb-489c-90b5-cb7664a53c2d", 500);
        InventoryChecker inventoryChecker = new InventoryChecker();
        OrderCalculator orderCalculator = new OrderCalculator();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        OrderProcessorService orderProcessorService = new OrderProcessorService(
                inventoryChecker,
                orderCalculator,
                paymentProcessor
        );

        orderProcessorService.processOrder(order);
    }
}