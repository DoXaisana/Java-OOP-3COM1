package Workshop;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {

    String id, name, status;

    public Main() {
        initComponents();
    }

    //overloading constructor
    public Main(String i, String n, String s) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        id = i;
        name = n;
        status = s;

        this.setTitle("User: " + name);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/logo.png")));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //ປຽນສີແຖບ Title bar ດ້ານເທິງ
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(30, 30, 30));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false); //ບໍ່ສະແດງ Icon ທີ່ title bar

        //
        if (!status.equals("Admin")) {
            jMenuData.setVisible(false);
            jMenuOrderImport.setVisible(false);
            jMenuReport.setVisible(false);
        }

        //When program is start up we will let PanelHome show frist
        showPanel(new PanelHome(id, name, status));
    }

    //create methot for show every panel in main panel
    private void showPanel(JPanel panel) {
        PanelMain.removeAll();
        PanelMain.add(panel);
        PanelMain.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        PanelMain = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuData = new javax.swing.JMenu();
        jMenuItemCustomer = new javax.swing.JMenuItem();
        jMenuEmployee = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuOrderImport = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuCustomer = new javax.swing.JMenu();
        jMenuCart = new javax.swing.JMenu();
        jMenuSearchItem = new javax.swing.JMenu();
        jMenuReport = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuProfiles = new javax.swing.JMenu();
        jMenuProfiles1 = new javax.swing.JMenu();
        jMenuItemFlatlafLight = new javax.swing.JMenuItem();
        jMenuItemFlatlafDark = new javax.swing.JMenuItem();
        jMenuItemFlatlafIntelliJ = new javax.swing.JMenuItem();
        jMenuItemFlatlafDarcula = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelMain.setLayout(new java.awt.BorderLayout());

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Home_32.png"))); // NOI18N
        jMenuHome.setText("ໜ້າຫຼັກ");
        jMenuHome.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenuHome);

        jMenuData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Add_Database_32.png"))); // NOI18N
        jMenuData.setText("ຈັດການຂໍ້ມູນ");
        jMenuData.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuData.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemCustomer.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItemCustomer.setText("ຈັດການຂໍ້ມູນລູກຄ້າ");
        jMenuItemCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomerActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemCustomer);

        jMenuEmployee.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuEmployee.setText("ຈັດການຂໍ້ມູນພະນັກງານ");
        jMenuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmployeeActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuEmployee);

        jMenuItem4.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem4.setText("ຈັດການຂໍ້ມູນສິນຄ້າ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem5.setText("ຈັດການຂໍ້ມູນປະເພດສິນຄ້າ");
        jMenuData.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem6.setText("ຈັດການຂໍ້ມູນຍີ່ຫໍ້");
        jMenuData.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem7.setText("ຈັດການຂໍ້ມູນອັດຕາແລກປ່ຽນ");
        jMenuData.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem8.setText("ຈັດການຂໍ້ມູນຜູ້ສະໜອງ");
        jMenuData.add(jMenuItem8);

        jMenuBar2.add(jMenuData);

        jMenuOrderImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Edit_Property_32.png"))); // NOI18N
        jMenuOrderImport.setText("ສັ່ງຊື້ - ນຳເຂົ້າ");
        jMenuOrderImport.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuOrderImport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuOrderImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuOrderImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem9.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem9.setText("ຈັດການຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuOrderImport.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem10.setText("ຈັດການຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuOrderImport.add(jMenuItem10);

        jMenuBar2.add(jMenuOrderImport);

        jMenuCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_User_Group_32.png"))); // NOI18N
        jMenuCustomer.setText("ລູກຄ້າ");
        jMenuCustomer.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCustomerMouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenuCustomer);

        jMenuCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Buying_32.png"))); // NOI18N
        jMenuCart.setText("ຂາຍສິນຄ້່າ");
        jMenuCart.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuCart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuCart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuCart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar2.add(jMenuCart);

        jMenuSearchItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Search_Property_32.png"))); // NOI18N
        jMenuSearchItem.setText("ຄົ້ນຫາສິນຄ້າ");
        jMenuSearchItem.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuSearchItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuSearchItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuSearchItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar2.add(jMenuSearchItem);

        jMenuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Report_Card_32.png"))); // NOI18N
        jMenuReport.setText("ລາຍງານ");
        jMenuReport.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem11.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem11.setText("ລາຍງານຂໍ້ມູນການຂາຍ");
        jMenuReport.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem12.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໃນຮ້ານ");
        jMenuReport.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem13.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໃກ້ໝົດ");
        jMenuReport.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem14.setText("ໃບບິນ");
        jMenuReport.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem15.setText("ລາຍງານຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuReport.add(jMenuItem15);

        jMenuItem16.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem16.setText("ລາຍງານຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuReport.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem17.setText("ລາຍງານຂໍ້ມູນລູກຄ້າ");
        jMenuReport.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem18.setText("ລາຍງານຂໍ້ມູນພະນັກງານ");
        jMenuReport.add(jMenuItem18);

        jMenuBar2.add(jMenuReport);

        jMenuProfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Profile_32.png"))); // NOI18N
        jMenuProfiles.setText("ໂປຮໄຟລ໌");
        jMenuProfiles.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuProfiles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuProfiles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuProfiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuProfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProfilesMouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenuProfiles);

        jMenuProfiles1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/change_Theme.png"))); // NOI18N
        jMenuProfiles1.setText("ປ່ຽນສີພື້ນຫຼັງ");
        jMenuProfiles1.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuProfiles1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuProfiles1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuProfiles1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemFlatlafLight.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItemFlatlafLight.setText("FlatLaf Light ");
        jMenuItemFlatlafLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFlatlafLightActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItemFlatlafLight);

        jMenuItemFlatlafDark.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItemFlatlafDark.setText("FlatLaf  Dark");
        jMenuItemFlatlafDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFlatlafDarkActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItemFlatlafDark);

        jMenuItemFlatlafIntelliJ.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItemFlatlafIntelliJ.setText("FlatLaf  IntelliJ");
        jMenuItemFlatlafIntelliJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFlatlafIntelliJActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItemFlatlafIntelliJ);

        jMenuItemFlatlafDarcula.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItemFlatlafDarcula.setText("FlatLaf  Darcula");
        jMenuItemFlatlafDarcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFlatlafDarculaActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItemFlatlafDarcula);

        jMenuItem19.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem19.setText("FlatLaf macOS Light");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Saysettha Web", 0, 12)); // NOI18N
        jMenuItem20.setText("FlatLaf macOS Dark");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenuProfiles1.add(jMenuItem20);

        jMenuBar2.add(jMenuProfiles1);

        jMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons/icons8_Shutdown_32.png"))); // NOI18N
        jMenuExit.setText("ອອກລະບົບ");
        jMenuExit.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuExitMouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenuExit);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuExitMouseClicked
        String msg = "<html><h3 style=\" font-family: Saysettha OT; font-weight: none\">ຕ້ອງການອອກຈາກລະບົບແທ້ ຫຼື ບໍ່?</h3></html>";
        int data = JOptionPane.showConfirmDialog(rootPane, msg, "ຢືນຢັນ", JOptionPane.OK_CANCEL_OPTION);

        if (data == 0) {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuExitMouseClicked

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHomeMouseClicked
        showPanel(new PanelHome(id, name, status));
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void jMenuItemCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomerActionPerformed
        showPanel(new PanelCustomer(id, name, status));
    }//GEN-LAST:event_jMenuItemCustomerActionPerformed

    private void jMenuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmployeeActionPerformed
        showPanel(new PanelEmployee(id, name, status));
    }//GEN-LAST:event_jMenuEmployeeActionPerformed

    private void jMenuCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCustomerMouseClicked
        showPanel(new PanelCustomer(id, name, status));
    }//GEN-LAST:event_jMenuCustomerMouseClicked

    private void jMenuItemFlatlafLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFlatlafLightActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(220, 220, 220));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });

    }//GEN-LAST:event_jMenuItemFlatlafLightActionPerformed

    private void jMenuItemFlatlafDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFlatlafDarkActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(30, 30, 30));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });

    }//GEN-LAST:event_jMenuItemFlatlafDarkActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(220, 220, 220));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });

    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(30, 30, 30));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });

    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItemFlatlafDarculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFlatlafDarculaActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(30, 30, 30));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });
    }//GEN-LAST:event_jMenuItemFlatlafDarculaActionPerformed

    private void jMenuItemFlatlafIntelliJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFlatlafIntelliJActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(30, 30, 30));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });
    }//GEN-LAST:event_jMenuItemFlatlafIntelliJActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int data = JOptionPane.showConfirmDialog(rootPane, "ທ່ານຕ້ອງການອອກຈາກໂປຮແກຮມແທ້ ຫຼື ບໍ່", "ຢືນຍັນ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (data == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuProfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProfilesMouseClicked
        showPanel(new PanelProfile(id, name, status));
    }//GEN-LAST:event_jMenuProfilesMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMain;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCart;
    private javax.swing.JMenu jMenuCustomer;
    private javax.swing.JMenu jMenuData;
    private javax.swing.JMenuItem jMenuEmployee;
    private javax.swing.JMenu jMenuExit;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCustomer;
    private javax.swing.JMenuItem jMenuItemFlatlafDarcula;
    private javax.swing.JMenuItem jMenuItemFlatlafDark;
    private javax.swing.JMenuItem jMenuItemFlatlafIntelliJ;
    private javax.swing.JMenuItem jMenuItemFlatlafLight;
    private javax.swing.JMenu jMenuOrderImport;
    private javax.swing.JMenu jMenuProfiles;
    private javax.swing.JMenu jMenuProfiles1;
    private javax.swing.JMenu jMenuReport;
    private javax.swing.JMenu jMenuSearchItem;
    // End of variables declaration//GEN-END:variables
}
