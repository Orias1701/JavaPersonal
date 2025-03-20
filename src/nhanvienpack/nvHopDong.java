package nhanvienpack;

public class nvHopDong extends NhanVien {
    private int soNgayCong;
    private double luongNgay;

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public double getLuongNgay() {
        return luongNgay;
    }

    public void setLuongNgay(double luongNgay) {
        this.luongNgay = luongNgay;
    }

    @Override
    public double tinhLuong() {
        return getSoNgayCong() * getLuongNgay();
    }
}
