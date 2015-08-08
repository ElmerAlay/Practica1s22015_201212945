
package MatrizOrtogonal;

public class principal {
    public static void main(String args[]){
        NodoCabecera ncab = new NodoCabecera(0);
        Cabecera cab = new Cabecera();
        cab.Insertar(ncab);
        cab.Insertar(new NodoCabecera(5));
        cab.Insertar(new NodoCabecera(2));
        cab.Existe(0);
        cab.Recorrer();
        
        NodoLateral nlat = new NodoLateral(0);
        Lateral lat = new Lateral();
        lat.Insertar(nlat);
        lat.Insertar(new NodoLateral(5));
        lat.Insertar(new NodoLateral(2));
        //lat.Existe(3);
        lat.Recorrer();
        lat.Busqueda(5);
        
        NodoOrtogonal nver = new NodoOrtogonal("Primer dato", 0, 0);
        ListaVertical ver = new ListaVertical();
        ver.Insertar(nver);
        ver.Insertar(new NodoOrtogonal("Segundo dato", 2, 2));
        ver.Insertar(new NodoOrtogonal("Quinto dato", 5, 5));
        ver.Recorrer();
        
        ListaHorizontal hor = new ListaHorizontal();
        hor.Insertar(nver);
        hor.Insertar(new NodoOrtogonal("Quinto dato", 5,5));
        hor.Insertar(new NodoOrtogonal("Segundo dato", 2,2));
        hor.Recorrer();
        
        MatrizOrtogonal matriz = new MatrizOrtogonal();
      
        matriz.Llenar(3, 3);
        //String dato1=matriz.l.Busqueda(0).fila.primero.abajo.derecha.dato;
        String dato=matriz.lateral.Busqueda(2).getFila().primerNodo.getNodoAbajo().getNodoDerecha().getDato();
      
        System.out.println(dato);
        
    }
}
