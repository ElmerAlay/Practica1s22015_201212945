
package MatrizOrtogonal;

import javax.swing.JOptionPane;

public class Cabecera {
    NodoCabecera primerNodo;
    NodoCabecera ultimoNodo;
    
    public Cabecera(){
        this.primerNodo=null;
        this.ultimoNodo=null;
    }
    
    public void Insertar(NodoCabecera actual){
        if(Vacio()){
            this.primerNodo=actual;
            this.ultimoNodo=actual;
        }else{
            if(actual.getX()<this.primerNodo.getX()){
                this.InsertarFrente(actual);
            }else if(actual.getX()>this.ultimoNodo.getX()){
                this.InsertarFinal(actual);
            }else{
                this.InsertarMedio(actual);
            }
        }
    }
    
    public void Eliminar(int posicion){
        if(this.primerNodo==this.ultimoNodo){
            this.primerNodo=null;
            this.ultimoNodo=null;
        }else {
            if(posicion==this.primerNodo.getX()){
                this.EliminarFrente();
            }else if(posicion==this.ultimoNodo.getX()){
                this.EliminarFinal();
            }else {
                this.EliminarMedio(posicion);
            }
        }
    }
    
    public void InsertarFrente(NodoCabecera actual){
        this.primerNodo.setAnteriorNodo(actual);
        actual.setSiguienteNodo(this.primerNodo);
        this.primerNodo=actual;
    }
    
    public void EliminarFrente(){
        this.primerNodo = this.primerNodo.getSiguienteNodo();
        this.primerNodo.setAnteriorNodo(null);
    }
    
    public void InsertarFinal(NodoCabecera actual){
        this.ultimoNodo.setSiguienteNodo(actual);
        actual.setAnteriorNodo(this.ultimoNodo);
        this.ultimoNodo=actual;
    }
    
    public void EliminarFinal(){
        this.ultimoNodo = this.ultimoNodo.getAnteriorNodo();
        this.ultimoNodo.setSiguienteNodo(null);
    }
    
    public void InsertarMedio(NodoCabecera actual){
        NodoCabecera temp1=this.primerNodo;
        NodoCabecera temp2;
        
        while(temp1.getX()<actual.getX()){
            temp1 = temp1.getSiguienteNodo();
        }
        
        temp2=temp1.getAnteriorNodo();
        temp2.setSiguienteNodo(actual);
        temp1.setAnteriorNodo(actual);
        
        actual.setSiguienteNodo(temp1);
        actual.setAnteriorNodo(temp2);
    }
    
    public void EliminarMedio(int posicion){
        if(Existe(posicion)){
            NodoCabecera temp1 = this.primerNodo;
            NodoCabecera temp2;
        
            while(temp1.getX()<posicion){
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
    
    public NodoCabecera getPosicionAt(int posicion){
        if(Existe(posicion)){
            NodoCabecera temp1 = this.primerNodo;
       
            while(temp1.getX()<posicion){
                temp1=temp1.getSiguienteNodo();
            }
        
            return new NodoCabecera(temp1.getX());
        }else {
            return null;
        }
        
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
            NodoCabecera temp = this.primerNodo;
            
            while(temp!=null){
                System.out.println("X = " + temp.getX());
                temp=temp.getSiguienteNodo();
            }
        }
    }
    
    public boolean Existe(int x){
        if(Vacio()){
            System.out.println("Lista Vacía");
            return false;
        }else{
            NodoCabecera temp = this.primerNodo;
            
            while(temp!=null){
                if(temp.getX()==x){
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
    
    public NodoCabecera Busqueda(int x){
        if(Existe(x)){
            NodoCabecera temp;
            temp=this.primerNodo;
            
            while(temp.getX()!=x){
                temp=temp.getSiguienteNodo();
            }
            
            System.out.println("Retornando");
            return temp;
        }else{
            System.out.println("No existe");
            return(new NodoCabecera(-1));
        }
    }
}
