
package MatrizOrtogonal;

public class NodoLateral {
    private NodoLateral anteriorNodo;
    private NodoLateral siguienteNodo;
    private ListaHorizontal fila;
    private int y;
    
    public NodoLateral(int y){
        this.y=y;
        this.anteriorNodo=null;
        this.siguienteNodo=null;
        this.fila = new ListaHorizontal();
    }
    
    public void setAnteriorNodo(NodoLateral anteriorNodo){
        this.anteriorNodo=anteriorNodo;
    }
    
    public void setSiguienteNodo(NodoLateral siguienteNodo){
        this.siguienteNodo=siguienteNodo;
    }
    
    public NodoLateral getAnteriorNodo(){
        return this.anteriorNodo;
    }
    
    public NodoLateral getSiguienteNodo(){
        return this.siguienteNodo;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setFila(ListaHorizontal fila){
        this.fila=fila;
    }
    
    public ListaHorizontal getFila(){
        return this.fila;
    }
}
