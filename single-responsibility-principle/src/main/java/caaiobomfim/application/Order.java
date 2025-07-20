package caaiobomfim.application;

public class Order {

    private final String uuid;
    private final float amount;

    public Order(String uuid, float amount) {
        this.uuid = uuid;
        this.amount = amount;
    }

    public String getUuid() {
        return uuid;
    }

    public float getAmount() {
        return amount;
    }
}
