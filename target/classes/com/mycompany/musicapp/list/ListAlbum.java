package com.mycompany.musicapp.list;

import com.mycompany.musicapp.item.ItemAlbum;
import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.model.Model_Album;

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

public class ListAlbum<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListAlbum() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        setVisibleRowCount(1);
        setLayoutOrientation(ListAlbum.HORIZONTAL_WRAP);

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
                Model_Album data;
                if (o instanceof Model_Album) {
                    data = (Model_Album) o;

//                    System.out.println("Rendering Album: " + data.getTitleAlbum());
                } else {
                    data = new Model_Album(1, 1, "No Data", "No Name", "No src");
                }
                ItemAlbum item = new ItemAlbum(data);
                return item;
            }
        };
    }

    private void loadSongsFromDatabase() {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM album JOIN artists ON album.ArtistID = artists.ArtistID")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int AlbumID = rs.getInt("AlbumID");
                int ArtistID = rs.getInt("ArtistID");
                String TitleAlbum = rs.getString("TitleAlbum");
                String ImagePathAlbum = rs.getString("ImagePathAlbum");
                String NameArtist = rs.getString("Name");
//                System.out.println("AlbumID: " + AlbumID + ", ArtistID: " + ArtistID + ", TitleAlbum: " + TitleAlbum
//                        + ", ImagePathAlbum: " + ImagePathAlbum + ", NameArtist: " + NameArtist);

                Model_Album album = new Model_Album(AlbumID, ArtistID, TitleAlbum, ImagePathAlbum, NameArtist);
                model.addElement(album);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItem(Model_Album album) {
        model.addElement(album);
    }

}
