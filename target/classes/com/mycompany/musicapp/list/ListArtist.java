package com.mycompany.musicapp.list;

import com.mycompany.musicapp.item.ItemArtist;
import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.model.Model_Artist;
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

public class ListArtist<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListArtist() {
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
                Model_Artist data;
                if (o instanceof Model_Artist) {
                    data = (Model_Artist) o;

//                    System.out.println("Rendering Artist: " + data.getName());
                } else {
                    data = new Model_Artist(1, "No Data", "No Name", 0);
                }
                ItemArtist item = new ItemArtist(data);
                return item;
            }
        };
    }

    private void loadSongsFromDatabase() {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM artists ")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int ArtistID = rs.getInt("ArtistID");
                String Name = rs.getString("Name");
                String ImagePathArtists = rs.getString("ImagePathArtists");
                int Flow = rs.getInt("Flow");
//                System.out.println("ArtistID: " + ArtistID + ", Name: " + Name + ", ImagePathArtists: " + ImagePathArtists
//                        + ", Flow: " + Flow);

                Model_Artist artist = new Model_Artist(ArtistID, Name, ImagePathArtists, Flow);
                model.addElement(artist);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItem(Model_Artist artist) {
        model.addElement(artist);
    }

}
