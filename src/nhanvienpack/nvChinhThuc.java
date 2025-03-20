package nhanvienpack;

public class nvChinhThuc extends NhanVien {
    private double luongCB;
    private double heSoLuong;

    public double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double tinhLuong() {
        return getLuongCB() * getHeSoLuong();
    }
}
