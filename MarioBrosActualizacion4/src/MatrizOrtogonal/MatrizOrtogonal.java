
package MatrizOrtogonal;

public class MatrizOrtogonal {
    Cabecera cabecera;
    Lateral lateral;
    
    public MatrizOrtogonal(){
        cabecera=new Cabecera();
        lateral=new Lateral();
    }
    
    public void insertar(String dato, int x, int y){
        NodoOrtogonal actual = new NodoOrtogonal(dato, x, y);
        
        if(cabecera.Existe(x)==false){
            cabecera.Insertar(new NodoCabecera(x));
        }
        if(lateral.Existe(y)==false){
            lateral.Insertar(new NodoLateral(y));
        }
        
        NodoCabecera cabTemp = cabecera.Busqueda(x);
        NodoLateral latTemp = lateral.Busqueda(y);
        
        cabTemp.getColumna().Insertar(actual);
        latTemp.getFila().Insertar(actual);
        
        System.out.println("Inserto " + dato + " en x = " + x + " y y = " + y);
    }
    
    public void Llenar(int x, int y){
        int z = 0;
        String dato="null ";
        
        for(int i=0;i<x;i++){
            for(int j=0; j<y; j++){
                this.insertar(dato+z, i, j);
                z++;
            }
        }
    }
}
