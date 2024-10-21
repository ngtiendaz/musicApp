package com.mycompany.musicapp;

import com.mycompany.musicapp.form.Form_Home;
import com.mycompany.musicapp.formAdmin.Form_Albums;
import com.mycompany.musicapp.formAdmin.Form_Artist;
import com.mycompany.musicapp.formAdmin.Form_Category;
import com.mycompany.musicapp.formAdmin.Form_Songs;
import com.mycompany.musicapp.formAdmin.Form_User;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Admin extends javax.swing.JFrame {

    private Form_Songs fSong;
    private Form_Albums fAlbum;
    private Form_Category fCategory;
    private Form_Artist fArtist;
    private Form_User fUser;

    public Admin() {
        initComponents();
        fSong = new Form_Songs();
        fAlbum = new Form_Albums();
        fArtist = new Form_Artist();
        fCategory = new Form_Category();
        fUser = new Form_User();
        setVisible(true);

        admin_Menu1.initMoving(Admin.this);
        admin_Menu1.addEventMenuSelected((int index) -> {
            switch (index) {
                case 0 ->
                    setForm(fSong);
                case 1 ->
                    setForm(fAlbum);
                case 2 -> {
                    setForm(fArtist);
                }
                case 3 ->
                    setForm(fCategory);
                case 4 ->
                    setForm(fUser);

                case 6 -> {
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
                default -> {
                }
            }
        });
        setForm(fSong);
        Form_Songs song = (Form_Songs) setForm.getComponent(0);
    }

    private void setForm(JComponent com) {
        setForm.removeAll();
        setForm.add(com);
        setForm.repaint();
        setForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        setForm = new javax.swing.JPanel();
        admin_Menu1 = new com.mycompany.musicapp.formAdmin.Admin_Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        panelMain.setBackground(new java.awt.Color(204, 204, 204));
        panelMain.setMaximumSize(new java.awt.Dimension(1000, 700));
        panelMain.setMinimumSize(new java.awt.Dimension(1000, 700));
        panelMain.setPreferredSize(new java.awt.Dimension(1000, 700));

        setForm.setBackground(new java.awt.Color(102, 102, 102));
        setForm.setMaximumSize(new java.awt.Dimension(700, 700));
        setForm.setMinimumSize(new java.awt.Dimension(700, 700));
        setForm.setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout setFormLayout = new javax.swing.GroupLayout(setForm);
        setForm.setLayout(setFormLayout);
        setFormLayout.setHorizontalGroup(
            setFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        setFormLayout.setVerticalGroup(
            setFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(admin_Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(setForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addComponent(setForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1213, 1213, 1213))
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(admin_Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.musicapp.formAdmin.Admin_Menu admin_Menu1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel setForm;
    // End of variables declaration//GEN-END:variables

}
