
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
    
    public void EliminarMedio(int posicion){
        if(posicion<this.length){
            if(posicion==1){
                this.primerNodo=this.primerNodo.getSiguienteNodo();
                if(this.primerNodo!=null){
                    this.primerNodo.breakAnteriorNodo();
                }
            }else{
                Nodo recorrer = this.primerNodo;
                for(int i=1;i<=posicion-2;i++){
                    recorrer = recorrer.getSiguienteNodo();
                    
                    Nodo proximo = recorrer.getSiguienteNodo();
                    proximo = proximo.getSiguienteNodo();
                    recorrer.setSiguienteNodo(proximo);
                    
                    if(proximo!=null){
                        proximo.setAnteriorNodo(recorrer);
                    }
                }
            }
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
