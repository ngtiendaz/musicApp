package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.event.EventSongSelected;
import static com.mycompany.musicapp.form.Form_Next_Album.setSelectedSong;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Form_Find extends javax.swing.JPanel {

    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Find.selectedSong = selectedSong;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    public Form_Find() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollSong_V.setVerticalScrollBar(new ScrollBar());
        scrollSong_V.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollSong_V.getViewport().setBackground(Color.BLACK);
        scrollSong_V.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        listSong_V.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_V.getSelectedValue());
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
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#1F1C2C"), getWidth(), getHeight(), Color.decode("#928DAB"));
        g2d.setPaint(gradient);

        // Vẽ hình chữ nhật với màu gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        edt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JLabel();
        kq = new javax.swing.JLabel();
        scrollSong_V = new javax.swing.JScrollPane();
        listSong_V = new com.mycompany.musicapp.list.ListSong_V();
        setkq = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ngày hôm nay của bạn thế nào?\n");

        edt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_timkiemActionPerformed(evt);
            }
        });
        edt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edt_timkiemKeyReleased(evt);
            }
        });

        btn_timkiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/find.png"))); // NOI18N

        kq.setBackground(new java.awt.Color(255, 255, 255));
        kq.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kq.setForeground(new java.awt.Color(255, 255, 255));
        kq.setText("Kết quả tìm kiếm:");

        scrollSong_V.setBorder(null);
        scrollSong_V.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSong_V.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollSong_V.setOpaque(false);

        listSong_V.setBackground(new java.awt.Color(0, 0, 0));
        listSong_V.setBorder(null);
        scrollSong_V.setViewportView(listSong_V);

        setkq.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        setkq.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollSong_V)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kq)
                .addGap(10, 10, 10)
                .addComponent(setkq)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kq, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setkq))
                .addGap(20, 20, 20)
                .addComponent(scrollSong_V, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_timkiemKeyReleased
        // TODO add your handling code here:
        String text = edt_timkiem.getText().trim();
        ((DefaultListModel) listSong_V.getModel()).removeAllElements();
        SwingUtilities.invokeLater(() -> {
            List<Model_Song> songs = MusicApp.timkiemSong(text);
            for (Model_Song song : songs) {
                listSong_V.addItem(song);
            }
        });
    }//GEN-LAST:event_edt_timkiemKeyReleased

    private void edt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_timkiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_timkiem;
    private javax.swing.JTextField edt_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kq;
    private com.mycompany.musicapp.list.ListSong_V listSong_V;
    private javax.swing.JScrollPane scrollSong_V;
    private javax.swing.JLabel setkq;
    // End of variables declaration//GEN-END:variables
}
