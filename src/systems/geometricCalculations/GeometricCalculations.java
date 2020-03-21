package systems.geometricCalculations;

import systems.geometricCalculations.models.GeometricForm;

import java.util.Scanner;

public class GeometricCalculations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        print("Digite um valor para A, B e C");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        GeometricForm geometricForm = new GeometricForm(a, b, c);
        print("Área do Triangulo: " + geometricForm.triangleArea());
        print("Área do Circulo: " + geometricForm.circleArea());
        print("Área do Cubo: " + geometricForm.cubeArea());
        print("Área do Quadrado: " + geometricForm.squareArea());
        print("Área do Retangulo: " + geometricForm.rectangleArea());
        print("Área do Trapezio: " + geometricForm.trapezeArea());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
