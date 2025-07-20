package caaiobomfim.application;

public class OrderProcessorService {

    public void processOrder(Order order){
        this.checkInventory(order);
        this.calculateTotal(order);
        this.processPayment(order);
    }

    private void checkInventory(Order order){
        // LOGIC
    }
    private void calculateTotal(Order order){
        // LOGIC
    }
    private void processPayment(Order order){
        // LOGIC
    }
}
