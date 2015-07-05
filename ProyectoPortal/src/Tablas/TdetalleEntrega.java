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
 * @author Cliente
 */
@Entity
@Table(name = "tdetalle_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TdetalleEntrega.findAll", query = "SELECT t FROM TdetalleEntrega t"),
    @NamedQuery(name = "TdetalleEntrega.findById", query = "SELECT t FROM TdetalleEntrega t WHERE t.id = :id"),
    @NamedQuery(name = "TdetalleEntrega.findByFechaEntrega", query = "SELECT t FROM TdetalleEntrega t WHERE t.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "TdetalleEntrega.findByTEntregaid", query = "SELECT t FROM TdetalleEntrega t WHERE t.tEntregaid = :tEntregaid"),
    @NamedQuery(name = "TdetalleEntrega.findByTArchivosid", query = "SELECT t FROM TdetalleEntrega t WHERE t.tArchivosid = :tArchivosid")})
public class TdetalleEntrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Fecha_Entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "TEntrega_id")
    private int tEntregaid;
    @Basic(optional = false)
    @Column(name = "TArchivos_id")
    private int tArchivosid;

    public TdetalleEntrega() {
    }

    public TdetalleEntrega(Integer id) {
        this.id = id;
    }

    public TdetalleEntrega(Integer id, Date fechaEntrega, int tEntregaid, int tArchivosid) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
        this.tEntregaid = tEntregaid;
        this.tArchivosid = tArchivosid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getTEntregaid() {
        return tEntregaid;
    }

    public void setTEntregaid(int tEntregaid) {
        this.tEntregaid = tEntregaid;
    }

    public int getTArchivosid() {
        return tArchivosid;
    }

    public void setTArchivosid(int tArchivosid) {
        this.tArchivosid = tArchivosid;
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
        if (!(object instanceof TdetalleEntrega)) {
            return false;
        }
        TdetalleEntrega other = (TdetalleEntrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.TdetalleEntrega[ id=" + id + " ]";
    }
    
}
