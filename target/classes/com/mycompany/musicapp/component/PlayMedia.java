package com.mycompany.musicapp.component;

import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayMedia extends javax.swing.JPanel {

    private boolean isPlaying = false;

    public PlayMedia() {
        initComponents();
        setOpaque(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JLabel();
        btn_play = new javax.swing.JLabel();
        btn_next = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(330, 40));
        setPreferredSize(new java.awt.Dimension(330, 40));

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/skiptostart.png"))); // NOI18N

        btn_play.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/playbig.png"))); // NOI18N
        btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_playMouseClicked(evt);
            }
        });

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/skip2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_back)
                .addGap(10, 10, 10)
                .addComponent(btn_play)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_play, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseClicked
        isPlaying = !isPlaying;
        if (isPlaying) {
            btn_play.setIcon(new ImageIcon("/com/mycompany/musicapp/icon/pausebig.png"));
        } else {
            btn_play.setIcon(new ImageIcon("/com/mycompany/musicapp/icon/playbig.png"));
        }
    }//GEN-LAST:event_btn_playMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_next;
    private javax.swing.JLabel btn_play;
    // End of variables declaration//GEN-END:variables
}
