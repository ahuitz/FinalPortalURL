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
    @NamedQuery(name = "Seccioncurso.findAll", query = "SELECT s FROM Seccioncurso s"),
    @NamedQuery(name = "Seccioncurso.findById", query = "SELECT s FROM Seccioncurso s WHERE s.id = :id"),
    @NamedQuery(name = "Seccioncurso.findByCupo", query = "SELECT s FROM Seccioncurso s WHERE s.cupo = :cupo"),
    @NamedQuery(name = "Seccioncurso.findByDisponibles", query = "SELECT s FROM Seccioncurso s WHERE s.disponibles = :disponibles"),
    @NamedQuery(name = "Seccioncurso.findBySeccionid", query = "SELECT s FROM Seccioncurso s WHERE s.seccionid = :seccionid"),
    @NamedQuery(name = "Seccioncurso.findByCursoCarreraid", query = "SELECT s FROM Seccioncurso s WHERE s.cursoCarreraid = :cursoCarreraid"),
    @NamedQuery(name = "Seccioncurso.findByUsuarioCatedraticoid", query = "SELECT s FROM Seccioncurso s WHERE s.usuarioCatedraticoid = :usuarioCatedraticoid")})
public class Seccioncurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int cupo;
    @Basic(optional = false)
    @Column(nullable = false)
    private int disponibles;
    @Basic(optional = false)
    @Column(name = "Seccion_id", nullable = false)
    private int seccionid;
    @Basic(optional = false)
    @Column(name = "CursoCarrera_id", nullable = false)
    private int cursoCarreraid;
    @Basic(optional = false)
    @Column(name = "UsuarioCatedratico_id", nullable = false)
    private int usuarioCatedraticoid;

    public Seccioncurso() {
    }

    public Seccioncurso(Integer id) {
        this.id = id;
    }

    public Seccioncurso(Integer id, int cupo, int disponibles, int seccionid, int cursoCarreraid, int usuarioCatedraticoid) {
        this.id = id;
        this.cupo = cupo;
        this.disponibles = disponibles;
        this.seccionid = seccionid;
        this.cursoCarreraid = cursoCarreraid;
        this.usuarioCatedraticoid = usuarioCatedraticoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getSeccionid() {
        return seccionid;
    }

    public void setSeccionid(int seccionid) {
        this.seccionid = seccionid;
    }

    public int getCursoCarreraid() {
        return cursoCarreraid;
    }

    public void setCursoCarreraid(int cursoCarreraid) {
        this.cursoCarreraid = cursoCarreraid;
    }

    public int getUsuarioCatedraticoid() {
        return usuarioCatedraticoid;
    }

    public void setUsuarioCatedraticoid(int usuarioCatedraticoid) {
        this.usuarioCatedraticoid = usuarioCatedraticoid;
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
        if (!(object instanceof Seccioncurso)) {
            return false;
        }
        Seccioncurso other = (Seccioncurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Seccioncurso[ id=" + id + " ]";
    }
    
}
