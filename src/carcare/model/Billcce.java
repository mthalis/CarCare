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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Dinesh
 */
@Entity
@Table(name = "billcce", catalog = "carcare", schema = "")
/*@NamedQueries({
    @NamedQuery(name = "Billcce.findAll", query = "SELECT b FROM Billcce b")
    , @NamedQuery(name = "Billcce.findByBillNo", query = "SELECT b FROM Billcce b WHERE b.billNo = :billNo")
    , @NamedQuery(name = "Billcce.findByVno", query = "SELECT b FROM Billcce b WHERE b.vno = :vno")
    , @NamedQuery(name = "Billcce.findByDate", query = "SELECT b FROM Billcce b WHERE b.date = :date")
    , @NamedQuery(name = "Billcce.findByMillage", query = "SELECT b FROM Billcce b WHERE b.millage = :millage")
    , @NamedQuery(name = "Billcce.findByName", query = "SELECT b FROM Billcce b WHERE b.name = :name")
    , @NamedQuery(name = "Billcce.findByAddress", query = "SELECT b FROM Billcce b WHERE b.address = :address")
    , @NamedQuery(name = "Billcce.findByPhone", query = "SELECT b FROM Billcce b WHERE b.phone = :phone")
    , @NamedQuery(name = "Billcce.findByChasiNo", query = "SELECT b FROM Billcce b WHERE b.chasiNo = :chasiNo")
    , @NamedQuery(name = "Billcce.findByFixCmRF", query = "SELECT b FROM Billcce b WHERE b.fixCmRF = :fixCmRF")
    , @NamedQuery(name = "Billcce.findByFixCmRR", query = "SELECT b FROM Billcce b WHERE b.fixCmRR = :fixCmRR")
    , @NamedQuery(name = "Billcce.findByWbRa", query = "SELECT b FROM Billcce b WHERE b.wbRa = :wbRa")
    , @NamedQuery(name = "Billcce.findByWRa", query = "SELECT b FROM Billcce b WHERE b.wRa = :wRa")
    , @NamedQuery(name = "Billcce.findByTyreRa", query = "SELECT b FROM Billcce b WHERE b.tyreRa = :tyreRa")
    , @NamedQuery(name = "Billcce.findByOther1Ra", query = "SELECT b FROM Billcce b WHERE b.other1Ra = :other1Ra")
    , @NamedQuery(name = "Billcce.findByOther2Ra", query = "SELECT b FROM Billcce b WHERE b.other2Ra = :other2Ra")
    , @NamedQuery(name = "Billcce.findByOther3Ra", query = "SELECT b FROM Billcce b WHERE b.other3Ra = :other3Ra")
    , @NamedQuery(name = "Billcce.findByFixCQF", query = "SELECT b FROM Billcce b WHERE b.fixCQF = :fixCQF")
    , @NamedQuery(name = "Billcce.findByFixCQR", query = "SELECT b FROM Billcce b WHERE b.fixCQR = :fixCQR")
    , @NamedQuery(name = "Billcce.findByWbQt", query = "SELECT b FROM Billcce b WHERE b.wbQt = :wbQt")
    , @NamedQuery(name = "Billcce.findByWQt", query = "SELECT b FROM Billcce b WHERE b.wQt = :wQt")
    , @NamedQuery(name = "Billcce.findByTyresQt", query = "SELECT b FROM Billcce b WHERE b.tyresQt = :tyresQt")
    , @NamedQuery(name = "Billcce.findByOther1Qt", query = "SELECT b FROM Billcce b WHERE b.other1Qt = :other1Qt")
    , @NamedQuery(name = "Billcce.findByOther2Qt", query = "SELECT b FROM Billcce b WHERE b.other2Qt = :other2Qt")
    , @NamedQuery(name = "Billcce.findByOther3Qt", query = "SELECT b FROM Billcce b WHERE b.other3Qt = :other3Qt")
    , @NamedQuery(name = "Billcce.findByDiscount", query = "SELECT b FROM Billcce b WHERE b.discount = :discount")
    , @NamedQuery(name = "Billcce.findByOTHER1Txt", query = "SELECT b FROM Billcce b WHERE b.oTHER1Txt = :oTHER1Txt")
    , @NamedQuery(name = "Billcce.findByOTHER2Txt", query = "SELECT b FROM Billcce b WHERE b.oTHER2Txt = :oTHER2Txt")
    , @NamedQuery(name = "Billcce.findByOTHER3Txt", query = "SELECT b FROM Billcce b WHERE b.oTHER3Txt = :oTHER3Txt")
    , @NamedQuery(name = "Billcce.findByAmount", query = "SELECT b FROM Billcce b WHERE b.amount = :amount")
    , @NamedQuery(name = "Billcce.findByFree1", query = "SELECT b FROM Billcce b WHERE b.free1 = :free1")
    , @NamedQuery(name = "Billcce.findByFree2", query = "SELECT b FROM Billcce b WHERE b.free2 = :free2")
    , @NamedQuery(name = "Billcce.findByFree3", query = "SELECT b FROM Billcce b WHERE b.free3 = :free3")
    , @NamedQuery(name = "Billcce.findByFree4", query = "SELECT b FROM Billcce b WHERE b.free4 = :free4")
    , @NamedQuery(name = "Billcce.findById", query = "SELECT b FROM Billcce b WHERE b.id = :id")
    , @NamedQuery(name = "Billcce.findByAddby", query = "SELECT b FROM Billcce b WHERE b.addby = :addby")
    , @NamedQuery(name = "Billcce.findByPaymethod", query = "SELECT b FROM Billcce b WHERE b.paymethod = :paymethod")
    , @NamedQuery(name = "Billcce.findByRePrint", query = "SELECT b FROM Billcce b WHERE b.rePrint = :rePrint")})*/
