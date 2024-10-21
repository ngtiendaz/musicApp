package com.mycompany.musicapp.item;

import com.mycompany.musicapp.form.Form_Next_Album;
import com.mycompany.musicapp.model.Model_Album;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ItemAlbum extends javax.swing.JPanel {

    private final Model_Album album;
    private Form_Next_Album nextAlbum;

    public ItemAlbum(Model_Album album) {
        this.album = album;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(album.getImagePathAlbum());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lbImageAlbum.setIcon(imageIcon);
        if (album.getTitleAlbum().length() > 20) {
            lbNameAlbum.setText(album.getTitleAlbum().substring(0, 20 - 3) + "...");
        } else {
            lbNameAlbum.setText(album.getTitleAlbum());
        }
        lbNameArtist.setText(album.getNameArtist());
        AWTEventMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextAlbum.updateAlbuminfo(album.getImagePathAlbum(), album.getTitleAlbum(), album.getNameArtist(), album.getAlbumID(), album.getArtistID());

//                Form_Next_Album nextAlbum = new Form_Next_Album(album.getTitleAlbum());
//                home.setForm(nextAlbum);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImageAlbum = new javax.swing.JLabel();
        lbNameAlbum = new javax.swing.JLabel();
        lbNameArtist = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lbImageAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbImageAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addImage.png"))); // NOI18N

        lbNameAlbum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNameAlbum.setForeground(new java.awt.Color(255, 255, 255));
        lbNameAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNameAlbum.setText("NameAlbum");

        lbNameArtist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lbNameArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNameArtist.setText("NameArtist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbImageAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNameAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(lbNameArtist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbImageAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbNameAlbum)
                .addGap(2, 2, 2)
                .addComponent(lbNameArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImageAlbum;
    private javax.swing.JLabel lbNameAlbum;
    private javax.swing.JLabel lbNameArtist;
    // End of variables declaration//GEN-END:variables
}
