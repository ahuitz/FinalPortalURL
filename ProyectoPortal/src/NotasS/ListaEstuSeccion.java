/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import java.util.List;

/**
 *
 * @author Saul
 */
public class ListaEstuSeccion implements Listas{
    
    public int EstudianteSeccionId;
    public int SeccionCursoId;
    public int UsuarioEstId;
    public String UsuarioEst;
    public String NombreEst;
    public String ApellidoEst;
    public int PersonaEstId;

    public ListaEstuSeccion(int EstudianteSeccionId, int SeccionCursoId, int UsuarioEstId, String UsuarioEst, String NombreEst, String ApellidoEst, int PersonaEstId) {
        this.EstudianteSeccionId = EstudianteSeccionId;
        this.SeccionCursoId = SeccionCursoId;
        this.UsuarioEstId = UsuarioEstId;
        this.UsuarioEst = UsuarioEst;
        this.NombreEst = NombreEst;
        this.ApellidoEst = ApellidoEst;
        this.PersonaEstId = PersonaEstId;
    }

    public int getEstudianteSeccionId() {
        return EstudianteSeccionId;
    }

    public void setEstudianteSeccionId(int EstudianteSeccionId) {
        this.EstudianteSeccionId = EstudianteSeccionId;
    }

    public int getSeccionCursoId() {
        return SeccionCursoId;
    }

    public void setSeccionCursoId(int SeccionCursoId) {
        this.SeccionCursoId = SeccionCursoId;
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

    public int getPersonaEstId() {
        return PersonaEstId;
    }

    public void setPersonaEstId(int PersonaEstId) {
        this.PersonaEstId = PersonaEstId;
    }

    @Override
    public String toString() {
        return "ListaEstuSeccion{" + "EstudianteSeccionId=" + EstudianteSeccionId + ", SeccionCursoId=" + SeccionCursoId + ", UsuarioEstId=" + UsuarioEstId + ", UsuarioEst=" + UsuarioEst + ", NombreEst=" + NombreEst + ", ApellidoEst=" + ApellidoEst + ", PersonaEstId=" + PersonaEstId + '}';
    }

    @Override
    public List<Object> cargarDatosLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
