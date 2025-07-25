package caaiobomfim.application.invariance;

public class BankAccount {

    protected float balance;

    public BankAccount(float balance) {
        this.balance = 0;
    }

    public void withDraw(float amount){
        if (amount <= 0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo");
        }
        if (amount > this.balance){
            throw new IllegalArgumentException("Saldo insuficiente. O saldo não pode ficar negativo");
        }
        this.balance = this.balance - amount;
    }

    public float getBalance() {
        return balance;
    }
}
