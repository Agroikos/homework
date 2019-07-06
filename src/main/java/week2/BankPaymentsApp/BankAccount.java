package week2.BankPaymentsApp;

public class BankAccount {
    private String IBAN;
    private double balance;
    private Card[] attachedCardNumbers;
    int numberOfCards;

    //actual methods
    public void addMoney(double amount) {
        this.balance += amount;
    }

    public void withdrawMoney(double amount) {
        this.balance -= amount;
    }

    public void attachCard(String cardNumber) {
        attachedCardNumbers[numberOfCards++].setCardNumber(cardNumber);
    }

    //utility methods

    //constructors, overloaded
    public BankAccount() {
    }

    public BankAccount(String IBAN) {
        numberOfCards = 0;
        this.IBAN = IBAN;
    }

    public BankAccount(String IBAN, double balance, Card[] attachedCardNumbers) {
        numberOfCards = 0;

        this.IBAN = IBAN;
        this.balance = balance;
        this.attachedCardNumbers = attachedCardNumbers;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card[] getAttachedCardNumbers() {
        return attachedCardNumbers;
    }

    public void setAttachedCardNumbers(Card[] attachedCardNumbers) {
        this.attachedCardNumbers = attachedCardNumbers;
    }
}
