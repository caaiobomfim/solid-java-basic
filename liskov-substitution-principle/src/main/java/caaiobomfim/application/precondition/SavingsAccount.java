package caaiobomfim.application.precondition;

public class SavingsAccount extends BankAccount{

    @Override
    public void deposit(float amount){
        if (amount < 10) {
            throw new IllegalArgumentException("The minimum deposit for a savings account is R$10.00");
        }
        super.deposit(amount);
    }
}
