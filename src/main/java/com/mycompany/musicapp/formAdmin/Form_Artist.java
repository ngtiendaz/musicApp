package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_Artist extends javax.swing.JPanel {

    private String imagePathArtist = "";
    int ArtistID;
    String Name;

    public Form_Artist() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollArtist.setVerticalScrollBar(new ScrollBar());
        scrollArtist.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollArtist.getViewport().setBackground(Color.BLACK);
        scrollArtist.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listArtist_Ngang.getSelectionModel().addListSelectionListener(e -> {
            Model_Artist selectedArtist = (Model_Artist) listArtist_Ngang.getSelectedValue();
            if (selectedArtist != null) {
                updateArtistInfo(selectedArtist);
            } else {
                edt_artistID.setText(null);
                edt_name.setText(null);
                imagePathArtist = "";
                lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            }
        });
    }

    private void updatedata() {
        ((DefaultListModel) listArtist_Ngang.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.getAllArtists();
            for (Model_Artist artist : artists) {
                listArtist_Ngang.addItem(artist);
            }
        });
    }

    private void updateArtistInfo(Model_Artist artist) {
        edt_artistID.setText(String.valueOf(artist.getArtistID()));
        edt_name.setText(artist.getName());

        ImageIcon imageIcon = new ImageIcon(artist.getImagePathArtists());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageArtist.setIcon(imageIcon);
        imagePathArtist = artist.getImagePathArtists();
        ArtistID = artist.getArtistID();
        Name = artist.getName();

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#001510"), getWidth(), getHeight(), Color.decode("#00bf8f"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollArtist = new javax.swing.JScrollPane();
        listArtist_Ngang = new com.mycompany.musicapp.list.ListArtist_Ngang();
        lb_them = new javax.swing.JLabel();
        lb_xoa = new javax.swing.JLabel();
        lb_sua = new javax.swing.JLabel();
        edt_timkiem = new javax.swing.JTextField();
        them = new javax.swing.JLabel();
        edt_artistID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lb_imageArtist = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        scrollArtist.setBorder(null);
        scrollArtist.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollArtist.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listArtist_Ngang.setBorder(null);
        scrollArtist.setViewportView(listArtist_Ngang);

        lb_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_them.setForeground(new java.awt.Color(255, 255, 255));
        lb_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/add.png"))); // NOI18N
        lb_them.setText("Thêm");
        lb_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_themMouseClicked(evt);
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

        edt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edt_timkiemKeyReleased(evt);
            }
        });

        them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        them.setForeground(new java.awt.Color(255, 255, 255));
        them.setText("ArtistID:");
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themMouseClicked(evt);
            }
        });

        edt_artistID.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ImagePath:");

        lb_imageArtist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageArtistMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/find.png"))); // NOI18N

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
            .addComponent(scrollArtist)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(them)
                            .addComponent(jLabel5))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edt_artistID, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(edt_name))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel6)
                        .addGap(54, 54, 54)
                        .addComponent(lb_imageArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_them)
                        .addGap(18, 18, 18)
                        .addComponent(lb_sua)
                        .addGap(18, 18, 18)
                        .addComponent(lb_xoa)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_imageArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(them)
                        .addComponent(edt_artistID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_them)
                        .addComponent(lb_xoa)
                        .addComponent(lb_sua)
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(scrollArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listArtist_Ngang.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.timkiemArtist(text);
            for (Model_Artist artist : artists) {
                listArtist_Ngang.addItem(artist);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void lb_imageArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageArtistMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Artist.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathArtist = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePathArtist);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imageArtist.setIcon(imageIcon);
        }
    }//GEN-LAST:event_lb_imageArtistMouseClicked

    private void lb_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_themMouseClicked
        try {
            int ArtistID = Integer.parseInt(edt_artistID.getText());
            String Name = edt_name.getText();
            String ImagePathArtists = imagePathArtist;

            if (CheckLoi.checkKey(edt_artistID.getText(), "artists")) {
                MusicApp.addArtists(ArtistID, Name, ImagePathArtists, 0);
                JOptionPane.showMessageDialog(this, "Thêm Artist thành công!");

                edt_artistID.setText(null);
                edt_name.setText(null);
                imagePathArtist = "";
                lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            } else {
                JOptionPane.showMessageDialog(this, "Album ID đã tồn tại");
                edt_artistID.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_themMouseClicked

    private void lb_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_suaMouseClicked
        try {
            int ArtistID = Integer.parseInt(edt_artistID.getText());
            String Name = edt_name.getText();
            String ImagePathArtists = imagePathArtist;

            MusicApp.updateArtist(ArtistID, Name, ImagePathArtists, 0);
            JOptionPane.showMessageDialog(this, "Sửa Album thành công!");

            edt_artistID.setText(null);
            edt_name.setText(null);

            imagePathArtist = "";
            lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            // updatedata();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_suaMouseClicked

    private void lb_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_xoaMouseClicked
        try {
            int ArtistID = Integer.parseInt(edt_artistID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Album này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MusicApp.deleteAlbum(ArtistID);
                JOptionPane.showMessageDialog(this, "Xóa Album thành công!");

                edt_artistID.setText(null);
                edt_name.setText(null);

                imagePathArtist = "";
                lb_imageArtist.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_xoaMouseClicked

    private void themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themMouseClicked
        int ThemID = 0;
        List<Model_Artist> artists = MusicApp.getAllArtists();
        ThemID = artists.size(); // Đếm số lượng người dùng trực tiếp
        edt_artistID.setText(String.valueOf(ThemID + 1));
    }//GEN-LAST:event_themMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            int tongBaiHat = 0;

            List<Model_Song> songList = MusicApp.Artist_Song(ArtistID);
            ReportManager.getInstance().compileReport();
            List<FieldReportAlbum> field = new ArrayList<>();
            for (Model_Song song : songList) {
                field.add(new FieldReportAlbum(song.getTitleSong(), song.getNameArtist()));
                tongBaiHat += 1;
            }
//                field.add(new FieldReportHoaDon(LoaiPhong, soNgayO, tongTienPhong));
            ParameterReportAlbum dataprint = new ParameterReportAlbum(Name, String.valueOf(tongBaiHat), field);
            ReportManager.getInstance().printReportPayment(dataprint);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edt_artistID;
    private javax.swing.JTextField edt_name;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb_imageArtist;
    private javax.swing.JLabel lb_sua;
    private javax.swing.JLabel lb_them;
    private javax.swing.JLabel lb_xoa;
    private com.mycompany.musicapp.list.ListArtist_Ngang listArtist_Ngang;
    private javax.swing.JScrollPane scrollArtist;
    private javax.swing.JLabel them;
    // End of variables declaration//GEN-END:variables
}
