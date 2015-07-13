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
    @NamedQuery(name = "Tipoasignacion.findAll", query = "SELECT t FROM Tipoasignacion t"),
    @NamedQuery(name = "Tipoasignacion.findById", query = "SELECT t FROM Tipoasignacion t WHERE t.id = :id"),
    @NamedQuery(name = "Tipoasignacion.findByFechaInicial", query = "SELECT t FROM Tipoasignacion t WHERE t.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Tipoasignacion.findByFechaFinal", query = "SELECT t FROM Tipoasignacion t WHERE t.fechaFinal = :fechaFinal")})
public class Tipoasignacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;

    public Tipoasignacion() {
    }

    public Tipoasignacion(Integer id) {
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
        if (!(object instanceof Tipoasignacion)) {
            return false;
        }
        Tipoasignacion other = (Tipoasignacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tipoasignacion[ id=" + id + " ]";
    }
    
}
