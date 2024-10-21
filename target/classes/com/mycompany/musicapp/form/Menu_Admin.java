package com.mycompany.musicapp.form;

import com.mycompany.musicapp.event.EventMenuSelected;
import com.mycompany.musicapp.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu_Admin extends javax.swing.JPanel {

    private EventMenuSelected event;

    public Menu_Admin() {
        initComponents();
        init();
        setOpaque(false);
        listMenu2.setOpaque(false);
    }

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu2.addEventMenuSelected(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelMoving = new javax.swing.JPanel();
        listMenu2 = new com.mycompany.musicapp.component.list.ListMenu<>();

        setMaximumSize(new java.awt.Dimension(300, 600));
        setMinimumSize(new java.awt.Dimension(300, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/admin.png"))); // NOI18N
        jLabel1.setText("Admin");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        listMenu2.setBorder(null);
        listMenu2.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addComponent(listMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.mycompany.musicapp.component.list.ListMenu<String> listMenu2;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables

    private void init() {
        listMenu2.addItem(new Model_Menu("lib_admin", "Songs", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("ad_artist", "Artists ", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("ad_album", "Albums", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("ad_cate", "Category", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("ad_user", "Users", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("", "Load", Model_Menu.MenuType.TITLE));
        listMenu2.addItem(new Model_Menu("ad_add", "Add", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("logout2", "Logout", Model_Menu.MenuType.MENU));

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#076585"), 0, getHeight(), Color.decode("#fff"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth() - 25, 0, getWidth(), getHeight());
        g2.fillRect(0, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#fff"), 0, getHeight(),
                Color.decode("#fff"));
        g2.setPaint(gradientPaint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }

    private int x;
    private int y;

    public void initMoving(JFrame frame) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }
}
