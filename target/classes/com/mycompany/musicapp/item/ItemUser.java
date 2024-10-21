package com.mycompany.musicapp.item;

import com.mycompany.musicapp.model.Model_User;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ItemUser extends javax.swing.JPanel {

    private final Model_User user;

    public ItemUser(Model_User user) {
        this.user = user;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(user.getImagePathUser());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_Imangeuser.setIcon(imageIcon);

        lb_email.setText(user.getEmail());
        lb_pass.setText(user.getPass());
        lb_nameUser.setText(user.getNameUser());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Imangeuser = new javax.swing.JLabel();
        lb_nameUser = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_pass = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lb_Imangeuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Imangeuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/artistnew.png"))); // NOI18N

        lb_nameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nameUser.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameUser.setText("UserName");

        lb_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_email.setForeground(new java.awt.Color(255, 255, 255));
        lb_email.setText("Email");

        lb_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_pass.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass.setText("Password");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/bacham.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_Imangeuser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_pass)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_nameUser)
                        .addComponent(lb_email)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lb_nameUser)
                        .addGap(2, 2, 2)
                        .addComponent(lb_email)
                        .addGap(2, 2, 2)
                        .addComponent(lb_pass))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addComponent(lb_Imangeuser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb_Imangeuser;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_nameUser;
    private javax.swing.JLabel lb_pass;
    // End of variables declaration//GEN-END:variables
}
