package com.mycompany.musicapp.component;

import com.mycompany.musicapp.model.Model_Menu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ItemMenu extends javax.swing.JPanel {

    private final Model_Menu data;
    private boolean selected;
    private boolean over;

    public ItemMenu(Model_Menu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        if (null == data.getType()) {
            lbNameMenu.setText("");
        } else {
            switch (data.getType()) {
                case MENU -> {
                    lbIconMenu.setIcon(data.toIcon());
                    lbNameMenu.setText(data.getName());
                }
                case TITLE -> {
                    lbIconMenu.setText(data.getName());
                    lbNameMenu.setFont(new java.awt.Font("Segoe UI", 1, 18));
                    lbNameMenu.setVisible(false);
                }
                default ->
                    lbNameMenu.setText("");
            }
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIconMenu = new javax.swing.JLabel();
        lbNameMenu = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(139, 40));

        lbIconMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNameMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNameMenu.setForeground(new java.awt.Color(255, 255, 255));
        lbNameMenu.setText("ItemName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIconMenu)
                .addGap(15, 15, 15)
                .addComponent(lbNameMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbIconMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbNameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
  @Override
    protected void paintComponent(Graphics g) {
        if (selected || over) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(255, 255, 255, 80));
            } else {
                g2.setColor(new Color(255, 255, 255, 20));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(g);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIconMenu;
    private javax.swing.JLabel lbNameMenu;
    // End of variables declaration//GEN-END:variables
}
