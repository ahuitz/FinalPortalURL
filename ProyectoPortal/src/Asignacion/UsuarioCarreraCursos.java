/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

/**
 *
 * @author frankzapeta1
 */
public class UsuarioCarreraCursos {

    public UsuarioCarreraCursos() {
        
    }
    
    public UsuarioCarreraCursos(int idUsuario, String Usuario, int RolUsuarioiD, int PersonaiD, int idCarreraUsuario, int UsuarioiD, int CarreraiD, int idCarrera, String carrera, int FacultadiD, int idCursoCarrera, String Descripsion, String CursoCarreraiD, int cicloCursoiD, int idCicloCurso, String anio, int cicloiD, int cursoiD) {
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.RolUsuarioiD = RolUsuarioiD;
        this.PersonaiD = PersonaiD;
        this.idCarreraUsuario = idCarreraUsuario;
        this.UsuarioiD = UsuarioiD;
        this.CarreraiD = CarreraiD;
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.FacultadiD = FacultadiD;
        this.idCursoCarrera = idCursoCarrera;
        this.Descripsion = Descripsion;
        this.CursoCarreraiD = CursoCarreraiD;
        this.cicloCursoiD = cicloCursoiD;
        this.idCicloCurso = idCicloCurso;
        this.anio = anio;
        this.cicloiD = cicloiD;
        this.cursoiD = cursoiD;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getRolUsuarioiD() {
        return RolUsuarioiD;
    }

    public void setRolUsuarioiD(int RolUsuarioiD) {
        this.RolUsuarioiD = RolUsuarioiD;
    }

    public int getPersonaiD() {
        return PersonaiD;
    }

    public void setPersonaiD(int PersonaiD) {
        this.PersonaiD = PersonaiD;
    }

    public int getIdCarreraUsuario() {
        return idCarreraUsuario;
    }

    public void setIdCarreraUsuario(int idCarreraUsuario) {
        this.idCarreraUsuario = idCarreraUsuario;
    }

    public int getUsuarioiD() {
        return UsuarioiD;
    }

    public void setUsuarioiD(int UsuarioiD) {
        this.UsuarioiD = UsuarioiD;
    }

    public int getCarreraiD() {
        return CarreraiD;
    }

    public void setCarreraiD(int CarreraiD) {
        this.CarreraiD = CarreraiD;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getFacultadiD() {
        return FacultadiD;
    }

    public void setFacultadiD(int FacultadiD) {
        this.FacultadiD = FacultadiD;
    }

    public int getIdCursoCarrera() {
        return idCursoCarrera;
    }

    public void setIdCursoCarrera(int idCursoCarrera) {
        this.idCursoCarrera = idCursoCarrera;
    }

    public String getDescripsion() {
        return Descripsion;
    }

    public void setDescripsion(String Descripsion) {
        this.Descripsion = Descripsion;
    }

    public String getCursoCarreraiD() {
        return CursoCarreraiD;
    }

    public void setCursoCarreraiD(String CursoCarreraiD) {
        this.CursoCarreraiD = CursoCarreraiD;
    }

    public int getCicloCursoiD() {
        return cicloCursoiD;
    }

    public void setCicloCursoiD(int cicloCursoiD) {
        this.cicloCursoiD = cicloCursoiD;
    }

    public int getIdCicloCurso() {
        return idCicloCurso;
    }

    public void setIdCicloCurso(int idCicloCurso) {
        this.idCicloCurso = idCicloCurso;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getCicloiD() {
        return cicloiD;
    }

    public void setCicloiD(int cicloiD) {
        this.cicloiD = cicloiD;
    }

    public int getCursoiD() {
        return cursoiD;
    }

    public void setCursoiD(int cursoiD) {
        this.cursoiD = cursoiD;
    }
    
    public int idUsuario;
    public String Usuario;
    public int RolUsuarioiD;
    public int PersonaiD;
    
    public int idCarreraUsuario;
    public int UsuarioiD;
    public int CarreraiD;
    
    public int idCarrera;
    public String carrera;
    public int FacultadiD;
    
    public int idCursoCarrera;
    public String Descripsion;
    public String CursoCarreraiD;
    public int cicloCursoiD;
    
    public int idCicloCurso;
    public String anio;
    public int cicloiD;
    public int cursoiD;

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public int idCiclo;
    public String ciclo;
    
    public int idCurso;
    public String curso;

    @Override
    public String toString() {
        return "UsuarioCarreraCursos{" + "idUsuario=" + idUsuario + ", Usuario=" + Usuario + ", RolUsuarioiD=" + RolUsuarioiD + ", PersonaiD=" + PersonaiD + ", idCarreraUsuario=" + idCarreraUsuario + ", UsuarioiD=" + UsuarioiD + ", CarreraiD=" + CarreraiD + ", idCarrera=" + idCarrera + ", carrera=" + carrera + ", FacultadiD=" + FacultadiD + ", idCursoCarrera=" + idCursoCarrera + ", Descripsion=" + Descripsion + ", CursoCarreraiD=" + CursoCarreraiD + ", cicloCursoiD=" + cicloCursoiD + ", idCicloCurso=" + idCicloCurso + ", anio=" + anio + ", cicloiD=" + cicloiD + ", cursoiD=" + cursoiD + ", idCiclo=" + idCiclo + ", ciclo=" + ciclo + ", idCurso=" + idCurso + ", curso=" + curso + '}';
    }
    
    
    
    
    
}
