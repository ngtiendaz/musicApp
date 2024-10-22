package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventArtistSelected;
import com.mycompany.musicapp.model.Model_Artist;
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

public class Form_Following extends javax.swing.JPanel {

    int Flow = 1;
    int UserID;
    private Model_User user;
    private EventArtistSelected eventArtistSelected;
    private static Model_Artist selectedArtist;

    public EventArtistSelected getEventArtistSelected() {
        return eventArtistSelected;
    }

    public void setEventArtistSelected(EventArtistSelected eventArtistSelected) {
        this.eventArtistSelected = eventArtistSelected;
    }

    public static Model_Artist getSelectedArtist() {
        return selectedArtist;
    }

    public static void setSelectedArtist(Model_Artist selectedArtist) {
        Form_Following.selectedArtist = selectedArtist;
    }

    public Form_Following() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);

        scrollArtist.setVerticalScrollBar(new ScrollBar());
        scrollArtist.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollArtist.getViewport().setBackground(Color.BLACK);
        scrollArtist.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        ((DefaultListModel) listArtist_Ngang.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.getFollowedArtistsByUser(UserID);
            for (Model_Artist artist : artists) {
                listArtist_Ngang.addItem(artist);
            }
        });
        listArtist_Ngang.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedArtist((Model_Artist) listArtist_Ngang.getSelectedValue());
                if (eventArtistSelected != null) {
                    eventArtistSelected.selected(selectedArtist);
                }
            }
        });

    }

    public void updateUser(Model_User user) {
        this.user = user;
        lb_nameUser.setText(user.getNameUser() + ".");
        ImageIcon imageIcon = new ImageIcon(user.getImagePathUser());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_avtUser.setIcon(imageIcon);
        UserID = user.getUserID();

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#373B44"), getWidth(), getHeight(), Color.decode("#4286f4"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollArtist = new javax.swing.JScrollPane();
        listArtist_Ngang = new com.mycompany.musicapp.list.ListArtist_Ngang();
        jLabel3 = new javax.swing.JLabel();
        loadData = new javax.swing.JLabel();
        lb_avtUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_nameUser = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nghệ Sĩ Yêu Thích ");

        scrollArtist.setBorder(null);
        scrollArtist.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollArtist.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listArtist_Ngang.setBorder(null);
        scrollArtist.setViewportView(listArtist_Ngang);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Playlist");

        loadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/load.png"))); // NOI18N
        loadData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadDataMouseClicked(evt);
            }
        });

        lb_avtUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_avtUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/addimg2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("dành riêng cho");

        lb_nameUser.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lb_nameUser.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameUser.setText("Daz.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollArtist)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_avtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nameUser)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadData)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lb_nameUser)))
                    .addComponent(lb_avtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(loadData)
                .addGap(18, 18, 18)
                .addComponent(scrollArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadDataMouseClicked
        ((DefaultListModel) listArtist_Ngang.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Artist> artists = MusicApp.getFollowedArtistsByUser(UserID);
            for (Model_Artist artist : artists) {
                listArtist_Ngang.addItem(artist);
            }
        });
    }//GEN-LAST:event_loadDataMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb_avtUser;
    private javax.swing.JLabel lb_nameUser;
    private com.mycompany.musicapp.list.ListArtist_Ngang listArtist_Ngang;
    private javax.swing.JLabel loadData;
    private javax.swing.JScrollPane scrollArtist;
    // End of variables declaration//GEN-END:variables
}
