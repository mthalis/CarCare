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
@Table(name = "custdata", catalog = "carcare", schema = "")
@NamedQueries({
    @NamedQuery(name = "Custdata.findAll", query = "SELECT c FROM Custdata c")
    , @NamedQuery(name = "Custdata.findByVno", query = "SELECT c FROM Custdata c WHERE c.vno = :vno")
    , @NamedQuery(name = "Custdata.findByName", query = "SELECT c FROM Custdata c WHERE c.name = :name")
    , @NamedQuery(name = "Custdata.findByAddress", query = "SELECT c FROM Custdata c WHERE c.address = :address")
    , @NamedQuery(name = "Custdata.findByCity", query = "SELECT c FROM Custdata c WHERE c.city = :city")
    , @NamedQuery(name = "Custdata.findByJdate", query = "SELECT c FROM Custdata c WHERE c.jdate = :jdate")
    , @NamedQuery(name = "Custdata.findByLdate", query = "SELECT c FROM Custdata c WHERE c.ldate = :ldate")
    , @NamedQuery(name = "Custdata.findByFmilage", query = "SELECT c FROM Custdata c WHERE c.fmilage = :fmilage")
    , @NamedQuery(name = "Custdata.findByLmilage", query = "SELECT c FROM Custdata c WHERE c.lmilage = :lmilage")
    , @NamedQuery(name = "Custdata.findByPhone", query = "SELECT c FROM Custdata c WHERE c.phone = :phone")
    , @NamedQuery(name = "Custdata.findByCredit", query = "SELECT c FROM Custdata c WHERE c.credit = :credit")
    , @NamedQuery(name = "Custdata.findByDeDate", query = "SELECT c FROM Custdata c WHERE c.deDate = :deDate")
    , @NamedQuery(name = "Custdata.findById", query = "SELECT c FROM Custdata c WHERE c.id = :id")})
public class Custdata implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "VNO")
    private String vno;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "JDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdate;
    @Basic(optional = false)
    @Column(name = "LDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ldate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FMILAGE")
    private Double fmilage;
    @Column(name = "LMILAGE")
    private Double lmilage;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "CREDIT")
    private Double credit;
    @Basic(optional = false)
    @Column(name = "DE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Custdata() {
    }

    public Custdata(Integer id) {
        this.id = id;
    }

    public Custdata(Integer id, Date jdate, Date ldate, Date deDate) {
        this.id = id;
        this.jdate = jdate;
        this.ldate = ldate;
        this.deDate = deDate;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        String oldVno = this.vno;
        this.vno = vno;
        changeSupport.firePropertyChange("vno", oldVno, vno);
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public Date getJdate() {
        return jdate;
    }

    public void setJdate(Date jdate) {
        Date oldJdate = this.jdate;
        this.jdate = jdate;
        changeSupport.firePropertyChange("jdate", oldJdate, jdate);
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        Date oldLdate = this.ldate;
        this.ldate = ldate;
        changeSupport.firePropertyChange("ldate", oldLdate, ldate);
    }

    public Double getFmilage() {
        return fmilage;
    }

    public void setFmilage(Double fmilage) {
        Double oldFmilage = this.fmilage;
        this.fmilage = fmilage;
        changeSupport.firePropertyChange("fmilage", oldFmilage, fmilage);
    }

    public Double getLmilage() {
        return lmilage;
    }

    public void setLmilage(Double lmilage) {
        Double oldLmilage = this.lmilage;
        this.lmilage = lmilage;
        changeSupport.firePropertyChange("lmilage", oldLmilage, lmilage);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        Double oldCredit = this.credit;
        this.credit = credit;
        changeSupport.firePropertyChange("credit", oldCredit, credit);
    }

    public Date getDeDate() {
        return deDate;
    }

    public void setDeDate(Date deDate) {
        Date oldDeDate = this.deDate;
        this.deDate = deDate;
        changeSupport.firePropertyChange("deDate", oldDeDate, deDate);
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
        if (!(object instanceof Custdata)) {
            return false;
        }
        Custdata other = (Custdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carcare.Custdata[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
