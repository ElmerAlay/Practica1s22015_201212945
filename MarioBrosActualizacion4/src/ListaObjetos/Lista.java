
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
    
    public void EliminarPrimero(){
        if(this.primerNodo==null){
            return;
        }else if(this.length==1){
            this.primerNodo=null;
            this.ultimoNodo=null;
        }else{
            Nodo siguienteActualNodo;
            
            siguienteActualNodo = this.primerNodo.getSiguienteNodo();
            siguienteActualNodo.breakAnteriorNodo();
            
            this.primerNodo.breakSiguienteNodo();
            this.primerNodo = siguienteActualNodo;
        }
        this.length--;
    }
    
    public void EliminarMedio(int posicion){
        if(this.primerNodo==null){
            return;
        }else if(posicion>this.length){
            return;
        }else if(posicion==0){
            this.primerNodo=null;
            this.ultimoNodo=null;
        }else {
            Nodo actual = this.primerNodo;
            int contador = 0;
            
            while(contador<posicion){
                actual = actual.getSiguienteNodo();
                contador++;
            }
            actual.getSiguienteNodo().setAnteriorNodo(actual.getAnteriorNodo());
            actual.getAnteriorNodo().setSiguienteNodo(actual.getSiguienteNodo());
            actual.setAnteriorNodo(null);
            actual.setSiguienteNodo(null);
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
    
    public Objeto getObjetoAt(int posicion){
        if(this.primerNodo==null){
            return null;
        }else if(posicion>=this.length){
            return null;
        }else{
            Nodo nodoRequerido = this.primerNodo;
            int contador=0;
            
            while(contador<posicion){
                nodoRequerido = nodoRequerido.getSiguienteNodo();
                contador++;
            }
            
            return nodoRequerido.getObjeto();
        }
    }
    
    public int Length(){
        return this.length;
    }
}
