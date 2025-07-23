package caaiobomfim.application;

public class SolidApplication {
    public static void main(String[] args) {
        Order order1 = new Order(200);
        order1.setDiscountInterface(new FixedDiscount(10));
        System.out.println("FIXED DISCOUNT: " + order1.getAmount());

        Order order2 = new Order(200);
        order2.setDiscountInterface(new PercentageDiscount(25));
        System.out.println("PERCENTAGE DISCOUNT: " + order2.getAmount());
    }
}