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
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findById", query = "SELECT a FROM Asignacion a WHERE a.id = :id"),
    @NamedQuery(name = "Asignacion.findBySeccionCursoid", query = "SELECT a FROM Asignacion a WHERE a.seccionCursoid = :seccionCursoid"),
    @NamedQuery(name = "Asignacion.findByEstudianteSeccionid", query = "SELECT a FROM Asignacion a WHERE a.estudianteSeccionid = :estudianteSeccionid"),
    @NamedQuery(name = "Asignacion.findByDescripcion", query = "SELECT a FROM Asignacion a WHERE a.descripcion = :descripcion")})
public class Asignacion implements Serializable {
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
    @Column(name = "EstudianteSeccion_id", nullable = false)
    private int estudianteSeccionid;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descripcion;

    public Asignacion() {
    }

    public Asignacion(Integer id) {
        this.id = id;
    }

    public Asignacion(Integer id, int seccionCursoid, int estudianteSeccionid, String descripcion) {
        this.id = id;
        this.seccionCursoid = seccionCursoid;
        this.estudianteSeccionid = estudianteSeccionid;
        this.descripcion = descripcion;
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

    public int getEstudianteSeccionid() {
        return estudianteSeccionid;
    }

    public void setEstudianteSeccionid(int estudianteSeccionid) {
        this.estudianteSeccionid = estudianteSeccionid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Asignacion[ id=" + id + " ]";
    }
    
}
