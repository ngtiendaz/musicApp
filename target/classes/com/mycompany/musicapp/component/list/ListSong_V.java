package com.mycompany.musicapp.component.list;

import com.mycompany.musicapp.component.item.ItemSong_V;
import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.model.Model_Song;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListSong_V<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;
    //private Form_Home home;

    public ListSong_V() {
        // this.home = home;
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        //setVisibleRowCount(1);

        setLayoutOrientation(ListAlbum.VERTICAL);

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                if (SwingUtilities.isLeftMouseButton(me)) {
//                    playIndex = locationToIndex(me.getPoint());
//                    repaint();
//                    if (me.getClickCount() == 2) {
//                        Object o = model.getElementAt(playIndex);
//                        if (o instanceof Model_Song) {
//                            Model_Song song = (Model_Song) o;
//                            //home.playSong(song.getAudioSrc(), song.getImagePathSong(), song.getTitleSong(), song.getNameArtist());
//                        }
//                    }
//                }
//            }
//        });
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

//                    System.out.println("Rendering Song: " + data.getTitleSong());
                } else {
                    data = new Model_Song(1, 1, 1, 1, "No Data", "No Name", "No Src", 0, "No NameArt");
                }
                ItemSong_V item = new ItemSong_V(data);
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
                String NameArtist = rs.getString("Name");
//                System.out.println("SongID: " + SongID + ", CategoryID: " + CategoryID + ", AlbumID: " + AlbumID
//                        + ", ArtistID: " + ArtistID + ", ImagePathSong:" + ImagePathSong + ",TitleSong:" + TitleSong + ",AudioSrc" + AudioSrc + ",Like" + Like + ",NameArtist" + NameArtist);

                Model_Song song = new Model_Song(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like, NameArtist);
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
