package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.model.Model_User;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Form_AdminProfile extends javax.swing.JPanel {

    private Model_User user;

    public Form_AdminProfile() {
        initComponents();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#373B44"), getWidth(), getHeight(), Color.decode("#73C8A9"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public void updateUser(Model_User user) {
        this.user = user;
        lb_nameuser.setText(user.getNameUser());
        lb_email.setText(user.getEmail());
        //lb_pass.setText(user.getPass());
        ImageIcon imageIcon = new ImageIcon(user.getImagePathUser());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imagePath.setIcon(imageIcon);
        lb_role.setText(user.getRole());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imagePath = new javax.swing.JLabel();
        lb_nameuser = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_role = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));

        lb_imagePath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imagePath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/ad_artist.png"))); // NOI18N

        lb_nameuser.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lb_nameuser.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameuser.setText("NameUser");

        lb_email.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lb_email.setForeground(new java.awt.Color(255, 255, 255));
        lb_email.setText("Email@gmail.com");

        lb_role.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_role.setForeground(new java.awt.Color(255, 255, 255));
        lb_role.setText("Role");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nameuser, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_email)
                    .addComponent(lb_role))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lb_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_role)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nameuser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_email)
                        .addGap(43, 43, 43)))
                .addContainerGap(594, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_imagePath;
    private javax.swing.JLabel lb_nameuser;
    private javax.swing.JLabel lb_role;
    // End of variables declaration//GEN-END:variables
}
