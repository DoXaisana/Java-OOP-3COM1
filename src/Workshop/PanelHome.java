/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Workshop;

import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.*;

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

        jLabel1.setFont(new java.awt.Font("Saysettha Web", 1, 24)); // NOI18N
        jLabel1.setText("ຍິນດິຕ້ອນຮັບເຂົ້າສູ່ ໂປຣແກຣມຮ້ານຂາຍເຄື່ອງ");

        sVGImage1.setBackground(new java.awt.Color(51, 255, 255));
        sVGImage1.setOpaque(true);

        sVGImage2.setBackground(new java.awt.Color(51, 255, 255));
        sVGImage2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private Workshop.SVGImage sVGImage1;
    private Workshop.SVGImage sVGImage2;
    // End of variables declaration//GEN-END:variables
}
