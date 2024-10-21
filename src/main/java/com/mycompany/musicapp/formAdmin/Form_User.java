package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.CheckLoi;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_User;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_User extends javax.swing.JPanel {

    private String imagePathUser;

    public Form_User() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollUser.setVerticalScrollBar(new ScrollBar());
        scrollUser.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollUser.getViewport().setBackground(Color.BLACK);
        scrollUser.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        listUser.getSelectionModel().addListSelectionListener(e -> {
            Model_User selectedUser = (Model_User) listUser.getSelectedValue();
            if (selectedUser != null) {
                updateUserInfo(selectedUser);
            } else {
                edt_email.setText(null);
                edt_pass.setText(null);
                edt_username.setText(null);
                edt_userID.setText(null);
                imagePathUser = "";
                lb_imageUser.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            }
        });
    }

    private void updateUserInfo(Model_User user) {
        edt_userID.setText(String.valueOf(user.getUserID()));
        edt_email.setText(user.getEmail());
        edt_pass.setText(user.getPass());
        edt_username.setText(user.getNameUser());
        ImageIcon imageIcon = new ImageIcon(user.getImagePathUser());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageUser.setIcon(imageIcon);
        imagePathUser = user.getImagePathUser();
    }

    private void updatedata() {
        ((DefaultListModel) listUser.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_User> users = MusicApp.getAllUser();
            for (Model_User user : users) {
                listUser.addItem(user);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollUser = new javax.swing.JScrollPane();
        listUser = new com.mycompany.musicapp.list.ListUser();
        themID = new javax.swing.JLabel();
        edt_timkiem = new javax.swing.JTextField();
        lb_xoa = new javax.swing.JLabel();
        lb_sua = new javax.swing.JLabel();
        lb_them = new javax.swing.JLabel();
        edt_userID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edt_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edt_pass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edt_username = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lb_imageUser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        scrollUser.setBorder(null);
        scrollUser.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollUser.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listUser.setBorder(null);
        scrollUser.setViewportView(listUser);

        themID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        themID.setForeground(new java.awt.Color(255, 255, 255));
        themID.setText("UserID:");
        themID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themIDMouseClicked(evt);
            }
        });

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

        edt_userID.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UserName:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ImagePath:");

        lb_imageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N
        lb_imageUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_imageUserMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/find.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollUser)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(themID)
                                .addGap(71, 71, 71))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edt_email)
                            .addComponent(edt_userID)
                            .addComponent(edt_pass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edt_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(lb_them)
                        .addGap(18, 18, 18)
                        .addComponent(lb_sua))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(42, 42, 42)
                        .addComponent(lb_imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lb_xoa)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(themID)
                            .addComponent(edt_userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(edt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(edt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lb_imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_xoa)
                        .addComponent(lb_sua)
                        .addComponent(lb_them)))
                .addGap(20, 20, 20)
                .addComponent(scrollUser, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listUser.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_User> users = MusicApp.timkiemUser(text);
            for (Model_User user : users) {
                listUser.addItem(user);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void lb_imageUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_imageUserMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_User.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathUser = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePathUser);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imageUser.setIcon(imageIcon);
        }
    }//GEN-LAST:event_lb_imageUserMouseClicked

    private void lb_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_themMouseClicked
        try {
            int UserID = Integer.parseInt(edt_userID.getText());
            String Email = edt_email.getText();
            String Pass = edt_pass.getText();
            String ImagePathUser = imagePathUser;
            String NameUser = edt_username.getText();
            String role = "user";
            if (CheckLoi.checkEmail(Email) != null && CheckLoi.checkPassword(Pass) != null) {
                if (CheckLoi.checkKey(edt_userID.getText(), "user")) {
                    MusicApp.addUser(UserID, Email, Pass, ImagePathUser, NameUser, role);
                    JOptionPane.showMessageDialog(this, "Thêm User thành công!");
                    edt_email.setText(null);
                    edt_pass.setText(null);
                    edt_username.setText(null);
                    edt_userID.setText(null);
                    imagePathUser = "";
                    lb_imageUser.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                    updatedata();

                } else {
                    JOptionPane.showMessageDialog(this, "UserID đã tồn tại");
                    edt_userID.setText(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email hoặc password không hợp lệ!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_themMouseClicked

    private void lb_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_suaMouseClicked
        try {
            int UserID = Integer.parseInt(edt_userID.getText());
            String Email = edt_email.getText();
            String Pass = edt_pass.getText();
            String ImagePathUser = imagePathUser;
            String NameUser = edt_username.getText();
            String role = "user";

            MusicApp.updateUser(UserID, Email, Pass, ImagePathUser, NameUser, role);
            JOptionPane.showMessageDialog(this, "Sửa User thành công!");

            edt_userID.setText(null);
            edt_email.setText(null);
            edt_pass.setText(null);
            edt_username.setText(null);

            imagePathUser = "";
            lb_imageUser.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
            updatedata();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_suaMouseClicked

    private void lb_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_xoaMouseClicked
        try {
            int UserID = Integer.parseInt(edt_userID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa User này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MusicApp.deleteUser(UserID);
                JOptionPane.showMessageDialog(this, "Xóa User thành công!");
                edt_email.setText(null);
                edt_pass.setText(null);
                edt_username.setText(null);
                edt_userID.setText(null);
                imagePathUser = "";
                lb_imageUser.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\addimg2.png"));
                updatedata();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_lb_xoaMouseClicked

    private void themIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themIDMouseClicked
        int ThemID = 0;
        List<Model_User> users = MusicApp.getAllUser();
        ThemID = users.size(); // Đếm số lượng người dùng trực tiếp
        edt_userID.setText(String.valueOf(ThemID + 2));
    }//GEN-LAST:event_themIDMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edt_email;
    private javax.swing.JTextField edt_pass;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JTextField edt_userID;
    private javax.swing.JTextField edt_username;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb_imageUser;
    private javax.swing.JLabel lb_sua;
    private javax.swing.JLabel lb_them;
    private javax.swing.JLabel lb_xoa;
    private com.mycompany.musicapp.list.ListUser listUser;
    private javax.swing.JScrollPane scrollUser;
    private javax.swing.JLabel themID;
    // End of variables declaration//GEN-END:variables
}
