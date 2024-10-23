package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.ModelChart;
import java.awt.Color;

public class Form_ThongKe2 extends javax.swing.JPanel {

    public Form_ThongKe2() {
        initComponents();
        //getContentPane().setBackground(new Color(250, 250, 250));
        chart.addLegend("Rap", new Color(245, 189, 135));
        chart.addLegend("Balland", new Color(135, 189, 245));
        chart.addLegend("POP", new Color(189, 135, 245));
        chart.addLegend("Indie", new Color(139, 229, 222));
        chart.addData(new ModelChart("Tháng 5", MusicApp.getSongLikesByCategoriesForMonth(5)));
        chart.addData(new ModelChart("Tháng 6", MusicApp.getSongLikesByCategoriesForMonth(6)));
        chart.addData(new ModelChart("Tháng 7", MusicApp.getSongLikesByCategoriesForMonth(7)));
        chart.addData(new ModelChart("Tháng 8", MusicApp.getSongLikesByCategoriesForMonth(8)));
        chart.addData(new ModelChart("Tháng 9", MusicApp.getSongLikesByCategoriesForMonth(9)));
        chart.addData(new ModelChart("Tháng 10", MusicApp.getSongLikesByCategoriesForMonth(10)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new com.mycompany.musicapp.formAdmin.Chart();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thể loại nhạc được yêu thích 6 tháng gần đây:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.musicapp.formAdmin.Chart chart;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
