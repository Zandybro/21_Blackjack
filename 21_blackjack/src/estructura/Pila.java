
package estructura;

import modelo.Carta;

public class Pila {
    private class Nodo {
        Carta carta;
        Nodo siguiente;

        public Nodo(Carta carta) {
            this.carta = carta;
            this.siguiente = null;
        }
    }
    private Nodo top;
    public Pila(){
        top=null;
    }
    //agrega carta al tope de la pila
    public void push(Carta carta){
        Nodo nodoN=new Nodo(carta);
        nodoN.siguiente=top;
        top=nodoN;
    }
    public Carta pop(){
        if (top==null)return null;
        Carta carta =top.carta;
        top=top.siguiente;
        return carta;
    }
    public boolean Vacio(){
        return top==null;
    }
}
