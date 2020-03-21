package systems.geometricCalculations.models;

public class GeometricForm {
    private double a;
    private double b;
    private double c;

    public GeometricForm(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double triangleArea() {
        return (a * b) / 2;
    }

    public double circleArea() {
        return Math.PI * (c * c);
    }

    public double squareArea() {
        return b * b;
    }

    public double rectangleArea() {
        return a * b;
    }

    public double cubeArea() {
        return c * c;
    }

    public double trapezeArea() {
        return (a + b) * c;
    }

}
