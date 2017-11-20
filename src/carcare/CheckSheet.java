/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare;

import static carcare.CarCare.view_check_window;
import carcare.controller.BillcccJpaController;
import carcare.controller.BillcceJpaController;
import carcare.controller.ChkshtJpaController;
import carcare.controller.CustdataJpaController;
import carcare.model.Chksht;
import carcare.model.Custdata;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Dinesh
 */
public class CheckSheet extends javax.swing.JInternalFrame {

    CustdataJpaController custdataJpaController = new CustdataJpaController(CarCare.EMF);
    ChkshtJpaController chkshtJpaController = new ChkshtJpaController(CarCare.EMF);
    BillcccJpaController billcccJpaController = new BillcccJpaController(CarCare.EMF);
    BillcceJpaController billcceJpaController = new BillcceJpaController(CarCare.EMF);
    boolean vNoEventFire = true;
    
    public CheckSheet() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        Date date = new Date();
        txtDate1.setDate(date);
        
        DocumentFilter filter = new UppercaseDocumentFilter ();
        ((AbstractDocument) txtVNo.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextField12.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextField11.getDocument()).setDocumentFilter(filter);
    }

    CheckSheet(Chksht checkSheet) {
        initComponents();
        
        vNoEventFire = false;
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DocumentFilter filter = new UppercaseDocumentFilter ();
        ((AbstractDocument) txtVNo.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextField12.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) jTextField11.getDocument()).setDocumentFilter(filter);
        
        txtVNo.setEnabled(false);
        txtVNo.setText(checkSheet.getCustdata().getVno());
        txtDate1.setDate(checkSheet.getDate());
        jTextField4.setText(Double.toString(checkSheet.getMilage()));
        
        
        Custdata cus = checkSheet.getCustdata();
        txtName.setText(cus.getName());
        txtAddr.setText(cus.getAddress());
        txtPhone.setText(cus.getPhone());
        txtMilage.setText(Double.toString(cus.getLmilage()));
        txtDate.setDate(cus.getLdate());

        jTextField23.setText(checkSheet.getFrToe());
        jTextField27.setText(checkSheet.getFrToe1());
        jTextField24.setText(checkSheet.getFrCmR());
        jTextField26.setText(checkSheet.getFrCmR1());
        jTextField25.setText(checkSheet.getFrCsR());
        jTextField28.setText(checkSheet.getFrCsR1());

        jTextField33.setText(checkSheet.getFrSb());
        jTextField29.setText(checkSheet.getFrCmL());
        jTextField32.setText(checkSheet.getFrCmL1());
        jTextField30.setText(checkSheet.getFrCsL());
        jTextField31.setText(checkSheet.getFrCsL1());

        jTextField3.setText(checkSheet.getReToeR());
        jTextField19.setText(checkSheet.getReToeR1());
        jTextField10.setText(checkSheet.getReCmR());
        jTextField18.setText(checkSheet.getReCmR1());
        jTextField20.setText(checkSheet.getReSb());

        jTextField22.setText(checkSheet.getReToeL());
        jTextField41.setText(checkSheet.getReToeL1());
        jTextField21.setText(checkSheet.getReCmL());
        jTextField40.setText(checkSheet.getReCmL1());

        jTextField7.setText(checkSheet.getTc1N());
        jTextField16.setText(checkSheet.getTc1I());
        jTextField36.setText(checkSheet.getTc1O());
        jTextField13.setText(checkSheet.getTc2N());
        jTextField15.setText(checkSheet.getTc2I());
        jTextField37.setText(checkSheet.getTc2O());
        jTextField14.setText(checkSheet.getTc3N());
        jTextField17.setText(checkSheet.getTc3I());
        jTextField38.setText(checkSheet.getTc3O());
        jTextField35.setText(checkSheet.getTc4N());
        jTextField34.setText(checkSheet.getTc4I());
        jTextField39.setText(checkSheet.getTc4O());

        jTextField6.setText(Integer.toString(checkSheet.getBwi1()));
        jTextField53.setText(Integer.toString(checkSheet.getBw1()));
        jTextField51.setText(Integer.toString(checkSheet.getBwi3()));
        jTextField52.setText(Integer.toString(checkSheet.getBw3()));

        jTextField55.setText(Integer.toString(checkSheet.getBwi2()));
        jTextField57.setText(Integer.toString(checkSheet.getBw2()));
        jTextField54.setText(Integer.toString(checkSheet.getBwi4()));
        jTextField56.setText(Integer.toString(checkSheet.getBw4()));

        jCheckBox3.setSelected(checkSheet.getSt());
        jCheckBox1.setSelected(checkSheet.getHlt());
        jCheckBox2.setSelected(checkSheet.getN2());

        jTextArea1.setText(checkSheet.getRem());

        jTextField12.setText(checkSheet.getJobby());
        jTextField11.setText(checkSheet.getAddby());

        jTextField8.setText(Integer.toString(checkSheet.getBAmount()));            
            
        jButton3.setText("Edit");
           /*
                checkSheet.setDeDate(new Timestamp(System.currentTimeMillis()));
            */
        int newMilage = (int) (checkSheet.getMilage() + 6000);
        jTextField5.setText(Integer.toString(newMilage));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtVNo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtAddr = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDate1 = new com.toedter.calendar.JDateChooser();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtMilage = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Check Sheet");
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Add by");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 34, 60, -1));

        jLabel8.setText("Job by");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 12, 60, -1));
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 80, -1));
        jPanel2.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 80, -1));

        jLabel51.setText("Head Lights");
        jPanel2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, -1));

        jLabel52.setText("N2");
        jPanel2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, -1));

        jLabel53.setText("Suspension");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, -1));
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 326, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tyre Condition", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 55, -1));
        jPanel3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 55, -1));
        jPanel3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 55, -1));
        jPanel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 70, 55, -1));
        jPanel3.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 50, 55, -1));
        jPanel3.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 90, 55, -1));

        jLabel11.setText("Fr L");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, -1));

        jLabel12.setText("Fr R");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Normal");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 53, -1));

        jLabel14.setText("Re R");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Out");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 53, -1));
        jPanel3.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 55, -1));
        jPanel3.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 55, -1));
        jPanel3.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 55, -1));
        jPanel3.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 55, -1));
        jPanel3.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 55, -1));
        jPanel3.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 110, 55, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("In");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 53, -1));

        jLabel40.setText("Re L");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 326, 190));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Front", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 55, -1));
        jPanel4.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 55, -1));
        jPanel4.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 55, -1));
        jPanel4.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 50, 55, -1));
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 30, 55, -1));
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 70, 55, -1));

        jLabel22.setText("Toe");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 40, -1));

        jLabel23.setText("Cam R");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, -1));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Pr.");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 53, -1));

        jLabel25.setText("Cas R");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, -1));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Aj.");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 53, -1));

        jLabel27.setText("S-B");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, -1));

        jLabel28.setText("L");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 20, -1));

        jLabel29.setText("L");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 20, -1));
        jPanel4.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 55, -1));
        jPanel4.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 55, -1));
        jPanel4.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 70, 55, -1));
        jPanel4.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 50, 55, -1));
        jPanel4.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 30, 55, -1));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Aj.");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 53, -1));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Pr.");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 53, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 326, 100));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rear", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 55, -1));
        jPanel5.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 55, -1));
        jPanel5.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 50, 55, -1));
        jPanel5.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 30, 55, -1));
        jPanel5.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 70, 55, -1));

        jLabel4.setText("Toe");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 40, -1));

        jLabel6.setText("Cam R");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("S-B");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 75, 53, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Aj.");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 53, -1));

        jLabel19.setText("L");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 20, -1));

        jLabel20.setText("L");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 20, -1));
        jPanel5.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 55, -1));
        jPanel5.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 55, -1));
        jPanel5.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 50, 55, -1));
        jPanel5.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 30, 55, -1));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Aj.");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 53, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Pr.");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 53, -1));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Pr.");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 53, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 326, 100));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balancing Weight", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 55, -1));

        jTextField51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField51KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 55, -1));

        jTextField52.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField52KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 60, 55, -1));

        jTextField53.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField53KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 40, 55, -1));

        jLabel3.setText("Fr R");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, -1));

        jLabel44.setText("Re R");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, -1));

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Out");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 53, -1));

        jLabel46.setText("L");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 20, -1));

        jLabel47.setText("L");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 20, -1));

        jTextField54.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField54KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 55, -1));

        jTextField55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField55KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 55, -1));

        jTextField56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField56KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 60, 55, -1));

        jTextField57.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField57KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 40, 55, -1));

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Out");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 53, -1));

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("In");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 53, -1));

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("In");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 53, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 326, 100));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Remarks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 620, 50));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 660, 80));

        txtVNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVNoFocusLost(evt);
            }
        });
        txtVNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVNoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtVNoMouseReleased(evt);
            }
        });
        jPanel1.add(txtVNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 120, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("V/ No");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 72, 25));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Name");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 25));

        txtName.setEnabled(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 280, 25));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Address");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 70, 25));

        txtAddr.setEnabled(false);
        jPanel1.add(txtAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 280, 25));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Date");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 76, 21));

        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 112, 25));

        jLabel5.setText("Milage Km");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 76, 21));

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 112, 25));

        jLabel9.setText("Next Milage Km");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 110, 21));
        jPanel9.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 112, 25));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 112, 25));

        jLabel10.setText("Amount");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 76, 21));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel9.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 90, -1));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel9.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 90, -1));

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 90, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 133, 360));

        txtMilage.setEnabled(false);
        jPanel1.add(txtMilage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, 25));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("L /Millage");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 72, 25));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Phone");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 60, 25));

        txtPhone.setEnabled(false);
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 120, 25));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Date");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 60, 25));

        txtDate.setEnabled(false);
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 120, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVNoFocusLost
        if(vNoEventFire){
            String vNo = txtVNo.getText();
            if(vNo != null && !vNo.isEmpty()){
                
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String formatDate = formater.format(txtDate1.getDate());
                
                List<Custdata> cusdate = custdataJpaController.findCustdataByVno(vNo);
                Object[] outPut = billcccJpaController.getBillCCCAmountMilage(vNo, formatDate);
                
                if(cusdate != null && cusdate.size() > 0){

                    Custdata cus = cusdate.get(0);
                    txtName.setText(cus.getName());
                    txtAddr.setText(cus.getAddress());
                    txtPhone.setText(cus.getPhone());
                    txtMilage.setText(Double.toString(cus.getLmilage()));
                    txtDate.setDate(cus.getLdate());
                    //txtMilage.requestFocus();
                    
                    if(null != outPut && outPut.length != 0){
                        jTextField4.setText(outPut[1].toString());
                        jTextField8.setText(outPut[0].toString());
                        int milage = (int) Double.parseDouble(outPut[1].toString());
                        int newMilage = milage + 6000;
                        jTextField5.setText(Integer.toString(newMilage));
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(jPanel1, "Vehicle number did not find !");
                    txtVNo.setText("");
                    txtName.setText("");
                    txtAddr.setText("");
                    txtPhone.setText("");
                    txtDate.setDate(null);
                    txtMilage.setText("");
                    txtVNo.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtVNoFocusLost

    private void txtVNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVNoMouseClicked

    }//GEN-LAST:event_txtVNoMouseClicked

    private void txtVNoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVNoMouseReleased
        /*String vNo = txtVNo.getText() != null ? txtVNo.getText() : "";
        List<Custdata> cusdate = custdataJpaController.findCustdataByVno(vNo);

        if(cusdate != null && cusdate.size() > 0){
            
            Custdata cus = cusdate.get(0);
            txtName.setText(cus.getName());
            txtAddr.setText(cus.getAddress());
            txtPhone.setText(cus.getPhone());
            txtMilage.setText(Double.toString(cus.getLmilage()));
            //txtDate.setText(cus.getLdate());
            //txtPhone.setText(cus.getPhone());
            //txtMilage.requestFocus();
        }else{
            JOptionPane.showMessageDialog(jPanel1, "Vehicle number did not find !");

            txtName.setText("");
            txtAddr.setText("");
            txtPhone.setText("");
            txtName.requestFocus();
        }*/
    }//GEN-LAST:event_txtVNoMouseReleased

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(txtVNo.getText() == null || txtVNo.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Vehicle no !");
            txtVNo.requestFocus();
        } else if(jTextField12.getText() == null || jTextField12.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Job by !");
            jTextField12.requestFocus();
        }else if(jTextField11.getText() == null || jTextField11.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Add by !");
            jTextField11.requestFocus();
        }else if(jTextField4.getText() == null || jTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Milage !");
            jTextField4.requestFocus();
        }else if(jTextField8.getText() == null || jTextField8.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1, "Please enter Amount !");
            jTextField8.requestFocus();
        }else{
            Chksht checkSheet = new Chksht();
            
            //checkSheet.setVno(txtVNo.getText());
            checkSheet.setDate(txtDate1.getDate());
            checkSheet.setMilage(Double.parseDouble(jTextField4.getText()));
            checkSheet.setNmilage(Double.parseDouble(jTextField5.getText()));
            
            checkSheet.setFrToe(jTextField23.getText());
            checkSheet.setFrToe1(jTextField27.getText());
            checkSheet.setFrCmR(jTextField24.getText());
            checkSheet.setFrCmR1(jTextField26.getText());
            checkSheet.setFrCsR(jTextField25.getText());
            checkSheet.setFrCsR1(jTextField28.getText());

            checkSheet.setFrSb(jTextField33.getText());
            checkSheet.setFrCmL(jTextField29.getText());
            checkSheet.setFrCmL1(jTextField32.getText());
            checkSheet.setFrCsL(jTextField30.getText());
            checkSheet.setFrCsL1(jTextField31.getText());
            
            checkSheet.setReToeR(jTextField3.getText());
            checkSheet.setReToeR1(jTextField19.getText());
            checkSheet.setReCmR(jTextField10.getText());
            checkSheet.setReCmR1(jTextField18.getText());
            checkSheet.setReSb(jTextField20.getText());
            
            checkSheet.setReToeL(jTextField22.getText());
            checkSheet.setReToeL1(jTextField41.getText());
            checkSheet.setReCmL(jTextField21.getText());
            checkSheet.setReCmL1(jTextField40.getText());
            
            checkSheet.setTc1N(jTextField7.getText());
            checkSheet.setTc1I(jTextField16.getText());
            checkSheet.setTc1O(jTextField36.getText());
            checkSheet.setTc2N(jTextField13.getText());
            checkSheet.setTc2I(jTextField15.getText());
            checkSheet.setTc2O(jTextField37.getText());
            checkSheet.setTc3N(jTextField14.getText());
            checkSheet.setTc3I(jTextField17.getText());
            checkSheet.setTc3O(jTextField38.getText());
            checkSheet.setTc4N(jTextField35.getText());
            checkSheet.setTc4I(jTextField34.getText());
            checkSheet.setTc4O(jTextField39.getText());
            
            checkSheet.setBwi1(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField6.getText()) : 0);
            checkSheet.setBw1(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField53.getText()): 0);
            checkSheet.setBwi3(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField51.getText()): 0);
            checkSheet.setBw3(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField52.getText()): 0);
            
            checkSheet.setBwi2(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField55.getText()): 0);
            checkSheet.setBw2(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField57.getText()): 0);
            checkSheet.setBwi4(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField54.getText()): 0);
            checkSheet.setBw4(!jTextField6.getText().isEmpty() ? Integer.parseInt(jTextField56.getText()): 0);
            
            checkSheet.setSt(jCheckBox3.isSelected());
            checkSheet.setHlt(jCheckBox1.isSelected());
            checkSheet.setN2(jCheckBox2.isSelected());
            
            checkSheet.setRem(jTextArea1.getText());
            
            checkSheet.setJobby(jTextField12.getText());
            checkSheet.setAddby(jTextField11.getText());
            
            checkSheet.setBAmount(Integer.parseInt(jTextField8.getText()));
            checkSheet.setDeDate(new Timestamp(System.currentTimeMillis()));
            
            chkshtJpaController.create(checkSheet);
            
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField53KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField53KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField53KeyTyped

    private void jTextField51KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField51KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField51KeyTyped

    private void jTextField52KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField52KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField52KeyTyped

    private void jTextField55KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField55KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField55KeyTyped

    private void jTextField57KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField57KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField57KeyTyped

    private void jTextField54KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField54KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField54KeyTyped

    private void jTextField56KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField56KeyTyped
       keyTyped(evt);
    }//GEN-LAST:event_jTextField56KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if(!jTextField4.getText().isEmpty()){
            int milage = Integer.parseInt(jTextField4.getText());
            int newMilage = milage + 6000;
            jTextField5.setText(Integer.toString(newMilage));
        }else{
           jTextField5.setText(""); 
        }
    }//GEN-LAST:event_jTextField4FocusLost

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
        view_check_window = 0;
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtVNo.setText("");
        txtName.setText("");
        txtAddr.setText("");
        txtMilage.setText("");
        txtPhone.setText("");
        txtDate.setDate(null);
        txtDate1.setDate(new Date());
        jTextField4.setText("");
        jTextField5.setText("");
            
        jTextField23.setText("");
        jTextField27.setText("");
        jTextField24.setText("");
        jTextField26.setText("");
        jTextField25.setText("");
        jTextField28.setText("");

        jTextField33.setText("");
        jTextField29.setText("");
        jTextField32.setText("");
        jTextField30.setText("");
        jTextField31.setText("");

        jTextField3.setText("");
        jTextField19.setText("");
        jTextField10.setText("");
        jTextField18.setText("");
        jTextField20.setText("");

        jTextField22.setText("");
        jTextField41.setText("");
        jTextField21.setText("");
        jTextField40.setText("");

        jTextField7.setText("");
        jTextField16.setText("");
        jTextField36.setText("");
        jTextField13.setText("");
        jTextField15.setText("");
        jTextField37.setText("");
        jTextField14.setText("");
        jTextField17.setText("");
        jTextField38.setText("");
        jTextField35.setText("");
        jTextField34.setText("");
        jTextField39.setText("");

        jTextField6.setText("");
        jTextField53.setText("");
        jTextField51.setText("");
        jTextField52.setText("");

        jTextField55.setText("");
        jTextField57.setText("");
        jTextField54.setText("");
        jTextField56.setText("");

        jCheckBox3.setSelected(false);
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);

        jTextArea1.setText("");

        jTextField12.setText("");
        jTextField11.setText("");

        jTextField8.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        view_check_window = 0;
    }//GEN-LAST:event_formInternalFrameClosed

    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField txtAddr;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.toedter.calendar.JDateChooser txtDate1;
    private javax.swing.JTextField txtMilage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtVNo;
    // End of variables declaration//GEN-END:variables
}
