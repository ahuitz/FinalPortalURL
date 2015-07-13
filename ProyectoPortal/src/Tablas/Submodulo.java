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
    @NamedQuery(name = "Submodulo.findAll", query = "SELECT s FROM Submodulo s"),
    @NamedQuery(name = "Submodulo.findById", query = "SELECT s FROM Submodulo s WHERE s.id = :id"),
    @NamedQuery(name = "Submodulo.findBySubModulo", query = "SELECT s FROM Submodulo s WHERE s.subModulo = :subModulo"),
    @NamedQuery(name = "Submodulo.findByModuloid", query = "SELECT s FROM Submodulo s WHERE s.moduloid = :moduloid"),
    @NamedQuery(name = "Submodulo.findByPermisoid", query = "SELECT s FROM Submodulo s WHERE s.permisoid = :permisoid")})
public class Submodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String subModulo;
    @Basic(optional = false)
    @Column(name = "Modulo_id", nullable = false)
    private int moduloid;
    @Basic(optional = false)
    @Column(name = "Permiso_id", nullable = false)
    private int permisoid;

    public Submodulo() {
    }

    public Submodulo(Integer id) {
        this.id = id;
    }

    public Submodulo(Integer id, String subModulo, int moduloid, int permisoid) {
        this.id = id;
        this.subModulo = subModulo;
        this.moduloid = moduloid;
        this.permisoid = permisoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubModulo() {
        return subModulo;
    }

    public void setSubModulo(String subModulo) {
        this.subModulo = subModulo;
    }

    public int getModuloid() {
        return moduloid;
    }

    public void setModuloid(int moduloid) {
        this.moduloid = moduloid;
    }

    public int getPermisoid() {
        return permisoid;
    }

    public void setPermisoid(int permisoid) {
        this.permisoid = permisoid;
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
        if (!(object instanceof Submodulo)) {
            return false;
        }
        Submodulo other = (Submodulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Submodulo[ id=" + id + " ]";
    }
    
}
