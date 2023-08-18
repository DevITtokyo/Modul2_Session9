package ra.entity;

import ra.impl.Student;

import java.util.Scanner;

public interface IStudent {
    // Hằng số
    public final int MARK_PASS = 5;

    // Các phương thức trừu tượng

    void inputData(Scanner scanner, Student[] arrStudent, int numberStudent);

    void displayData();
    void calAvgMark();

}
