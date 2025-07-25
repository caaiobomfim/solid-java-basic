package caaiobomfim.application.precondition;

public class BankAccount {

    protected float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(float balance) {
        this.balance = balance;
    }

    public void deposit(float amount){
        if (amount <= 0){
            throw new IllegalArgumentException("The deposit value must be positive");
        }
        this.balance = this.balance + amount;
    }

    public float getBalance(){
        return this.balance;
    }
}
