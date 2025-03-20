package qlyTaiLieu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            QuanLySach quanLySach = new QuanLySach();
            boolean flag = true;

            do {
                System.out.println("\n--- Quan ly tai lieu ---");
                System.out.println("1. Them tai lieu");
                System.out.println("2. Xoa tai lieu voi ma");
                System.out.println("3. Hien thi danh sach tai lieu");
                System.out.println("4. Tim kiem tai lieu theo loai");
                System.out.println("5. Thoat");
                System.out.print("Chon chuc nang: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Chon loai tai lieu (1-Sach, 2-Tap chi, 3-TL_Bao): ");
                        int type = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhap ma: ");
                        String ma = scanner.nextLine();
                        System.out.print("Nhap ten nxb: ");
                        String nxb = scanner.nextLine();
                        System.out.print("Nhap so ban phat hanh: ");
                        int soBan = scanner.nextInt();
                        scanner.nextLine();

                        switch (type) {
                            case 1 -> {
                                System.out.print("Nhap ten tac gia: ");
                                String tacGia = scanner.nextLine();
                                System.out.print("Nhap so trang: ");
                                int soTrang = scanner.nextInt();
                                scanner.nextLine();
                                quanLySach.ThemTaiLieu(new TL_Sach(ma, nxb, soBan, tacGia, soTrang));
                            }
                            case 2 -> {
                                System.out.print("Nhap so phat hanh: ");
                                int soPhatHanh = scanner.nextInt();
                                System.out.print("Nhap thang phat hanh: ");
                                int thang = scanner.nextInt();
                                scanner.nextLine();
                                quanLySach.ThemTaiLieu(new TL_TapChi(ma, nxb, soBan, soPhatHanh, thang));
                            }
                            default -> {
                                System.out.print("Nhap ngay phat hanh: ");
                                String ngay = scanner.nextLine();
                                quanLySach.ThemTaiLieu(new TL_Bao(ma, nxb, soBan, ngay));
                            }
                        }
                    }
                    case 2 -> {
                        System.out.print("Nhap tai lieu can xoa: ");
                        String maXoa = scanner.nextLine();
                        quanLySach.xoaTaiLieu(maXoa);
                    }
                    case 3 -> quanLySach.hienThiTaiLieu();
                    case 4 -> {
                        System.out.println("Chọn tai lieu can tim:");
                        System.out.println("1 - Sach");
                        System.out.println("2 - Tap chi");
                        System.out.println("3 - TL_Bao");
                        System.out.print("Nhap lua chon: ");

                        int loai = scanner.nextInt();
                        scanner.nextLine();

                        quanLySach.timKiemTaiLieu(loai);
                    }
                    case 5 -> flag = false;
                    default -> {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Lua chon khong hop le. Hay chon lai!");
                    }
                }
            } while (flag);
        }
    }
}
