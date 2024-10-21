package com.mycompany.musicapp.formLogin;

import com.mycompany.musicapp.Main;
import com.mycompany.musicapp.Main_Admin;
import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.Model_User;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Form_login extends javax.swing.JPanel {

    public Form_login() {
        initComponents();
    }

    public void login() {
        edt_email.grabFocus();
    }

    public void addEventRegister(ActionListener event) {
        cmdRegister.addActionListener(event);
    }

    public void addEventDangNhap(ActionListener event) {
        lb_dangNhap.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edt_email = new com.mycompany.musicapp.swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edt_pass = new com.mycompany.musicapp.swing.MyPassword();
        jLabel3 = new javax.swing.JLabel();
        lb_dangNhap = new com.mycompany.musicapp.swing.MyButton();
        cmdRegister = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đăng nhập");

        jLabel3.setText("Mật khẩu");

        lb_dangNhap.setBackground(new java.awt.Color(0, 102, 51));
        lb_dangNhap.setBorder(null);
        lb_dangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lb_dangNhap.setText("Đăng nhập");
        lb_dangNhap.setColor(new java.awt.Color(0, 102, 51));
        lb_dangNhap.setColorOver(new java.awt.Color(0, 102, 51));
        lb_dangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_dangNhapActionPerformed(evt);
            }
        });

        cmdRegister.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        cmdRegister.setForeground(new java.awt.Color(0, 153, 51));
        cmdRegister.setText("Chưa có tài khoản ? Đăng ký ngay.");
        cmdRegister.setBorder(null);
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(edt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(edt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lb_dangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(cmdRegister)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lb_dangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_dangNhapActionPerformed
        String email = edt_email.getText();
        String pass = String.valueOf(edt_pass.getPassword());
        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        try {
            Connection conn = MusicApp.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE Email = ? AND Pass = ?");
            stmt.setString(1, email);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Model_User user = MusicApp.mapResultSetToUser(rs);
                if (user.getRole().equals("admin")) {
                    System.out.println("Đăng nhập thành công! Chuyển đến trang quản trị");
                    Main_Admin admin = new Main_Admin();
                    admin.setVisible(true);
                    SwingUtilities.getWindowAncestor(this).dispose();
                } else {
                    System.out.println("Đăng nhập thành công! Chuyển đến trang chủ");
                    Main main = new Main(user);
                    main.setVisible(true);
                    SwingUtilities.getWindowAncestor(this).dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sai email hoặc mật khẩu!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đăng nhập!");
        }
    }//GEN-LAST:event_lb_dangNhapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdRegister;
    private com.mycompany.musicapp.swing.MyTextField edt_email;
    private com.mycompany.musicapp.swing.MyPassword edt_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.mycompany.musicapp.swing.MyButton lb_dangNhap;
    // End of variables declaration//GEN-END:variables
}
