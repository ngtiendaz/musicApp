package com.mycompany.musicapp;

import com.mycompany.musicapp.event.EventSongLikeChanged;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Category;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.model.Model_User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicApp {

    private static EventSongLikeChanged eventSongLikeChanged;

    public static void addEventSongLikeChanged(EventSongLikeChanged eventSongLikeChanged) {
        MusicApp.eventSongLikeChanged = eventSongLikeChanged;
    }

    private static Model_Song mapResultSetToSong(ResultSet rs) throws SQLException {

        int SongID = rs.getInt("SongID");
        int CategoryID = rs.getInt("CategoryID");
        int AlbumID = rs.getInt("AlbumID");
        int ArtistID = rs.getInt("ArtistID");
        String ImagePathSong = rs.getString("ImagePathSong");
        String TitleSong = rs.getString("TitleSong");
        String AudioSrc = rs.getString("AudioSrc");
        int Like = rs.getInt("Like");
        String NameArtist = rs.getString("Name");
        return new Model_Song(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like, NameArtist);
    }

    private static Model_Album mapResultSetToAlbum(ResultSet rs) throws SQLException {

        int AlbumID = rs.getInt("AlbumID");
        int ArtistID = rs.getInt("ArtistID");
        String ImagePathAlbum = rs.getString("ImagePathAlbum");
        String TitleAlbum = rs.getString("TitleAlbum");
        String NameArtist = rs.getString("Name");
        return new Model_Album(AlbumID, ArtistID, TitleAlbum, ImagePathAlbum, NameArtist);
    }

    public static Model_User mapResultSetToUser(ResultSet rs) throws SQLException {
        int UserID = rs.getInt("UserID");
        String Email = rs.getString("Email");
        String Pass = rs.getString("Pass");
        String ImagePathUser = rs.getString("ImagePathUser");
        String NameUser = rs.getString("NameUser");
        String role = rs.getString("role");
        return new Model_User(UserID, Email, Pass, ImagePathUser, NameUser, role);
    }

    private static Model_Artist mapResultSetToArtist(ResultSet rs) throws SQLException {
        int ArtistID = rs.getInt("ArtistId");
        int Flow = rs.getInt("Flow");
        String ImagePathArtists = rs.getString("ImagePathArtists");
        String Name = rs.getString("Name");

        return new Model_Artist(ArtistID, Name, ImagePathArtists, Flow);

    }

    private Connection conn;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/projectmusic?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main.main();
        //new NewJFrame().setVisible(true);
    }

    public static List<Model_Album> getAllAlbum() {
        List<Model_Album> albumList = new ArrayList<>();
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM album JOIN artists ON album.ArtistID = artists.ArtistID")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int AlbumID = rs.getInt("AlbumID");
                int ArtistID = rs.getInt("ArtistID");
                String TitleAlbum = rs.getString("TitleAlbum");
                String ImagePathAlbum = rs.getString("ImagePathAlbum");
                String NameArtist = rs.getString("Name");
                Model_Album album = new Model_Album(AlbumID, ArtistID, TitleAlbum, ImagePathAlbum, NameArtist);
                albumList.add(album);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return albumList;
    }

    public static List<Model_Song> getAllSongs() {
        List<Model_Song> songList = new ArrayList<>();
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
                Model_Song song = new Model_Song(SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc, Like, NameArtist);
                songList.add(song);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public static List<Model_Category> getAllCategory() {
        List<Model_Category> categoryList = new ArrayList<>();
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `category`")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int CategoryID = rs.getInt("CategoryID");
                String TitleCategory = rs.getString("TitleCategory");
                String ImagePathCategory = rs.getString("ImagePathCategory");

                Model_Category category = new Model_Category(CategoryID, TitleCategory, ImagePathCategory);
                categoryList.add(category);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public static List<Model_Artist> getAllArtists() {
        List<Model_Artist> artistsList = new ArrayList<>();
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `artists`")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int ArtistID = rs.getInt("ArtistID");
                String Name = rs.getString("Name");
                String ImagePathArtists = rs.getString("ImagePathArtists");
                int Flow = rs.getInt("Flow");
                Model_Artist artists = new Model_Artist(ArtistID, Name, ImagePathArtists, Flow);
                artistsList.add(artists);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return artistsList;
    }

    public static List<Model_User> getAllUser() {
        List<Model_User> userList = new ArrayList<>();
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE role = 'user'")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int UserID = rs.getInt("UserID");
                String Email = rs.getString("Email");
                String Pass = rs.getString("Pass");
                String ImagePathUser = rs.getString("ImagePathUser");
                String NameUser = rs.getString("NameUser");
                String role = rs.getString("role");
                Model_User user = new Model_User(UserID, Email, Pass, ImagePathUser, NameUser, role);
                userList.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void addAlbum(int AlbumID, String TitleAlbum, String ImagePathAlbum, int ArtistID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO album (AlbumID, TitleAlbum, ImagePathAlbum, ArtistID) "
                + "VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, AlbumID);
            stmt.setString(2, TitleAlbum);
            stmt.setString(3, ImagePathAlbum);
            stmt.setInt(4, ArtistID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addArtists(int ArtistID, String Name, String ImagePathArtists, int Flow) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO artists (ArtistID, Name, ImagePathArtists, Flow) "
                + "VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, ArtistID);
            stmt.setString(2, Name);
            stmt.setString(3, ImagePathArtists);
            stmt.setInt(4, Flow);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(int UserID, String Email, String Pass, String ImagePathArtists, String NameUser, String role) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO user (UserID, Email, Pass, ImagePathUser, NameUser, role) "
                + "VALUES (?, ?, ?, ?,?,?)")) {
            stmt.setInt(1, UserID);
            stmt.setString(2, Email);
            stmt.setString(3, Pass);
            stmt.setString(4, ImagePathArtists);
            stmt.setString(5, NameUser);
            stmt.setString(6, role);

            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSong(int SongID, int CategoryID, int AlbumID, int ArtistID, String ImagePathSong, String TitleSong, String AudioSrc, int Like) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO songs (SongID, CategoryID, AlbumID, ArtistID, ImagePathSong, TitleSong, AudioSrc,`Like`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, SongID);
            stmt.setInt(2, CategoryID);
            stmt.setInt(3, AlbumID);
            stmt.setInt(4, ArtistID);
            stmt.setString(5, ImagePathSong);
            stmt.setString(6, TitleSong);
            stmt.setString(7, AudioSrc);
            stmt.setInt(8, Like);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Model_Song> timkiemSong(String TitleSong) {
        List<Model_Song> songList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE TitleSong LIKE ?");
            stmt.setString(1, "%" + TitleSong + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                songList.add(mapResultSetToSong(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public static List<Model_Album> timkiemAlbum(String TitleAlbum) {
        List<Model_Album> albumList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM album JOIN artists ON album.ArtistID = artists.ArtistID WHERE TitleAlbum LIKE ?");
            stmt.setString(1, "%" + TitleAlbum + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                albumList.add(mapResultSetToAlbum(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return albumList;
    }

    public static List<Model_Artist> timkiemArtist(String Name) {
        List<Model_Artist> artistList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM artists  WHERE Name LIKE ?");
            stmt.setString(1, "%" + Name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artistList.add(mapResultSetToArtist(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return artistList;
    }

    public static List<Model_User> timkiemUser(String NameUser) {
        List<Model_User> userList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user  WHERE NameUser LIKE ?");
            stmt.setString(1, "%" + NameUser + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                userList.add(mapResultSetToUser(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static List<Model_Song> Album_Song(int AlbumID) {
        List<Model_Song> songList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE AlbumID LIKE ?");
            stmt.setString(1, "%" + AlbumID + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                songList.add(mapResultSetToSong(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public static List<Model_Song> Category_Song(int CategoryID) {
        List<Model_Song> songList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE CategoryID LIKE ?");
            stmt.setString(1, "%" + CategoryID + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                songList.add(mapResultSetToSong(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public static List<Model_Song> Artist_Song(int ArtistID) {
        List<Model_Song> songList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE songs.ArtistID LIKE ?");
            stmt.setString(1, "%" + ArtistID + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                songList.add(mapResultSetToSong(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;

    }

    public static List<Model_Song> Favorite(int Like) {
        List<Model_Song> songList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE `Like` LIKE 1");
            // stmt.setString(1, "%" + Like + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                songList.add(mapResultSetToSong(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return songList;

    }

    public static List<Model_Artist> Following(int Flow) {
        List<Model_Artist> artistList = new ArrayList<>();
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `artists` WHERE Flow LIKE ?");
            stmt.setString(1, "%" + Flow + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artistList.add(mapResultSetToArtist(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return artistList;

    }

    public static void updateLike(int SongID, int Like) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE songs SET `Like` = ? WHERE SongID = ?")) {
            stmt.setInt(1, Like);
            stmt.setInt(2, SongID);
            stmt.executeUpdate();
            if (eventSongLikeChanged != null) {
                Model_Song song = getSongById(SongID);
                eventSongLikeChanged.changed(song);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Model_Song getSongById(int SongID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM songs JOIN artists ON songs.ArtistID = artists.ArtistID WHERE songs.SongID = ?")) {
            stmt.setInt(1, SongID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToSong(rs);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateFlow(int ArtistID, int Flow) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE artists SET Flow = ? WHERE ArtistID = ?")) {
            stmt.setInt(1, Flow);
            stmt.setInt(2, ArtistID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAlbum(int AlbumID, String TitleAlbum, String ImagePathAlbum, int ArtistID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE album SET TitleAlbum = ?, ImagePathAlbum = ?, ArtistID = ? WHERE AlbumID = ?")) {
            stmt.setString(1, TitleAlbum);
            stmt.setString(2, ImagePathAlbum);
            stmt.setInt(3, ArtistID);
            stmt.setInt(4, AlbumID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAlbum(int AlbumID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM album WHERE AlbumID = ?")) {
            stmt.setInt(1, AlbumID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateArtist(int ArtistID, String Name, String ImagePathArtists, int Flow) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE artists SET Name = ?, ImagePathArtists = ?, Flow = ? WHERE ArtistID = ?")) {
            stmt.setString(1, Name);
            stmt.setString(2, ImagePathArtists);
            stmt.setInt(3, Flow);
            stmt.setInt(4, ArtistID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteArtist(int ArtistID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM artists WHERE ArtistID = ?")) {
            stmt.setInt(1, ArtistID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(int UserID, String Email, String Pass, String ImagePathUser, String NameUser, String role) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE user SET Email = ?, Pass = ?, ImagePathUser = ?,NameUser=? WHERE UserID = ?")) {
            stmt.setString(1, Email);
            stmt.setString(2, Pass);
            stmt.setString(3, ImagePathUser);
            stmt.setString(4, NameUser);
            stmt.setInt(5, UserID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int UserID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE UserID = ?")) {
            stmt.setInt(1, UserID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSong(int SongID, int CategoryID, int AlbumID, int ArtistID, String ImagePathSong, String TitleSong, String AudioSrc, int Like) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("UPDATE songs SET CategoryID = ?, AlbumID = ?,ArtistID=?, ImagePathSong = ?, TitleSong = ?, AudioSrc = ? , `Like` = ? WHERE SongID = ?")) {
            stmt.setInt(1, CategoryID);
            stmt.setInt(2, AlbumID);
            stmt.setInt(3, ArtistID);

            stmt.setString(4, ImagePathSong);
            stmt.setString(5, TitleSong);
            stmt.setString(6, AudioSrc);
            stmt.setInt(7, 0);
            stmt.setInt(8, SongID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSong(int SongID) {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM songs WHERE SongID = ?")) {
            stmt.setInt(1, SongID);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
