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
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByTitulo", query = "SELECT a FROM Actividad a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividad.findByFechaEntrega", query = "SELECT a FROM Actividad a WHERE a.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Actividad.findByFechaPublicacion", query = "SELECT a FROM Actividad a WHERE a.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Actividad.findByPunteo", query = "SELECT a FROM Actividad a WHERE a.punteo = :punteo"),
    @NamedQuery(name = "Actividad.findByTiempoextra", query = "SELECT a FROM Actividad a WHERE a.tiempoextra = :tiempoextra"),
    @NamedQuery(name = "Actividad.findByFisica", query = "SELECT a FROM Actividad a WHERE a.fisica = :fisica"),
    @NamedQuery(name = "Actividad.findByVirtual", query = "SELECT a FROM Actividad a WHERE a.virtual = :virtual"),
    @NamedQuery(name = "Actividad.findBySeccionCursoid", query = "SELECT a FROM Actividad a WHERE a.seccionCursoid = :seccionCursoid"),
    @NamedQuery(name = "Actividad.findByTipoActividadid", query = "SELECT a FROM Actividad a WHERE a.tipoActividadid = :tipoActividadid")})
public class Actividad implements Serializable {
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
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @Column(nullable = false)
    private double punteo;
    @Basic(optional = false)
    @Column(name = "Tiempo_extra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoextra;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean fisica;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean virtual;
    @Basic(optional = false)
    @Column(name = "SeccionCurso_id", nullable = false)
    private int seccionCursoid;
    @Basic(optional = false)
    @Column(name = "TipoActividad_id", nullable = false)
    private int tipoActividadid;

    public Actividad() {
    }

    public Actividad(Integer id) {
        this.id = id;
    }

    public Actividad(Integer id, String titulo, String descripcion, Date fechaEntrega, Date fechaPublicacion, double punteo, Date tiempoextra, boolean fisica, boolean virtual, int seccionCursoid, int tipoActividadid) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.fechaPublicacion = fechaPublicacion;
        this.punteo = punteo;
        this.tiempoextra = tiempoextra;
        this.fisica = fisica;
        this.virtual = virtual;
        this.seccionCursoid = seccionCursoid;
        this.tipoActividadid = tipoActividadid;
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

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getPunteo() {
        return punteo;
    }

    public void setPunteo(double punteo) {
        this.punteo = punteo;
    }

    public Date getTiempoextra() {
        return tiempoextra;
    }

    public void setTiempoextra(Date tiempoextra) {
        this.tiempoextra = tiempoextra;
    }

    public boolean getFisica() {
        return fisica;
    }

    public void setFisica(boolean fisica) {
        this.fisica = fisica;
    }

    public boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public int getSeccionCursoid() {
        return seccionCursoid;
    }

    public void setSeccionCursoid(int seccionCursoid) {
        this.seccionCursoid = seccionCursoid;
    }

    public int getTipoActividadid() {
        return tipoActividadid;
    }

    public void setTipoActividadid(int tipoActividadid) {
        this.tipoActividadid = tipoActividadid;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Actividad[ id=" + id + " ]";
    }
    
}
