package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventSongLikeChanged;
import com.mycompany.musicapp.event.EventSongSelected;
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

public class Form_FavoriteSong extends javax.swing.JPanel {

    int Like = 1;
    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;
    private EventSongLikeChanged eventSongLikeChanged;

    public EventSongLikeChanged getEventSongLikeChanged() {
        return eventSongLikeChanged;
    }

    public void setEventSongLikeChanged(EventSongLikeChanged eventSongLikeChanged) {
        this.eventSongLikeChanged = eventSongLikeChanged;
    }

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_FavoriteSong.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    public Form_FavoriteSong() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);

        scrollFavoriteSong.setVerticalScrollBar(new ScrollBar());
        scrollFavoriteSong.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollFavoriteSong.getViewport().setBackground(Color.BLACK);
        scrollFavoriteSong.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        ((DefaultListModel) listSong_V1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Favorite(Like);
            for (Model_Song song : songs) {
                listSong_V1.addItem(song);
            }
        });

        listSong_V1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V1.getSelectedValue());
                if (eventSongSelected != null) {
                    eventSongSelected.selected(selectedSong);
                }
            }
        });
        MusicApp.addEventSongLikeChanged(eventSongLikeChanged);

    }

    public void updateSong() {
        ((DefaultListModel) listSong_V1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Favorite(Like);
            for (Model_Song song : songs) {
                listSong_V1.addItem(song);
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#5D4157"), getWidth(), getHeight(), Color.decode("#A8CABA"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollFavoriteSong = new javax.swing.JScrollPane();
        listSong_V1 = new com.mycompany.musicapp.list.ListSong_V();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loadData = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bài hát yêu thích\n");

        scrollFavoriteSong.setBorder(null);

        listSong_V1.setBorder(null);
        scrollFavoriteSong.setViewportView(listSong_V1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/export3.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/newtim.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Playlist");

        loadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/play@@.png"))); // NOI18N
        loadData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadData)
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollFavoriteSong)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadData))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addComponent(scrollFavoriteSong, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadDataMouseClicked
        updateSong();
    }//GEN-LAST:event_loadDataMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.mycompany.musicapp.list.ListSong_V listSong_V1;
    private javax.swing.JLabel loadData;
    private javax.swing.JScrollPane scrollFavoriteSong;
    // End of variables declaration//GEN-END:variables
}
