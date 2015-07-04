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
    @NamedQuery(name = "Tarchivos.findAll", query = "SELECT t FROM Tarchivos t"),
    @NamedQuery(name = "Tarchivos.findById", query = "SELECT t FROM Tarchivos t WHERE t.id = :id"),
    @NamedQuery(name = "Tarchivos.findByNombre", query = "SELECT t FROM Tarchivos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tarchivos.findByExtension", query = "SELECT t FROM Tarchivos t WHERE t.extension = :extension"),
    @NamedQuery(name = "Tarchivos.findByUrl", query = "SELECT t FROM Tarchivos t WHERE t.url = :url"),
    @NamedQuery(name = "Tarchivos.findByTama\u00f1o", query = "SELECT t FROM Tarchivos t WHERE t.tama\u00f1o = :tama\u00f1o"),
    @NamedQuery(name = "Tarchivos.findByFisico", query = "SELECT t FROM Tarchivos t WHERE t.fisico = :fisico"),
    @NamedQuery(name = "Tarchivos.findByVirtual", query = "SELECT t FROM Tarchivos t WHERE t.virtual = :virtual")})
public class Tarchivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String extension;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String url;
    @Basic(optional = false)
    @Column(nullable = false)
    private double tamaño;
    private Boolean fisico;
    private Boolean virtual;

    public Tarchivos() {
    }

    public Tarchivos(Integer id) {
        this.id = id;
    }

    public Tarchivos(Integer id, String nombre, String extension, String url, double tamaño) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.url = url;
        this.tamaño = tamaño;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public Boolean getFisico() {
        return fisico;
    }

    public void setFisico(Boolean fisico) {
        this.fisico = fisico;
    }

    public Boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
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
        if (!(object instanceof Tarchivos)) {
            return false;
        }
        Tarchivos other = (Tarchivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tarchivos[ id=" + id + " ]";
    }
    
}
