package com.mycompany.musicapp.model;

import com.mycompany.musicapp.MusicApp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLoi {

    static Connection conn;

    public static boolean checkKey(String ID, String tenDB) {
        boolean kq = false;
        String ma = null;
        if (tenDB == "album") {
            ma = "AlbumId";
        } else if (tenDB == "artists") {
            ma = "ArtistID";
        } else if (tenDB == "category") {
            ma = "CategoryID";
        } else if (tenDB == "songs") {
            ma = "SongID";
        } else if (tenDB == "user") {
            ma = "UserID";
        }
        try {
            conn = MusicApp.connect();
            String sql = "SELECT * FROM `" + tenDB + "` Where " + ma + " = ('" + ID + "') ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                kq = true;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
        return kq;
    }

    public static String checkEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            return null;
        }
        return email;
    }

    public static String checkPassword(String password) {
        // Mật khẩu ít nhất 8 ký tự, có chữ cái và số
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        if (!m.matches()) {
            return null;
        }
        return password;
    }

}
