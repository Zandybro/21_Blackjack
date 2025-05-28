
package modelo;

import estructura.ListaEnlazada;

public class Jugador {
    private String nombre;
    private ListaEnlazada mano; 
    private int puntaje;
    private String estado;    

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ListaEnlazada();
        this.puntaje = 0;
        this.estado = "Jugando";
    }

    public String getNombre() {
        return nombre;
    }

    public ListaEnlazada getMano() {
        return mano;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getEstado() {
        return estado;
    }

    
    

    // Agrega carta a la mano y actualiza puntaje
    public void AgregarCarta(Carta carta) {
        mano.add(carta);
       ActualizarPuntaje();
    }
    // Actualiza puntaje considerando el valor de As (11 o 1) y establece estado
    private void ActualizarPuntaje() {
        puntaje = mano.sumValores();
        if (puntaje > 21) {
            estado = "BUSTED";
        } else if (puntaje == 21) {
            estado = "Plantado";
        }
    }
    // El jugador se planta manualmente
    public void Plantar() {
        estado = "Plantado";
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", mano=" + mano + ", puntaje=" + puntaje + ", estado=" + estado + '}';
    }
    
    
}
