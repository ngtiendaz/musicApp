package com.mycompany.musicapp.form_login;

import com.mycompany.musicapp.Login;

public class Form_Register extends javax.swing.JPanel {

    private Login login;

    public Form_Register() {
        initComponents();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        edt_email = new javax.swing.JTextField();
        lb_dangki = new javax.swing.JButton();
        lb_dangnhap = new javax.swing.JLabel();
        edt_pass = new javax.swing.JTextField();
        edt_checkpass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_xem = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(430, 500));
        setMinimumSize(new java.awt.Dimension(430, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng kí");

        edt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_emailActionPerformed(evt);
            }
        });

        lb_dangki.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_dangki.setForeground(new java.awt.Color(0, 204, 102));
        lb_dangki.setText("Đăng kí");

        lb_dangnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_dangnhap.setForeground(new java.awt.Color(255, 255, 255));
        lb_dangnhap.setText("Đã có tài khoản, quay trở lại đăng nhập.");
        lb_dangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_dangnhapMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 102));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 102));
        jLabel5.setText("Mật khẩu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 102));
        jLabel6.setText("Nhập lại mật khẩu");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/user.png"))); // NOI18N

        lb_xem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/mat2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(edt_checkpass, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edt_pass, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lb_xem, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(lb_dangki, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lb_dangnhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_xem))
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edt_checkpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lb_dangki, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_dangnhap)
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_emailActionPerformed

    private void lb_dangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dangnhapMouseClicked
        login.setForm(new Form_SignIn());
    }//GEN-LAST:event_lb_dangnhapMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edt_checkpass;
    private javax.swing.JTextField edt_email;
    private javax.swing.JTextField edt_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton lb_dangki;
    private javax.swing.JLabel lb_dangnhap;
    private javax.swing.JLabel lb_xem;
    // End of variables declaration//GEN-END:variables
}
