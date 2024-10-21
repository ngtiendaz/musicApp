package com.mycompany.musicapp.form;

import com.mycompany.musicapp.event.EventAlbumSelected;
import com.mycompany.musicapp.event.EventArtistSelected;
import com.mycompany.musicapp.event.EventCategorySelected;
import com.mycompany.musicapp.event.EventSongSelected;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Artist;
import com.mycompany.musicapp.model.Model_Category;
import com.mycompany.musicapp.model.Model_Song;
import com.mycompany.musicapp.swing.ScrollBar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {

//    private ListSong_H listSong_H;
    private static Model_Song selectedSong;
    private EventSongSelected eventSongSelected;
    private EventAlbumSelected eventAlbumSelected;
    private static Model_Album selectedAlbuml;
    private EventArtistSelected eventArtistSelected;
    private static Model_Artist selectedArtist;
    private EventCategorySelected eventCategorySelected;
    private static Model_Category selectedCategory;

    public EventCategorySelected getEventCategorySelected() {
        return eventCategorySelected;
    }

    public void setEventCategorySelected(EventCategorySelected eventCategorySelected) {
        this.eventCategorySelected = eventCategorySelected;
    }

    public static Model_Category getSelectedCategory() {
        return selectedCategory;
    }

    public static void setSelectedCategory(Model_Category selectedCategory) {
        Form_Home.selectedCategory = selectedCategory;
    }

    public EventArtistSelected getEventArtistSelected() {
        return eventArtistSelected;
    }

    public void setEventArtistSelected(EventArtistSelected eventArtistSelected) {
        this.eventArtistSelected = eventArtistSelected;
    }

    public static Model_Artist getSelectedArtist() {
        return selectedArtist;
    }

    public static void setSelectedArtist(Model_Artist selectedArtist) {
        Form_Home.selectedArtist = selectedArtist;
    }

    public EventAlbumSelected getEventAlbumSelected() {
        return eventAlbumSelected;
    }

    public static Model_Album getSelectedAlbuml() {
        return selectedAlbuml;
    }

    public static void setSelectedAlbuml(Model_Album selectedAlbuml) {
        Form_Home.selectedAlbuml = selectedAlbuml;
    }

    public void setEventAlbumSelected(EventAlbumSelected eventAlbumSelected) {
        this.eventAlbumSelected = eventAlbumSelected;
    }

    public EventSongSelected getEventSongSelected() {
        return eventSongSelected;
    }

    public void setEventSongSelected(EventSongSelected eventSongSelected) {
        this.eventSongSelected = eventSongSelected;
    }

    public static Model_Song getSelectedSong() {
        return selectedSong;
    }

    public static void setSelectedSong(Model_Song selectedSong) {
        Form_Home.selectedSong = selectedSong;
    }

    public Form_Home() {
        initComponents();
        init();
        setOpaque(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrollArtist = new javax.swing.JScrollPane();
        listArtist = new com.mycompany.musicapp.list.ListArtist();
        jLabel3 = new javax.swing.JLabel();
        scrollAlbum = new javax.swing.JScrollPane();
        listAlbum = new com.mycompany.musicapp.list.ListAlbum();
        scrollSong = new javax.swing.JScrollPane();
        listSong_H1 = new com.mycompany.musicapp.list.ListSong_H();
        jLabel4 = new javax.swing.JLabel();
        scrollCategory = new javax.swing.JScrollPane();
        listCategory = new com.mycompany.musicapp.list.ListCategory();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 500));

        scrollPanel.setBackground(new java.awt.Color(0, 0, 0));
        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelMain.setBackground(new java.awt.Color(0, 0, 0));
        panelMain.setMaximumSize(new java.awt.Dimension(2000, 2000));
        panelMain.setMinimumSize(new java.awt.Dimension(800, 1300));
        panelMain.setPreferredSize(new java.awt.Dimension(800, 1200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Album thịnh hành trên Spotify");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nghệ sĩ bạn nên biết");

        scrollArtist.setBorder(null);
        scrollArtist.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollArtist.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listArtist.setBackground(new java.awt.Color(0, 0, 0));
        listArtist.setBorder(null);
        scrollArtist.setViewportView(listArtist);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Có thể bạn sẽ thích");

        scrollAlbum.setBorder(null);
        scrollAlbum.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollAlbum.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listAlbum.setBorder(null);
        scrollAlbum.setViewportView(listAlbum);

        scrollSong.setBorder(null);
        scrollSong.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollSong.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listSong_H1.setBorder(null);
        scrollSong.setViewportView(listSong_H1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thể Loại\n");

        scrollCategory.setBackground(new java.awt.Color(0, 0, 0));
        scrollCategory.setBorder(null);
        scrollCategory.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollCategory.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listCategory.setBackground(new java.awt.Color(0, 0, 0));
        listCategory.setBorder(null);
        scrollCategory.setViewportView(listCategory);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(scrollArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                        .addComponent(scrollSong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(scrollAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(scrollArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(scrollSong, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(scrollCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );

        scrollPanel.setViewportView(panelMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        listAlbum.setOpaque(false);
        listArtist.setOpaque(false);
        scrollPanel.setVerticalScrollBar(new ScrollBar());
        scrollPanel.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollPanel.getViewport().setBackground(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        scrollPanel.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        scrollArtist.setHorizontalScrollBar(new ScrollBar());
        scrollArtist.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollArtist.getViewport().setBackground(Color.BLACK);
        scrollArtist.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        scrollAlbum.setHorizontalScrollBar(new ScrollBar());
        scrollAlbum.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollAlbum.getViewport().setBackground(Color.BLACK);
        scrollAlbum.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        scrollSong.setHorizontalScrollBar(new ScrollBar());
        scrollSong.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollSong.getViewport().setBackground(Color.BLACK);
        scrollSong.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        scrollCategory.setHorizontalScrollBar(new ScrollBar());
        scrollCategory.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollCategory.getViewport().setBackground(Color.BLACK);
        scrollCategory.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        listSong_H1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedSong((Model_Song) listSong_H1.getSelectedValue());
                if (eventSongSelected != null) {
                    eventSongSelected.selected(selectedSong);
                }
            }
        });
        listAlbum.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedAlbuml((Model_Album) listAlbum.getSelectedValue());
                if (eventAlbumSelected != null) {
                    eventAlbumSelected.selected(selectedAlbuml);
                }
            }
        });
        listArtist.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedArtist((Model_Artist) listArtist.getSelectedValue());
                if (eventArtistSelected != null) {
                    eventArtistSelected.selected(selectedArtist);
                }
            }
        });
        listCategory.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                setSelectedCategory((Model_Category) listCategory.getSelectedValue());
                if (eventCategorySelected != null) {
                    eventCategorySelected.selected(selectedCategory);
                }
            }
        });

    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#000000"), 0, getHeight(), Color.decode("#000000"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth() - 25, 0, getWidth(), getHeight());
        g2.fillRect(0, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(g);
    }

    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#000000"), 0, getHeight(),
                Color.decode("#000000"));
        g2.setPaint(gradientPaint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.mycompany.musicapp.list.ListAlbum listAlbum;
    private com.mycompany.musicapp.list.ListArtist listArtist;
    private com.mycompany.musicapp.list.ListCategory listCategory;
    private com.mycompany.musicapp.list.ListSong_H listSong_H1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane scrollAlbum;
    private javax.swing.JScrollPane scrollArtist;
    private javax.swing.JScrollPane scrollCategory;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JScrollPane scrollSong;
    // End of variables declaration//GEN-END:variables

    //private void getAllDataAlbum() {
    //  List<Model_Album> albumList = MusicApp.getAllAlbum();
    //for (Model_Album album : albumList) {
    //   listAlbum1.addItem(album);
    //}
    //}
}
