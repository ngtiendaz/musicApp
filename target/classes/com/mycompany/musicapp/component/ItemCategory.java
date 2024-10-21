package com.mycompany.musicapp.component;

import com.mycompany.musicapp.model.Model_Category;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ItemCategory extends javax.swing.JPanel {

    private final Model_Category category;

    public ItemCategory(Model_Category category) {
        this.category = category;
        initComponents();
        setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(category.getImagePathCategory());
        Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lb_imageCategory.setIcon(imageIcon);
        if (category.getTitleCategory().length() > 20) {
            lb_nameCategory.setText(category.getTitleCategory().substring(0, 20 - 3) + "...");
        } else {
            lb_nameCategory.setText(category.getTitleCategory());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_imageCategory = new javax.swing.JLabel();
        lb_nameCategory = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lb_imageCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_imageCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/man-avatar.png"))); // NOI18N

        lb_nameCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nameCategory.setForeground(new java.awt.Color(255, 255, 255));
        lb_nameCategory.setText("NameCategory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_imageCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(lb_nameCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_imageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nameCategory)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_imageCategory;
    private javax.swing.JLabel lb_nameCategory;
    // End of variables declaration//GEN-END:variables
}
