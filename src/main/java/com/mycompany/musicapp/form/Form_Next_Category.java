package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventCategorySelected;
import com.mycompany.musicapp.event.EventSongSelected;
import static com.mycompany.musicapp.form.Form_Next_Artist.setSelectedSong;
import com.mycompany.musicapp.model.Model_Category;
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

public class Form_Next_Category extends javax.swing.JPanel {

    int ID;
    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Next_Category.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    public Form_Next_Category() {
        initComponents();
        JPanel p = new JPanel();
        listSong_V.setOpaque(false);
        listSong_V.setBackground(new Color(0, 0, 0, 0));
        //p.setBackground(Color.BLACK);
        scrollCategory.setVerticalScrollBar(new ScrollBar());
        scrollCategory.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollCategory.getViewport().setBackground(Color.BLACK);
        scrollCategory.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        listSong_V.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V.getSelectedValue());
                if (eventSongSelected != null) {
                    eventSongSelected.selected(selectedSong);
                }
            }
        });

    }

    public void updateCategoryinfo(String ImagePathCategory, String TitleCategory, int CategoryID) {
        if (ImagePathCategory != null && !ImagePathCategory.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(ImagePathCategory);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lb_imageCategory.setIcon(imageIcon);
        }
        ID = CategoryID;
        if (TitleCategory != null && !TitleCategory.isEmpty()) {
            lb_nameCategory.setText(TitleCategory + ".");
        }

        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.Category_Song(ID);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo một GradientPaint từ màu đầu đến màu cuối
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#8e9eab"), getWidth(), getHeight(), Color.decode("#eef2f3"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollCategory = new javax.swing.JScrollPane();
        listSong_V = new com.mycompany.musicapp.list.ListSong_V();
        lb_imageCategory = new javax.swing.JLabel();
        lb_nameCategory = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loadData = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        scrollCategory.setBorder(null);
        scrollCategory.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCategory.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollCategory.setViewportView(listSong_V);

        lb_imageCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/category.png"))); // NOI18N

        lb_nameCategory.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lb_nameCategory.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameCategory.setText("NameCategory");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Playlist.");

        loadData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/play@@.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollCategory)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_imageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_nameCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(loadData)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_imageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(lb_nameCategory))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loadData)))
                .addGap(30, 30, 30)
                .addComponent(scrollCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb_imageCategory;
    private javax.swing.JLabel lb_nameCategory;
    private com.mycompany.musicapp.list.ListSong_V listSong_V;
    private javax.swing.JLabel loadData;
    private javax.swing.JScrollPane scrollCategory;
    // End of variables declaration//GEN-END:variables
}
