
package MatrizOrtogonal;

import javax.swing.JOptionPane;

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
    
    public void InsertarFrente(NodoLateral actual){
        this.primerNodo.setAnteriorNodo(actual);
        actual.setSiguienteNodo(this.primerNodo);
        this.primerNodo=actual;
    }
    
    public void EliminarFrente(){
        this.primerNodo = this.primerNodo.getSiguienteNodo();
        this.primerNodo.setAnteriorNodo(null);
    }
    
    public void InsertarFinal(NodoLateral actual){
        this.ultimoNodo.setSiguienteNodo(actual);
        actual.setAnteriorNodo(this.ultimoNodo);
        this.ultimoNodo=actual;
    }
    
    public void EliminarFinal(){
        this.ultimoNodo = this.ultimoNodo.getAnteriorNodo();
        this.ultimoNodo.setSiguienteNodo(null);
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
    
    public void EliminarMedio(int posicion){
        if(Existe(posicion)){
            NodoLateral temp1 = this.primerNodo;
            NodoLateral temp2;
        
            while(temp1.getY()<posicion){
                temp1 = temp1.getSiguienteNodo();
            }
        
            temp2 = temp1.getAnteriorNodo();
            temp2.setSiguienteNodo(temp1.getSiguienteNodo());
            temp1.getSiguienteNodo().setAnteriorNodo(temp2);
        
            temp1.setAnteriorNodo(null);
            temp1.setSiguienteNodo(null); 
        }else {
            JOptionPane.showMessageDialog(null, "No existe Posicion");
        }
       
    }
    
    public NodoLateral getPosicionAt(int posicion){
        if(Existe(posicion)){
            NodoLateral temp1 = this.primerNodo;
       
            while(temp1.getY()<posicion){
                temp1=temp1.getSiguienteNodo();
            }
        
            return new NodoLateral(temp1.getY());
        }else {
            return null;
        }
        
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
