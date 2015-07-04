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
@Table(name = "tseccion_cursos", catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TseccionCursos.findAll", query = "SELECT t FROM TseccionCursos t"),
    @NamedQuery(name = "TseccionCursos.findById", query = "SELECT t FROM TseccionCursos t WHERE t.id = :id"),
    @NamedQuery(name = "TseccionCursos.findByCupo", query = "SELECT t FROM TseccionCursos t WHERE t.cupo = :cupo"),
    @NamedQuery(name = "TseccionCursos.findByAula", query = "SELECT t FROM TseccionCursos t WHERE t.aula = :aula"),
    @NamedQuery(name = "TseccionCursos.findByTSeccionid", query = "SELECT t FROM TseccionCursos t WHERE t.tSeccionid = :tSeccionid"),
    @NamedQuery(name = "TseccionCursos.findByTAsignadosid", query = "SELECT t FROM TseccionCursos t WHERE t.tAsignadosid = :tAsignadosid"),
    @NamedQuery(name = "TseccionCursos.findByTCursoid", query = "SELECT t FROM TseccionCursos t WHERE t.tCursoid = :tCursoid")})
public class TseccionCursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int cupo;
    @Column(length = 45)
    private String aula;
    @Basic(optional = false)
    @Column(name = "TSeccion_id", nullable = false)
    private int tSeccionid;
    @Basic(optional = false)
    @Column(name = "TAsignados_id", nullable = false)
    private int tAsignadosid;
    @Basic(optional = false)
    @Column(name = "TCurso_id", nullable = false)
    private int tCursoid;

    public TseccionCursos() {
    }

    public TseccionCursos(Integer id) {
        this.id = id;
    }

    public TseccionCursos(Integer id, int cupo, int tSeccionid, int tAsignadosid, int tCursoid) {
        this.id = id;
        this.cupo = cupo;
        this.tSeccionid = tSeccionid;
        this.tAsignadosid = tAsignadosid;
        this.tCursoid = tCursoid;
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

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getTSeccionid() {
        return tSeccionid;
    }

    public void setTSeccionid(int tSeccionid) {
        this.tSeccionid = tSeccionid;
    }

    public int getTAsignadosid() {
        return tAsignadosid;
    }

    public void setTAsignadosid(int tAsignadosid) {
        this.tAsignadosid = tAsignadosid;
    }

    public int getTCursoid() {
        return tCursoid;
    }

    public void setTCursoid(int tCursoid) {
        this.tCursoid = tCursoid;
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
        if (!(object instanceof TseccionCursos)) {
            return false;
        }
        TseccionCursos other = (TseccionCursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.TseccionCursos[ id=" + id + " ]";
    }
    
}
