package Workshop;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mysql_connect.MysqlConnect;
import validation.Validation;

public class PanelCustomer extends javax.swing.JPanel {

    String id, name, status;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PanelCustomer(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;
        
        //ປ່ຽນສີພື້ນຫົວຕາຕະລາງ
        JTableHeader header = jTable1.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(108, 117, 125));
        header.setForeground(new Color(243, 243, 243));
        
        //ເສັ້ນຕາຕະລາງ
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new Color(139, 138, 137));
        
        //ສະແດງຜົນຢູ່ກາງຖັນ
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); //ໃຫ້ຂໍ້ມູນຢູ່ຖັນ ລະຫັດສະແດງທີ່ກາງຫ້ອງ
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); //ໃຫ້ຂໍ້ມູນຢູ່ຖັນ ເພດ ສະແດງທີ່ກາງຫ້ອງ

        //ສະແດງຜົນຂໍ້ມູນຢູ່ຕິດດ້ານຂວາຂອງຖັນ
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        
        //connect database
        conn = MysqlConnect.connectDB();
        tableUpdate();
        autoID();
        
        //define value for gender button
        txtMale.setActionCommand("ຊາຍ");
        txtFemale.setActionCommand("ຍິງ");
        
        //PlaceHolder
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ຄົ້ນຫາ");
        txtTelephone.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "020 12345678");
        
        //ໃສ່ຮູບໃນ txtUser ແລະ txtPass
        ImageIcon icon1 = new ImageIcon(getClass().getResource("../image/icons/search_text.png"));
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, icon1);
        
        //ລືບ
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        
        //
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    //wirte method to show data to table
    private void tableUpdate(){
        try {
            String sql = "SELECT *FROM customer ORDER BY cus_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            jTable1.setRowHeight(30); //The height of row
            d.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("cus_id"));
                v.add(rs.getString("cus_name"));
                v.add(rs.getString("cus_lname"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("address"));
                v.add(rs.getString("tel"));
                d.addRow(v);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //ສ້າງເມັດທອດສ້າງ id ເພີ່ມຂຶ້ນອັດຕະຖນມັດ
    private void autoID() {

        try {
            String sql = "SELECT MAX(cus_id) AS max_id FROM customer";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            if (rs.getString("max_id") == null) {
                txtId.setText("CUS0000001");
            } else {
                int id = Integer.parseInt(rs.getString("max_id").substring(3, rs.getString("max_id").length()));
                id++;
                txtId.setText("CUS" + String.format("%07d", id));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //ລືບຂໍ້ມູນໃນຟອມ
    private void clearForm() {
        autoID();
        txtFirstname.setText("");
        txtLastname.setText("");
        gender.clearSelection();
        txtAddress.setText("");
        txtTelephone.setText("");

        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        jTable1.clearSelection();
    }
    
    //ກວດສອບທຸກຊ່ອງຂອງຟອມໄດ້ຖືກເລືອກຫຼືບໍ່
    private boolean checkInputs() {
        return txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || gender.getSelection() == null
                || txtAddress.getText().isEmpty() || txtTelephone.getText().isEmpty();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtFemale = new javax.swing.JRadioButton();
        txtMale = new javax.swing.JRadioButton();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtLastname = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        jTable1.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດລູກຄ້າ", "ຊື່ລູກຄ້າ", "ນາມສະກຸນ", "ເພດ", "ທີ່ຢູ່", "ເບີໂທ"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນລູກຄ້າ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Saysettha Web", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel15.setText("ເບີໂທລະສັບ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel16.setText("ລະຫັດລູກຄ້າ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel17.setText("ໍໍຊື່ລູກຄ້າ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel18.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel18.setText("ນາມສະກຸນ");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel19.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel19.setText("ທີ່ຢູ່");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        gender.add(txtFemale);
        txtFemale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtFemale.setText("ຍິງ");
        txtFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        gender.add(txtMale);
        txtMale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtMale.setText("ຊາຍ");
        jPanel3.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        btnCancel.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, -1, -1));

        btnAdd.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        btnAdd.setText("ເພີ່ມ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        btnEdit.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        btnEdit.setText("ແກ້ໄຂ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        btnDelete.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        btnDelete.setText("ລຶບ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane4.setViewportView(txtAddress);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 240, 90));
        jPanel3.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 230, -1));
        jPanel3.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 240, -1));

        txtId.setEditable(false);
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 230, -1));
        jPanel3.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 230, -1));

        jLabel21.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jLabel21.setText("ເພດ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //check Imnformation input
        if(checkInputs()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບ", "ຫວ່າງເປົ່າ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //check tel format
        if(!Validation.TelephoneValidation(txtTelephone.getText())){
        JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນເບີໂທໃຫ້ຖືກຕ້ອງດ້ວຍ", "ຜິດພາດ",  JOptionPane.WARNING_MESSAGE);
        return;
        }
        try {
            String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,txtId.getText());
            pst.setString(2,txtFirstname.getText());
            pst.setString(3,txtLastname.getText());
            pst.setString(4,gender.getSelection().getActionCommand());
            pst.setString(5,txtAddress.getText());
            pst.setString(6,txtTelephone.getText());
            
            pst.executeUpdate();
            
            tableUpdate();
            clearForm();
            
            //ImageIcon icon = new ImageIcon(getClass().getResource("../image/ok.png"));
            FlatSVGIcon icon = new FlatSVGIcon("image_svg/done.svg");
            JOptionPane.showMessageDialog(null, "ຂໍ້ມູນຖືກບັນທຶກລົງໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH, icon);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       //confirm for delete
       int data;
       data = JOptionPane.showConfirmDialog(null,"ທ່ານຕ້ອງການລຶບຂໍ້ມູນລາຍການນີ້ແທ້ ຫຼື ບໍ່?", "ຢືນຍັນ",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(data != 0){
           clearForm();
           return;
       }
        try {
            String sql = "DELETE FROM customer WHERE cus_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtId.getText());
            pst.executeUpdate();
            tableUpdate();
            clearForm();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        if(selectIndex == -1){
            return;
        }
        
        txtId.setText(d.getValueAt(selectIndex,0).toString());
        txtFirstname.setText(d.getValueAt(selectIndex,1).toString());
        txtLastname.setText(d.getValueAt(selectIndex,2).toString());
        
        String gender = d.getValueAt(selectIndex, 3).toString();
        if(gender.equals("ຊາຍ")){
            txtMale.setSelected(true);
        } else{
            txtFemale.setSelected(true);
        }
        txtAddress.setText(d.getValueAt(selectIndex,4).toString());
        txtTelephone.setText(d.getValueAt(selectIndex,5).toString());
        
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         //check Imnformation input
        if(checkInputs()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບ", "ຫວ່າງເປົ່າ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //check tel format
        if(!Validation.TelephoneValidation(txtTelephone.getText())){
        JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນເບີໂທໃຫ້ຖືກຕ້ອງດ້ວຍ", "ຜິດພາດ",  JOptionPane.WARNING_MESSAGE);
        return;
        }
        try {
            String sql = "UPDATE customer SET cus_name=?, cus_lname=?,gender=?,address=?,tel=? WHERE cus_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(6,txtId.getText());
            pst.setString(1,txtFirstname.getText());
            pst.setString(2,txtLastname.getText());
            pst.setString(3,gender.getSelection().getActionCommand());
            pst.setString(4,txtAddress.getText());
            pst.setString(5,txtTelephone.getText());
            
            pst.executeUpdate();
            
            tableUpdate();
            clearForm();
            
            //ImageIcon icon = new ImageIcon(getClass().getResource("../image/ok.png"));
            FlatSVGIcon icon = new FlatSVGIcon("image_svg/done.svg");
            JOptionPane.showMessageDialog(null, "ແກ້ໄຂຂໍ້ມູນລູກຄ້າໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH, icon);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String sql = "SELECT *FROM customer WHERE CONCAT(cus_id, cus_name, cus_lname, tel)" + " LIKE '%" + txtSearch.getText() +"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            jTable1.setRowHeight(30); //The height of row
            d.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("cus_id"));
                v.add(rs.getString("cus_name"));
                v.add(rs.getString("cus_lname"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("address"));
                v.add(rs.getString("tel"));
                d.addRow(v);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JRadioButton txtFemale;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JRadioButton txtMale;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
