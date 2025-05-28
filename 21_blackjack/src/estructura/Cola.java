
package estructura;

import modelo.Jugador;


public class Cola {

    // Nodo interno para la cola
    private class Nodo {
        Jugador jugador;
        Nodo siguiente;
        public Nodo(Jugador jugador) {
            this.jugador =jugador;
            this.siguiente = null;
        }
    }
    private Nodo adelante, atras;

    public Cola() {
        adelante = atras = null;
    }

    // Enqueue: agrega jugador al final de la cola
    public void AgregarAlFinal(Jugador jugador) {
        Nodo nodoN = new Nodo(jugador);
        if (atras == null) {
            adelante = atras = nodoN;
        } else {
            atras.siguiente = nodoN;
            atras = nodoN;
        }
    }

    // Dequeue: remueve y retorna el jugador al frente de la cola
    public Jugador Remover() {
        if (adelante == null) return null;
        Jugador jugador = adelante.jugador;
        adelante=adelante.siguiente;
        if (adelante == null) {
            atras = null;
        }
        return jugador;
    }

    public boolean Vacio() {
        return adelante == null;
    }
}
