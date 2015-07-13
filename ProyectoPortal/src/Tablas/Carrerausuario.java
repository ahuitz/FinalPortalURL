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
    @NamedQuery(name = "Carrerausuario.findAll", query = "SELECT c FROM Carrerausuario c"),
    @NamedQuery(name = "Carrerausuario.findById", query = "SELECT c FROM Carrerausuario c WHERE c.id = :id"),
    @NamedQuery(name = "Carrerausuario.findByUsuarioid", query = "SELECT c FROM Carrerausuario c WHERE c.usuarioid = :usuarioid"),
    @NamedQuery(name = "Carrerausuario.findByCarreraid", query = "SELECT c FROM Carrerausuario c WHERE c.carreraid = :carreraid")})
public class Carrerausuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Usuario_id", nullable = false)
    private int usuarioid;
    @Basic(optional = false)
    @Column(name = "Carrera_id", nullable = false)
    private int carreraid;

    public Carrerausuario() {
    }

    public Carrerausuario(Integer id) {
        this.id = id;
    }

    public Carrerausuario(Integer id, int usuarioid, int carreraid) {
        this.id = id;
        this.usuarioid = usuarioid;
        this.carreraid = carreraid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getCarreraid() {
        return carreraid;
    }

    public void setCarreraid(int carreraid) {
        this.carreraid = carreraid;
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
        if (!(object instanceof Carrerausuario)) {
            return false;
        }
        Carrerausuario other = (Carrerausuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Carrerausuario[ id=" + id + " ]";
    }
    
}
