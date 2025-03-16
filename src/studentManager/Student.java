package studentManager;

import java.util.Scanner;

public class Student extends Person {

    private int maSV;
    private double diemTB;
    private String email;

    public int maSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void nhapThongTin() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap ma sinh vien: ");
            maSV = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap ten: ");
            setName(sc.nextLine());
            System.out.println("Nhap gioi tinh: ");
            setGender(sc.nextLine());
            System.out.println("Nhap dia chi: ");
            setAddress(sc.nextLine());
            System.out.println("Nhap ngay sinh: ");
            setBirth(sc.nextLine());
            System.out.println("Nhap diem trung binh: ");
            diemTB = sc.nextDouble();
            sc.nextLine();
            System.out.println("Nhap email: ");
            email = sc.nextLine();
        }
    }

    public void xuatThongTin() {
        System.out.println("Ma sinh vien: " + maSV);
        System.out.println("Ten: " + getName());
        System.out.println("Gioi tinh: " + getGender());
        System.out.println("Dia chi: " + getAddress());
        System.out.println("Ngay sinh: " + getBirth());
        System.out.println("Diem trung binh: " + diemTB);
        System.out.println("Email: " + email);
    }
}
