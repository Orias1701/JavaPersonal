package qlyTaiLieu;

public class TL_Bao extends TaiLieu {
    private final String ngayPhatHanh;

    public TL_Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("TL_Bao - Ma: " + maTaiLieu + ", NXB: " + tenNhaXuatBan + ", So ban: " + soBanPhatHanh
                + ", Ngay phat hanh: " + ngayPhatHanh);
    }
}
