/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "chksht", catalog = "carcare", schema = "")
/*@NamedQueries({
    @NamedQuery(name = "Chksht.findAll", query = "SELECT c FROM Chksht c")
    , @NamedQuery(name = "Chksht.findByVno", query = "SELECT c FROM Chksht c WHERE c.vno = :vno")
    , @NamedQuery(name = "Chksht.findByDate", query = "SELECT c FROM Chksht c WHERE c.date = :date")
    , @NamedQuery(name = "Chksht.findByMilage", query = "SELECT c FROM Chksht c WHERE c.milage = :milage")
    , @NamedQuery(name = "Chksht.findByNmilage", query = "SELECT c FROM Chksht c WHERE c.nmilage = :nmilage")
    , @NamedQuery(name = "Chksht.findByFrToe", query = "SELECT c FROM Chksht c WHERE c.frToe = :frToe")
    , @NamedQuery(name = "Chksht.findByFrToe1", query = "SELECT c FROM Chksht c WHERE c.frToe1 = :frToe1")
    , @NamedQuery(name = "Chksht.findByFrCmL", query = "SELECT c FROM Chksht c WHERE c.frCmL = :frCmL")
    , @NamedQuery(name = "Chksht.findByFrCmL1", query = "SELECT c FROM Chksht c WHERE c.frCmL1 = :frCmL1")
    , @NamedQuery(name = "Chksht.findByFrCmR", query = "SELECT c FROM Chksht c WHERE c.frCmR = :frCmR")
    , @NamedQuery(name = "Chksht.findByFrCmR1", query = "SELECT c FROM Chksht c WHERE c.frCmR1 = :frCmR1")
    , @NamedQuery(name = "Chksht.findByFrCsL", query = "SELECT c FROM Chksht c WHERE c.frCsL = :frCsL")
    , @NamedQuery(name = "Chksht.findByFrCsL1", query = "SELECT c FROM Chksht c WHERE c.frCsL1 = :frCsL1")
    , @NamedQuery(name = "Chksht.findByFrCsR", query = "SELECT c FROM Chksht c WHERE c.frCsR = :frCsR")
    , @NamedQuery(name = "Chksht.findByFrCsR1", query = "SELECT c FROM Chksht c WHERE c.frCsR1 = :frCsR1")
    , @NamedQuery(name = "Chksht.findByFrSb", query = "SELECT c FROM Chksht c WHERE c.frSb = :frSb")
    , @NamedQuery(name = "Chksht.findByFrSb1", query = "SELECT c FROM Chksht c WHERE c.frSb1 = :frSb1")
    , @NamedQuery(name = "Chksht.findByReToeR", query = "SELECT c FROM Chksht c WHERE c.reToeR = :reToeR")
    , @NamedQuery(name = "Chksht.findByReToeR1", query = "SELECT c FROM Chksht c WHERE c.reToeR1 = :reToeR1")
    , @NamedQuery(name = "Chksht.findByReToeL", query = "SELECT c FROM Chksht c WHERE c.reToeL = :reToeL")
    , @NamedQuery(name = "Chksht.findByReToeL1", query = "SELECT c FROM Chksht c WHERE c.reToeL1 = :reToeL1")
    , @NamedQuery(name = "Chksht.findByReCmL", query = "SELECT c FROM Chksht c WHERE c.reCmL = :reCmL")
    , @NamedQuery(name = "Chksht.findByReCmL1", query = "SELECT c FROM Chksht c WHERE c.reCmL1 = :reCmL1")
    , @NamedQuery(name = "Chksht.findByReCmR", query = "SELECT c FROM Chksht c WHERE c.reCmR = :reCmR")
    , @NamedQuery(name = "Chksht.findByReCmR1", query = "SELECT c FROM Chksht c WHERE c.reCmR1 = :reCmR1")
    , @NamedQuery(name = "Chksht.findByReSb", query = "SELECT c FROM Chksht c WHERE c.reSb = :reSb")
    , @NamedQuery(name = "Chksht.findByReSb1", query = "SELECT c FROM Chksht c WHERE c.reSb1 = :reSb1")
    , @NamedQuery(name = "Chksht.findByTc1N", query = "SELECT c FROM Chksht c WHERE c.tc1N = :tc1N")
    , @NamedQuery(name = "Chksht.findByTc1I", query = "SELECT c FROM Chksht c WHERE c.tc1I = :tc1I")
    , @NamedQuery(name = "Chksht.findByTc1O", query = "SELECT c FROM Chksht c WHERE c.tc1O = :tc1O")
    , @NamedQuery(name = "Chksht.findByTc2N", query = "SELECT c FROM Chksht c WHERE c.tc2N = :tc2N")
    , @NamedQuery(name = "Chksht.findByTc2I", query = "SELECT c FROM Chksht c WHERE c.tc2I = :tc2I")
    , @NamedQuery(name = "Chksht.findByTc2O", query = "SELECT c FROM Chksht c WHERE c.tc2O = :tc2O")
    , @NamedQuery(name = "Chksht.findByTc3N", query = "SELECT c FROM Chksht c WHERE c.tc3N = :tc3N")
    , @NamedQuery(name = "Chksht.findByTc3I", query = "SELECT c FROM Chksht c WHERE c.tc3I = :tc3I")
    , @NamedQuery(name = "Chksht.findByTc3O", query = "SELECT c FROM Chksht c WHERE c.tc3O = :tc3O")
    , @NamedQuery(name = "Chksht.findByTc4N", query = "SELECT c FROM Chksht c WHERE c.tc4N = :tc4N")
    , @NamedQuery(name = "Chksht.findByTc4I", query = "SELECT c FROM Chksht c WHERE c.tc4I = :tc4I")
    , @NamedQuery(name = "Chksht.findByTc4O", query = "SELECT c FROM Chksht c WHERE c.tc4O = :tc4O")
    , @NamedQuery(name = "Chksht.findByTt1", query = "SELECT c FROM Chksht c WHERE c.tt1 = :tt1")
    , @NamedQuery(name = "Chksht.findByTt2", query = "SELECT c FROM Chksht c WHERE c.tt2 = :tt2")
    , @NamedQuery(name = "Chksht.findByTt3", query = "SELECT c FROM Chksht c WHERE c.tt3 = :tt3")
    , @NamedQuery(name = "Chksht.findByTt4", query = "SELECT c FROM Chksht c WHERE c.tt4 = :tt4")
    , @NamedQuery(name = "Chksht.findByBw1", query = "SELECT c FROM Chksht c WHERE c.bw1 = :bw1")
    , @NamedQuery(name = "Chksht.findByBwi1", query = "SELECT c FROM Chksht c WHERE c.bwi1 = :bwi1")
    , @NamedQuery(name = "Chksht.findByBw2", query = "SELECT c FROM Chksht c WHERE c.bw2 = :bw2")
    , @NamedQuery(name = "Chksht.findByBwi2", query = "SELECT c FROM Chksht c WHERE c.bwi2 = :bwi2")
    , @NamedQuery(name = "Chksht.findByBw3", query = "SELECT c FROM Chksht c WHERE c.bw3 = :bw3")
    , @NamedQuery(name = "Chksht.findByBwi3", query = "SELECT c FROM Chksht c WHERE c.bwi3 = :bwi3")
    , @NamedQuery(name = "Chksht.findByBw4", query = "SELECT c FROM Chksht c WHERE c.bw4 = :bw4")
    , @NamedQuery(name = "Chksht.findByBwi4", query = "SELECT c FROM Chksht c WHERE c.bwi4 = :bwi4")
    , @NamedQuery(name = "Chksht.findBySt", query = "SELECT c FROM Chksht c WHERE c.st = :st")
    , @NamedQuery(name = "Chksht.findByHlt", query = "SELECT c FROM Chksht c WHERE c.hlt = :hlt")
    , @NamedQuery(name = "Chksht.findByN2", query = "SELECT c FROM Chksht c WHERE c.n2 = :n2")
    , @NamedQuery(name = "Chksht.findByJobby", query = "SELECT c FROM Chksht c WHERE c.jobby = :jobby")
    , @NamedQuery(name = "Chksht.findByBAmount", query = "SELECT c FROM Chksht c WHERE c.bAmount = :bAmount")
    , @NamedQuery(name = "Chksht.findByAddby", query = "SELECT c FROM Chksht c WHERE c.addby = :addby")
    , @NamedQuery(name = "Chksht.findByDeDate", query = "SELECT c FROM Chksht c WHERE c.deDate = :deDate")
    , @NamedQuery(name = "Chksht.findById", query = "SELECT c FROM Chksht c WHERE c.id = :id")})*/
