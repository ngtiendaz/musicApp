package com.mycompany.musicapp.component;

import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Song;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ItemSong2 extends javax.swing.JPanel {

    private final Model_Song song;

    public ItemSong2(Model_Song song) {
        this.song = song;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(song.getImagePathSong());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lbImageSong.setIcon(imageIcon);
        if (song.getTitleSong().length() > 20) {
            lbNameArtist.setText(song.getTitleSong().substring(0, 20 - 3) + "...");
        } else {
            lbNameArtist.setText(song.getTitleSong());
        }
        if (song.getLike() == 0) {
            lb_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\like.png"));
        } else {
            lb_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\liked.png"));

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImageSong = new javax.swing.JLabel();
        lbNameSong = new javax.swing.JLabel();
        lbNameArtist = new javax.swing.JLabel();
        lb_like = new javax.swing.JLabel();

        lbImageSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/audioOk.png"))); // NOI18N

        lbNameSong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNameSong.setForeground(new java.awt.Color(255, 255, 255));
        lbNameSong.setText("NameSong");

        lbNameArtist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lbNameArtist.setText("NameArtist");

        lb_like.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/like.png"))); // NOI18N
        lb_like.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbImageSong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameSong, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(lbNameArtist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_like, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_like, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNameSong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNameArtist)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImageSong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImageSong;
    private javax.swing.JLabel lbNameArtist;
    private javax.swing.JLabel lbNameSong;
    private javax.swing.JLabel lb_like;
    // End of variables declaration//GEN-END:variables
}
