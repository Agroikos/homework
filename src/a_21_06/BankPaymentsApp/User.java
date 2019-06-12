package a_21_06.BankPaymentsApp;

public class User {
    private int numOfCards;
    private Card [] cards;

    private int numOfAccounts;
    private BankAccount [] accounts;


    //actual class methods
    public void addCard(Card card) {
        this.cards[numOfCards++] = card;
    }

    public void addBankAccount (BankAccount account) {
        this.accounts[numOfAccounts++] = account;
    }

    //utility methods

    //constructors
    public User() {
    }

    public User(Card[] cards, BankAccount account) {
        this.numOfCards = 0;
        this.numOfAccounts = 0;
        this.cards = cards;
        this.accounts[numOfAccounts++] = account;
    }

    //getters and setters
    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public BankAccount [] getAccount() {
        return accounts;
    }

    public void setAccount(BankAccount[] accounts) {
        //this.account[numOfAccounts++] = account;
        this.accounts = accounts;
    }
}
