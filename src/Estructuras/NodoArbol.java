package Estructuras;

/**
 *
 * @author Squery
 */
public class NodoArbol {

    private String valor;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    private boolean anulable;
    private int numero;
    private String primeros;
    private String ultimos;
    private String siguientes;

    public NodoArbol(String valor, NodoArbol izquierda, NodoArbol derecha) {
        this.valor = valor;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPrimeros() {
        return primeros;
    }

    public void setPrimeros(String primeros) {
        this.primeros = primeros;
    }

    public String getUltimos() {
        return ultimos;
    }

    public void setUltimos(String ultimos) {
        this.ultimos = ultimos;
    }

    public String getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(String siguientes) {
        this.siguientes = siguientes;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

}
