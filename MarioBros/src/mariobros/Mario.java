
package mariobros;

import javax.swing.ImageIcon;

public class Mario {
 
    String tipo;
    int cantidad;
    int puntos;
    int vida;
    ImageIcon icono;
    
    public Mario(){
        this.tipo = "mario";
        this.cantidad=0;
        this.puntos=0;
        this.vida=1;
        icono = new ImageIcon("C:\\Users\\Elmer\\Documents\\NetBeansProjects\\MarioBros\\src\\mario2.jpg");
    }
}
