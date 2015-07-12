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
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findById", query = "SELECT s FROM Seccion s WHERE s.id = :id"),
    @NamedQuery(name = "Seccion.findByCursoid", query = "SELECT s FROM Seccion s WHERE s.cursoid = :cursoid"),
    @NamedQuery(name = "Seccion.findBySeccion", query = "SELECT s FROM Seccion s WHERE s.seccion = :seccion")})
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Curso_id", nullable = false)
    private int cursoid;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String seccion;

    public Seccion() {
    }

    public Seccion(Integer id) {
        this.id = id;
    }

    public Seccion(Integer id, int cursoid, String seccion) {
        this.id = id;
        this.cursoid = cursoid;
        this.seccion = seccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
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
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormUsuario.Seccion[ id=" + id + " ]";
    }
    
}
