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
 * @author Cliente
 */
@Entity
@Table(name = "tusuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusuarios.findAll", query = "SELECT t FROM Tusuarios t"),
    @NamedQuery(name = "Tusuarios.findById", query = "SELECT t FROM Tusuarios t WHERE t.id = :id"),
    @NamedQuery(name = "Tusuarios.findByUsuario", query = "SELECT t FROM Tusuarios t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tusuarios.findByTPersonaid", query = "SELECT t FROM Tusuarios t WHERE t.tPersonaid = :tPersonaid")})
public class Tusuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "TPersona_id")
    private int tPersonaid;

    public Tusuarios() {
    }

    public Tusuarios(Integer id) {
        this.id = id;
    }

    public Tusuarios(Integer id, String usuario, int tPersonaid) {
        this.id = id;
        this.usuario = usuario;
        this.tPersonaid = tPersonaid;
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

    public int getTPersonaid() {
        return tPersonaid;
    }

    public void setTPersonaid(int tPersonaid) {
        this.tPersonaid = tPersonaid;
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
        if (!(object instanceof Tusuarios)) {
            return false;
        }
        Tusuarios other = (Tusuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tusuarios[ id=" + id + " ]";
    }
    
}
