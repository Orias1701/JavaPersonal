package QuanLySinhVien;

/**
 * @author Admin
 */
public class Person {
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private String gioiTinh;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "ten=" + ten + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh;
    }
    
    
    
}
