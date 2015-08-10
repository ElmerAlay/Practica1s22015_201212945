
package MatrizOrtogonal;

public class NodoOrtogonal {
    private int x;
    private int y;
    private String dato;
    private NodoOrtogonal nodoArriba;
    private NodoOrtogonal nodoAbajo;
    private NodoOrtogonal nodoIzquierda;
    private NodoOrtogonal nodoDerecha;
    
    public NodoOrtogonal(String dato,  int x, int y){
        this.dato=dato;
        this.x=x;
        this.y=y;
        this.nodoArriba=null;
        this.nodoAbajo=null;
        this.nodoIzquierda=null;
        this.nodoDerecha=null;
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public void setDato(String dato){
        this.dato=dato;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getDato(){
        return dato;
    }
    
    public void setNodoArriba(NodoOrtogonal nodoArriba){
        this.nodoArriba=nodoArriba;
    }
    
    public void setNodoAbajo(NodoOrtogonal nodoAbajo){
        this.nodoAbajo=nodoAbajo;
    }
    
    public void setNodoIzquierda(NodoOrtogonal nodoIzquierda){
        this.nodoIzquierda=nodoIzquierda;
    }
    
    public void setNodoDerecha(NodoOrtogonal nodoDerecha){
        this.nodoDerecha=nodoDerecha;
    }
    
    public NodoOrtogonal getNodoArriba(){
        return this.nodoArriba;
    }
    
    public NodoOrtogonal getNodoAbajo(){
        return this.nodoAbajo;
    }
    
    public NodoOrtogonal getNodoIzquierda(){
        return this.nodoIzquierda;
    }
    
    public NodoOrtogonal getNodoDerecha(){
        return this.nodoDerecha;
    }
}
