package com.mycompany.musicapp.form_login;

import com.mycompany.musicapp.Login;
import com.mycompany.musicapp.Main;
import com.mycompany.musicapp.Main_Admin;
import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.CheckLoi;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

public class Form_SignIn extends javax.swing.JPanel {

    private Login login;
    private Form_Register register;
    private Form_Admin admin;

    public Form_SignIn() {
        initComponents();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#000000"), getWidth(), getHeight(), Color.decode("#434343"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb_dangnhap = new javax.swing.JButton();
        lb_role = new javax.swing.JLabel();
        edt_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edt_pass = new javax.swing.JTextField();
        lb_xem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_nhoPass = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        lb_dangki = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(430, 500));
        setMinimumSize(new java.awt.Dimension(430, 500));
        setPreferredSize(new java.awt.Dimension(430, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng Nhập");

        lb_dangnhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_dangnhap.setForeground(new java.awt.Color(0, 153, 51));
        lb_dangnhap.setText("Đăng nhập");
        lb_dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_dangnhapActionPerformed(evt);
            }
        });

        lb_role.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/user.png"))); // NOI18N
        lb_role.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_roleMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 102));
        jLabel3.setText("Email");

        lb_xem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/mat2.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 102));
        jLabel5.setText("Mật khẩu");

        cb_nhoPass.setBackground(new java.awt.Color(51, 51, 51));
        cb_nhoPass.setForeground(new java.awt.Color(255, 255, 255));
        cb_nhoPass.setText("Nhớ mật khẩu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Chưa có tài khoản ?");

        lb_dangki.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lb_dangki.setForeground(new java.awt.Color(0, 204, 102));
        lb_dangki.setText("Đăng kí ngay.");
        lb_dangki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_dangkiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edt_pass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edt_email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_role)
                            .addComponent(lb_xem))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_nhoPass)
                            .addComponent(jLabel5)
                            .addComponent(lb_dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_dangki)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_role)
                    .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_nhoPass))
                    .addComponent(lb_xem))
                .addGap(43, 43, 43)
                .addComponent(lb_dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb_dangki))
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lb_roleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_roleMouseClicked
        login.setForm(admin);
    }//GEN-LAST:event_lb_roleMouseClicked

    private void lb_dangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_dangnhapActionPerformed
//        if (CheckLoi.checkEmail(edt_email.getText()) != null && CheckLoi.checkPassword(edt_pass.getText()) != null) {
//            String email = edt_email.getText();
//            String pass = edt_pass.getText();
//            if (MusicApp.checkLogin(email, pass) == 1) {
//                Main main = new Main();
//                main.setVisible(true);
//                this.setVisible(false);
//            } else if (MusicApp.checkLogin(email, pass) == 2) {
//                Main_Admin main_admin = new Main_Admin();
//                main_admin.setVisible(true);
//                this.setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Email hoặc mật khẩu không hợp lệ!");
//        }
    }//GEN-LAST:event_lb_dangnhapActionPerformed

    private void lb_dangkiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dangkiMouseClicked
        login.setForm(register);
    }//GEN-LAST:event_lb_dangkiMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_nhoPass;
    private javax.swing.JTextField edt_email;
    private javax.swing.JTextField edt_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb_dangki;
    private javax.swing.JButton lb_dangnhap;
    private javax.swing.JLabel lb_role;
    private javax.swing.JLabel lb_xem;
    // End of variables declaration//GEN-END:variables
}
