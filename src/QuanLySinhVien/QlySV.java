package QuanLySinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Admin
 */
public class QlySV {
    private final List<Student> listSV;

    public QlySV() {
        listSV = new ArrayList<>();
    }
    public void nhapSV(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap So Luong Sinh Vien: ");
            int N = sc.nextInt();
            sc.nextLine();
            for(int i=0; i<N; i++){
                Student sv = new Student();
                System.out.println("Nhap ma: ");
                sv.setMaSV(sc.nextLine());
                System.out.println("Nhap ten: ");
                sv.setTen(sc.nextLine());
                System.out.println("Nhap dia chi");
                sv.setDiaChi(sc.nextLine());
                System.out.println("Nhap ngay sinh");
                sv.setNgaySinh(sc.nextLine());
                System.out.println("Nhap gioi tinh");
                sv.setGioiTinh(sc.nextLine());
                System.out.println("Nhap diem TB: ");
                sv.setDiemTB(sc.nextDouble());
                sc.nextLine();
                System.out.println("Nhap email: ");
                sv.setEmail(sc.nextLine());
                listSV.add(sv);
            }
        }
    }
    public void hienThi(){
        for(Student x: listSV){
            System.out.println(x.toString());
        }
    }
    public void xetHocBong(){
        List<Student> listHB = new ArrayList<>();
        int count =0;
        for(Student x: listSV){
            if(x.checkHocBong()==true){
                count++;
                listHB.add(x);
            }
        }
        if(count==0){
            System.out.println("Khong co sinh vien dat hoc bong!");
        }
        else{
            for(Student x: listHB){
                System.out.println(x.toString());
            }
        }
        
    }
    
    
    
    
}
