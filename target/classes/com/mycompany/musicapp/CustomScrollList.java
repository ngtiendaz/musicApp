/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicapp;

import com.mycompany.musicapp.component.ListAlbum;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class CustomScrollList extends JPanel {

    private JList<String> list;
    private Point mousePressLocation;

    public CustomScrollList() {
        setLayout(null);  // Disable layout manager to manually control positioning
        DefaultListModel<String> model = new DefaultListModel<>();

        for (int i = 1; i <= 50; i++) {
            model.addElement("Item " + i);
        }

        list = new JList<>(model);
        list.setFixedCellHeight(100);
        list.setVisibleRowCount(1);
        list.setLayoutOrientation(ListAlbum.HORIZONTAL_WRAP);
        list.setSize(model.getSize() * list.getFixedCellWidth(), 200);  // Set size based on number of items

        add(list);

        // Mouse listener to detect drag
        list.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mousePressLocation = e.getPoint();
            }
        });

        list.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point current = e.getPoint();
                int deltaX = current.x - mousePressLocation.x;

                // Update list position
                Rectangle bounds = list.getBounds();
                bounds.x += deltaX;

                // Prevent scrolling too far
                if (bounds.x > 0) {
                    bounds.x = 0;
                }
                if (bounds.x < -(bounds.width - getWidth())) {
                    bounds.x = -(bounds.width - getWidth());
                }

                list.setBounds(bounds);
                mousePressLocation = current;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Scroll List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        CustomScrollList customScrollList = new CustomScrollList();
        frame.add(customScrollList);

        frame.setVisible(true);
    }
}
