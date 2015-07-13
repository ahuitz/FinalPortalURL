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
@Table(name = "modulo_has_rolusuario", catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModuloHasRolusuario.findAll", query = "SELECT m FROM ModuloHasRolusuario m"),
    @NamedQuery(name = "ModuloHasRolusuario.findById", query = "SELECT m FROM ModuloHasRolusuario m WHERE m.id = :id"),
    @NamedQuery(name = "ModuloHasRolusuario.findByRolUsuarioid", query = "SELECT m FROM ModuloHasRolusuario m WHERE m.rolUsuarioid = :rolUsuarioid"),
    @NamedQuery(name = "ModuloHasRolusuario.findByModuloid", query = "SELECT m FROM ModuloHasRolusuario m WHERE m.moduloid = :moduloid")})
public class ModuloHasRolusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "RolUsuario_id", nullable = false)
    private int rolUsuarioid;
    @Basic(optional = false)
    @Column(name = "Modulo_id", nullable = false)
    private int moduloid;

    public ModuloHasRolusuario() {
    }

    public ModuloHasRolusuario(Integer id) {
        this.id = id;
    }

    public ModuloHasRolusuario(Integer id, int rolUsuarioid, int moduloid) {
        this.id = id;
        this.rolUsuarioid = rolUsuarioid;
        this.moduloid = moduloid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRolUsuarioid() {
        return rolUsuarioid;
    }

    public void setRolUsuarioid(int rolUsuarioid) {
        this.rolUsuarioid = rolUsuarioid;
    }

    public int getModuloid() {
        return moduloid;
    }

    public void setModuloid(int moduloid) {
        this.moduloid = moduloid;
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
        if (!(object instanceof ModuloHasRolusuario)) {
            return false;
        }
        ModuloHasRolusuario other = (ModuloHasRolusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.ModuloHasRolusuario[ id=" + id + " ]";
    }
    
}
