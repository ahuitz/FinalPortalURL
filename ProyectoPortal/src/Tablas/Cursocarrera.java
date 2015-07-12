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
    @NamedQuery(name = "Cursocarrera.findByCursoid", query = "SELECT c FROM Cursocarrera c WHERE c.cursoid = :cursoid"),
    @NamedQuery(name = "Cursocarrera.findByCarreraid", query = "SELECT c FROM Cursocarrera c WHERE c.carreraid = :carreraid"),
    @NamedQuery(name = "Cursocarrera.findByDescripcion", query = "SELECT c FROM Cursocarrera c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cursocarrera.findById", query = "SELECT c FROM Cursocarrera c WHERE c.id = :id")})
public class Cursocarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Curso_id", nullable = false)
    private int cursoid;
    @Basic(optional = false)
    @Column(name = "Carrera_id", nullable = false)
    private int carreraid;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    public Cursocarrera() {
    }

    public Cursocarrera(Integer id) {
        this.id = id;
    }

    public Cursocarrera(Integer id, int cursoid, int carreraid, String descripcion) {
        this.id = id;
        this.cursoid = cursoid;
        this.carreraid = carreraid;
        this.descripcion = descripcion;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getCarreraid() {
        return carreraid;
    }

    public void setCarreraid(int carreraid) {
        this.carreraid = carreraid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "FormUsuario.Cursocarrera[ id=" + id + " ]";
    }
    
}
