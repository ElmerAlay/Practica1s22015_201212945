
package Objetos;

import javax.swing.ImageIcon;

public class Mario {
 
    public String tipo;
    private int cantidad;
    private int puntos;
    private int vida;
    private ImageIcon icono;
    
    public Mario(){
        this.tipo = "mario";
        this.cantidad=0;
        this.puntos=0;
        this.vida=1;
        icono = new ImageIcon("C:\\Users\\Elmer\\Documents\\NetBeansProjects\\MarioBros\\src\\mario2.jpg");
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    
    public ImageIcon getIcono(){
        return this.icono;
    }
    
    public void setIcono(ImageIcon icono){
        this.icono=icono;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public void setVida(int vida){
        this.vida=vida;
    }
}
