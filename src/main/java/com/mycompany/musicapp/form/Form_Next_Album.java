package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventSongSelected;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_Next_Album extends javax.swing.JPanel {

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Next_Album.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    int ID;
    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;

    public Form_Next_Album() {
        initComponents();
        JPanel p = new JPanel();
        //p.setBackground(Color.BLACK);
        scrollAlbumnext.setVerticalScrollBar(new ScrollBar());
        scrollAlbumnext.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollAlbumnext.getViewport().setBackground(Color.BLACK);
        scrollAlbumnext.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listSong_V.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V.getSelectedValue());
                if (eventSongSelected != null) {
                    eventSongSelected.selected(selectedSong);
                }
            }
        });

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#000000"), getWidth(), getHeight(), Color.decode("#434343"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public void updateAlbuminfo(String ImagePathAlbum, String TitleAlbum, String NameArtist, int AlbumID, int ArtistID) {
        if (ImagePathAlbum != null && !ImagePathAlbum.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(ImagePathAlbum);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imgAlbum.setIcon(imageIcon);
        }
        ID = AlbumID;
        if (TitleAlbum != null && !TitleAlbum.isEmpty()) {
            lb_nameAlbum.setText(TitleAlbum);
        }
        if (NameArtist != null && !NameArtist.isEmpty()) {
            lb_nameArtist.setText(NameArtist + ".");

        }
        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Album_Song(ID);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imgAlbum = new javax.swing.JLabel();
        lb_nameAlbum = new javax.swing.JLabel();
        lb_nameArtist = new javax.swing.JLabel();
        scrollAlbumnext = new javax.swing.JScrollPane();
        listSong_V = new com.mycompany.musicapp.list.ListSong_V();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loadData = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        lb_imgAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imgAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/avt1.jpg"))); // NOI18N

        lb_nameAlbum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_nameAlbum.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameAlbum.setText("NameAlbumg");

        lb_nameArtist.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lb_nameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameArtist.setText("NameArtist");

        scrollAlbumnext.setBorder(null);
        scrollAlbumnext.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAlbumnext.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollAlbumnext.setOpaque(false);

        listSong_V.setBorder(null);
        scrollAlbumnext.setViewportView(listSong_V);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Album của");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Album");

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
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollAlbumnext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_imgAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_nameAlbum)
                                    .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_nameArtist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadData)
                                .addGap(30, 30, 30))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nameAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadData, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lb_nameArtist))))
                    .addComponent(lb_imgAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(scrollAlbumnext, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadDataMouseClicked
        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Album_Song(ID);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }//GEN-LAST:event_loadDataMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_imgAlbum;
    private javax.swing.JLabel lb_nameAlbum;
    private javax.swing.JLabel lb_nameArtist;
    private com.mycompany.musicapp.list.ListSong_V listSong_V;
    private javax.swing.JLabel loadData;
    private javax.swing.JScrollPane scrollAlbumnext;
    // End of variables declaration//GEN-END:variables
}
