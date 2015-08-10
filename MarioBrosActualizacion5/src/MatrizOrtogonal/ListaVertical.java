
package MatrizOrtogonal;

public class ListaVertical {
    NodoOrtogonal primerNodo;
    NodoOrtogonal ultimoNodo;
    
    public ListaVertical(){
        this.primerNodo=null;
        this.ultimoNodo=null;
    }
    
    public void Insertar(NodoOrtogonal actual){
        if(Vacio()){
            this.primerNodo=actual;
            this.ultimoNodo=actual;
        }else {
            if(actual.getY()<this.primerNodo.getY()){
                this.InsertarFrente(actual);
            }else if(actual.getY()>this.ultimoNodo.getY()){
                this.InsertarFinal(actual);
            }else {
                this.InsertarMedio(actual);
            }
        }
    }
    
    public void Eliminar(int posicion){
        if(this.primerNodo==this.ultimoNodo){
            this.primerNodo=null;
            this.ultimoNodo=null;
        }else {
            if(posicion==this.primerNodo.getY()){
                this.EliminarFrente();
            }else if(posicion==this.ultimoNodo.getY()){
                this.EliminarFinal();
            }else {
                this.EliminarMedio(posicion);
            }
        }
        
    }
    
    public void InsertarFrente(NodoOrtogonal actual){
        this.primerNodo.setNodoArriba(actual);
        actual.setNodoAbajo(this.primerNodo);
        this.primerNodo=actual;
    }
    
    public void InsertarFinal(NodoOrtogonal actual){
        this.ultimoNodo.setNodoAbajo(actual);
        actual.setNodoArriba(this.ultimoNodo);
        this.ultimoNodo=actual;
    }
    
    public void EliminarFrente(){
        this.primerNodo = this.primerNodo.getNodoAbajo();
        this.primerNodo.setNodoArriba(null);
    }
    
    public void EliminarFinal(){
        this.ultimoNodo.getNodoArriba().setNodoAbajo(null);
        this.ultimoNodo.setNodoArriba(null);
    }
    
    public void InsertarMedio(NodoOrtogonal actual){
        NodoOrtogonal temp1 = this.primerNodo;
        NodoOrtogonal temp2;
        
        while(temp1.getY()<actual.getY()){
            temp1=temp1.getNodoAbajo();
        }
        
        temp2=temp1.getNodoArriba();
        temp2.setNodoAbajo(actual);
        temp1.setNodoArriba(actual);
        
        actual.setNodoAbajo(temp1);
        actual.setNodoArriba(temp2);
    }
    
    public void EliminarMedio(int posicion){
        NodoOrtogonal temp1 = this.primerNodo;
        NodoOrtogonal temp2;
        
        while(temp1.getY()<posicion){
            temp1=temp1.getNodoAbajo();
        }
        
        temp2=temp1.getNodoArriba();
        temp2.setNodoAbajo(temp1.getNodoAbajo());
        temp1.getNodoAbajo().setNodoArriba(temp2);
        temp1.setNodoArriba(null);
        temp1.setNodoAbajo(null);
    }
    
    public NodoOrtogonal getDatoAt(int posicion){
        NodoOrtogonal temp1 = this.primerNodo;
       
        while(temp1.getY()<posicion){
            temp1=temp1.getNodoAbajo();
        }
        
        return new NodoOrtogonal(temp1.getDato(),  temp1.getX(), temp1.getY());
    }
    
    public boolean Vacio(){
        if(this.primerNodo==null){
            return true;
        }else {
            return false;
        }
    }
    
    public void Recorrer(){
        if(!Vacio()){
            NodoOrtogonal temp = this.primerNodo;
            
            while(temp!=null){
                System.out.println("Y = " + temp.getY());
                temp=temp.getNodoAbajo();
            }
        }
    }
}
