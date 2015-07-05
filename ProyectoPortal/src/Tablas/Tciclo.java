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
@Table(name = "tciclo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tciclo.findAll", query = "SELECT t FROM Tciclo t"),
    @NamedQuery(name = "Tciclo.findById", query = "SELECT t FROM Tciclo t WHERE t.id = :id"),
    @NamedQuery(name = "Tciclo.findByCiclo", query = "SELECT t FROM Tciclo t WHERE t.ciclo = :ciclo")})
public class Tciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ciclo")
    private String ciclo;

    public Tciclo() {
    }

    public Tciclo(Integer id) {
        this.id = id;
    }

    public Tciclo(Integer id, String ciclo) {
        this.id = id;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
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
        if (!(object instanceof Tciclo)) {
            return false;
        }
        Tciclo other = (Tciclo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tciclo[ id=" + id + " ]";
    }
    
}
