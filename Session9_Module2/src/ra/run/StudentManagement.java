package ra.run;

import ra.impl.Student;

import java.util.Scanner;

public class StudentManagement {
    static Student[] arrStudent = new Student[1000];// Toàn cục
    static int numberStudent = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("*************************** MENU *************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Tính trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chon của bạn là: ");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.printf("-------------------------------\n");
            switch (choice){
                case 1:
                    StudentManagement.inputListStudent(scanner);
                    break;
                case 2:
                    StudentManagement.calGPA();
                    break;
                case 3:
                    StudentManagement.calReview();
                    break;
                case 4:
                    StudentManagement.calStatus();
                    break;
                case 5:
                    StudentManagement.displayListStudent();
                    break;
                case 6:
                     StudentManagement.sortByAvgMarkASC();
                    break;
                case 7:
                    StudentManagement.searchStudentName(scanner);
                    break;
                case 8:
                    StudentManagement.statisticByRate();
                    break;
                case 9:
                    StudentManagement.statisticByStatus();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-10");
            }

        }while(true);

    }
    // 1. Phương thức nhập thông tin sinh viên
    public static void inputListStudent(Scanner scanner){
        System.out.print("Nhập vào số sinh viên cần nhập thông tin : ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i+1) + " : ");
            arrStudent[numberStudent] = new Student();
            arrStudent[numberStudent].inputData(scanner, arrStudent, numberStudent);
            numberStudent++;
            System.out.printf("-------------------------------\n");
        }
    }
    // 2. Phương thức tính điểm trung bình
    public static void calGPA (){
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calAvgMark();
        }
        System.out.println("Đã tính xong điểm trung bình tất cả sinh viên");
        System.out.printf("-------------------------------\n");
    }
    // 3. Phương thức đánh giá và xếp loại các sinh viên
    public static void calReview (){
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calRateStudent();
        }
        System.out.println("Đã đánh giá và xếp loại tất cả sinh viên");
        System.out.printf("-------------------------------\n");
    }
    // 4. Phương thức tính trạng thái của sinh viên
    public static void calStatus (){
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calStatusStudent();
        }
        System.out.println("Đã tính xong trạng thái của sinh viên");
        System.out.printf("-------------------------------\n");
    }
    // 5. In thông tin sinh viên
    public static void displayListStudent(){
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].displayData();
            System.out.printf("+++++++++++++++++++++++++++++\n");
        }
    }
    // 6. Phương thức sắp xếp sinh viên tăng dần theo điểm trung bình
    public static void sortByAvgMarkASC(){
        for (int i = 0; i < numberStudent-1; i++) {
            for (int j = i+1; j < numberStudent; j++) {
                if (arrStudent[i].getAvgMark() > arrStudent[j].getAvgMark()){
                    Student temp = arrStudent[i];
                    arrStudent[i] = arrStudent[j];
                    arrStudent[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong sinh viên tăng dần theo điểm trung bình");
    }
    // 7. Tìm kiếm sinh viên theo tên
    public static void searchStudentName(Scanner scanner){
        System.out.print("Nhập vào tên sinh viên cần tìm kiếm : ");
        String searchName = scanner.nextLine();
        boolean isNameExist = false;
        for (int i = 0; i < numberStudent; i++) {
            if (arrStudent[i].getStudentName().toLowerCase().contains(searchName.toLowerCase())){
                arrStudent[i].displayData();
                isNameExist = true;
            }
        }
        if (!isNameExist){
            System.err.println("Không tìm thấy sinh viên nào tên " + searchName);
        }
    }
    // 8. Thống kê sinh viên theo xếp loại
    public static void statisticByRate(){
        // Sử dụng 1 mảng để đếm số lượng sinh viên theo từng xếp loại
        int[] classifyNumber = new int[5]; // Yếu, Trung bình, Khá, Giỏi, Xuất Sắc
        for (int i = 0; i < numberStudent; i++) {
            Student student = arrStudent[i];
            // Chuỗi lưu trữ xếp loại sinh viên được trả về từ phương thức getRate()
            String rate = student.getRate();
            // Kiểm tra giá trị của biến rate để xác định xếp loại của sinh viên và tăng giá trị của phần tử tương ứng trong mảng
            if (rate.equals("Yếu")){
                classifyNumber[0]++;
            } else if (rate.equals("Trung bình")) {
                classifyNumber[1]++;
            }else if (rate.equals("Khá")) {
                classifyNumber[2]++;
            }else if (rate.equals("Giỏi")) {
                classifyNumber[3]++;
            }else if (rate.equals("Xuất sắc")) {
                classifyNumber[4]++;
            }
        }
        // In thống kê
        System.out.println("Thống kê sinh viên theo xếp loại");
        System.out.println("Yếu : " + classifyNumber[0]);
        System.out.println("Trung bình : " + classifyNumber[1]);
        System.out.println("Khá : " + classifyNumber[2]);
        System.out.println("Giỏi : " + classifyNumber[3]);
        System.out.println("Xuất sắc : " + classifyNumber[4]);
    }
    // 9. Thống kê sinh viên theo trạng thái
    public static void statisticByStatus(){
        int passNumber = 0;
        int failNumber = 0;
        for (int i = 0; i < numberStudent; i++) {
            Student student = arrStudent[i];
            // Chuỗi lưu trạng thái của sinh viên được trả về từ phương thức getStatus()
            String status = student.getStatus();
            // Kiểm tra giá trị của biến status để xác định trạng thái của sinh viên và tăng giá trị tương ứng
            if (status.equals("PASS")){
                passNumber++;
            }else if (status.equals("FAIL")){
                failNumber++;
            }
        }
        System.out.println("Thống kê sinh viên theo trạng thái: ");
        System.out.println("PASS : " + passNumber);
        System.out.println("FAIL : " + failNumber);
    }
}
