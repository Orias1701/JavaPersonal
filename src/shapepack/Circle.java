package shapepack;

public class Circle implements IShape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public void printDetails() {
        System.out.println("Circle: radius = " + getRadius() + ", perimeter = " + getPerimeter() + ", area = " + getArea());
    }
}
