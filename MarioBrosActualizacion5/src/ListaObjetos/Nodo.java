package ListaObjetos;

public class Nodo {
    
    private Nodo anteriorNodo;
    private Nodo siguienteNodo;
    private Objeto objeto;
    
    public Nodo(Objeto objeto){
        this.objeto=objeto;
    }
    
    public void setAnteriorNodo(Nodo anteriorNodo){
        this.anteriorNodo=anteriorNodo;
    }
    
    public void setSiguienteNodo(Nodo siguienteNodo){
        this.siguienteNodo=siguienteNodo;
    }
    
    public Nodo getAnteriorNodo(){
        return this.anteriorNodo;
    }
    
    public Nodo getSiguienteNodo(){
        return this.siguienteNodo;
    }
    
    public Objeto getObjeto(){
        return this.objeto;
    }
    
    public void breakAnteriorNodo(){
        this.anteriorNodo=null;
    }
    
    public void breakSiguienteNodo(){
        this.siguienteNodo=null;
    }
}
