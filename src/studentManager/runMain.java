package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class runMain extends Student {

    public static void main(String[] args) {
        ArrayList<Student> ListSV = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap so luong sinh vien: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Student sv = new Student();
                sv.nhapThongTin();
                ListSV.add(sv);
            }

            System.out.println("\nDanh sach sinh vien:");
            for (int i = 0; i < ListSV.size(); i++) {
                System.out.println("Thong tin sinh vien thu " + (i + 1) + ":");
                ListSV.get(i).xuatThongTin();
                System.out.println("-------------------");
            }
        }
    }
}
