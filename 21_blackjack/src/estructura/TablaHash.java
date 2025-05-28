
package estructura;

import modelo.Jugador;


public class TablaHash {
    private class NodoHash {
        String llave;
        Jugador valor;
        NodoHash siguiente;

        public NodoHash(String llave, Jugador valor) {
            this.llave = llave;
            this.valor = valor;
            this.siguiente = null;
        }
       
    }
    private NodoHash[] buckets;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        buckets = new NodoHash[capacidad];
    }
    
    private int getIndiceBucket(String llave) {
        int hashCode = llave.hashCode();
        return Math.abs(hashCode) % capacidad;
    }
    
    public void poner(String llave, Jugador valor) {
        int indice = getIndiceBucket(llave);
        NodoHash cabeza = buckets[indice];
        while (cabeza != null) {
            if (cabeza.llave.equals(llave)) {
                cabeza.valor = valor;
                return;
            }
            cabeza = cabeza.siguiente;
        }
        NodoHash nodoN = new NodoHash(llave, valor);
        nodoN.siguiente = buckets[indice];
        buckets[indice] = nodoN;
    }
    // Obtener jugador por nombre (clave)
    public Jugador Obtener(String llave) {
        int indice = getIndiceBucket(llave);
        NodoHash cabeza = buckets[indice];
        while (cabeza != null) {
            if (cabeza.llave.equals(llave)) {
                return cabeza.valor;
            }
            cabeza = cabeza.siguiente;
        }
        return null;
    }
}
