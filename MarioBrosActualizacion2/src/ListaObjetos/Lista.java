
package ListaObjetos;

public class Lista {
    
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private Nodo actualNodo;
    private int length;
    
    public Lista(){
        this.length=0;
    }
    
    public void Agregar(Objeto objetoAgregar){
        Nodo adicionarNodo =  new Nodo(objetoAgregar);
        
        if(this.primerNodo==null){
            this.primerNodo=adicionarNodo;
            this.ultimoNodo=this.primerNodo;
            this.actualNodo=this.primerNodo;
        }else{
            this.ultimoNodo.setSiguienteNodo(adicionarNodo);
            adicionarNodo.setAnteriorNodo(this.ultimoNodo);
            this.ultimoNodo=adicionarNodo;
        }
        
        this.length++;
    }
    
    public void Eliminar(){
        if(this.primerNodo==null){
            return;
        }else if(this.length==1){
            this.primerNodo=null;
        }else{
            Nodo anteriorActualNodo;
            
            anteriorActualNodo = this.ultimoNodo.getAnteriorNodo();
            anteriorActualNodo.breakSiguienteNodo();
            
            this.ultimoNodo.breakAnteriorNodo();
            this.ultimoNodo=anteriorActualNodo;
        }
        
        this.length--;
    }
    
    public Objeto getSiguienteObjeto(){
        if(this.actualNodo==null){
            return null;
        }else {
            if(this.actualNodo!=null){
                Objeto temporal;
                
                temporal=this.actualNodo.getObjeto();
                this.actualNodo=this.actualNodo.getSiguienteNodo();
                
                return temporal;
            }else {
                return null;
            }
        }
    }
    
    public void setSiguienteObjeto(){
        this.actualNodo=this.primerNodo;
    }
    
    public int Length(){
        return this.length;
    }
}
