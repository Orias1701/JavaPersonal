package qlyTaiLieu;

public class TL_Sach extends TaiLieu {
    private final String TacGia;
    private final int soTrang;

    public TL_Sach(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, String TacGia, int soTrang) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.TacGia = TacGia;
        this.soTrang = soTrang;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Sach - ma: " + maTaiLieu + ", NXB: " + tenNhaXuatBan + ", So ban: " + soBanPhatHanh
                + ", Tac gia: " + TacGia + ", So trang: " + soTrang);
    }

}
