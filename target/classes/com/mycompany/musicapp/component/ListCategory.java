package com.mycompany.musicapp.component;

import static com.mycompany.musicapp.MusicApp.connect;
import com.mycompany.musicapp.model.Model_Category;
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

public class ListCategory<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListCategory() {
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
                Model_Category data;
                if (o instanceof Model_Category) {
                    data = (Model_Category) o;

//                    System.out.println("Rendering Category: " + data.getTitleCategory());
                } else {
                    data = new Model_Category(1, "No Data", "No Name");
                }
                ItemCategory item = new ItemCategory(data);
                return item;
            }
        };
    }

    private void loadSongsFromDatabase() {
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM category ")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String TitleCategory = rs.getString("TitleCategory");
                String ImagePathCategory = rs.getString("ImagePathCategory");
//                System.out.println("CategoryID: " + CategoryID + ", TitleCategory: " + TitleCategory + ", ImagePathArtists: " + ImagePathCategory
//                );

                Model_Category category = new Model_Category(CategoryID, TitleCategory, ImagePathCategory);
                model.addElement(category);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItem(Model_Category category) {
        model.addElement(category);
    }

}
