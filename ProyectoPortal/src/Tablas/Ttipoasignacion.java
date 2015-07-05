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
@Table(name = "ttipoasignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipoasignacion.findAll", query = "SELECT t FROM Ttipoasignacion t"),
    @NamedQuery(name = "Ttipoasignacion.findById", query = "SELECT t FROM Ttipoasignacion t WHERE t.id = :id"),
    @NamedQuery(name = "Ttipoasignacion.findByFechaInicial", query = "SELECT t FROM Ttipoasignacion t WHERE t.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Ttipoasignacion.findByFechaFinal", query = "SELECT t FROM Ttipoasignacion t WHERE t.fechaFinal = :fechaFinal")})
public class Ttipoasignacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "FechaInicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Column(name = "FechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;

    public Ttipoasignacion() {
    }

    public Ttipoasignacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
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
        if (!(object instanceof Ttipoasignacion)) {
            return false;
        }
        Ttipoasignacion other = (Ttipoasignacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Ttipoasignacion[ id=" + id + " ]";
    }
    
}