public class Chksht implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    //@Column(name = "VNO")
    //private String vno;
   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VNO", referencedColumnName="VNO")
    private Custdata custdata;
    
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MILAGE")
    private Double milage;
    @Column(name = "NMILAGE")
    private Double nmilage;
    @Column(name = "FR_TOE")
    private String frToe;
    @Column(name = "FR_TOE1")
    private String frToe1;
    @Column(name = "FR_CM_L")
    private String frCmL;
    @Column(name = "FR_CM_L1")
    private String frCmL1;
    @Column(name = "FR_CM_R")
    private String frCmR;
    @Column(name = "FR_CM_R1")
    private String frCmR1;
    @Column(name = "FR_CS_L")
    private String frCsL;
    @Column(name = "FR_CS_L1")
    private String frCsL1;
    @Column(name = "FR_CS_R")
    private String frCsR;
    @Column(name = "FR_CS_R1")
    private String frCsR1;
    @Column(name = "FR_SB")
    private String frSb;
    @Column(name = "FR_SB1")
    private String frSb1;
    @Column(name = "RE_TOE_R")
    private String reToeR;
    @Column(name = "RE_TOE_R1")
    private String reToeR1;
    @Column(name = "RE_TOE_L")
    private String reToeL;
    @Column(name = "RE_TOE_L1")
    private String reToeL1;
    @Column(name = "RE_CM_L")
    private String reCmL;
    @Column(name = "RE_CM_L1")
    private String reCmL1;
    @Column(name = "RE_CM_R")
    private String reCmR;
    @Column(name = "RE_CM_R1")
    private String reCmR1;
    @Column(name = "RE_SB")
    private String reSb;
    @Column(name = "RE_SB1")
    private String reSb1;
    @Column(name = "TC1_N")
    private String tc1N;
    @Column(name = "TC1_I")
    private String tc1I;
    @Column(name = "TC1_O")
    private String tc1O;
    @Column(name = "TC2_N")
    private String tc2N;
    @Column(name = "TC2_I")
    private String tc2I;
    @Column(name = "TC2_O")
    private String tc2O;
    @Column(name = "TC3_N")
    private String tc3N;
    @Column(name = "TC3_I")
    private String tc3I;
    @Column(name = "TC3_O")
    private String tc3O;
    @Column(name = "TC4_N")
    private String tc4N;
    @Column(name = "TC4_I")
    private String tc4I;
    @Column(name = "TC4_O")
    private String tc4O;
    @Column(name = "TT1")
    private String tt1;
    @Column(name = "TT2")
    private String tt2;
    @Column(name = "TT3")
    private String tt3;
    @Column(name = "TT4")
    private String tt4;
    @Column(name = "BW1")
    private Integer bw1;
    @Column(name = "BWI1")
    private Integer bwi1;
    @Column(name = "BW2")
    private Integer bw2;
    @Column(name = "BWI2")
    private Integer bwi2;
    @Column(name = "BW3")
    private Integer bw3;
    @Column(name = "BWI3")
    private Integer bwi3;
    @Column(name = "BW4")
    private Integer bw4;
    @Column(name = "BWI4")
    private Integer bwi4;
    @Column(name = "ST")
    private Boolean st;
    @Column(name = "HLT")
    private Boolean hlt;
    @Column(name = "N2")
    private Boolean n2;
    @Column(name = "JOBBY")
    private String jobby;
    @Column(name = "B_AMOUNT")
    private Integer bAmount;
    @Column(name = "ADDBY")
    private String addby;
    @Basic(optional = false)
    @Column(name = "DE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deDate;
    @Lob
    @Column(name = "REM")
    private String rem;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Chksht() {
    }

    public Chksht(Integer id) {
        this.id = id;
    }

    public Chksht(Integer id, Date date, Date deDate) {
        this.id = id;
        this.date = date;
        this.deDate = deDate;
    }

    public Custdata getCustdata() {
        return custdata;
    }

    public void setCustdata(Custdata custdata) {
        this.custdata = custdata;
    }

    
    
    /*public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        String oldVno = this.vno;
        this.vno = vno;
        changeSupport.firePropertyChange("vno", oldVno, vno);
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public Double getMilage() {
        return milage;
    }

    public void setMilage(Double milage) {
        Double oldMilage = this.milage;
        this.milage = milage;
        changeSupport.firePropertyChange("milage", oldMilage, milage);
    }

    public Double getNmilage() {
        return nmilage;
    }

    public void setNmilage(Double nmilage) {
        Double oldNmilage = this.nmilage;
        this.nmilage = nmilage;
        changeSupport.firePropertyChange("nmilage", oldNmilage, nmilage);
    }

    public String getFrToe() {
        return frToe;
    }

    public void setFrToe(String frToe) {
        String oldFrToe = this.frToe;
        this.frToe = frToe;
        changeSupport.firePropertyChange("frToe", oldFrToe, frToe);
    }

    public String getFrToe1() {
        return frToe1;
    }

    public void setFrToe1(String frToe1) {
        String oldFrToe1 = this.frToe1;
        this.frToe1 = frToe1;
        changeSupport.firePropertyChange("frToe1", oldFrToe1, frToe1);
    }

    public String getFrCmL() {
        return frCmL;
    }

    public void setFrCmL(String frCmL) {
        String oldFrCmL = this.frCmL;
        this.frCmL = frCmL;
        changeSupport.firePropertyChange("frCmL", oldFrCmL, frCmL);
    }

    public String getFrCmL1() {
        return frCmL1;
    }

    public void setFrCmL1(String frCmL1) {
        String oldFrCmL1 = this.frCmL1;
        this.frCmL1 = frCmL1;
        changeSupport.firePropertyChange("frCmL1", oldFrCmL1, frCmL1);
    }

    public String getFrCmR() {
        return frCmR;
    }

    public void setFrCmR(String frCmR) {
        String oldFrCmR = this.frCmR;
        this.frCmR = frCmR;
        changeSupport.firePropertyChange("frCmR", oldFrCmR, frCmR);
    }

    public String getFrCmR1() {
        return frCmR1;
    }

    public void setFrCmR1(String frCmR1) {
        String oldFrCmR1 = this.frCmR1;
        this.frCmR1 = frCmR1;
        changeSupport.firePropertyChange("frCmR1", oldFrCmR1, frCmR1);
    }

    public String getFrCsL() {
        return frCsL;
    }

    public void setFrCsL(String frCsL) {
        String oldFrCsL = this.frCsL;
        this.frCsL = frCsL;
        changeSupport.firePropertyChange("frCsL", oldFrCsL, frCsL);
    }

    public String getFrCsL1() {
        return frCsL1;
    }

    public void setFrCsL1(String frCsL1) {
        String oldFrCsL1 = this.frCsL1;
        this.frCsL1 = frCsL1;
        changeSupport.firePropertyChange("frCsL1", oldFrCsL1, frCsL1);
    }

    public String getFrCsR() {
        return frCsR;
    }

    public void setFrCsR(String frCsR) {
        String oldFrCsR = this.frCsR;
        this.frCsR = frCsR;
        changeSupport.firePropertyChange("frCsR", oldFrCsR, frCsR);
    }

    public String getFrCsR1() {
        return frCsR1;
    }

    public void setFrCsR1(String frCsR1) {
        String oldFrCsR1 = this.frCsR1;
        this.frCsR1 = frCsR1;
        changeSupport.firePropertyChange("frCsR1", oldFrCsR1, frCsR1);
    }

    public String getFrSb() {
        return frSb;
    }

    public void setFrSb(String frSb) {
        String oldFrSb = this.frSb;
        this.frSb = frSb;
        changeSupport.firePropertyChange("frSb", oldFrSb, frSb);
    }

    public String getFrSb1() {
        return frSb1;
    }

    public void setFrSb1(String frSb1) {
        String oldFrSb1 = this.frSb1;
        this.frSb1 = frSb1;
        changeSupport.firePropertyChange("frSb1", oldFrSb1, frSb1);
    }

    public String getReToeR() {
        return reToeR;
    }

    public void setReToeR(String reToeR) {
        String oldReToeR = this.reToeR;
        this.reToeR = reToeR;
        changeSupport.firePropertyChange("reToeR", oldReToeR, reToeR);
    }

    public String getReToeR1() {
        return reToeR1;
    }

    public void setReToeR1(String reToeR1) {
        String oldReToeR1 = this.reToeR1;
        this.reToeR1 = reToeR1;
        changeSupport.firePropertyChange("reToeR1", oldReToeR1, reToeR1);
    }

    public String getReToeL() {
        return reToeL;
    }

    public void setReToeL(String reToeL) {
        String oldReToeL = this.reToeL;
        this.reToeL = reToeL;
        changeSupport.firePropertyChange("reToeL", oldReToeL, reToeL);
    }

    public String getReToeL1() {
        return reToeL1;
    }

    public void setReToeL1(String reToeL1) {
        String oldReToeL1 = this.reToeL1;
        this.reToeL1 = reToeL1;
        changeSupport.firePropertyChange("reToeL1", oldReToeL1, reToeL1);
    }

    public String getReCmL() {
        return reCmL;
    }

    public void setReCmL(String reCmL) {
        String oldReCmL = this.reCmL;
        this.reCmL = reCmL;
        changeSupport.firePropertyChange("reCmL", oldReCmL, reCmL);
    }

    public String getReCmL1() {
        return reCmL1;
    }

    public void setReCmL1(String reCmL1) {
        String oldReCmL1 = this.reCmL1;
        this.reCmL1 = reCmL1;
        changeSupport.firePropertyChange("reCmL1", oldReCmL1, reCmL1);
    }

    public String getReCmR() {
        return reCmR;
    }

    public void setReCmR(String reCmR) {
        String oldReCmR = this.reCmR;
        this.reCmR = reCmR;
        changeSupport.firePropertyChange("reCmR", oldReCmR, reCmR);
    }

    public String getReCmR1() {
        return reCmR1;
    }

    public void setReCmR1(String reCmR1) {
        String oldReCmR1 = this.reCmR1;
        this.reCmR1 = reCmR1;
        changeSupport.firePropertyChange("reCmR1", oldReCmR1, reCmR1);
    }

    public String getReSb() {
        return reSb;
    }

    public void setReSb(String reSb) {
        String oldReSb = this.reSb;
        this.reSb = reSb;
        changeSupport.firePropertyChange("reSb", oldReSb, reSb);
    }

    public String getReSb1() {
        return reSb1;
    }

    public void setReSb1(String reSb1) {
        String oldReSb1 = this.reSb1;
        this.reSb1 = reSb1;
        changeSupport.firePropertyChange("reSb1", oldReSb1, reSb1);
    }

    public String getTc1N() {
        return tc1N;
    }

    public void setTc1N(String tc1N) {
        String oldTc1N = this.tc1N;
        this.tc1N = tc1N;
        changeSupport.firePropertyChange("tc1N", oldTc1N, tc1N);
    }

    public String getTc1I() {
        return tc1I;
    }

    public void setTc1I(String tc1I) {
        String oldTc1I = this.tc1I;
        this.tc1I = tc1I;
        changeSupport.firePropertyChange("tc1I", oldTc1I, tc1I);
    }

    public String getTc1O() {
        return tc1O;
    }

    public void setTc1O(String tc1O) {
        String oldTc1O = this.tc1O;
        this.tc1O = tc1O;
        changeSupport.firePropertyChange("tc1O", oldTc1O, tc1O);
    }

    public String getTc2N() {
        return tc2N;
    }

    public void setTc2N(String tc2N) {
        String oldTc2N = this.tc2N;
        this.tc2N = tc2N;
        changeSupport.firePropertyChange("tc2N", oldTc2N, tc2N);
    }

    public String getTc2I() {
        return tc2I;
    }

    public void setTc2I(String tc2I) {
        String oldTc2I = this.tc2I;
        this.tc2I = tc2I;
        changeSupport.firePropertyChange("tc2I", oldTc2I, tc2I);
    }

    public String getTc2O() {
        return tc2O;
    }

    public void setTc2O(String tc2O) {
        String oldTc2O = this.tc2O;
        this.tc2O = tc2O;
        changeSupport.firePropertyChange("tc2O", oldTc2O, tc2O);
    }

    public String getTc3N() {
        return tc3N;
    }

    public void setTc3N(String tc3N) {
        String oldTc3N = this.tc3N;
        this.tc3N = tc3N;
        changeSupport.firePropertyChange("tc3N", oldTc3N, tc3N);
    }

    public String getTc3I() {
        return tc3I;
    }

    public void setTc3I(String tc3I) {
        String oldTc3I = this.tc3I;
        this.tc3I = tc3I;
        changeSupport.firePropertyChange("tc3I", oldTc3I, tc3I);
    }

    public String getTc3O() {
        return tc3O;
    }

    public void setTc3O(String tc3O) {
        String oldTc3O = this.tc3O;
        this.tc3O = tc3O;
        changeSupport.firePropertyChange("tc3O", oldTc3O, tc3O);
    }

    public String getTc4N() {
        return tc4N;
    }

    public void setTc4N(String tc4N) {
        String oldTc4N = this.tc4N;
        this.tc4N = tc4N;
        changeSupport.firePropertyChange("tc4N", oldTc4N, tc4N);
    }

    public String getTc4I() {
        return tc4I;
    }

    public void setTc4I(String tc4I) {
        String oldTc4I = this.tc4I;
        this.tc4I = tc4I;
        changeSupport.firePropertyChange("tc4I", oldTc4I, tc4I);
    }

    public String getTc4O() {
        return tc4O;
    }

    public void setTc4O(String tc4O) {
        String oldTc4O = this.tc4O;
        this.tc4O = tc4O;
        changeSupport.firePropertyChange("tc4O", oldTc4O, tc4O);
    }

    public String getTt1() {
        return tt1;
    }

    public void setTt1(String tt1) {
        String oldTt1 = this.tt1;
        this.tt1 = tt1;
        changeSupport.firePropertyChange("tt1", oldTt1, tt1);
    }

    public String getTt2() {
        return tt2;
    }

    public void setTt2(String tt2) {
        String oldTt2 = this.tt2;
        this.tt2 = tt2;
        changeSupport.firePropertyChange("tt2", oldTt2, tt2);
    }

    public String getTt3() {
        return tt3;
    }

    public void setTt3(String tt3) {
        String oldTt3 = this.tt3;
        this.tt3 = tt3;
        changeSupport.firePropertyChange("tt3", oldTt3, tt3);
    }

    public String getTt4() {
        return tt4;
    }

    public void setTt4(String tt4) {
        String oldTt4 = this.tt4;
        this.tt4 = tt4;
        changeSupport.firePropertyChange("tt4", oldTt4, tt4);
    }

    public Integer getBw1() {
        return bw1;
    }

    public void setBw1(Integer bw1) {
        Integer oldBw1 = this.bw1;
        this.bw1 = bw1;
        changeSupport.firePropertyChange("bw1", oldBw1, bw1);
    }

    public Integer getBwi1() {
        return bwi1;
    }

    public void setBwi1(Integer bwi1) {
        Integer oldBwi1 = this.bwi1;
        this.bwi1 = bwi1;
        changeSupport.firePropertyChange("bwi1", oldBwi1, bwi1);
    }

    public Integer getBw2() {
        return bw2;
    }

    public void setBw2(Integer bw2) {
        Integer oldBw2 = this.bw2;
        this.bw2 = bw2;
        changeSupport.firePropertyChange("bw2", oldBw2, bw2);
    }

    public Integer getBwi2() {
        return bwi2;
    }

    public void setBwi2(Integer bwi2) {
        Integer oldBwi2 = this.bwi2;
        this.bwi2 = bwi2;
        changeSupport.firePropertyChange("bwi2", oldBwi2, bwi2);
    }

    public Integer getBw3() {
        return bw3;
    }

    public void setBw3(Integer bw3) {
        Integer oldBw3 = this.bw3;
        this.bw3 = bw3;
        changeSupport.firePropertyChange("bw3", oldBw3, bw3);
    }

    public Integer getBwi3() {
        return bwi3;
    }

    public void setBwi3(Integer bwi3) {
        Integer oldBwi3 = this.bwi3;
        this.bwi3 = bwi3;
        changeSupport.firePropertyChange("bwi3", oldBwi3, bwi3);
    }

    public Integer getBw4() {
        return bw4;
    }

    public void setBw4(Integer bw4) {
        Integer oldBw4 = this.bw4;
        this.bw4 = bw4;
        changeSupport.firePropertyChange("bw4", oldBw4, bw4);
    }

    public Integer getBwi4() {
        return bwi4;
    }

    public void setBwi4(Integer bwi4) {
        Integer oldBwi4 = this.bwi4;
        this.bwi4 = bwi4;
        changeSupport.firePropertyChange("bwi4", oldBwi4, bwi4);
    }

    public Boolean getSt() {
        return st;
    }

    public void setSt(Boolean st) {
        Boolean oldSt = this.st;
        this.st = st;
        changeSupport.firePropertyChange("st", oldSt, st);
    }

    public Boolean getHlt() {
        return hlt;
    }

    public void setHlt(Boolean hlt) {
        Boolean oldHlt = this.hlt;
        this.hlt = hlt;
        changeSupport.firePropertyChange("hlt", oldHlt, hlt);
    }

    public Boolean getN2() {
        return n2;
    }

    public void setN2(Boolean n2) {
        Boolean oldN2 = this.n2;
        this.n2 = n2;
        changeSupport.firePropertyChange("N2", oldN2, n2);
    }

    public String getJobby() {
        return jobby;
    }

    public void setJobby(String jobby) {
        String oldJobby = this.jobby;
        this.jobby = jobby;
        changeSupport.firePropertyChange("jobby", oldJobby, jobby);
    }

    public Integer getBAmount() {
        return bAmount;
    }

    public void setBAmount(Integer bAmount) {
        Integer oldBAmount = this.bAmount;
        this.bAmount = bAmount;
        changeSupport.firePropertyChange("BAmount", oldBAmount, bAmount);
    }

    public String getAddby() {
        return addby;
    }

    public void setAddby(String addby) {
        String oldAddby = this.addby;
        this.addby = addby;
        changeSupport.firePropertyChange("addby", oldAddby, addby);
    }

    public Date getDeDate() {
        return deDate;
    }

    public void setDeDate(Date deDate) {
        Date oldDeDate = this.deDate;
        this.deDate = deDate;
        changeSupport.firePropertyChange("deDate", oldDeDate, deDate);
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        String oldRem = this.rem;
        this.rem = rem;
        changeSupport.firePropertyChange("rem", oldRem, rem);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chksht)) {
            return false;
        }
        Chksht other = (Chksht) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carcare.Chksht[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
