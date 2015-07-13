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
    @NamedQuery(name = "Estudianteseccion.findAll", query = "SELECT e FROM Estudianteseccion e"),
    @NamedQuery(name = "Estudianteseccion.findById", query = "SELECT e FROM Estudianteseccion e WHERE e.id = :id"),
    @NamedQuery(name = "Estudianteseccion.findBySeccionCursoid", query = "SELECT e FROM Estudianteseccion e WHERE e.seccionCursoid = :seccionCursoid"),
    @NamedQuery(name = "Estudianteseccion.findByUsuarioid", query = "SELECT e FROM Estudianteseccion e WHERE e.usuarioid = :usuarioid")})
public class Estudianteseccion implements Serializable {
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

    public Estudianteseccion() {
    }

    public Estudianteseccion(Integer id) {
        this.id = id;
    }

    public Estudianteseccion(Integer id, int seccionCursoid, int usuarioid) {
        this.id = id;
        this.seccionCursoid = seccionCursoid;
        this.usuarioid = usuarioid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudianteseccion)) {
            return false;
        }
        Estudianteseccion other = (Estudianteseccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Estudianteseccion[ id=" + id + " ]";
    }
    
}
