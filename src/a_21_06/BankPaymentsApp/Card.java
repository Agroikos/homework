package a_21_06.BankPaymentsApp;

public class Card {

    private String expirationDate;
    private String ownerName;
    private String cardNumber;
    private BankAccount linkedBankAccount;

    public Card() {
    }

    public Card(String expirationDate, String ownerName, String cardNumber, BankAccount bankAccount) {
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.linkedBankAccount = bankAccount;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BankAccount getLinkedBankAccount() {
        return linkedBankAccount;
    }

    public void setLinkedBankAccount(BankAccount linkedBankAccount) {
        this.linkedBankAccount = linkedBankAccount;
    }
}
