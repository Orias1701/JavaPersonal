package qlyTaiLieu;

import java.util.ArrayList;
import java.util.Comparator;

public class QuanLySach {

    private final ArrayList<TaiLieu> DanhSach;

    public QuanLySach() {
        DanhSach = new ArrayList<>();
    }

    public QuanLySach(ArrayList<TaiLieu> danhSach) {
        DanhSach = danhSach;
    }

    public void ThemTaiLieu(TaiLieu TL) {
        this.DanhSach.add(TL);
    }

    // Delete
    public void xoaTaiLieu(String maTaiLieu) {
        boolean daXoa = false;

        for (int i = 0; i < DanhSach.size(); i++) {
            if (DanhSach.get(i).getMaTaiLieu().equals(maTaiLieu)) {
                DanhSach.remove(i);
                daXoa = true;
                System.out.println("Da xoa tai lieu voi ma: " + maTaiLieu);
                break;
            }
        }

        if (!daXoa) {
            System.out.println("Khong tim thay ma can xoa: " + maTaiLieu);
        }
    }

    // Display
    public void hienThiTaiLieu() {
        if (DanhSach.isEmpty()) {
            System.out.println("Danh sach tai lieu trong.");
            return;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-15s\n", "Ma TL", "Nha xuat ban", "So ban", "Loai tai lieu");
        System.out.println("--------------------------------------------------------------");

        for (TaiLieu taiLieu : DanhSach) {
            switch (taiLieu) {
                case TL_Sach sach -> System.out.printf("%-10s %-20s %-10d %-15s\n", sach.getMaTaiLieu(),
                        sach.tenNhaXuatBan, sach.soBanPhatHanh, "Sach");
                case TL_TapChi tapChi -> System.out.printf("%-10s %-20s %-10d %-15s\n", tapChi.getMaTaiLieu(),
                        tapChi.tenNhaXuatBan, tapChi.soBanPhatHanh, "Tap Chi");
                case TL_Bao bao -> System.out.printf("%-10s %-20s %-10d %-15s\n", bao.getMaTaiLieu(), bao.tenNhaXuatBan,
                        bao.soBanPhatHanh, "Bao");
                default -> throw new IllegalStateException("Unexpected value: " + taiLieu);
            }
        }

        System.out.println("--------------------------------------------------------------");
    }

    // Search
    public void timKiemTaiLieu(int loai) {
        ArrayList<TaiLieu> danhSachLoc = new ArrayList<>();

        for (TaiLieu taiLieu : DanhSach) {
            if ((loai == 1 && taiLieu instanceof TL_Sach) ||
                    (loai == 2 && taiLieu instanceof TL_TapChi) ||
                    (loai == 3 && taiLieu instanceof TL_Bao)) {
                danhSachLoc.add(taiLieu);
            }
        }

        if (danhSachLoc.isEmpty()) {
            System.out.println("Không tìm thấy thể loại này.");
            return;
        }

        danhSachLoc.sort(Comparator.comparing(TaiLieu::getMaTaiLieu));

        for (TaiLieu taiLieu : danhSachLoc) {
            taiLieu.hienThiThongTin();
        }
    }

}
