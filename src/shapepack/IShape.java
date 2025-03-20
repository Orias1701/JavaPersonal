package shapepack;

public interface IShape {
    double getArea();
    double getPerimeter();
    void printDetails();

    default void print() {
        System.out.println("This is a default method in IShape interface");
    }
}