public class Billcce implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BILL_NO")
    private Double billNo;
    @Column(name = "VNO")
    private String vno;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "MILLAGE")
    private Double millage;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ChasiNo")
    private String chasiNo;
    @Column(name = "FIX_CM_R_F")
    private Integer fixCmRF;
    @Column(name = "FIX_CM_R_R")
    private Integer fixCmRR;
    @Column(name = "WB_RA")
    private Integer wbRa;
    @Column(name = "W_RA")
    private Integer wRa;
    @Column(name = "TYRE_RA")
    private Integer tyreRa;
    @Column(name = "OTHER1_RA")
    private Integer other1Ra;
    @Column(name = "OTHER2_RA")
    private Integer other2Ra;
    @Column(name = "OTHER3_RA")
    private Integer other3Ra;
    @Column(name = "FIX_C_Q_F")
    private Integer fixCQF;
    @Column(name = "FIX_C_Q_R")
    private Integer fixCQR;
    @Column(name = "WB_QT")
    private Integer wbQt;
    @Column(name = "W_QT")
    private Integer wQt;
    @Column(name = "TYRES_QT")
    private Integer tyresQt;
    @Column(name = "OTHER1_QT")
    private Integer other1Qt;
    @Column(name = "OTHER2_QT")
    private Integer other2Qt;
    @Column(name = "OTHER3_QT")
    private Integer other3Qt;
    @Column(name = "DISCOUNT")
    private Integer discount;
    @Column(name = "OTHER1_Txt")
    private String oTHER1Txt;
    @Column(name = "OTHER2_Txt")
    private String oTHER2Txt;
    @Column(name = "OTHER3_Txt")
    private String oTHER3Txt;
    @Column(name = "Amount")
    private Integer amount;
    @Column(name = "Free1")
    private Boolean free1;
    @Column(name = "Free2")
    private Boolean free2;
    @Column(name = "Free3")
    private Boolean free3;
    @Column(name = "Free4")
    private Boolean free4;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADDBY")
    private String addby;
    @Column(name = "PAYMETHOD")
    private Boolean paymethod;

    public Billcce() {
    }

    public Billcce(Integer id) {
        this.id = id;
    }

    public Billcce(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Double getBillNo() {
        return billNo;
    }

    public void setBillNo(Double billNo) {
        Double oldBillNo = this.billNo;
        this.billNo = billNo;
        changeSupport.firePropertyChange("billNo", oldBillNo, billNo);
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        String oldVno = this.vno;
        this.vno = vno;
        changeSupport.firePropertyChange("vno", oldVno, vno);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public Double getMillage() {
        return millage;
    }

    public void setMillage(Double millage) {
        Double oldMillage = this.millage;
        this.millage = millage;
        changeSupport.firePropertyChange("millage", oldMillage, millage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getChasiNo() {
        return chasiNo;
    }

    public void setChasiNo(String chasiNo) {
        String oldChasiNo = this.chasiNo;
        this.chasiNo = chasiNo;
        changeSupport.firePropertyChange("chasiNo", oldChasiNo, chasiNo);
    }

    public Integer getFixCmRF() {
        return fixCmRF;
    }

    public void setFixCmRF(Integer fixCmRF) {
        Integer oldFixCmRF = this.fixCmRF;
        this.fixCmRF = fixCmRF;
        changeSupport.firePropertyChange("fixCmRF", oldFixCmRF, fixCmRF);
    }

    public Integer getFixCmRR() {
        return fixCmRR;
    }

    public void setFixCmRR(Integer fixCmRR) {
        Integer oldFixCmRR = this.fixCmRR;
        this.fixCmRR = fixCmRR;
        changeSupport.firePropertyChange("fixCmRR", oldFixCmRR, fixCmRR);
    }

    public Integer getWbRa() {
        return wbRa;
    }

    public void setWbRa(Integer wbRa) {
        Integer oldWbRa = this.wbRa;
        this.wbRa = wbRa;
        changeSupport.firePropertyChange("wbRa", oldWbRa, wbRa);
    }

    public Integer getWRa() {
        return wRa;
    }

    public void setWRa(Integer wRa) {
        Integer oldWRa = this.wRa;
        this.wRa = wRa;
        changeSupport.firePropertyChange("WRa", oldWRa, wRa);
    }

    public Integer getTyreRa() {
        return tyreRa;
    }

    public void setTyreRa(Integer tyreRa) {
        Integer oldTyreRa = this.tyreRa;
        this.tyreRa = tyreRa;
        changeSupport.firePropertyChange("tyreRa", oldTyreRa, tyreRa);
    }

    public Integer getOther1Ra() {
        return other1Ra;
    }

    public void setOther1Ra(Integer other1Ra) {
        Integer oldOther1Ra = this.other1Ra;
        this.other1Ra = other1Ra;
        changeSupport.firePropertyChange("other1Ra", oldOther1Ra, other1Ra);
    }

    public Integer getOther2Ra() {
        return other2Ra;
    }

    public void setOther2Ra(Integer other2Ra) {
        Integer oldOther2Ra = this.other2Ra;
        this.other2Ra = other2Ra;
        changeSupport.firePropertyChange("other2Ra", oldOther2Ra, other2Ra);
    }

    public Integer getOther3Ra() {
        return other3Ra;
    }

    public void setOther3Ra(Integer other3Ra) {
        Integer oldOther3Ra = this.other3Ra;
        this.other3Ra = other3Ra;
        changeSupport.firePropertyChange("other3Ra", oldOther3Ra, other3Ra);
    }

    public Integer getFixCQF() {
        return fixCQF;
    }

    public void setFixCQF(Integer fixCQF) {
        Integer oldFixCQF = this.fixCQF;
        this.fixCQF = fixCQF;
        changeSupport.firePropertyChange("fixCQF", oldFixCQF, fixCQF);
    }

    public Integer getFixCQR() {
        return fixCQR;
    }

    public void setFixCQR(Integer fixCQR) {
        Integer oldFixCQR = this.fixCQR;
        this.fixCQR = fixCQR;
        changeSupport.firePropertyChange("fixCQR", oldFixCQR, fixCQR);
    }

    public Integer getWbQt() {
        return wbQt;
    }

    public void setWbQt(Integer wbQt) {
        Integer oldWbQt = this.wbQt;
        this.wbQt = wbQt;
        changeSupport.firePropertyChange("wbQt", oldWbQt, wbQt);
    }

    public Integer getWQt() {
        return wQt;
    }

    public void setWQt(Integer wQt) {
        Integer oldWQt = this.wQt;
        this.wQt = wQt;
        changeSupport.firePropertyChange("WQt", oldWQt, wQt);
    }

    public Integer getTyresQt() {
        return tyresQt;
    }

    public void setTyresQt(Integer tyresQt) {
        Integer oldTyresQt = this.tyresQt;
        this.tyresQt = tyresQt;
        changeSupport.firePropertyChange("tyresQt", oldTyresQt, tyresQt);
    }

    public Integer getOther1Qt() {
        return other1Qt;
    }

    public void setOther1Qt(Integer other1Qt) {
        Integer oldOther1Qt = this.other1Qt;
        this.other1Qt = other1Qt;
        changeSupport.firePropertyChange("other1Qt", oldOther1Qt, other1Qt);
    }

    public Integer getOther2Qt() {
        return other2Qt;
    }

    public void setOther2Qt(Integer other2Qt) {
        Integer oldOther2Qt = this.other2Qt;
        this.other2Qt = other2Qt;
        changeSupport.firePropertyChange("other2Qt", oldOther2Qt, other2Qt);
    }

    public Integer getOther3Qt() {
        return other3Qt;
    }

    public void setOther3Qt(Integer other3Qt) {
        Integer oldOther3Qt = this.other3Qt;
        this.other3Qt = other3Qt;
        changeSupport.firePropertyChange("other3Qt", oldOther3Qt, other3Qt);
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        Integer oldDiscount = this.discount;
        this.discount = discount;
        changeSupport.firePropertyChange("discount", oldDiscount, discount);
    }

    public String getOTHER1Txt() {
        return oTHER1Txt;
    }

    public void setOTHER1Txt(String oTHER1Txt) {
        String oldOTHER1Txt = this.oTHER1Txt;
        this.oTHER1Txt = oTHER1Txt;
        changeSupport.firePropertyChange("OTHER1Txt", oldOTHER1Txt, oTHER1Txt);
    }

    public String getOTHER2Txt() {
        return oTHER2Txt;
    }

    public void setOTHER2Txt(String oTHER2Txt) {
        String oldOTHER2Txt = this.oTHER2Txt;
        this.oTHER2Txt = oTHER2Txt;
        changeSupport.firePropertyChange("OTHER2Txt", oldOTHER2Txt, oTHER2Txt);
    }

    public String getOTHER3Txt() {
        return oTHER3Txt;
    }

    public void setOTHER3Txt(String oTHER3Txt) {
        String oldOTHER3Txt = this.oTHER3Txt;
        this.oTHER3Txt = oTHER3Txt;
        changeSupport.firePropertyChange("OTHER3Txt", oldOTHER3Txt, oTHER3Txt);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        Integer oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Boolean getFree1() {
        return free1;
    }

    public void setFree1(Boolean free1) {
        Boolean oldFree1 = this.free1;
        this.free1 = free1;
        changeSupport.firePropertyChange("free1", oldFree1, free1);
    }

    public Boolean getFree2() {
        return free2;
    }

    public void setFree2(Boolean free2) {
        Boolean oldFree2 = this.free2;
        this.free2 = free2;
        changeSupport.firePropertyChange("free2", oldFree2, free2);
    }

    public Boolean getFree3() {
        return free3;
    }

    public void setFree3(Boolean free3) {
        Boolean oldFree3 = this.free3;
        this.free3 = free3;
        changeSupport.firePropertyChange("free3", oldFree3, free3);
    }

    public Boolean getFree4() {
        return free4;
    }

    public void setFree4(Boolean free4) {
        Boolean oldFree4 = this.free4;
        this.free4 = free4;
        changeSupport.firePropertyChange("free4", oldFree4, free4);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getAddby() {
        return addby;
    }

    public void setAddby(String addby) {
        String oldAddby = this.addby;
        this.addby = addby;
        changeSupport.firePropertyChange("addby", oldAddby, addby);
    }

    public Boolean getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(Boolean paymethod) {
        Boolean oldPaymethod = this.paymethod;
        this.paymethod = paymethod;
        changeSupport.firePropertyChange("paymethod", oldPaymethod, paymethod);
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
        if (!(object instanceof Billcce)) {
            return false;
        }
        Billcce other = (Billcce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carcare.Billcce[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
