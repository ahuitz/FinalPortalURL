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
    @NamedQuery(name = "Trecurso.findAll", query = "SELECT t FROM Trecurso t"),
    @NamedQuery(name = "Trecurso.findById", query = "SELECT t FROM Trecurso t WHERE t.id = :id"),
    @NamedQuery(name = "Trecurso.findByTitulo", query = "SELECT t FROM Trecurso t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Trecurso.findByDescripcion", query = "SELECT t FROM Trecurso t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Trecurso.findByFechaPublicacion", query = "SELECT t FROM Trecurso t WHERE t.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Trecurso.findByTSeccionCursosid", query = "SELECT t FROM Trecurso t WHERE t.tSeccionCursosid = :tSeccionCursosid"),
    @NamedQuery(name = "Trecurso.findByTArchivosid", query = "SELECT t FROM Trecurso t WHERE t.tArchivosid = :tArchivosid")})
public class Trecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String titulo;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Fecha_Publicacion", nullable = false, length = 45)
    private String fechaPublicacion;
    @Basic(optional = false)
    @Column(name = "TSeccion_Cursos_id", nullable = false)
    private int tSeccionCursosid;
    @Basic(optional = false)
    @Column(name = "TArchivos_id", nullable = false)
    private int tArchivosid;

    public Trecurso() {
    }

    public Trecurso(Integer id) {
        this.id = id;
    }

    public Trecurso(Integer id, String titulo, String descripcion, String fechaPublicacion, int tSeccionCursosid, int tArchivosid) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.tSeccionCursosid = tSeccionCursosid;
        this.tArchivosid = tArchivosid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getTSeccionCursosid() {
        return tSeccionCursosid;
    }

    public void setTSeccionCursosid(int tSeccionCursosid) {
        this.tSeccionCursosid = tSeccionCursosid;
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
        if (!(object instanceof Trecurso)) {
            return false;
        }
        Trecurso other = (Trecurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Trecurso[ id=" + id + " ]";
    }
    
}
