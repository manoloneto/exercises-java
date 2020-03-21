package systems.carSale.models;

public class Car {
    private double price;

    public Car(double price){
        this.price = price;
    }

    public double finalPrice(){
        double profit = this.price * 0.2;
        double taxes = this.price * 0.45;
        double publicity = this.price * 0.08;

        return this.price + profit + taxes + publicity;
    }
}
