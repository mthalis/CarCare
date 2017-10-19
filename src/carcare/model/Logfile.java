/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dinesh
 */
@Entity
@Table(name = "logfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logfile.findAll", query = "SELECT l FROM Logfile l")})
public class Logfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PROCESSED")
    private Boolean processed;
    @Column(name = "LASDAYBAK")
    private Boolean lasdaybak;
    @Column(name = "LASDAYRMV")
    private Boolean lasdayrmv;
    @Column(name = "LASDAYSUMM")
    private Boolean lasdaysumm;
    @Column(name = "USER_LOCK")
    private Boolean userLock;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "CCCBILLNO")
    private Integer cccbillno;
    @Column(name = "CCEBILLNO")
    private Integer ccebillno;
    @Column(name = "RBILLNO")
    private Integer rbillno;
    @Column(name = "PATH")
    private String path;
    @Column(name = "BAK_FILE")
    private String bakFile;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    public Logfile() {
    }

    public Logfile(Integer id) {
        this.id = id;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getLasdaybak() {
        return lasdaybak;
    }

    public void setLasdaybak(Boolean lasdaybak) {
        this.lasdaybak = lasdaybak;
    }

    public Boolean getLasdayrmv() {
        return lasdayrmv;
    }

    public void setLasdayrmv(Boolean lasdayrmv) {
        this.lasdayrmv = lasdayrmv;
    }

    public Boolean getLasdaysumm() {
        return lasdaysumm;
    }

    public void setLasdaysumm(Boolean lasdaysumm) {
        this.lasdaysumm = lasdaysumm;
    }

    public Boolean getUserLock() {
        return userLock;
    }

    public void setUserLock(Boolean userLock) {
        this.userLock = userLock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCccbillno() {
        return cccbillno;
    }

    public void setCccbillno(Integer cccbillno) {
        this.cccbillno = cccbillno;
    }

    public Integer getCcebillno() {
        return ccebillno;
    }

    public void setCcebillno(Integer ccebillno) {
        this.ccebillno = ccebillno;
    }

    public Integer getRbillno() {
        return rbillno;
    }

    public void setRbillno(Integer rbillno) {
        this.rbillno = rbillno;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBakFile() {
        return bakFile;
    }

    public void setBakFile(String bakFile) {
        this.bakFile = bakFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Logfile)) {
            return false;
        }
        Logfile other = (Logfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carcare.model.Logfile[ id=" + id + " ]";
    }
    
}
