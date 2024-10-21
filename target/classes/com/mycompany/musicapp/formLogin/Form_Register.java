package com.mycompany.musicapp.formLogin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.model.Model_User;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Form_Register extends javax.swing.JPanel {

    int ThemID = 0;

    public Form_Register() {
        initComponents();
    }

    public void register() {
        edt_email.grabFocus();
    }

    public void addEventBackLogin(ActionListener event) {
        cmdBackLogin.addActionListener(event);
    }

    public void addEventDangKi(ActionListener event) {
        lb_dangki.addActionListener(event);
    }

    public void cleardata() {
        edt_checkPass.setText(null);
        edt_email.setText(null);
        edt_userName.setText(null);
        edt_pass.setText(null);
    }

    public void getCountUser() {
        List<Model_User> users = MusicApp.getAllUser();
        ThemID = users.size(); // Đếm số lượng người dùng trực tiếp
        System.out.println(ThemID);
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
        lb_dangki = new com.mycompany.musicapp.swing.MyButton();
        cmdBackLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        edt_checkPass = new com.mycompany.musicapp.swing.MyPassword();
        edt_userName = new com.mycompany.musicapp.swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        edt_email.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đăng ký");

        jLabel3.setText("Mật khẩu");

        lb_dangki.setBackground(new java.awt.Color(0, 102, 51));
        lb_dangki.setBorder(null);
        lb_dangki.setForeground(new java.awt.Color(255, 255, 255));
        lb_dangki.setText("Đăng ký");
        lb_dangki.setColor(new java.awt.Color(0, 102, 51));
        lb_dangki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_dangkiActionPerformed(evt);
            }
        });

        cmdBackLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(0, 153, 51));
        cmdBackLogin.setText("Đã có tài khoản, quay về đăng nhập.");
        cmdBackLogin.setBorder(null);
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setText("Tên người dùng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(edt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(edt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dangki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(edt_checkPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edt_userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_checkPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lb_dangki, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cmdBackLogin)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lb_dangkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_dangkiActionPerformed
        List<Model_User> users = MusicApp.getAllUser();
        ThemID = users.size();
        ThemID++;
        ThemID++;
        String email = edt_email.getText();
        String pass = String.valueOf(edt_pass.getPassword());
        String checkPass = String.valueOf(edt_checkPass.getPassword());
        String userName = edt_userName.getText();
        if (email.isEmpty() || pass.isEmpty() || checkPass.isEmpty() || userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        if (CheckLoi.checkEmail(email) == null) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!");
            return;
        }
        if (CheckLoi.checkPassword(pass) == null) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 8 ký tự, gồm chữ cái và số!");
            return;
        }
        if (!pass.equals(checkPass)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp!");
            return;
        }
        try {
            if (CheckLoi.checkEmail(email) != null) {

                MusicApp.addUser(ThemID, email, pass, "D:\\Data_Music\\newIcon\\man-avatar.png", userName, "user");
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                cleardata();

            } else {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi đăng ký!");
        }

    }//GEN-LAST:event_lb_dangkiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private com.mycompany.musicapp.swing.MyPassword edt_checkPass;
    private com.mycompany.musicapp.swing.MyTextField edt_email;
    private com.mycompany.musicapp.swing.MyPassword edt_pass;
    private com.mycompany.musicapp.swing.MyTextField edt_userName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.mycompany.musicapp.swing.MyButton lb_dangki;
    // End of variables declaration//GEN-END:variables
}
