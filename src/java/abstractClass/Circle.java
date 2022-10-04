/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractClass;

/**
 *
 * @author ASUS
 */
public  class Circle extends Figure {

    int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public double area() {
        return r * r * Math.PI;
    }
public double perimeter()
{
    return 2*Math.PI*r;
}
    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }

    public static void main(String args[]) {

    
    }


  
}
