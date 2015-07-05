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
@Table(name = "tpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpersona.findAll", query = "SELECT t FROM Tpersona t"),
    @NamedQuery(name = "Tpersona.findById", query = "SELECT t FROM Tpersona t WHERE t.id = :id"),
    @NamedQuery(name = "Tpersona.findByCarne", query = "SELECT t FROM Tpersona t WHERE t.carne = :carne"),
    @NamedQuery(name = "Tpersona.findByNombre", query = "SELECT t FROM Tpersona t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tpersona.findByApellido", query = "SELECT t FROM Tpersona t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "Tpersona.findByDireccion", query = "SELECT t FROM Tpersona t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "Tpersona.findByTelefono", query = "SELECT t FROM Tpersona t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tpersona.findByCelular", query = "SELECT t FROM Tpersona t WHERE t.celular = :celular"),
    @NamedQuery(name = "Tpersona.findByDpi", query = "SELECT t FROM Tpersona t WHERE t.dpi = :dpi"),
    @NamedQuery(name = "Tpersona.findByFechaNac", query = "SELECT t FROM Tpersona t WHERE t.fechaNac = :fechaNac"),
    @NamedQuery(name = "Tpersona.findByGenero", query = "SELECT t FROM Tpersona t WHERE t.genero = :genero"),
    @NamedQuery(name = "Tpersona.findByEstado", query = "SELECT t FROM Tpersona t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tpersona.findByTipoSangreid", query = "SELECT t FROM Tpersona t WHERE t.tipoSangreid = :tipoSangreid")})
public class Tpersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "carne")
    private String carne;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "celular")
    private String celular;
    @Column(name = "DPI")
    private String dpi;
    @Basic(optional = false)
    @Column(name = "FechaNac")
    private String fechaNac;
    @Basic(optional = false)
    @Column(name = "genero")
    private boolean genero;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "TipoSangre_id")
    private int tipoSangreid;

    public Tpersona() {
    }

    public Tpersona(Integer id) {
        this.id = id;
    }

    public Tpersona(Integer id, String carne, String nombre, String apellido, String direccion, String fechaNac, boolean genero, boolean estado, int tipoSangreid) {
        this.id = id;
        this.carne = carne;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.estado = estado;
        this.tipoSangreid = tipoSangreid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTipoSangreid() {
        return tipoSangreid;
    }

    public void setTipoSangreid(int tipoSangreid) {
        this.tipoSangreid = tipoSangreid;
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
        if (!(object instanceof Tpersona)) {
            return false;
        }
        Tpersona other = (Tpersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tpersona[ id=" + id + " ]";
    }
    
}
