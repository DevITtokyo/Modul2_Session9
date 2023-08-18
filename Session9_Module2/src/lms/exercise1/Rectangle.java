package lms.exercise1;

import java.util.Scanner;

public class Rectangle implements Resizeable {
    private double width;
    private double height;
    private double area;
    private double perimeter;
    public Rectangle() {
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea() {
        return this.getWidth()*this.getHeight();
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getPerimeter() {
        return (this.width+this.height)*2;
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    public void input(Scanner scanner){
        System.out.println("Nhập vào chiều dài hình chữ nhật : ");
        this.width = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập vào chiều rộng hình chữ nhật: ");
        this.height = Double.parseDouble(scanner.nextLine());
    }
    public void display(){
        System.out.printf("Diên tích hình chữ nhật là : %f\n",getArea());
        System.out.printf("Chu vi hình chữ nhật là : %f\n",getPerimeter());
    }

    @Override
    public void resize(double percent) {
        width *=(1 + percent / 100);
        height *=(1 + percent / 100);
    }
}
