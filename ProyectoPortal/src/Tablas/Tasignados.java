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
    @NamedQuery(name = "Tasignados.findAll", query = "SELECT t FROM Tasignados t"),
    @NamedQuery(name = "Tasignados.findById", query = "SELECT t FROM Tasignados t WHERE t.id = :id"),
    @NamedQuery(name = "Tasignados.findByTSeccionCursosid", query = "SELECT t FROM Tasignados t WHERE t.tSeccionCursosid = :tSeccionCursosid"),
    @NamedQuery(name = "Tasignados.findByTUsuariosid", query = "SELECT t FROM Tasignados t WHERE t.tUsuariosid = :tUsuariosid")})
public class Tasignados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TSeccion_Cursos_id", nullable = false)
    private int tSeccionCursosid;
    @Basic(optional = false)
    @Column(name = "TUsuarios_id", nullable = false)
    private int tUsuariosid;

    public Tasignados() {
    }

    public Tasignados(Integer id) {
        this.id = id;
    }

    public Tasignados(Integer id, int tSeccionCursosid, int tUsuariosid) {
        this.id = id;
        this.tSeccionCursosid = tSeccionCursosid;
        this.tUsuariosid = tUsuariosid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTSeccionCursosid() {
        return tSeccionCursosid;
    }

    public void setTSeccionCursosid(int tSeccionCursosid) {
        this.tSeccionCursosid = tSeccionCursosid;
    }

    public int getTUsuariosid() {
        return tUsuariosid;
    }

    public void setTUsuariosid(int tUsuariosid) {
        this.tUsuariosid = tUsuariosid;
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
        if (!(object instanceof Tasignados)) {
            return false;
        }
        Tasignados other = (Tasignados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tasignados[ id=" + id + " ]";
    }
    
}
