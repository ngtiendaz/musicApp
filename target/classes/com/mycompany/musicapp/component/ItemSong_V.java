package com.mycompany.musicapp.component;

import com.mycompany.musicapp.form.Form_Home;
import com.mycompany.musicapp.model.Model_Song;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ItemSong_V extends javax.swing.JPanel {

    private final Model_Song song;
    private boolean isLike;
    private Bottom bottom;
    //private Form_Home home;

    public ItemSong_V(Model_Song song) {
        this.song = song;
        //this.home = home;
        initComponents();

        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(song.getImagePathSong());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageSong.setIcon(imageIcon);
        lb_NameArist.setText(song.getNameArtist());
        if (song.getTitleSong().length() > 40) {
            lb_NameSong.setText(song.getTitleSong().substring(0, 20 - 3) + "...");
        } else {
            lb_NameSong.setText(song.getTitleSong());
        }
//        if (song.getLike() == 1) {
//            isLike = true;
//            lb_tim.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\liked.png"));
//        } else {
//            isLike = false;
//            lb_tim.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\like.png"));
//        }

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

        lb_imageSong = new javax.swing.JLabel();
        lb_NameSong = new javax.swing.JLabel();
        lb_NameArist = new javax.swing.JLabel();
        lb_tim = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(500, 86));
        setMinimumSize(new java.awt.Dimension(500, 86));
        setPreferredSize(new java.awt.Dimension(500, 80));

        lb_imageSong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/audioOk.png"))); // NOI18N

        lb_NameSong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_NameSong.setForeground(new java.awt.Color(255, 255, 255));
        lb_NameSong.setText("NameMusic");

        lb_NameArist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_NameArist.setForeground(new java.awt.Color(255, 255, 255));
        lb_NameArist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_NameArist.setText("NameArtist");

        lb_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/bacham.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_imageSong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_NameArist, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_NameSong, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(lb_tim)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb_imageSong, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lb_tim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_NameSong)
                        .addGap(0, 0, 0)
                        .addComponent(lb_NameArist)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_NameArist;
    private javax.swing.JLabel lb_NameSong;
    private javax.swing.JLabel lb_imageSong;
    private javax.swing.JLabel lb_tim;
    // End of variables declaration//GEN-END:variables
}
