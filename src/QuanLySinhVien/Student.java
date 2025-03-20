package QuanLySinhVien;

/**
 * @author Admin
 */
public class Student extends Person{
    private String maSV;
    private double diemTB;
    private String email;

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " maSV=" + maSV + "," +super.toString()+  "diemTB=" + diemTB + ", email=" + email + '}';
    }
    public  boolean checkHocBong(){
        return getDiemTB() >= 8.0;
    }
    
    
}
