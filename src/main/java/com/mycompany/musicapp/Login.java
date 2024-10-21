package com.mycompany.musicapp;

import com.mycompany.musicapp.form_login.Form_Admin;
import com.mycompany.musicapp.form_login.Form_Register;
import com.mycompany.musicapp.form_login.Form_SignIn;
import javax.swing.JComponent;

public class Login extends javax.swing.JFrame {

    private Form_SignIn signin;
    private Form_Register register;
    private Form_Admin admin;

    public Login() {
        initComponents();
        signin = new Form_SignIn();
        register = new Form_Register();
        admin = new Form_Admin();
        setForm(signin);
        signin.setLogin(this);
        register.setLogin(this);
        admin.setLogin(this);
    }

    public void setForm(JComponent daz) {
        panelThayDoi.removeAll();
        panelThayDoi.add(daz);
        panelThayDoi.repaint();
        panelThayDoi.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_anh = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelThayDoi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(900, 500));

        panel_anh.setBackground(new java.awt.Color(255, 255, 255));
        panel_anh.setMaximumSize(new java.awt.Dimension(470, 500));
        panel_anh.setMinimumSize(new java.awt.Dimension(470, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/a201.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Spotify");

        javax.swing.GroupLayout panel_anhLayout = new javax.swing.GroupLayout(panel_anh);
        panel_anh.setLayout(panel_anhLayout);
        panel_anhLayout.setHorizontalGroup(
            panel_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_anhLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(panel_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        panel_anhLayout.setVerticalGroup(
            panel_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_anhLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelThayDoi.setBackground(new java.awt.Color(51, 51, 51));
        panelThayDoi.setMaximumSize(new java.awt.Dimension(430, 500));
        panelThayDoi.setMinimumSize(new java.awt.Dimension(430, 500));
        panelThayDoi.setPreferredSize(new java.awt.Dimension(430, 500));
        panelThayDoi.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelThayDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelThayDoi, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelThayDoi;
    private javax.swing.JPanel panel_anh;
    // End of variables declaration//GEN-END:variables
}
