package systems.bitcoinSystem.models;

public class Investor {
    private String name;
    private Double moneyWallet = 0.0;
    private Double bitcoinWallet = 0.0;

    public void depositMoney(Double money) {
        this.moneyWallet += money;
    }

    public void withdrawMoney(Double money){
        this.moneyWallet -= money;
    }

    public void withdrawMoney(){
        this.moneyWallet = 0.0;
    }

    public void depositBitcoin(Double bitcoin) {
        this.bitcoinWallet += bitcoin;
    }

    public void withdrawBitcoin(Double bitcoin) {
        this.bitcoinWallet -= bitcoin;
    }

    public void withdrawBitcoin() {
        this.bitcoinWallet = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoneyWallet() {
        return moneyWallet;
    }

    public Double getBitcoinWallet() {
        return bitcoinWallet;
    }
}
