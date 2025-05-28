
package estructura;

import modelo.Carta;


public class ListaEnlazada {
    private class nodo{
        Carta carta;
        nodo siguiente;

        public nodo(Carta carta) {
            this.carta = carta;
            this.siguiente=null;
        }
       
    }
    private nodo cabeza;
    public ListaEnlazada(){
        cabeza= null;
    }
    //Agregar carta al final de la lista
    public void add (Carta carta){
        nodo nodoN= new nodo(carta);
        if(cabeza ==null){
            cabeza = nodoN;
            
        }
        else{
            nodo curr=cabeza;
            while (curr.siguiente != null){
                curr=curr.siguiente;
            }
            curr.siguiente= nodoN;
        }
    }
    //remueve y retorna la primera carta de la lista
    public Carta removerP(){
        if(cabeza==null){
            return null;
        }
        Carta carta=cabeza.carta;
        cabeza=cabeza.siguiente;
        return carta;
        
    }
    //Verificar si la lista esta vacia
    public boolean Vvacio(){
    return cabeza==null;
    }
    public  int sumValores(){
        int suma =0;
        int aces=0;
        nodo curr = cabeza;
        while(curr!=null){
            suma+=curr.carta.getValor();
            if(curr.carta.getRango().equals("aaS")){
                aces++;
            }
            curr=curr.siguiente;
       }
        //ajustar As de 11 a 1 si pasa de 21
        while (suma>21 && aces>0){
            suma-=10;
            aces--;
            
        }
        return suma;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        nodo curr = cabeza;
        while (curr != null) {
            sb.append(curr.carta).append(", ");
            curr = curr.siguiente;
        }
        return sb.toString();
    }
}
