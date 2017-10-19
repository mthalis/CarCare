/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare;

import carcare.controller.CustdataJpaController;
import carcare.controller.LKController;
import carcare.controller.PaginationController;
import carcare.model.Custdata;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class CustomerDetails extends javax.swing.JInternalFrame {

    public static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("carcare?zeroDateTimeBehavior=convertToNullPU");
    String actionType = null;
    PaginationController pagination;
    CustdataJpaController custdataJpaController = new CustdataJpaController(EMF);
    
    public CustomerDetails() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        Date date = new Date();
        txtDate.setDate(date);
        
        LKController.resizeColumnWidth(jTable1);
        int jumlahBaris = Integer.parseInt(cmbJumlahBaris.getSelectedItem().toString());
        pagination = new PaginationController(15, custdataJpaController.getCustdataCount());
        refreshTable();
     
        //hide Last Date & Last Milage in add case
        jLabel4.setEnabled(false);
        jLabel9.setEnabled(false);       
        txtLastDate.setEnabled(false);
        txtLastMilage.setEnabled(false);
        
        actionType = "save";
        
        txtCusId.setVisible(false);
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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("carcare?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        custdataQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Custdata c").setMaxResults(30);
        custdataList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : custdataQuery.getResultList();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVNo = new javax.swing.JTextField();
        txtAddr = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLastMilage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMilage = new javax.swing.JTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnSaveUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtCusId = new javax.swing.JTextField();
        txtLastDate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        cmbJumlahBaris = new javax.swing.JComboBox();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setClosable(true);
        setTitle("Customer Details");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 73, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Vehicle No");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Address");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 116, 80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Last Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("City");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 157, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 198, 80, 30));

        txtVNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVNoActionPerformed(evt);
            }
        });
        jPanel1.add(txtVNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 25));
        jPanel1.add(txtAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 116, 344, 25));
        jPanel1.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 157, 344, 25));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 198, 344, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, 30));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 344, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Last Milage");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 80, 30));
        jPanel1.add(txtLastMilage, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 280, 120, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Milage");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        txtMilage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMilageActionPerformed(evt);
            }
        });
        jPanel1.add(txtMilage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 120, 25));

        txtDate.setDateFormatString("dd-MMM-yyyy");
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 40, 120, 25));

        btnSaveUpdate.setText("Save");
        btnSaveUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 90, 30));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 70, 30));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 80, 30));
        jPanel1.add(txtCusId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 30, -1));
        jPanel1.add(txtLastDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 120, 25));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, custdataList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vno}"));
        columnBinding.setColumnName("Vehicle No");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jdate}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        cmbJumlahBaris.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30" }));
        cmbJumlahBaris.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJumlahBarisItemStateChanged(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jTextField2.setText("Vehicle No");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtVNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVNoActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtMilageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMilageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMilageActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        pagination.firstPage();
        refreshTable();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        pagination.prevPage();
        refreshTable();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void cmbJumlahBarisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJumlahBarisItemStateChanged
        int jumlahBaris = Integer.parseInt(cmbJumlahBaris.getSelectedItem().toString());
        pagination = new PaginationController(jumlahBaris, custdataJpaController.getCustdataCount());
        refreshTable();
    }//GEN-LAST:event_cmbJumlahBarisItemStateChanged

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        pagination.nextPage();
        refreshTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        pagination.lastPage();
        refreshTable();
    }//GEN-LAST:event_btnLastActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String vNo = jTextField2.getText() != null ? jTextField2.getText() : "";
        if(!vNo.isEmpty()){
            custdataList.clear();
            List<Custdata> cusDataList = custdataJpaController.findCustdataByVno(vNo);
            if(cusDataList !=null && cusDataList.size() > 0){
                custdataList.addAll(cusDataList);
                jTable1.updateUI();
            }else{
                JOptionPane.showMessageDialog(jPanel1, "Vehicle number not found !");
                btnSearch.requestFocus();
            }
        }else{
            refreshTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUpdateActionPerformed
        final String regExp = "[0-9]+([.][0-9]{1,2})?";
        if(txtVNo.getText() == null || txtVNo.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Vehicle no ");
            txtVNo.requestFocus();
        }else if(txtMilage.getText() != null && !Pattern.matches(regExp, txtMilage.getText())){
            JOptionPane.showMessageDialog(jPanel1, "Please enter correct Milage");
            txtMilage.requestFocus();
        }else{
            Custdata custdata= new Custdata(); 
            custdata.setVno(txtVNo.getText().trim().toUpperCase());
            custdata.setName(txtName.getText() != null ? txtName.getText().trim().toUpperCase() : null);
            custdata.setAddress(txtAddr.getText() != null ? txtAddr.getText().trim().toUpperCase() : null);
            custdata.setCity(txtCity.getText() != null ? txtCity.getText().trim().toUpperCase() : null);            
            custdata.setFmilage(txtMilage.getText() != null ? Double.parseDouble(txtMilage.getText()) : 0);            
            custdata.setPhone(txtPhone.getText() != null ? txtPhone.getText().trim().toUpperCase() : null);
            custdata.setCredit(0.0);
            custdata.setDeDate(new Timestamp(System.currentTimeMillis()));
            
            try{
                if(null != actionType && actionType.equals("save")){
                    custdata.setJdate(txtDate.getDate());
                    custdata.setLdate(txtDate.getDate());
                    custdata.setLmilage(txtMilage.getText() != null ? Double.parseDouble(txtMilage.getText()) : 0);
                    
                    custdataJpaController.create(custdata);
                    JOptionPane.showMessageDialog(null, "Successfuly save record !");
                }else if(null != actionType && actionType.equals("edit")){
                    custdata.setJdate(txtDate.getDate());
                    custdata.setLdate(txtLastDate.getDate());
                    custdata.setLmilage(txtLastMilage.getText() != null ? Double.parseDouble(txtLastMilage.getText()) : 0);
                    custdata.setId(Integer.parseInt(txtCusId.getText()));
                    custdataJpaController.edit(custdata);
                    JOptionPane.showMessageDialog(null, "Successfuly edit record !");
                }
                clear();
                refreshTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jLabel4.setEnabled(true);
        jLabel9.setEnabled(true);       
        txtLastDate.setEnabled(true);
        txtLastMilage.setEnabled(true);
        
        // get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();
        Custdata cusdate = custdataList.get(jTable1.convertRowIndexToModel(selectedRowIndex));
        txtCusId.setText(Integer.toString(cusdate.getId()));
        txtVNo.setText(cusdate.getVno());
        txtName.setText(cusdate.getName());
        txtAddr.setText(cusdate.getAddress());
        txtCity.setText(cusdate.getCity());
        txtDate.setDate(cusdate.getJdate());
        txtMilage.setText(Double.toString(cusdate.getFmilage()));
        txtLastMilage.setText(Double.toString(cusdate.getLmilage()));
        txtPhone.setText(cusdate.getPhone());
        txtLastDate.setDate(cusdate.getLdate());
        btnSaveUpdate.setText("Update");
        
        actionType = "edit";

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        clear();
        
        //hide Last Date & Last Milage in add case
        jLabel4.setEnabled(false);
        jLabel9.setEnabled(false);       
        txtLastDate.setEnabled(false);
        txtLastMilage.setEnabled(false);
        
        btnSaveUpdate.setText("Save");
        actionType = "save";
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSaveUpdate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbJumlahBaris;
    private java.util.List<carcare.model.Custdata> custdataList;
    private javax.persistence.Query custdataQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtAddr;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCusId;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.toedter.calendar.JDateChooser txtLastDate;
    private javax.swing.JTextField txtLastMilage;
    private javax.swing.JTextField txtMilage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtVNo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
    private void refreshTable() {
        custdataList.clear();
        custdataList.addAll(custdataJpaController.findCustdataEntities(pagination.getPageSize(), pagination.getCurrentItem()));
        jTable1.updateUI();
        
        btnFirst.setEnabled(pagination.isHasPrevPage());
        btnPrev.setEnabled(pagination.isHasPrevPage());
        btnNext.setEnabled(pagination.isHasNextPage());
        btnLast.setEnabled(pagination.isHasNextPage());
    }
    
    public void clear(){
        txtVNo.setText("");
        txtName.setText("");
        txtAddr.setText("");
        txtCity.setText("");
        txtDate.setDate(new Date());
        txtMilage.setText("");
        txtPhone.setText("");
        txtLastDate.setDate(new Date());
        txtLastMilage.setText("");
    }

}
