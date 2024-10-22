package com.mycompany.musicapp.form;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.Model_User;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.mycompany.musicapp.model.Model_User;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Bottom extends javax.swing.JPanel {

    private Player player;
    private Clip clip;
    private long clipTimePosition = 0;
    private Timer timer;
    private boolean isSliderBeingDragged = false;

    private boolean isPlaying = false;
    private boolean isLike;
    int ChangeSongID;
    int user;

    public Bottom() {
        initComponents();
        setOpaque(false);

        //slider1 = (Slider) new JSlider(0, 100, 0);
        //slider1.setMajorTickSpacing(10);
        // slider1.setPaintTicks(true);
        //slider1.setPaintLabels(true);
    }

    String musicTest = "";

    public void updateLike(int SongID, int Like) {
        MusicApp.updateLike(SongID, Like);
        if (Like == 1) {
            isLike = true;
            btn_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\liked.png"));
        } else {
            isLike = false;
            btn_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\like.png"));
        }
    }

    public void updateSongInfo(int SongID, String imagePath, String nameSong, String nameArtist, String audioSrc, int Like) {
        stopMusic();
//        clipTimePosition = 0;

        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage(); // Lấy đối tượng Image từ ImageIcon
            Image scaledImage = image.getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            lbImage.setIcon(imageIcon);
        }
        if (nameSong != null && !nameSong.isEmpty()) {
            lbNameMusic.setText(nameSong);
        }
        if (nameArtist != null && !nameArtist.isEmpty()) {
            lbNameArtist.setText(nameArtist);
        }
//        if (musicTest != null) {
//            musicTest = "";
//            musicTest = audioSrc;
//        } else {
        musicTest = audioSrc;
        ChangeSongID = SongID;
//        }
        if (Like == 1) {
            isLike = true;
            btn_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\liked.png"));
        } else {
            isLike = false;
            btn_like.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\like.png"));
        }

        playOrResumeMusic(musicTest);
        isPlaying = true;
        btn_play.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\pausebig.png"));

    }

    private String formatTime(long microseconds) {
        long seconds = TimeUnit.MICROSECONDS.toSeconds(microseconds);
        long minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public void stopMusic() {
        if (clip != null) {
            clip.stop();
            musicTest = null;
            clipTimePosition = 0;
            clip.close();
            clip = null; // Giả phóng tài nguyên
            if (timer != null) {
                timer.cancel();

            }
        }
    }

    public void playOrResumeMusic(String filePath) {
        try {
            if (clip == null) {
                // Lần đầu phát nhạc
                File audioFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.setMicrosecondPosition(clipTimePosition); // Tiếp tục từ vị trí tạm dừng
                clip.start();

                // Cập nhật JSlider khi nhạc đang phát
                updateSlider();

            } else if (!clip.isRunning()) {
                // Nếu nhạc đang tạm dừng, tiếp tục từ vị trí đã lưu
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();
                updateSlider();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    private void updateSlider() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (clip != null && clip.isRunning() && !isSliderBeingDragged) {
                    long currentPosition = clip.getMicrosecondPosition();
                    long totalLength = clip.getMicrosecondLength();
                    int sliderValue = (int) ((currentPosition * 100) / totalLength); // Tính toán giá trị slider
                    slider1.setValue(sliderValue);
                    String elapsedTime = formatTime(currentPosition);
                    String totalTime = formatTime(totalLength);
                    lb_elapsed.setText(elapsedTime);
                    lb_totalTime.setText(totalTime);
                }

            }
        }, 0, 100); // Cập nhật mỗi 100ms
    }

    public void pauseMusic() {
        if (clip != null && clip.isRunning()) {
            clipTimePosition = clip.getMicrosecondPosition(); // Lưu lại vị trí hiện tại
            clip.stop(); // Tạm dừng nhạc
            if (timer != null) {
                timer.cancel(); // Dừng cập nhật slider
            }
        }
    }

    private static class Player {

        public Player(FileInputStream fileInputStream) {
        }

        private void play() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_elapsed = new javax.swing.JLabel();
        lb_totalTime = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        lbNameMusic = new javax.swing.JLabel();
        lbNameArtist = new javax.swing.JLabel();
        slider1 = new com.mycompany.musicapp.swing.Slider();
        jLabel4 = new javax.swing.JLabel();
        btn_back = new javax.swing.JLabel();
        btn_play = new javax.swing.JLabel();
        btn_skip = new javax.swing.JLabel();
        btn_like = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1000, 80));

        lb_elapsed.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_elapsed.setForeground(new java.awt.Color(255, 255, 255));
        lb_elapsed.setText("00:00");

        lb_totalTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_totalTime.setForeground(new java.awt.Color(255, 255, 255));
        lb_totalTime.setText("00:00");

        lbImage.setBackground(new java.awt.Color(255, 51, 51));
        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/music.png"))); // NOI18N

        lbNameMusic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNameMusic.setForeground(new java.awt.Color(255, 255, 255));
        lbNameMusic.setText("NameMusic");

        lbNameArtist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNameArtist.setForeground(new java.awt.Color(255, 255, 255));
        lbNameArtist.setText("NameArtist");

        slider1.setValue(0);
        slider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider1StateChanged(evt);
            }
        });
        slider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                slider1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider1MouseReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/share.png"))); // NOI18N

        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/skiptostart.png"))); // NOI18N

        btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/playbig.png"))); // NOI18N
        btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_playMouseClicked(evt);
            }
        });

        btn_skip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/skip2.png"))); // NOI18N

        btn_like.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/like.png"))); // NOI18N
        btn_like.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_likeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameArtist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btn_back)
                        .addGap(10, 10, 10)
                        .addComponent(btn_play)
                        .addGap(10, 10, 10)
                        .addComponent(btn_skip))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_elapsed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slider1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_totalTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(btn_like)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNameMusic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNameArtist))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_totalTime)
                                    .addComponent(lb_elapsed)))
                            .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_play, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(btn_skip)))
                                .addGap(4, 4, 4)
                                .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(btn_like))))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseClicked
        isPlaying = !isPlaying;
        if (isPlaying) {
            // Nếu đang play, chuyển thành pause
            btn_play.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\pausebig.png"));
            playOrResumeMusic(musicTest);
        } else {
            // Nếu đang pause, chuyển thành play
            btn_play.setIcon(new ImageIcon("D:\\Data_Music\\newIcon\\playbig.png"));
            pauseMusic();
        }
    }//GEN-LAST:event_btn_playMouseClicked

    private void btn_likeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_likeMouseClicked

        // You need to get the actual SongID from somewhere
        if (isLike) {
            updateLike(ChangeSongID, 0);
            //MusicApp.deleteFavorite(UserID, ChangeSongID);

        } else {
            updateLike(ChangeSongID, 1);
            // Update like to 1 (liked)
            //MusicApp.addFavorite(UserID, ChangeSongID);
        }

    }//GEN-LAST:event_btn_likeMouseClicked

    private void slider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider1StateChanged
        if (!isSliderBeingDragged) {
            return;
        }
        if (clip != null && !slider1.getValueIsAdjusting()) {
            int sliderValue = slider1.getValue();
            long newPosition = (long) (sliderValue * clip.getMicrosecondLength() / 100); // Tính toán vị trí
            clip.setMicrosecondPosition(newPosition);
        }

    }//GEN-LAST:event_slider1StateChanged

    private void slider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider1MousePressed
        isSliderBeingDragged = true;
    }//GEN-LAST:event_slider1MousePressed

    private void slider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider1MouseReleased
        isSliderBeingDragged = false;
    }//GEN-LAST:event_slider1MouseReleased

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(0, 0, getWidth(), 25);
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_like;
    private javax.swing.JLabel btn_play;
    private javax.swing.JLabel btn_skip;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbNameArtist;
    private javax.swing.JLabel lbNameMusic;
    private javax.swing.JLabel lb_elapsed;
    private javax.swing.JLabel lb_totalTime;
    private com.mycompany.musicapp.swing.Slider slider1;
    // End of variables declaration//GEN-END:variables
}
