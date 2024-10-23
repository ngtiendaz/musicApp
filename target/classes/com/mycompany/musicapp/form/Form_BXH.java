package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_BXH extends javax.swing.JPanel {

    public Form_BXH() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollSongTop.setHorizontalScrollBar(new ScrollBar());
        scrollSongTop.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollSongTop.getViewport().setBackground(Color.BLACK);
        scrollSongTop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scrollArtistTop.setHorizontalScrollBar(new ScrollBar());
        scrollArtistTop.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollArtistTop.getViewport().setBackground(Color.BLACK);
        scrollArtistTop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        ((DefaultListModel) listSong_H1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.getTopLikedSongs(10);
            for (Model_Song song : songs) {
                listSong_H1.addItem(song);
            }
        });
        ((DefaultListModel) listArtist1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.getTopFollowedArtists(3);
            for (Model_Artist artist : artists) {
                listArtist1.addItem(artist);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        scrollSongTop = new javax.swing.JScrollPane();
        listSong_H1 = new com.mycompany.musicapp.list.ListSong_H();
        jLabel1 = new javax.swing.JLabel();
        scrollArtistTop = new javax.swing.JScrollPane();
        listArtist1 = new com.mycompany.musicapp.list.ListArtist();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/like.png"))); // NOI18N
        jLabel2.setText("Top 10 bài hát được yêu thích nhất");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        scrollSongTop.setBorder(null);
        scrollSongTop.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollSongTop.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listSong_H1.setBorder(null);
        scrollSongTop.setViewportView(listSong_H1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/top.png"))); // NOI18N
        jLabel1.setText("Top 3 nghệ sĩ được yêu thích nhất");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        scrollArtistTop.setBorder(null);
        scrollArtistTop.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollArtistTop.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listArtist1.setBorder(null);
        scrollArtistTop.setViewportView(listArtist1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(174, Short.MAX_VALUE))
            .addComponent(scrollSongTop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scrollArtistTop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(scrollSongTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(scrollArtistTop, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ((DefaultListModel) listArtist1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.getTopFollowedArtists(3);
            for (Model_Artist artist : artists) {
                listArtist1.addItem(artist);
            }
        });
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.mycompany.musicapp.list.ListArtist listArtist1;
    private com.mycompany.musicapp.list.ListSong_H listSong_H1;
    private javax.swing.JScrollPane scrollArtistTop;
    private javax.swing.JScrollPane scrollSongTop;
    // End of variables declaration//GEN-END:variables
}
