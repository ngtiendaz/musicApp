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
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Form_Next_Artist extends javax.swing.JPanel {

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Next_Artist.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    int ID;
    int UserID;
    private Model_User user;

    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;
    private boolean isFlow;

    public Form_Next_Artist() {
        initComponents();
        JPanel p = new JPanel();
        //p.setBackground(Color.BLACK);
        scrollArtist.setVerticalScrollBar(new ScrollBar());
        scrollArtist.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollArtist.getViewport().setBackground(Color.BLACK);
        scrollArtist.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listSong_V.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V.getSelectedValue());
                if (eventSongSelected != null) {
                    eventSongSelected.selected(selectedSong);
                }
            }
        });

    }

    public void updateUser(Model_User user) {
        this.user = user;
        UserID = user.getUserID();

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

    public void updateArtistinfo(String ImagePathArtist, String Name, int ArtistID, int Flow) {
        if (ImagePathArtist != null && !ImagePathArtist.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(ImagePathArtist);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imgArtist.setIcon(imageIcon);
        }
        ID = ArtistID;

        if (Name != null && !Name.isEmpty()) {
            lb_nameArtist.setText(Name + ".");
        }
        if (Flow == 1) {
            isFlow = true;
            btn_follow.setText("Đang theo dõi");

        } else {
            isFlow = false;
            btn_follow.setText("Theo dõi");

        }

        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Artist_Song(ID);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imgArtist = new javax.swing.JLabel();
        scrollArtist = new javax.swing.JScrollPane();
        listSong_V = new com.mycompany.musicapp.list.ListSong_V();
        lb_nameArtist = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_follow = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nhan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        lb_imgArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/credit-card.png"))); // NOI18N

        scrollArtist.setBorder(null);

        listSong_V.setBorder(null);
        scrollArtist.setViewportView(listSong_V);

        lb_nameArtist.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        lb_nameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameArtist.setText("Vũ.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("88.7k followers");

        btn_follow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_follow.setText("Theo Dõi\n");
        btn_follow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_followActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/tichxanh.png"))); // NOI18N
        jLabel4.setText("Nghệ sĩ đã được xác minh.");

        nhan.setForeground(new java.awt.Color(255, 255, 255));
        nhan.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_imgArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_follow)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_nameArtist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nhan)
                                .addGap(87, 87, 87))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addContainerGap())))
            .addComponent(scrollArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_imgArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_nameArtist)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(btn_follow)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(nhan)))))
                .addGap(19, 19, 19)
                .addComponent(scrollArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_followActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_followActionPerformed
        if (isFlow) {
            // Nếu đang follow, bỏ follow
            MusicApp.updateFlow(ID, 0);
            btn_follow.setText("Theo dõi");
            MusicApp.deleteFollowers(UserID, ID);

            isFlow = false;
        } else {
            MusicApp.updateFlow(ID, 1);
            btn_follow.setText("Đang theo dõi");
            MusicApp.addFollowers(UserID, ID);
            isFlow = true;
        }
    }//GEN-LAST:event_btn_followActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_follow;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_imgArtist;
    private javax.swing.JLabel lb_nameArtist;
    private com.mycompany.musicapp.list.ListSong_V listSong_V;
    private javax.swing.JLabel nhan;
    private javax.swing.JScrollPane scrollArtist;
    // End of variables declaration//GEN-END:variables
}
