/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rosario
 */
@Entity
@Table(catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdetalleasignacionvip.findAll", query = "SELECT t FROM Tdetalleasignacionvip t"),
    @NamedQuery(name = "Tdetalleasignacionvip.findById", query = "SELECT t FROM Tdetalleasignacionvip t WHERE t.id = :id"),
    @NamedQuery(name = "Tdetalleasignacionvip.findByTtipoAsignacionid", query = "SELECT t FROM Tdetalleasignacionvip t WHERE t.ttipoAsignacionid = :ttipoAsignacionid"),
    @NamedQuery(name = "Tdetalleasignacionvip.findByTFacultadid", query = "SELECT t FROM Tdetalleasignacionvip t WHERE t.tFacultadid = :tFacultadid")})
public class Tdetalleasignacionvip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TtipoAsignacion_id", nullable = false)
    private int ttipoAsignacionid;
    @Basic(optional = false)
    @Column(name = "TFacultad_id", nullable = false)
    private int tFacultadid;

    public Tdetalleasignacionvip() {
    }

    public Tdetalleasignacionvip(Integer id) {
        this.id = id;
    }

    public Tdetalleasignacionvip(Integer id, int ttipoAsignacionid, int tFacultadid) {
        this.id = id;
        this.ttipoAsignacionid = ttipoAsignacionid;
        this.tFacultadid = tFacultadid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTtipoAsignacionid() {
        return ttipoAsignacionid;
    }

    public void setTtipoAsignacionid(int ttipoAsignacionid) {
        this.ttipoAsignacionid = ttipoAsignacionid;
    }

    public int getTFacultadid() {
        return tFacultadid;
    }

    public void setTFacultadid(int tFacultadid) {
        this.tFacultadid = tFacultadid;
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
        if (!(object instanceof Tdetalleasignacionvip)) {
            return false;
        }
        Tdetalleasignacionvip other = (Tdetalleasignacionvip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tdetalleasignacionvip[ id=" + id + " ]";
    }
    
}
