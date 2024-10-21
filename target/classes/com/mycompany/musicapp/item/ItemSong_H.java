package com.mycompany.musicapp.item;

import com.mycompany.musicapp.form.Bottom;
import com.mycompany.musicapp.form.Form_Home;
import com.mycompany.musicapp.model.Model_Song;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ItemSong_H extends javax.swing.JPanel {

    private final Model_Song song;
    private Form_Home home;
    private Bottom bottom;

    public ItemSong_H(Model_Song song, Form_Home home) {
        this.song = song;
        this.home = home;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(song.getImagePathSong());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_Imagesong.setIcon(imageIcon);
        if (song.getTitleSong().length() > 20) {
            lb_nameSong.setText(song.getTitleSong().substring(0, 20 - 3) + "...");
        } else {
            lb_nameSong.setText(song.getTitleSong());
        }
        lb_nameArtist.setText(song.getNameArtist());
        AWTEventMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(song.getTitleSong());
                bottom.stopMusic();
                bottom.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());

            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Imagesong = new javax.swing.JLabel();
        lb_nameSong = new javax.swing.JLabel();
        lb_nameArtist = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lb_Imagesong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Imagesong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/imgOK.png"))); // NOI18N

        lb_nameSong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nameSong.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameSong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nameSong.setText("NameSong");

        lb_nameArtist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_nameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nameArtist.setText("NameArtist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_Imagesong, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(lb_nameSong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nameArtist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_Imagesong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lb_nameSong)
                .addGap(2, 2, 2)
                .addComponent(lb_nameArtist)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_Imagesong;
    private javax.swing.JLabel lb_nameArtist;
    private javax.swing.JLabel lb_nameSong;
    // End of variables declaration//GEN-END:variables
}
