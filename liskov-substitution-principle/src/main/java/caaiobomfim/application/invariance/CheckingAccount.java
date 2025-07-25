package caaiobomfim.application.invariance;

public class CheckingAccount extends BankAccount{

    private final float overdraftLimit;

    public CheckingAccount(float balance, float overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withDraw(float amount){
        if (amount <= 0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo");
        }

        float availableBalance = this.balance + this.overdraftLimit;

        if (amount > availableBalance){
            throw new IllegalArgumentException("Saldo insuficiente e limite de cheque especial excedido");
        }

        this.balance = this.balance - amount;
    }
}
