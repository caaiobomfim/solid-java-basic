package caaiobomfim.application;

public class FixedDiscount implements DiscountInterface{

    private float value;

    public FixedDiscount(float value) {
        this.value = value;
    }

    @Override
    public float apply(float orderAmount) {
        if (this.value > orderAmount){
            throw new IllegalArgumentException("The discount cannot exceed the order value");
        }
        return orderAmount - this.value;
    }
}
