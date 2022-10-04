package abstractClass;

public class Rectangle extends Figure implements ISides {

    int length;
    int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double diagonal() {
        return Math.sqrt(length * length + width * width);
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "length=" + length + ", width=" + width + '}';
    }

    public static void main(String[] args) {
        Figure f = new Rectangle(6, 4);
        System.out.println(f instanceof Rectangle);
        System.out.println(f instanceof Figure);
        System.out.println(f instanceof ISides);
        System.out.println(f instanceof Object);
        System.out.println(f instanceof Circle);
        f = new Circle(7);
        Rectangle r = new Rectangle(0, 0);
        
        System.out.println();
        System.out.println(f instanceof Rectangle);
        System.out.println(f instanceof Figure);
        System.out.println(f instanceof ISides);
        System.out.println(f instanceof Object);
        System.out.println(f instanceof Circle);
        ISides is = new Rectangle(7, 6);
        System.out.println();
        System.out.println(is instanceof Rectangle);
        System.out.println(is instanceof Figure);
        System.out.println(is instanceof ISides);
        System.out.println(is instanceof Object);
        System.out.println(is instanceof Circle);
        
    }

    @Override
    public int sides() {
        return 4;
    }
}
