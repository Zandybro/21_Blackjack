
package juego;
import estructura.Cola;
import estructura.ListaEnlazada;
import estructura.Pila;
import estructura.TablaHash;
import java.util.Random;
import java.util.Scanner;
import modelo.ArbolDecision;
import modelo.Carta;
import modelo.Jugador;

// Clase principal del juego Blackjack
public class BlackJackJuego {
    public static void main(String[] args) {
        Scanner digite = new Scanner(System.in);

        // Crear baraja con lista enlazada
        ListaEnlazada deck = new ListaEnlazada();
        String[] TipoCarta = {"Corazones", "Diamantes", "Picas", "Treboles"};
        String[] NumeroCarta= {"2","3","4","5","6","7","8","9","10","J","Q","K","As"};
        int[] valores =   {2,  3,  4,  5,  6,  7,  8,  9, 10, 10, 10, 10, 11};
        Carta[] cartas = new Carta[52];
        int idx = 0;
        
        for (String tipo : TipoCarta) {
            for (int i = 0; i < NumeroCarta.length; i++) {
                cartas[idx++] = new Carta(tipo, NumeroCarta[i], valores[i]);
            }
        }
        Random aleatorio = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = aleatorio.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        // Agregar cartas mezcladas a la lista
        for (Carta carta : cartas) {
            deck.add(carta);
        }

        // Crear jugadores
        System.out.print("Ingrese nombre del jugador: ");
        String NombreJugador = digite.nextLine();
        Jugador jugador = new Jugador(NombreJugador);
        Jugador dealer = new Jugador("Dealer");

        // Tabla hash para jugadores
        TablaHash tabla = new TablaHash(10);
        tabla.poner(jugador.getNombre(), jugador);
        tabla.poner(dealer.getNombre(), dealer);

        // Estructuras auxiliares
        Pila historial = new Pila(); // historial de cartas jugadas
        Cola turnos = new Cola();
        turnos.AgregarAlFinal(jugador);
        turnos.AgregarAlFinal(dealer);
        ArbolDecision LogicaDealer = new ArbolDecision();

        // Repartir dos cartas iniciales a jugador y dealer
        jugador.AgregarCarta(deck.removerP());
        dealer.AgregarCarta(deck.removerP());
        jugador.AgregarCarta(deck.removerP());
        dealer.AgregarCarta(deck.removerP());

        // Mostrar manos iniciales (ocultar primera carta del dealer)
        System.out.println("\nCartas iniciales:");
        System.out.println(jugador.getNombre()+ ": " + jugador.getMano()
                           + "(" + jugador.getPuntaje()+ " puntos)");
        // Obtener segunda carta del dealer para mostrarla
        String ManoDealer = dealer.getMano().toString();
        String segundaCarta;
        if (ManoDealer.contains(",")) {
            segundaCarta = ManoDealer.substring(ManoDealer.indexOf(",") + 2);
        } else {
            segundaCarta = ManoDealer;
        }
        System.out.println(dealer.getNombre()+ ": [Carta Oculta], " 
                           + segundaCarta + " (puntaje oculto)");

        // Jugar turno por turno usando la cola
        while (!turnos.Vacio()) {
            Jugador current = turnos.Remover();
            if (current.getEstado().equals("Jugando")) {
                if (!current.getNombre().equals("Dealer")) {
                    // Turno del jugador
                    System.out.print("\n¿Desea pedir carta? (s/n): ");
                    String respuesta = digite.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        Carta carta = deck.removerP();
                        System.out.println("Carta pedida: " + carta);
                        jugador.AgregarCarta(carta);
                        historial.push(carta);
                        System.out.println("Mano " + jugador.getNombre()+ ": " 
                                           + jugador.getNombre()
                                           + "(" + jugador.getPuntaje()+ " puntos)");
                        if (jugador.getEstado().equals("BUSTED")) {
                            System.out.println("¡Ha excedido 21 puntos (BUSTED)!");
                        } else {
                            // Volver a encolar si sigue jugando
                            turnos.AgregarAlFinal(jugador);
                        }
                    } else {
                        jugador.Plantar();
                        System.out.println(jugador.getNombre()+ " se planta con " 
                                           + jugador.getPuntaje()+ " puntos.");
                        // Reenfilar dealer si aún juega
                        if (dealer.getEstado().equals("Jugando")) {
                            turnos.AgregarAlFinal(dealer);
                        }
                    }
                } else {
                    // Turno del dealer
                    int puntajeDealer = dealer.getPuntaje();
                    String decision = LogicaDealer.evaluar(puntajeDealer);
                    System.out.println("\nTurno Dealer: puntaje actual " + puntajeDealer);
                    if (decision.equals("Pedir carta")) {
                        Carta carta = deck.removerP();
                        System.out.println("Dealer pide carta: " + carta);
                        dealer.AgregarCarta(carta);
                        historial.push(carta);
                        System.out.println("Mano Dealer: " + dealer.getMano()
                                           + "(" + dealer.getPuntaje()+ " puntos)");
                        if (dealer.getEstado().equals("BUSTED")) {
                            System.out.println("¡Dealer ha excedido 21 puntos (BUSTED)!");
                        } else {
                            turnos.AgregarAlFinal(dealer);
                        }
                    } else {
                        dealer.Plantar();
                        System.out.println("Dealer se planta con " 
                                           + dealer.getPuntaje()+ " puntos.");
                    }
                }
            }
        }

        // Mostrar resultado final
        System.out.println("\n--- Resultados finales ---");
        System.out.println(jugador);
        System.out.println(dealer);
        int scorePlayer = jugador.getPuntaje();
        int scoreDealer = dealer.getPuntaje();
        // Determinar ganador
        if (jugador.getEstado().equals("BUSTED")) {
            System.out.println("El jugador ha perdido.");
        } else if (dealer.getEstado().equals("BUSTED")) {
            System.out.println("Dealer pierde, ¡jugador gana!");
        } else if (scorePlayer > scoreDealer) {
            System.out.println("¡Jugador gana con " + scorePlayer + " puntos!");
        } else if (scoreDealer > scorePlayer) {
            System.out.println("Dealer gana con " + scoreDealer + " puntos.");
        } else {
            System.out.println("Empate.");
        }
    }
}
