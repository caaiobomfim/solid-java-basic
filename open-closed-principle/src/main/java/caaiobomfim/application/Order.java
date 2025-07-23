package caaiobomfim.application;

public class Order {

    private float amount;

    public Order(float amount) {
        this.amount = amount;
    }

    public void applyFixedDiscount(float discount){
        if (discount > this.amount){
            throw new IllegalArgumentException("The discount cannot exceed the order value");
        }
        this.amount = this.amount - discount;
    }

    public void applyPercentageDiscount(float percentage){
        if (percentage > 100 || percentage <= 0){
            throw new IllegalArgumentException("The percentage value must be between 1% and 100%");
        }
        this.amount = this.amount - (this.amount * percentage / 100);
    }

    public float getAmount() {
        return this.amount;
    }
}
