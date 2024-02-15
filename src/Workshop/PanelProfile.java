package Workshop;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mysql_connect.MysqlConnect;
import passwordHashing.PasswordHashing;
import validation.Validation;

public class PanelProfile extends javax.swing.JPanel {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

     String id, name, status;
    private String ImgPath = null; //ສໍາລັບຮັບທີ່ຢູ່ຂອງຮູບພາບ
    

    public PanelProfile(String id, String name, String status) {
        initComponents();
        this.id = id;

        //ກໍານົດຄ້າໃຫ້ເພດ
        txtMale.setActionCommand("ຊາຍ");
        txtFemale.setActionCommand("ຍິງ");

        //placeholder ເບີໂທລະສັບ
        txtTelephone.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "020 1234 5678");
        
         //Reveal button
        txtOldPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        txtNewPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        txtConfirmPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        
        //ເຊື່ອມຖານຂໍ້ມູນ
        conn = MysqlConnect.connectDB();
        listProvince();
        profileUpdate();

    }

    //ລາຍຊືບັນດາແຂວງ
    private void listProvince() {
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

    //ປັບຂະໜາດຮູບພາບ
    public ImageIcon resizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(110, 130, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    //ສ້າງເມັດທອດສະແດງຂໍ້ມູນໃນຕາຕະລາງ
    private void profileUpdate() {

        try {
            String sql = "SELECT province FROM employee WHERE emp_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            txtProvince.setSelectedItem(rs.getString("province"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            String sql = "SELECT *FROM employee WHERE emp_id=? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            txtId.setText(rs.getString("emp_id"));
            txtFirstname.setText(rs.getString("emp_name"));
            txtLastname.setText(rs.getString("emp_lname"));

            if (rs.getString("gender").equals("ຊາຍ")) {
                txtMale.setSelected(true);
            } else {
                txtFemale.setSelected(true);
            }

            //ວັນເດືອນປີເກີດ ແລະ ວັນເດືອນປີເຂົ້າເຮັດວຽກ
            try {
                Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date_of_b"));
                txtDateOfBirth.setDate(dateOfBirth);

                Date dateStartWork = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("start_date"));
                txtStartWork.setDate(dateStartWork);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            txtVillage.setText(rs.getString("village"));

            txtTelephone.setText(rs.getString("tel"));
            txtUser.setText(rs.getString("username"));
            txtStatus.setText(rs.getString("status"));
            txtDistrict.setSelectedItem(rs.getString("city"));
            picture.setIcon(resizeImage(null, rs.getBytes("picture")));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //ກວດສອບທຸກຊ່ອງຂອງຟອມໄດ້ຖືກເລືອກຫຼືບໍ່
    private boolean checkInputs() {
        return txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty()
                || gender.getSelection() == null || txtDateOfBirth.getDate() == null
                || txtStartWork.getDate() == null || txtVillage.getText().isEmpty()
                || txtTelephone.getText().isEmpty() || txtUser.getText().isEmpty();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBrownImage = new javax.swing.JButton();
        txtFemale = new javax.swing.JRadioButton();
        txtTelephone = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMale = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtVillage = new javax.swing.JTextField();
        picture = new javax.swing.JLabel();
        txtDistrict = new javax.swing.JComboBox<>();
        txtProvince = new javax.swing.JComboBox<>();
        txtDateOfBirth = new com.toedter.calendar.JDateChooser();
        txtStartWork = new com.toedter.calendar.JDateChooser();
        txtStatus = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnEditPassword = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ລາຍລະອຽດບັນຊີເຂົ້າໃຊ້", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("ບ້ານ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 80, 28));

        jLabel6.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ວັນ, ເດືອນ, ປີເກີດ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, 28));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 270, -1));

        jLabel4.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ສະຖານະ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 70, 28));

        jLabel1.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ລະຫັດພະນັກງານ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 110, 28));

        btnBrownImage.setBackground(new java.awt.Color(243, 156, 18));
        btnBrownImage.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnBrownImage.setForeground(new java.awt.Color(23, 32, 42));
        btnBrownImage.setText("ເລືອກຮູບ");
        btnBrownImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrownImageActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrownImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, -1));

        gender.add(txtFemale);
        txtFemale.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtFemale.setText("ຍິງ");
        jPanel1.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        txtTelephone.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 270, -1));

        txtLastname.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 270, -1));

        jLabel11.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("ເບີໂທລະສັບ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 80, 28));

        jLabel5.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("ນາມສະກຸນ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 80, 28));

        gender.add(txtMale);
        txtMale.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtMale.setText("ຊາຍ");
        jPanel1.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("ເພດ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 42, 28));

        jLabel12.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("ມື້ເຂົ້າການ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 80, 28));

        jLabel13.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("ແຂວງ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 80, 28));

        jLabel14.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("ເມືອງ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 80, 28));

        txtFirstname.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 270, -1));

        txtUser.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 270, -1));

        jLabel9.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("ຊື່ພະນັກງານ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 80, 28));

        jLabel15.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("ບັນຊີເຂົ້າໃຊ້");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, 28));

        txtVillage.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtVillage, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 270, -1));

        picture.setBackground(new java.awt.Color(255, 204, 204));
        picture.setOpaque(true);
        jPanel1.add(picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 130));

        txtDistrict.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 270, 30));

        txtProvince.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinceActionPerformed(evt);
            }
        });
        jPanel1.add(txtProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 270, 30));

        txtDateOfBirth.setDateFormatString("d / MM / y");
        txtDateOfBirth.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 270, 30));

        txtStartWork.setDateFormatString("d / MM / y");
        txtStartWork.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtStartWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 270, 30));

        txtStatus.setEditable(false);
        txtStatus.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 270, -1));

        btnEdit.setBackground(new java.awt.Color(22, 160, 133));
        btnEdit.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("ບັນທຶກ ແກ້ໄຂ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 270, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ປ່ຽນລະຫັດຜ່ານ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 16))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("ລະຫັດຜ່ານເກົ່າ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 110, 28));

        txtOldPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 330, -1));

        jLabel16.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("ລະຫັດຜ່ານໃໝ່");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 28));

        txtNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 330, -1));

        jLabel17.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("ຢືນຢັນລະຫັດຜ່ານ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 120, 28));

        txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 330, -1));

        btnEditPassword.setBackground(new java.awt.Color(22, 160, 133));
        btnEditPassword.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnEditPassword.setForeground(new java.awt.Color(255, 255, 255));
        btnEditPassword.setText("ບັນທຶກ ແກ້ໄຂ");
        btnEditPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 330, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrownImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrownImageActionPerformed
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
    }//GEN-LAST:event_btnBrownImageActionPerformed

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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnEditPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPasswordActionPerformed
        String oldPassword = null;
        try {
            String sql = "SELECT password FROM employee WHERE emp_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                oldPassword = rs.getString("password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (txtOldPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນລະຫັດຜ່ານເກົ່າດ້ວຍ", "ຫວ່າງເປົ່່າ", JOptionPane.WARNING_MESSAGE);
            txtOldPassword.requestFocus();
        } else if (txtNewPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນລະຫັດຜ່ານໃໝ່ດ້ວຍ", "ຫວ່າງເປົ່່າ", JOptionPane.WARNING_MESSAGE);
            txtNewPassword.requestFocus();
        } else if (txtConfirmPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຢືນຢັນລະຫັດຜ່ານດ້ວຍ", "ຫວ່າງເປົ່່າ", JOptionPane.WARNING_MESSAGE);
            txtConfirmPassword.requestFocus();
        } else if (!oldPassword.equals(PasswordHashing.doHashing(txtOldPassword.getText().trim()))) {
            JOptionPane.showMessageDialog(null, "ລະຫັດຜ່ານເກົ່າບໍ່ຖືກຕ້ອງ", "ຜິດພາດ", JOptionPane.ERROR_MESSAGE);
            txtOldPassword.requestFocus();
        } else if (!(txtNewPassword.getText().equals(txtConfirmPassword.getText()))) {
            JOptionPane.showMessageDialog(null, "ລະຫັດຜ່ານໃໝ່ ແລະ ລະຫັດຢືນຢັນບໍ່ກົງກັນ", "ຜິດພາດ", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String sql = "UPDATE employee SET password=? WHERE emp_id=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, PasswordHashing.doHashing(txtNewPassword.getText().trim()));
                pst.setString(2, id);

                if (pst.executeUpdate() > 0) {
                    FlatSVGIcon icon = new FlatSVGIcon("image_svg/done.svg");
                    JOptionPane.showMessageDialog(null, "ປັບປຸງລະຫັດຜ່ານໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH, icon);
                    txtOldPassword.setText("");
                    txtNewPassword.setText("");
                    txtConfirmPassword.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnEditPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrownImage;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditPassword;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel picture;
    private javax.swing.JPasswordField txtConfirmPassword;
    private com.toedter.calendar.JDateChooser txtDateOfBirth;
    private javax.swing.JComboBox<String> txtDistrict;
    private javax.swing.JRadioButton txtFemale;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JRadioButton txtMale;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JComboBox<String> txtProvince;
    private com.toedter.calendar.JDateChooser txtStartWork;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVillage;
    // End of variables declaration//GEN-END:variables
}
