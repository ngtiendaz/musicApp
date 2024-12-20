package com.mycompany.musicapp;

import com.mycompany.musicapp.formAdmin.Form_AdminProfile;
import com.mycompany.musicapp.formAdmin.Form_Albums;
import com.mycompany.musicapp.formAdmin.Form_Artist;
import com.mycompany.musicapp.formAdmin.Form_Category;
import com.mycompany.musicapp.formAdmin.Form_Songs;
import com.mycompany.musicapp.formAdmin.Form_ThongKe;

import com.mycompany.musicapp.formAdmin.Form_User;
import com.mycompany.musicapp.model.Model_User;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Main_Admin extends javax.swing.JFrame {

    private Form_Songs Song;
    private Form_Albums Album;
    private Form_Category Category;
    private Form_Artist Artist;
    private Form_User User;
    private Form_ThongKe thongke;
    private Form_AdminProfile profile;

    private static Model_User user;

    public Main_Admin(Model_User user) {
        initComponents();
        profile = new Form_AdminProfile();
        thongke = new Form_ThongKe();
        Song = new Form_Songs();
        Album = new Form_Albums();
        Artist = new Form_Artist();
        Category = new Form_Category();
        User = new Form_User();
        admin_Menu.initMoving(Main_Admin.this);
        admin_Menu.addEventMenuSelected((int index) -> {
            switch (index) {
                case 0 ->
                    setForm(Song);
                case 1 ->
                    setForm(Album);
                case 2 -> {
                    setForm(Artist);
                }
                case 3 ->
                    setForm(Category);
                case 4 ->
                    setForm(User);
                case 6 ->
                    setForm(thongke);
                case 7 -> {
                    setForm(profile);
                    profile.updateUser(user);
                }
                case 8 -> {
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất tài khoản này ?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        Login_Main login = new Login_Main();
                        setVisible(false);
                        login.setVisible(true);
                    }
                }
                default -> {
                }
            }
        });
        setForm(Song);

    }

    private void setForm(JComponent daz) {
        panelForm.removeAll();
        panelForm.add(daz);
        panelForm.repaint();
        panelForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        admin_Menu = new com.mycompany.musicapp.formAdmin.Admin_Menu();
        panelForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));

        panelMain.setBackground(new java.awt.Color(0, 0, 0));
        panelMain.setMaximumSize(new java.awt.Dimension(1000, 650));
        panelMain.setMinimumSize(new java.awt.Dimension(1000, 650));
        panelMain.setPreferredSize(new java.awt.Dimension(1000, 650));

        admin_Menu.setMaximumSize(new java.awt.Dimension(200, 650));
        admin_Menu.setMinimumSize(new java.awt.Dimension(200, 650));
        admin_Menu.setPreferredSize(new java.awt.Dimension(200, 650));

        panelForm.setBackground(new java.awt.Color(204, 255, 255));
        panelForm.setMaximumSize(new java.awt.Dimension(700, 650));
        panelForm.setMinimumSize(new java.awt.Dimension(800, 650));
        panelForm.setPreferredSize(new java.awt.Dimension(800, 650));
        panelForm.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(admin_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admin_Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Admin(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.musicapp.formAdmin.Admin_Menu admin_Menu;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
