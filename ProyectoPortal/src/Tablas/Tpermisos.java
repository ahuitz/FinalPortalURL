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
    @NamedQuery(name = "Tpermisos.findAll", query = "SELECT t FROM Tpermisos t"),
    @NamedQuery(name = "Tpermisos.findById", query = "SELECT t FROM Tpermisos t WHERE t.id = :id"),
    @NamedQuery(name = "Tpermisos.findByEliminar", query = "SELECT t FROM Tpermisos t WHERE t.eliminar = :eliminar"),
    @NamedQuery(name = "Tpermisos.findByModificar", query = "SELECT t FROM Tpermisos t WHERE t.modificar = :modificar"),
    @NamedQuery(name = "Tpermisos.findByBuscar", query = "SELECT t FROM Tpermisos t WHERE t.buscar = :buscar"),
    @NamedQuery(name = "Tpermisos.findByCrear", query = "SELECT t FROM Tpermisos t WHERE t.crear = :crear"),
    @NamedQuery(name = "Tpermisos.findByExtraer", query = "SELECT t FROM Tpermisos t WHERE t.extraer = :extraer")})
public class Tpermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean eliminar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean modificar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean buscar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean crear;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean extraer;

    public Tpermisos() {
    }

    public Tpermisos(Integer id) {
        this.id = id;
    }

    public Tpermisos(Integer id, boolean eliminar, boolean modificar, boolean buscar, boolean crear, boolean extraer) {
        this.id = id;
        this.eliminar = eliminar;
        this.modificar = modificar;
        this.buscar = buscar;
        this.crear = crear;
        this.extraer = extraer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean getModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean getBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    public boolean getCrear() {
        return crear;
    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean getExtraer() {
        return extraer;
    }

    public void setExtraer(boolean extraer) {
        this.extraer = extraer;
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
        if (!(object instanceof Tpermisos)) {
            return false;
        }
        Tpermisos other = (Tpermisos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tpermisos[ id=" + id + " ]";
    }
    
}
