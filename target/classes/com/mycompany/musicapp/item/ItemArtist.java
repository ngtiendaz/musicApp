package com.mycompany.musicapp.item;

import com.mycompany.musicapp.form.Form_Next_Artist;
import com.mycompany.musicapp.model.Model_Artist;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ItemArtist extends javax.swing.JPanel {

    private final Model_Artist artist;
    private Form_Next_Artist nextArtist;

    public ItemArtist(Model_Artist artist) {
        this.artist = artist;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(artist.getImagePathArtists());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lbImgArtist.setIcon(imageIcon);
        if (artist.getName().length() > 20) {
            lbNameArtist.setText(artist.getName().substring(0, 20 - 3) + "...");
        } else {
            lbNameArtist.setText(artist.getName());
        }
        AWTEventMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextArtist.updateArtistinfo(artist.getImagePathArtists(), artist.getName(), artist.getArtistID(), artist.getFlow());

            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImgArtist = new javax.swing.JLabel();
        lbNameArtist = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(158, 197));

        lbImgArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbImgArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addArtist.png"))); // NOI18N

        lbNameArtist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lbNameArtist.setText("NameArtist");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("88.7K người theo dõi");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/check.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImgArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNameArtist)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1)))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbImgArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbNameArtist)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbImgArtist;
    private javax.swing.JLabel lbNameArtist;
    // End of variables declaration//GEN-END:variables
}
