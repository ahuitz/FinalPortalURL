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
@Table(name = "tcurso_ciclo", catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcursoCiclo.findAll", query = "SELECT t FROM TcursoCiclo t"),
    @NamedQuery(name = "TcursoCiclo.findById", query = "SELECT t FROM TcursoCiclo t WHERE t.id = :id"),
    @NamedQuery(name = "TcursoCiclo.findByTCicloid1", query = "SELECT t FROM TcursoCiclo t WHERE t.tCicloid1 = :tCicloid1"),
    @NamedQuery(name = "TcursoCiclo.findByTCursoid1", query = "SELECT t FROM TcursoCiclo t WHERE t.tCursoid1 = :tCursoid1"),
    @NamedQuery(name = "TcursoCiclo.findByA\u00f1o", query = "SELECT t FROM TcursoCiclo t WHERE t.a\u00f1o = :a\u00f1o")})
public class TcursoCiclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TCiclo_id1", nullable = false)
    private int tCicloid1;
    @Basic(optional = false)
    @Column(name = "TCurso_id1", nullable = false)
    private int tCursoid1;
    @Basic(optional = false)
    @Column(nullable = false)
    private int año;

    public TcursoCiclo() {
    }

    public TcursoCiclo(Integer id) {
        this.id = id;
    }

    public TcursoCiclo(Integer id, int tCicloid1, int tCursoid1, int año) {
        this.id = id;
        this.tCicloid1 = tCicloid1;
        this.tCursoid1 = tCursoid1;
        this.año = año;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTCicloid1() {
        return tCicloid1;
    }

    public void setTCicloid1(int tCicloid1) {
        this.tCicloid1 = tCicloid1;
    }

    public int getTCursoid1() {
        return tCursoid1;
    }

    public void setTCursoid1(int tCursoid1) {
        this.tCursoid1 = tCursoid1;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
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
        if (!(object instanceof TcursoCiclo)) {
            return false;
        }
        TcursoCiclo other = (TcursoCiclo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.TcursoCiclo[ id=" + id + " ]";
    }
    
}
