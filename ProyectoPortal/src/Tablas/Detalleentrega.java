/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rosario
 */
@Entity
@Table(catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleentrega.findAll", query = "SELECT d FROM Detalleentrega d"),
    @NamedQuery(name = "Detalleentrega.findById", query = "SELECT d FROM Detalleentrega d WHERE d.id = :id"),
    @NamedQuery(name = "Detalleentrega.findByFechaModificacion", query = "SELECT d FROM Detalleentrega d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Detalleentrega.findByArchivoid", query = "SELECT d FROM Detalleentrega d WHERE d.archivoid = :archivoid"),
    @NamedQuery(name = "Detalleentrega.findByEntregaid", query = "SELECT d FROM Detalleentrega d WHERE d.entregaid = :entregaid")})
public class Detalleentrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "Archivo_id", nullable = false)
    private int archivoid;
    @Basic(optional = false)
    @Column(name = "Entrega_id", nullable = false)
    private int entregaid;

    public Detalleentrega() {
    }

    public Detalleentrega(Integer id) {
        this.id = id;
    }

    public Detalleentrega(Integer id, Date fechaModificacion, int archivoid, int entregaid) {
        this.id = id;
        this.fechaModificacion = fechaModificacion;
        this.archivoid = archivoid;
        this.entregaid = entregaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getArchivoid() {
        return archivoid;
    }

    public void setArchivoid(int archivoid) {
        this.archivoid = archivoid;
    }

    public int getEntregaid() {
        return entregaid;
    }

    public void setEntregaid(int entregaid) {
        this.entregaid = entregaid;
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
        if (!(object instanceof Detalleentrega)) {
            return false;
        }
        Detalleentrega other = (Detalleentrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Detalleentrega[ id=" + id + " ]";
    }
    
}
