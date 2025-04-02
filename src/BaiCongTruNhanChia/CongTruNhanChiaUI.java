/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiCongTruNhanChia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Admin
 */
public class CongTruNhanChiaUI extends JFrame{
    JButton btnGiai, btnXoa, btnThoat;
    JTextField txt_a, txt_b, txt_kq;
    JRadioButton radCong, radTru, radNhan, radChia;
    public CongTruNhanChiaUI(String title) throws HeadlessException {
        super(title);
        addControl();
        addEvent();
    }
    public void addEvent(){
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_a.setText("");
                txt_b.setText("");
                txt_kq.setText("");
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkThoat();
            }
        });
        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giai();
            }
        });
       
    }
    protected void checkThoat(){
        int chon=JOptionPane.showConfirmDialog(null,"Xác nhận thoát?"
                , "Thông báo", JOptionPane.YES_NO_OPTION);
        
        if(chon==JOptionPane.YES_OPTION){
            System.exit(0);
        }       
        
    }
    protected boolean isNumber(JTextField txt){
        if(Integer.parseInt(txt.getText())>=0 ||Integer.parseInt(txt.getText())<0){
            return true;
        }
        else
            return false;
    }
    protected  void giai(){
        if(isNumber(txt_a)&&isNumber(txt_b)){
            int a = Integer.parseInt(txt_a.getText());
            int b = Integer.parseInt(txt_b.getText());
            if(radChia.isSelected()){
                float kq = (float)a/b;
                txt_kq.setText(kq+"");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ");
        }
        
    }
   
    
    public void addControl(){
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        JPanel pnXuLy = new JPanel();
        pnXuLy.setLayout(new GridLayout(3, 1, 10, 5));
        pnXuLy.setPreferredSize(new Dimension(150, 0));
        btnGiai = new JButton("Giải");
        btnThoat = new JButton("Thoát");
        btnXoa = new JButton("Xóa");
        pnXuLy.add(btnGiai);
        pnXuLy.add(btnXoa);
        pnXuLy.add(btnThoat);
        Border borderXuLy = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titleXuLy = BorderFactory.createTitledBorder(borderXuLy, "Chọn tác vụ");
        titleXuLy.setTitleJustification(TitledBorder.CENTER);
        pnXuLy.setBorder(titleXuLy);
        pnMain.add(pnXuLy, BorderLayout.WEST);
        
        JPanel pnTieuDe = new JPanel();
        JLabel lblTieuDe = new JLabel("Cộng Trừ Nhân Chia");
        Font font = new Font("Times new roman", Font.BOLD, 28);
        lblTieuDe.setFont(font);
        pnTieuDe.add(lblTieuDe);        
        pnMain.add(pnTieuDe, BorderLayout.NORTH);
        
        JPanel pnPhepTinh = new JPanel();
        pnPhepTinh.setLayout(new BoxLayout(pnPhepTinh, BoxLayout.Y_AXIS));
        Border borderPhepTinh = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titlePhepTinh = BorderFactory.createTitledBorder(borderXuLy, "Nhập 2 số a, b");
        titlePhepTinh.setTitleJustification(TitledBorder.LEFT);
        pnPhepTinh.setBorder(titlePhepTinh);
        JPanel pnHang_a = new JPanel();
        JLabel lbl_a = new JLabel("Nhập a:");
        txt_a = new JTextField(20);
        pnHang_a.add(lbl_a);
        pnHang_a.add(txt_a);
        pnPhepTinh.add(pnHang_a);
        JPanel pnHang_b = new JPanel();
        JLabel lbl_b = new JLabel("Nhập b:");
        txt_b = new JTextField(20);
        pnHang_b.add(lbl_b);
        pnHang_b.add(txt_b);
        pnPhepTinh.add(pnHang_b);
        
        JPanel pnLuaChon = new JPanel();
        pnLuaChon.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pnChinh = new JPanel();
        pnChinh.setPreferredSize(new Dimension(150,70));
        Border borderLuaChon = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titleLuaChon = BorderFactory.createTitledBorder(borderXuLy, "Chọn phép toán");
        titleLuaChon.setTitleJustification(TitledBorder.LEFT);
        pnChinh.setBorder(titleLuaChon);
        pnChinh.setLayout(new GridLayout(2, 2));
        radCong = new JRadioButton("Cộng");
        radTru = new JRadioButton("Trừ");
        radNhan = new JRadioButton("Nhân");
        radChia = new JRadioButton("Chia");
        ButtonGroup group = new ButtonGroup();
        group.add(radCong);
        group.add(radTru);
        group.add(radNhan);
        group.add(radChia);
        pnChinh.add(radCong);
        pnChinh.add(radTru);
        pnChinh.add(radNhan);
        pnChinh.add(radChia);
        pnLuaChon.add(pnChinh);
        pnPhepTinh.add(pnLuaChon);
        
        JPanel pnHang_kq = new JPanel();
        JLabel lbl_kq = new JLabel("Kết quả:");
        txt_kq = new JTextField(20);
        pnHang_kq.add(lbl_kq);
        pnHang_kq.add(txt_kq);
        pnPhepTinh.add(pnHang_kq);
        
        pnMain.add(pnPhepTinh,BorderLayout.CENTER);
        con.add(pnMain);
        
        
    }
    
    public void showWindow(){
        this.setVisible(true);
        this.setSize(500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
                
    }
    
}
