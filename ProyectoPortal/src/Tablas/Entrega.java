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
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findById", query = "SELECT e FROM Entrega e WHERE e.id = :id"),
    @NamedQuery(name = "Entrega.findByCalificacion", query = "SELECT e FROM Entrega e WHERE e.calificacion = :calificacion"),
    @NamedQuery(name = "Entrega.findByRealizada", query = "SELECT e FROM Entrega e WHERE e.realizada = :realizada"),
    @NamedQuery(name = "Entrega.findByNoRealizada", query = "SELECT e FROM Entrega e WHERE e.noRealizada = :noRealizada"),
    @NamedQuery(name = "Entrega.findByActividadid", query = "SELECT e FROM Entrega e WHERE e.actividadid = :actividadid"),
    @NamedQuery(name = "Entrega.findByUsuarioid", query = "SELECT e FROM Entrega e WHERE e.usuarioid = :usuarioid")})
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private double calificacion;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean realizada;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean noRealizada;
    @Basic(optional = false)
    @Column(name = "Actividad_id", nullable = false)
    private int actividadid;
    @Basic(optional = false)
    @Column(name = "Usuario_id", nullable = false)
    private int usuarioid;

    public Entrega() {
    }

    public Entrega(Integer id) {
        this.id = id;
    }

    public Entrega(Integer id, double calificacion, boolean realizada, boolean noRealizada, int actividadid, int usuarioid) {
        this.id = id;
        this.calificacion = calificacion;
        this.realizada = realizada;
        this.noRealizada = noRealizada;
        this.actividadid = actividadid;
        this.usuarioid = usuarioid;
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

    public boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public boolean getNoRealizada() {
        return noRealizada;
    }

    public void setNoRealizada(boolean noRealizada) {
        this.noRealizada = noRealizada;
    }

    public int getActividadid() {
        return actividadid;
    }

    public void setActividadid(int actividadid) {
        this.actividadid = actividadid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
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
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Entrega[ id=" + id + " ]";
    }
    
}
