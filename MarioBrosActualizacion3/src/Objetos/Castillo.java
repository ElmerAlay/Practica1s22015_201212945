
package Objetos;

import javax.swing.ImageIcon;

public class Castillo {
    public String tipo;
    private int cantidad;
    private ImageIcon icono;
    
    public Castillo(){
        this.tipo="Castillo";
        this.cantidad=0;
        this.icono= new ImageIcon("C:\\Users\\Elmer\\Documents\\NetBeansProjects\\MarioBros\\src\\castillo.png");
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
}
