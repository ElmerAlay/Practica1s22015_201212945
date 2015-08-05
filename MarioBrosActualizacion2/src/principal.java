import ListaObjetos.*;
import javax.swing.ImageIcon;

public class principal {
    
    public static void main (String args[]){
        ImageIcon icono;
        Lista lista = new Lista();
        lista.Agregar(new Objeto("Nombre", "Tipo", icono = new ImageIcon()));
        lista.Agregar(new Objeto("Nombre", "Tipo", icono = new ImageIcon()));
        System.out.println(lista.Length());
    }
    
}
