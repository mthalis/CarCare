/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare;

import static carcare.CarCare.jDesktopPane1;
import carcare.controller.BillcccJpaController;
import carcare.controller.BillcceJpaController;
import carcare.controller.LKController;
import carcare.controller.PaginationController;
import carcare.model.Billccc;
import carcare.model.Billcce;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lenovo
 */
public class ViewBill extends javax.swing.JInternalFrame {

    public static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("carcare?zeroDateTimeBehavior=convertToNullPU");
    String actionType = null;
    PaginationController pagination;
    PaginationController pagination1;
    BillcceJpaController billcceJpaController = new BillcceJpaController(EMF);
    BillcccJpaController billcccJpaController = new BillcccJpaController(EMF);
    
    public ViewBill() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        LKController.resizeColumnWidth(jTable1);
        int jumlahBaris = Integer.parseInt(cmbJumlahBaris.getSelectedItem().toString());
        pagination = new PaginationController(17, billcceJpaController.getBillcceCount());
        pagination1 = new PaginationController(17, billcccJpaController.getBillcccCount());
        refreshTable();
       
        /*
         "UPDATE Logfile SET RBILLNO = RBILLNO+1";
        cmdText = "UPDATE Logfile SET CCCBILLNO = CCCBILLNO+1";
        this.oleDbCmd = new OdbcCommand("UPDATE Logfile SET CCEBILLNO = CCEBILLNO+1", this.oleDbCnn1);
        cmdText = "INSERT INTO custdata(VNO,NAME,ADDRESS,PHONE,FMILAGE,LMILAGE) VALUES('" + this.txtVNo.Text + "','" + this.txtName.Text + "','" + this.txtAddress.Text + "','" + this.txtPhone.Text + "'," + this.txtMilage.Text + "," + this.txtMilage.Text + ")";
        cmdText = "UPDATE custdata SET LDATE = #" + DateAndTime.Now.ToString() + "#,LMILAGE =" + this.txtMilage.Text + " WHERE VNo ='" + this.txtVNo.Text + "' ";
        
        
        */
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
        billcccQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Billccc b").setMaxResults(17);
        billcccList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : billcccQuery.getResultList();
        billcceQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Billcce b").setMaxResults(17);
        billcceList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : billcceQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        cmbJumlahBaris = new javax.swing.JComboBox();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        cmbJumlahBaris1 = new javax.swing.JComboBox();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        btnSearchv = new javax.swing.JButton();

        setClosable(true);
        setTitle("View Bill");

        jPanel1.setPreferredSize(new java.awt.Dimension(862, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("carcare center"));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, billcccList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vno}"));
        columnBinding.setColumnName("VNO");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${billNo}"));
        columnBinding.setColumnName("Bill No");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 420, 340));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("carcare enterprise"));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, billcceList, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vno}"));
        columnBinding.setColumnName("VNO");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${billNo}"));
        columnBinding.setColumnName("Bill No");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 420, 340));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 410, 40));

        btnFirst1.setText("First");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPrev1.setText("<");
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        cmbJumlahBaris1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30" }));
        cmbJumlahBaris1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJumlahBaris1ItemStateChanged(evt);
            }
        });

        btnNext1.setText(">");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setText("Last");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(btnFirst1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbJumlahBaris1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast1)
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1)
                    .addComponent(btnPrev1)
                    .addComponent(cmbJumlahBaris1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext1)
                    .addComponent(btnLast1))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 420, 40));

        jTextField2.setText("Vehicle No");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        btnSearchv.setText("Search");
        btnSearchv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchv)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchv))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        pagination = new PaginationController(jumlahBaris, billcceJpaController.getBillcceCount());
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

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        pagination1.firstPage();
        refreshTable1();
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        pagination1.prevPage();
        refreshTable1();
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void cmbJumlahBaris1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJumlahBaris1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJumlahBaris1ItemStateChanged

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        pagination1.nextPage();
        refreshTable1();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        pagination1.lastPage();
        refreshTable1();
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void btnSearchvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchvActionPerformed
        String vNo = jTextField2.getText() != null ? jTextField2.getText() : "";
        billcccList.clear();
        billcccList.addAll(billcccJpaController.findBillcccByVno(vNo));
        jTable1.updateUI();
        
        billcceList.clear();
        billcceList.addAll(billcceJpaController.findBillcceByVno(vNo));
        jTable2.updateUI();
    }//GEN-LAST:event_btnSearchvActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRowIndex = jTable1.getSelectedRow();
        Billccc billccc = billcccList.get(jTable1.convertRowIndexToModel(selectedRowIndex));
        
        Billing billing = new Billing(billccc);
        jDesktopPane1.add(billing);
        billing.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int selectedRowIndex = jTable2.getSelectedRow();
        Billcce billcce = billcceList.get(jTable2.convertRowIndexToModel(selectedRowIndex));
        
        Billing billing = new Billing(billcce);
        jDesktopPane1.add(billing);
        billing.setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<carcare.model.Billccc> billcccList;
    private javax.persistence.Query billcccQuery;
    private java.util.List<carcare.model.Billcce> billcceList;
    private javax.persistence.Query billcceQuery;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnSearchv;
    private javax.swing.JComboBox cmbJumlahBaris;
    private javax.swing.JComboBox cmbJumlahBaris1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
    private void refreshTable() {
        billcceList.clear();
        billcceList.addAll(billcceJpaController.findBillcceEntities(pagination.getPageSize(), pagination.getCurrentItem()));
        jTable2.updateUI();
        
        btnFirst.setEnabled(pagination.isHasPrevPage());
        btnPrev.setEnabled(pagination.isHasPrevPage());
        btnNext.setEnabled(pagination.isHasNextPage());
        btnLast.setEnabled(pagination.isHasNextPage());
    }
    
    private void refreshTable1() {
        billcccList.clear();
        billcccList.addAll(billcccJpaController.findBillcccEntities(pagination1.getPageSize(), pagination1.getCurrentItem()));
        jTable1.updateUI();
        
        btnFirst1.setEnabled(pagination1.isHasPrevPage());
        btnPrev1.setEnabled(pagination1.isHasPrevPage());
        btnNext1.setEnabled(pagination1.isHasNextPage());
        btnLast1.setEnabled(pagination1.isHasNextPage());
    }
}
