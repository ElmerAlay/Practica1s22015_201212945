
package Objetos;

import javax.swing.ImageIcon;

public class Enemigo {
    
    String tipo;
    String ruta;
    ImageIcon icono;
    
    public Enemigo(String tipo, String ruta){
        this.tipo=tipo;
        this.icono= new ImageIcon(ruta);
    }
}
