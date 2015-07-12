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
    @NamedQuery(name = "Clasehorario.findAll", query = "SELECT c FROM Clasehorario c"),
    @NamedQuery(name = "Clasehorario.findByClaseid", query = "SELECT c FROM Clasehorario c WHERE c.claseid = :claseid"),
    @NamedQuery(name = "Clasehorario.findByHorarioid", query = "SELECT c FROM Clasehorario c WHERE c.horarioid = :horarioid"),
    @NamedQuery(name = "Clasehorario.findById", query = "SELECT c FROM Clasehorario c WHERE c.id = :id")})
public class Clasehorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Clase_id", nullable = false)
    private int claseid;
    @Basic(optional = false)
    @Column(name = "Horario_id", nullable = false)
    private int horarioid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    public Clasehorario() {
    }

    public Clasehorario(Integer id) {
        this.id = id;
    }

    public Clasehorario(Integer id, int claseid, int horarioid) {
        this.id = id;
        this.claseid = claseid;
        this.horarioid = horarioid;
    }

    public int getClaseid() {
        return claseid;
    }

    public void setClaseid(int claseid) {
        this.claseid = claseid;
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
        if (!(object instanceof Clasehorario)) {
            return false;
        }
        Clasehorario other = (Clasehorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormUsuario.Clasehorario[ id=" + id + " ]";
    }
    
}
