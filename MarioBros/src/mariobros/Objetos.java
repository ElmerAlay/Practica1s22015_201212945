
package mariobros;

import javax.swing.ImageIcon;

public class Objetos {
    
    String tipo;
    String ruta;
    ImageIcon icono;
    
    public Objetos(String tipo, String ruta){
        this.tipo=tipo;
        this.icono=new ImageIcon(ruta);
    }
}
