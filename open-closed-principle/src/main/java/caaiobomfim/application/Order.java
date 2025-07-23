package caaiobomfim.application;

public class Order {

    private float amount;
    private DiscountInterface discount = null;

    public Order(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        if (this.discount != null){
            this.amount = this.discount.apply(this.amount);
        }
        return this.amount;
    }

    public void setDiscountInterface(DiscountInterface discount) {
        this.discount = discount;
    }
}
