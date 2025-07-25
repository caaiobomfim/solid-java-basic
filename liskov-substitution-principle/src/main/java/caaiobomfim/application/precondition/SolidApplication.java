package caaiobomfim.application.precondition;

public class SolidApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new SavingsAccount();
        bankAccount.deposit(5);
        System.out.println(bankAccount.getBalance());
    }
}