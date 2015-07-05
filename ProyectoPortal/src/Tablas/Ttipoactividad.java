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
 * @author Cliente
 */
@Entity
@Table(name = "ttipoactividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipoactividad.findAll", query = "SELECT t FROM Ttipoactividad t"),
    @NamedQuery(name = "Ttipoactividad.findById", query = "SELECT t FROM Ttipoactividad t WHERE t.id = :id"),
    @NamedQuery(name = "Ttipoactividad.findByTipoActividad", query = "SELECT t FROM Ttipoactividad t WHERE t.tipoActividad = :tipoActividad")})
public class Ttipoactividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TipoActividad")
    private String tipoActividad;

    public Ttipoactividad() {
    }

    public Ttipoactividad(Integer id) {
        this.id = id;
    }

    public Ttipoactividad(Integer id, String tipoActividad) {
        this.id = id;
        this.tipoActividad = tipoActividad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
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
        if (!(object instanceof Ttipoactividad)) {
            return false;
        }
        Ttipoactividad other = (Ttipoactividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Ttipoactividad[ id=" + id + " ]";
    }
    
}
