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
@Table(name = "tcarrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcarrera.findAll", query = "SELECT t FROM Tcarrera t"),
    @NamedQuery(name = "Tcarrera.findById", query = "SELECT t FROM Tcarrera t WHERE t.id = :id"),
    @NamedQuery(name = "Tcarrera.findByCarrera", query = "SELECT t FROM Tcarrera t WHERE t.carrera = :carrera"),
    @NamedQuery(name = "Tcarrera.findByTPersonaid", query = "SELECT t FROM Tcarrera t WHERE t.tPersonaid = :tPersonaid"),
    @NamedQuery(name = "Tcarrera.findByTFacultadid", query = "SELECT t FROM Tcarrera t WHERE t.tFacultadid = :tFacultadid")})
public class Tcarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "carrera")
    private String carrera;
    @Basic(optional = false)
    @Column(name = "TPersona_id")
    private int tPersonaid;
    @Basic(optional = false)
    @Column(name = "TFacultad_id")
    private int tFacultadid;

    public Tcarrera() {
    }

    public Tcarrera(Integer id) {
        this.id = id;
    }

    public Tcarrera(Integer id, String carrera, int tPersonaid, int tFacultadid) {
        this.id = id;
        this.carrera = carrera;
        this.tPersonaid = tPersonaid;
        this.tFacultadid = tFacultadid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getTPersonaid() {
        return tPersonaid;
    }

    public void setTPersonaid(int tPersonaid) {
        this.tPersonaid = tPersonaid;
    }

    public int getTFacultadid() {
        return tFacultadid;
    }

    public void setTFacultadid(int tFacultadid) {
        this.tFacultadid = tFacultadid;
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
        if (!(object instanceof Tcarrera)) {
            return false;
        }
        Tcarrera other = (Tcarrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tcarrera[ id=" + id + " ]";
    }
    
}
