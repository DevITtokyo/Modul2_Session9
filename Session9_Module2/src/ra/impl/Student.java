package ra.impl;

import ra.entity.IStudent;

import java.util.Scanner;

public class Student implements IStudent {

    // Khai báo thuộc tính
    private String studentId;
    private String studentName;
    private int age;
    private float htmlScore;
    private float cssScore;
    private float jsScore;
    private float avgMark;
    private boolean sex;
    private String rate;
    private String status;

    // Getter
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public int getAge() {
        return age;
    }
    public float getHtmlScore() {
        return htmlScore;
    }
    public float getCssScore() {
        return cssScore;
    }
    public float getJsScore() {
        return jsScore;
    }
    public float getAvgMark() {
        return avgMark;
    }
    public boolean isSex() {
        return sex;
    }
    public String getRate() {
        return rate;
    }
    public String getStatus() {
        return status;
    }

    // Setter
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }
    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }
    public void setJsScore(float jsScore) {
        this.jsScore = jsScore;
    }
    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Constructor
    public Student() {
    }

    public Student(String studentId, String studentName, int age, float htmlScore, float cssScore, float jsScore, float avgMark, boolean sex, String rate, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.jsScore = jsScore;
        this.avgMark = avgMark;
        this.sex = sex;
        this.rate = rate;
        this.status = status;
        calAvgMark();
        calRateStudent();
        calStatusStudent();
    }

    // Xây dựng lớp Student kế thừa IStudent trong package
    // Abstract Methods
    @Override
    public void inputData(Scanner scanner, Student[] arrStudent, int numberStudent) {
        // 1. StudentId: Duy nhất, không trùng lặp và gồm 4 ký tự bắt đầu là “SV”
        System.out.print("Nhập vào mã sinh viên : ");
        boolean checkStudentId = true;
        do {
            this.studentId = scanner.nextLine();
            boolean isStudentIdExist = false;
            for (int i = 0; i < numberStudent; i++) {
                if (arrStudent[i].studentId.equals(this.studentId)){
                    isStudentIdExist = true;
                    break;
                }
            }
            if (isStudentIdExist){
                // Mã sinh viên bị trùng
                System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
            }else {
                // Mã sinh viên k bị trùng lặp
                // Kiểm tra độ dài mã sinh viên = 4
                if (this.studentId.length() == 4){
                    if (this.studentId.startsWith("SV")){
                        break;
                    }else {
                        System.err.println("Mã sinh viên bắt đầu là SV, vui lòng nhập lại");
                    }
                }else {
                    System.err.println("Mã sinh viên gồm 4 ký tự, vui lòng nhập lại");
                }
            }

        }while (checkStudentId);
        // 2. studentName: gồm 6-50 ký tụ
        System.out.print("Nhập vào tên sinh viên : ");
        boolean checkStudentName = true;
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length()>=6 && this.studentName.length()<=50){
                break;
            }else {
                System.err.println("Tên sinh viên gồm 6-50 ký tự, vui lòng nhập lại");
            }
        }while (checkStudentName);
        // 3. age : Có giá trị lớn hơn hoặc bằng 18
        System.out.print("Nhập vào tuổi sinh viên : ");
        boolean checkAge = true;
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age>=18){
                break;
            }else {
                System.err.println("Tuổi của sinh viên phải lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }
        }while (checkAge);
        // 4. Điểm html, css, js có giá trị trong khoảng 0-10
        // 4.1 html
        System.out.print("Nhập điểm html : ");
        boolean checkHtml = true;
        do {
            this.htmlScore=Float.parseFloat(scanner.nextLine());
            if (this.htmlScore>=0 && this.htmlScore<=10){
                break;
            }else {
                System.err.println("Điểm HTML giá trị trong khoảng 0-10, vui lòng nhập lại");
            }
        }while (checkHtml);
        // 4.2 css
        System.out.print("Nhập điểm css : ");
        boolean checkCss = true;
        do {
            this.cssScore=Float.parseFloat(scanner.nextLine());
            if (this.cssScore>=0 && this.cssScore<=10){
                break;
            }else {
                System.err.println("Điểm CSS giá trị trong khoảng 0-10, vui lòng nhập lại");
            }
        }while (checkCss);
        // 4.3 javascript
        System.out.print("Nhập điểm javascript : ");
        boolean checkJavascript = true;
        do {
            this.jsScore=Float.parseFloat(scanner.nextLine());
            if (this.jsScore>=0 && this.jsScore<=10){
                break;
            }else {
                System.err.println("Điểm Javascript giá trị trong khoảng 0-10, vui lòng nhập lại");
            }
        }while (checkJavascript);
        // 5. Sex
        System.out.print("Nhập giới tính của sinh viên (true: nam ; false : nữ) : ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
    }
    @Override
    public void displayData() {
        String sexDisplay = (this.sex) ? "Nam" : "Nữ";
        System.out.printf("Mã sinh viên : %s - Tên sinh viên : %s - Tuối : %d - Giới tính : %s \n", this.studentId, this.studentName, this.age, sexDisplay);
        System.out.printf("HTML : %.1f - CSS : %.1f - Javascript : %.1f - Avg Score : %.1f \n", this.htmlScore, this.cssScore, this.jsScore, this.avgMark);
        System.out.printf("Xếp loại : %s - Trạng thái : %s \n",this.rate, this.status);
    }
    @Override
    public void calAvgMark() {
        this.avgMark = (this.htmlScore + this.cssScore + this.jsScore)/3;
    }

    // Phương thức xếp loại sinh viên
    public void calRateStudent(){
        if (this.avgMark>=0 && this.avgMark<5){
            this.rate = "Yếu";
        } else if (this.avgMark>=5 && this.avgMark<7) {
            this.rate = "Trung bình";
        } else if (this.avgMark>=7 && this.avgMark<8){
            this.rate = "Khá";
        } else if (this.avgMark>=8 && this.avgMark<9){
            this.rate = "Giỏi";
        }else if (this.avgMark>=9 && this.avgMark<=10){
            this.rate = "Xuất sắc";
        }else {
            System.err.println("Không xác định");
        }
    }

    // Phương thức tính trạng thái sinh viên
    public void calStatusStudent(){
        if (this.avgMark>=MARK_PASS){
            this.status = "PASS";
        } else {
            this.status = "FAIL";
        }
    }
}
