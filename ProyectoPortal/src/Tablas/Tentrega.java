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
@Table(name = "tentrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tentrega.findAll", query = "SELECT t FROM Tentrega t"),
    @NamedQuery(name = "Tentrega.findById", query = "SELECT t FROM Tentrega t WHERE t.id = :id"),
    @NamedQuery(name = "Tentrega.findByCalificacion", query = "SELECT t FROM Tentrega t WHERE t.calificacion = :calificacion"),
    @NamedQuery(name = "Tentrega.findByTActividadid", query = "SELECT t FROM Tentrega t WHERE t.tActividadid = :tActividadid")})
public class Tentrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Calificacion")
    private double calificacion;
    @Basic(optional = false)
    @Column(name = "TActividad_id")
    private int tActividadid;

    public Tentrega() {
    }

    public Tentrega(Integer id) {
        this.id = id;
    }

    public Tentrega(Integer id, double calificacion, int tActividadid) {
        this.id = id;
        this.calificacion = calificacion;
        this.tActividadid = tActividadid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getTActividadid() {
        return tActividadid;
    }

    public void setTActividadid(int tActividadid) {
        this.tActividadid = tActividadid;
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
        if (!(object instanceof Tentrega)) {
            return false;
        }
        Tentrega other = (Tentrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tentrega[ id=" + id + " ]";
    }
    
}
