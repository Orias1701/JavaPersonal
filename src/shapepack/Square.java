package shapepack;

public class Square implements IShape {
    private double side;

    public double getSide() {
        return side;
    }

    @Override
    public double getPerimeter() {
        return 4 * getSide();
    }

    @Override
    public double getArea() {
        return getSide() * getSide();
    }

    @Override
    public void printDetails() {
        System.out.println("Square: side = " + getSide());
    }
}
