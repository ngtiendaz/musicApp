package com.mycompany.musicapp.item;

import com.mycompany.musicapp.model.Model_Album;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ItemAlbum_Ngang extends javax.swing.JPanel {

    private final Model_Album album;

    public ItemAlbum_Ngang(Model_Album album) {
        this.album = album;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(album.getImagePathAlbum());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imgAlbum.setIcon(imageIcon);
        if (album.getTitleAlbum().length() > 40) {
            lb_namealbum.setText(album.getTitleAlbum().substring(0, 20 - 3) + "...");
        } else {
            lb_namealbum.setText(album.getTitleAlbum());
        }
        lb_nameartist.setText(album.getNameArtist());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imgAlbum = new javax.swing.JLabel();
        lb_namealbum = new javax.swing.JLabel();
        lb_nameartist = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lb_imgAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imgAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/ablum.png"))); // NOI18N
        lb_imgAlbum.setPreferredSize(new java.awt.Dimension(384, 112));

        lb_namealbum.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_namealbum.setForeground(new java.awt.Color(255, 255, 255));
        lb_namealbum.setText("NameAlbum");

        lb_nameartist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_nameartist.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameartist.setText("NameArtist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_imgAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_namealbum)
                    .addComponent(lb_nameartist))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lb_imgAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lb_namealbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nameartist)))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_imgAlbum;
    private javax.swing.JLabel lb_namealbum;
    private javax.swing.JLabel lb_nameartist;
    // End of variables declaration//GEN-END:variables
}
