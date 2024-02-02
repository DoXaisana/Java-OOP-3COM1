/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Workshop;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mysql_connect.MysqlConnect;
import validation.Validation;

public class PanelEmployee extends javax.swing.JPanel {

    String id, name, status;
    
    private String ImgPath = null;
    private String oldPassword;
    
    Connection conn = null;         //ເກັບຜົນເຊື່ອມຕໍ່ຖານຂໍ້ມູນ
    PreparedStatement pst = null;   //ກຽມຄຳສັ່ງ SQL
    ResultSet rs = null;            //ເກັບຜົນໄດ້ຮັບຈາກການ query

    public PanelEmployee(String i, String n, String s) {
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
        listProvince();
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
        
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
    }
    
    //ສ້າງເມັດທອດປັບຂະໜາດຮູບພາບທີ່ຈະສະແດງທີ່ຫ້ອງ picture (label ທີ່ໃຫ້ສະແດງຮູບ)
    public ImageIcon resizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    
    //list of our province
    private void listProvince(){
        try {
            String sql = "SELECT *FROM province ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            txtProvince.removeAllItems();
            while (rs.next()) {
                txtProvince.addItem(rs.getString("province_name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //wirte method to show data to table
    private void tableUpdate(){
        try {
            String sql = "SELECT *FROM employee ORDER BY emp_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            jTable1.setRowHeight(30); //The height of row
            d.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("emp_id"));
                v.add(rs.getString("emp_name"));
                v.add(rs.getString("emp_lname"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("date_of_b"));
                v.add(rs.getString("village"));
                v.add(rs.getString("city"));
                v.add(rs.getString("province"));
                v.add(rs.getString("tel"));
                v.add(rs.getString("start_date"));
                v.add(rs.getString("username"));
                v.add(rs.getString("status"));
                v.add(rs.getString("picture"));
                d.addRow(v);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //ສ້າງເມັດທອດສ້າງ id ເພີ່ມຂຶ້ນອັດຕະຖນມັດ
    private void autoID() {

        try {
            String sql = "SELECT MAX(emp_id) AS max_id FROM employee";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            if (rs.getString("max_id") == null) {
                txtId.setText("EMP001");
            } else {
                int id = Integer.parseInt(rs.getString("max_id").substring(3, rs.getString("max_id").length()));
                id++;
                txtId.setText("EMP" + String.format("%03d", id));
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
        txtVillage.setText("");
        txtUser.setText("");
        txtPassword.setText("");
        txtTelephone.setText("");

        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        jTable1.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        btnBroweImage = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancer = new javax.swing.JButton();
        txtTelephone = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtVillage = new javax.swing.JTextField();
        txtStatus = new javax.swing.JComboBox<>();
        txtProvince = new javax.swing.JComboBox<>();
        txtDistrict = new javax.swing.JComboBox<>();
        picture = new javax.swing.JLabel();
        txtDateOfBirth = new com.toedter.calendar.JDateChooser();
        txtStartWork = new com.toedter.calendar.JDateChooser();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtFemale = new javax.swing.JRadioButton();
        txtMale = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();

        jTable1.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດ", "ຊື່", "ນາມສະກຸນ", "ເພດ", "ວັນເດືອນປີເກີດ", "ບ້ານ", "ເມືອງ", "ແຂວງ", "ເບີໂທ", "ເລີ່ມເຮັດວຽກ", "ບັນຊີເຂົ້າໃຊ້", "ລະຫັດຜ່ານ", "ສະຖານະ", "ຮູບພາບ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        btnBroweImage.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        btnBroweImage.setText("ເລືອກຮູບ");
        btnBroweImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroweImageActionPerformed(evt);
            }
        });
        jPanel3.add(btnBroweImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        btnAdd.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        btnAdd.setText("ເພີ່ມ");
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, -1, -1));

        btnEdit.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        btnEdit.setText("ແກ້ໄຂ");
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, -1, -1));

        btnDelete.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        btnDelete.setText("ລຶບ");
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, -1));

        btnCancer.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        btnCancer.setText("ຍົກເລີກ");
        btnCancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancerActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancer, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 200, -1, -1));
        jPanel3.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 170, -1));
        jPanel3.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, -1));
        jPanel3.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 180, -1));

        txtId.setEditable(false);
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 180, -1));
        jPanel3.add(txtVillage, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 170, -1));

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
        jPanel3.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 190, -1));

        txtProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinceActionPerformed(evt);
            }
        });
        jPanel3.add(txtProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 170, -1));

        jPanel3.add(txtDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));

        picture.setBackground(new java.awt.Color(255, 204, 204));
        picture.setOpaque(true);
        jPanel3.add(picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 120, 150));

        txtDateOfBirth.setDateFormatString("d / MM / y");
        jPanel3.add(txtDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 180, -1));

        txtStartWork.setDateFormatString("d / MM / y");
        jPanel3.add(txtStartWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));
        jPanel3.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 190, -1));

        txtPassword.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 190, -1));

        gender.add(txtFemale);
        txtFemale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtFemale.setText("ຍິງ");
        jPanel3.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        gender.add(txtMale);
        txtMale.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        txtMale.setText("ຊາຍ");
        jPanel3.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancerActionPerformed
        clearForm();
    }//GEN-LAST:event_btnCancerActionPerformed

    private void txtProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinceActionPerformed
        String province = txtProvince.getSelectedItem().toString();
        try {

            String sql = "SELECT district_name FROM district WHERE province_id = (SELECT province_id FROM province WHERE province_name = ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, province);
            rs = pst.executeQuery();
            txtDistrict.removeAllItems();
            while (rs.next()) {
                txtDistrict.addItem(rs.getString("district_name").trim());
            }
            listProvince();
            txtProvince.setSelectedItem(province);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtProvinceActionPerformed

    private void btnBroweImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroweImageActionPerformed
        // ກ່ອນອື່ນໃຫ້ສ້າງເມັດທອດຊື່ resizeImage ໄວ້ກ່ອນ ແລະ ປະກາດ ImgPath ເປັນ properties ຂອງຄລາດກ່ອນ ເຊິ່ງຈະປະກາດໄວ້ທີ່ກ້ອງຄລາດ
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            picture.setIcon(resizeImage(path, null));
            ImgPath = path;
        } else {
            System.out.println("No file Selected");
        }
    }//GEN-LAST:event_btnBroweImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBroweImage;
    private javax.swing.JButton btnCancer;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel picture;
    private com.toedter.calendar.JDateChooser txtDateOfBirth;
    private javax.swing.JComboBox<String> txtDistrict;
    private javax.swing.JRadioButton txtFemale;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JRadioButton txtMale;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtProvince;
    private javax.swing.JTextField txtSearch;
    private com.toedter.calendar.JDateChooser txtStartWork;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVillage;
    // End of variables declaration//GEN-END:variables
}
