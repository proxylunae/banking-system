package application;

public class Account {
    private long cardNumber;
    private String cardPin;
    private long balance;

    public Account(long cardNumber, String cardPin, long balance) {
        this.cardNumber = cardNumber;
        this.cardPin = new String(cardPin);
        this.balance = balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
