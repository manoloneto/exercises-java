package systems.bitcoinSystem;

import systems.bitcoinSystem.models.Investor;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class BitcoinSystem {

    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat formatter = new DecimalFormat("#.##");

    private static double bitcoinPrice;
    private static int bitcoinValueCounter;
    private static int bitcoinDevalueCounter;
    private static Investor investor;

    public static void main(String[] args) {

        bitcoinPrice = 14000.00;
        bitcoinValueCounter = 0;
        bitcoinDevalueCounter = 0;

        investor = new Investor();

        System.out.print("Type your name: ");
        investor.setName(in.next());

        System.out.print("Type your first investment: ");
        investor.depositMoney(in.nextDouble());

        setupSchedule();

    }

    private static void setupSchedule() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {

                        updateBitcoinPrice();

                        if (bitcoinValueCounter == 3) {
                            showSellMenu();
                        } else if (bitcoinDevalueCounter == 3) {
                            showBuyMenu();
                        }

                        if (investor != null) {
                            System.out.println("...");
                            setupSchedule();
                        }
                    }
                },
                3000
        );
    }

    private static void updateBitcoinPrice() {
        if (isBitcoinValued()) valueBitcoin();
        else devalueBitcoin();

        System.out.println("The new bitcoin price is: $ " + formatter.format(bitcoinPrice));
    }

    private static void showBuyMenu() {
        int option = 0;
        do {

            System.out.print("1 - Buy bitcoin;\n2 - Exit system;\n3 - Cancel;\nType your option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    buyBitcoin();
                    break;

                case 2:
                    exitSystem();
                    break;
            }

        } while (option != 1 && option != 2 && option != 3);
    }

    private static void buyBitcoin() {
        System.out.print("How much money do you want to buy in bitcoins? ");
        double money = in.nextDouble();

        if (investor.getMoneyWallet() >= money) {
            investor.withdrawMoney(money);
            investor.depositBitcoin(money / bitcoinPrice);
            investorBalance();
        } else {
            System.out.println("You have no money to this...");
        }
    }

    private static void showSellMenu() {
        int option = 0;
        do {

            System.out.print("1 - Sell bitcoin;\n2 - Exit system;\n3 - Cancel;\nType your option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    sellBitcoin();
                    break;

                case 2:
                    exitSystem();
                    break;
            }

        } while (option != 1 && option != 2 && option != 3);
    }

    private static void sellBitcoin() {
        System.out.print("How much bitcoin do you want to sell? ");
        double bitcoin = in.nextDouble();

        if (investor.getBitcoinWallet() >= bitcoin) {
            investor.withdrawBitcoin(bitcoin);
            investor.depositMoney(bitcoin * bitcoinPrice);
            investorBalance();
        } else {
            System.out.println("You have no bitcoin to this...");
        }
    }

    private static void exitSystem() {
        if (investor.getBitcoinWallet() > 0) {
            investor.depositMoney(investor.getBitcoinWallet() * bitcoinPrice);
            investor.withdrawBitcoin();
        }

        investorBalance();

        investor = null;
    }

    private static void investorBalance() {
        System.out.println(investor.getName());
        System.out.println("Money balance: $ " + formatter.format(investor.getMoneyWallet()));
        System.out.println("Bitcoin balance: $ " + formatter.format(investor.getBitcoinWallet()));
    }

    private static boolean isBitcoinValued() {
        Random random = new Random();
        return random.nextInt(2) == 1;
    }

    private static double bitcoinVariant() {
        Random random = new Random();
        double variant = random.nextInt(100) + 1;
        return variant * 0.0001;
    }

    private static void devalueBitcoin() {
        double devalue = bitcoinVariant();
        double devaluePrice = bitcoinPrice * devalue;
        bitcoinPrice -= devaluePrice;
        bitcoinValueCounter = 0;
        bitcoinDevalueCounter++;

        System.out.println("The bitcoin price devalue $ " + formatter.format(devaluePrice));
    }

    private static void valueBitcoin() {
        double value = bitcoinVariant();
        double valuePrice = bitcoinPrice * value;
        bitcoinPrice += valuePrice;
        bitcoinDevalueCounter = 0;
        bitcoinValueCounter++;

        System.out.println("The bitcoin price value $ " + formatter.format(valuePrice));
    }

}
