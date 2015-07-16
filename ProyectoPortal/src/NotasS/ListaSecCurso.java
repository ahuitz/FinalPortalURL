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
public class ListaSecCurso implements Listas{
    
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

    public ListaSecCurso(int SeccionCursoId, int CursoCarreraId, int SeccionId, int UsuarioCatId, String SeccionDescrip, int CicloCursoAnio, String Ciclo, String Curso, String Carrera, int CicloId, int CursoId, String Facultad, String UsuarioCat, String NombreCat, String ApellidoCat, int PersonaCatId) {
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
    }

    public int getSeccionCursoId() {
        return SeccionCursoId;
    }

    public void setSeccionCursoId(int SeccionCursoId) {
        this.SeccionCursoId = SeccionCursoId;
    }

    public int getCursoCarreraId() {
        return CursoCarreraId;
    }

    public void setCursoCarreraId(int CursoCarreraId) {
        this.CursoCarreraId = CursoCarreraId;
    }

    public int getSeccionId() {
        return SeccionId;
    }

    public void setSeccionId(int SeccionId) {
        this.SeccionId = SeccionId;
    }

    public int getUsuarioCatId() {
        return UsuarioCatId;
    }

    public void setUsuarioCatId(int UsuarioCatId) {
        this.UsuarioCatId = UsuarioCatId;
    }

    public String getSeccionDescrip() {
        return SeccionDescrip;
    }

    public void setSeccionDescrip(String SeccionDescrip) {
        this.SeccionDescrip = SeccionDescrip;
    }

    public int getCicloCursoAnio() {
        return CicloCursoAnio;
    }

    public void setCicloCursoAnio(int CicloCursoAnio) {
        this.CicloCursoAnio = CicloCursoAnio;
    }

    public String getCiclo() {
        return Ciclo;
    }

    public void setCiclo(String Ciclo) {
        this.Ciclo = Ciclo;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public int getCicloId() {
        return CicloId;
    }

    public void setCicloId(int CicloId) {
        this.CicloId = CicloId;
    }

    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int CursoId) {
        this.CursoId = CursoId;
    }

    public String getFacultad() {
        return Facultad;
    }

    public void setFacultad(String Facultad) {
        this.Facultad = Facultad;
    }

    public String getUsuarioCat() {
        return UsuarioCat;
    }

    public void setUsuarioCat(String UsuarioCat) {
        this.UsuarioCat = UsuarioCat;
    }

    public String getNombreCat() {
        return NombreCat;
    }

    public void setNombreCat(String NombreCat) {
        this.NombreCat = NombreCat;
    }

    public String getApellidoCat() {
        return ApellidoCat;
    }

    public void setApellidoCat(String ApellidoCat) {
        this.ApellidoCat = ApellidoCat;
    }

    public int getPersonaCatId() {
        return PersonaCatId;
    }

    public void setPersonaCatId(int PersonaCatId) {
        this.PersonaCatId = PersonaCatId;
    }

    @Override
    public String toString() {
        return "ListaSecCurso{" + "SeccionCursoId=" + SeccionCursoId + ", CursoCarreraId=" + CursoCarreraId + ", SeccionId=" + SeccionId + ", UsuarioCatId=" + UsuarioCatId + ", SeccionDescrip=" + SeccionDescrip + ", CicloCursoAnio=" + CicloCursoAnio + ", Ciclo=" + Ciclo + ", Curso=" + Curso + ", Carrera=" + Carrera + ", CicloId=" + CicloId + ", CursoId=" + CursoId + ", Facultad=" + Facultad + ", UsuarioCat=" + UsuarioCat + ", NombreCat=" + NombreCat + ", ApellidoCat=" + ApellidoCat + ", PersonaCatId=" + PersonaCatId + '}';
    }

    @Override
    public List<Object> cargarDatosLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
