package com.mycompany.musicapp;

import com.mycompany.musicapp.form.Form_Add;
import com.mycompany.musicapp.form.Form_FavoriteSong;
import com.mycompany.musicapp.form.Form_Find;
import com.mycompany.musicapp.form.Form_Following;
import com.mycompany.musicapp.form.Form_Home;
import com.mycompany.musicapp.form.Form_Library;
import com.mycompany.musicapp.form.Form_Next_Album;
import com.mycompany.musicapp.form.Form_Next_Artist;
import com.mycompany.musicapp.form.Form_Next_Category;
import com.mycompany.musicapp.form.Form_Profile;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Category;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.model.Model_User;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends javax.swing.JFrame {

    private Model_Song Songs;
    private Model_Album albums;
    private Model_Artist artists;
    private Model_Category categorys;
    private static Model_User user;

    private Form_Home home;
    private Form_Add add;
    private Form_FavoriteSong songfavo;
    private Form_Following following;
    private Form_Find find;
    private Form_Next_Album nextAlbum;
    private Form_Library library;
    private Form_Profile profile;
    private Form_Next_Artist nextArtist;
    private Form_Next_Category nextCategory;

    public Main(Model_User user) {
        initComponents();
        init();
        nextCategory = new Form_Next_Category();
        nextArtist = new Form_Next_Artist();
        profile = new Form_Profile();
        home = new Form_Home();
        add = new Form_Add();
        find = new Form_Find();
        songfavo = new Form_FavoriteSong();
        following = new Form_Following();
        nextAlbum = new Form_Next_Album();
        library = new Form_Library();
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(Main.this);
        menu1.addEventMenuSelected((int index) -> {
            switch (index) {
                case 0 ->
                    setForm(home);
                case 1 ->
                    setForm(find);
                case 2 -> {
                    setForm(songfavo);
                }
                case 3 ->
                    setForm(following);
                case 4 -> {
                    setForm(profile);
                    profile.updateUser(user);
                }
                case 6 ->
                    setForm(add);
                case 7 ->
                    setForm(library);
                case 8 -> {
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất tài khoản này ?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        bottom1.stopMusic();
                        Login_Main login = new Login_Main();
                        setVisible(false);
                        login.setVisible(true);

                    }
                }
                default -> {
                }
            }
        });
        setForm(home);
        setFormFrame();

    }

    private void setForm(JComponent com) {
        panelForm.removeAll();
        panelForm.add(com);
        panelForm.repaint();
        panelForm.revalidate();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new com.mycompany.musicapp.swing.Panel();
        bottom1 = new com.mycompany.musicapp.form.Bottom();
        menu1 = new com.mycompany.musicapp.form.Menu();
        panelForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelMain.setBackground(new java.awt.Color(0, 0, 0));

        panelForm.setBackground(new java.awt.Color(51, 51, 51));
        panelForm.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bottom1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottom1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main() {

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
                new Main(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.musicapp.form.Bottom bottom1;
    private com.mycompany.musicapp.form.Menu menu1;
    private javax.swing.JPanel panelForm;
    private com.mycompany.musicapp.swing.Panel panelMain;
    // End of variables declaration//GEN-END:variables

    private void setFormFrame() {
        Form_Home home = (Form_Home) panelForm.getComponent(0);
        home.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        home.setEventAlbumSelected((Model_Album album) -> {
            setForm(nextAlbum);
            albums = album;
            nextAlbum.updateAlbuminfo(album.getImagePathAlbum(), album.getTitleAlbum(), album.getNameArtist(), album.getAlbumID(), album.getArtistID());

        });
        nextAlbum.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        find.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        home.setEventArtistSelected((Model_Artist artist) -> {
            setForm(nextArtist);
            artists = artist;
            nextArtist.updateArtistinfo(artist.getImagePathArtists(), artist.getName(), artist.getArtistID(), artist.getFlow());

        });
        nextArtist.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        songfavo.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        following.setEventArtistSelected((Model_Artist artist) -> {
            setForm(nextArtist);
            artists = artist;
            nextArtist.updateArtistinfo(artist.getImagePathArtists(), artist.getName(), artist.getArtistID(), artist.getFlow());

        });
        songfavo.setEventSongLikeChanged((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        home.setEventCategorySelected((Model_Category category) -> {
            setForm(nextCategory);
            categorys = category;
            nextCategory.updateCategoryinfo(category.getImagePathCategory(), category.getTitleCategory(), category.getCategoryID());
        });
        nextCategory.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });
        profile.setEventSongSelected((Model_Song song) -> {
            Songs = song;
            bottom1.updateSongInfo(song.getSongID(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist(), song.getAudioSrc(), song.getLike());
        });

    }

    public void setUser(Model_User user) {
        this.user = user;
    }
}
