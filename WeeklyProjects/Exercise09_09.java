package WeeklyProjects;
public class Exercise09_09 {
    // Polygons as defined in exercise
    public static void main(String[] args) {
    RegularPolygon polygon1 = new RegularPolygon();
    RegularPolygon polygon2 = new RegularPolygon(6, 4);
    RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

    // Polygon 1 Display
    System.out.println("Polygon 1:");
    System.out.println("Perimeter: " + polygon1.getPerimeter());
    System.out.println("Area: " + polygon1.getArea());

    // Polygon 2 Display
    System.out.println("\nPolygon 2:");
    System.out.println("Perimeter: " + polygon2.getPerimeter());
    System.out.println("Area: " + polygon2.getArea());

    // Polygon 3 Display
    System.out.println("\nPolygon 3:");
    System.out.println("Perimeter: " + polygon3.getPerimeter());
    System.out.println("Area: " + polygon3.getArea());
  }
}

class RegularPolygon {
    // Private fields (#1-4)
    private int n = 3;           // number of sides
    private double side = 1;     // length of each side
    private double x = 0;        // x-coordinate of center
    private double y = 0;        // y-coordinate of center

    // No-arg constructor (#5)
    public RegularPolygon() {
    }

    // Constructor with n and side (#6)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor with n, side, x, y (#7)
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessors and mutators (#8)
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to get perimeter (#9)
    public double getPerimeter() {
        return n * side;
    }

    // Method to get area (#10)
    public double getArea() {
    return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}