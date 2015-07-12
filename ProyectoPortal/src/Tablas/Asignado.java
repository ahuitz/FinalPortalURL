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
    @NamedQuery(name = "Asignado.findAll", query = "SELECT a FROM Asignado a"),
    @NamedQuery(name = "Asignado.findById", query = "SELECT a FROM Asignado a WHERE a.id = :id"),
    @NamedQuery(name = "Asignado.findBySeccionCursoid", query = "SELECT a FROM Asignado a WHERE a.seccionCursoid = :seccionCursoid"),
    @NamedQuery(name = "Asignado.findByUsuarioid", query = "SELECT a FROM Asignado a WHERE a.usuarioid = :usuarioid"),
    @NamedQuery(name = "Asignado.findByFechaAsignacion", query = "SELECT a FROM Asignado a WHERE a.fechaAsignacion = :fechaAsignacion")})
public class Asignado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "SeccionCurso_id", nullable = false)
    private int seccionCursoid;
    @Basic(optional = false)
    @Column(name = "Usuario_id", nullable = false)
    private int usuarioid;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;

    public Asignado() {
    }

    public Asignado(Integer id) {
        this.id = id;
    }

    public Asignado(Integer id, int seccionCursoid, int usuarioid, Date fechaAsignacion) {
        this.id = id;
        this.seccionCursoid = seccionCursoid;
        this.usuarioid = usuarioid;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSeccionCursoid() {
        return seccionCursoid;
    }

    public void setSeccionCursoid(int seccionCursoid) {
        this.seccionCursoid = seccionCursoid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
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
        if (!(object instanceof Asignado)) {
            return false;
        }
        Asignado other = (Asignado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormUsuario.Asignado[ id=" + id + " ]";
    }
    
}
