public class Triangle extends GeometricObject {

    // Data fields, default value = 1.0
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // No-arg constructor
    public Triangle() {
    }

    // Constructors for sides of triangles
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }

    // getArea method
    public double getArea() {
        double s = getPerimeter() / 2; 
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side2));
    }

    // toString method
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Formula to get the area of the triangle
    public String toString() {
        return "Triangle: side1 = " + side1
             + " side2 = " + side2
             + " side3 = " + side3;
    }
}
