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
    @NamedQuery(name = "Ciclocurso.findAll", query = "SELECT c FROM Ciclocurso c"),
    @NamedQuery(name = "Ciclocurso.findById", query = "SELECT c FROM Ciclocurso c WHERE c.id = :id"),
    @NamedQuery(name = "Ciclocurso.findByAnio", query = "SELECT c FROM Ciclocurso c WHERE c.anio = :anio"),
    @NamedQuery(name = "Ciclocurso.findByCicloid", query = "SELECT c FROM Ciclocurso c WHERE c.cicloid = :cicloid"),
    @NamedQuery(name = "Ciclocurso.findByCursoid", query = "SELECT c FROM Ciclocurso c WHERE c.cursoid = :cursoid")})
public class Ciclocurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int anio;
    @Basic(optional = false)
    @Column(name = "Ciclo_id", nullable = false)
    private int cicloid;
    @Basic(optional = false)
    @Column(name = "Curso_id", nullable = false)
    private int cursoid;

    public Ciclocurso() {
    }

    public Ciclocurso(Integer id) {
        this.id = id;
    }

    public Ciclocurso(Integer id, int anio, int cicloid, int cursoid) {
        this.id = id;
        this.anio = anio;
        this.cicloid = cicloid;
        this.cursoid = cursoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCicloid() {
        return cicloid;
    }

    public void setCicloid(int cicloid) {
        this.cicloid = cicloid;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
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
        if (!(object instanceof Ciclocurso)) {
            return false;
        }
        Ciclocurso other = (Ciclocurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Ciclocurso[ id=" + id + " ]";
    }
    
}
