package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Category;
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

public class Form_Category extends javax.swing.JPanel {

    String imagePathCategory = "";
    int CategoryID;
    String TenCate;

    public Form_Category() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollCate.setHorizontalScrollBar(new ScrollBar());
        scrollCate.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollCate.getViewport().setBackground(Color.BLACK);
        scrollCate.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        listCategory1.getSelectionModel().addListSelectionListener(e -> {
            Model_Category selectedCategory = (Model_Category) listCategory1.getSelectedValue();
            if (selectedCategory != null) {
                updateCategoryInfo(selectedCategory);
            } else {
                edt_categoryID.setText(null);
                edt_titleCate.setText(null);
                imagePathCategory = "";
                lb_imagePath.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
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

    private void updateCategoryInfo(Model_Category category) {
        edt_categoryID.setText(String.valueOf(category.getCategoryID()));
        edt_titleCate.setText(category.getTitleCategory());
        ImageIcon imageIcon = new ImageIcon(category.getImagePathCategory());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imagePath.setIcon(imageIcon);
        imagePathCategory = category.getImagePathCategory();
        CategoryID = category.getCategoryID();
        TenCate = category.getTitleCategory();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollCate = new javax.swing.JScrollPane();
        listCategory1 = new com.mycompany.musicapp.list.ListCategory();
        jLabel1 = new javax.swing.JLabel();
        themID = new javax.swing.JLabel();
        edt_categoryID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edt_titleCate = new javax.swing.JTextField();
        edt_timkiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lb_imagePath = new javax.swing.JLabel();
        lb_them = new javax.swing.JLabel();
        lb_sua = new javax.swing.JLabel();
        lb_xoa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        scrollCate.setBorder(null);
        scrollCate.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollCate.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listCategory1.setBorder(null);
        scrollCate.setViewportView(listCategory1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Category");

        themID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        themID.setForeground(new java.awt.Color(255, 255, 255));
        themID.setText("CategoryID:");
        themID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themIDMouseClicked(evt);
            }
        });

        edt_categoryID.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TitleCategory:");

        edt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edt_timkiemKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ImagePath:");

        lb_imagePath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imagePath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imagePath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imagePathMouseClicked(evt);
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/download.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollCate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(themID)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(edt_categoryID)
                                        .addComponent(edt_titleCate, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                    .addComponent(lb_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_xoa)
                                    .addComponent(lb_them)
                                    .addComponent(lb_sua)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addComponent(scrollCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themID)
                    .addComponent(edt_categoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(edt_titleCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb_them)
                        .addGap(20, 20, 20)
                        .addComponent(lb_sua)
                        .addGap(20, 20, 20)
                        .addComponent(lb_xoa)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listCategory1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Category> categorys = MusicApp.timkiemCategory(text);
            for (Model_Category category : categorys) {
                listCategory1.addItem(category);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void lb_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_themMouseClicked
        try {
            int CategoryID = Integer.parseInt(edt_categoryID.getText());
            String TitleCategory = edt_titleCate.getText();
            String ImagePathCategory = imagePathCategory;

            if (CheckLoi.checkKey(edt_categoryID.getText(), "category")) {
                MusicApp.addCategory(CategoryID, TitleCategory, ImagePathCategory);
                JOptionPane.showMessageDialog(this, "Thêm Category thành công!");
                edt_categoryID.setText(null);
                edt_titleCate.setText(null);
                imagePathCategory = "";
                lb_imagePath.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            } else {
                JOptionPane.showMessageDialog(this, "CategoryID đã tồn tại");
                edt_categoryID.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_themMouseClicked

    private void lb_imagePathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imagePathMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Category.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathCategory = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePathCategory);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imagePath.setIcon(imageIcon);
        }
    }//GEN-LAST:event_lb_imagePathMouseClicked

    private void themIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themIDMouseClicked
        int ThemID = 0;
        List<Model_Category> categorys = MusicApp.getAllCategory();
        ThemID = categorys.size(); // Đếm số lượng người dùng trực tiếp
        edt_categoryID.setText(String.valueOf(ThemID + 1));
    }//GEN-LAST:event_themIDMouseClicked

    private void lb_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_suaMouseClicked
        try {
            int CategoryID = Integer.parseInt(edt_categoryID.getText());
            String TitleCategory = edt_titleCate.getText();
            String ImagePathCategory = imagePathCategory;
            MusicApp.updateCategory(CategoryID, TitleCategory, ImagePathCategory);
            JOptionPane.showMessageDialog(this, "Sửa Category thành công!");
            edt_categoryID.setText(null);
            edt_titleCate.setText(null);
            imagePathCategory = "";
            lb_imagePath.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            updatedata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_suaMouseClicked

    private void lb_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_xoaMouseClicked
        try {
            int CategoryID = Integer.parseInt(edt_categoryID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Category này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MusicApp.deleteCategory(CategoryID);
                JOptionPane.showMessageDialog(this, "Xóa Album thành công!");
                edt_categoryID.setText(null);
                edt_titleCate.setText(null);
                imagePathCategory = "";
                lb_imagePath.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lb_xoaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            int tongBaiHat = 0;

            List<Model_Song> songList = MusicApp.Category_Song(CategoryID);
            ReportManager.getInstance().compileReport();
            List<FieldReportAlbum> field = new ArrayList<>();
            for (Model_Song song : songList) {
                field.add(new FieldReportAlbum(song.getTitleSong(), song.getNameArtist()));
                tongBaiHat += 1;
            }
//                field.add(new FieldReportHoaDon(LoaiPhong, soNgayO, tongTienPhong));
            ParameterReportAlbum dataprint = new ParameterReportAlbum(TenCate, String.valueOf(tongBaiHat), field);
            ReportManager.getInstance().printReportPayment(dataprint);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edt_categoryID;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JTextField edt_titleCate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_imagePath;
    private javax.swing.JLabel lb_sua;
    private javax.swing.JLabel lb_them;
    private javax.swing.JLabel lb_xoa;
    private com.mycompany.musicapp.list.ListCategory listCategory1;
    private javax.swing.JScrollPane scrollCate;
    private javax.swing.JLabel themID;
    // End of variables declaration//GEN-END:variables

    private void updatedata() {
        ((DefaultListModel) listCategory1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Category> cates = MusicApp.getAllCategory();
            for (Model_Category cate : cates) {
                listCategory1.addItem(cate);
            }
        });
    }
}
