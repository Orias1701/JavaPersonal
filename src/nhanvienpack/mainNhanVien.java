package nhanvienpack;
import java.util.ArrayList;
import java.util.Scanner;

public class mainNhanVien {
    public static void main(String[] args) {
        ArrayList<NhanVien> listChinhThuc = new ArrayList<>();
        ArrayList<NhanVien> listHopDong = new ArrayList<>();
        int n;
        System.out.print("Nhap so luong nhan vien: ");
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ":");
                System.out.print("Nhap ma nhan vien: ");
                String maNhanVien = scanner.next();
                System.out.print("Nhap ten nhan vien: ");
                String tenNhanVien = scanner.next();
                System.out.print("Nhap loai nhan vien (1 - Nhan vien chinh thuc, 2 - Nhan vien hop dong): ");
                int loaiNhanVien = scanner.nextInt();
                switch (loaiNhanVien) {
                    case 1 -> {
                        nvChinhThuc nhanVien = new nvChinhThuc();
                        nhanVien.setMaNhanVien(maNhanVien);
                        nhanVien.setTenNhanVien(tenNhanVien);
                        System.out.print("Nhap luong co ban: ");
                        double luongCB = scanner.nextDouble();
                        nhanVien.setLuongCB(luongCB);
                        System.out.print("Nhap he so luong: ");
                        double heSoLuong = scanner.nextDouble();
                        nhanVien.setHeSoLuong(heSoLuong);
                        listChinhThuc.add(nhanVien);
                        nhanVien.tinhLuong();
                        System.out.println("Luong: " + nhanVien.tinhLuong());
                    }
                    case 2 -> {
                        nvHopDong nhanVien = new nvHopDong();
                        nhanVien.setMaNhanVien(maNhanVien);
                        nhanVien.setTenNhanVien(tenNhanVien);
                        System.out.print("Nhap so ngay cong: ");
                        int soNgayCong = scanner.nextInt();
                        nhanVien.setSoNgayCong(soNgayCong);
                        System.out.print("Nhap luong ngay: ");
                        double luongNgay = scanner.nextDouble();
                        nhanVien.setLuongNgay(luongNgay);
                        listHopDong.add(nhanVien);
                        nhanVien.tinhLuong();
                        System.out.println("Luong: " + nhanVien.tinhLuong());
                    }
                    default -> System.out.println("Loai nhan vien khong hop le.");
                }
            }
        }
        System.out.println("Danh sach nhan vien chinh thuc:");
        for (NhanVien nhanVien : listChinhThuc) {
            System.out.println(nhanVien.toString());
        }
        System.out.println("Danh sach nhan vien hop dong:");
        for (NhanVien nhanVien : listHopDong) {
            System.out.println(nhanVien.toString());
        }
    }
}







