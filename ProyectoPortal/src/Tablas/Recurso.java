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
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r"),
    @NamedQuery(name = "Recurso.findById", query = "SELECT r FROM Recurso r WHERE r.id = :id"),
    @NamedQuery(name = "Recurso.findByTitulo", query = "SELECT r FROM Recurso r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "Recurso.findByDescripcion", query = "SELECT r FROM Recurso r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Recurso.findByFechaPublicacion", query = "SELECT r FROM Recurso r WHERE r.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Recurso.findByArchivoid", query = "SELECT r FROM Recurso r WHERE r.archivoid = :archivoid"),
    @NamedQuery(name = "Recurso.findBySeccionCursoid", query = "SELECT r FROM Recurso r WHERE r.seccionCursoid = :seccionCursoid")})
public class Recurso implements Serializable {
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
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @Column(name = "Archivo_id", nullable = false)
    private int archivoid;
    @Basic(optional = false)
    @Column(name = "SeccionCurso_id", nullable = false)
    private int seccionCursoid;

    public Recurso() {
    }

    public Recurso(Integer id) {
        this.id = id;
    }

    public Recurso(Integer id, String titulo, String descripcion, Date fechaPublicacion, int archivoid, int seccionCursoid) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.archivoid = archivoid;
        this.seccionCursoid = seccionCursoid;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getArchivoid() {
        return archivoid;
    }

    public void setArchivoid(int archivoid) {
        this.archivoid = archivoid;
    }

    public int getSeccionCursoid() {
        return seccionCursoid;
    }

    public void setSeccionCursoid(int seccionCursoid) {
        this.seccionCursoid = seccionCursoid;
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
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Recurso[ id=" + id + " ]";
    }
    
}
