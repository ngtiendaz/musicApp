package com.mycompany.musicapp.list;

import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.item.ItemUser;
import com.mycompany.musicapp.model.Model_User;

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

public class ListUser<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListUser() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        setVisibleRowCount(1);
        setLayoutOrientation(ListAlbum.VERTICAL);

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
                Model_User data;
                if (o instanceof Model_User) {
                    data = (Model_User) o;

//                    System.out.println("Rendering Album: " + data.getTitleAlbum());
                } else {
                    data = new Model_User(1, "No Data", "No Name", "No src", "no anh", "no anh");
                }
                ItemUser item = new ItemUser(data);
                return item;
            }
        };
    }

    private void loadSongsFromDatabase() {
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
                model.addElement(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItem(Model_User user) {
        model.addElement(user);
    }

}
