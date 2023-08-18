package lms.exercise1;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************MENU************");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Exist");
        System.out.print("Sự lụa chọn của bạn là : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.err.println("Vui lòng chọn từ 1-4");
        }
    }
}
