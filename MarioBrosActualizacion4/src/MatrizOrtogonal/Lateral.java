
package MatrizOrtogonal;

public class Lateral {
    NodoLateral primerNodo;
    NodoLateral ultimoNodo;
    
    public Lateral(){
        this.primerNodo=null;
        this.ultimoNodo=null;
    }
    
    public void Insertar(NodoLateral actual){
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
    
    public void InsertarFrente(NodoLateral actual){
        this.primerNodo.setAnteriorNodo(actual);
        actual.setSiguienteNodo(this.primerNodo);
        this.primerNodo=actual;
    }
    
    public void InsertarFinal(NodoLateral actual){
        this.ultimoNodo.setSiguienteNodo(actual);
        actual.setAnteriorNodo(this.ultimoNodo);
        this.ultimoNodo=actual;
    }
    
    public void InsertarMedio(NodoLateral actual){
        NodoLateral temp1 = this.primerNodo;
        NodoLateral temp2;
        
        while(temp1.getY()<actual.getY()){
            temp1=temp1.getSiguienteNodo();
        }
        
        temp2=temp1.getAnteriorNodo();
        temp2.setSiguienteNodo(actual);
        temp1.setAnteriorNodo(actual);
        
        actual.setSiguienteNodo(temp1);
        actual.setAnteriorNodo(temp2);
    }
    
    public boolean Vacio(){
        if(this.primerNodo!=null){
            return false;
        }else {
            return true;
        }
    }
    
    public void Recorrer(){
        if(!Vacio()){
            NodoLateral temp = this.primerNodo;
            
            while(temp!=null){
                System.out.println("Y = " + temp.getY());
                temp=temp.getSiguienteNodo();
            }
        }
    }
    
    public boolean Existe(int y){
        if(Vacio()){
            System.out.println("Lista Vacía");
            return false;
        }else {
            NodoLateral temp = this.primerNodo;
            
            while(temp!=null){
                if(temp.getY()==y){
                    System.out.println("Existe");
                    return true;
                }else if(temp.getSiguienteNodo()==null){
                    System.out.println("No se encontro");
                    return false;
                }
                temp = temp.getSiguienteNodo();
            }
        }
        return false;
    }
    
    public NodoLateral Busqueda(int y){
        if(Existe(y)){
            NodoLateral temp = this.primerNodo;
            
            while(temp.getY()!=y){
                temp = temp.getSiguienteNodo();
            }
            System.out.println("Retornando");
            return temp;
        }else{
            System.out.println("No existe");
            return(new NodoLateral(-1));
        }
    }
}
