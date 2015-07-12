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
@Table(name = "curso_has_ciclo", catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoHasCiclo.findAll", query = "SELECT c FROM CursoHasCiclo c"),
    @NamedQuery(name = "CursoHasCiclo.findByCursoid", query = "SELECT c FROM CursoHasCiclo c WHERE c.cursoid = :cursoid"),
    @NamedQuery(name = "CursoHasCiclo.findByCicloid", query = "SELECT c FROM CursoHasCiclo c WHERE c.cicloid = :cicloid"),
    @NamedQuery(name = "CursoHasCiclo.findById", query = "SELECT c FROM CursoHasCiclo c WHERE c.id = :id"),
    @NamedQuery(name = "CursoHasCiclo.findByRemedial", query = "SELECT c FROM CursoHasCiclo c WHERE c.remedial = :remedial"),
    @NamedQuery(name = "CursoHasCiclo.findByNormal", query = "SELECT c FROM CursoHasCiclo c WHERE c.normal = :normal")})
public class CursoHasCiclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Curso_id", nullable = false)
    private int cursoid;
    @Basic(optional = false)
    @Column(name = "Ciclo_id", nullable = false)
    private int cicloid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean remedial;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean normal;

    public CursoHasCiclo() {
    }

    public CursoHasCiclo(Integer id) {
        this.id = id;
    }

    public CursoHasCiclo(Integer id, int cursoid, int cicloid, boolean remedial, boolean normal) {
        this.id = id;
        this.cursoid = cursoid;
        this.cicloid = cicloid;
        this.remedial = remedial;
        this.normal = normal;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getCicloid() {
        return cicloid;
    }

    public void setCicloid(int cicloid) {
        this.cicloid = cicloid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getRemedial() {
        return remedial;
    }

    public void setRemedial(boolean remedial) {
        this.remedial = remedial;
    }

    public boolean getNormal() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
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
        if (!(object instanceof CursoHasCiclo)) {
            return false;
        }
        CursoHasCiclo other = (CursoHasCiclo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormUsuario.CursoHasCiclo[ id=" + id + " ]";
    }
    
}
