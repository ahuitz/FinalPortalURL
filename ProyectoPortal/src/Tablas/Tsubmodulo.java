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
    @NamedQuery(name = "Tsubmodulo.findAll", query = "SELECT t FROM Tsubmodulo t"),
    @NamedQuery(name = "Tsubmodulo.findById", query = "SELECT t FROM Tsubmodulo t WHERE t.id = :id"),
    @NamedQuery(name = "Tsubmodulo.findBySubModulo", query = "SELECT t FROM Tsubmodulo t WHERE t.subModulo = :subModulo"),
    @NamedQuery(name = "Tsubmodulo.findByTModuloid", query = "SELECT t FROM Tsubmodulo t WHERE t.tModuloid = :tModuloid"),
    @NamedQuery(name = "Tsubmodulo.findByTPermisosid", query = "SELECT t FROM Tsubmodulo t WHERE t.tPermisosid = :tPermisosid")})
public class Tsubmodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String subModulo;
    @Basic(optional = false)
    @Column(name = "TModulo_id", nullable = false)
    private int tModuloid;
    @Basic(optional = false)
    @Column(name = "TPermisos_id", nullable = false)
    private int tPermisosid;

    public Tsubmodulo() {
    }

    public Tsubmodulo(Integer id) {
        this.id = id;
    }

    public Tsubmodulo(Integer id, String subModulo, int tModuloid, int tPermisosid) {
        this.id = id;
        this.subModulo = subModulo;
        this.tModuloid = tModuloid;
        this.tPermisosid = tPermisosid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubModulo() {
        return subModulo;
    }

    public void setSubModulo(String subModulo) {
        this.subModulo = subModulo;
    }

    public int getTModuloid() {
        return tModuloid;
    }

    public void setTModuloid(int tModuloid) {
        this.tModuloid = tModuloid;
    }

    public int getTPermisosid() {
        return tPermisosid;
    }

    public void setTPermisosid(int tPermisosid) {
        this.tPermisosid = tPermisosid;
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
        if (!(object instanceof Tsubmodulo)) {
            return false;
        }
        Tsubmodulo other = (Tsubmodulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tsubmodulo[ id=" + id + " ]";
    }
    
}
