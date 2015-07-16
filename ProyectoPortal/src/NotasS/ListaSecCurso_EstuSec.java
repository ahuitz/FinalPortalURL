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
public class ListaSecCurso_EstuSec implements Listas{
    
    public int SeccionCursoId;
    public int CursoCarreraId;
    public int SeccionId;
    public int UsuarioCatId;
    public String SeccionDescrip;
    public int CicloCursoAnio;
    public String Ciclo;
    public String Curso;
    public String Carrera;
    public int CicloId;
    public int CursoId;
    public String Facultad;
    public String UsuarioCat;
    public String NombreCat;
    public String ApellidoCat;
    public int PersonaCatId;
    public int EstudianteSeccionId;
    public int UsuarioEstId;
    public String UsuarioEst;
    public String NombreEst;
    public String ApellidoEst;
    public int PersonaEstId;

    public ListaSecCurso_EstuSec(int SeccionCursoId, int CursoCarreraId, int SeccionId, int UsuarioCatId, String SeccionDescrip, int CicloCursoAnio, String Ciclo, String Curso, String Carrera, int CicloId, int CursoId, String Facultad, String UsuarioCat, String NombreCat, String ApellidoCat, int PersonaCatId, int EstudianteSeccionId, int UsuarioEstId, String UsuarioEst, String NombreEst, String ApellidoEst, int PersonaEstId) {
        this.SeccionCursoId = SeccionCursoId;
        this.CursoCarreraId = CursoCarreraId;
        this.SeccionId = SeccionId;
        this.UsuarioCatId = UsuarioCatId;
        this.SeccionDescrip = SeccionDescrip;
        this.CicloCursoAnio = CicloCursoAnio;
        this.Ciclo = Ciclo;
        this.Curso = Curso;
        this.Carrera = Carrera;
        this.CicloId = CicloId;
        this.CursoId = CursoId;
        this.Facultad = Facultad;
        this.UsuarioCat = UsuarioCat;
        this.NombreCat = NombreCat;
        this.ApellidoCat = ApellidoCat;
        this.PersonaCatId = PersonaCatId;
        this.EstudianteSeccionId = EstudianteSeccionId;
        this.UsuarioEstId = UsuarioEstId;
        this.UsuarioEst = UsuarioEst;
        this.NombreEst = NombreEst;
        this.ApellidoEst = ApellidoEst;
        this.PersonaEstId = PersonaEstId;
    }

    public int getSeccionCursoId() {
        return SeccionCursoId;
    }

    public int getCursoCarreraId() {
        return CursoCarreraId;
    }

    public int getSeccionId() {
        return SeccionId;
    }

    public int getUsuarioCatId() {
        return UsuarioCatId;
    }

    public String getSeccionDescrip() {
        return SeccionDescrip;
    }

    public int getCicloCursoAnio() {
        return CicloCursoAnio;
    }

    public String getCiclo() {
        return Ciclo;
    }

    public String getCurso() {
        return Curso;
    }

    public String getCarrera() {
        return Carrera;
    }

    public int getCicloId() {
        return CicloId;
    }

    public int getCursoId() {
        return CursoId;
    }

    public String getFacultad() {
        return Facultad;
    }

    public String getUsuarioCat() {
        return UsuarioCat;
    }

    public String getNombreCat() {
        return NombreCat;
    }

    public String getApellidoCat() {
        return ApellidoCat;
    }

    public int getPersonaCatId() {
        return PersonaCatId;
    }

    public int getEstudianteSeccionId() {
        return EstudianteSeccionId;
    }

    public int getUsuarioEstId() {
        return UsuarioEstId;
    }

    public String getUsuarioEst() {
        return UsuarioEst;
    }

    public String getNombreEst() {
        return NombreEst;
    }

    public String getApellidoEst() {
        return ApellidoEst;
    }

    public int getPersonaEstId() {
        return PersonaEstId;
    }

    
    
    @Override
    public String toString() {
        return "ListaSecCurso_EstuSec{" + "SeccionCursoId=" + SeccionCursoId + ", CursoCarreraId=" + CursoCarreraId + ", SeccionId=" + SeccionId + ", UsuarioCatId=" + UsuarioCatId + ", SeccionDescrip=" + SeccionDescrip + ", CicloCursoAnio=" + CicloCursoAnio + ", Ciclo=" + Ciclo + ", Curso=" + Curso + ", Carrera=" + Carrera + ", CicloId=" + CicloId + ", CursoId=" + CursoId + ", Facultad=" + Facultad + ", UsuarioCat=" + UsuarioCat + ", NombreCat=" + NombreCat + ", ApellidoCat=" + ApellidoCat + ", PersonaCatId=" + PersonaCatId + ", EstudianteSeccionId=" + EstudianteSeccionId + ", UsuarioEstId=" + UsuarioEstId + ", UsuarioEst=" + UsuarioEst + ", NombreEst=" + NombreEst + ", ApellidoEst=" + ApellidoEst + ", PersonaEstId=" + PersonaEstId + '}';
    }
    
    
    
    

    @Override
    public List<Object> cargarDatosLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
