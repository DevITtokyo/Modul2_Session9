package lms.exercise1;

import java.util.Scanner;

public class Square implements Resizeable {
    private double side;
    private double area;
    private double perimeter;
    public Square() {
    }
    public Square(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return side*side;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getPerimeter() {
        return side*4;
    }
    public void input(Scanner scanner){
        System.out.println("Nhập vào cạnh của hình vuông");
        this.side=Double.parseDouble(scanner.nextLine());
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    public void display(){
        System.out.printf("Diện tích hình vuông là : %f",getArea());
        System.out.printf("Chu vi hình vuông là : %f",getPerimeter());
    }
    public void resize(double percent) {
        side *= (1 + percent / 100);
    }
}
