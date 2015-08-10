
package MatrizOrtogonal;

public class NodoCabecera {
    private NodoCabecera siguienteNodo;
    private NodoCabecera anteriorNodo;
    private ListaVertical columna;
    private int x;
    
    public NodoCabecera(int x){
        this.x = x;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
        this.columna = new ListaVertical();
    }
    
    public void setSiguienteNodo(NodoCabecera siguienteNodo){
        this.siguienteNodo=siguienteNodo;
    }
    
    public void setAnteriorNodo(NodoCabecera anteriorNodo){
        this.anteriorNodo=anteriorNodo;
    }
    
    public NodoCabecera getSiguienteNodo(){
        return this.siguienteNodo;
    }
    
    public NodoCabecera getAnteriorNodo(){
        return this.anteriorNodo;
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setColumna(ListaVertical columna){
        this.columna=columna;
    }
    
    public ListaVertical getColumna(){
        return this.columna;
    }
}
