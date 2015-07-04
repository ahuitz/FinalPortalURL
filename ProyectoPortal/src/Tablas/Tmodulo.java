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
    @NamedQuery(name = "Tmodulo.findAll", query = "SELECT t FROM Tmodulo t"),
    @NamedQuery(name = "Tmodulo.findById", query = "SELECT t FROM Tmodulo t WHERE t.id = :id"),
    @NamedQuery(name = "Tmodulo.findByNombreModulo", query = "SELECT t FROM Tmodulo t WHERE t.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "Tmodulo.findByTRolUsuarioid", query = "SELECT t FROM Tmodulo t WHERE t.tRolUsuarioid = :tRolUsuarioid")})
public class Tmodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nombreModulo;
    @Basic(optional = false)
    @Column(name = "TRolUsuario_id", nullable = false)
    private int tRolUsuarioid;

    public Tmodulo() {
    }

    public Tmodulo(Integer id) {
        this.id = id;
    }

    public Tmodulo(Integer id, String nombreModulo, int tRolUsuarioid) {
        this.id = id;
        this.nombreModulo = nombreModulo;
        this.tRolUsuarioid = tRolUsuarioid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public int getTRolUsuarioid() {
        return tRolUsuarioid;
    }

    public void setTRolUsuarioid(int tRolUsuarioid) {
        this.tRolUsuarioid = tRolUsuarioid;
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
        if (!(object instanceof Tmodulo)) {
            return false;
        }
        Tmodulo other = (Tmodulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tmodulo[ id=" + id + " ]";
    }
    
}
