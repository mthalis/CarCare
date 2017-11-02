/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare;

import carcare.controller.CustdataJpaController;
import static carcare.CarCare.view_bill_window;
import carcare.model.Billccc;
import carcare.model.Billcce;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Billing extends javax.swing.JInternalFrame {

    CustdataJpaController custdataJpaController = new CustdataJpaController(CarCare.EMF);
    
    public Billing() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        Date date = new Date();
        dateBill.setDate(date);
    }

    Billing(Billccc billccc) {
        initComponents();
        
        this.setTitle("CarCare Center Bill");
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        String biillNo = Double.toString(billccc.getBillNo());
        
        txtBillNo.setText(biillNo.substring(0, biillNo.length()- 2));
        dateBill.setDate(billccc.getDate());
        txtVNo.setText(billccc.getVno());
        txtMilage.setText(billccc.getMillage().toString());
        txtName.setText(billccc.getName());
        txtAddr.setText(billccc.getAddress());
        txtPhone.setText(billccc.getPhone());
        txtChasiNo.setText(billccc.getChasiNo());
        if(billccc.getPaymethod()){
           jRadioButton1.setSelected(true);
        }else{
           jRadioButton2.setSelected(true);
        }        
        txtAddby.setText(billccc.getAddby());
        txtChkAlign.setText(billccc.getChkAlign().toString());
        txtAdstToe.setText(billccc.getAjstToe().toString());
        txtCamber.setText(billccc.getCamber().toString());
        txtCaster.setText(billccc.getCaster().toString());
        txtBHight.setText(billccc.getBHight().toString());
        txtReToe.setText(billccc.getReToe().toString());
        txtReCamber.setText(billccc.getReCamber().toString());
        txtAnyOther.setText(billccc.getAnyOther().toString());
        txtSusTest.setText(billccc.getSusTest().toString());
        txtHLTest.setText(billccc.getHLTest().toString());
        chkFreeAlign.setSelected(billccc.getFreeAlign());
        chkFreeToe.setSelected(billccc.getFreeToe());
        chkFreeCamb.setSelected(billccc.getFreeCamb());
        chkFreeCast.setSelected(billccc.getFreeCast());
        chkFreeBHgt.setSelected(billccc.getFreeBhgt());
        chkFreeRToe.setSelected(billccc.getFreeRToe());
        chkFreeRCam.setSelected(billccc.getFreeRCam());
        chkFreeAnyO.setSelected(billccc.getFreeAnyo());
        chkFreeST.setSelected(billccc.getFreeSt());
        chkFreeHLT.setSelected(billccc.getFreeHlt());
        txtCCCSubTotal.setText(Integer.toString(billccc.getAmount()+ billccc.getDiscount()));
        txtDisCCCTotal.setText(billccc.getDiscount().toString());
        txtCCCTotal.setText(billccc.getAmount().toString());
        
    }

    Billing(Billcce billcce) {
        initComponents();
        
        this.setTitle("CarCare Enterprise Bill");
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        String biillNo = Double.toString(billcce.getBillNo());
        txtBillNo.setText(biillNo.substring(0, biillNo.length()- 2));
        dateBill.setDate(billcce.getDate());
        txtVNo.setText(billcce.getVno());
        txtMilage.setText(billcce.getMillage().toString());
        txtName.setText(billcce.getName());
        txtAddr.setText(billcce.getAddress());
        txtPhone.setText(billcce.getPhone());
        txtChasiNo.setText(billcce.getChasiNo());
        jTextField20.setText(billcce.getWbQt().toString());
        jTextField21.setText(billcce.getWQt().toString());
        //jTextField22.setText(billcce.getWbQt().toString());
        //jTextField23.setText(billcce.getWbQt().toString());
        jTextField27.setText(billcce.getWbRa().toString());
        //jTextField34.setText(billcce.getFixCmRR().toString());
        //jTextField20.setText(billcce.getWbQt().toString());
        jTextField33.setText(billcce.getWRa().toString());
        //jTextField34.setText(billcce.getFixCmRR().toString());
        //jTextField20.setText(billcce.getWbQt().toString());
        jTextField32.setText(billcce.getFixCmRF().toString());
        //jTextField34.setText(billcce.getFixCmRR().toString());
        jTextField31.setText(billcce.getFixCmRR().toString());
        jTextField30.setText(billcce.getOther1Ra().toString());
        jTextField29.setText(billcce.getOther2Ra().toString());
        jTextField28.setText(billcce.getOther3Ra().toString());
        jTextField37.setText(billcce.getOTHER3Txt());
        jTextField24.setText(billcce.getOther1Qt().toString());
        jTextField25.setText(billcce.getOther2Qt().toString());
        jTextField26.setText(billcce.getOther3Qt().toString());
        
        jTextField44.setText(Integer.toString(billcce.getAmount()+ billcce.getDiscount()));
        jTextField35.setText(billcce.getDiscount().toString());
        jTextField46.setText(billcce.getAmount().toString());
        
        jCheckBox11.setSelected(billcce.getFree1());
        jCheckBox12.setSelected(billcce.getFree2());
        jCheckBox13.setSelected(billcce.getFree3());
        jCheckBox14.setSelected(billcce.getFree4());
        
        if(billcce.getFree1()){
            jTextField34.setText("0");
        }else{
            int qty = Integer.parseInt(jTextField20.getText());
            int rate = Integer.parseInt(jTextField27.getText());
            int total = qty * rate;
            jTextField34.setText(Integer.toString(total));
        }
        
        if(billcce.getFree2()){
            jTextField40.setText("0");
        }else{
           jTextField40.setText(billcce.getWRa().toString());
        }
        
        if(billcce.getFree3()){
            jTextField39.setText("0");
        }else{
            jTextField39.setText(billcce.getFixCmRF().toString());
        }
        
        if(billcce.getFree4()){
            jTextField38.setText("0");
        }else{
            jTextField38.setText(billcce.getFixCmRR().toString());
        }
        
        int qty = Integer.parseInt(jTextField24.getText());
        int rate = Integer.parseInt(jTextField30.getText());
        int total = qty * rate;
        jTextField41.setText(Integer.toString(total));

        int qty1 = Integer.parseInt(jTextField25.getText());
        int rate1 = Integer.parseInt(jTextField29.getText());
        int total1 = qty1 * rate1;
        jTextField36.setText(Integer.toString(total1));

        int qty2 = Integer.parseInt(jTextField26.getText());
        int rate2 = Integer.parseInt(jTextField28.getText());
        int total2 = qty2* rate2;
        jTextField45.setText(Integer.toString(total2));

        
    }
    
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(38, 526, 263, 526); 
        g2d.drawLine(38, 550, 263, 550);
        
        
        g2d.drawLine(355, 500, 666, 500); 
        g2d.drawLine(355, 527, 666, 527);
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateBill = new com.toedter.calendar.JDateChooser();
        txtVNo = new javax.swing.JTextField();
        txtChasiNo = new javax.swing.JTextField();
        txtMilage = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        txtBillNo = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtAddby = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        chkFreeHLT = new javax.swing.JCheckBox();
        chkFreeToe = new javax.swing.JCheckBox();
        chkFreeCamb = new javax.swing.JCheckBox();
        chkFreeCast = new javax.swing.JCheckBox();
        chkFreeBHgt = new javax.swing.JCheckBox();
        chkFreeRToe = new javax.swing.JCheckBox();
        chkFreeRCam = new javax.swing.JCheckBox();
        chkFreeAnyO = new javax.swing.JCheckBox();
        chkFreeST = new javax.swing.JCheckBox();
        chkFreeAlign = new javax.swing.JCheckBox();
        txtChkAlign = new javax.swing.JTextField();
        txtAdstToe = new javax.swing.JTextField();
        txtCamber = new javax.swing.JTextField();
        txtCaster = new javax.swing.JTextField();
        txtBHight = new javax.swing.JTextField();
        txtReToe = new javax.swing.JTextField();
        txtReCamber = new javax.swing.JTextField();
        txtAnyOther = new javax.swing.JTextField();
        txtSusTest = new javax.swing.JTextField();
        txtHLTest = new javax.swing.JTextField();
        txtCCCSubTotal = new javax.swing.JTextField();
        txtCCCTotal = new javax.swing.JTextField();
        txtDisCCCTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setClosable(true);
        setTitle("Billing");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 64, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("V/ No");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 72, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Chasi No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 72, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Millage");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 72, 25));

        dateBill.setEnabled(false);
        jPanel1.add(dateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 120, 25));

        txtVNo.setEnabled(false);
        txtVNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVNoFocusLost(evt);
            }
        });
        jPanel1.add(txtVNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 120, 25));

        txtChasiNo.setEnabled(false);
        jPanel1.add(txtChasiNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, 25));

        txtMilage.setEnabled(false);
        jPanel1.add(txtMilage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 120, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Payment Method");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 120, 25));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 45, 70, 25));
        jPanel1.add(txtAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 330, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 70, 25));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 105, 25));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Name");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 13, 70, 25));

        jRadioButton1.setText("Cash");
        jRadioButton1.setEnabled(false);
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        jRadioButton2.setText("Credit");
        jRadioButton2.setEnabled(false);
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        txtBillNo.setEnabled(false);
        jPanel1.add(txtBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 13, 120, 25));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Bill No");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 72, 25));

        txtAddby.setEnabled(false);
        jPanel1.add(txtAddby, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 105, 25));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Add By");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 70, 25));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 90, -1));

        jTextField1.setText("Enter password ");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 130, -1));

        jLabel33.setText("Update Customer Details");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 170, 20));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAR CARE CENTER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Checking Align");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 120, -1));

        jLabel9.setText("Adjust Toe");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 45, 80, -1));

        jLabel10.setText("Camber");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 65, 80, -1));

        jLabel11.setText("Caster");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 85, 80, -1));

        jLabel12.setText("Body Height");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 105, 80, -1));

        jLabel13.setText("Rear Toe");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 125, 80, -1));

        jLabel14.setText("Rear Camber");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 145, 120, -1));

        jLabel15.setText("Any Other");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 165, 80, 20));

        jLabel16.setText("Susp. Test");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 185, 80, 20));

        jLabel17.setText("Head Light Test");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 205, 120, 20));

        chkFreeHLT.setEnabled(false);
        jPanel3.add(chkFreeHLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        chkFreeToe.setEnabled(false);
        jPanel3.add(chkFreeToe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        chkFreeCamb.setEnabled(false);
        jPanel3.add(chkFreeCamb, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        chkFreeCast.setEnabled(false);
        jPanel3.add(chkFreeCast, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        chkFreeBHgt.setEnabled(false);
        jPanel3.add(chkFreeBHgt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        chkFreeRToe.setEnabled(false);
        jPanel3.add(chkFreeRToe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        chkFreeRCam.setEnabled(false);
        jPanel3.add(chkFreeRCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        chkFreeAnyO.setEnabled(false);
        jPanel3.add(chkFreeAnyO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        chkFreeST.setEnabled(false);
        jPanel3.add(chkFreeST, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        chkFreeAlign.setEnabled(false);
        jPanel3.add(chkFreeAlign, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        txtChkAlign.setEnabled(false);
        jPanel3.add(txtChkAlign, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 60, -1));

        txtAdstToe.setEnabled(false);
        jPanel3.add(txtAdstToe, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 60, -1));

        txtCamber.setEnabled(false);
        jPanel3.add(txtCamber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 60, -1));

        txtCaster.setEnabled(false);
        jPanel3.add(txtCaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 60, -1));

        txtBHight.setEnabled(false);
        jPanel3.add(txtBHight, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 60, -1));

        txtReToe.setEnabled(false);
        jPanel3.add(txtReToe, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 60, -1));

        txtReCamber.setEnabled(false);
        jPanel3.add(txtReCamber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 60, -1));

        txtAnyOther.setEnabled(false);
        jPanel3.add(txtAnyOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 60, -1));

        txtSusTest.setEnabled(false);
        jPanel3.add(txtSusTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 60, -1));

        txtHLTest.setEnabled(false);
        jPanel3.add(txtHLTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 60, -1));

        txtCCCSubTotal.setEnabled(false);
        jPanel3.add(txtCCCSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 60, -1));

        txtCCCTotal.setEnabled(false);
        jPanel3.add(txtCCCTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 274, 60, -1));

        txtDisCCCTotal.setEnabled(false);
        jPanel3.add(txtDisCCCTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 60, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("TOTAL");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 273, 80, -1));

        jLabel19.setText("Discount");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 253, 80, -1));

        jLabel20.setText("Sub Total");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 233, 90, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAR CARE ENTERPRISES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Fixed Camber Fr.");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, 130, -1));

        jLabel22.setText("Fixed Camber Re.");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 120, 130, -1));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Amount");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 70, -1));

        jLabel24.setText("Wheel Balancing");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 130, -1));

        jTextField20.setEnabled(false);
        jPanel5.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 40, -1));

        jTextField21.setText("1");
        jTextField21.setEnabled(false);
        jPanel5.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, -1));

        jTextField22.setText("1");
        jTextField22.setEnabled(false);
        jPanel5.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 40, -1));

        jTextField23.setText("1");
        jTextField23.setEnabled(false);
        jPanel5.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 40, -1));

        jTextField24.setText("4");
        jTextField24.setEnabled(false);
        jPanel5.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 40, -1));

        jTextField25.setEnabled(false);
        jPanel5.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 40, -1));

        jTextField26.setEnabled(false);
        jPanel5.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 40, -1));

        jTextField27.setEnabled(false);
        jPanel5.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 40, -1));

        jTextField28.setEnabled(false);
        jPanel5.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 40, -1));

        jTextField29.setEnabled(false);
        jPanel5.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 40, -1));

        jTextField30.setEnabled(false);
        jPanel5.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 40, -1));

        jTextField31.setEnabled(false);
        jPanel5.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 40, -1));

        jTextField32.setEnabled(false);
        jPanel5.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 40, -1));

        jTextField33.setEnabled(false);
        jPanel5.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 40, -1));

        jTextField34.setEnabled(false);
        jPanel5.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 70, -1));

        jTextField35.setEnabled(false);
        jPanel5.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 70, -1));

        jTextField36.setEnabled(false);
        jPanel5.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 70, -1));

        jTextField37.setEnabled(false);
        jPanel5.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 180, 110, -1));

        jTextField38.setEnabled(false);
        jPanel5.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 70, -1));

        jTextField39.setEnabled(false);
        jPanel5.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 70, -1));

        jTextField40.setEnabled(false);
        jPanel5.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 70, -1));

        jCheckBox11.setEnabled(false);
        jPanel5.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 60, -1, -1));

        jCheckBox12.setEnabled(false);
        jPanel5.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 80, -1, -1));

        jCheckBox13.setEnabled(false);
        jPanel5.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 100, -1, -1));

        jCheckBox14.setEnabled(false);
        jPanel5.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 120, -1, -1));

        jTextField41.setEnabled(false);
        jPanel5.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 70, -1));

        jTextField42.setText("Tyre Change");
        jTextField42.setEnabled(false);
        jPanel5.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 160, 110, -1));

        jTextField43.setText("N2");
        jTextField43.setEnabled(false);
        jPanel5.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, 110, -1));

        jLabel25.setText("Weights");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 130, -1));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Qty");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 40, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Rate");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 40, -1));

        jTextField44.setEnabled(false);
        jPanel5.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, -1));

        jTextField45.setEnabled(false);
        jPanel5.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 70, -1));

        jLabel28.setText("Sub Total");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 205, 80, -1));

        jLabel29.setText("Discount");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 225, 80, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 51));
        jLabel30.setText("TOTAL");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 70, -1));

        jTextField46.setEnabled(false);
        jPanel5.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 70, -1));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel5.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 70, -1));

        btnPrint.setText("Re Print");
        jPanel5.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVNoFocusLost
        
    }//GEN-LAST:event_txtVNoFocusLost

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
        view_bill_window = 0;
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "You are not authorize to update Customer Details !");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        view_bill_window = 0;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JCheckBox chkFreeAlign;
    private javax.swing.JCheckBox chkFreeAnyO;
    private javax.swing.JCheckBox chkFreeBHgt;
    private javax.swing.JCheckBox chkFreeCamb;
    private javax.swing.JCheckBox chkFreeCast;
    private javax.swing.JCheckBox chkFreeHLT;
    private javax.swing.JCheckBox chkFreeRCam;
    private javax.swing.JCheckBox chkFreeRToe;
    private javax.swing.JCheckBox chkFreeST;
    private javax.swing.JCheckBox chkFreeToe;
    private com.toedter.calendar.JDateChooser dateBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField txtAddby;
    private javax.swing.JTextField txtAddr;
    private javax.swing.JTextField txtAdstToe;
    private javax.swing.JTextField txtAnyOther;
    private javax.swing.JTextField txtBHight;
    private javax.swing.JTextField txtBillNo;
    private javax.swing.JTextField txtCCCSubTotal;
    private javax.swing.JTextField txtCCCTotal;
    private javax.swing.JTextField txtCamber;
    private javax.swing.JTextField txtCaster;
    private javax.swing.JTextField txtChasiNo;
    private javax.swing.JTextField txtChkAlign;
    private javax.swing.JTextField txtDisCCCTotal;
    private javax.swing.JTextField txtHLTest;
    private javax.swing.JTextField txtMilage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtReCamber;
    private javax.swing.JTextField txtReToe;
    private javax.swing.JTextField txtSusTest;
    private javax.swing.JTextField txtVNo;
    // End of variables declaration//GEN-END:variables
}
