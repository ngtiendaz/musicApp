package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Category;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Form_Add extends javax.swing.JPanel {

    private String imagePathAlbum = "";
    private String imagePathArtist = "";
    private String imagePathSong = "";
    private String audioPathSong = "";

    public Form_Add() {
        initComponents();
        loadArtistToComboBox();
        loadArtistToComboBoxSong();
        loadAlbumToComboBoxSong();
        loadCategoryToComboBoxSong();

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

    private void loadCategoryToComboBoxSong() {
        try {
            List<Model_Category> categoryList = MusicApp.getAllCategory();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Category category : categoryList) {
                model.addElement(category);
                cbb_categoryID.addItem(category.getTitleCategory());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadArtistToComboBoxSong() {
        try {
            List<Model_Artist> artistList = MusicApp.getAllArtists();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Artist artist : artistList) {
                model.addElement(artist);
                cbb_artistIDSong.addItem(artist.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAlbumToComboBoxSong() {
        try {
            List<Model_Album> albumList = MusicApp.getAllAlbum();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Album album : albumList) {
                model.addElement(album);
                cbb_albumID.addItem(album.getTitleAlbum());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadArtistToComboBox() {
        try {
            List<Model_Artist> artistList = MusicApp.getAllArtists();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Artist artist : artistList) {
                model.addElement(artist);
                cbb_artistIDAlbum.addItem(artist.getName());
            }
            // cbb_artistIDAlbum.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbb_artistIDAlbum = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lb_imageAlbum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_add_album = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edt_nameArtist = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lb_imageArtist = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_add_artist = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbb_categoryID = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbb_albumID = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbb_artistIDSong = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        edt_titleSong = new javax.swing.JTextField();
        lb_imageSong = new javax.swing.JLabel();
        lb_audioSong = new javax.swing.JLabel();
        btn_add_song = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        edt_artistID = new javax.swing.JTextField();
        edt_songID = new javax.swing.JTextField();
        edt_albumID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edt_titleAlbum = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/ablum.png"))); // NOI18N
        jLabel1.setText("Album");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AlbumID:");

        cbb_artistIDAlbum.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ArtistID:");

        lb_imageAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageAlbumMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ImagePath:");

        btn_add_album.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_add_album.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        btn_add_album.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_albumMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/artist.png"))); // NOI18N
        jLabel7.setText("Artist");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ArtistID:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ImagePath:");

        lb_imageArtist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageArtistMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/song.png"))); // NOI18N
        jLabel12.setText("Song");

        btn_add_artist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_add_artist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        btn_add_artist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_artistMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("SongID:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CategoryID:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("AlbumID:");

        cbb_albumID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_albumIDActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ArtistID:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Title:");

        lb_imageSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageSongMouseClicked(evt);
            }
        });

        lb_audioSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addfile.png"))); // NOI18N
        lb_audioSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_audioSongMouseClicked(evt);
            }
        });

        btn_add_song.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        btn_add_song.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_songMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Upload DataBase");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TitleAlbum:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18)
                            .addGap(332, 332, 332))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(edt_songID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbb_albumID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbb_categoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(edt_titleSong, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(cbb_artistIDSong, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(97, 97, 97)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lb_imageSong)
                                        .addComponent(lb_audioSong))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(edt_nameArtist)
                                            .addComponent(edt_artistID)
                                            .addComponent(edt_albumID)
                                            .addComponent(cbb_artistIDAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(46, 46, 46)
                                        .addComponent(lb_imageAlbum))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(edt_titleAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(lb_imageArtist))))))
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel22)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add_artist)
                    .addComponent(btn_add_song)
                    .addComponent(btn_add_album))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(edt_albumID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(lb_imageAlbum)
                    .addComponent(btn_add_album))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_artistIDAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(edt_titleAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(edt_artistID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_add_artist)
                    .addComponent(lb_imageArtist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edt_nameArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(edt_songID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbb_categoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(cbb_artistIDSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_imageSong)
                    .addComponent(btn_add_song))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(cbb_albumID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(edt_titleSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_audioSong))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_albumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_albumMouseClicked
        try {
            int AlbumID = Integer.parseInt(edt_albumID.getText());
            String TitleAlbum = edt_titleAlbum.getText();
            String ImagePathAlbum = imagePathAlbum;
            int ArtistID = cbb_artistIDAlbum.getSelectedIndex() + 1;
            if (CheckLoi.checkKey(edt_albumID.getText(), "album")) {
                MusicApp.addAlbum(AlbumID, TitleAlbum, ImagePathAlbum, ArtistID);
                JOptionPane.showMessageDialog(this, "Thêm Album thành công!");
                loadArtistToComboBox();
                edt_albumID.setText(null);
                edt_titleAlbum.setText(null);
                cbb_artistIDAlbum.setSelectedIndex(0);
                imagePathAlbum = "";
                lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));

            } else {
                JOptionPane.showMessageDialog(this, "Album ID đã tồn tại");
                edt_albumID.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_btn_add_albumMouseClicked

    private void btn_add_artistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_artistMouseClicked
        try {
            int ArtistID = Integer.parseInt(edt_artistID.getText());
            String Name = edt_nameArtist.getText();
            String ImagePathArtists = imagePathArtist;
            int Flow = 0;
            if (CheckLoi.checkKey(edt_artistID.getText(), "artists")) {
                MusicApp.addArtists(ArtistID, Name, ImagePathArtists, Flow);
                JOptionPane.showMessageDialog(this, "Thêm Artist thành công!");
                loadArtistToComboBox();
                loadArtistToComboBoxSong();
                edt_artistID.setText(null);
                imagePathArtist = "";
                edt_nameArtist.setText(null);
                lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));

            } else {
                JOptionPane.showMessageDialog(this, "Artist ID đã tồn tại");
                edt_artistID.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_btn_add_artistMouseClicked

    private void btn_add_songMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_songMouseClicked
        try {
            int SongID = Integer.parseInt(edt_songID.getText());
            int CategoryID = cbb_categoryID.getSelectedIndex() + 1;
            int AlbumID = cbb_albumID.getSelectedIndex() + 1;
            int ArtistID = cbb_artistIDSong.getSelectedIndex() + 1;
            String ImagePathSong = imagePathSong;
            String TitleSong = edt_titleSong.getText();
            String AudioSrc = audioPathSong;
            int Like = 0;
            if (CheckLoi.checkKey(edt_songID.getText(), "songs")) {
                MusicApp.addSong(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like);
                JOptionPane.showMessageDialog(this, "Thêm Song thành công!");
                edt_songID.setText(null);
                edt_titleSong.setText(null);
                cbb_categoryID.setSelectedIndex(1);
                cbb_albumID.setSelectedIndex(1);
                cbb_artistIDSong.setSelectedIndex(1);
                audioPathSong = "";
                lb_audioSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addfile.png"));
                lb_imageSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            } else {
                JOptionPane.showMessageDialog(this, "Song ID đã tồn tại");
                edt_songID.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
    }//GEN-LAST:event_btn_add_songMouseClicked

    }
    private void lb_imageAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageAlbumMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Add.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathAlbum = selectedFile.getAbsolutePath();
            lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\imgOK.png"));//set lại icon đã chọn
        }
    }//GEN-LAST:event_lb_imageAlbumMouseClicked

    private void lb_imageArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageArtistMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Add.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathArtist = selectedFile.getAbsolutePath();
            lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\imgOK.png"));
        }
    }//GEN-LAST:event_lb_imageArtistMouseClicked

    private void lb_imageSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageSongMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Add.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathSong = selectedFile.getAbsolutePath();
            lb_imageSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\imgOK.png"));
        }
    }//GEN-LAST:event_lb_imageSongMouseClicked

    private void lb_audioSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_audioSongMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Chọn file audio .wav");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".wav");
            }

            @Override
            public String getDescription() {
                return "File âm thanh WAV (*.wav)";
            }
        });
        if (fileChooser.showOpenDialog(Form_Add.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            audioPathSong = selectedFile.getAbsolutePath();
            lb_audioSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\audioOK.png"));
        }
    }//GEN-LAST:event_lb_audioSongMouseClicked

    private void cbb_albumIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_albumIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_albumIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_add_album;
    private javax.swing.JLabel btn_add_artist;
    private javax.swing.JLabel btn_add_song;
    private javax.swing.JComboBox<String> cbb_albumID;
    private javax.swing.JComboBox<String
    > cbb_artistIDAlbum;
    private javax.swing.JComboBox<String> cbb_artistIDSong;
    private javax.swing.JComboBox<String> cbb_categoryID;
    private javax.swing.JTextField edt_albumID;
    private javax.swing.JTextField edt_artistID;
    private javax.swing.JTextField edt_nameArtist;
    private javax.swing.JTextField edt_songID;
    private javax.swing.JTextField edt_titleAlbum;
    private javax.swing.JTextField edt_titleSong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lb_audioSong;
    private javax.swing.JLabel lb_imageAlbum;
    private javax.swing.JLabel lb_imageArtist;
    private javax.swing.JLabel lb_imageSong;
    // End of variables declaration//GEN-END:variables

}
