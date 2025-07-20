package caaiobomfim.application;

public class OrderProcessorService {

    private final InventoryChecker inventoryChecker;
    private final OrderCalculator orderCalculator;
    private final PaymentProcessor paymentProcessor;

    public OrderProcessorService(InventoryChecker inventoryChecker,
                                 OrderCalculator orderCalculator,
                                 PaymentProcessor paymentProcessor) {
        this.inventoryChecker = inventoryChecker;
        this.orderCalculator = orderCalculator;
        this.paymentProcessor = paymentProcessor;
    }

    public void processOrder(Order order){
        this.inventoryChecker.check(order);
        this.orderCalculator.calculate(order);
        this.paymentProcessor.processPayment(order);
    }
}
