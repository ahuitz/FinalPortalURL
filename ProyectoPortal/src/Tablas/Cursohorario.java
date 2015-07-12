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
    @NamedQuery(name = "Cursohorario.findAll", query = "SELECT c FROM Cursohorario c"),
    @NamedQuery(name = "Cursohorario.findByCursoid", query = "SELECT c FROM Cursohorario c WHERE c.cursoid = :cursoid"),
    @NamedQuery(name = "Cursohorario.findByHorarioid", query = "SELECT c FROM Cursohorario c WHERE c.horarioid = :horarioid"),
    @NamedQuery(name = "Cursohorario.findById", query = "SELECT c FROM Cursohorario c WHERE c.id = :id")})
public class Cursohorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Curso_id", nullable = false)
    private int cursoid;
    @Basic(optional = false)
    @Column(name = "Horario_id", nullable = false)
    private int horarioid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    public Cursohorario() {
    }

    public Cursohorario(Integer id) {
        this.id = id;
    }

    public Cursohorario(Integer id, int cursoid, int horarioid) {
        this.id = id;
        this.cursoid = cursoid;
        this.horarioid = horarioid;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getHorarioid() {
        return horarioid;
    }

    public void setHorarioid(int horarioid) {
        this.horarioid = horarioid;
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
        if (!(object instanceof Cursohorario)) {
            return false;
        }
        Cursohorario other = (Cursohorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormUsuario.Cursohorario[ id=" + id + " ]";
    }
    
}
