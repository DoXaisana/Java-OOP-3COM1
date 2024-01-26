/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Workshop;

import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.*;

public class PanelEmployee extends javax.swing.JPanel {

    String id, name, status;
    Connection conn = null;
    PreparedStatement pat = null;
    ResultSet rs = null;

    public PanelEmployee(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtMale = new javax.swing.JRadioButton();
        txtFemale = new javax.swing.JRadioButton();
        txtTel = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtVillage = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtStatus = new javax.swing.JComboBox<>();
        txtProvince = new javax.swing.JComboBox<>();
        txtCity = new javax.swing.JComboBox<>();
        dateOfwork = new com.toedter.calendar.JDateChooser();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນພະນັກງານ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Saysettha Web", 3, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel1.setText("ວັນ,ເດືອນ,ປີເກີດ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel2.setText("ສະຖານະ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel3.setText("ຊື່ພະນັກງານ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel4.setText("ນາມສະກຸນ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel5.setText("ເພດ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel6.setText("ເລກລະຫັດພະນັກງານ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel7.setText("ມື້ເຂົ້າການ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel8.setText("ແຂວງ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel9.setText("ເມືອງ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel10.setText("ບ້ານ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel12.setText("ເບີໂທລະສັບ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel13.setText("ບັນຊີເຂົ້າໃຊ້");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jLabel14.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jLabel14.setText("ລະຫັດຜ່ານ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jButton1.setText("ເລືອກຮູບ");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, -1, -1));

        jButton2.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jButton2.setText("ເພີ່ມ");
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, -1));

        jButton3.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jButton3.setText("ແກ້ໄຂ");
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        jButton4.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jButton4.setText("ລຶບ");
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, -1, -1));

        jButton5.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jButton5.setText("ຍົກເລີກ");
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));

        txtMale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtMale.setText("ຊາຍ");
        txtMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMalejRadioButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        txtFemale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtFemale.setText("ຍິງ");
        txtFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFemalejRadioButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));
        jPanel3.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 170, -1));
        jPanel3.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, -1));
        jPanel3.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 180, -1));
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 180, -1));
        jPanel3.add(txtVillage, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 170, -1));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel3.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 170, -1));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 170, 20));

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 170, -1));

        txtProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(txtProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 170, -1));

        txtCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));
        jPanel3.add(dateOfwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));
        jPanel3.add(dateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 180, -1));

        jLabel11.setBackground(new java.awt.Color(255, 102, 255));
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 120, 150));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTable1.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດ", "ຊື່", "ນາມສະກຸນ", "ເພດ", "ວັນເດືອນປີເກີດ", "ບ້ານ", "ເມືອງ", "ແຂວງ", "ເບີໂທ", "ເລີ່ມເຮັດວຽກ", "ບັນຊີເຂົ້າໃຊ້", "ສະຖານະ", "ຮູບພາບ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMalejRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMalejRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMalejRadioButton2ActionPerformed

    private void txtFemalejRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFemalejRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFemalejRadioButton1ActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private com.toedter.calendar.JDateChooser dateOfwork;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtCity;
    private javax.swing.JRadioButton txtFemale;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JRadioButton txtMale;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtProvince;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVillage;
    // End of variables declaration//GEN-END:variables
}
