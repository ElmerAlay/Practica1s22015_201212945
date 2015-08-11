
package ListaObjetos;

import javax.swing.ImageIcon;

public class Objeto {
    private String nombre;
    private String tipo;
    private ImageIcon icono;
    
    public Objeto(String nombre, String tipo, ImageIcon icono){
        this.nombre=nombre;
        this.tipo=tipo;
        this.icono=icono;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public void setIcono(ImageIcon icono){
        this.icono=icono;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public ImageIcon getIcono(){
        return icono;
    }
    
}
