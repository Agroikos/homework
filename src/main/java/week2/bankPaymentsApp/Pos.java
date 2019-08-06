package week2.bankPaymentsApp;

public class Pos {
    private BankAccount[] bankAccounts;
    private int numOfAccounts;

    public void addKnownBankAccount (BankAccount account) {
        bankAccounts[numOfAccounts++] = account;
    }

    //not checking whether the payment can actually be made
    public String pay(double amount, Card card) {
        card.getLinkedBankAccount().withdrawMoney(amount);
        return "The amount spent is: " + amount;
    }

}
