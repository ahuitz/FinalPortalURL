/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import java.util.Date;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Saul
 */
public class ListaEntregaActiv implements Listas{
    
    public int EntregaId;
    public Double EntregaCalificacion;
    public Boolean EntregaNoRealizada;
    public Boolean EntregaRealizada;
    public int ActividadId;
    public Double ActividadPunteo;
    public String ActividadTitulo;
    public int TipoActividadId;
    public String TipoActividadDescripcion;
    public int UsuarioEstId;
    public String UsuarioEst;
    public int PersonaEstId;
    public String NombreEst;
    public String ApellidoEst;
    public int SeccionCursoId;
    public Date ActividadFechaEntrega;
    public Date ActividadFechaPublicacion;
    public Boolean ActividadFisica;
    public Boolean ActividadVirtual;

    public ListaEntregaActiv(int EntregaId, Double EntregaCalificacion, Boolean EntregaNoRealizada, Boolean EntregaRealizada, int ActividadId, Double ActividadPunteo, String ActividadTitulo, int TipoActividadId, String TipoActividadDescripcion, int UsuarioEstId, String UsuarioEst, int PersonaEstId, String NombreEst, String ApellidoEst, int SeccionCursoId, Date ActividadFechaEntrega, Date ActividadFechaPublicacion, Boolean ActividadFisica, Boolean ActividadVirtual) {
        this.EntregaId = EntregaId;
        this.EntregaCalificacion = EntregaCalificacion;
        this.EntregaNoRealizada = EntregaNoRealizada;
        this.EntregaRealizada = EntregaRealizada;
        this.ActividadId = ActividadId;
        this.ActividadPunteo = ActividadPunteo;
        this.ActividadTitulo = ActividadTitulo;
        this.TipoActividadId = TipoActividadId;
        this.TipoActividadDescripcion = TipoActividadDescripcion;
        this.UsuarioEstId = UsuarioEstId;
        this.UsuarioEst = UsuarioEst;
        this.PersonaEstId = PersonaEstId;
        this.NombreEst = NombreEst;
        this.ApellidoEst = ApellidoEst;
        this.SeccionCursoId = SeccionCursoId;
        this.ActividadFechaEntrega = ActividadFechaEntrega;
        this.ActividadFechaPublicacion = ActividadFechaPublicacion;
        this.ActividadFisica = ActividadFisica;
        this.ActividadVirtual = ActividadVirtual;
    }

    public int getEntregaId() {
        return EntregaId;
    }

    public void setEntregaId(int EntregaId) {
        this.EntregaId = EntregaId;
    }

    public Double getEntregaCalificacion() {
        return EntregaCalificacion;
    }

    public void setEntregaCalificacion(Double EntregaCalificacion) {
        this.EntregaCalificacion = EntregaCalificacion;
    }

    public Boolean getEntregaNoRealizada() {
        return EntregaNoRealizada;
    }

    public void setEntregaNoRealizada(Boolean EntregaNoRealizada) {
        this.EntregaNoRealizada = EntregaNoRealizada;
    }

    public Boolean getEntregaRealizada() {
        return EntregaRealizada;
    }

    public void setEntregaRealizada(Boolean EntregaRealizada) {
        this.EntregaRealizada = EntregaRealizada;
    }

    public int getActividadId() {
        return ActividadId;
    }

    public void setActividadId(int ActividadId) {
        this.ActividadId = ActividadId;
    }

    public Double getActividadPunteo() {
        return ActividadPunteo;
    }

    public void setActividadPunteo(Double ActividadPunteo) {
        this.ActividadPunteo = ActividadPunteo;
    }

    public String getActividadTitulo() {
        return ActividadTitulo;
    }

    public void setActividadTitulo(String ActividadTitulo) {
        this.ActividadTitulo = ActividadTitulo;
    }

    public int getTipoActividadId() {
        return TipoActividadId;
    }

    public void setTipoActividadId(int TipoActividadId) {
        this.TipoActividadId = TipoActividadId;
    }

    public String getTipoActividadDescripcion() {
        return TipoActividadDescripcion;
    }

    public void setTipoActividadDescripcion(String TipoActividadDescripcion) {
        this.TipoActividadDescripcion = TipoActividadDescripcion;
    }

    public int getUsuarioEstId() {
        return UsuarioEstId;
    }

    public void setUsuarioEstId(int UsuarioEstId) {
        this.UsuarioEstId = UsuarioEstId;
    }

    public String getUsuarioEst() {
        return UsuarioEst;
    }

    public void setUsuarioEst(String UsuarioEst) {
        this.UsuarioEst = UsuarioEst;
    }

    public int getPersonaEstId() {
        return PersonaEstId;
    }

    public void setPersonaEstId(int PersonaEstId) {
        this.PersonaEstId = PersonaEstId;
    }

    public String getNombreEst() {
        return NombreEst;
    }

    public void setNombreEst(String NombreEst) {
        this.NombreEst = NombreEst;
    }

    public String getApellidoEst() {
        return ApellidoEst;
    }

    public void setApellidoEst(String ApellidoEst) {
        this.ApellidoEst = ApellidoEst;
    }

    public int getSeccionCursoId() {
        return SeccionCursoId;
    }

    public void setSeccionCursoId(int SeccionCursoId) {
        this.SeccionCursoId = SeccionCursoId;
    }

    public Date getActividadFechaEntrega() {
        return ActividadFechaEntrega;
    }

    public void setActividadFechaEntrega(Date ActividadFechaEntrega) {
        this.ActividadFechaEntrega = ActividadFechaEntrega;
    }

    public Date getActividadFechaPublicacion() {
        return ActividadFechaPublicacion;
    }

    public void setActividadFechaPublicacion(Date ActividadFechaPublicacion) {
        this.ActividadFechaPublicacion = ActividadFechaPublicacion;
    }

    public Boolean getActividadFisica() {
        return ActividadFisica;
    }

    public void setActividadFisica(Boolean ActividadFisica) {
        this.ActividadFisica = ActividadFisica;
    }

    public Boolean getActividadVirtual() {
        return ActividadVirtual;
    }

    public void setActividadVirtual(Boolean ActividadVirtual) {
        this.ActividadVirtual = ActividadVirtual;
    }

    @Override
    public String toString() {
        return "ListaEntregaActiv{" + "EntregaId=" + EntregaId + ", EntregaCalificacion=" + EntregaCalificacion + ", EntregaNoRealizada=" + EntregaNoRealizada + ", EntregaRealizada=" + EntregaRealizada + ", ActividadId=" + ActividadId + ", ActividadPunteo=" + ActividadPunteo + ", ActividadTitulo=" + ActividadTitulo + ", TipoActividadId=" + TipoActividadId + ", TipoActividadDescripcion=" + TipoActividadDescripcion + ", UsuarioEstId=" + UsuarioEstId + ", UsuarioEst=" + UsuarioEst + ", PersonaEstId=" + PersonaEstId + ", NombreEst=" + NombreEst + ", ApellidoEst=" + ApellidoEst + ", SeccionCursoId=" + SeccionCursoId + ", ActividadFechaEntrega=" + ActividadFechaEntrega + ", ActividadFechaPublicacion=" + ActividadFechaPublicacion + ", ActividadFisica=" + ActividadFisica + ", ActividadVirtual=" + ActividadVirtual + '}';
    }

    @Override
    public List<Object> cargarDatosLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
