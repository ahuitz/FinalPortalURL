/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Saul
 */
public class ClaseSecCurso_EstSecc_EntAct {
    
    public List<ListaSecCurso_EstuSec> miListSecCur_EstuSecc;
    public List<ListaEntregaActiv> miListEntAct;
    public List<ListaSecCurso_EstuSec_EntAct> miListSecCurso_EstSec_EntAct;

    public void setMiListSecCur_EstuSecc(List<ListaSecCurso_EstuSec> miListSecCur_EstuSecc) {
        this.miListSecCur_EstuSecc = miListSecCur_EstuSecc;
    }

    public void setMiListEntAct(List<ListaEntregaActiv> miListEntAct) {
        this.miListEntAct = miListEntAct;
    }
    
    
    public List<ListaSecCurso_EstuSec_EntAct> cargarDatosSecCur_EstuSuc_EntAct(){
        System.out.println("");
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        miListSecCurso_EstSec_EntAct = new ArrayList<ListaSecCurso_EstuSec_EntAct>();
        if (miListSecCur_EstuSecc.size() >= miListEntAct.size()) {
//            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn2");
            Iterator<ListaSecCurso_EstuSec> iteradorLisSecCur_EstuSec = miListSecCur_EstuSecc.iterator();
            while (iteradorLisSecCur_EstuSec.hasNext()) { 
//                System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn3");
                ListaSecCurso_EstuSec ListaSecCur_EstSec = iteradorLisSecCur_EstuSec.next();
                Iterator<ListaEntregaActiv> iteradorLisEntAct = miListEntAct.iterator();
                while (iteradorLisEntAct.hasNext()) { 
//                    System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn4");
                    ListaEntregaActiv ListaEntAct = iteradorLisEntAct.next();
//                    System.out.println(ListaSecCur_EstSec );
                    
                    if ((ListaSecCur_EstSec.getSeccionCursoId() != ListaEntAct.getSeccionCursoId())) {
                        if (ListaSecCur_EstSec.getUsuarioEstId() == ListaEntAct.getUsuarioEstId()) {
//                            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn5");
                            ListaSecCurso_EstuSec_EntAct miListaSecCur_EstSec_EntAct = new ListaSecCurso_EstuSec_EntAct(ListaSecCur_EstSec.getSeccionCursoId(), ListaSecCur_EstSec.getCursoCarreraId(), ListaSecCur_EstSec.getSeccionId(), ListaSecCur_EstSec.getUsuarioCatId(), ListaSecCur_EstSec.getSeccionDescrip(), ListaSecCur_EstSec.getCicloCursoAnio(), ListaSecCur_EstSec.getCiclo(), ListaSecCur_EstSec.getCurso(), ListaSecCur_EstSec.getCarrera(), ListaSecCur_EstSec.getCicloId(), ListaSecCur_EstSec.getCursoId(), ListaSecCur_EstSec.getFacultad(), ListaSecCur_EstSec.getUsuarioCat(), ListaSecCur_EstSec.getNombreCat(), ListaSecCur_EstSec.getApellidoCat(), ListaSecCur_EstSec.getPersonaCatId(), ListaSecCur_EstSec.getEstudianteSeccionId(), ListaSecCur_EstSec.getUsuarioEstId(), ListaSecCur_EstSec.getUsuarioEst(), ListaSecCur_EstSec.getNombreEst(), ListaSecCur_EstSec.getApellidoEst(), ListaSecCur_EstSec.getPersonaEstId(), 0, Double.NaN, Boolean.FALSE, Boolean.FALSE, 0, Double.NaN, null, 0, null, null, null, Boolean.FALSE, Boolean.FALSE);
                            miListSecCurso_EstSec_EntAct.add(miListaSecCur_EstSec_EntAct);
                        }
                    }else{
                        
                        ListaSecCurso_EstuSec_EntAct miListaSecCur_EstSec_EntAct = new ListaSecCurso_EstuSec_EntAct(ListaSecCur_EstSec.getSeccionCursoId(), ListaSecCur_EstSec.getCursoCarreraId(), ListaSecCur_EstSec.getSeccionId(), ListaSecCur_EstSec.getUsuarioCatId(), ListaSecCur_EstSec.getSeccionDescrip(), ListaSecCur_EstSec.getCicloCursoAnio(), ListaSecCur_EstSec.getCiclo(), ListaSecCur_EstSec.getCurso(), ListaSecCur_EstSec.getCarrera(), ListaSecCur_EstSec.getCicloId(), ListaSecCur_EstSec.getCursoId(), ListaSecCur_EstSec.getFacultad(), ListaSecCur_EstSec.getUsuarioCat(), ListaSecCur_EstSec.getNombreCat(), ListaSecCur_EstSec.getApellidoCat(), ListaSecCur_EstSec.getPersonaCatId(), ListaSecCur_EstSec.getEstudianteSeccionId(), ListaSecCur_EstSec.getUsuarioEstId(), ListaSecCur_EstSec.getUsuarioEst(), ListaSecCur_EstSec.getNombreEst(), ListaSecCur_EstSec.getApellidoEst(), ListaSecCur_EstSec.getPersonaEstId(), ListaEntAct.getEntregaId(), ListaEntAct.getEntregaCalificacion(), ListaEntAct.getEntregaNoRealizada(), ListaEntAct.getEntregaRealizada(), ListaEntAct.getActividadId(), ListaEntAct.getActividadPunteo(), ListaEntAct.getActividadTitulo(), ListaEntAct.getTipoActividadId(), ListaEntAct.getTipoActividadDescripcion(), ListaEntAct.getActividadFechaEntrega(), ListaEntAct.getActividadFechaPublicacion(), ListaEntAct.getActividadFisica(), ListaEntAct.getActividadVirtual());
                        miListSecCurso_EstSec_EntAct.add(miListaSecCur_EstSec_EntAct);
                    }
//                    System.out.println(ListaSecCur_EstSec );
                }
            }
        } else {
            
            Iterator<ListaEntregaActiv> iteradorLisEntAct = miListEntAct.iterator();
            while (iteradorLisEntAct.hasNext()) { 
                
                ListaEntregaActiv ListaEntAct = iteradorLisEntAct.next();
                Iterator<ListaSecCurso_EstuSec> iteradorLisSecCur_EstuSec = miListSecCur_EstuSecc.iterator();
                while (iteradorLisSecCur_EstuSec.hasNext()) { 
                    
                    ListaSecCurso_EstuSec ListaSecCur_EstSec = iteradorLisSecCur_EstuSec.next();
                    
                    if ((ListaSecCur_EstSec.getSeccionCursoId() != ListaEntAct.getSeccionCursoId())) {
                        if (ListaSecCur_EstSec.getUsuarioEstId() == ListaEntAct.getUsuarioEstId()) {
//                            System.out.println("PRIMER IFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                            ListaSecCurso_EstuSec_EntAct miListaSecCur_EstSec_EntAct = new ListaSecCurso_EstuSec_EntAct(ListaSecCur_EstSec.getSeccionCursoId(), ListaSecCur_EstSec.getCursoCarreraId(), ListaSecCur_EstSec.getSeccionId(), ListaSecCur_EstSec.getUsuarioCatId(), ListaSecCur_EstSec.getSeccionDescrip(), ListaSecCur_EstSec.getCicloCursoAnio(), ListaSecCur_EstSec.getCiclo(), ListaSecCur_EstSec.getCurso(), ListaSecCur_EstSec.getCarrera(), ListaSecCur_EstSec.getCicloId(), ListaSecCur_EstSec.getCursoId(), ListaSecCur_EstSec.getFacultad(), ListaSecCur_EstSec.getUsuarioCat(), ListaSecCur_EstSec.getNombreCat(), ListaSecCur_EstSec.getApellidoCat(), ListaSecCur_EstSec.getPersonaCatId(), ListaSecCur_EstSec.getEstudianteSeccionId(), ListaSecCur_EstSec.getUsuarioEstId(), ListaSecCur_EstSec.getUsuarioEst(), ListaSecCur_EstSec.getNombreEst(), ListaSecCur_EstSec.getApellidoEst(), ListaSecCur_EstSec.getPersonaEstId(), 0, Double.NaN, Boolean.FALSE, Boolean.FALSE, 0, Double.NaN, null, 0, null, null, null, Boolean.FALSE, Boolean.FALSE);
                            miListSecCurso_EstSec_EntAct.add(miListaSecCur_EstSec_EntAct);
                            System.out.println(miListaSecCur_EstSec_EntAct);
                        }
                    }else{
//                        System.out.println("SEGUNDO IFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                        ListaSecCurso_EstuSec_EntAct miListaSecCur_EstSec_EntAct = new ListaSecCurso_EstuSec_EntAct(ListaSecCur_EstSec.getSeccionCursoId(), ListaSecCur_EstSec.getCursoCarreraId(), ListaSecCur_EstSec.getSeccionId(), ListaSecCur_EstSec.getUsuarioCatId(), ListaSecCur_EstSec.getSeccionDescrip(), ListaSecCur_EstSec.getCicloCursoAnio(), ListaSecCur_EstSec.getCiclo(), ListaSecCur_EstSec.getCurso(), ListaSecCur_EstSec.getCarrera(), ListaSecCur_EstSec.getCicloId(), ListaSecCur_EstSec.getCursoId(), ListaSecCur_EstSec.getFacultad(), ListaSecCur_EstSec.getUsuarioCat(), ListaSecCur_EstSec.getNombreCat(), ListaSecCur_EstSec.getApellidoCat(), ListaSecCur_EstSec.getPersonaCatId(), ListaSecCur_EstSec.getEstudianteSeccionId(), ListaSecCur_EstSec.getUsuarioEstId(), ListaSecCur_EstSec.getUsuarioEst(), ListaSecCur_EstSec.getNombreEst(), ListaSecCur_EstSec.getApellidoEst(), ListaSecCur_EstSec.getPersonaEstId(), ListaEntAct.getEntregaId(), ListaEntAct.getEntregaCalificacion(), ListaEntAct.getEntregaNoRealizada(), ListaEntAct.getEntregaRealizada(), ListaEntAct.getActividadId(), ListaEntAct.getActividadPunteo(), ListaEntAct.getActividadTitulo(), ListaEntAct.getTipoActividadId(), ListaEntAct.getTipoActividadDescripcion(), ListaEntAct.getActividadFechaEntrega(), ListaEntAct.getActividadFechaPublicacion(), ListaEntAct.getActividadFisica(), ListaEntAct.getActividadVirtual());
                        miListSecCurso_EstSec_EntAct.add(miListaSecCur_EstSec_EntAct);
                        System.out.println(miListaSecCur_EstSec_EntAct);
                    }
                }
                
            }
        }
        return miListSecCurso_EstSec_EntAct;
    } 
    
}
