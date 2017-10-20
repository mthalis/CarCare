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
@Table(name = "billccc", catalog = "carcare", schema = "")
@NamedQueries({
    @NamedQuery(name = "Billccc.findAll", query = "SELECT b FROM Billccc b")
    , @NamedQuery(name = "Billccc.findByBillNo", query = "SELECT b FROM Billccc b WHERE b.billNo = :billNo")
    , @NamedQuery(name = "Billccc.findByDate", query = "SELECT b FROM Billccc b WHERE b.date = :date")
    , @NamedQuery(name = "Billccc.findByVno", query = "SELECT b FROM Billccc b WHERE b.vno = :vno")
    , @NamedQuery(name = "Billccc.findByMillage", query = "SELECT b FROM Billccc b WHERE b.millage = :millage")
    , @NamedQuery(name = "Billccc.findByName", query = "SELECT b FROM Billccc b WHERE b.name = :name")
    , @NamedQuery(name = "Billccc.findByAddress", query = "SELECT b FROM Billccc b WHERE b.address = :address")
    , @NamedQuery(name = "Billccc.findByPhone", query = "SELECT b FROM Billccc b WHERE b.phone = :phone")
    , @NamedQuery(name = "Billccc.findByChasiNo", query = "SELECT b FROM Billccc b WHERE b.chasiNo = :chasiNo")
    , @NamedQuery(name = "Billccc.findByChkAlign", query = "SELECT b FROM Billccc b WHERE b.chkAlign = :chkAlign")
    , @NamedQuery(name = "Billccc.findByAjstToe", query = "SELECT b FROM Billccc b WHERE b.ajstToe = :ajstToe")
    , @NamedQuery(name = "Billccc.findByCamber", query = "SELECT b FROM Billccc b WHERE b.camber = :camber")
    , @NamedQuery(name = "Billccc.findByCaster", query = "SELECT b FROM Billccc b WHERE b.caster = :caster")
    , @NamedQuery(name = "Billccc.findByBHight", query = "SELECT b FROM Billccc b WHERE b.bHight = :bHight")
    , @NamedQuery(name = "Billccc.findByReToe", query = "SELECT b FROM Billccc b WHERE b.reToe = :reToe")
    , @NamedQuery(name = "Billccc.findByReCamber", query = "SELECT b FROM Billccc b WHERE b.reCamber = :reCamber")
    , @NamedQuery(name = "Billccc.findByAnyOther", query = "SELECT b FROM Billccc b WHERE b.anyOther = :anyOther")
    , @NamedQuery(name = "Billccc.findByWBlncing", query = "SELECT b FROM Billccc b WHERE b.wBlncing = :wBlncing")
    , @NamedQuery(name = "Billccc.findByWeights", query = "SELECT b FROM Billccc b WHERE b.weights = :weights")
    , @NamedQuery(name = "Billccc.findBySusTest", query = "SELECT b FROM Billccc b WHERE b.susTest = :susTest")
    , @NamedQuery(name = "Billccc.findByHLTest", query = "SELECT b FROM Billccc b WHERE b.hLTest = :hLTest")
    , @NamedQuery(name = "Billccc.findByR", query = "SELECT b FROM Billccc b WHERE b.r = :r")
    , @NamedQuery(name = "Billccc.findByFreeAlign", query = "SELECT b FROM Billccc b WHERE b.freeAlign = :freeAlign")
    , @NamedQuery(name = "Billccc.findByFreeToe", query = "SELECT b FROM Billccc b WHERE b.freeToe = :freeToe")
    , @NamedQuery(name = "Billccc.findByFreeCamb", query = "SELECT b FROM Billccc b WHERE b.freeCamb = :freeCamb")
    , @NamedQuery(name = "Billccc.findByFreeCast", query = "SELECT b FROM Billccc b WHERE b.freeCast = :freeCast")
    , @NamedQuery(name = "Billccc.findByFreeBhgt", query = "SELECT b FROM Billccc b WHERE b.freeBhgt = :freeBhgt")
    , @NamedQuery(name = "Billccc.findByFreeRToe", query = "SELECT b FROM Billccc b WHERE b.freeRToe = :freeRToe")
    , @NamedQuery(name = "Billccc.findByFreeRCam", query = "SELECT b FROM Billccc b WHERE b.freeRCam = :freeRCam")
    , @NamedQuery(name = "Billccc.findByFreeAnyo", query = "SELECT b FROM Billccc b WHERE b.freeAnyo = :freeAnyo")
    , @NamedQuery(name = "Billccc.findByFreeWb", query = "SELECT b FROM Billccc b WHERE b.freeWb = :freeWb")
    , @NamedQuery(name = "Billccc.findByFreeWeit", query = "SELECT b FROM Billccc b WHERE b.freeWeit = :freeWeit")
    , @NamedQuery(name = "Billccc.findByFreeSt", query = "SELECT b FROM Billccc b WHERE b.freeSt = :freeSt")
    , @NamedQuery(name = "Billccc.findByFreeHlt", query = "SELECT b FROM Billccc b WHERE b.freeHlt = :freeHlt")
    , @NamedQuery(name = "Billccc.findByAmount", query = "SELECT b FROM Billccc b WHERE b.amount = :amount")
    , @NamedQuery(name = "Billccc.findById", query = "SELECT b FROM Billccc b WHERE b.id = :id")
    , @NamedQuery(name = "Billccc.findByDiscount", query = "SELECT b FROM Billccc b WHERE b.discount = :discount")
    , @NamedQuery(name = "Billccc.findByAddby", query = "SELECT b FROM Billccc b WHERE b.addby = :addby")
    , @NamedQuery(name = "Billccc.findByPaymethod", query = "SELECT b FROM Billccc b WHERE b.paymethod = :paymethod")})
