package com.mycompany.musicapp;

import com.mycompany.musicapp.component.ListAlbum;
import com.mycompany.musicapp.model.Model_Album;
import com.mycompany.musicapp.model.Model_Song;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class MainTest extends JFrame {

    private JList<Model_Song> songList;
    private DefaultListModel<Model_Song> songModel;
    private final MusicApp songManager;
    private Clip clip;
    private int currentSongIndex = -1;  // Đánh dấu bài hát hiện tại

    public MainTest() throws ClassNotFoundException, SQLException {
        songManager = new MusicApp();
        songModel = songManager.getListModel();
        songList = new JList<>(songModel);
        songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");
        JButton playButton = new JButton("Play");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(playButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(backButton);

        // Khi nhấn nút Play
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongIndex = songList.getSelectedIndex();
                playSong(currentSongIndex);
            }
        });

        // Khi nhấn nút Next
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentSongIndex < songModel.size() - 1) {
                    currentSongIndex++;
                    playSong(currentSongIndex);
                    songList.setSelectedIndex(currentSongIndex); // Chọn bài hát trong danh sách
                }
            }
        });

        // Khi nhấn nút Back
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentSongIndex > 0) {
                    currentSongIndex--;
                    playSong(currentSongIndex);
                    songList.setSelectedIndex(currentSongIndex); // Chọn bài hát trong danh sách
                }
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(songList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Music Player");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void playSong(int songIndex) {
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Dừng bài hát hiện tại nếu đang phát
        }

        if (songIndex >= 0 && songIndex < songModel.size()) {
            Model_Song song = songModel.get(songIndex);
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(song.getAudioSrc()));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(MainTest::new);
    }
}
