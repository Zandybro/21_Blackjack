
package modelo;

// Árbol de decisión binario para la lógica del dealer (evaluación de puntaje)
public class ArbolDecision {
    private NodoDecision root;

    public ArbolDecision() {
       
        root = new NodoDecision("¿Puntaje < 17?");
        NodoDecision NodoPedir = new NodoDecision("Pedir carta");
        NodoDecision NodoPlantarse = new NodoDecision("Plantarse");
        root.setRamaSi(NodoPedir);
        root.setRamaNo(NodoPlantarse);
    }

    
    public String evaluar(int puntaje) {
        if (puntaje < 17) {
            return root.getRamaSi().getPregunta();
        } else {
            return root.getRamaNo().getPregunta();
        }
    }
}

