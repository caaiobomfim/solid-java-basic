package caaiobomfim.application;

public class PercentageDiscount implements DiscountInterface{

    private float percentage;

    public PercentageDiscount(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public float apply(float orderAmount) {
        if (percentage > 100 || percentage <= 0){
            throw new IllegalArgumentException("The percentage value must be between 1% and 100%");
        }
        return orderAmount - (orderAmount * this.percentage / 100);
    }
}
