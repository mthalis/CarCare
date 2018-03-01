/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare;

import static carcare.CarCare.user_window;
import carcare.controller.UserJpaController;
import carcare.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Dinesh
 */
public class AddUser extends javax.swing.JInternalFrame {

    final Logger logger = Logger.getLogger(AddUser.class);
    UserJpaController userJpaController = new UserJpaController(CarCare.EMF);
    String actionType = null;
    
    public AddUser() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DocumentFilter filter = new UppercaseDocumentFilter ();
        ((AbstractDocument) txtUserName2.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) txtChgUserName.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) txtUserName3.getDocument()).setDocumentFilter(filter);
        
        jRadioButton3.setSelected(true);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        
        jTextField1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("carcare?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        userQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM User u");
        userList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : userQuery.getResultList();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnAdd3 = new javax.swing.JButton();
        btnExit3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtConPassWd2 = new javax.swing.JPasswordField();
        txtPassWd2 = new javax.swing.JPasswordField();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtUserName2 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        btnAdd4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtChgUserName = new javax.swing.JTextField();
        txtChgOldPwd = new javax.swing.JPasswordField();
        txtChgPassWd = new javax.swing.JPasswordField();
        txtChgConPassWd = new javax.swing.JPasswordField();
        btnChgAdd = new javax.swing.JButton();
        btnChgExit = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtUserName3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnChgAdd1 = new javax.swing.JButton();
        btnChgExit1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setClosable(true);
        setTitle("User");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("User Name");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Password");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Confirm Password");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("User Role");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Active");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 30));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 142, 190));

        btnAdd3.setText("Save");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnAdd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 75, 25));

        btnExit3.setText("Close");
        btnExit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnExit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 75, 25));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtConPassWd2.setEnabled(false);
        txtConPassWd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConPassWd2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtConPassWd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, 30));

        txtPassWd2.setEnabled(false);
        txtPassWd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWd2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassWd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Regular User" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 170, 30));

        txtUserName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserName2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtUserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 30));

        jRadioButton4.setText("No");
        jRadioButton4.setEnabled(false);
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jRadioButton3.setText("Yes");
        jRadioButton3.setEnabled(false);
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 11, 200, 205));

        btnAdd4.setText("Add");
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });
        jPanel8.add(btnAdd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 75, 25));
        jPanel8.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 20, -1));

        jTabbedPane3.addTab("Add User", jPanel8);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("User Name");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 120, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Old Password");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 120, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("New Password");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 120, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Confirm Password");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 120, 30));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 21, 137, 160));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtChgUserName.setEnabled(false);
        jPanel13.add(txtChgUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 149, 30));
        jPanel13.add(txtChgOldPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 149, 30));
        jPanel13.add(txtChgPassWd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 149, 30));
        jPanel13.add(txtChgConPassWd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, 30));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 21, 160, 170));

        btnChgAdd.setText("Update");
        btnChgAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgAddActionPerformed(evt);
            }
        });
        jPanel11.add(btnChgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 75, 25));

        btnChgExit.setText("Close");
        btnChgExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgExitActionPerformed(evt);
            }
        });
        jPanel11.add(btnChgExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 75, 25));

        jTabbedPane3.addTab("Chage Password", jPanel11);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("User Name");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));

        txtUserName3.setEnabled(false);
        jPanel14.add(txtUserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 149, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Reset Password");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));
        jPanel14.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        btnChgAdd1.setText("Reset");
        btnChgAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgAdd1ActionPerformed(evt);
            }
        });
        jPanel14.add(btnChgAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 75, 25));

        btnChgExit1.setText("Close");
        btnChgExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgExit1ActionPerformed(evt);
            }
        });
        jPanel14.add(btnChgExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 75, 25));

        jTabbedPane3.addTab("Reset Password", jPanel14);

        jPanel10.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 370, 310));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("User Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${role}"));
        columnBinding.setColumnName("Role");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${active}"));
        columnBinding.setColumnName("Active");
        columnBinding.setColumnClass(Short.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
        }

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 310));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 340));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        try{            
            String userName = txtUserName2.getText();
            char[] passWd = txtPassWd2.getPassword();
            String pwd = "";

            for(char pw : passWd){
                pwd = pwd + pw;
            }

            char[] passWdCon = txtConPassWd2.getPassword();
            String pwdCon = "";

            for(char pwCon : passWdCon){
                pwdCon = pwdCon + pwCon;
            }

            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Please Enter Correct User Name !");
                txtUserName2.requestFocus();
            }else{
                if ("save".equals(actionType) && userJpaController.userAvailable(userName)) {
                    JOptionPane.showMessageDialog(jPanel1, "Enter User Name Already in System !");
                    txtUserName2.requestFocus();
                }else{
                    if ("save".equals(actionType) &&  pwd.isEmpty()){
                        JOptionPane.showMessageDialog(jPanel1, "Please Enter Password !");
                        txtPassWd2.requestFocus();
                    }else{
                        if ("save".equals(actionType) && pwdCon.isEmpty()){
                            JOptionPane.showMessageDialog(jPanel1, "Please Enter Confirm Password !");
                            txtConPassWd2.requestFocus();
                        }else{
                            if("save".equals(actionType) && !pwd.equalsIgnoreCase(pwdCon)){
                                JOptionPane.showMessageDialog(jPanel1, "Enter Password and Confirm Password not match !");
                                txtConPassWd2.requestFocus();
                            }else{
                                String pw = DigestUtils.sha256Hex(pwd);

                                User user = new User();
                                user.setUsername(userName);
                                user.setPassword(pw);
                                if(jRadioButton3.isSelected()){
                                    user.setActive((short)1);
                                }else{
                                    user.setActive((short)0);
                                }
                                
                                user.setRole(jComboBox2.getSelectedItem().toString());
                                
                                if(null != actionType && actionType.equals("save")){
                                    userJpaController.create(user);
                                    JOptionPane.showMessageDialog(jPanel1, "You are successfully Add User !");
                                }else if(null != actionType && actionType.equals("edit")){
                                    user.setId(Integer.parseInt(jTextField1.getText()));
                                    userJpaController.updateUser(user);
                                    JOptionPane.showMessageDialog(jPanel1, "You are successfully update User !");
                                }
                                
                                user_window = 0;
                                dispose();
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            logger.fatal("Error occured while saving User -> " + e);
        }
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnExit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit3ActionPerformed
        dispose();
        user_window = 0;
    }//GEN-LAST:event_btnExit3ActionPerformed

    private void btnChgAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgAddActionPerformed
        try{
            String userName = txtChgUserName.getText();
            char[] passWdOld = txtChgOldPwd.getPassword();

            String pwdOld = "";

            for(char pwOld : passWdOld){
                pwdOld = pwdOld + pwOld;
            }

            char[] passWd = txtChgPassWd.getPassword();
            String pwd = "";

            for(char pw : passWd){
                pwd = pwd + pw;
            }

            char[] passWdCon = txtChgConPassWd.getPassword();
            String pwdCon = "";

            for(char pwCon : passWdCon){
                pwdCon = pwdCon + pwCon;
            }

            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Please Enter Correct User Name !");
                txtChgUserName.requestFocus();
            }else{
                if (!userJpaController.userAvailable(userName)) {
                    JOptionPane.showMessageDialog(jPanel1, "Enter User Name does not in System !");
                    txtChgUserName.requestFocus();
                }else{
                    if(pwdOld.isEmpty()){
                        JOptionPane.showMessageDialog(jPanel1, "Please Enter Old Password !");
                        txtChgOldPwd.requestFocus();
                    }else{
                        String pwOld = DigestUtils.sha256Hex(pwdOld);
                        boolean authenticate  = userJpaController.authenticateUser(userName, pwOld);
                        if(!authenticate){
                            JOptionPane.showMessageDialog(jPanel1, "Your old password was incorrect !");
                            txtChgOldPwd.requestFocus();
                        }else{
                            if (pwd.isEmpty()){
                                showPopupMessage("Please Enter New Password !");
                                txtChgPassWd.requestFocus();
                            }else{
                                if (pwdCon.isEmpty()){
                                    showPopupMessage("Please Enter Confirm Password !");
                                    txtChgConPassWd.requestFocus();
                                }else{
                                    if(!pwd.equalsIgnoreCase(pwdCon)){
                                        showPopupMessage("Enter Password and Confirm Password not match !");
                                        txtChgConPassWd.requestFocus();
                                    }else{
                                        String pw = DigestUtils.sha256Hex(pwd);

                                        User user = new User();
                                        user.setUsername(userName);
                                        user.setPassword(pw);

                                        int userId = userJpaController.updateUserPWD(user);
                                        String msg;
                                        if(userId > 0){
                                            msg = "You are successfully change user Password !";
                                        }else{
                                            msg = "Error Occured, Please try again !";
                                        }
                                        showPopupMessage(msg);
                                        user_window = 0;
                                        dispose();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            logger.fatal("Error occured while saving User -> " + e);
        }
    }//GEN-LAST:event_btnChgAddActionPerformed

    private void btnChgExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgExitActionPerformed
        dispose();
        user_window = 0;
    }//GEN-LAST:event_btnChgExitActionPerformed

    private void btnChgAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgAdd1ActionPerformed
        String userName = txtUserName3.getText();        
        if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Please Enter Correct User Name !");
                txtUserName2.requestFocus();
        }else{
            if (!userJpaController.userAvailable(userName)) {
                JOptionPane.showMessageDialog(jPanel1, "Enter User Name does not in System !");
                txtUserName2.requestFocus();
            }else if(!jCheckBox1.isSelected()){                
                jCheckBox1.requestFocus();                
            }else{
                userJpaController.resetPwd(userName);
                JOptionPane.showMessageDialog(jPanel1, "Successfully reset password !");
            }
        }
    }//GEN-LAST:event_btnChgAdd1ActionPerformed

    private void btnChgExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgExit1ActionPerformed
        dispose();
        user_window = 0;
    }//GEN-LAST:event_btnChgExit1ActionPerformed

    private void txtUserName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserName2ActionPerformed
        jComboBox2.requestFocusInWindow();
    }//GEN-LAST:event_txtUserName2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        txtPassWd2.requestFocusInWindow();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtPassWd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWd2ActionPerformed
        txtConPassWd2.requestFocusInWindow();
    }//GEN-LAST:event_txtPassWd2ActionPerformed

    private void txtConPassWd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConPassWd2ActionPerformed
        btnAdd3.requestFocusInWindow();
    }//GEN-LAST:event_txtConPassWd2ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        txtUserName2.setText("");
        txtChgUserName.setText("");
        txtUserName3.setText("");
        txtUserName2.setEnabled(true);
        //jRadioButton3.setEnabled(true);
        //jRadioButton4.setEnabled(true);
        jRadioButton3.setSelected(true);
        txtPassWd2.setEnabled(true);
        txtConPassWd2.setEnabled(true);
        
        btnAdd3.setText("Save");
        actionType = "save";
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        txtUserName2.setText("");
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        
        txtPassWd2.setEnabled(false);
        txtConPassWd2.setEnabled(false);
        
        int selectedRowIndex = jTable2.getSelectedRow();
        User cusdate = userList.get(jTable2.convertRowIndexToModel(selectedRowIndex));
        txtUserName2.setText(cusdate.getUsername());
        txtChgUserName.setText(cusdate.getUsername());
        txtUserName3.setText(cusdate.getUsername());
        jTextField1.setText(cusdate.getId().toString());
        txtUserName2.setEnabled(false);
        if(cusdate.getActive()==1){
            jRadioButton3.setSelected(true);
        }else{
            jRadioButton4.setSelected(true);
        }
        jComboBox2.setSelectedItem(cusdate.getRole());
        
        btnAdd3.setText("Update");
        txtUserName2.requestFocusInWindow();
        //jComboBox2.set
        
        actionType = "edit";
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        user_window = 0;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JButton btnChgAdd;
    private javax.swing.JButton btnChgAdd1;
    private javax.swing.JButton btnChgExit;
    private javax.swing.JButton btnChgExit1;
    private javax.swing.JButton btnExit3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField txtChgConPassWd;
    private javax.swing.JPasswordField txtChgOldPwd;
    private javax.swing.JPasswordField txtChgPassWd;
    private javax.swing.JTextField txtChgUserName;
    private javax.swing.JPasswordField txtConPassWd2;
    private javax.swing.JPasswordField txtPassWd2;
    private javax.swing.JTextField txtUserName2;
    private javax.swing.JTextField txtUserName3;
    private java.util.List<carcare.model.User> userList;
    private javax.persistence.Query userQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void showPopupMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}

class CustomRenderer extends DefaultTableCellRenderer {
    
    @Override
    public void setValue(Object value){
        if( (Short)value == 1){
            value = "Yes";
        } else {
            value = "No";
        } 
        super.setValue(value);
    }    
}
