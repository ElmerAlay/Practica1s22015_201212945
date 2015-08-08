
package MatrizOrtogonal;

public class ListaHorizontal {
    NodoOrtogonal primerNodo;
    NodoOrtogonal ultimoNodo;
    
    public ListaHorizontal(){
        this.primerNodo=null;
        this.ultimoNodo=null;
    }
    
    public void Insertar(NodoOrtogonal actual){
        if(Vacio()){
            this.primerNodo=actual;
            this.ultimoNodo=actual;
        }else {
            if(actual.getX()<this.primerNodo.getX()){
                this.InsertarFrente(actual);
            }else if(actual.getX()>this.ultimoNodo.getX()){
                this.InsertarFinal(actual);
            }else {
                this.InsertarMedio(actual);
            }
        }
    }
    
    public void InsertarFrente(NodoOrtogonal actual){
        this.primerNodo.setNodoIzquierda(actual);
        actual.setNodoDerecha(this.primerNodo);
        this.primerNodo=actual;
    }
    
    public void InsertarFinal(NodoOrtogonal actual){
        this.ultimoNodo.setNodoDerecha(actual);
        actual.setNodoIzquierda(this.ultimoNodo);
        this.ultimoNodo=actual;
    }
    
    public void InsertarMedio(NodoOrtogonal actual){
        NodoOrtogonal temp1 = this.primerNodo;
        NodoOrtogonal temp2;
        
        while(temp1.getX()<actual.getX()){
            temp1=temp1.getNodoDerecha();
        }
        
        temp2=temp1.getNodoIzquierda();
        temp2.setNodoDerecha(actual);
        temp1.setNodoIzquierda(actual);
        
        actual.setNodoIzquierda(temp2);
        actual.setNodoDerecha(temp1);
    }
    
    public boolean Vacio(){
        if(this.primerNodo!=null){
            return false;
        }else{
            return true;
        }
    }
    
    public void Recorrer(){
        if(!Vacio()){
            NodoOrtogonal temp = this.primerNodo;
            
            while(temp!=null){
                System.out.println("X = " + temp.getX());
                temp=temp.getNodoDerecha();
            }
        }
    }
}
