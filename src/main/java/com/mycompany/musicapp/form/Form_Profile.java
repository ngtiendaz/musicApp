package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventSongSelected;
import com.mycompany.musicapp.model.Model_Song;
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

public class Form_Profile extends javax.swing.JPanel {

    private static Model_Song selectedSong;
    int UserID;
    private EventSongSelected eventSongSelected;
    String imagePathUser = "";
    String pass = "";
    String nameUser = "";
    String role = "";
    String email = "";

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Profile.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    private Model_User user;

    public Form_Profile() {
        initComponents();
        init();
        ((DefaultListModel) listSong_V1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.getRecentlyPlayedSongsByUser(UserID);
            for (Model_Song song : songs) {
                listSong_V1.addItem(song);
            }
        });
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scollSong.setVerticalScrollBar(new ScrollBar());
        scollSong.getVerticalScrollBar().setBackground(Color.BLACK);
        scollSong.getViewport().setBackground(Color.BLACK);
        scollSong.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listSong_V1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V1.getSelectedValue());
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
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#373B44"), getWidth(), getHeight(), Color.decode("#73C8A9"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public void updateUser(Model_User user) {
        this.user = user;
        edt_name.setText(user.getNameUser());
        edt_email.setText(user.getEmail());
        //lb_pass.setText(user.getPass());
        ImageIcon imageIcon = new ImageIcon(user.getImagePathUser());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageUser.setIcon(imageIcon);
        lb_role.setText(user.getRole());
        UserID = user.getUserID();

        nameUser = user.getNameUser();
        email = user.getEmail();
        pass = user.getPass();
        role = user.getRole();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imageUser = new javax.swing.JLabel();
        edt_name = new javax.swing.JLabel();
        edt_email = new javax.swing.JLabel();
        addImage = new javax.swing.JLabel();
        lb_role = new javax.swing.JLabel();
        scollSong = new javax.swing.JScrollPane();
        listSong_V1 = new com.mycompany.musicapp.list.ListSong_V();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        lb_imageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/ad_artist.png"))); // NOI18N

        edt_name.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        edt_name.setForeground(new java.awt.Color(255, 255, 255));
        edt_name.setText("NameUser");

        edt_email.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        edt_email.setForeground(new java.awt.Color(255, 255, 255));
        edt_email.setText("Email@gmail.com");

        addImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/pencil.png"))); // NOI18N
        addImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addImageMouseClicked(evt);
            }
        });

        lb_role.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_role.setForeground(new java.awt.Color(255, 255, 255));
        lb_role.setText("Role");

        scollSong.setBorder(null);
        scollSong.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scollSong.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listSong_V1.setBorder(null);
        scollSong.setViewportView(listSong_V1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bài hát đã nghe gần đây:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scollSong, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(edt_name))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edt_email))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_role)))
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addImage))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lb_imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(addImage)
                        .addGap(20, 20, 20)
                        .addComponent(lb_role)
                        .addGap(0, 0, 0)
                        .addComponent(edt_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edt_email)))
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(scollSong, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ((DefaultListModel) listSong_V1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.getRecentlyPlayedSongsByUser(UserID);
            for (Model_Song song : songs) {
                listSong_V1.addItem(song);
            }
        });
    }//GEN-LAST:event_jLabel1MouseClicked

    private void addImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addImageMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showOpenDialog(Form_Profile.this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePathUser = selectedFile.getAbsolutePath();
            MusicApp.updateUser(UserID, email, pass, imagePathUser, nameUser, role);
            updateUser(user);

            JOptionPane.showMessageDialog(this, "Cập nhật ảnh thành công");
            ImageIcon imageIcon = new ImageIcon(imagePathUser);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imageUser.setIcon(imageIcon);
        }
    }//GEN-LAST:event_addImageMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addImage;
    private javax.swing.JLabel edt_email;
    private javax.swing.JLabel edt_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_imageUser;
    private javax.swing.JLabel lb_role;
    private com.mycompany.musicapp.list.ListSong_V listSong_V1;
    private javax.swing.JScrollPane scollSong;
    // End of variables declaration//GEN-END:variables

    private void init() {
        ((DefaultListModel) listSong_V1.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.getRecentlyPlayedSongsByUser(UserID);
            for (Model_Song song : songs) {
                listSong_V1.addItem(song);
            }
        });

    }
}
