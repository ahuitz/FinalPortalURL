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
    @NamedQuery(name = "Rolusuario.findAll", query = "SELECT r FROM Rolusuario r"),
    @NamedQuery(name = "Rolusuario.findById", query = "SELECT r FROM Rolusuario r WHERE r.id = :id"),
    @NamedQuery(name = "Rolusuario.findByRol", query = "SELECT r FROM Rolusuario r WHERE r.rol = :rol"),
    @NamedQuery(name = "Rolusuario.findByCarreraPuesto", query = "SELECT r FROM Rolusuario r WHERE r.carreraPuesto = :carreraPuesto")})
public class Rolusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String rol;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean carreraPuesto;

    public Rolusuario() {
    }

    public Rolusuario(Integer id) {
        this.id = id;
    }

    public Rolusuario(Integer id, String rol, boolean carreraPuesto) {
        this.id = id;
        this.rol = rol;
        this.carreraPuesto = carreraPuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean getCarreraPuesto() {
        return carreraPuesto;
    }

    public void setCarreraPuesto(boolean carreraPuesto) {
        this.carreraPuesto = carreraPuesto;
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
        if (!(object instanceof Rolusuario)) {
            return false;
        }
        Rolusuario other = (Rolusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Rolusuario[ id=" + id + " ]";
    }
    
}
