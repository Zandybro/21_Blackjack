
package modelo;

public class NodoDecision {
    String pregunta;        
    NodoDecision RamaSi;   
    NodoDecision RamaNo;    

    public NodoDecision(String pregunta) {
        this.pregunta = pregunta;
        this.RamaSi = null;
        this.RamaNo = null;
    }
    public void setRamaSi(NodoDecision si) {
    this.RamaSi = si; 
    }
    public void setRamaNo(NodoDecision no) { 
        this.RamaNo = no; 
    }
    public String getPregunta() { 
        return pregunta; 
    }
    public NodoDecision getRamaSi() { 
        return RamaSi; 
    }
    public NodoDecision getRamaNo() { 
        return RamaNo; 
    }
}
