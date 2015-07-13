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
    @NamedQuery(name = "Cursocarrera.findAll", query = "SELECT c FROM Cursocarrera c"),
    @NamedQuery(name = "Cursocarrera.findById", query = "SELECT c FROM Cursocarrera c WHERE c.id = :id"),
    @NamedQuery(name = "Cursocarrera.findByDescripcion", query = "SELECT c FROM Cursocarrera c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cursocarrera.findByCarreraid", query = "SELECT c FROM Cursocarrera c WHERE c.carreraid = :carreraid"),
    @NamedQuery(name = "Cursocarrera.findByCicloCursoid", query = "SELECT c FROM Cursocarrera c WHERE c.cicloCursoid = :cicloCursoid")})
public class Cursocarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Carrera_id", nullable = false)
    private int carreraid;
    @Basic(optional = false)
    @Column(name = "CicloCurso_id", nullable = false)
    private int cicloCursoid;

    public Cursocarrera() {
    }

    public Cursocarrera(Integer id) {
        this.id = id;
    }

    public Cursocarrera(Integer id, String descripcion, int carreraid, int cicloCursoid) {
        this.id = id;
        this.descripcion = descripcion;
        this.carreraid = carreraid;
        this.cicloCursoid = cicloCursoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCarreraid() {
        return carreraid;
    }

    public void setCarreraid(int carreraid) {
        this.carreraid = carreraid;
    }

    public int getCicloCursoid() {
        return cicloCursoid;
    }

    public void setCicloCursoid(int cicloCursoid) {
        this.cicloCursoid = cicloCursoid;
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
        if (!(object instanceof Cursocarrera)) {
            return false;
        }
        Cursocarrera other = (Cursocarrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Cursocarrera[ id=" + id + " ]";
    }
    
}
