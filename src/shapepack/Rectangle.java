package shapepack;

public class Rectangle implements IShape {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public void printDetails() {
        System.out.println("Rectangle: length = " + getLength() + ", width = " + getWidth());
    }
}
