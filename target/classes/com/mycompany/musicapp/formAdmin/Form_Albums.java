package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.form.Form_Add;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.print.FieldReportAlbum;
import com.mycompany.musicapp.print.ParameterReportAlbum;
import com.mycompany.musicapp.print.ReportManager;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_Albums extends javax.swing.JPanel {

    String imagePathAlbum = "";
    int AlbumID;
    String TenAlbum;

    public Form_Albums() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollAlbum.setVerticalScrollBar(new ScrollBar());
        scrollAlbum.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollAlbum.getViewport().setBackground(Color.BLACK);
        scrollAlbum.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        loadArtistToComboBox();
        listAlbum_Ngang2.getSelectionModel().addListSelectionListener(e -> {
            Model_Album selectedAlbum = (Model_Album) listAlbum_Ngang2.getSelectedValue();
            if (selectedAlbum != null) {
                updateAlbumInfo(selectedAlbum);
            } else {
                edt_albumID.setText(null);
                edt_titleAlbum.setText(null);
                cbb_artistID.setSelectedIndex(0);
                imagePathAlbum = "";
                lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            }
        });

    }

    private void updateAlbumInfo(Model_Album album) {
        edt_albumID.setText(String.valueOf(album.getAlbumID()));
        edt_titleAlbum.setText(album.getTitleAlbum());
        cbb_artistID.setSelectedItem(album.getNameArtist());
        ImageIcon imageIcon = new ImageIcon(album.getImagePathAlbum());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageAlbum.setIcon(imageIcon);
        imagePathAlbum = album.getImagePathAlbum();
        AlbumID = album.getAlbumID();
        TenAlbum = album.getTitleAlbum();
    }

    private void updatedata() {
        ((DefaultListModel) listAlbum_Ngang2.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Album> albums = MusicApp.getAllAlbum();
            for (Model_Album album : albums) {
                listAlbum_Ngang2.addItem(album);
            }
        });
    }

    private void loadArtistToComboBox() {
        try {
            List<Model_Artist> artistList = MusicApp.getAllArtists();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Model_Artist artist : artistList) {
                model.addElement(artist);
                cbb_artistID.addItem(artist.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edt_timkiem = new javax.swing.JTextField();
        scrollAlbum = new javax.swing.JScrollPane();
        listAlbum_Ngang2 = new com.mycompany.musicapp.list.ListAlbum_Ngang();
        lb_them = new javax.swing.JLabel();
        lb_sua = new javax.swing.JLabel();
        lb_xoa = new javax.swing.JLabel();
        themID = new javax.swing.JLabel();
        edt_albumID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edt_titleAlbum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lb_imageAlbum = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbb_artistID = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        edt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edt_timkiemKeyReleased(evt);
            }
        });

        scrollAlbum.setBorder(null);
        scrollAlbum.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAlbum.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listAlbum_Ngang2.setBorder(null);
        scrollAlbum.setViewportView(listAlbum_Ngang2);

        lb_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_them.setForeground(new java.awt.Color(255, 255, 255));
        lb_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        lb_them.setText("Thêm");
        lb_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_themMouseClicked(evt);
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

        lb_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_xoa.setForeground(new java.awt.Color(255, 255, 255));
        lb_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/xoa.png"))); // NOI18N
        lb_xoa.setText("Xóa");
        lb_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_xoaMouseClicked(evt);
            }
        });

        themID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        themID.setForeground(new java.awt.Color(255, 255, 255));
        themID.setText("AlbumID:");
        themID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themIDMouseClicked(evt);
            }
        });

        edt_albumID.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TitleAlbum:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ImagePath:");

        lb_imageAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageAlbumMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ArtistID:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/find.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/download.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollAlbum)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(themID)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edt_titleAlbum)
                            .addComponent(edt_albumID)
                            .addComponent(cbb_artistID, 0, 128, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addComponent(jLabel6)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel9)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_them)
                        .addGap(18, 18, 18)
                        .addComponent(lb_sua)
                        .addGap(18, 18, 18)
                        .addComponent(lb_xoa)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_imageAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_albumID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themID)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(edt_titleAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lb_imageAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbb_artistID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(lb_them)
                    .addComponent(lb_sua)
                    .addComponent(lb_xoa)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addComponent(scrollAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listAlbum_Ngang2.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Album> albums = MusicApp.timkiemAlbum(text);
            for (Model_Album album : albums) {
                listAlbum_Ngang2.addItem(album);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void lb_imageAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageAlbumMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Albums.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathAlbum = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePathAlbum);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imageAlbum.setIcon(imageIcon);
        }
    }//GEN-LAST:event_lb_imageAlbumMouseClicked

    private void lb_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_themMouseClicked
        try {
            int AlbumID = Integer.parseInt(edt_albumID.getText());
            String TitleAlbum = edt_titleAlbum.getText();
            String ImagePathAlbum = imagePathAlbum;
            int ArtistID = cbb_artistID.getSelectedIndex() + 1;
            if (CheckLoi.checkKey(edt_albumID.getText(), "album")) {
                MusicApp.addAlbum(AlbumID, TitleAlbum, ImagePathAlbum, ArtistID);
                JOptionPane.showMessageDialog(this, "Thêm Album thành công!");
                loadArtistToComboBox();
                edt_albumID.setText(null);
                edt_titleAlbum.setText(null);
                cbb_artistID.setSelectedIndex(0);
                imagePathAlbum = "";
                lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            } else {
                JOptionPane.showMessageDialog(this, "Album ID đã tồn tại");
                edt_albumID.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_themMouseClicked

    private void lb_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_xoaMouseClicked
        try {
            int AlbumID = Integer.parseInt(edt_albumID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Album này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MusicApp.deleteAlbum(AlbumID);
                JOptionPane.showMessageDialog(this, "Xóa Album thành công!");
                loadArtistToComboBox();
                edt_albumID.setText(null);
                edt_titleAlbum.setText(null);
                cbb_artistID.setSelectedIndex(0);
                imagePathAlbum = "";
                lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_xoaMouseClicked

    private void lb_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_suaMouseClicked

        try {
            int AlbumID = Integer.parseInt(edt_albumID.getText());
            String TitleAlbum = edt_titleAlbum.getText();
            String ImagePathAlbum = imagePathAlbum;
            int ArtistID = cbb_artistID.getSelectedIndex() + 1;
            MusicApp.updateAlbum(AlbumID, TitleAlbum, ImagePathAlbum, ArtistID);
            JOptionPane.showMessageDialog(this, "Sửa Album thành công!");
            loadArtistToComboBox();
            edt_albumID.setText(null);
            edt_titleAlbum.setText(null);
            cbb_artistID.setSelectedIndex(0);
            imagePathAlbum = "";
            lb_imageAlbum.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            updatedata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_suaMouseClicked

    private void themIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themIDMouseClicked
        int ThemID = 0;
        List<Model_Album> albums = MusicApp.getAllAlbum();
        ThemID = albums.size(); // Đếm số lượng người dùng trực tiếp
        edt_albumID.setText(String.valueOf(ThemID + 1));
    }//GEN-LAST:event_themIDMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            int tongBaiHat = 0;

            List<Model_Song> songList = MusicApp.Album_Song(AlbumID);
            ReportManager.getInstance().compileReport();
            List<FieldReportAlbum> field = new ArrayList<>();
            for (Model_Song song : songList) {
                field.add(new FieldReportAlbum(song.getTitleSong(), song.getNameArtist()));
                tongBaiHat += 1;
            }
//                field.add(new FieldReportHoaDon(LoaiPhong, soNgayO, tongTienPhong));
            ParameterReportAlbum dataprint = new ParameterReportAlbum(TenAlbum, String.valueOf(tongBaiHat), field);
            ReportManager.getInstance().printReportPayment(dataprint);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_artistID;
    private javax.swing.JTextField edt_albumID;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JTextField edt_titleAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_imageAlbum;
    private javax.swing.JLabel lb_sua;
    private javax.swing.JLabel lb_them;
    private javax.swing.JLabel lb_xoa;
    private com.mycompany.musicapp.list.ListAlbum_Ngang listAlbum_Ngang2;
    private javax.swing.JScrollPane scrollAlbum;
    private javax.swing.JLabel themID;
    // End of variables declaration//GEN-END:variables
}
