package com.mycompany.musicapp.component.item;

import com.mycompany.musicapp.model.Model_Artist;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ItemArtist_Ngang extends javax.swing.JPanel {

    private final Model_Artist artist;
    private boolean isLike;

    public ItemArtist_Ngang(Model_Artist artist) {
        this.artist = artist;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(artist.getImagePathArtists());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_image.setIcon(imageIcon);
        if (artist.getName().length() > 20) {
            lb_nameArtist.setText(artist.getName().substring(0, 20 - 3) + "...");
        } else {
            lb_nameArtist.setText(artist.getName());
        }
        if (artist.getFlow() == 1) {
            isLike = true;
            lb_follow.setText("Following");

        } else {
            isLike = false;
            lb_follow.setText("Follow");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_image = new javax.swing.JLabel();
        lb_nameArtist = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_follow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lb_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/man-avatar.png"))); // NOI18N

        lb_nameArtist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameArtist.setText("NameArtist");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("88.7k followers");
        jLabel3.setToolTipText("");

        lb_follow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_follow.setText("Follow");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/check.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_nameArtist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lb_follow)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_nameArtist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lb_follow)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton lb_follow;
    private javax.swing.JLabel lb_image;
    private javax.swing.JLabel lb_nameArtist;
    // End of variables declaration//GEN-END:variables
}
