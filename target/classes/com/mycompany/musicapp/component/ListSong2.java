/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicapp.component;

import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Song;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListSong2<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListSong2() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        //setVisibleRowCount(1);
        setLayoutOrientation(ListAlbum.VERTICAL_WRAP);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    playIndex = locationToIndex(me.getPoint());
                    repaint();
                }
            }
        });

        // Load song data from the database
        loadSongsFromDatabase();
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Song data;
                if (o instanceof Model_Song) {
                    data = (Model_Song) o;

                    System.out.println("Rendering Song: " + data.getTitleSong());

                } else {
                    data = new Model_Song(1, 1, 1, 1, "No Data", "No Name", "No src", 1);
                }
                ItemSong2 item = new ItemSong2(data);
                return item;
            }
        };
    }

    private void loadSongsFromDatabase() {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int SongID = rs.getInt("SongID");
                int CategoryID = rs.getInt("CategoryID");
                int AlbumID = rs.getInt("AlbumID");
                int ArtistID = rs.getInt("ArtistID");
                String ImagePathSong = rs.getString("ImagePathSong");
                String TitleSong = rs.getString("TitleSong");
                String AudioSrc = rs.getString("AudioSrc");
                int Like = rs.getInt("Like");
                Model_Song song = new Model_Song(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like);
                model.addElement(song);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItem(Model_Song song) {
        model.addElement(song);
    }

}
