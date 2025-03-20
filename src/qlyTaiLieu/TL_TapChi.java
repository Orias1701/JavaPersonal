package qlyTaiLieu;

public class TL_TapChi extends TaiLieu {
    private final int soPhatHanh;
    private final int thangPhatHanh;

    public TL_TapChi(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Tap chi - Ma: " + maTaiLieu + ", NXB: " + tenNhaXuatBan + ", So ban: " + soBanPhatHanh
                + ", So phat hanh: " + soPhatHanh + ", Thang phat hanh: " + thangPhatHanh);
    }

}
