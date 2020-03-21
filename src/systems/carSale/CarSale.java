package systems.carSale;

import systems.carSale.models.Car;

import java.util.Scanner;

public class CarSale {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o valor do carro: ");
        double price = in.nextDouble();

        Car car = new Car(price);

        System.out.println("O valor final do carro é: " + car.finalPrice());
    }
}
