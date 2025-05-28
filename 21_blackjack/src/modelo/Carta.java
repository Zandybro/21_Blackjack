
package modelo;

public class Carta {
    private String tipo;
    private String rango;
    private int valor;

    public Carta(String tipo, String rango, int valor) {
        this.tipo = tipo;
        this.rango = rango;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRango() {
        return rango;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return rango + " de "+ tipo;
    }
    
    

}
