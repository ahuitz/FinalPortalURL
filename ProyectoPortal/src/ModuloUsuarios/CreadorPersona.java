/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

/**
 *
 * @author Vader33
 */
public class CreadorPersona {
    private TipoPersona persona;

    public CreadorPersona() {
        
    }
    
    
    public void crearpersona(){
        this.persona.crear();
    }
    
    public void setPersona(TipoPersona per){
        this.persona= per;
    }
}
