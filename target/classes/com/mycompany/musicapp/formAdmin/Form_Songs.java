package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.form.Form_Add;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Category;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_Songs extends javax.swing.JPanel {

    String audioPathSong = "";
    String imagePathSong = "";

    public Form_Songs() {
        initComponents();
        loadArtistToComboBoxSong();
        loadAlbumToComboBoxSong();
        loadCategoryToComboBoxSong();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollSong.setVerticalScrollBar(new ScrollBar());
        scrollSong.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollSong.getViewport().setBackground(Color.BLACK);
        scrollSong.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listSong_V.getSelectionModel().addListSelectionListener(e -> {
            Model_Song selectedSong = (Model_Song) listSong_V.getSelectedValue();
            if (selectedSong != null) {
                updateSongInfo(selectedSong);
            } else {
                edt_songID.setText(null);
                edt_titleSong.setText(null);
                cbb_album.setSelectedIndex(1);
                cbb_artist.setSelectedIndex(1);
                cbb_category.setSelectedIndex(1);
                audioPathSong = "";
                lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addfile.png"));
                lb_ImagePathSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
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

    private void loadCategoryToComboBoxSong() {
        try {
            List<Model_Category> categoryList = MusicApp.getAllCategory();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Category category : categoryList) {
                model.addElement(category);
                cbb_category.addItem(category.getTitleCategory());
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
                cbb_artist.addItem(artist.getName());
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
                cbb_album.addItem(album.getTitleAlbum());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSong = new javax.swing.JScrollPane();
        listSong_V = new com.mycompany.musicapp.list.ListSong_V();
        them = new javax.swing.JLabel();
        edt_songID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbb_category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbb_artist = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbb_album = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        edt_titleSong = new javax.swing.JTextField();
        edt_timkiem = new javax.swing.JTextField();
        lb_xoa = new javax.swing.JLabel();
        lb_sua = new javax.swing.JLabel();
        lb_them = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_ImagePathSong = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_AudioSrc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        scrollSong.setBorder(null);
        scrollSong.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSong.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listSong_V.setBorder(null);
        scrollSong.setViewportView(listSong_V);

        them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        them.setForeground(new java.awt.Color(255, 255, 255));
        them.setText("SongID:");
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themMouseClicked(evt);
            }
        });

        edt_songID.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CategoryID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ArtistID:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AlbumID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TitleSong:");

        edt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edt_timkiemKeyReleased(evt);
            }
        });

        lb_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_xoa.setForeground(new java.awt.Color(255, 255, 255));
        lb_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/xoa.png"))); // NOI18N
        lb_xoa.setText("Xóa");
        lb_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_xoaMouseClicked(evt);
            }
        });

        lb_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_sua.setForeground(new java.awt.Color(255, 255, 255));
        lb_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/pencil.png"))); // NOI18N
        lb_sua.setText("Sửa");
        lb_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_suaMouseClicked(evt);
            }
        });

        lb_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_them.setForeground(new java.awt.Color(255, 255, 255));
        lb_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        lb_them.setText("Thêm");
        lb_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_themMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ImagePath:");

        lb_ImagePathSong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ImagePathSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_ImagePathSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ImagePathSongMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("AudioSrc:");

        lb_AudioSrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addfile.png"))); // NOI18N
        lb_AudioSrc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_AudioSrcMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollSong)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(them)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbb_category, 0, 138, Short.MAX_VALUE)
                            .addComponent(edt_songID)
                            .addComponent(cbb_artist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb_album, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edt_titleSong))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ImagePathSong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(55, 55, 55)
                                .addComponent(lb_AudioSrc)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(lb_them)
                        .addGap(18, 18, 18)
                        .addComponent(lb_sua)
                        .addGap(18, 18, 18)
                        .addComponent(lb_xoa)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(them)
                            .addComponent(edt_songID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbb_artist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(lb_ImagePathSong, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb_album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lb_AudioSrc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edt_titleSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_xoa)
                    .addComponent(lb_sua)
                    .addComponent(lb_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollSong, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lb_AudioSrcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_AudioSrcMouseClicked
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
        if (fileChooser.showOpenDialog(Form_Songs.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            audioPathSong = selectedFile.getAbsolutePath();
            lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\audioOK.png"));
        }
    }//GEN-LAST:event_lb_AudioSrcMouseClicked

    private void lb_ImagePathSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ImagePathSongMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Songs.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathSong = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePathSong);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(107, 107, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_ImagePathSong.setIcon(imageIcon);
        }
    }//GEN-LAST:event_lb_ImagePathSongMouseClicked

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.timkiemSong(text);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void lb_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_themMouseClicked
        try {
            int SongID = Integer.parseInt(edt_songID.getText());
            int CategoryID = cbb_category.getSelectedIndex() + 1;
            int AlbumID = cbb_album.getSelectedIndex() + 1;
            int ArtistID = cbb_artist.getSelectedIndex() + 1;
            String ImagePathSong = imagePathSong;
            String TitleSong = edt_titleSong.getText();
            String AudioSrc = audioPathSong;
            int Like = 0;
            if (CheckLoi.checkKey(edt_songID.getText(), "songs")) {
                MusicApp.addSong(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like);
                JOptionPane.showMessageDialog(this, "Thêm Song thành công!");
                edt_songID.setText(null);
                edt_titleSong.setText(null);
                cbb_album.setSelectedIndex(0);
                cbb_artist.setSelectedIndex(0);
                cbb_category.setSelectedIndex(0);
                audioPathSong = "";
                lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addfile.png"));
                lb_ImagePathSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();
            } else {
                JOptionPane.showMessageDialog(this, "Song ID đã tồn tại");
                edt_songID.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_themMouseClicked

    private void updateSongInfo(Model_Song song) {
        edt_songID.setText(String.valueOf(song.getSongID()));
        edt_titleSong.setText(song.getTitleSong());
        cbb_album.setSelectedItem(song.getAlbumID());
        cbb_artist.setSelectedItem(song.getArtistID());
        cbb_category.setSelectedItem(song.getCategoryID());
        ImageIcon imageIcon = new ImageIcon(song.getImagePathSong());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_ImagePathSong.setIcon(imageIcon);
        imagePathSong = song.getImagePathSong();
        audioPathSong = song.getAudioSrc();
        lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\audioOK.png"));
    }
    private void themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themMouseClicked
        int ThemID = 0;
        List<Model_Song> songs = MusicApp.getAllSongs();
        ThemID = songs.size(); // Đếm số lượng người dùng trực tiếp
        edt_songID.setText(String.valueOf(ThemID + 1));
    }//GEN-LAST:event_themMouseClicked

    private void lb_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_suaMouseClicked
        try {
            int SongID = Integer.parseInt(edt_songID.getText());
            int CategoryID = cbb_category.getSelectedIndex() + 1;
            int AlbumID = cbb_album.getSelectedIndex() + 1;
            int ArtistID = cbb_artist.getSelectedIndex() + 1;
            String ImagePathSong = imagePathSong;
            String TitleSong = edt_titleSong.getText();
            String AudioSrc = audioPathSong;
            int Like = 0;
            MusicApp.updateSong(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like);
            JOptionPane.showMessageDialog(this, "Sửa Album thành công!");
            edt_songID.setText(null);
            edt_titleSong.setText(null);
            cbb_album.setSelectedIndex(0);
            cbb_artist.setSelectedIndex(0);
            cbb_category.setSelectedIndex(0);
            audioPathSong = "";
            lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addfile.png"));
            lb_ImagePathSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            updatedata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_suaMouseClicked

    private void lb_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_xoaMouseClicked
        try {
            int SongID = Integer.parseInt(edt_songID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Song này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MusicApp.deleteSong(SongID);
                JOptionPane.showMessageDialog(this, "Xóa Song thành công!");
                edt_songID.setText(null);
                edt_titleSong.setText(null);
                cbb_album.setSelectedIndex(1);
                cbb_artist.setSelectedIndex(1);
                cbb_category.setSelectedIndex(1);
                audioPathSong = "";
                lb_AudioSrc.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addfile.png"));
                lb_ImagePathSong.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_xoaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_album;
    private javax.swing.JComboBox<String> cbb_artist;
    private javax.swing.JComboBox<String> cbb_category;
    private javax.swing.JTextField edt_songID;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JTextField edt_titleSong;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_AudioSrc;
    private javax.swing.JLabel lb_ImagePathSong;
    private javax.swing.JLabel lb_sua;
    private javax.swing.JLabel lb_them;
    private javax.swing.JLabel lb_xoa;
    private com.mycompany.musicapp.list.ListSong_V listSong_V;
    private javax.swing.JScrollPane scrollSong;
    private javax.swing.JLabel them;
    // End of variables declaration//GEN-END:variables

    private void updatedata() {
        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.getAllSongs();
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }
}