public class Billccc implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BILL_NO")
    private Double billNo;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "VNO")
    private String vno;
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
    @Column(name = "CHK_ALIGN")
    private Integer chkAlign;
    @Column(name = "AJST_TOE")
    private Integer ajstToe;
    @Column(name = "CAMBER")
    private Integer camber;
    @Column(name = "CASTER")
    private Integer caster;
    @Column(name = "B_HIGHT")
    private Integer bHight;
    @Column(name = "RE_TOE")
    private Integer reToe;
    @Column(name = "RE_CAMBER")
    private Integer reCamber;
    @Column(name = "ANY_OTHER")
    private Integer anyOther;
    @Column(name = "W_BLNCING")
    private Integer wBlncing;
    @Column(name = "WEIGHTS")
    private Integer weights;
    @Column(name = "SUS_TEST")
    private Integer susTest;
    @Column(name = "H_L_TEST")
    private Integer hLTest;
    @Column(name = "R")
    private Boolean r;
    @Column(name = "FREE_ALIGN")
    private Boolean freeAlign;
    @Column(name = "FREE_TOE")
    private Boolean freeToe;
    @Column(name = "FREE_CAMB")
    private Boolean freeCamb;
    @Column(name = "FREE_CAST")
    private Boolean freeCast;
    @Column(name = "FREE_BHGT")
    private Boolean freeBhgt;
    @Column(name = "FREE_R_TOE")
    private Boolean freeRToe;
    @Column(name = "FREE_R_CAM")
    private Boolean freeRCam;
    @Column(name = "FREE_ANYO")
    private Boolean freeAnyo;
    @Column(name = "FREE_WB")
    private Boolean freeWb;
    @Column(name = "FREE_WEIT")
    private Boolean freeWeit;
    @Column(name = "FREE_ST")
    private Boolean freeSt;
    @Column(name = "FREE_HLT")
    private Boolean freeHlt;
    @Column(name = "Amount")
    private Integer amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DISCOUNT")
    private Integer discount;
    @Column(name = "ADDBY")
    private String addby;
    @Column(name = "PAYMETHOD")
    private Boolean paymethod;

    public Billccc() {
    }

    public Billccc(Integer id) {
        this.id = id;
    }

    public Billccc(Integer id, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        String oldVno = this.vno;
        this.vno = vno;
        changeSupport.firePropertyChange("vno", oldVno, vno);
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

    public Integer getChkAlign() {
        return chkAlign;
    }

    public void setChkAlign(Integer chkAlign) {
        Integer oldChkAlign = this.chkAlign;
        this.chkAlign = chkAlign;
        changeSupport.firePropertyChange("chkAlign", oldChkAlign, chkAlign);
    }

    public Integer getAjstToe() {
        return ajstToe;
    }

    public void setAjstToe(Integer ajstToe) {
        Integer oldAjstToe = this.ajstToe;
        this.ajstToe = ajstToe;
        changeSupport.firePropertyChange("ajstToe", oldAjstToe, ajstToe);
    }

    public Integer getCamber() {
        return camber;
    }

    public void setCamber(Integer camber) {
        Integer oldCamber = this.camber;
        this.camber = camber;
        changeSupport.firePropertyChange("camber", oldCamber, camber);
    }

    public Integer getCaster() {
        return caster;
    }

    public void setCaster(Integer caster) {
        Integer oldCaster = this.caster;
        this.caster = caster;
        changeSupport.firePropertyChange("caster", oldCaster, caster);
    }

    public Integer getBHight() {
        return bHight;
    }

    public void setBHight(Integer bHight) {
        Integer oldBHight = this.bHight;
        this.bHight = bHight;
        changeSupport.firePropertyChange("BHight", oldBHight, bHight);
    }

    public Integer getReToe() {
        return reToe;
    }

    public void setReToe(Integer reToe) {
        Integer oldReToe = this.reToe;
        this.reToe = reToe;
        changeSupport.firePropertyChange("reToe", oldReToe, reToe);
    }

    public Integer getReCamber() {
        return reCamber;
    }

    public void setReCamber(Integer reCamber) {
        Integer oldReCamber = this.reCamber;
        this.reCamber = reCamber;
        changeSupport.firePropertyChange("reCamber", oldReCamber, reCamber);
    }

    public Integer getAnyOther() {
        return anyOther;
    }

    public void setAnyOther(Integer anyOther) {
        Integer oldAnyOther = this.anyOther;
        this.anyOther = anyOther;
        changeSupport.firePropertyChange("anyOther", oldAnyOther, anyOther);
    }

    public Integer getWBlncing() {
        return wBlncing;
    }

    public void setWBlncing(Integer wBlncing) {
        Integer oldWBlncing = this.wBlncing;
        this.wBlncing = wBlncing;
        changeSupport.firePropertyChange("WBlncing", oldWBlncing, wBlncing);
    }

    public Integer getWeights() {
        return weights;
    }

    public void setWeights(Integer weights) {
        Integer oldWeights = this.weights;
        this.weights = weights;
        changeSupport.firePropertyChange("weights", oldWeights, weights);
    }

    public Integer getSusTest() {
        return susTest;
    }

    public void setSusTest(Integer susTest) {
        Integer oldSusTest = this.susTest;
        this.susTest = susTest;
        changeSupport.firePropertyChange("susTest", oldSusTest, susTest);
    }

    public Integer getHLTest() {
        return hLTest;
    }

    public void setHLTest(Integer hLTest) {
        Integer oldHLTest = this.hLTest;
        this.hLTest = hLTest;
        changeSupport.firePropertyChange("HLTest", oldHLTest, hLTest);
    }

    public Boolean getR() {
        return r;
    }

    public void setR(Boolean r) {
        Boolean oldR = this.r;
        this.r = r;
        changeSupport.firePropertyChange("r", oldR, r);
    }

    public Boolean getFreeAlign() {
        return freeAlign;
    }

    public void setFreeAlign(Boolean freeAlign) {
        Boolean oldFreeAlign = this.freeAlign;
        this.freeAlign = freeAlign;
        changeSupport.firePropertyChange("freeAlign", oldFreeAlign, freeAlign);
    }

    public Boolean getFreeToe() {
        return freeToe;
    }

    public void setFreeToe(Boolean freeToe) {
        Boolean oldFreeToe = this.freeToe;
        this.freeToe = freeToe;
        changeSupport.firePropertyChange("freeToe", oldFreeToe, freeToe);
    }

    public Boolean getFreeCamb() {
        return freeCamb;
    }

    public void setFreeCamb(Boolean freeCamb) {
        Boolean oldFreeCamb = this.freeCamb;
        this.freeCamb = freeCamb;
        changeSupport.firePropertyChange("freeCamb", oldFreeCamb, freeCamb);
    }

    public Boolean getFreeCast() {
        return freeCast;
    }

    public void setFreeCast(Boolean freeCast) {
        Boolean oldFreeCast = this.freeCast;
        this.freeCast = freeCast;
        changeSupport.firePropertyChange("freeCast", oldFreeCast, freeCast);
    }

    public Boolean getFreeBhgt() {
        return freeBhgt;
    }

    public void setFreeBhgt(Boolean freeBhgt) {
        Boolean oldFreeBhgt = this.freeBhgt;
        this.freeBhgt = freeBhgt;
        changeSupport.firePropertyChange("freeBhgt", oldFreeBhgt, freeBhgt);
    }

    public Boolean getFreeRToe() {
        return freeRToe;
    }

    public void setFreeRToe(Boolean freeRToe) {
        Boolean oldFreeRToe = this.freeRToe;
        this.freeRToe = freeRToe;
        changeSupport.firePropertyChange("freeRToe", oldFreeRToe, freeRToe);
    }

    public Boolean getFreeRCam() {
        return freeRCam;
    }

    public void setFreeRCam(Boolean freeRCam) {
        Boolean oldFreeRCam = this.freeRCam;
        this.freeRCam = freeRCam;
        changeSupport.firePropertyChange("freeRCam", oldFreeRCam, freeRCam);
    }

    public Boolean getFreeAnyo() {
        return freeAnyo;
    }

    public void setFreeAnyo(Boolean freeAnyo) {
        Boolean oldFreeAnyo = this.freeAnyo;
        this.freeAnyo = freeAnyo;
        changeSupport.firePropertyChange("freeAnyo", oldFreeAnyo, freeAnyo);
    }

    public Boolean getFreeWb() {
        return freeWb;
    }

    public void setFreeWb(Boolean freeWb) {
        Boolean oldFreeWb = this.freeWb;
        this.freeWb = freeWb;
        changeSupport.firePropertyChange("freeWb", oldFreeWb, freeWb);
    }

    public Boolean getFreeWeit() {
        return freeWeit;
    }

    public void setFreeWeit(Boolean freeWeit) {
        Boolean oldFreeWeit = this.freeWeit;
        this.freeWeit = freeWeit;
        changeSupport.firePropertyChange("freeWeit", oldFreeWeit, freeWeit);
    }

    public Boolean getFreeSt() {
        return freeSt;
    }

    public void setFreeSt(Boolean freeSt) {
        Boolean oldFreeSt = this.freeSt;
        this.freeSt = freeSt;
        changeSupport.firePropertyChange("freeSt", oldFreeSt, freeSt);
    }

    public Boolean getFreeHlt() {
        return freeHlt;
    }

    public void setFreeHlt(Boolean freeHlt) {
        Boolean oldFreeHlt = this.freeHlt;
        this.freeHlt = freeHlt;
        changeSupport.firePropertyChange("freeHlt", oldFreeHlt, freeHlt);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        Integer oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        Integer oldDiscount = this.discount;
        this.discount = discount;
        changeSupport.firePropertyChange("discount", oldDiscount, discount);
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
        if (!(object instanceof Billccc)) {
            return false;
        }
        Billccc other = (Billccc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carcare.Billccc[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
