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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByRolUsuarioid", query = "SELECT u FROM Usuario u WHERE u.rolUsuarioid = :rolUsuarioid"),
    @NamedQuery(name = "Usuario.findByPersonaid", query = "SELECT u FROM Usuario u WHERE u.personaid = :personaid")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 12)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "RolUsuario_id", nullable = false)
    private int rolUsuarioid;
    @Basic(optional = false)
    @Column(name = "Persona_id", nullable = false)
    private int personaid;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String usuario, int rolUsuarioid, int personaid) {
        this.id = id;
        this.usuario = usuario;
        this.rolUsuarioid = rolUsuarioid;
        this.personaid = personaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getRolUsuarioid() {
        return rolUsuarioid;
    }

    public void setRolUsuarioid(int rolUsuarioid) {
        this.rolUsuarioid = rolUsuarioid;
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Usuario[ id=" + id + " ]";
    }
    
}
