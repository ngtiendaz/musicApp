package com.mycompany.musicapp.formAdmin;

import com.mycompany.musicapp.MusicApp;
import com.mycompany.musicapp.model.ModelChart;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Form_ThongKe extends javax.swing.JPanel {

    private Connection conn;

    public Form_ThongKe() {
        initComponents();
        //getContentPane().setBackground(new Color(250, 250, 250));
        chart.addLegend("Rap", new Color(245, 189, 135));
        chart.addLegend("Balland", new Color(135, 189, 245));
        chart.addLegend("POP", new Color(189, 135, 245));
        chart.addLegend("Indie", new Color(139, 229, 222));
        chart.addData(new ModelChart("Tháng 5", MusicApp.getSongLikesByCategoriesForMonth(5)));
        chart.addData(new ModelChart("Tháng 6", MusicApp.getSongLikesByCategoriesForMonth(6)));
        chart.addData(new ModelChart("Tháng 7", MusicApp.getSongLikesByCategoriesForMonth(7)));
        chart.addData(new ModelChart("Tháng 8", MusicApp.getSongLikesByCategoriesForMonth(8)));
        chart.addData(new ModelChart("Tháng 9", MusicApp.getSongLikesByCategoriesForMonth(9)));
        chart.addData(new ModelChart("Tháng 10", MusicApp.getSongLikesByCategoriesForMonth(10)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new com.mycompany.musicapp.formAdmin.Chart();
        jLabel1 = new javax.swing.JLabel();
        xuatData = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thể loại nhạc được yêu thích 6 tháng gần đây:");

        xuatData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musicapp/icon/export2.png"))); // NOI18N
        xuatData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xuatDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xuatData)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xuatData))
                .addGap(18, 18, 18)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xuatDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xuatDataMouseClicked
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Thongke");
            CreationHelper createHelper = workbook.getCreationHelper();

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("THỐNG KÊ THỂ LOẠI NHẠC ĐƯỢC YÊU THÍCH");

            // Tạo dòng tiêu đề của bảng
            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Tháng");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Rap");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ballad");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("POP");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Indie");

            // Kết nối DB và lấy dữ liệu thống kê
            Connection conn = MusicApp.connect();
            String sql = "SELECT MONTH(f.created_at) AS Thang, "
                    + "SUM(CASE WHEN c.TitleCategory = 'Rap' THEN 1 ELSE 0 END) AS Rap, "
                    + "SUM(CASE WHEN c.TitleCategory = 'Ballad' THEN 1 ELSE 0 END) AS Ballad, "
                    + "SUM(CASE WHEN c.TitleCategory = 'POP' THEN 1 ELSE 0 END) AS POP, "
                    + "SUM(CASE WHEN c.TitleCategory = 'Indie' THEN 1 ELSE 0 END) AS Indie "
                    + "FROM favorites f "
                    + "JOIN songs s ON f.SongID = s.SongID "
                    + "JOIN category c ON s.CategoryID = c.CategoryID "
                    + "GROUP BY MONTH(f.created_at) "
                    + "ORDER BY MONTH(f.created_at)";

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue("Tháng " + rs.getInt("Thang"));
                row.createCell(1).setCellValue(rs.getInt("Rap"));
                row.createCell(2).setCellValue(rs.getInt("Ballad"));
                row.createCell(3).setCellValue(rs.getInt("POP"));
                row.createCell(4).setCellValue(rs.getInt("Indie"));
                i++;
            }

            // Ghi file Excel ra đường dẫn cụ thể
            File file = new File("D:\\Java Nâng Cao\\Thongke_theloai_nhac.xlsx");
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            st.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_xuatDataMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.musicapp.formAdmin.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel xuatData;
    // End of variables declaration//GEN-END:variables
}
