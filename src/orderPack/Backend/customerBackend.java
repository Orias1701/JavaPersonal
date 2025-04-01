package orderPack.Backend;

import java.sql.*;
import java.util.ArrayList;

public class customerBackend {
    private static final String URL = "jdbc:mysql://localhost:3306/customer";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Đổi theo cài đặt của bạn
    private Connection conn;

    public customerBackend() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối MySQL thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    // Lấy tất cả khách hàng
    public ArrayList<String[]> getAllCustomers() {
        ArrayList<String[]> customers = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customers")) {
            while (rs.next()) {
                customers.add(new String[]{
                        rs.getString("ID"),
                        rs.getString("Customer_ID"),
                        rs.getString("Customer_Name"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Birthday")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Thêm khách hàng
    public void addCustomer(String customerID, String customerName, String email, String phone, String birthday) {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO Customers (Customer_ID, Customer_Name, Email, Phone, Birthday) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, customerID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, birthday);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sửa thông tin khách hàng
    public void updateCustomer(int id, String customerID, String customerName, String email, String phone, String birthday) {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE Customers SET Customer_ID=?, Customer_Name=?, Email=?, Phone=?, Birthday=? WHERE ID=?")) {
            pstmt.setString(1, customerID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, birthday);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa khách hàng
    public void deleteCustomer(int id) {
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Customers WHERE ID=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
