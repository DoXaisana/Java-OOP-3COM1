/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Workshop;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;

public class PanelHome extends javax.swing.JPanel {

    String id, name, status;
    Connection conn = null;
    PreparedStatement pat = null;
    ResultSet rs = null;

    public PanelHome(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;
        
        sVGImage1.setSvgImage("image_svg/login.svg",100,100);
        sVGImage2.setSvgImage("image_svg/login.svg",100,100);
        sVGImage2.animation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sVGImage1 = new Workshop.SVGImage();
        sVGImage2 = new Workshop.SVGImage();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Saysettha Web", 1, 24)); // NOI18N
        jLabel1.setText("ຍິນດິຕ້ອນຮັບເຂົ້າສູ່ ໂປຣແກຣມຮ້ານຂາຍເຄື່ອງ");

        sVGImage1.setBackground(new java.awt.Color(204, 0, 204));
        sVGImage1.setOpaque(true);

        sVGImage2.setBackground(new java.awt.Color(255, 255, 102));
        sVGImage2.setOpaque(true);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)))
                .addComponent(jButton1)
                .addContainerGap(161, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FlatSVGIcon icon = new FlatSVGIcon("image_svg/done.svg");
        JOptionPane.showMessageDialog(null, "ຂໍ້ມູນຖືກບັນທຶກລົງໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH, icon);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private Workshop.SVGImage sVGImage1;
    private Workshop.SVGImage sVGImage2;
    // End of variables declaration//GEN-END:variables
}
